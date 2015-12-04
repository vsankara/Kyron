package com.technobrain.trips.core.bean;

import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.sessionmanager.SessionPage;
import com.technobrain.trips.core.sessionmanager.backing.BackingSessionManager;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;

import java.lang.reflect.Field;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * This class stores the backing beans to a storage area, and whenever the user wants, puts it back to session scope.
 * It is used when the user wants to open a page that uses the same backing bean in the same session, but the instances
 * of the backing beans must be different. So simultaneously, we should be able to use the two backin bean instances. 
 */
public class BackingBeanStorer {
    static final Logger log = Logger.getLogger(BackingBeanStorer.class);
    public BackingBeanStorer() {
    }
    
    
    /**
     * Stores the backing bean to a store area which is in the session scope. Then removes the backing bean from the session scope
     * @param backingBeanName
     */
    public static void store(String backingBeanName) {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        sessionManager.getStoredBackingBeans().put(
            backingBeanName, (BackingBase)FacesUtil.getManagedBeanValue(backingBeanName));
        FacesUtil.removeFromSession(backingBeanName);
    }
    
    /**
     * Stores the process scope vars to a store area which is in the session scope.
     */
    public static void storeKnownProcessScopeVariables() {
        SessionPage page = new SessionPage();
        page.storeKnownProcessScopeVariables();
        BackingSessionManager manager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        manager.setStoredProcessScopeVariables(page.getProcessScopeVariables());
    }
    
    /**
     * Removes all the process scope variables that are defined in the web constants.
     */
    public static void clearProcessScopeVariables() {
        // uses reflection in order to find the static field values in the webconstants.processscopevariable interface.
        Class processScopeInterface = null;
        try {
            processScopeInterface = Class.forName(WebConstants.class.getName() + "$ProcessScopeVariable");
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
            return;
        }
        
        if(processScopeInterface != null) {
            Field[] fields = processScopeInterface.getFields();
            for (int i = 0; i < fields.length; i++)  {
                Field field = fields[i];

                // find the static field values.
                Object fieldValue = null;
                try {
                    fieldValue = field.get(null);
                } catch (IllegalAccessException e) {
                    log.error(e.getLocalizedMessage(), e);
                    return;
                }
                // put it into the storage.
                if(fieldValue != null)
                        FacesUtil.removeFromProcessScope(fieldValue.toString());

            }
            
        }
    }
    
    /**
     * Stores the backing beans to a store area which is in the session scope. Then, removes the backing bean from the session scope
     * @param backingBeans
     */
    public static void store(List<String> backingBeans) {
        for (int i = 0; i < backingBeans.size(); i++)  {
            String backingBeanName = backingBeans.get(i);
            store(backingBeanName);
        }
    }
    
    /**
     * Clears all the stored backing beans.
     */
    public static void clearStoredBackingBeans() {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        // clear the storage area.
        sessionManager.getStoredBackingBeans().clear();
    }
    
    /**
     * Clears the stored backing bean.
     * @param backingBeanName
     */
    public static void clearStoredBackingBean(String backingBeanName) {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        // clear the storage area.
        sessionManager.getStoredBackingBeans().remove(backingBeanName);
    }
    
    /**
     * Puts back the stored backing beans from the storage area to the session scope, then deletes them from the storage area.
     */
    public static void putBackAllFromTheStorage() {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        Map<String, BackingBase> backingBeans = sessionManager.getStoredBackingBeans();
        Iterator itr = backingBeans.keySet().iterator();
        while(itr.hasNext()) {
            String backingBeanName = (String)itr.next();
            // replace the stored backing bean 
            FacesUtil.removeFromSession(backingBeanName);
            BackingBase backingBase = backingBeans.get(backingBeanName);
            FacesUtil.storeOnSession(backingBeanName, backingBase);
        }
        // clear from the storage area.
        clearStoredBackingBeans();
    }
    
    /**
     * Puts back the stored backing bean from the storage area to the session scope, then deletes it from the storage area.
     * @param backingBeanName
     */
    public static void putBackFromTheStorage(String backingBeanName) {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        Map<String, BackingBase> backingBeans = sessionManager.getStoredBackingBeans();
        // replace the stored backing bean 
        FacesUtil.removeFromSession(backingBeanName);
        BackingBase backingBase = backingBeans.get(backingBeanName);
        FacesUtil.storeOnSession(backingBeanName, backingBase);
        // clear from the storage area.
        clearStoredBackingBean(backingBeanName);
    } 
    
    /**
     * Puts back the stored process scope vars from the storage area to the session scope, then deletes it from the storage area.
     */
    public static void putBackProcessScopeVariablesFromTheStorage() {
        BackingSessionManager sessionManager = (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        Map<String, Object> storedPCV = sessionManager.getStoredProcessScopeVariables();
        Iterator itr = storedPCV.keySet().iterator();
        while(itr.hasNext()) {
            String key = (String)itr.next();
            FacesUtil.storeOnProcessScope(key, storedPCV.get(key));
        }
        sessionManager.getStoredProcessScopeVariables().clear();
    }
}
