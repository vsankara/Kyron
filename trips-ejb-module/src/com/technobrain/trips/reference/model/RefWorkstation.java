package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * This class is used as a reference table for all printers
 *
 * @since	$Date: 5/26/2009 10:01:35 AM$
 * @version 	$Revision: 1$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  1    TRIPS2    1.0         5/26/2009 10:01:35 AM  Howard Hill     
 * $
 */
@Entity
@NamedQuery(name = "RefWorkstation.findAll", query = "select o from RefWorkstation o")
@Table(name = "Ref_Workstation")
public class RefWorkstation extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="IP_ADDRESS")
    private String ipAddress;
    @Column(name="COMPUTER_NAME")
    private String computerName;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    
    
    public RefWorkstation() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerName() {
        return computerName;
    }
}
