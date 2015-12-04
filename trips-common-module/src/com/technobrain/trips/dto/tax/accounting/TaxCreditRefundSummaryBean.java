package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class TaxCreditRefundSummaryBean {

    private String tccNumber;
    private String tccStatus;
    private String legalBasis;
    private Timestamp issueDate;
    private BigDecimal issueAmount;
    private BigDecimal tccBalance;    

    public TaxCreditRefundSummaryBean() {
    }
    
    public TaxCreditRefundSummaryBean(String tccNumber, String tccStatus, String legalBasis, Timestamp issueDate, BigDecimal issueAmount, BigDecimal tccBalance) {
        this.tccNumber = tccNumber;
        this.tccStatus = tccStatus;
        this.legalBasis = legalBasis;
        this.issueDate = issueDate;
        this.issueAmount = issueAmount;
        this.tccBalance = tccBalance;
    }

    public void setTccNumber(String tccNumber) {
        this.tccNumber = tccNumber;
    }

    public String getTccNumber() {
        return tccNumber;
    }

    public void setTccStatus(String tccStatus) {
        this.tccStatus = tccStatus;
    }

    public String getTccStatus() {
        return tccStatus;
    }

    public void setLegalBasis(String legalBasis) {
        this.legalBasis = legalBasis;
    }

    public String getLegalBasis() {
        return legalBasis;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueAmount(BigDecimal issueAmount) {
        this.issueAmount = issueAmount;
    }

    public BigDecimal getIssueAmount() {
        return issueAmount;
    }

    public void setTccBalance(BigDecimal tccBalance) {
        this.tccBalance = tccBalance;
    }

    public BigDecimal getTccBalance() {
        return tccBalance;
    }
}
