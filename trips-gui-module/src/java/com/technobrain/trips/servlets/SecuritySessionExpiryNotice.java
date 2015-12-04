package com.technobrain.trips.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecuritySessionExpiryNotice extends HttpServlet {

    
    protected void doPost(HttpServletRequest httpServletRequest, 
                          HttpServletResponse httpServletResponse) throws ServletException, IOException {
       
    }

    protected void doGet(HttpServletRequest httpServletRequest, 
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
        
        
//        
//        /*
//         * Construct the url to redirect to
//         */
//        String url = httpServletRequest.isSecure() ? "https://" : "http://" +
//        httpServletRequest.getServerName() + ":" +
//        httpServletRequest.getServerPort() +
//        httpServletRequest.getContextPath()+
//        "/faces/login/LogOut.jspx";
        
//        httpServletRequest.getSession(false).invalidate();
        /*
         * Create the response for session timeout
         */
//        httpServletResponse.setContentType("text/html;");
//        StringBuffer html = new StringBuffer("");
//        html.append("<script type=\"text/javascript\">" + 
//            "alert('Your session has expired');"+
//            "window.opener='x';window.close();"+
//            "</script>");
//        httpServletResponse.getWriter().write(html.toString());
       
     //   httpServletRequest.getSession(false).invalidate(); 
       httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/LogOutSession");
       
       //
    }

}
