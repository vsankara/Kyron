package com.technobrain.trips.common.helpers;

import java.io.Serializable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class AnnotationHelper {
    static final Logger log = Logger.getLogger(AnnotationHelper.class);

    private AnnotationHelper() {
    }
    
    
    /**
     * Returns the value of the first field that is associated with the given annotation. (Can be used if there is exactly one)
     * @param entity
     * @param annotationClass
     * @return
     */
    public static Object getValueByAnnotation(Serializable entity, Class annotationClass) {
        Object value = null;
        Field field = getFieldByAnnotation(entity, annotationClass);
        if(field == null)
            return null;
        try{
            value=ReflectionHelper.invokeGetter(entity,field.getName());
        } catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return value;
    }
    
    /**
     * Returns all of the values of the fields that are associated with the given annotation. (Can be used if there is exactly one)
     * @param entity
     * @param annotationClass
     * @return
     */
    public static List getValuesByAnnotation(Serializable entity, Class annotationClass) {
        List values =  new ArrayList();
        List<Field> fields = getFieldsByAnnotation(entity.getClass(), annotationClass);
        if(fields == null)
            return null;
        for (int i = 0; i < fields.size(); i++)  {
            Field field = fields.get(i);
            Object value = null;
            try{
                value=ReflectionHelper.invokeGetter(entity,field.getName());
            } catch (NoSuchMethodException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            values.add(value);
        }
        return values;
    }
    
    public static <T extends Annotation> Annotation getAnnotation(Class entityClass, Class<T> annotationClass) {
        if(entityClass.isAnnotationPresent(annotationClass)) {
            return entityClass.getAnnotation(annotationClass);
        }
        return null;
    }
    
    /**
     * Returns the first field that is associated with the given annotation. (Can be used if there is exactly one)
     * 
     * @param entity
     * @param annotationClass
     * @return
     */
    public static Field getFieldByAnnotation(Serializable entity, Class annotationClass) {
        return getFieldByAnnotation(entity.getClass(), annotationClass);
    }
    
    /**
     * Returns the first field that is associated with the given annotation. (Can be used if there is exactly one)
     * @param entityClass
     * @param annotationClass
     * @return
     */
    public static Field getFieldByAnnotation(Class entityClass, Class annotationClass) {Field[] fields;
        fields = entityClass.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field field = fields[i];
            if(field.isAnnotationPresent(annotationClass)){
                return field;
            }
        } 
        if(entityClass.getSuperclass() != null)
            return getFieldByAnnotation(entityClass.getSuperclass(), annotationClass);
        
        return null;
    }
    
    /**
     * Returns all the fields that are associated with the given annotation.
     * @param entityClass
     * @param annotationClass
     * @return
     */
    public static List<Field> getFieldsByAnnotation(Class entityClass, Class annotationClass) {
        Field[] fields = entityClass.getDeclaredFields();
        List<Field> fieldsList = new ArrayList<Field>();
        for(int i=0; i<fields.length; i++){
            Field field = fields[i];
            if(field.isAnnotationPresent(annotationClass)){
                fieldsList.add(field);
            }
        } 
        return fieldsList;
    } 
    
    
    /**
     * If any of the values that are related with the given parameter is null, returns true. Otherwise returns false.
     * @param child
     * @param annotationClass
     * @return
     */
    public static boolean checkIfAnnotationValueIsNull(Object child, Class annotationClass) {
        List values = getValuesByAnnotation((Serializable)child, annotationClass);
        if(values == null)
            return true;
        for (int i = 0; i < values.size(); i++)  {
            if(values.get(i) == null)
                return true;
        }
        return false;
    }
}
