package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "DDOC_TRANSACTION_SUMMARY")
@NamedQueries( {
@NamedQuery(name="DdocTransactionSummaryView.findChargesByLastEvent",
query="select o from DdocTransactionSummaryView o where o.documentId=?1 and o.eventId = (select max(oo.eventId)" + 
"from DdocTransactionSummaryView oo where oo.documentId=?1)")
 })
public class DdocTransactionSummaryView implements Serializable {
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="DOCUMENT_ID")
    private String documentId;
    @Column(name="TRANS_TYPE")
    private String transactionType;
    @Column(name="TRANSACTION_ID")
    private Long accountTransactionId;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="EVENT_ID")
    private Long eventId;
    @Column(name="CHARGE_AMOUNT")
    private BigDecimal chargeAmount;
    @Column(name="GL_ACCOUNT_ID")
    private String glAccount;
    @Column(name="TRANS_BALANCE")
    private BigDecimal transactionBalance;
        
    
   
    public DdocTransactionSummaryView() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public void setTransactionBalance(BigDecimal transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public BigDecimal getTransactionBalance() {
        return transactionBalance;
    }


    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }
}
