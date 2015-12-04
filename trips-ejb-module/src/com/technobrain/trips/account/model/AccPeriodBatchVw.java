package com.technobrain.trips.account.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AccPeriodBatchVw.findAll", 
    query = "select o from AccPeriodBatchVw o")
@Table(name = "ACC_PERIOD_BATCH_VW")
public class AccPeriodBatchVw implements Serializable {
   // @Id
   // @Column(name="ACC_ACCOUNT")
   // private Long accAccount;
    @EmbeddedId
     protected AccPeriodBatchVwPK accPeriodBatchVwPK;
    @Column(name="ACC_PERIOD")
    private Long accPeriod;
    private Timestamp edr;
    @Column(name="ENT_ENTITY")
    private Long entEntity;
    @Column(name="PERIOD_END_DATE")
    private Timestamp periodEndDate;
    @Column(name="REVENUE_TYPE")
    private String revenueType;
    
   // private String stagger;

    public AccPeriodBatchVw() {
    }

//    public Long getAccAccount() {
//        return accAccount;
//    }
//
//    public void setAccAccount(Long accAccount) {
//        this.accAccount = accAccount;
//    }

    public Long getAccPeriod() {
        return accPeriod;
    }

    public void setAccPeriod(Long accPeriod) {
        this.accPeriod = accPeriod;
    }

    public Timestamp getEdr() {
        return edr;
    }

    public void setEdr(Timestamp edr) {
        this.edr = edr;
    }

    public Long getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(Long entEntity) {
        this.entEntity = entEntity;
    }

    public Timestamp getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

//    public String getStagger() {
//        return stagger;
//    }
//
//    public void setStagger(String stagger) {
//        this.stagger = stagger;
//    }

//    public void setReturnType(String returnType) {
//        this.returnType = returnType;
//    }
//
//    public String getReturnType() {
//        return returnType;
//    }

    public void setAccPeriodBatchVwPK(AccPeriodBatchVwPK accPeriodBatchVwPK) {
        this.accPeriodBatchVwPK = accPeriodBatchVwPK;
    }

    public AccPeriodBatchVwPK getAccPeriodBatchVwPK() {
        return accPeriodBatchVwPK;
    }
}
