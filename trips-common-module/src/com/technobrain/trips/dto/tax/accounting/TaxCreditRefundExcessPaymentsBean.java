package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

public class TaxCreditRefundExcessPaymentsBean {

    private String transactionType;
    private BigDecimal amount;
    private BigDecimal balance;
    private String revenueType;
    private String acctTran;
    private String acctTranSign;

    public TaxCreditRefundExcessPaymentsBean() {
    }
    
    public TaxCreditRefundExcessPaymentsBean(String transactionType, BigDecimal amount, BigDecimal balance, String revenueType, String acctTran, String acctTranSign) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
        this.revenueType = revenueType;
        this.acctTran = acctTran;
        this.acctTranSign = acctTranSign;
    }


    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAcctTran(String acctTran) {
        this.acctTran = acctTran;
    }

    public String getAcctTran() {
        return acctTran;
    }

    public void setAcctTranSign(String acctTranSign) {
        this.acctTranSign = acctTranSign;
    }

    public String getAcctTranSign() {
        return acctTranSign;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
