package com.technobrain.trips.common.helpers;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;


/**
 * � Crown Agents 2008
 *
 * Hold static utility functions for general reflection (get/set etc.).
 *
 * @since $Date: 2/1/2010 9:33:31 AM$
 * @version $Revision: 37$
 * @author $Author: Kemal Ediz$
 *
 * $Log[1]:
 *  37   TRIPS2 etis.bir.gov.ph1.26.2.9    2/1/2010 9:33:31 AM    Kemal Ediz   
 *         cpv and scv implemented.
 * $
 */
public class ReflectionHelper {
    static final Logger log = Logger.getLogger(ReflectionHelper.class);
    private ReflectionHelper() {

    }

    // Stop going up the class hierarchy before we hit this object
    private static String STOP_CLASS = "java.lang.Object";

    // The separator used in full method name
    public static final String METHOD_NAME_SEPARATOR = ".";

    // Getter method prefix
    public static final String GET = "get";

    /**
     * Run through the fields on the input object and return the input field if it exists, else null.
     * @param source Object to search fields on
     * @param fieldName Name of field to look for
     * @return
     */
    public static Field getField(Object source, String fieldName) {
        return getField(source.getClass(), fieldName, false);
    }

    /**
     * Run through the fields on the input object and return the input field if it exists,
     * ignoring the case of the input fieldName, else null.
     * @param source Object to search fields on
     * @param fieldName Name of field to look for
     * @return
     */
    public static Field getFieldIgnoreCase(Object source, String fieldName) {
        return getField(source.getClass(), fieldName, true);
    }
    
    /**
     * Does the input class have a default (paramaterless) constructor
     * @param clazz
     * @return true if default constructor exists
     */
    public static boolean hasDefaultConstructor(Class clazz) {
        Constructor[] constructors = clazz.getConstructors();
        
        for (Constructor currCons: constructors) {
            if ( (currCons.getGenericParameterTypes() == null) || 
                 (currCons.getGenericParameterTypes().length == 0) )
                return true;
        }
        
        return false;
    }

    /**
     * Underlying worker method for getField that takes the class to search to enable a recursive search of superclass
     *
     * @param fieldName
     * @param clazz
     * @param ignoreCase Ignore the case of the input field name
     * @return
     */
    private static Field getField(Class clazz, String fieldName, 
                                  boolean ignoreCase) {
        // if the field has multiple '.' separated parts to it, regress down through them to the field
        if (fieldName.indexOf(".") > -1) {
            // first get the top level field
            Field tempFld = 
                getField(clazz, fieldName.substring(0, fieldName.indexOf(".")), 
                         ignoreCase);
            // and if it exists, start moving down the tree
            if (tempFld != null)
                return getField(tempFld.getType(), 
                                fieldName.substring(fieldName.indexOf(".") + 
                                                    1), ignoreCase);
        }

        Field[] fields = clazz.getDeclaredFields();
        Field currField = null;
        // run through and look for any default fields to set
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(fieldName) || 
                (fields[i].getName().equalsIgnoreCase(fieldName) && 
                 ignoreCase)) {
                currField = fields[i];
                break;
            }
        }

        if ((currField == null) && 
            (!clazz.getSuperclass().getName().equals(STOP_CLASS)))
            currField = getField(clazz.getSuperclass(), fieldName, ignoreCase);

        return currField;
    }

    /**
     * Find a method that may exist in a super class
     * TODO (MS) I don't think I really need this, check it out when get a chance
     *
     * @param clazz
     * @param methodName
     * @param params
     * @return
     * @throws Exception
     */
    private static Method findMethod(Class clazz, String methodName, 
                                     Class[] params) throws Exception {
        try {

            Method result = clazz.getMethod(methodName, params);


            if ((result == null) && 
                !clazz.getSuperclass().getName().equals(STOP_CLASS))
                result = findMethod(clazz.getSuperclass(), methodName, params);

            if (result == null)
                throw new Exception("Method named " + methodName + 
                                    " cannot be found.");
            else
                return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * General utility method to invoke the specified method on the object.
     * @param target Object to invoke method on
     * @param methName Name of method to invoke
     * @param params Objects to pass as parameters, classes of these objects used to find the signature
     * of the method to invoke
     * @return The return of the invoke
     * @throws NoSuchMethodException
     */
    public static Object invokeStaticMethod(Class target, String methName, 
                                            Object[] params) throws NoSuchMethodException {
        Object result = null;


        Class[] sig = null;
        if (null == params) {

        } else {
            sig = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                sig[i] = params[i].getClass();
            }
        }

        try {
            Method methSetter = findMethod(target, methName, sig);
            result = methSetter.invoke(null, params);
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

        return result;
    }

    /**
     * General utility method to invoke the specified method on the object.
     * @param target Object to invoke method on
     * @param methName Name of method to invoke
     * @param params Objects to pass as parameters, classes of these objects used to find the signature
     * of the method to invoke
     * @return The return of the invoke
     * @throws NoSuchMethodException
     */
    public static Object invokeMethod(Object target, String methName, 
                                      Object[] params) throws NoSuchMethodException {
        Object result = null;


        Class[] sig = null;
        if (null == params) {

        } else {
            sig = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                sig[i] = params[i].getClass();
            }
        }

        try {
            Method methSetter = findMethod(target.getClass(), methName, sig);
            result = methSetter.invoke(target, params);
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

        return result;
    }

    /**
     * Invoke the setter for the input field name on the input object, assigning the input value.
     *
     * @param target Target object call set on
     * @param fieldName Name of the field to set
     * @param value Value to set
     * @throws NoSuchMethodException
     */
    public static void invokeSetter(Object target, String fieldName, 
                                    Object value) throws NoSuchMethodException {
        invokeSetter(target, fieldName, null,value, false);
    }
    
    /**
     * Invoke the setter for the input field name on the input object with the given input. But the fieldName is given 
     * as follows:
     * address.contact.name
     * In this case we need to iterate within the given target object and visit address, then contact object and within
     * contact, we need to assign the given input to the name field.
     * 
     * @param target
     * @param fieldNameChain
     * @param value
     * @throws NoSuchMethodException
     */
    public static void invokeSetterInChain(Object target, String fieldNameChain, Object value) throws NoSuchMethodException{
        if(!fieldNameChain.contains(".")) {
            invokeSetter(target, fieldNameChain, value);
            return;
        }
        String[] chain = fieldNameChain.split("\\.");
        
        for(int i = 0 ; i < chain.length - 1; i++) {
            Object innerObject = invokeGetter(target, chain[i]);
            target = innerObject;
        }
        // now the target object is the last object within the chain. The given value should be assigned within this target
        // object.
        invokeSetter(target, chain[chain.length - 1], value);
    }
    
    /**
     * Invoke the getter for the input field name on the input object. But the fieldName is given 
     * as follows:
     * address.contact.name
     * In this case we need to iterate within the given target object and visit address, then contact object and within
     * contact, we need to get the value for the given name field.
     * 
     * @param target
     * @param fieldNameChain
     * @throws NoSuchMethodException
     */
    public static Object invokeGetterInChain(Object target, String fieldNameChain) throws NoSuchMethodException{
        String[] chain = fieldNameChain.split("\\.");
        
        for(int i = 0 ; i < chain.length - 1; i++) {
            Object innerObject = invokeGetter(target, chain[i]);
            target = innerObject;
        }
        // now the target object is the last object within the chain. We can directly return the field value.
        return invokeGetter(target, chain[chain.length - 1]);
    }
    
    /**
     * Check if there is a fieldname at the class given as a parameter.
     * @param clazz
     * @param fieldName
     * @return
     */
    public static boolean checkIfFieldExists(Class clazz, String fieldName) {
        try {
            clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return false;
        }
        return true;
    }

    public static void invokeSetter(Object target, Field field, 
                                    Object value,boolean failGracefully) throws NoSuchMethodException {
        invokeSetter(target, field.getName(), field.getType(),value, failGracefully);
    }
    public static void invokeSetter(Object target, Field field, 
                                    Object value) throws NoSuchMethodException {
        invokeSetter(target, field.getName(), field.getType(),value, true);
    }
    
    public static void invokeSetter(Object target, String fieldName, 
                                    Object value, 
                                    boolean failGracefully) throws NoSuchMethodException {
	 invokeSetter(target, fieldName, null,value, failGracefully);
   }
   
    /**
     * Invoke the setter for the input field name on the input object, assigning the input value.
     *
     * @param target Target object call set on
     * @param fieldName Name of the field to set
     * @param value Value to set
     * @throws NoSuchMethodException
     */
    public static void invokeSetter(Object target, String fieldName, Class type,
                                    Object value, 
                                    boolean failGracefully) throws NoSuchMethodException {
        //        if(failGracefully){
        //            try {
        //                target.getClass().getDeclaredField(fieldName);
        //            } catch (NoSuchFieldException e) {
        //                log.error(e.getLocalizedMessage(), e);
        //                return;
        //            }
        //        }
      
        String setter = getSetterFieldName(fieldName);
        Method methSetter =  null;
        try {
            if(null == value && type != null){
                 methSetter = 
                    findMethod(target.getClass(), setter, new Class[] { type });  
                methSetter.invoke(target, new Object[] { null });
            }else{
                 methSetter = null;
                if(null != type){
                    methSetter= findMethod(target.getClass(), setter, new Class[] { type });
                }else{
                   methSetter= findMethod(target.getClass(), setter, new Class[] { value.getClass() });
                }
                if(methSetter == null){
                    throw new NoSuchMethodException();
                }
                methSetter.invoke(target, new Object[] { value });
            }
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        }catch (NoSuchMethodException ex){
            throw ex;        
        } catch (Exception e) {
            log.debug("methSetter " + methSetter);
            log.debug("target.getClass() " + target.getClass());
            log.debug("type " + type);
            log.debug("value " + value);
            log.error(e.getLocalizedMessage(), e);
            if(!failGracefully){
                throw new IllegalAccessError(e.getMessage());
            }
        }

    }

    /**
     * Invoke the setter for the input field name on the input object, assigning the input value,
     * only if the current value of the field is null.
     *
     * @param target
     * @param fieldName
     * @param value
     * @return
     * @throws NoSuchMethodException
     */
    public static boolean setFieldIfNull(Object target, String fieldName, 
                                         Object value) throws NoSuchMethodException {
        Field currField = getField(target, fieldName);
        if (null != currField) {
            Object currVal = invokeGetter(target, fieldName);
            if (null == currVal) {
                invokeSetter(target, fieldName, value);
                return true;
            }
        }
        return false;
    }

    /**
     * Invoke the getter for the input field name on the input object, returning the value.
     * @param source Source object to call getter on
     * @param fieldName Name of field to get
     * @return Value returned from getter
     * @throws NoSuchMethodException
     */
    public static Object invokeGetter(Object source, 
                                      String fieldName) throws NoSuchMethodException {
        return invokeGetter(source, fieldName, false);
    }

    /**
     * Invoke the getter for the input field name on the input object, returning the value
     * <p>
     * This failGracefully indicates that the method will return null if the field is not found.
     * @param source Source object to call getter on
     * @param fieldName Name of field to get
     * @param failGracefully
     * @return Value returned from getter
     * @throws NoSuchMethodException
     */
    public static Object invokeGetter(Object source, String fieldName, 
                                      boolean failGracefully) throws NoSuchMethodException {
        //checks if the field exists on the source object
        if (failGracefully) {
            try {
                source.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                return null;
            }
        }
        // if the field has multiple '.' separated parts to it, regress down through them to the field
        if (fieldName.indexOf(".") > -1) {
            // first get the top level field
            Object tempObj = 
                invokeGetter(source, fieldName.substring(0, fieldName.indexOf(".")));
            // and if it exists, start moving down the tree
            if (tempObj != null)
                return invokeGetter(tempObj, 
                                    fieldName.substring(fieldName.indexOf(".") + 
                                                        1));
        }

        String getter = 
            "get" + String.valueOf(fieldName.charAt(0)).toUpperCase() + 
            fieldName.substring(1);

        try {
            if (source == null) {
                return null;
            } else {
                Method methGetter = 
                    findMethod(source.getClass(), getter, null);
                return methGetter.invoke(source, null);
            }
        } catch (InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * Finds all member objects of the package specified of this aObject.
     * <br>
     * These objects of the package specified are added to a collection of
     * any type.
     * @param aObject
     * @param forPackage
     * @return a collection of member objects for this aObject
     * @throws NoSuchMethodException
     */
    public static Collection<?> getCollectionOfFields(Object aObject, 
                                                      String forPackage) throws NoSuchMethodException {

        ArrayList memberVariableList = new ArrayList();

        Field[] fields = aObject.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            if (field.getType().getName().equals(List.class.getName()) || 
                field.getType().getName().equals(Set.class.getName())) {
                Collection collection = 
                    (Collection)invokeGetter(aObject, field.getName());

                if (collection == null)
                    continue;

                Iterator iter = collection.iterator();
                while (iter.hasNext()) {
                    Object objectInCollection = iter.next();
                    String packageName = getPackageName(objectInCollection);
                    if (packageName.equals(forPackage)) {
                        memberVariableList.add(objectInCollection);
                    }
                }

            } else {
                Object memberObject = invokeGetter(aObject, field.getName());
                String packageName = getPackageName(memberObject);

                if (forPackage.equals(packageName)) {
                    memberVariableList.add(memberObject);
                }
            }

        }

        return memberVariableList;
    }

    /**
     * Gets the packageName of an object
     * @param o
     * @return null if the object is null
     */
    private static String getPackageName(Object o) {
        return null != o ? o.getClass().getPackage().getName() : null;
    }


    /**
     * Collects the declared fields.
     * @param clazz
     * @return
     */
    public static List<Field> getDeclaredFieldsWithInheritance(Class clazz) {
        List<Field> fields = new ArrayList<Field>();
        try {
            addDeclaredFieldsWithInheritance(clazz, fields);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return fields;
    }

    /**
     * It collects the declared fields. It
     * uses recursion to collect every declared field at the superclasses.
     *
     * @param clazz
     * @param fields
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static void addDeclaredFieldsWithInheritance(Class clazz, 
                                                         List fields) throws InstantiationException, 
                                                                             IllegalAccessException {
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        if (clazz.getSuperclass() == null)
            return;
        addDeclaredFieldsWithInheritance(clazz.getSuperclass(), fields);
    }


    public static List<Field> getDeclaredFields(Class clazz) {
        List<Field> fields = new ArrayList<Field>();
        try {
            addDeclaredFields(clazz, fields);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return fields;
    }

    private static void addDeclaredFields(Class clazz, 
                                          List fields) throws InstantiationException, 
                                                              IllegalAccessException {
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        return;
    }

    /**
     * Returns the value of the field  <tt><b>fieldName</b></tt> of the source
     * object, if any instance in source assosiation contains array/Collection returns
     * complex object correspondingly
     *
     * @param source a source object instance, top-tree
     * @param fieldName name of the field which value will be returned, e.g., itemQuantity
     * @return current value of the field with <tt><b>fieldName</b></tt> name,
     * if any instance in source assosiation contains array/Collection returns
     * complex object correspondingly
     * @throws NoSuchMethodException thrown if source instance class has no
     * getter method for a field with fieldName name; e.g., Item class has no
     * <tt><b>getItemQuantity()</b></tt> method
     */
    public static Object getFieldValue(Object source, 
                                       String fieldName) throws NoSuchMethodException {

        if (null == source) { // Can't do much here...
            return null;
        }

        if (fieldName.contains(METHOD_NAME_SEPARATOR)) { // Complex method name, prepended
            // by class name(s); resolve it (go down one next class)

            String prefix = 
                fieldName.substring(0, fieldName.indexOf(METHOD_NAME_SEPARATOR));
            Object currentObject = getFieldValue(source, prefix);

            if (null == currentObject) {
                log.debug("\n=W=\t Value of the field '" + prefix + 
                                   "' of the '" + source.getClass() + 
                                   "' object is null!");
                return null;
            }

            // Remove one prepending prefix (e.g., "itemDetails.")
            String suffix = 
                fieldName.substring(fieldName.indexOf(METHOD_NAME_SEPARATOR) + 
                                    1);

            // Now treat Array, Collection, and just a simple single instance
            // object differently, as on Array and Collection we have to invoke
            // given method on each member of Array/Collection. Note, that for Array
            // an array of invokations is returned, for Collection a Collection
            // (currently implemented as ArrayList) is returned.

            if (currentObject.getClass().isArray()) {
                int length = Array.getLength(currentObject);
                //log.debug("=I= Object currentObject=" + currentObject + " is array!");
                Object[] objects = new Object[length];

                for (int i = 0; i < length; i++) {
                    objects[i] = 
                            getFieldValue(Array.get(currentObject, i), suffix);

                    //log.debug("=I= Getter invoked; objects [" + i + "]=" + objects [i] + "... ");
                    //if (null != objects [i]) {
                    //log.debug("; object class: " + objects [i].getClass());
                    //}
                }

                return objects;

            } else if (currentObject instanceof Collection) {

                Collection objList = new ArrayList();

                for (Iterator iter = ((Collection)currentObject).iterator(); 
                     iter.hasNext(); ) {
                    objList.add(getFieldValue(iter.next(), suffix));
                }

                return objList;

                //      } else if (...) {  // Add more special cases here??
            } else {
                // Just a single object...
                return getFieldValue(currentObject, suffix);
            }

        }

        // If we get to here means that the name of the method to invoke is not
        // complex, i.e., it needs no (further) resolving. Create getter and invoke
        // it to get the value of the field.

        String getter = 
            GET + String.valueOf(fieldName.charAt(0)).toUpperCase() + 
            fieldName.substring(1);
//        log.debug("=I= getter: " + getter);

        Object valueObject = null;

        try {
            Method methGetter = findMethod(source.getClass(), getter, null);
            if(null != methGetter)valueObject = methGetter.invoke(source);
            else{
                throw new NoSuchMethodException();
            }
        } catch (Exception e) {
            //log.error(e.getLocalizedMessage(), e);
            throw new NoSuchMethodException();
        }

        return valueObject;
    }


    public static String getSetterFieldName(String fieldName) {
        String methodName = null;
        char firstCharacter = fieldName.charAt(0);
        String upperCaseChar = String.valueOf(firstCharacter).toUpperCase();
        methodName = upperCaseChar + fieldName.substring(1);
        return "set" + methodName;
    }
    
    public static Object getInstance(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            //log.error(e.getLocalizedMessage(), e);
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            //log.error(e.getLocalizedMessage(), e);
             log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (InstantiationException e) {
            //log.error(e.getLocalizedMessage(), e);
             log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
 
}
