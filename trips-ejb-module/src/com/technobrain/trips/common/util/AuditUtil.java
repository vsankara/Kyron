package com.technobrain.trips.common.util;

//import com.crownagents.trips.generic.message.VariantType;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class AuditUtil {
    private List<Object> tracedClasses = new ArrayList<Object>();
    
    private AuditUtil() {
    }
    
    public static AuditUtil getInstance() {
        return new AuditUtil();
    }
    
    /**
     * Audits the entity with the user credentials and dates
     * @param objToBeAudited
     * @param userNameOrObjCarryingAudit
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public void userAudit(Object objToBeAudited, final Object userNameOrObjCarryingAudit)  {

        Object it = isClassToAudit(objToBeAudited);
        if (it != null) {
            if (it instanceof InputType) {
                if(userNameOrObjCarryingAudit instanceof String) {
                // we come here from BpelProcessInterceptor
                    if (((InputType)it).getCreatedBy() == null && userNameOrObjCarryingAudit != null) 
                        ((InputType)it).setCreatedBy((String)userNameOrObjCarryingAudit);
                    if (((InputType)it).getCreatedDate() == null)
                        ((InputType)it).setCreatedDate(Calendar.getInstance());
                    if(null != userNameOrObjCarryingAudit)
                    ((InputType)it).setUpdatedBy((String)userNameOrObjCarryingAudit);
                    ((InputType)it).setUpdatedDate(Calendar.getInstance());
                    if(((InputType)it).getStatus() == null) {
                        ((InputType)it).setStatus("A");
                    }
                }
                else if(userNameOrObjCarryingAudit instanceof BaseModelObject) {
                // we come here from setCommonFieldDataToInputType method in MessageHelper
                    ((InputType)it).setCreatedBy(((BaseModelObject)userNameOrObjCarryingAudit).getCreatedBy());
                    ((InputType)it).setCreatedDate(DateHelper.getCalendar(((BaseModelObject)userNameOrObjCarryingAudit).getCreatedDate()));
                    ((InputType)it).setUpdatedBy(((BaseModelObject)userNameOrObjCarryingAudit).getUpdatedBy());
                    ((InputType)it).setUpdatedDate(DateHelper.getCalendar(((BaseModelObject)userNameOrObjCarryingAudit).getUpdatedDate()));
                    if(((InputType)it).getStatus() == null)
                        ((InputType)it).setStatus(((BaseModelObject)userNameOrObjCarryingAudit).getStatus());
                    ((InputType)it).setAccessLevel(((BaseModelObject)userNameOrObjCarryingAudit).getAccessLevel());
                }                
            } else if (it instanceof BaseModelObject) {
                if(userNameOrObjCarryingAudit instanceof String) {
                    // we come here from UserAuditInterceptor
                    if (((BaseModelObject)it).getCreatedBy() == null && userNameOrObjCarryingAudit != null)
                        ((BaseModelObject)it).setCreatedBy((String)userNameOrObjCarryingAudit);
                    if (((BaseModelObject)it).getCreatedDate() == null)
                        ((BaseModelObject)it).setCreatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
                    if(null != userNameOrObjCarryingAudit)
                    ((BaseModelObject)it).setUpdatedBy((String)userNameOrObjCarryingAudit);
                    ((BaseModelObject)it).setUpdatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
                    if(((BaseModelObject)it).getStatus() == null) {
                        ((BaseModelObject)it).setStatus("A");
                    }
                }
                else if(userNameOrObjCarryingAudit instanceof InputType) {
                    // we come here from saveOrUpdate in FacadeBean.
                        if (((BaseModelObject)it).getCreatedBy() == null)
                        ((BaseModelObject)it).setCreatedBy(((InputType)userNameOrObjCarryingAudit).getCreatedBy());
                        if (((BaseModelObject)it).getCreatedDate() == null)
                        ((BaseModelObject)it).setCreatedDate(DateHelper.getSqlTimestamp(((InputType)userNameOrObjCarryingAudit).getCreatedDate()));
                    ((BaseModelObject)it).setUpdatedBy(((InputType)userNameOrObjCarryingAudit).getUpdatedBy());
                    ((BaseModelObject)it).setUpdatedDate(DateHelper.getSqlTimestamp(((InputType)userNameOrObjCarryingAudit).getUpdatedDate()));
                    if(((InputType)userNameOrObjCarryingAudit).getStatus() == null) {
                        ((BaseModelObject)it).setStatus("A");
                    }
                    else {
                        ((BaseModelObject)it).setStatus(((InputType)userNameOrObjCarryingAudit).getStatus());
                    }
                    ((BaseModelObject)it).setAccessLevel(((InputType)userNameOrObjCarryingAudit).getAccessLevel());
                }
            }
            tracedClasses.add(objToBeAudited);
            traverseAndAudit(objToBeAudited, objToBeAudited.getClass().getMethods(), userNameOrObjCarryingAudit);
        }

    }

    /**
     * 
     * @param messageType
     * @param methods
     * @param userName
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    private void traverseAndAudit(Object messageType, Method[] methods, 
                                          final Object userName) {
        for (Method m: methods) {
            Class returnType = m.getReturnType();
            if (null != returnType) {
                if(m.getName().startsWith("get")) {
                    if (isClassToAudit(returnType)) {
                        Object obj = null;
                        try{
                            obj = m.invoke(messageType, null);
                        }
                        catch(Exception e) {
//                            log.error(e.getLocalizedMessage(), e);
                            continue;
                        }
                        if (obj == null) {
                            //do nothing   
                        } else {
                            // check if this class is traced before. Otherwise it enters recursion.
                            if(tracedClasses.contains(obj)){
                                continue;
                            }
                            userAudit(obj, userName);
                        }
    
                    } else if (returnType.isArray()) {
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
                                if(!tracedClasses.contains(msgType))
                                    userAudit(msgType, userName);
                            }
                        }
                    } else if (Collection.class.isAssignableFrom(returnType)) {
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
                        if (obj != null && !tracedClasses.contains(obj) && 
                            Collection.class.isAssignableFrom(obj.getClass()) && ((Collection)obj).size() > 0) {
                            Iterator itr = ((Collection)obj).iterator();
                            while(itr.hasNext()) {
                                Object msgType = itr.next();
                                if(!tracedClasses.contains(msgType))
                                    userAudit(msgType, userName);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param clazz
     * @return
     */
    private Object isClassToAudit(Object clazz) {
        if (null != clazz && isClassToAudit(clazz.getClass())) {
            return clazz;
        } else {
            return null;
        }
    }

    private boolean isClassToAudit(Class clazz) {

        if (InputType.class.isAssignableFrom(clazz)) { //|| VariantType.class.isAssignableFrom(clazz)) {
            return true;
        } else if (BaseModelObject.class.isAssignableFrom(clazz)) {
            return true;
        }
        return false;
    }
}
