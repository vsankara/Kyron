package com.technobrain.trips.common.util;

import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.core.message.InputType;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class CopyNewRecord {
    public static final Logger log = Logger.getLogger(CopyNewRecord.class);

    private List<Object> initialisedTypes = new ArrayList<Object>();

    public void initializeFieldsForCopy(Object inputType, List<String> fieldsToClear, boolean clearChildClasses)  {
        if (inputType != null) {
            if (inputType instanceof InputType) {
                ((InputType)inputType).setId(null);
                ((InputType)inputType).setCreatedBy(null);
                ((InputType)inputType).setCreatedDate(null);
                ((InputType)inputType).setUpdatedBy(null);
                ((InputType)inputType).setUpdatedDate(null);
            }    
            if (fieldsToClear != null && fieldsToClear.size() > 0) {
                for (String field : fieldsToClear){
                    try{
//                        Field fieldx  = inputType.getClass().getField(field);
//                        if(fieldx != null ){
                            Method[] methods = inputType.getClass().getMethods();
                            for (Method meth : methods){
                                if(meth.getName().equalsIgnoreCase("set" + field)){
                                    Object[] arr = new Object[1];
                                    arr[0] = null;
                                    meth.invoke(inputType, arr);
                                    break;
                                }
                            }

//                        }
//                    }catch(NoSuchFieldException ex){
//                        log.error(ex.getLocalizedMessage(), ex);
                        // do nothing
                    }catch(IllegalAccessException ex){
                        log.error(ex.getLocalizedMessage(), ex);
                        // do nothing
                    }catch(InvocationTargetException ex){
                        log.error(ex.getLocalizedMessage(), ex);
                         // do nothing
                    }
                }
            }
        }
        if (clearChildClasses) {
            initialisedTypes.add(inputType);
            initialiseChildTypes(inputType, inputType.getClass().getMethods(), fieldsToClear);
        }
    }       

    public static CopyNewRecord getInstance() {
        return new CopyNewRecord();
    }

    private void initialiseChildTypes(Object messageType, Method[] methods, List<String> fieldsToClear) {
        for (Method m: methods) {
            Class returnType = m.getReturnType();
            if (null != returnType) {
                if(m.getName().startsWith("get")) {
                    if (returnType.isArray()) {
                        Object obj = null;
                        try{
                            obj = m.invoke(messageType, null);
                        }
                        catch(Exception e) {
        //                            log.error(e.getLocalizedMessage(), e);
                            continue;
                        }
                        // check:
                        // if this class is traced before. Otherwise it enters recursion.
                        // if the return type is suitable
                        // if the returning object is not null.
                        // if the size of the collection is more than zero so that we can trace the items.
                        if (obj != null && 
                            obj.getClass().isArray() && Array.getLength(obj) > 0) {
                            int length = Array.getLength(obj);
                            for (int i = 0; i < length; i++) {
                                Object msgType = Array.get(obj, i);
                                if(!initialisedTypes.contains(msgType))
                                    initializeFieldsForCopy(msgType,fieldsToClear, true);
                                }
                        }
                    } else if (Collection.class.isAssignableFrom(returnType)) {
                        Object obj = null;
                        try{
                            obj = m.invoke(messageType, null);
                            }
                        catch(Exception e) {
    //                                log.error(e.getLocalizedMessage(), e);
                            continue;
                        }
                            // check:
                            // if this class is traced before. Otherwise it enters recursion.
                            // if the return type is suitable
                            // if the returning object is not null.
                            // if the size of the collection is more than zero so that we can trace the items.
                        if (obj != null && !initialisedTypes.contains(obj) && 
                            Collection.class.isAssignableFrom(obj.getClass()) && ((Collection)obj).size() > 0) {
                                Iterator itr = ((Collection)obj).iterator();
                                while(itr.hasNext()) {
                                    Object msgType = itr.next();
                                    if(!initialisedTypes.contains(msgType))
                                        initializeFieldsForCopy(msgType,fieldsToClear, true);
                                }
                            }
                        }
                        else {
                                Object obj = null;
                                try{
                                    obj = m.invoke(messageType, null);
                                }
                                catch(Exception e) {
                            //                      log.error(e.getLocalizedMessage(), e);
                                continue;
                                }
                                if (obj != null && obj instanceof InputType) {
                                 // check if this class is traced before. Otherwise it enters recursion.
                                    if(initialisedTypes.contains(obj)){
                                    continue;
                                }
                                initializeFieldsForCopy(obj,fieldsToClear, true);
                            }
                        }

                    }
            }
        }
    }
}
