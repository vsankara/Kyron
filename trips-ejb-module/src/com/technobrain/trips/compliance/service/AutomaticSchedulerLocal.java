package com.technobrain.trips.compliance.service;

import javax.ejb.Local;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;

import org.quartz.Job;

@Local
public interface AutomaticSchedulerLocal extends Job {

    boolean isRunning();
}
