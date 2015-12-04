package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppWhCustControlPoint.findAll", query = "select o from AppWhCustControlPoint o")
@Table(name = "APP_WH_CUST_CONTROL_POINT")
public class AppWhCustControlPoint extends BaseNormalModelObject {
    @Column(name="CUST_CONTROL_POINT_CODE")
    private String custControlPointCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_CUST_CONTROL_POINT_SEQ")
    @SequenceGenerator(name = "APP_WH_CUST_CONTROL_POINT_SEQ", sequenceName = "APP_WH_CUST_CONTROL_POINT_SEQ", allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(name="PROCEDURE_TYPE_CODE")
    private String procedureTypeCode;
    @OneToMany(mappedBy = "appWhCustControlPoint", cascade={CascadeType.ALL})
    private List<AppWhCustomsProcedure> appWhCustomsProcedureList;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;
    @OneToMany(mappedBy = "appWhCustControlPoint", cascade={CascadeType.ALL})
    private List<AppWhCustomsOffice> appWhCustomsOfficeList;

    public AppWhCustControlPoint() {
    }

    public String getCustControlPointCode() {
        return custControlPointCode;
    }

    public void setCustControlPointCode(String custControlPointCode) {
        this.custControlPointCode = custControlPointCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedureTypeCode() {
        return procedureTypeCode;
    }

    public void setProcedureTypeCode(String procedureTypeCode) {
        this.procedureTypeCode = procedureTypeCode;
    }

    public List<AppWhCustomsProcedure> getAppWhCustomsProcedureList() {
        return appWhCustomsProcedureList;
    }

    public void setAppWhCustomsProcedureList(List<AppWhCustomsProcedure> appWhCustomsProcedureList) {
        this.appWhCustomsProcedureList = appWhCustomsProcedureList;
    }

    public AppWhCustomsProcedure addAppWhCustomsProcedure(AppWhCustomsProcedure appWhCustomsProcedure) {
        getAppWhCustomsProcedureList().add(appWhCustomsProcedure);
        appWhCustomsProcedure.setAppWhCustControlPoint(this);
        return appWhCustomsProcedure;
    }

    public AppWhCustomsProcedure removeAppWhCustomsProcedure(AppWhCustomsProcedure appWhCustomsProcedure) {
        getAppWhCustomsProcedureList().remove(appWhCustomsProcedure);
        appWhCustomsProcedure.setAppWhCustControlPoint(null);
        return appWhCustomsProcedure;
    }

    public AppWhAuthorisation getAppWhAuthorisation() {
        return appWhAuthorisation;
    }

    public void setAppWhAuthorisation(AppWhAuthorisation appWhAuthorisation) {
        this.appWhAuthorisation = appWhAuthorisation;
    }

    public List<AppWhCustomsOffice> getAppWhCustomsOfficeList() {
        return appWhCustomsOfficeList;
    }

    public void setAppWhCustomsOfficeList(List<AppWhCustomsOffice> appWhCustomsOfficeList) {
        this.appWhCustomsOfficeList = appWhCustomsOfficeList;
    }

    public AppWhCustomsOffice addAppWhCustomsOffice(AppWhCustomsOffice appWhCustomsOffice) {
        getAppWhCustomsOfficeList().add(appWhCustomsOffice);
        appWhCustomsOffice.setAppWhCustControlPoint(this);
        return appWhCustomsOffice;
    }

    public AppWhCustomsOffice removeAppWhCustomsOffice(AppWhCustomsOffice appWhCustomsOffice) {
        getAppWhCustomsOfficeList().remove(appWhCustomsOffice);
        appWhCustomsOffice.setAppWhCustControlPoint(null);
        return appWhCustomsOffice;
    }
}
