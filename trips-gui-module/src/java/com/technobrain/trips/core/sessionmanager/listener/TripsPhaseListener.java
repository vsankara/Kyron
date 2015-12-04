package com.technobrain.trips.core.sessionmanager.listener;

import com.technobrain.trips.core.sessionmanager.SessionPage;
import com.technobrain.trips.core.sessionmanager.backing.BackingSessionManager;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * � Crown Agents 2006
 * <p>
 * Manages the trips web application page caching and session objects
 * @since $Date: 8/24/2009 12:34:03 AM$
 * @version $Revision: 17$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  17   TRIPS2 etis.bir.gov.ph1.15.1.0    8/24/2009 12:34:03 AM  Howard Hill  
 *         updated for UAT test build
 * $
 */
public class TripsPhaseListener implements PhaseListener {

    public static final Logger log = Logger.getLogger(TripsPhaseListener.class);
    
    public TripsPhaseListener() {
    }

    public void afterPhase(PhaseEvent phaseEvent) {
        
        /*
         * Gets the backing session manager for the workflow
         */
        BackingSessionManager sessionManager = 
        (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
        // tracks the session pages that can be rubbish. If any one of them is in end state, clear its state and remove it.
        try {
            for(SessionPage rubbishPage:sessionManager.getRubbishPages())
                sessionManager.trackEndState(rubbishPage, FacesUtil.getRootViewId());
            sessionManager.getRubbishPages().clear();
            	// TODO (vedat) this throws ConcurrentModificationException !!!
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        // mark the response as uncacheable...
        HttpServletResponse response = 
            (HttpServletResponse)ctx.getExternalContext().getResponse();
       /* 
        Web pages must use adf blocking on buttons */  
//           response.setHeader("Cache-Control", 
//                   "no-cache, max-age=0, must-revalidate, no-store");

           
       
        if(phaseEvent.getFacesContext().getViewRoot().getViewId().contains(WebConstants.ViewId.WELCOME_VIEW_ID)) {
            // if we are navigating to the home page, then there is no need for 
            // any scope variable or storage variable, we should clear everything.
            BackingSessionManager backingSessionManager = 
                (BackingSessionManager)FacesUtil.getFromSession(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
            
            if(null != backingSessionManager){
                backingSessionManager.cleanUpSystem();
            }
            
            // check for any unread activity log.
           
        }
        BackingSessionManager sessionManager = 
        (BackingSessionManager)FacesUtil.getManagedBeanValue(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);                           
        // add the flow to the session.
        if(sessionManager!=null){
            sessionManager.addFlow(FacesUtil.getRootViewId());    
        }
        
    }

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
