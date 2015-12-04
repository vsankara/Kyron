package com.technobrain.trips.security.listener;

import com.technobrain.trips.util.FacesUtil;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * � Crown Agents 2006
 * <p>
 * Checks to ensure the user security is enforced
 * <p>
 * Also handles session tracking, etc
 * @since $Date: 12/18/2009 7:39:40 PM$
 * @version $Revision: 6$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2 etis.bir.gov.ph1.4.1.0     12/18/2009 7:39:40 PM  Howard Hill  
 *         updated as per merge with Registration UAT branch dec 19
 * $
 */
public class SecurityCheckerPhaseListener implements PhaseListener{
    static final Logger log = Logger.getLogger(SecurityCheckerPhaseListener.class);
   
    public void afterPhase(PhaseEvent phaseEvent) {
       sessionTimeOutChecker(phaseEvent.getFacesContext());
    }

    public void beforePhase(PhaseEvent phaseEvent) {
       sessionTimeOutChecker(phaseEvent.getFacesContext());
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    /**
     * @param facesContext
     * @return true if the current view id is a login page otherwise false
     */
    private boolean isLoginPages(FacesContext facesContext) {
        boolean isLoginPages = false;
        final String viewId = facesContext.getViewRoot().getViewId();
        isLoginPages =  viewId.endsWith("login.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.endsWith("index.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.endsWith("Welcome.jspx"); if(isLoginPages)return true;
        isLoginPages =  viewId.contains("LogOut.jspx"); if(isLoginPages)return true;
        
         return isLoginPages;
    }
    
    /**
     * 
     * @param facesContext
     */
    private void sessionTimeOutChecker(FacesContext facesContext) {
        ExternalContext ectx = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
        HttpServletRequest request = (HttpServletRequest)ectx.getRequest();
        HttpSession session = request.getSession(false);
//        UserAccount userAccount = 
//            (UserAccount)request.getSession(false).getAttribute(UserAccount.class.getName());
        
        String targetUrl = request.getContextPath() + "/ExpiryNotice";
        
//        if(null == userAccount && !isLoginPages(facesContext)){
//            try {
//                FacesUtil.getFacesContext().getExternalContext().redirect(targetUrl);
//                return;
//            } catch (IOException e) {
//                log.error(e.getLocalizedMessage(), e);
//            }
//        }
        
        if (session == null &&
            request.getRequestedSessionId() != null &&
            !request.isRequestedSessionIdValid())
        {    
            
            try {
                response.sendRedirect(response.encodeRedirectURL(targetUrl));
            } catch (IOException e) {
                 log.error(e.getLocalizedMessage(), e);
            }
            return;
        }
        
//        if (new SecurityControlDelegate().isSessionTerminated(request.getSession(false),request.getRemoteAddr())){
//            if(null == userAccount && !isLoginPages(facesContext) ){
//                //NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
//                //nh.handleNavigation(facesContext, null, "sessionTimeOut");
//                try {
//                    response.sendRedirect(response.encodeRedirectURL(targetUrl));
//                } catch (IOException e) {
//                     log.error(e.getLocalizedMessage(), e);
//                }
//            }
//        }
    }
}
