package com.technobrain.trips.common.messagehelpers;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.common.util.AuditUtil;
import com.technobrain.trips.core.message.AdditionalField;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.dto.DataTransferObject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;


//import com.crownagents.trips.returns.messagehelper.DummyTaxReturnMessageHelper;
//import com.crownagents.trips.returns.model.DummyTaxReturn;


/**
 * @author hhill
 */
public abstract class MessageHelper implements DataTransferObject {
    public static final Logger log = Logger.getLogger(MessageHelper.class);
    private static final String[] otherTypes = new String[] { "[Lcom.technobrain.trips" };
    protected EntityManager em;
    protected FacadeLocal facade;
    public static final Map<Class, MessageHelperMapper> messageHelpers;
    
    /**
     * Used in order to understand which message helper is used for a specific input type to be mapped to a pojo. 
     */
    static{
        messageHelpers = new HashMap<Class, MessageHelperMapper>();
//        removed to test 
        //messageHelpers.put(TaxReturnInputType.class, new MessageHelperMapper(DummyTaxReturnMessageHelper.class, DummyTaxReturn.class));
    }
    
    private static <T> T init(T obj, Class<T> clazz, String regExp, Integer depth) {
        if (obj == null) {

            try {
                obj = (T)clazz.newInstance();
            } catch (IllegalAccessException e) {
                log.error(e.getLocalizedMessage(), e);
            } catch (InstantiationException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }

        try {
            if (obj.getClass().equals(clazz)) {
                initializeFields(obj, regExp, depth);
            } else {
                throw new IllegalAccessError("Class and object not the same");
            }
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
            ;
        }

        return obj;
    }
    
    /**
     * Initializes the child message helper and does the necessary operations while initalizing.
     * @param clazz
     * @return
     */
    protected <T extends MessageHelper> T initMessageHelper(Class<T> clazz) {
        MessageHelper messageHelper = null;
        try {
            messageHelper = (MessageHelper)clazz.newInstance();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        // we must set entity manager, because it can be used while creating the association via this message helper.
        messageHelper.setEm(em);
        return (T)messageHelper;
    }

    /**
     * default regExp = com.crownagents.trips
     * @param obj - object to initialize
     * @param clazz - class of object if object is null
     * @return
     */
    public static <T> T init(T obj, Class clazz, Integer depth) {
        return (T)init(obj, clazz, Constants.TRIPS_PACKAGE_PREFIX, depth);
    }

    /**
     * default regExp = com.crownagents.trips
     * @param obj - object to initialize
     * @param clazz - class of object if object is null
     * @return
     */
    public static <T> T init(T obj, Class clazz) {
        return (T)init(obj, clazz, Constants.TRIPS_PACKAGE_PREFIX, null);
    }

    public static <T> T init(Class<T> clazz) {
        return init(null, clazz, Constants.TRIPS_PACKAGE_PREFIX, null);
    }

    public static <T> T init(Class<T> clazz, Integer depth) {
        return init(null, clazz, Constants.TRIPS_PACKAGE_PREFIX, depth);
    }

    /**
     * Initializes fields for the input type, so that we will have empty objects not null objects. With this way,
     * we will not get null pointer exceptions in the application.
     * @param obj
     * @param regExp
     * @param depth prevents the method to enter to infinite recursion. If it is null, there will be no depth in the recursion.
     * @throws InvocationTargetException
     */
    private static void initializeFields(Object obj, String regExp, Integer depth) throws InvocationTargetException {
        Class fieldClass;
        Object fieldObject;
        try {
            List<Field> fieldsList = ReflectionHelper.getDeclaredFieldsWithInheritance(obj.getClass());
            if(fieldsList == null)
                return;
            for (int i = 0; i < fieldsList.size(); i++) {
                Field field = fieldsList.get(i);
                fieldClass = field.getType();
                if (shouldAccessClass(fieldClass, regExp)) {
                    fieldObject = field.getType().newInstance();
                    Object getObjValue = ReflectionHelper.invokeGetter(obj, field.getName());
                    if (getObjValue == null) {
                        //log.trace("Object Value is " + getObjValue + " initializing field " + field.getName() + " completed");
                        ReflectionHelper.invokeSetter(obj, field.getName(), fieldObject);
                        // The if statement prevents the infinite recursion.
                        if(depth != null && field.getType().getName().equals(obj.getClass().getName())) {
                            if(depth != 0) {
                                depth--;
                                initializeFields(fieldObject, regExp, depth);
                            }

                        }
                        else {
                            initializeFields(fieldObject, regExp, depth);
                        }


                    }

                } else {
                    final String fieldType = field.getType().getName();

                    int arrayPackageIndex = -1;
                    for (int o = 0; o < otherTypes.length; o++) {
                        String aType = otherTypes[o];
                        arrayPackageIndex = fieldType.indexOf(aType);
                        if (arrayPackageIndex != -1) {
                            Class clazz = field.getType();
                            Object getObjValue = ReflectionHelper.invokeGetter(obj, field.getName());
                            if (getObjValue == null) {
                                //log.trace("Object Value is " + getObjValue + " initializing array " + field.getName() + " completed");
                                ReflectionHelper.invokeSetter(obj, field.getName(),
                                                              Array.newInstance(clazz.getComponentType(), 0));
                            }

                        }
                    }
                }
            }

            return;

        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private static boolean shouldAccessClass(Class fieldClass, String regExp) {
        Package packageVar = fieldClass.getPackage();
        if (null == packageVar)
            return false;
        String packageName = packageVar.getName();
        int index = packageName.indexOf(regExp);

        if (index != -1) {
            return true;
        } else {
            return false;
        }

    }

    public abstract BaseModelObject setData(BaseModelObject pojo, InputType type);

//    public void setCommonFieldsDataToPojo(BaseModelObject pojo, InputType message){
//        if()
//        AuditUtil.userAudit();
//    }
    public abstract InputType getData(BaseModelObject pojo);

    public  static void setCommonFieldsDataToInputType(BaseModelObject pojo, InputType message){
        AuditUtil.getInstance().userAudit(message, pojo);
    }

    public boolean shouldSetAssociationData(InputType type, Class childInputTypeClass) {
        if(type.isLazyFetch() == null
            || (type.getAssociatedData() != null && Arrays.asList(type.getAssociatedData()).contains(childInputTypeClass.getSimpleName())))
            return true;
        return false;
    }

    protected void createAssociation(BaseModelObject pojo, Object associatedObject,
                                      IAssociationHelper associationHelper){

      Collection<BaseModelObject> associatedPojoCollection = new ArrayList<BaseModelObject>();

      if (associatedObject instanceof InputType[]) {
        InputType[] inputTypes = (InputType[]) associatedObject;

        for ( InputType associatedType : inputTypes) {
            BaseModelObject associatedPojo = null;
            try {
              associatedPojo = (BaseModelObject)associationHelper.getAssociatedPojoClass().newInstance();
            } catch (Exception e) {
                log.error(e.getLocalizedMessage(), e);
                return;
            }

          associatedPojoCollection.add(associatedPojo);
          associationHelper.setDataForAssociatedPojo(associatedType,
              associatedPojo);
            setCommonFieldsDataToInputType(associatedPojo, associatedType);      
//            setCommonFieldsFromParentToChild(pojo, parent);
        }

      } else if (associatedObject instanceof Collection) {

        associatedPojoCollection = (Collection)associatedObject;
      }

      associationHelper.setAssociatedCollection(pojo, associatedPojoCollection);
    }
    
    protected void setAssociationData(BaseModelObject parent, List<InputType> childrenMessageTypes,
                                      Collection childrenPojo,
                                      ComplexAssociationHelper associationHelper){

        setAssociationData(parent, childrenMessageTypes,
                                              childrenPojo,
                                             associationHelper,null);
    }
    
    protected void setAssociationData(BaseModelObject parent, List<InputType> childrenMessageTypes,
                                      Collection childrenPojo,
                                      ComplexAssociationHelper associationHelper,MessageHelper[] messageHelpers) {
        MessageHelper messageHelper = null;
        messageHelper = getMessageHelper(associationHelper,messageHelpers);
        messageHelper = null == messageHelper ? initMessageHelper(associationHelper.getMessageHelperClass()) : messageHelper;
        if (childrenMessageTypes == null) {
            if (childrenPojo != null) {
                // Delete everything.
//                log.trace("before finding all deletion set: --/1--"+Calendar.getInstance().getTimeInMillis());
                List<BaseModelObject> deletionList = new ArrayList<>();
                for (int i = 0; i < ((List)childrenPojo).size(); i++)  {
                    BaseModelObject child = (BaseModelObject)((List)childrenPojo).get(i);
                        deletionList.add((BaseModelObject)child);
                }
//                log.trace("after finding deletion set: --/2--"+Calendar.getInstance().getTimeInMillis());
                // delete.
                for (int i = 0; i < deletionList.size(); i++) {
                    BaseModelObject child = deletionList.get(i);
                    associationHelper.remove(parent, child);
                }
//                log.trace("delete set: --/3--"+Calendar.getInstance().getTimeInMillis());
            }
        } else {
            if (childrenPojo == null) {
                childrenPojo = new ArrayList<>();
            }
            
            // find the deletion set.
//             log.trace("before finding deletion set: --/4--"+Calendar.getInstance().getTimeInMillis());
            List<BaseModelObject> deletionList = new ArrayList<>();
            for (int i = 0; i < ((List)childrenPojo).size(); i++)  {
                BaseModelObject child = (BaseModelObject)((List)childrenPojo).get(i);
                if (shouldBeDeleted((BaseNormalModelObject)child, childrenMessageTypes, associationHelper))
                    deletionList.add((BaseModelObject)child);
            }
//            log.trace("after finding deletion set: --/5--"+Calendar.getInstance().getTimeInMillis());
            // delete.
            for (int i = 0; i < deletionList.size(); i++) {
                BaseModelObject child = deletionList.get(i);
                
                associationHelper.remove(parent, child);
            }
//            log.trace("delete set: --/6--"+Calendar.getInstance().getTimeInMillis());
            List<BaseModelObject> insertionList = new ArrayList<>();
            // find the insertion set.
//             log.trace("before finding insertion set: --/7--"+Calendar.getInstance().getTimeInMillis());
            for (int i = 0; i < childrenMessageTypes.size(); i++) {
                InputType childMessageType = childrenMessageTypes.get(i);
//                log.trace("before checking insertion: --/8--"+Calendar.getInstance().getTimeInMillis());
                if (!checkIfInsertableIfNotUpdate(childMessageType, childrenPojo, associationHelper, messageHelper, (BaseNormalModelObject)parent)) {
                    continue;
                }
//                log.trace("after checking insertion: --/9--"+Calendar.getInstance().getTimeInMillis());
                insertionList.add(createChildElement(childMessageType, associationHelper, messageHelper, parent));
//                log.trace("create child element: --/10--"+Calendar.getInstance().getTimeInMillis());
            }
        }
        
    }
    
    private boolean shouldBeDeleted(BaseNormalModelObject child, List<InputType> childrenMessageTypes, ComplexAssociationHelper associationHelper) {
        if (childrenMessageTypes == null)
            return false;
        for (int i = 0; i < childrenMessageTypes.size(); i++) {
            InputType childMessageType = childrenMessageTypes.get(i);
            Boolean same = associationHelper.compare(childMessageType, child);
            boolean childDoesNotContainId = (child.getId() == null);//AnnotationHelper.checkIfAnnotationValueIsNull(child, Id.class);
            if (same == null) {
                if(childDoesNotContainId) {
                    return false;
                }
                else {
                    continue;
                }
            }
            else if(same){
                return false;
            }
        }
        return true;
    }

    protected void setAssociationData(BaseModelObject parent, InputType[] childrenMessageTypes,
                                      Collection childrenPojo,
                                      ComplexAssociationHelper associationHelper){

        setAssociationData(parent, childrenMessageTypes,
                                              childrenPojo,
                                             associationHelper,null);
    }

    /**
     *
     * @param parent
     * @param childrenMessageTypes
     * @param childrenPojo
     * @param associationHelper
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    protected void setAssociationData(BaseModelObject parent, InputType[] childrenMessageTypes,
                                      Collection childrenPojo,
                                      ComplexAssociationHelper associationHelper,MessageHelper[] messageHelpers) {
        MessageHelper messageHelper = null;
        messageHelper = getMessageHelper(associationHelper,messageHelpers);
        messageHelper = null == messageHelper ? initMessageHelper(associationHelper.getMessageHelperClass()) : messageHelper;
        if (childrenMessageTypes == null) {
            if (childrenPojo != null) {
                // Delete everything.
//                log.trace("before finding all deletion set: --/1--"+Calendar.getInstance().getTimeInMillis());
                List<BaseModelObject> deletionList = new ArrayList<BaseModelObject>();
                for (int i = 0; i < ((List)childrenPojo).size(); i++)  {
                    BaseModelObject child = (BaseModelObject)((List)childrenPojo).get(i);
                        deletionList.add((BaseModelObject)child);
                }
//                log.trace("after finding deletion set: --/2--"+Calendar.getInstance().getTimeInMillis());
                // delete.
                for (int i = 0; i < deletionList.size(); i++) {
                    BaseModelObject child = deletionList.get(i);
                    associationHelper.remove(parent, child);
                }
//                log.trace("delete set: --/3--"+Calendar.getInstance().getTimeInMillis());
            }
        } else {
            if (childrenPojo == null) {
                childrenPojo = new ArrayList<BaseModelObject>();
            }
            
            // find the deletion set.
//             log.trace("before finding deletion set: --/4--"+Calendar.getInstance().getTimeInMillis());
            List<BaseModelObject> deletionList = new ArrayList<BaseModelObject>();
            for (int i = 0; i < ((List)childrenPojo).size(); i++)  {
                BaseModelObject child = (BaseModelObject)((List)childrenPojo).get(i);
                if (shouldBeDeleted((BaseNormalModelObject)child, childrenMessageTypes, associationHelper))
                    deletionList.add((BaseModelObject)child);
            }
//            log.trace("after finding deletion set: --/5--"+Calendar.getInstance().getTimeInMillis());
            // delete.
            for (int i = 0; i < deletionList.size(); i++) {
                BaseModelObject child = deletionList.get(i);
                
                associationHelper.remove(parent, child);
            }
//            log.trace("delete set: --/6--"+Calendar.getInstance().getTimeInMillis());
            List<BaseModelObject> insertionList = new ArrayList<BaseModelObject>();
            // find the insertion set.
//             log.trace("before finding insertion set: --/7--"+Calendar.getInstance().getTimeInMillis());
            for (int i = 0; i < childrenMessageTypes.length; i++) {
                InputType childMessageType = childrenMessageTypes[i];
//                log.trace("before checking insertion: --/8--"+Calendar.getInstance().getTimeInMillis());
                if (!checkIfInsertableIfNotUpdate(childMessageType, childrenPojo, associationHelper, messageHelper, (BaseNormalModelObject)parent)) {
                    continue;
                }
//                log.trace("after checking insertion: --/9--"+Calendar.getInstance().getTimeInMillis());
                insertionList.add(createChildElement(childMessageType, associationHelper, messageHelper, parent));
//                log.trace("create child element: --/10--"+Calendar.getInstance().getTimeInMillis());
            }
        }
        
        
        
        
    }

    private boolean shouldBeDeleted(BaseNormalModelObject child, InputType[] childrenMessageTypes, ComplexAssociationHelper associationHelper) {
        if (childrenMessageTypes == null)
            return false;
        for (int i = 0; i < childrenMessageTypes.length; i++) {
            InputType childMessageType = childrenMessageTypes[i];
            Boolean same = associationHelper.compare(childMessageType, child);
            boolean childDoesNotContainId = (child.getId().equals(null));//AnnotationHelper.checkIfAnnotationValueIsNull(child, Id.class);
            if (same == null) {
                if(childDoesNotContainId) {
                    return false;
                }
                else {
                    continue;
                }
            }
            else if(same){
                return false;
            }
        }
        return true;
    }

    private BaseModelObject createChildElement(
//        InputType childMessageType, ComplexAssociationHelper associationHelper, MessageHelper messageHelper) {
        InputType childMessageType, ComplexAssociationHelper associationHelper,
        MessageHelper messageHelper, BaseModelObject parent) {

        BaseModelObject newChildPojo = null;
        Class childPojoClass = 
            (associationHelper.getChildPojoClass(childMessageType) != null) ? associationHelper.getChildPojoClass(childMessageType) : 
            associationHelper.getChildPojoClass();
        if(childMessageType.getId() != null && childMessageType.getId() != 0) {
//            try {
                newChildPojo = (BaseModelObject)em.find(childPojoClass, childMessageType.getId());
//            } catch (Exception e) {}
        }
        if(newChildPojo == null) {
            try {
                newChildPojo = (BaseModelObject)childPojoClass.newInstance();
            } catch (IllegalAccessException e) {
                log.error(e.getLocalizedMessage(), e);
                return null;
            } catch (InstantiationException e) {
                 log.error(e.getLocalizedMessage(), e);
                 return null;
            }
        }
        
        associationHelper.setData(childMessageType, newChildPojo, messageHelper);
        setCommonFieldsFromParentToChild(newChildPojo, parent);
//        setCommonFieldsDataToInputType(newChildPojo, childMessageType);        
        associationHelper.add(parent, newChildPojo);
        
        return newChildPojo;
    }

    private boolean checkIfInsertableIfNotUpdate(
        InputType childMessageType, Collection<BaseModelObject> children,
        ComplexAssociationHelper associationHelper, MessageHelper messageHelper, BaseNormalModelObject parent) {

        if (children == null)
            return false;
        boolean insertable = true;
        for (BaseModelObject child: children) {
            // check if it exists already in the children list.
            // if it exists then update,
             Boolean same = associationHelper.compare(childMessageType, child);
            if (same != null && same) {
                insertable = false;
                // update
                associationHelper.setData(childMessageType,child, messageHelper);
//                setCommonFieldsDataToInputType(child, childMessageType);
                  setCommonFieldsFromParentToChild(child, parent);
                break;
            }
        }
        return insertable;
    }

    /**
     * Searchs this messagehelps for this associationHelper.
     * <p>
     * This allows reuse of an instance of an message helper
     * @param associationHelper
     * @param messageHelpers
     * @return
     */
    private MessageHelper getMessageHelper(ComplexAssociationHelper associationHelper,
                                           MessageHelper[] messageHelpers) {
        if(null == messageHelpers){
            return null;
        }else{
            for(MessageHelper mh:messageHelpers){
                if(mh.getClass().getName().equals(associationHelper.getMessageHelperClass().getName())){
                    return mh;
                }
            }

            return null;
        }
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }
    
    public static AdditionalField generateAdditionalField(
        String fieldName, String tableName, String columnName, 
        String fieldType, Object fieldValue, Boolean isPrimaryKey,
        Integer decimalLength) {
        
        AdditionalField field = new AdditionalField();
        field.setFieldName(fieldName);
        field.setTableName(tableName);
        field.setDecimalLength(decimalLength);
        field.setTableColumn(columnName);
        field.setFieldType(fieldType);
        field.setFieldValue(fieldValue);
        field.setIsPrimaryKey(isPrimaryKey);
        return field;
    }
    
    public static AdditionalField generatePortalAdditionalFields(
        String fieldName, String tableName, String columnName, 
        String fieldType, Object fieldValue, Boolean isPrimaryKey,
        Integer decimalLength,String displayType) {

        AdditionalField field = new AdditionalField();
        field.setFieldName(fieldName);
        field.setTableName(tableName);
        field.setDecimalLength(decimalLength);
        field.setTableColumn(columnName);
        field.setFieldType(fieldType);
        field.setFieldValue(fieldValue);
        field.setIsPrimaryKey(isPrimaryKey);
        field.setDisplayType(displayType);
        return field;
    }
    
    public static AdditionalField generatePortalAdditionalFieldValueArray(
        String fieldName, String tableName, String columnName, 
        String fieldType, Object fieldValueArray[], Boolean isPrimaryKey,
        Integer decimalLength,String displayType) {

        AdditionalField field = new AdditionalField();
        field.setFieldName(fieldName);
        field.setTableName(tableName);
        field.setDecimalLength(decimalLength);
        field.setTableColumn(columnName);
        field.setFieldType(fieldType);
        field.getFieldValueArray().addAll(Arrays.asList(fieldValueArray));
        field.setIsPrimaryKey(isPrimaryKey);
        field.setDisplayType(displayType);
        return field;
    }

    public void setCommonFieldsFromParentToChild(BaseModelObject pojo, BaseModelObject parentPojo){
        if(pojo != null && parentPojo != null){
            if(pojo.getCreatedBy() == null) pojo.setCreatedBy( parentPojo.getCreatedBy() );
            if(pojo.getCreatedDate() == null) pojo.setCreatedDate(  parentPojo.getCreatedDate() );
            
            pojo.setUpdatedBy( parentPojo.getUpdatedBy() );
            pojo.setUpdatedDate( parentPojo.getUpdatedDate() );
        
        }
    }
    
    public void setCommonFieldsFromInputTypeToPojo(BaseModelObject pojo, InputType type){
        if(pojo != null && type != null){
            if(pojo.getCreatedBy() == null) pojo.setCreatedBy( type.getCreatedBy() );
            if(pojo.getCreatedDate() == null) pojo.setCreatedDate( DateHelper.getSqlTimestamp( type.getCreatedDate() == null ? Calendar.getInstance():type.getCreatedDate()));
            
            pojo.setUpdatedBy( type.getUpdatedBy() );
            pojo.setUpdatedDate( DateHelper.getSqlTimestamp( type.getUpdatedDate()));
        
        }
    }    


    public void setCommonFieldsFromPojoToInputType(BaseNormalModelObject pojo, InputType type){
        if(pojo != null && type != null){
            type.setId( pojo.getId() );
            type.setCreatedBy( pojo.getCreatedBy() );
            type.setCreatedDate( DateHelper.getCalendar(pojo.getCreatedDate() ));
            type.setUpdatedBy( pojo.getUpdatedBy() );
            type.setUpdatedDate( DateHelper.getCalendar( pojo.getUpdatedDate() ));
        
        }
    }  
    
    /**
     * The facadeLocal instance will be injected from the place we initialize this messagehelper.
     * @param local
     */
    public void setFacade(FacadeLocal local) {
        this.facade = local;
    }

}
