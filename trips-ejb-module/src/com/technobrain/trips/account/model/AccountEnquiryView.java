package com.technobrain.trips.account.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries ( 
    {
    
    @NamedQuery(name = "AccountEnquiryView.findAccountEnquiryByTinNumber", 
        query = "select a from AccountEnquiryView a where a.tinNumber=?1"),
    @NamedQuery(name = "AccountEnquiryView.findAccountEnquiryByEntityId", 
    query = "select a from AccountEnquiryView a where a.entityId=?1"),
    @NamedQuery(name = "AccountEnquiryView.findAccountEnquiryByAccountId", 
    query = "select a from AccountEnquiryView a where a.accountId=?1"),
    @NamedQuery(name = "AccountEnquiryView.findAccountEnquiryForSuspenseByTin", 
    query = "select a from AccountEnquiryView a where a.tinNumber=?1 and a.accountType='SUSPENSE'"),
    @NamedQuery(name = "AccountEnquiryView.findAccountEnquiryByTinAndTaxType", 
    query = "select a from AccountEnquiryView a where a.tinNumber=?1 and a.revenueType=?2")
    }
)
@Table(name = "TAXPAYER_ACCOUNT_ENQUIRY")
public class AccountEnquiryView implements Serializable {
    @Id
    @Column(name = "ACC_ID")
    private Long accountId;
    @Column(name = "ACC_TYPE")
    private String accountType;
    
    @Column(name = "REV_TYPE")
    private String revenueType;
    
    @Column(name = "ACC_NO")
    private String accountNumber;
    @Column(name = "STATUS")
    private String accountStatus;
    @Column(name = "ENT_ID")
    private Long entityId;
    @Column(name = "ACCOUNT_DESC")
    private String description;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "TIN")
    private String tinNumber;
    @Column(name = "MODE_TYPE")
    private String modeType;
    
    public AccountEnquiryView() {
    }


    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }


    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getModeType() {
        return modeType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }
}
