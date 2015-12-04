package com.technobrain.trips.account.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="AccountPeriodView")
@NamedQueries ({ 
    @NamedQuery(name = "AccountPeriodView.findAll", 
        query = "select o from AccountPeriodView o"), 
    @NamedQuery(name = "AccountPeriodView.findPeriodForAccountByStatus", 
        query = "select o from AccountPeriodView o where o.accountNumber = ?1 " +
        " and o.periodStatus = ?2"), 
    @NamedQuery(name = "AccountPeriodView.findCurrentPeriodByAccountId", query = 
                "select o from AccountPeriodView o where o.accountId = ?1 " +
                "and o.periodStartDate <= CURRENT_TIMESTAMP " +
                "and (o.periodEndDate >= CURRENT_TIMESTAMP or o.periodEndDate is NULL) ")
})
@Table(name = "ACCOUNT_PERIOD")
public class AccountPeriodView implements Serializable {
    @Column(name="ACCOUNT_BALANCE")
    private BigDecimal accountBalance;
    @Column(name="ACCOUNT_ID", nullable = false)
    private Long accountId;
    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="PERIOD_DUE_DATE")
    private Timestamp periodDueDate;
    @Column(name="PERIOD_END_DATE")
    private Timestamp periodEndDate;
    @Column(name="PERIOD_START_DATE")
    private Timestamp periodStartDate;
    @Column(name="PERIOD_STATUS")
    private String periodStatus;
    @Column(name="PERIOD_YEAR")
    private Long periodYear;
    @Column(name="UPDATED_BY")
    private String updatedBy;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPeriodDueDate() {
        return periodDueDate;
    }

    public void setPeriodDueDate(Timestamp periodDueDate) {
        this.periodDueDate = periodDueDate;
    }

    public Timestamp getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public Timestamp getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(Timestamp periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodStatus() {
        return periodStatus;
    }

    public void setPeriodStatus(String periodStatus) {
        this.periodStatus = periodStatus;
    }

    public Long getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(Long periodYear) {
        this.periodYear = periodYear;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
