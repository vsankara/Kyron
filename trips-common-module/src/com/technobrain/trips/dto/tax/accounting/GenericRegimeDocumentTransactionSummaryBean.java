package com.technobrain.trips.dto.tax.accounting;

import java.io.Serializable;

import java.math.BigDecimal;

public class GenericRegimeDocumentTransactionSummaryBean implements Serializable  {

    private Long transactionId;
    private String transactionType;
    private String taxType;
    private BigDecimal chargeAmount;
    private String glAccount;
    private BigDecimal transactionBalance;
    public GenericRegimeDocumentTransactionSummaryBean(Long transactionId,String transactionType,String taxType,BigDecimal chargeAmount,String glAccount,BigDecimal transactionBalance) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.taxType = taxType;
        this.chargeAmount = chargeAmount;
        this.glAccount = glAccount;
        this.transactionBalance = transactionBalance;
    }
    public GenericRegimeDocumentTransactionSummaryBean() {
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
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

   
    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setTransactionBalance(BigDecimal transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public BigDecimal getTransactionBalance() {
        return transactionBalance;
    }
}
