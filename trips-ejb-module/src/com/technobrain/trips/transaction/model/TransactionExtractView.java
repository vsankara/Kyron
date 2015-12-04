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
@NamedQuery(name = "TransactionExtractView.findAll", 
            query = "select o from TransactionExtractView o")
@Table(name = "TRANSACTION_EXTRACT")
public class TransactionExtractView implements Serializable {
    @Id
    @Column(name = "TRANS_ID_REF")
    private String transIdRef;
    @Column(name = "TRANS_TYPE")
    private String transType;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "DOC_TYPE")
    private String docType;
    @Column(name = "DOC_EVENT_TYPE")
    private String docEventType;
    @Column(name = "TRANS_REFERENCE")
    private String transReference;
    @Column(name = "TIN")
    private String tin;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "TRANS_DATE")
    private Timestamp transDate;
    @Column(name = "REV_LED_CODE")
    private String revLedCode;
    @Column(name = "TAX_TYPE")
    private String taxType;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "OFFICE")
    private String office;
    @Column(name = "RECEIPT_NUMBER")
    private String receiptNumber;
    @Column(name = "ALLOCATION_ITEM_TYPE")
    private String allocationItemType;
    @Column(name = "PAYMENT_ALLOC_TAX_OFFICE")
    private String paymentAllocTaxOffice;
    @Column(name = "PAYMENT_CURRENCY")
    private String paymentCurrency;
    @Column(name = "AMOUNT_IN_FOREX")
    private BigDecimal amountInForex;
    @Column(name = "EXCHANGE_RATE")
    private BigDecimal exchangeRate;
    //@Column(name = "CREATED_DATE")
    //private Timestamp createdDate;

    public TransactionExtractView() {
    }

    public String getTransIdRef() {
        return transIdRef;
    }

    public void setTransIdRef(String transIdRef) {
        this.transIdRef = transIdRef;
    }

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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocEventType() {
        return docEventType;
    }

    public void setDocEventType(String docEventType) {
        this.docEventType = docEventType;
    }

    public String getTransReference() {
        return transReference;
    }

    public void setTransReference(String transReference) {
        this.transReference = transReference;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

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

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getAllocationItemType() {
        return allocationItemType;
    }

    public void setAllocationItemType(String allocationItemType) {
        this.allocationItemType = allocationItemType;
    }

    public String getPaymentAllocTaxOffice() {
        return paymentAllocTaxOffice;
    }

    public void setPaymentAllocTaxOffice(String paymentAllocTaxOffice) {
        this.paymentAllocTaxOffice = paymentAllocTaxOffice;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public BigDecimal getAmountInForex() {
        return amountInForex;
    }

    public void setAmountInForex(BigDecimal amountInForex) {
        this.amountInForex = amountInForex;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    //public Timestamp getCreatedDate() {
    //    return createdDate;
    //}

    //public void setCreatedDate(Timestamp createdDate) {
    //    this.createdDate = createdDate;
    //}
}
