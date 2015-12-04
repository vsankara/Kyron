package com.technobrain.trips.period;

import java.util.*;

/**
 * Period object.
 */
public class Period {

    private Integer periodNumber;
    private Integer periodYear;
    private Integer periodQuarter;
    private Date periodStart;
    private Date periodEnd;
    private String periodLabel;
    private String periodType;
    private String taxReturnType;
    private Date dueDate;
    private Integer numberOfDaysToAdd;
    private Long id;
  //  private boolean quarterApplied;
  //  private boolean annualApplied;
    
    public Period() {
    }

    public void setPeriodNumber(Integer periodNumber) {
        this.periodNumber = periodNumber;
    }

    public Integer getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodYear(Integer periodYear) {
        this.periodYear = periodYear;
    }

    public Integer getPeriodYear() {
        return periodYear;
    }

    public void setPeriodQuarter(Integer periodQuarter) {
        this.periodQuarter = periodQuarter;
    }

    public Integer getPeriodQuarter() {
        return periodQuarter;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodLabel(String periodLabel) {
        this.periodLabel = periodLabel;
    }

    public String getPeriodLabel() {
        return periodLabel;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setNumberOfDaysToAdd(Integer numberOfDaysToAdd) {
        this.numberOfDaysToAdd = numberOfDaysToAdd;
    }

    public Integer getNumberOfDaysToAdd() {
        return numberOfDaysToAdd;
    }

//    public void setQuarterApplied(boolean quarterApplied) {
//        this.quarterApplied = quarterApplied;
//    }
//
//    public boolean isQuarterApplied() {
//        return quarterApplied;
//    }
//
//    public void setAnnualApplied(boolean annualApplied) {
//        this.annualApplied = annualApplied;
//    }
//
//    public boolean isAnnualApplied() {
//        return annualApplied;
//    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setTaxReturnType(String taxReturnType) {
        this.taxReturnType = taxReturnType;
    }

    public String getTaxReturnType() {
        return taxReturnType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
