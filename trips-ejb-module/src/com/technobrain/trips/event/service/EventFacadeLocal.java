package com.technobrain.trips.event.service;

import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.event.model.EvtEvent;


import javax.ejb.Local;

@Local
public interface EventFacadeLocal {

    public <T extends InputType> Long persistEvent(String eventType, T inputType);

    public Long persistEvent(EvtEvent evt, Long docId);
}
