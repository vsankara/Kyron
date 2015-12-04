package com.technobrain.trips.analysis.service;


import com.technobrain.trips.core.message.RegimeAccountType;
import javax.ejb.Remote;


@Remote
public interface AnalysisFacadeRemote {   

    public RegimeAccountType[] getImplicitRegimes(String messageType,String legalStatus,boolean rgdRegistration);
    
}
