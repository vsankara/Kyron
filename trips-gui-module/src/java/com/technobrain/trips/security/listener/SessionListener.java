package com.technobrain.trips.security.listener;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {
  
  private int sessionCount;
  
  public static final Logger log = Logger.getLogger(SessionListener.class);  
  
    
  public SessionListener() {
    this.sessionCount = 0;
  }

  public void sessionCreated(HttpSessionEvent se) {
     
    HttpSession session = se.getSession();
//    session.setMaxInactiveInterval(60);
    
//    UserAccount ua =  (UserAccount)session.getAttribute(UserAccount.class.getName());
//    String usrId = null;
//    if(null != ua){
//        new SecurityControlDelegate().logNewSession(session,ua.getUserName(),null);
//    }
  
    synchronized (this) {
      sessionCount++;
    }
    String id = session.getId();
    Timestamp now = new Timestamp(System.currentTimeMillis());
    String message = new StringBuffer("New Session created on ").append(
        now.toString()).append("\nID: ").append(id).append("\n")
        .append("There are now ").append("" + sessionCount).append(
            " live sessions in the application.").toString();
   
//     new SecurityControlDelegate().logInUser(id);   
    
      Enumeration attributeNames = session.getAttributeNames();
      while (attributeNames.hasMoreElements()) {
         String name = attributeNames.nextElement().toString();
         String value = session.getAttribute(name).toString();
         if(log.isDebugEnabled())log.debug(name + " = " + value + "<br>");
      }
      
      
    if(log.isDebugEnabled())log.debug(message);
  }

  public void sessionDestroyed(HttpSessionEvent se) {

    HttpSession session = se.getSession();
    String id = session.getId();
    
//    new SecurityControlDelegate().logSession(session,se);
    
    synchronized (this) {
      --sessionCount;
    }
    String message = new StringBuffer("Session destroyed"
        + "\nValue of destroyed session ID is").append("" + id).append(
        "\n").append("There are now ").append("" + sessionCount)
        .append(" live sessions in the application.").toString();
    if(log.isDebugEnabled())log.debug(message);
    
//      new SecurityControlDelegate().logOutUser(id,);	
    
  }

	
	private String getUser(HttpServletRequest httpServletRequest) {
        return null == httpServletRequest.getUserPrincipal() ? null : httpServletRequest.getUserPrincipal().getName();
    }
  
  	
}
