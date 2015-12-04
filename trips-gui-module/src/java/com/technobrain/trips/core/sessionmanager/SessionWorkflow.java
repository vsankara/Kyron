package com.technobrain.trips.core.sessionmanager;

import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.core.sessionmanager.backing.BackingSessionManager;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;


import org.apache.log4j.Logger;


/**
 * NOT USED ANYMORE.
 * TODO: WILL BE DELETED
 */
/**
 * @author hhill
 */
public class SessionWorkflow implements Serializable {
    
    public static final Logger log = Logger.getLogger(BackingSessionManager.class);
    
    private String backingBeanName;
    private String[] processScopeVariables;
    private String[] sessionScopeVariables;

    private SessionState startState = new SessionState();
    private SessionState previousState;
    private SessionState currentState;
    private boolean forcedEndState;
    
    public SessionWorkflow() {

    }

    public SessionWorkflow(String backingBeanName) {
        setBackingBeanName(backingBeanName);
    }

    public void setStartState(SessionState startState) {
        this.startState = startState;
    }

    public SessionState getStartState() {
        return startState;
    }

    public void setPreviousState(SessionState previousState) {
        this.previousState = previousState;
    }

    public SessionState getPreviousState() {
        return previousState;
    }

    public SessionState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String viewId) {
        if (currentState != null) {
            if (previousState == null) {
                previousState = new SessionState();
                previousState.setViewId(viewId);
            } else if (!currentState.getViewId().equalsIgnoreCase(viewId)) {
                previousState.setViewId(currentState.getViewId());
            }

            currentState.setViewId(viewId);
           
        } else {
            currentState = new SessionState();
            currentState.setViewId(viewId);          
        }
    }

    public boolean isEndState() {
        if(isForcedEndState()){
            return true;
        }
        boolean result = true;

        Object jsfManagedBean = 
            FacesUtil.getManagedBeanValue(getBackingBeanName());
        if(jsfManagedBean == null){
            return false;
        }else{
            SessionWorker worker = 
                jsfManagedBean.getClass().getAnnotation(SessionWorker.class);
            ArrayList<String> chaining = createLinks(worker);
            for (int i = 0; i < chaining.size(); i++) {
                String toViewId = chaining.get(i).trim();
                int indexOfAll = toViewId.indexOf("*");
                String compareTo = getCurrentState().getViewId();
                if (indexOfAll != -1 && 
                    getCurrentState().getViewId().length() >= indexOfAll) {
    
                    compareTo = 
                            getCurrentState().getViewId().substring(0, indexOfAll);
                    compareTo = compareTo + "*.jspx";
                }
                if (compareTo.equalsIgnoreCase(toViewId)) {
                    result = false;
                } else {
                    if (getCurrentState().getViewId().equalsIgnoreCase(WebConstants.ViewId.ADF_DIALOG_VIEW_ID) ||
                        getCurrentState().getViewId().equalsIgnoreCase(WebConstants.ViewId.CONFIGURATION_ERROR_VIEW_ID) 
                        ) {
                        result = false;
                    } 
                }
            }

             return result;
        }
    }

    public void endState() {
        FacesUtil.removeFromSession(getBackingBeanName());
    }


    private ArrayList<String> createLinks(SessionWorker worker) {
        ArrayList<String> chaining = new ArrayList<String>();
        chaining.add(getStartState().getViewId());
        String[] links = worker.stayAlive().split(",");
        ;
        chaining.addAll(new ArrayList(Arrays.asList(links)));
        return chaining;
    }

    public void setBackingBeanName(String backingBeanName) {
        this.backingBeanName = backingBeanName;
    }

    public String getBackingBeanName() {
        return backingBeanName;
    }

    public void cleanUpProcessScopeVariables() {
        FacesUtil.removeFromProcessScope(processScopeVariables);
    }

    public void cleanUpSessionScopeVariables() {
        FacesUtil.removeFromSession(sessionScopeVariables);
    }

    public void setProcessScopeVariables(String[] processScopeVariables) {
        this.processScopeVariables = processScopeVariables;
    }

    public String[] getProcessScopeVariables() {
        return processScopeVariables;
    }

    public void setSessionScopeVariables(String[] sessionScopeVariables) {
        this.sessionScopeVariables = sessionScopeVariables;
    }

    public String[] getSessionScopeVariables() {
        return sessionScopeVariables;
    }
    /**
     * When the session manager is cleaning up the workflow
     * <p>
     * This method allows for the session manager to end it state 
     * @param forcedEndState
     */
    public void setForcedEndState(boolean forcedEndState) {
        this.forcedEndState = forcedEndState;
    }

    public boolean isForcedEndState() {
        return forcedEndState;
    }
}
