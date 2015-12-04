package com.technobrain.trips.compliance.service;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;

import org.apache.log4j.Logger;

@Stateless(mappedName = "test-Project1-TimerSessionBean")
public class TimerSessionBean implements SessionBean, TimedObject {
    public static final Logger log = Logger.getLogger(TimerSessionBean.class);
    private SessionContext context;

    public Timer myCreateTimer(long intervalDuration) {

       log.debug
            ("TimerSessionBean: start createTimer ");
        TimerService timerService = context.getTimerService();
        Timer timer = 
            timerService.createTimer(intervalDuration, 
          "created timer");
          return timer;
   }

    public void ejbTimeout(Timer timer) {
  
        log.debug("TimerSessionBean: ejbTimeout ");
    }

    public void setSessionContext(SessionContext sc) {
        log.debug("TimerSessionBean:setSessionContext");
        context = sc;
     }

     public void ejbCreate() {
        log.debug("TimerSessionBean: ejbCreate");
     }

     public TimerSessionBean() {}
     public void ejbRemove() {}
     public void ejbActivate() {}
     public void ejbPassivate() {}

}  