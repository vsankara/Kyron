package com.technobrain.trips.compliance.service;

import java.util.Timer;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TimerService;

@Stateless(name = "TimerKillService", mappedName = "test-Project1-TimerServiceBean")
@Local
public class TimerServiceBean implements TimerServiceLocal {

    @Resource 
    private TimerService timerService;
    
    public void killTimers() {
        for (Object obj :timerService.getTimers()) {
            Timer timer = (Timer) obj;
            timer.cancel();
        }
        timerService.getTimers().clear();
    }

}
