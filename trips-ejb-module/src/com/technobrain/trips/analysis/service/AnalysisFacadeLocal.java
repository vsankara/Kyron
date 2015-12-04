package com.technobrain.trips.analysis.service;


import com.technobrain.trips.core.message.RegimeAccountType;
import javax.ejb.Local;


@Local
public interface AnalysisFacadeLocal {   

    public RegimeAccountType[] getImplicitRegimes(String messageType,String legalStatus,boolean rgdRegistration);
    
}
