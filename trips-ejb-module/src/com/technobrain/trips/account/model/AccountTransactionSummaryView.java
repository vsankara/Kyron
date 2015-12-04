package com.technobrain.trips.account.model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries ( 
    {
    @NamedQuery(name = "AccountTransactionSummaryView.findAll", 
        query = "select o from AccountTransactionSummaryView o"), 
//    @NamedQuery(name = "AccountTransactionSummaryView.findTransactionsByAccountNumber", 
//        query = "select o from AccountTransactionSummaryView o where o.accountNumber=?1"),
    @NamedQuery(name = "AccountTransactionSummaryView.findTransactionsByReference", 
        query = "select o from AccountTransactionSummaryView o where o.transactionRef=?1"),
    @NamedQuery(name = "AccountTransactionSummaryView.findNonZeroByDocumentId", 
    query = "select o from AccountTransactionSummaryView o where o.documentId=?1 and o.balance > 0 order by o.transactionId asc"),
        @NamedQuery(name = "AccountTransactionSummaryView.findNonZeroByDocumentIdAndChargeType", 
    query = "select o from AccountTransactionSummaryView o where o.documentId=?1 and o.balance > 0 and o.transactionType='DEBIT' and o.chargeType=?2 order by o.transactionId asc"),
    @NamedQuery(name = "AccountTransactionSummaryView.findByDocumentId", 
        query = "select o from AccountTransactionSummaryView o where o.documentId=?1"),
    @NamedQuery(name = "AccountTransactionSummaryView.findDocumentCurrentCharges", 
        query = "select o from AccountTransactionSummaryView o where o.documentId=?1 and (o.eventId is null or o.eventId = (select max(a.eventId) from AccountTransactionSummaryView a where a.documentId=?1))"),
    @NamedQuery(name = "AccountTransactionSummaryView.findByTransactionId", 
        query = "select o from AccountTransactionSummaryView o where o.transactionId=?1")
    }
)
@Table(name = "ACCOUNT_TRAN_SUMMARY")
public class AccountTransactionSummaryView {
    @Id
    @Column(name = "TRANSACTION_ID")    
    private Long transactionId;
    @Column(name = "ACC_ACCOUNT", nullable = false)
    private Long accAccount;
    private BigDecimal amount;
    @Column(name="BALANCE")
    private BigDecimal balance;
    @Column(name="DOCUMENT_ID")
    private String documentId;
    @Column(name="TRANSACTION_DATE")
    private Timestamp transactionDate;
    @Column(name="TRANSACTION_PERIOD")
    private Double transactionPeriod;
    @Column(name="TRANSACTION_REF")
    private String transactionRef;
    @Column(name="TRANSACTION_TYPE")
    private String transactionType;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="CHARGE_TYPE")
    private String chargeType;
    @Column(name = "EVENT_ID")
    private Long eventId;
    @Column(name = "INSTALMENT_NUMBER")
    private Long instalmentNumber;
    

    public AccountTransactionSummaryView() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionPeriod() {
        return transactionPeriod;
    }

    public void setTransactionPeriod(Double transactionPeriod) {
        this.transactionPeriod = transactionPeriod;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setAccAccount(Long accAccount) {
        this.accAccount = accAccount;
    }

    public Long getAccAccount() {
        return accAccount;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setInstalmentNumber(Long instalmentNumber) {
        this.instalmentNumber = instalmentNumber;
    }

    public Long getInstalmentNumber() {
        return instalmentNumber;
    }
}
