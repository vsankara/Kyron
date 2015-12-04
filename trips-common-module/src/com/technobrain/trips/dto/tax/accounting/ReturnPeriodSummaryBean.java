package com.technobrain.trips.dto.tax.accounting;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class ReturnPeriodSummaryBean {

    private String taxType;
    private String description;
    private Timestamp returnPeriod;
    private BigDecimal accountBalance;
    
    
    public ReturnPeriodSummaryBean() {
    }
    
    public ReturnPeriodSummaryBean(String taxType, String description, Timestamp returnPeriod, BigDecimal accountBalance){
        
        this.taxType = taxType;
        this.description = description;
        this.returnPeriod = returnPeriod;
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

    public void setReturnPeriod(Timestamp returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public Timestamp getReturnPeriod() {
        return returnPeriod;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
