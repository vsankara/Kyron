package com.technobrain.trips.security;

import javax.servlet.ServletContext;

//import oracle.security.jazn.oc4j.JAZNUserManager;


/**
 * This class implements the JAASManager interface, which has methods for

 * adding/removing users with roles to the JAAS provider system.
 * The implementation for these methods adds user and role data to
 * jazn-data.xml, the repository for user name, password and roles.
 * The implementation can be changed depending on the repository.eg LDAP,RDBMS etc
 * 
 */
public class OC4JJAASManager {


    // user manager instance
//    private static JAZNUserManager  userMgr;
    // servlet context, the user manager is stored in the context by OC4J
    private OC4JJAASManager oc4jJAASManager;
    
  
    /**
     * This method casts the initParam to ServletContext and extracts 
     * the JAZNUserManager instance from this context
     * @param initParam
     */
    public static OC4JJAASManager init(Object initParam) {
        ServletContext ctx = (ServletContext)initParam;
//        userMgr = (JAZNUserManager)ctx.getAttribute("xml.manager");
       
        return new OC4JJAASManager();
    }

//    public JAZNUserManager getUserMgr() {
//        return userMgr;
//    }

}
