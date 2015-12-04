package com.technobrain.trips.core.toplinkconfiguration;

import com.technobrain.trips.common.helpers.AnnotationHelper;
import com.technobrain.trips.common.logging.model.LogActivityLog;
import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.event.model.EvtEvent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.mappings.ForeignReferenceMapping;
import org.eclipse.persistence.sessions.Session;

public class TripsSessionCustomizer implements SessionCustomizer {
    
    public TripsSessionCustomizer() {
    }

    public void customize(Session session) throws InstantiationException, IllegalAccessException {
         //get all descriptors from mapping
         Map map = session.getDescriptors();
         Set keySet = map.keySet();
         Iterator it = keySet.iterator();
         // iterate over the descriptors and obtain every POJO.
         while (it.hasNext()) {
             Object key = it.next();
             ClassDescriptor cd = (ClassDescriptor)map.get(key);
             
             disableCachingForClass(cd);
             
             // Map logging fields
             if (isAbstractClass(cd)) {
                 continue;
             }
             
             // Map logging fields
             boolean hasBaseObject = cd.getJavaClass().newInstance() instanceof BaseModelObject;
             boolean isBaseClass = cd.getJavaClass().getSimpleName().equals(BaseModelObject.class.getSimpleName()) 
                 || cd.getJavaClass().getSimpleName().equals(BaseRefModelObject.class.getSimpleName()) 
                 || cd.getJavaClass().getSimpleName().equals(BaseCompositeModelObject.class.getSimpleName()) 
                 || cd.getJavaClass().getSimpleName().equals(BaseNormalModelObject.class.getSimpleName()) ;
             if (hasBaseObject && !isBaseClass){
                 /*
                  * Check if the package name is in gui package, this will allow gui entities to 
                  * be cached others will be refereshed each time
                  */
                 if(!shouldAlwaysRefreshCache(cd.getJavaClass())){
                    //do nothing
                 }else{
                     cd.setShouldAlwaysRefreshCache(true);
                 }
                 
                 generateDefaultMappings(cd);
                 
                 //this will apply for event models only.
                 generateEventDefaultMappings(cd);
                                  
                 
                 //add listener to descriptor
                 cd.getDescriptorEventManager().addListener(new TripsDescriptorEventListener());

                 // now set the private owned relationship
                 generatePrivateOwnedRelationship(cd);
             }
         }
    }
    
    /**
     * Disable cache usage for the pojo class given.
     * @param cd
     */
    private void disableCache(ClassDescriptor cd) {
        cd.useNoIdentityMap();
    }
    
    /**
     * Generates the private owned relationship if there is remove cascade.
     * @param cd
     */
    private void generatePrivateOwnedRelationship(ClassDescriptor cd) {
        generatePrivateOwnedRelationship(cd, OneToMany.class);
        generatePrivateOwnedRelationship(cd, ManyToOne.class);
        generatePrivateOwnedRelationship(cd, ManyToMany.class);
        generatePrivateOwnedRelationship(cd, OneToOne.class);
    }
    
    private void generatePrivateOwnedRelationship(ClassDescriptor cd, Class annotationClass) {
        List<Field> annotationFields = AnnotationHelper.getFieldsByAnnotation(cd.getJavaClass(), annotationClass);
        if(annotationFields != null) {
            for (int i = 0; i < annotationFields.size(); i++)  {
                Field field = annotationFields.get(i);
                String fieldName = field.getName();
                boolean privateOwned = false;
                
                // find the annotation for that mapping and check if there is a cascadetype.all or cascadetype.remove
                // attribute. If there is, this means that it is a private-owned relationship.
                Annotation annotation = field.getAnnotation(annotationClass);
                CascadeType[] cascadeTypes = null;
                if(annotation instanceof OneToMany)
                    cascadeTypes = ((OneToMany)annotation).cascade();
                else if(annotation instanceof ManyToOne)
                    cascadeTypes = ((ManyToOne)annotation).cascade();  
                else if(annotation instanceof OneToOne)
                    cascadeTypes = ((OneToOne)annotation).cascade(); 
//                else if(annotation instanceof ManyToMany)
//                    cascadeTypes = ((ManyToMany)annotation).cascade();                       
                if(cascadeTypes != null) {
                    for (int j = 0; j < cascadeTypes.length; j++)  {
                        CascadeType casType = cascadeTypes[j];
                        if(casType.equals(CascadeType.ALL) || casType.equals(CascadeType.REMOVE)) {
                            privateOwned = true;
                            break;
                        }
                    }
                }
                if(privateOwned) {
                    ForeignReferenceMapping mapping = (ForeignReferenceMapping)cd.getMappingForAttributeName(fieldName);
                    mapping.setIsPrivateOwned(true);
                }
            }
        }        
    }
    
    /**
     * Generates the default logging mappings dynamically.
     * @param cd
     */
    private void generateDefaultMappings(ClassDescriptor cd) throws InstantiationException, IllegalAccessException {
//        Object pojo = cd.getJavaClass().newInstance();

         
         // if it is a many to many model object, then we will not put the rest. 
//         if(pojo instanceof BaseCompositeModelObject)
//             return;                
        // If there is a discriminatorcolumn annotation but not an inheritance annotation, 
        // it means that this object is extending another model object. 
        // We will not put the mapping at this situation.
//        if(AnnotationHelper.getAnnotation(cd.getJavaClass(), DiscriminatorColumn.class) == null ||
//            AnnotationHelper.getAnnotation(cd.getJavaClass(), Inheritance.class) != null) {
        if(cd.getJavaClass().getSuperclass().getSimpleName().equals(BaseNormalModelObject.class.getSimpleName())
            || cd.getJavaClass().getSuperclass().getSimpleName().equals(BaseRefModelObject.class.getSimpleName())
            || cd.getJavaClass().getSuperclass().getSimpleName().equals(BaseCompositeModelObject.class.getSimpleName())) {            
            
            String tableName = getDatabaseName(cd.getJavaClass());         
            if(tableName != null) {   
                
                 // generate default mappings.
//                 if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.CREATED_BY) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.CREATED_BY, tableName + "." + Constants.EntityDefaultValues.DB_CREATED_BY);
////                if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.CREATED_DATE) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.CREATED_DATE, tableName + "." + Constants.EntityDefaultValues.DB_CREATED_DATE);
////                if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.UPDATED_BY) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.UPDATED_BY, tableName + "." + Constants.EntityDefaultValues.DB_UPDATED_BY);
////                if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.UPDATED_DATE) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.UPDATED_DATE, tableName + "." + Constants.EntityDefaultValues.DB_UPDATED_DATE);
////                if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.STATUS) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.STATUS, tableName + "." + Constants.EntityDefaultValues.DB_STATUS);
////                if(cd.getMappingForAttributeName(Constants.EntityDefaultValues.VERSION) == null)
//                 cd.addDirectMapping(Constants.EntityDefaultValues.VERSION, tableName + "." + Constants.EntityDefaultValues.DB_VERSION);    
//                cd.addDirectMapping(Constants.EntityDefaultValues.ACCESS_LEVEL, tableName + "." + Constants.EntityDefaultValues.DB_ACCESS_LEVEL);    
//                
//                if(cd.getJavaClass().getSuperclass().getSimpleName().equals(BaseRefModelObject.class.getSimpleName())){
//                    cd.addDirectMapping(Constants.EntityDefaultValues.ORDER_SEQ, tableName + "." + Constants.EntityDefaultValues.DB_ORDER_SEQ);    
//                    
//                }
            }
        }      
    }
    
    
    private void generateEventDefaultMappings(ClassDescriptor cd) throws InstantiationException, IllegalAccessException {
       
    //if it extends from evtEvent model, then we need to add EvtEvent mappings.
        if(cd.getJavaClass().getSuperclass().getSimpleName().equals(EvtEvent.class.getSimpleName())) {            
            
            String tableName = getDatabaseName(cd.getJavaClass());         
            if(tableName != null) {   
                
                 // generate default mappings.
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.EFFECTIVE_DATE, tableName + "." + Constants.EntityEventDefaultValues.DB_EFFECTIVE_DATE);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.EVENT_DATE, tableName + "." + Constants.EntityEventDefaultValues.DB_EVENT_DATE);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.EXPIRY_DATE, tableName + "." + Constants.EntityEventDefaultValues.DB_EXPIRY_DATE);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.INITIATED_BY, tableName + "." + Constants.EntityEventDefaultValues.DB_INITIATED_BY);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.PARENT_EVENT, tableName + "." + Constants.EntityEventDefaultValues.DB_PARENT_EVENT);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.REF_EVT_TYPE_CAT, tableName + "." + Constants.EntityEventDefaultValues.DB_REF_EVT_TYPE_CAT);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.RELATED_MODULE_ID, tableName + "." + Constants.EntityEventDefaultValues.DB_RELATED_MODULE_ID);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.WORKFLOW_TYPE, tableName + "." + Constants.EntityEventDefaultValues.DB_WORKFLOW_TYPE);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.REASON, tableName + "." + Constants.EntityEventDefaultValues.DB_REASON);
//                 cd.addDirectMapping(Constants.EntityEventDefaultValues.NOTES, tableName + "." + Constants.EntityEventDefaultValues.DB_NOTES);
            }
        }      
    }
        
    private String getDatabaseName(Class pojoClass) {
        Table table = (Table)AnnotationHelper.getAnnotation(pojoClass, Table.class);
        if(table != null)
            return table.name();
        return null;
    }
    
    /**
     * Checks if the pojo should always be refereshed
     * @param pojoClazz
     * @return
     */
    private boolean shouldAlwaysRefreshCache(Class pojoClazz) {
//       if(0== pojoClazz.getPackage().getName().indexOf("com.crownagents.trips.gui")){
//           return false;
//       }
//       
//        if(0== pojoClazz.getPackage().getName().indexOf("com.crownagents.trips.reference")){
//            return false;
//        }
       
       return true;
    }
    
    private void disableCachingForClass(ClassDescriptor classDescriptor) {
        String [] classesToDisable = {LogActivityLog.class.getSimpleName()};       
        for (int i = 0; i < classesToDisable.length; i++) {
            if(classDescriptor.getJavaClass().getSimpleName().equals(classesToDisable[i])) {
                disableCache(classDescriptor);
            }            
        }
    }
    
    private boolean isAbstractClass(ClassDescriptor classDescriptor) {
        return Modifier.isAbstract(classDescriptor.getJavaClass().getModifiers());
    }
}
