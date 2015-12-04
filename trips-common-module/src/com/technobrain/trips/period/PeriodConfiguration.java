package com.technobrain.trips.period;

import java.util.Date;

/**
 * Represents various configuration parameters which is the basis of the period to generate.
 */
public class PeriodConfiguration {

    private Integer quantity;
    private String frequency;
    private boolean applyQuarter;
    private boolean applyAnnual;
    private int accountEndMonth;
    private String taxReturnType;
    private String formula;
    private String subFrequency; // this is only for multiple frequency.
    private Date generationStartDate;
    private int accountEndDay;
    private boolean fiscalYearIndicator;

    public PeriodConfiguration() {
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setFrequency(String unitOfTime) {
        this.frequency = unitOfTime;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    public void setSubFrequency(String subFrequency) {
        this.subFrequency = subFrequency;
    }

    public String getSubFrequency() {
        return subFrequency;
    }

    public void setGenerationStartDate(Date generationStartDate) {
        this.generationStartDate = generationStartDate;
    }

    public Date getGenerationStartDate() {
        return generationStartDate;
    }

    public void setApplyQuarter(boolean applyQuarter) {
        this.applyQuarter = applyQuarter;
    }

    public boolean isApplyQuarter() {
        return applyQuarter;
    }

    public void setApplyAnnual(boolean applyAnnual) {
        this.applyAnnual = applyAnnual;
    }

    public boolean isApplyAnnual() {
        return applyAnnual;
    }

    public void setAccountEndMonth(int accountEndMonth) {
        this.accountEndMonth = accountEndMonth;
    }

    public int getAccountEndMonth() {
        return accountEndMonth;
    }

    public void setAccountEndDay(int accountEndDay) {
        this.accountEndDay = accountEndDay;
    }

    public int getAccountEndDay() {
        return accountEndDay;
    }

    public void setTaxReturnType(String taxReturnType) {
        this.taxReturnType = taxReturnType;
    }

    public String getTaxReturnType() {
        return taxReturnType;
    }

    public void setFiscalYearIndicator(boolean fiscalYearIndicator) {
        this.fiscalYearIndicator = fiscalYearIndicator;
    }

    public boolean isFiscalYearIndicator() {
        return fiscalYearIndicator;
    }
}
