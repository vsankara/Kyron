package com.technobrain.trips.util;

import com.technobrain.trips.common.exceptions.TripsValidationException;
import com.technobrain.trips.core.message.SystemMessage;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.bpel.services.workflow.WorkflowException;

import org.apache.log4j.Logger;

public class ExceptionParser {
    public static final Logger log = Logger.getLogger(ExceptionParser.class);
    public ExceptionParser() {
    }
    
    public static void parseError(Exception e) {
        addFacesErrorMessage(null, e);
        log.error(e.getLocalizedMessage(), e);
    }
    
    public static void addFacesErrorMessage(String msg, Exception ex) {
        String description = null;
        
        if (ex instanceof WorkflowException) {
            if (ex.getCause() != null && ex.getCause() instanceof WorkflowException) {
                description = ((WorkflowException)ex).getErrorCode() +": " + ((WorkflowException)ex.getCause()).getDescription();
            }
            else {
                description = ((WorkflowException)ex).getErrorCode() +
                                                            ": " + ((WorkflowException)ex).getDescription();
            }
        }
        else {
            description = ex.getMessage();
        }
        FacesMessage fm = FacesUtil.createFacesMessage(FacesMessage.SEVERITY_ERROR, msg, description);
        FacesUtil.getFacesContext().addMessage(FacesUtil.getRootViewComponentId(), fm);
    }
    
    public static void parseScriptErrorMessageToGUI(Object message, String label, Exception e) {
    	parseScriptErrorMessageToGUI(message, label, null, e);
    }
    
    public static void parseScriptErrorMessageToGUI(Object message, String label, String tabLabel, Exception e) {
    	 String[] params = null;
    	 if(tabLabel != null){
    		 params = new String[2];
             params[1] = label;
             params[0] = tabLabel;
    	 } else if(label != null && e != null) {
             params = new String[2];
             String errMessage = e.getCause().getClass().getSimpleName();
             if(e.getMessage() != null) {
                 errMessage += ": " + e.getMessage();
             }
             params[1] = errMessage;
             params[0] = label;
         } else if(label != null) {
             params = new String[1];
             params[0] = label;
         } else if(e != null) {
             params = new String[1];
             String errMessage = e.getCause().getClass().getSimpleName();
             if(e.getMessage() != null) {
                 errMessage += ": " + e.getMessage();
             }
             params[0] = errMessage;
         }
         if(message instanceof String) {
             FacesUtil.addFacesErrorMessage((String)message, params);
         }else if(message instanceof List) {
             List<String> l = (List<String>)message;
             FacesUtil.concatFacesErrorMessage(l, params);                
         }else if(message instanceof SystemMessage){
             FacesUtil.addFacesErrorMessage((SystemMessage)message);
             
         }
    }

   
    public static void parseScriptErrorMessageToGUIForFF(Object message, String label, Exception e) {
            String[] params = null;
            if(label != null && e != null) {
                params = new String[2];
                String errMessage = e.getCause().getClass().getSimpleName();
                if(e.getMessage() != null) {
                    errMessage += ": " + e.getMessage();
                }
                params[1] = errMessage;
                params[0] = label;
            }
            else if(label != null) {
                params = new String[1];
                params[0] = label;
            }
            else if(e != null) {
                params = new String[1];
                String errMessage = e.getCause().getClass().getSimpleName();
                if(e.getMessage() != null) {
                    errMessage += ": " + e.getMessage();
                }
                params[0] = errMessage;
            }
            if(message instanceof String) {
                FacesUtil.addFacesErrorMessageForFF((String)message, params);
            }else if(message instanceof List) {
                List<String> l = (List<String>)message;
                FacesUtil.concatFacesErrorMessageForFF(l, params);                
            }else if(message instanceof SystemMessage){
                FacesUtil.addFacesErrorMessageForFF((SystemMessage)message);
                
            }
    }
    
    public static void addFacesErrorMessage(TripsValidationException ex) {
        if(ex.getMessage() != null) {
            FacesContext ctx = FacesUtil.getFacesContext();
              FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                FacesUtil.getStringFromBundle(ex.getMessage(), ex.getMessageParameters()) ,null);
            ctx.addMessage(FacesUtil.getRootViewComponentId(),fm);            
        }
    }
}
