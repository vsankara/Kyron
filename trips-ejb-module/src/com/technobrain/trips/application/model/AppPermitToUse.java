package com.technobrain.trips.application.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppPermitToUse.findAll", query = "select o from AppPermitToUse o")
@Table(name = "APP_PERMIT_TO_USE")
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("PERMIT_TO_USE")
public class AppPermitToUse extends AppApplication {
 
    @OneToMany(mappedBy = "appPermitToUse", cascade={CascadeType.ALL})
    private List<AppPermitBkAcct> appPermitBkAcctList;

    @OneToMany(mappedBy = "appPermitToUse", cascade={CascadeType.ALL})
    private List<AppPermitMachine> appPermitMachineList;
    
    @OneToMany(mappedBy = "appPermitToUse", cascade={CascadeType.ALL})
    private List<AppPermitInvoice> appPermitInvoiceList;
    
    String comments;
    
    @Column(name="SUPPLIER_ID")
    private Long supplierID;
    
    public AppPermitToUse() {
    }

    public AppPermitInvoice addAppPermitInvoice(AppPermitInvoice appPermitInvoice) {
        getAppPermitInvoiceList().add(appPermitInvoice);
        appPermitInvoice.setAppPermitToUse(this);
        return appPermitInvoice;
    }

    public AppPermitInvoice removeAppPermitInvoice(AppPermitInvoice appPermitInvoice) {
        getAppPermitInvoiceList().remove(appPermitInvoice);
        appPermitInvoice.setAppPermitToUse(null);
        return appPermitInvoice;
    }
    
    public AppPermitMachine addAppPermitMachine(AppPermitMachine appPermitMachine) {
        getAppPermitMachineList().add(appPermitMachine);
        appPermitMachine.setAppPermitToUse(this);
        return appPermitMachine;
    }

    public AppPermitMachine removeAppPermitMachine(AppPermitMachine AppPermitMachine) {
        getAppPermitMachineList().remove(AppPermitMachine);
        AppPermitMachine.setAppPermitToUse(null);
        return AppPermitMachine;
    }
    
    public AppPermitBkAcct addAppPermitBkAcct(AppPermitBkAcct appPermitBkAcct) {
        getAppPermitBkAcctList().add(appPermitBkAcct);
        appPermitBkAcct.setAppPermitToUse(this);
        return appPermitBkAcct;
    }

    public AppPermitBkAcct removeAppPermitBkAcct(AppPermitBkAcct appPermitBkAcct) {
        getAppPermitBkAcctList().remove(appPermitBkAcct);
        appPermitBkAcct.setAppPermitToUse(null);
        return appPermitBkAcct;
    }
    
    

    public void setAppPermitMachineList(List<AppPermitMachine> appPermitMachineList) {
        this.appPermitMachineList = appPermitMachineList;
    }

    public List<AppPermitMachine> getAppPermitMachineList() {
        return appPermitMachineList;
    }

    public void setAppPermitInvoiceList(List<AppPermitInvoice> appPermitInvoiceList) {
        this.appPermitInvoiceList = appPermitInvoiceList;
    }

    public List<AppPermitInvoice> getAppPermitInvoiceList() {
        return appPermitInvoiceList;
    }

    public void setAppPermitBkAcctList(List<AppPermitBkAcct> appPermitBkAcctList) {
        this.appPermitBkAcctList = appPermitBkAcctList;
    }

    public List<AppPermitBkAcct> getAppPermitBkAcctList() {
        return appPermitBkAcctList;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public Long getSupplierID() {
        return supplierID;
    }
}
