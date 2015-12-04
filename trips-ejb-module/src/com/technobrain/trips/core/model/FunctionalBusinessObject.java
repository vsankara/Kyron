package com.technobrain.trips.core.model;

import com.technobrain.trips.common.helpers.ReflectionHelper;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.ManyToOne;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * Provides functional methods to a model object to make it a business object
 */
public class FunctionalBusinessObject implements Serializable {
    public static final Logger log = Logger.getLogger(FunctionalBusinessObject.class);

    /**
     * Object which will duplicated
     */
    BaseModelObject modelObject;
    
    /**
     * Wrapper constructor that manages the object, making it transient
     * @param _modelObject
     */
    public FunctionalBusinessObject(BaseModelObject _modelObject) {
        this.modelObject = _modelObject;
    }
    
    /**
     * Makes a duplicate of a object as transient
     * @return
     */
    public BaseModelObject makeNew() {
        return makeNew(modelObject);
    }
    /**
     * Makes a new object address
     * @param _modelObject
     * @return
     */
    private BaseModelObject makeNew(BaseModelObject _modelObject) {
        BaseModelObject clone = null;
        try {
            clone = (BaseModelObject)BeanUtils.cloneBean(_modelObject);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchMethodException e) {
             log.error(e.getLocalizedMessage(), e);
        } catch (InvocationTargetException e) {
             log.error(e.getLocalizedMessage(), e);
        } catch (InstantiationException e) {
             log.error(e.getLocalizedMessage(), e);
        }


        try {
            cascadeMakeNew(clone,
                new Class[]{javax.persistence.Id.class,ManyToOne.class},null,false);
        } catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new IllegalAccessError(e.getMessage());
        }
        return clone;
    }

    /**
     * Cascade the object graph and recreates a new object with its
     * associated relations
     * @param clone
     * @param annonations
     * @throws NoSuchMethodException
     */
    public static void cascadeMakeNew(Object clone, 
                                            Class[] annonations,Object parent,boolean bidirectional) throws NoSuchMethodException {
    
        List<Field> fields = ReflectionHelper.getDeclaredFieldsWithInheritance(clone.getClass());
        boolean found = false;
        for(Field field:fields){
            for(int i=0; i<annonations.length;i++){
                found = field.isAnnotationPresent(annonations[i]);
                if(found){
                    if(bidirectional && annonations[i].isAssignableFrom(ManyToOne.class)){
                        if(field.getType().equals(parent.getClass())){

                                              log.debug("o " + clone);
                            ReflectionHelper.invokeSetter(clone,field,parent,false);
                        }else{
                            //do nothig for now, need to add a map to
                            //get fields to clone to create new and make a reference
                        }
                    }else{
                        //hence must be undirectional or a Strong type
                        
                        if(isStrongType(field)){
                            ReflectionHelper.invokeSetter(clone,field,null,false);  
                        }else //for unidirectional
                            {
                                //do nothig for now, need to add a map to
                                //get fields to clone to create new and make a reference
                                
                            }
                    }
                }
            }
            
           if( field.getType().isAssignableFrom(java.util.List.class) 
               || field.getType().isAssignableFrom(java.util.Set.class))
           {
               Collection collection = (Collection)ReflectionHelper.invokeGetter(clone,field.getName());
               Iterator i = collection.iterator();
               Object o = null;
               while(i.hasNext()){
                  o = i.next();
                  cascadeMakeNew(o,annonations,clone,true);
               }
           }
        }
    }


    private static boolean isStrongType(Field field) {
       return !field.getType().isAssignableFrom(BaseModelObject.class);
    }
}
