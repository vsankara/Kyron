package com.technobrain.trips.application.service;

import com.technobrain.trips.core.service.FacadeLocal;

import com.technobrain.trips.application.message.EntityAppInputType;
import com.technobrain.trips.application.message.RevenueTypeAppInputType;

import javax.ejb.Local;

@Local
public interface ApplicationFacadeLocal extends FacadeLocal {
    
    public EntityAppInputType findEntityAppInputType(Long id);
    
    public RevenueTypeAppInputType findRevenueAppInputType(Long id);
}
