package com.technobrain.trips.security;



import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import oracle.adf.share.http.ServletADFContext;

import org.apache.log4j.Logger;


/**
 * � Crown Agents 2008
 *
 * 
 * @since       $Date: 8/21/2009 12:23:53 AM$
 * @version     $Revision: 6$
 * @author      $Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2 etis.bir.gov.ph1.4.1.0     8/21/2009 12:23:53 AM  Howard Hill  
 *         updated to bring to a stable point
 * $
 */
public class SecuritySessionExpiryFilter implements Filter {
    private FilterConfig _filterConfig = null;
    private Logger logger = Logger.getLogger(SecuritySessionExpiryFilter.class);
    
    public static final String KICK_THE_USER = "kickTheUser"; 
    
    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, 
                         FilterChain chain) throws  
                                                   ServletException {
        
                
        HttpServletRequest httpServletRequest = ((HttpServletRequest)request);
        HttpServletResponse httpServletResponse = 
            ((HttpServletResponse)response);
      
      
        String requestedSession = httpServletRequest.getRequestedSessionId();
        String currentWebSession = httpServletRequest.getSession().getId();
        boolean sessionOk = 
            currentWebSession.equalsIgnoreCase(requestedSession);

        /*
         * get the logged in user, if null redirect to the home page because java sso occured
         * or an unauthorized attemp on the requested url
         */
//        UserAccount userAccount = 
//            (UserAccount)httpServletRequest.getSession(false).getAttribute(UserAccount.class.getName());
//        
//        boolean isFromPortal = false;//null == httpServletRequest.getParameter("IS_FROM_PORTAL") ? false : Boolean.valueOf( httpServletRequest.getParameter("IS_FROM_PORTAL"));
        
//        if (!isFromPortal && (null == userAccount && !isDefaultResource(httpServletRequest)) 
//            ||  !httpServletRequest.isUserInRole(SecurityControlDelegate.USER_GROUP)) {
//            String pageUrl = "/ExpiryNotice";
//            String url = 
//                request.isSecure() ? "https://" : "http://" + request.getServerName() + 
//                ":" + request.getServerPort() + 
//                httpServletRequest.getContextPath() + pageUrl;
//            try {
//                httpServletResponse.sendRedirect(url);
//            } catch (IOException e) {
//                logger.error("Error occured with request : " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest) ,e);
//            }
//            
//            if(logger.isDebugEnabled())
//                logger.debug("Session time out invoked() for url " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest));
//                
//            return;
//        }
        
        HttpSession session = httpServletRequest.getSession(false);

        if (session == null &&
            httpServletRequest.getRequestedSessionId() != null &&
            !httpServletRequest.isRequestedSessionIdValid())
        {    
            String targetUrl = httpServletRequest.getContextPath() + "/ExpiryNotice";
            try {
                httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL(targetUrl));
            } catch (IOException e) {
                logger.error("Error occured with request : " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest) ,e);
            }
            
            if(logger.isDebugEnabled())
                logger.debug("Session time out invoked() for url " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest));
                
            return;
        }
        
//        if (session != null && Constants.TRUE.equals(session.getAttribute(KICK_THE_USER))){
//        	try {
//        		logger.info("user : " + getUser(httpServletRequest) + " was kicked off by admin ...");
//				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/LogOutSession");
//			} catch (IOException e) {
//				logger.error("Error occured with kickTheUser request : " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest) ,e);
//			}
//        }
//	      if (session != null && securityControlDelegate.isUserKickedOut(getUser(httpServletRequest))){
//		    	try {
//		    		logger.info("user : " + getUser(httpServletRequest) + " was kicked off by admin ...");
//					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/LogOutSession");
//				} catch (IOException e) {
//					logger.error("Error occured with kickTheUser request : " + httpServletRequest.getRequestURL() + " for user " + getUser(httpServletRequest) ,e);
//				}
//		  }        
        
        /*
         * START ADF PATCH 
         */
        
//        try {
//                ServletADFContext.initThreadContext(_filterConfig.getServletContext(), request, response);
//                chain.doFilter(request, response);
//        } catch (IOException e) {
//            logger.error("Error occured with request : " + httpServletRequest.getRequestURL() ,e);
//        } finally {
//                ServletADFContext.resetThreadContext();
//        }
        
        
        httpServletResponse.setHeader("CACHE-CONTROL", "no-cache, max-age=0, must-revalidate, no-store");
        httpServletResponse.setHeader("EXPIRES", "0");
        httpServletResponse.setHeader("PRAGMA", "NO-CACHE");


        /*
         * END ADF PATCH 
         */
        
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    private boolean isDefaultResource(HttpServletRequest httpServletRequest) {
        final String URI = httpServletRequest.getRequestURI();
        boolean isDefaultResource = false;
        if ((-1 == URI.indexOf("index.jspx") ? false : true) || 
            (-1 == URI.indexOf("LogOut.jspx") ? false : true) ||
            (-1 == URI.indexOf("Welcome.jspx") ? false : true) 
           ) {
            isDefaultResource = true;

        }
        return isDefaultResource;
    }
    
    /**
     * Gets the user who made the request
     * @param httpServletRequest
     */
    private String getUser(HttpServletRequest httpServletRequest) {
        return null == httpServletRequest.getUserPrincipal() ? null : httpServletRequest.getUserPrincipal().getName();
    }
}
