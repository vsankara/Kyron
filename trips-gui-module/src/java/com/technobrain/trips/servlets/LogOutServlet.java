package com.technobrain.trips.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import oracle.security.jazn.sso.util.JSSOUtil;

public class LogOutServlet extends HttpServlet {
    static final Logger log = Logger.getLogger(LogOutServlet.class);

    
    protected void doPost(HttpServletRequest httpServletRequest, 
                          HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest,httpServletResponse);
    }

    protected void doGet(HttpServletRequest httpServletRequest, 
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
        
        
        ssoLogoutUser(httpServletRequest,httpServletResponse,null);
        
    }
    
    /**
     * Invalidates the user Http Session
     */
    public static void ssoLogoutUser(HttpServletRequest request, 
                                     HttpServletResponse response, 
                                     String pageUrl) {
        
        if (pageUrl == null) {
            pageUrl = "/faces/login/login.jspx";
        }
        
        String url = 
            request.isSecure() ? "https://" : "http://" + request.getServerName() + 
            ":" + request.getServerPort() + request.getContextPath() + pageUrl;
        
        try {
            if(null != request.getSession(false)){
                request.getSession(false).invalidate();
            }
//            JSSOUtil.logout(response, url);
            response.sendRedirect(url);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        
    }


}
