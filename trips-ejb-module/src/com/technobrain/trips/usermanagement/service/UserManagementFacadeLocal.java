package com.technobrain.trips.usermanagement.service;

import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.usermanagement.model.WfisUserPrinter;

import javax.ejb.Local;

@Local
public interface UserManagementFacadeLocal extends FacadeLocal {
    public WfisUserPrinter findPrinterByUserName(String userName);
    
    public String findOfficeFor(String username);
    
    public WfisUserPrinter saveUserPrinter(WfisUserPrinter wfisUserPrinter);
}
