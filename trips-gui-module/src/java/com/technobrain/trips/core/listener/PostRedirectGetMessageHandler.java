package com.technobrain.trips.core.listener;

import com.technobrain.trips.util.WebConstants;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import javax.servlet.http.HttpServletRequest;

/**
 * This is a phase listener that handles messages. eg confirmation message
 * TODO: Revisit after demo
 * @since $Date: 8/18/2009 5:14:45 AM$
 * @version $Revision: 4$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2 etis.bir.gov.ph1.2.1.0     8/18/2009 5:14:45 AM   Howard Hill  
 *         checked in core changes
 * $
 */

public class PostRedirectGetMessageHandler implements PhaseListener{
    public PostRedirectGetMessageHandler() {
    }

    public void afterPhase(PhaseEvent phaseEvent) {
        String viewId = phaseEvent.getFacesContext().getViewRoot().getViewId();
        postGetRedirectMessageHandler(phaseEvent);
     }

    public void beforePhase(PhaseEvent phaseEvent) {
        
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    /**
     * Gets message(Confirmation message) and store it on to a session variable if the message 
     * has 'confirmation' as client ID
     * @param phaseEvent
     */
    private void postGetRedirectMessageHandler(PhaseEvent phaseEvent) {
        FacesContext context = phaseEvent.getFacesContext();
        Iterator i = context.getClientIdsWithMessages();
        if(null == i){
            //do nothing
        }else{
            // sometimes the iterator contains more than one element and the 
            // clientid of the first element is null and the last element in the
            // iteration contains the actual confirmation message. So whenever we
            // find a client id which is the confirmation, we put it to the session map.
            while(i.hasNext()){     
                String clientId = (String)i.next();
                if(clientId == null) {
                    continue;   
                }
                if(clientId.equalsIgnoreCase(WebConstants.Messages.CONFIRMATION)){
                    context.getExternalContext().getSessionMap().put(WebConstants.Messages.CONFIRMATION_MESSAGE,
                        context.getMessages(clientId));
                }
               
            }
        }
    }
    
}
