package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppCustSimplProcedure.findAll", query = "select o from AppCustSimplProcedure o")
@Table(name = "APP_CUST_SIMPL_PROCEDURE")
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("CUST_SIMPL_PROC")
public class AppCustSimplProcedure extends AppApplication {
    @Column(name="DEFERMENT_CASE_REFERENCE")
    private String defermentCaseReference;
    @Column(name="GUARANTEE_LEVEL")
    private BigDecimal guaranteeLevel;
    @Column(name="GUARANTEE_LEVEL_CURRENCY")
    private String guaranteeLevelCurrency;
    @Column(name="SELF_SUPP_DEC_INDICATOR")
    private String selfSuppDecIndicator;
    @Column(name="SINGLE_GUA_INDICATOR")
    private String singleGuaIndicator;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="APP_CUS_PROC_SMP_PROC_REL",
        joinColumns={@JoinColumn(name = "APP_CUST_SIMPL_PROC_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "APP_CUST_PROCEDURE_ID",
                referencedColumnName = "ID")}
    )
    private List<AppCustomsProcedure> appCustomsProcedureList;
    @Column(name="VAT_NUMBER")
    private String vatNumber;

    public AppCustSimplProcedure() {
    }

    public BigDecimal getGuaranteeLevel() {
        return guaranteeLevel;
    }

    public void setGuaranteeLevel(BigDecimal guaranteeLevel) {
        this.guaranteeLevel = guaranteeLevel;
    }

    public String getGuaranteeLevelCurrency() {
        return guaranteeLevelCurrency;
    }

    public void setGuaranteeLevelCurrency(String guaranteeLevelCurrency) {
        this.guaranteeLevelCurrency = guaranteeLevelCurrency;
    }

    public String getSelfSuppDecIndicator() {
        return selfSuppDecIndicator;
    }

    public void setSelfSuppDecIndicator(String selfSuppDecIndicator) {
        this.selfSuppDecIndicator = selfSuppDecIndicator;
    }

    public String getSingleGuaIndicator() {
        return singleGuaIndicator;
    }

    public void setSingleGuaIndicator(String singleGuaIndicator) {
        this.singleGuaIndicator = singleGuaIndicator;
    }

    public void setAppCustomsProcedureList(List<AppCustomsProcedure> appCustomsProcedureList) {
        this.appCustomsProcedureList = appCustomsProcedureList;
    }

    public List<AppCustomsProcedure> getAppCustomsProcedureList() {
        return appCustomsProcedureList;
    }
    
    public void addAppCustomsProcedure(AppCustomsProcedure appCustomsProcedure) {
        getAppCustomsProcedureList().add(appCustomsProcedure);
    }

    public void removeAppCustomsProcedure(AppCustomsProcedure appCustomsProcedure) {
        getAppCustomsProcedureList().remove(appCustomsProcedure);
    }

    public void setDefermentCaseReference(String defermentCaseReference) {
        this.defermentCaseReference = defermentCaseReference;
    }

    public String getDefermentCaseReference() {
        return defermentCaseReference;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }
}
