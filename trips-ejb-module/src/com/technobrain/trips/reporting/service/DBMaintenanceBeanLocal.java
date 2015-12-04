package com.technobrain.trips.reporting.service;

import javax.ejb.Local;
import org.quartz.Job;

@Local
public interface DBMaintenanceBeanLocal extends Job {

    boolean isRunning();
    
}
