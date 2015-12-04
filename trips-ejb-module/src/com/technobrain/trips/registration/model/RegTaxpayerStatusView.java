package com.technobrain.trips.registration.model;

import com.technobrain.trips.entity.model.EntEntity;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( {

@NamedQuery(name = "RegTaxpayerStatusView.findAll", 
    query = "select o from RegTaxpayerStatusView o"), 

@NamedQuery(name = "RegTaxpayerStatusView.findTaxpayerStatusByRegistrationId", 
    query = "select o from RegTaxpayerStatusView o where o.id =?1 "),

@NamedQuery(name = "RegTaxpayerStatusView.findRegistrationByEntityAndStatus", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.currentStatus = ?2 and o.registrationType = 'REVENUE' "),
    
@NamedQuery(name = "RegTaxpayerStatusView.findRevenueRegistrationByEntity", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.registrationType = 'REVENUE' "),
    
@NamedQuery(name = "RegTaxpayerStatusView.findRevenueAccountsForDereg", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.currentStatus <> 'DE-REG' and o.registrationType = 'REVENUE' "), 
    

@NamedQuery(name = "RegTaxpayerStatusView.findRegistrationByEntityAndRevenueType", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.revenueType = ?2 and o.currentStatus <> 'DE-REG'"),    

@NamedQuery(name = "RegTaxpayerStatusView.findAccountByEntityAndRevenueType", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.revenueType = ?2"),    

@NamedQuery(name = "RegTaxpayerStatusView.findAllRegisteredAccountsForEntity", 
    query = "select o from RegTaxpayerStatusView o where o.entEntity.id =?1 " +
    "           and o.currentStatus <> 'REG'"),    

@NamedQuery(name = "RegTaxpayerStatusView.findTaxpayerAccountRegistration",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id = ?1 " +
    "           AND o.registrationType = 'TAXPAYER'"),

@NamedQuery(name = "RegTaxpayerStatusView.findByAccountNumber",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.accountNumber = ?1 "),
    
@NamedQuery(name = "RegTaxpayerStatusView.findByTin",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.tin = ?1 "),

 @NamedQuery(name = "RegTaxpayerStatusView.findTaxPayerByTin",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.tin = ?1 "+
    "           AND o.registrationType = 'TAXPAYER'"),

@NamedQuery(name = "RegTaxpayerStatusView.findByTaxpayerAccountId",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.taxpayerAccountId = ?1 "),

@NamedQuery(name = "RegTaxpayerStatusView.duplicateAccountCheck",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id = ?1 " +
            "AND o.revenueType = ?2"),
@NamedQuery(name = "RegTaxpayerStatusView.duplicateTaxpayerCheck",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id = ?1 " +
            "AND o.registrationType = ?2"),

@NamedQuery(name = "RegTaxpayerStatusView.findAllAccountsByTin",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id IN (    " +
            "   SELECT o2.entEntity.id FROM RegTaxpayerStatusView o2 WHERE o2.tin = ?1    " +
            ")"),
            
@NamedQuery(name = "RegTaxpayerStatusView.findAllAccountsByTinAndRevenueType",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id IN (    " +
            "   SELECT o2.entEntity.id FROM RegTaxpayerStatusView o2 WHERE o2.tin = ?1    " +
            ")                                                                  " +
            "AND o.registrationType = ?2                                        "),

@NamedQuery(name = "RegTaxpayerStatusView.findAllAccountsByTinSelectedRevTypes",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.tin = ?1 and o.revenueType in (?2, ?3) and o.currentStatus <> 'DE-REG'"),        
    
@NamedQuery(name = "RegTaxpayerStatusView.findTaxpayerAccountsByTinSelectedRevType",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.tin = ?1 and o.registrationType in ('TAXPAYER','REVENUE') and (o.revenueType is null or o.revenueType=?2) order by o.registrationType desc"),     
            
//@NamedQuery(name = "RegTaxpayerStatusView.findAllReprintStoreRecords",
//    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.currentStatus = 'REG' " +
//            "AND (o.revenueType IS NULL or o.revenueType IN ('V-STD','V-FR','VAT-NHIL'))"),
//@NamedQuery(name = "RegTaxpayerStatusView.findAllReprintStoreRecords",
//    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.currentStatus = 'REG' AND o.registrationType='TAXPAYER' " +
//            "AND o.tin NOT IN (SELECT o2.Tin From ReportStore o2 where o2.taxType is null) " +
//            "UNION " +
//            "SELECT o3 From RegTaxpayerStatusView o3 Where o3.currentStatus = 'REG' AND o3.registrationType='REVENUE' " + 
//            "AND o3.revenueType In ('V-STD','V-FR','VAT-NHIL') " + 
//            "AND o3.id Not In " + 
//            "(SELECT o4.Id From RegTaxpayerStatusView o4, ReportStore o5 " + 
//            "WHERE o4.currentStatus = 'REG' AND o4.registrationType='REVENUE' AND o4.tin = o5.tin AND o4.revenueType = o5.taxType)"),
@NamedQuery(name = "RegTaxpayerStatusView.findRevenueAccountsByTinAndStatus",
    query = "SELECT o FROM RegTaxpayerStatusView o WHERE o.entEntity.id IN ( " +
            " SELECT o2.entEntity.id FROM RegTaxpayerStatusView o2 WHERE o2.tin = ?1  )" +
            "AND o.registrationType ='REVENUE'  AND o.revenueType = ?2 "+
            "AND o.currentStatus = 'REG' OR o.currentStatus ='SUSP' ")
}
)
@Table(name = "REG_TAXPAYER_STATUS")
public class RegTaxpayerStatusView implements Serializable {

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="CURRENT_STATUS", nullable = false)
    private String currentStatus;

    @Column(name="EFFECTIVE_DATE", nullable = false)
    private Timestamp effectiveDate;

    @Column(name="EFFECTIVE_EVENT_TYPE", nullable = false)
    private String effectiveEventType;

    @Id
    @Column(name="ID")
    private Long id; 

    @JoinColumn(name = "ENT_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private EntEntity entEntity;

    private String notes;

    private String reason;

    @Column(name="REGISTRATION_TYPE", nullable = false)
    private String registrationType;

    @Column(name="REVENUE_TYPE")
    private String revenueType;
    
    @Column(name="REVENUE_DESC")
    private String revenueDescription;
    
    @Column(name="EDD")
    private Timestamp edd;

    @Column(name="TAXPAYER_ACCOUNT_ID")
    private Long taxpayerAccountId;

    private String tin;
    
    @Column(name="REGISTERED_DATE", nullable = false)
    private Timestamp registeredDate;
    
    @Column(name="DISPLAY_STATUS")
    private String displayStatus;
    
    @Column(name="EDS")
    private Timestamp eds;
    
    @Column(name="TAXPAYER_EDR")
    private Timestamp taxpayerRegDate;
    
    @Column(name="NO_RETURN_INDICATOR")
    private String noReturnIndicator;
    
    private String office;

    public RegTaxpayerStatusView() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveEventType() {
        return effectiveEventType;
    }

    public void setEffectiveEventType(String effectiveEventType) {
        this.effectiveEventType = effectiveEventType;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public Long getTaxpayerAccountId() {
        return taxpayerAccountId;
    }

    public void setTaxpayerAccountId(Long taxpayerAccountId) {
        this.taxpayerAccountId = taxpayerAccountId;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRegisteredDate(Timestamp registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Timestamp getRegisteredDate() {
        return registeredDate;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setEdd(Timestamp edd) {
        this.edd = edd;
    }

    public Timestamp getEdd() {
        return edd;
    }

    public void setRevenueDescription(String revenueDescription) {
        this.revenueDescription = revenueDescription;
    }

    public String getRevenueDescription() {
        return revenueDescription;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setEds(Timestamp eds) {
        this.eds = eds;
    }

    public Timestamp getEds() {
        return eds;
    }

    public void setTaxpayerRegDate(Timestamp taxpayerRegDate) {
        this.taxpayerRegDate = taxpayerRegDate;
    }

    public Timestamp getTaxpayerRegDate() {
        return taxpayerRegDate;
    }

    public void setNoReturnIndicator(String noReturnIndicator) {
        this.noReturnIndicator = noReturnIndicator;
    }

    public String getNoReturnIndicator() {
        return noReturnIndicator;
    }
}
