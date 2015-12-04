package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class TaxYearSummaryBean {

    private String taxType;
    private String description;
    private String taxYear;
    private BigDecimal accountBalance;
    
    public TaxYearSummaryBean() {
    }
    
    public TaxYearSummaryBean(String taxType, String description, String taxYear, BigDecimal accountBalance){
        
        this.taxType = taxType;
        this.description = description;
        this.taxYear = taxYear;
        this.accountBalance = accountBalance;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }

    public String getTaxYear() {
        return taxYear;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
