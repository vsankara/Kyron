package com.technobrain.trips.dto.portal;

import java.math.BigDecimal;

import java.sql.Timestamp;


public class TransactionDTO {
    public TransactionDTO(String transIdRef, String transType, 
                          BigDecimal amount, String docType, 
                          String docEventType, String transReference, 
                          String tin, String accountNumber, 
                          Timestamp transDate, String revLedCode, 
                          String taxType, String description, String office, 
                          String receiptNumber, String allocationItemType, 
                          String paymentAllocTaxOffice, String paymentCurrency, 
                          BigDecimal amountInForex, BigDecimal exchangeRate) {
        this.transIdRef = transIdRef;
        this.transType = transType;
        this.amount = amount;
        this.docType = docType;
        this.docEventType = docEventType;
        this.transReference = transReference;
        this.tin = tin;
        this.accountNumber = accountNumber;
        this.transDate = transDate;
        this.revLedCode = revLedCode;
        this.taxType = taxType;
        this.description = description;
        this.office = office;
        this.receiptNumber = receiptNumber;
        this.allocationItemType = allocationItemType;
        this.paymentAllocTaxOffice = paymentAllocTaxOffice;
        this.paymentCurrency = paymentCurrency;
        this.amountInForex = amountInForex;
        this.exchangeRate = exchangeRate;
    }

    private String transIdRef;
    private String transType;
    private BigDecimal amount;
    private String docType;
    private String docEventType;
    private String transReference;
    private String tin;
    private String accountNumber;
    private Timestamp transDate;
    private String revLedCode;
    private String taxType;
    private String description;
    private String office;
    private String receiptNumber;
    private String allocationItemType;
    private String paymentAllocTaxOffice;
    private String paymentCurrency;
    private BigDecimal amountInForex;
    private BigDecimal exchangeRate;

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
}
