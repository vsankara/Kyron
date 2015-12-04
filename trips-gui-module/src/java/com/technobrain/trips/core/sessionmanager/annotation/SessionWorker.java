package com.technobrain.trips.core.sessionmanager.annotation;

import com.technobrain.trips.util.WebConstants;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* � Crown Agents 2007 
* <br>
* A Session Worker is assigned jobs to work to keep alive. These jobs
* are viewIds for a jsf managed Bean. <br>
* <br> The worker is controlled by the session manager which decises when no more work is to be done.
* <b>Hence when the session is to be cleanedUp</b>
* 
* @since $Date: 1/7/2010 5:13:07 AM$
* @version $Revision: 5$
* @author $Author: Linesh Mali$
* 
* $Log[1]:
*  5    TRIPS2 etis.bir.gov.ph1.3.1.0     1/7/2010 5:13:07 AM    Linesh Mali   
*        Flexible forms script operations moved to common and ejb modules
* $
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SessionWorker {
    
    java.lang.String sessionManager() default"backingSessionManager";
    
    java.lang.String managedBeanName();
    
    boolean absoluteBackingBean() default false;

    java.lang.String stayAlive() ; //TODO: Rename to flow or steps
    
    java.lang.String preCondition() default "/index.jspx";
    
    java.lang.String postCondition() default "/genericConfirmationPage.jspx";
    
    java.lang.String processScopeVariables() default "";
    
    java.lang.String sessionScopeVariables() default "";
}
