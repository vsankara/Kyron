package com.technobrain.trips.compliance.service;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBRemote;
import com.technobrain.trips.core.service.FacadeBean;

import java.io.Serializable;

import java.util.Date;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.NoSuchObjectLocalException;
import javax.ejb.Timer;
import javax.ejb.TimerService;

public abstract class AbstractTimer extends FacadeBean {
    
    @Resource
    TimerService timerService;
    
    @EJB
    private  RefCodeAssemblerSessionEJBLocal ref;
    
    public Timer createTimer(String name, long intervalDuration) {
        log.debug("Abstract Timer: start timer for " + name);
        return timerService.createTimer(new Date(System.currentTimeMillis()+intervalDuration), intervalDuration, name);
    }
    
    public boolean killTimer(Timer _timer) {
        boolean flag = false;
        Serializable name = null;
        try {
            name = _timer.getInfo();
            _timer.cancel();
            flag = true;
        } catch (NullPointerException _ex) {
            log.error(_ex.getLocalizedMessage(), _ex);
        } catch (IllegalStateException _ex) {
            log.error(_ex.getLocalizedMessage(), _ex);
        } catch (NoSuchObjectLocalException _ex) {
            log.error(_ex.getLocalizedMessage(), _ex);
        } catch (EJBException _ex) {
            log.error(_ex.getLocalizedMessage(), _ex);
        }
/*        if (flag)
            log.debug("-> Removing old timer : " + name);
        else 
            log.debug("-> Old Timer can not be removed: " + name);*/
        return flag;
    }
    
    public boolean removeTimer(Timer _timer) {
        return killTimer(_timer);
    }
    
    private long getInterval(String interval) {
        return Long.valueOf(ref.findSystemParameter(interval));
    }
    
    protected  Timer replaceTimer(Timer timer, String interval) {
        Serializable name = timer.getInfo();
        long schIntervalDuration = getInterval(interval);
//        log.debug("++++ Re-initialize: Auto-Scheduler Timers: " + timer.getInfo()); 
        removeTimer(timer);
        Timer genericTimer = timerService.createTimer(new Date(System.currentTimeMillis()+schIntervalDuration), schIntervalDuration, name);
//        log.debug("++++ Re-initialize: Completed");
        return genericTimer;
    }
    
}
