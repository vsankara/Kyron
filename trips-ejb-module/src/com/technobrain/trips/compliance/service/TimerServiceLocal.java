package com.technobrain.trips.compliance.service;

import javax.ejb.Local;

@Local
public interface TimerServiceLocal {
    public void killTimers();
}
