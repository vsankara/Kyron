package com.technobrain.trips.core.sessionmanager;

import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;


/**
 * Class for holding the information of a jsf page in the flow of pages.
 */
public class SessionPage implements Serializable {
    static final Logger log = Logger.getLogger(SessionPage.class);
    /**
     * Page url
     */
    private String viewId;
    /**
     * Page's backing bean
     */
    private BackingBase backingBean;
    
    /**
     * Page's backing bean name in the faces config.
     */
    private String backingBeanName;
    
    /**
     * One page can contain more than one backing beans. The elements of the list are instances of map.
     * Map key is the backing bean name, value is the backing bean.
     */
    private Map backingBeans;
    
    /**
     * Stores the process scope variables for this page.
     */
    private Map processScopeVariables;
    
    /**
     * SessionWorker session scope vars.
     */
    private Map workerSessionScopeVariables;
    
    /**
     * SessionWorker process scope vars.
     */
    private Map workerProcessScopeVariables;
    
    private boolean forcedEndState;
    
    public SessionPage() {
    }

    public SessionPage(String viewId) {
        this.viewId = viewId;
    }

    public SessionPage(String viewId, BackingBase backingBean, String backingBeanName) {
        this.viewId = viewId;
        this.backingBean = backingBean;
        this.backingBeanName = backingBeanName;
    }
    
    public SessionPage(String viewId, Map backingBeans) {
        this.viewId = viewId;
        this.backingBeans = backingBeans;
    }
    
    public boolean equals(Object object) {
            // if (object == this) return true;
            if ( (object == null) || !(object instanceof SessionPage) ) return false;

            final SessionPage page = (SessionPage) object;
                
            if (viewId != null && page.getViewId() != null){
                return viewId.equals(page.getViewId());
            }
            return false;  
    }

    public void setBackingBean(BackingBase backingBean) {
        this.backingBean = backingBean;
    }

    public BackingBase getBackingBean() {
        return backingBean;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getViewId() {
        return viewId;
    }

    public void setBackingBeanName(String backingBeanName) {
        this.backingBeanName = backingBeanName;
    }

    public String getBackingBeanName() {
        return backingBeanName;
    }

    public void setBackingBeans(Map backingBeans) {
        this.backingBeans = backingBeans;
    }

    public Map getBackingBeans() {
        return backingBeans;
    }

    public void setProcessScopeVariables(Map processScopeVariables) {
        this.processScopeVariables = processScopeVariables;
    }

    public Map getProcessScopeVariables() {
        return processScopeVariables;
    }
    
    /**
     * Stores the processscope variables for the generic search page. When we want to turn back to this page later,
     * we can use this map to put the process scope variables to the process scope that are used for this page.
     * We know the names of the process scope variables because they are declared in WebConstants class.
     */
    public void storeKnownProcessScopeVariables() {
        processScopeVariables = new HashMap();
        
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
                if(fieldValue.toString().equals(WebConstants.ProcessScopeVariable.POST_SEARCH_NAV_KEY))
                    log.debug(WebConstants.ProcessScopeVariable.POST_SEARCH_NAV_KEY);
                // put it into the storage.
                if(fieldValue != null)
                        processScopeVariables.put(fieldValue.toString(), FacesUtil.getProcessScope().get(fieldValue));

            }
            
        }
    }
    
    /**
     * Stores the scope variables that are defined in the SessionWorker annotation.
     */
    public void storeSessionWorkerScopeVars() {
        if(backingBean == null)
            return;
        SessionWorker worker = backingBean.getSessionWorker();
        if(worker == null)
            return;
        if(workerProcessScopeVariables == null)
            workerProcessScopeVariables = new HashMap();
        if(worker.processScopeVariables() != null) {
            String[] workerProcessVars = worker.processScopeVariables().split(",");
            for(String workerProcessVar:workerProcessVars) {
                workerProcessScopeVariables.put(workerProcessVar, FacesUtil.getFromProcessScope(workerProcessVar));
            }
        }
        
        if(workerSessionScopeVariables == null)
            workerSessionScopeVariables = new HashMap();
        if(worker.sessionScopeVariables() != null) {
            String[] workerSessionVars = worker.sessionScopeVariables().split(",");
            for(String workerSessionVar:workerSessionVars) {
                workerSessionScopeVariables.put(workerSessionVar, FacesUtil.getFromSession(workerSessionVar));
            }
        }        
            
    }
    
    /**
     * Puts back the stored scope variables to the related scope.
     */
    public void putScopeVariablesToBack() {
        if(processScopeVariables != null) {
            Iterator itr = processScopeVariables.keySet().iterator();
            while(itr.hasNext()) {
                String key = (String)itr.next();
                Object value = processScopeVariables.get(key);
                FacesUtil.getProcessScope().put(key, value);
            }
        }
        
        if(workerProcessScopeVariables != null) {
            Iterator itr = workerProcessScopeVariables.keySet().iterator();
            while(itr.hasNext()) {
                String key = (String)itr.next();
                Object value = workerProcessScopeVariables.get(key);
                FacesUtil.getProcessScope().put(key, value);
            }
        }
        
        if(workerSessionScopeVariables != null) {
            Iterator itr = workerSessionScopeVariables.keySet().iterator();
            while(itr.hasNext()) {
                String key = (String)itr.next();
                Object value = workerSessionScopeVariables.get(key);
                FacesUtil.getSessionScope().put(key, value);
            }
        }
    }
    
    /**
     * Puts the page's backing bean(s) to the session scope.
     * 
     * i.e. If the navigation goes to the generic search and if the generic search page contains a backing bean that was
     * stored before, that backing bean is put to the session scope in order to be used after the navigation. (This is used
     * for the sake of seeing the previous search results that were done before in a search page.)
     * 
     */
    public void putBackingBeansToSessionScope() {
        // First look if page has a backing bean stored in it. If it is, then put that backing bean into the session scope.

        if(this.getBackingBean() != null && this.getBackingBeanName() != null) {
//            // TODO Kemal: The below if statement is temporary. If the multiadvancedsearch is available in the generic search, when we return back to 
//            // this search page and want to navigate from search page again, it resets the backinggenericsearch and the page behaves strangely.
//            // In order to resolve that problem, this if statement is put. The problem will be handled in a different way later.
//            if(this.getBackingBean() instanceof BackingGenericSearch) {
//                if(((BackingGenericSearch)this.getBackingBean()).isMultiAdvancedSearchAvailable()) {
//                    return;
//                }
//            }
            // inform the backing beans about this operation by putting a variable to the request scope which will be used
            // in the stored backing bean.
            FacesUtil.storeOnRequestScope(WebConstants.RequestVariable.PUT_BACKING_BEANS_BACK, true);
            FacesUtil.storeOnSession(this.getBackingBeanName(), this.getBackingBean());
        }
        // If the page contains more than one backing bean, then put all the backing beans into the session scope.
        else if(this.getBackingBeans() != null) {
            Iterator itr = this.getBackingBeans().keySet().iterator();
            while(itr.hasNext()) {
                String backingBeanName = (String)itr.next();
                BackingBase backingBean = (BackingBase)this.getBackingBeans().get(backingBeanName);
                FacesUtil.storeOnSession(backingBeanName, backingBean);
            }
        }
    }
    
    /**
     * Check if the view id is existing in the session worker. If it exists, then the backing bean should stay in the session scope, return false.
     * If this session page is forced to end its state, don't look at anything and return true.
     * @param viewId
     * @return
     */
    public boolean isEndState(String viewId) {
        if(isForcedEndState()){
            return true;
        }
        boolean result = true;       
        Object jsfManagedBean = backingBean;
        if(jsfManagedBean == null){
            return false;
        }else{
            SessionWorker worker = 
                jsfManagedBean.getClass().getAnnotation(SessionWorker.class);
            ArrayList<String> chaining = createLinks(worker);
            for (int i = 0; i < chaining.size(); i++) {
                String toViewId = chaining.get(i).trim();
                int indexOfAll = toViewId.indexOf("*");
                String compareTo = viewId;
                if (indexOfAll != -1 && 
                    viewId.length() >= indexOfAll) {
    
                    compareTo = 
                            viewId.substring(0, indexOfAll);
                    compareTo = compareTo + "*.jspx";
                }
                if (compareTo != null && compareTo.equalsIgnoreCase(toViewId)) {
                    result = false;
                } else {
                    if (viewId != null && (viewId.equalsIgnoreCase(WebConstants.ViewId.ADF_DIALOG_VIEW_ID) ||
                        viewId.equalsIgnoreCase(WebConstants.ViewId.CONFIGURATION_ERROR_VIEW_ID)) 
                        ) {
                        result = false;
                    }
                }
            }

             return result;
        }
    }
    
    private ArrayList<String> createLinks(SessionWorker worker) {
        ArrayList<String> chaining = new ArrayList<String>();
        String[] links = worker.stayAlive().split(",");
        ;
        chaining.addAll(new ArrayList(Arrays.asList(links)));
        return chaining;
    }
    
    public void endState() {
        FacesUtil.removeFromSession(getBackingBeanName());
    }
    
    public void cleanUpWorkerProcessScopeVariables() {
        if(workerProcessScopeVariables != null) 
            FacesUtil.removeFromProcessScope((String[])workerProcessScopeVariables.keySet().toArray(new String[]{}));
    }
    
    public void cleanUpWorkerScopeVariables() {
        cleanUpWorkerProcessScopeVariables();
        cleanUpWorkerSessionScopeVariables();
    }
    
    public void cleanUpProcessScopeVariables() {
        if(processScopeVariables != null) 
            FacesUtil.removeFromProcessScope((String[])processScopeVariables.keySet().toArray(new String[]{}));
    }
    
    public void cleanUpAllScopeVariables() {
        cleanUpWorkerScopeVariables();
        cleanUpProcessScopeVariables();
    }
    
     public void cleanUpWorkerSessionScopeVariables() {
        if(workerSessionScopeVariables != null) 
            FacesUtil.removeFromSession((String[])workerSessionScopeVariables.keySet().toArray(new String[]{}));
     }

    public void setForcedEndState(boolean forcedEndState) {
        this.forcedEndState = forcedEndState;
    }

    public boolean isForcedEndState() {
        return forcedEndState;
    }
}
