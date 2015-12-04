package com.technobrain.trips.account.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries (
    {
@NamedQuery(name = "AccRevenueAccountVw.findAll", 
    query = "select o from AccRevenueAccountVw o"),
@NamedQuery(name = "AccRevenueAccountVw.findAccRevenueAccountVwByAccAccountId", 
    query = "select o from AccRevenueAccountVw o where o.accAccount = ?1 and o.returnType = ?2")
    }
)
@Table(name = "ACC_REVENUE_ACCOUNT_VW")
public class AccRevenueAccountVw implements Serializable {
    
    @Id
    @Column(name="ACC_ACCOUNT", nullable = false)
    private Long accAccount;
    
    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;
    
    private Timestamp eda;
    private Timestamp edd;
    private Timestamp edr;
    private Timestamp eds;
    private Timestamp edt;
    @Column(name="ENT_ENTITY")
    private Long entEntity;
    @Column(name="FORCED_REGISTRATION_IND")
    private String forcedRegistrationInd;
    private String office;
    @Column(name="REGISTRATION_STATUS")
    private String registrationStatus;
    @Column(name="REGISTRATION_TYPE")
    private String registrationType;
    @Column(name="REG_TAXPAYER_REVENUE")
    private Long regTaxpayerRevenue;
    @Column(name="REVENUE_TYPE")
    private String revenueType;
    @Column(name="RETURN_TYPE")
    private String returnType;
    private String stagger;
    @Column(name="SUB_STAGGER")
    private String subStagger;

    public AccRevenueAccountVw() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccAccount() {
        return accAccount;
    }

    public void setAccAccount(Long accAccount) {
        this.accAccount = accAccount;
    }

    public Timestamp getEda() {
        return eda;
    }

    public void setEda(Timestamp eda) {
        this.eda = eda;
    }

    public Timestamp getEdd() {
        return edd;
    }

    public void setEdd(Timestamp edd) {
        this.edd = edd;
    }

    public Timestamp getEdr() {
        return edr;
    }

    public void setEdr(Timestamp edr) {
        this.edr = edr;
    }

    public Timestamp getEds() {
        return eds;
    }

    public void setEds(Timestamp eds) {
        this.eds = eds;
    }

    public Timestamp getEdt() {
        return edt;
    }

    public void setEdt(Timestamp edt) {
        this.edt = edt;
    }

    public Long getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(Long entEntity) {
        this.entEntity = entEntity;
    }

    public String getForcedRegistrationInd() {
        return forcedRegistrationInd;
    }

    public void setForcedRegistrationInd(String forcedRegistrationInd) {
        this.forcedRegistrationInd = forcedRegistrationInd;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public Long getRegTaxpayerRevenue() {
        return regTaxpayerRevenue;
    }

    public void setRegTaxpayerRevenue(Long regTaxpayerRevenue) {
        this.regTaxpayerRevenue = regTaxpayerRevenue;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getStagger() {
        return stagger;
    }

    public void setStagger(String stagger) {
        this.stagger = stagger;
    }

    public String getSubStagger() {
        return subStagger;
    }

    public void setSubStagger(String subStagger) {
        this.subStagger = subStagger;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }
}
