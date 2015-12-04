package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppPermitMachine.findAll", 
    query = "select o from AppPermitMachine o")
@Table(name = "APP_PERMIT_MACHINE")
public class AppPermitMachine extends BaseNormalModelObject {
  
    private String brand;
    @Column(name="CONDITION_CODE")
    private String conditionCode;
    @Column(name="FUNCTION_CODE")
    private String functionCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_PERMIT_MACHINE_SEQ")
    @SequenceGenerator(name = "APP_PERMIT_MACHINE_SEQ", sequenceName = "APP_PERMIT_MACHINE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="MACHINE_LOCATION")
    private String machineLocation;
    @Column(name="MACHINE_TYPE")
    private String machineType;
    @Column(name="MAX_ACC_CAP")
    private String maxAccCap;
    private String model;
    @Column(name="SERIAL_NO")
    private String serialNo;
    @Column(name="SPEC_PURP_MACHINE")
    private String specPurpMachine;
   
    @ManyToOne
    @JoinColumn(name = "APP_PERMIT_APP_ID", referencedColumnName = "ID")
    private AppPermitToUse appPermitToUse;
    
    
    public AppPermitMachine() {
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachineLocation() {
        return machineLocation;
    }

    public void setMachineLocation(String machineLocation) {
        this.machineLocation = machineLocation;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMaxAccCap() {
        return maxAccCap;
    }

    public void setMaxAccCap(String maxAccCap) {
        this.maxAccCap = maxAccCap;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSpecPurpMachine() {
        return specPurpMachine;
    }

    public void setSpecPurpMachine(String specPurpMachine) {
        this.specPurpMachine = specPurpMachine;
    }


    public void setAppPermitToUse(AppPermitToUse appPermitToUse) {
        this.appPermitToUse = appPermitToUse;
    }

    public AppPermitToUse getAppPermitToUse() {
        return appPermitToUse;
    }
}
