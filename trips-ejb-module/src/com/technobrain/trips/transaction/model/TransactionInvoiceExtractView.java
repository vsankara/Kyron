package com.technobrain.trips.transaction.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "TransactionInvoiceExtractView.findAll", 
            query = "select o from TransactionInvoiceExtractView o")
@Table(name = "TRANS_INVOICE_EXTRACT")
public class TransactionInvoiceExtractView implements Serializable {
    public TransactionInvoiceExtractView() {
    }

    @Id
    @Column(name = "TRANS_ID")
    private String transId;
    @Column(name = "TRANS_TYPE")
    private String transType;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "TRANS_REFERENCE")
    private String transReference;
    //    @Column(name = "PERIOD_NUMBER")
    //    private String periodNumber;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "TRANS_DATE")
    private Timestamp transDate;
    @Column(name = "REV_LED_CODE")
    private String revLedCode;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "OFFICE")
    private String office;
    @Column(name = "DOC_TYPE")
    private String docType;
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    @Column(name = "SUBMISSION_DATE")
    private Timestamp submissionDate;
    @Column(name = "REF_EVT_TYPE_CAT")
    private String refEvtTypeCat;
    @Column(name = "TIN")
    private String tin;
    @Column(name = "TAX_TYPE")
    private String taxType;

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransReference() {
        return transReference;
    }

    public void setTransReference(String transReference) {
        this.transReference = transReference;
    }

    //    public String getPeriodNumber() {
    //        return periodNumber;
    //    }
    //
    //    public void setPeriodNumber(String periodNumber) {
    //        this.periodNumber = periodNumber;
    //    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public String getRevLedCode() {
        return revLedCode;
    }

    public void setRevLedCode(String revLedCode) {
        this.revLedCode = revLedCode;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getRefEvtTypeCat() {
        return refEvtTypeCat;
    }

    public void setRefEvtTypeCat(String refEvtTypeCat) {
        this.refEvtTypeCat = refEvtTypeCat;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
    
    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
}
