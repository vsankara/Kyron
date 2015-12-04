package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity

@NamedQueries({
    @NamedQuery(name = "RefDateCfg.findAll", 
        query = "select o from RefDateCfg o"
    ),
    
    @NamedQuery(
        name="RefDateCfg.findAllNonRunEntries",
        query="select o from RefDateCfg o where o.shouldRunJob = ?1 and o.status='A'"
    )    
})   



@Table(name = "REF_DATE_CFG")
public class RefDateCfg extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @ManyToOne
    @JoinColumn(name = "REF_DATE_CATEGORY", referencedColumnName = "CODE")
    private RefDateCategory refDateCategory;
    
    @ManyToOne
    @JoinColumn(name = "REF_DATE_SUB_CATEGORY", referencedColumnName = "CODE")
    private RefDateSubCategory refDateSubCategory;
    
    @Column(name="DATE_FROM")
    private Timestamp dateFrom;
    
    @Column(name="DATE_TO")
    private Timestamp dateTo;
    
    @Column(name="SPECIAL_HOLIDAY_FLAG")
    private String specialHolidayFlag;
    
    @ManyToOne
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE")
    private RefRevType refRevType;
    
    @ManyToOne
    @JoinColumn(name = "FILING_FREQUENCY", referencedColumnName = "CODE")
    private RefStagger refStagger;

    @Column(name="FILING_MODE")
    private String filingMode;
    
    @ManyToOne
    @JoinColumn(name = "REF_DATE_RECUR_CFG", referencedColumnName = "CODE")
    private RefDateRecurCfg refDateRecurCfg;
    
    @Column(name="MUNICIPALITY_CODE")
    private String municipalityCode;
    
    @Column(name="SHOULD_RUN_JOB")
    private String shouldRunJob;    
    
    @Column(name="JOB_RUN_DATE")
    private Timestamp jobRunDate;
    
    @Column(name="YEAR")
    private Integer year;
    
    public RefDateCfg() {
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setRefDateCategory(RefDateCategory refDateCategory) {
        this.refDateCategory = refDateCategory;
    }

    public RefDateCategory getRefDateCategory() {
        return refDateCategory;
    }

    public void setRefDateSubCategory(RefDateSubCategory refDateSubCategory) {
        this.refDateSubCategory = refDateSubCategory;
    }

    public RefDateSubCategory getRefDateSubCategory() {
        return refDateSubCategory;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setSpecialHolidayFlag(String specialHolidayFlag) {
        this.specialHolidayFlag = specialHolidayFlag;
    }

    public String getSpecialHolidayFlag() {
        return specialHolidayFlag;
    }

    public void setRefRevType(RefRevType refRevType) {
        this.refRevType = refRevType;
    }

    public RefRevType getRefRevType() {
        return refRevType;
    }

    public void setRefStagger(RefStagger refStagger) {
        this.refStagger = refStagger;
    }

    public RefStagger getRefStagger() {
        return refStagger;
    }

    public void setFilingMode(String filingMode) {
        this.filingMode = filingMode;
    }

    public String getFilingMode() {
        return filingMode;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setRefDateRecurCfg(RefDateRecurCfg refDateRecurCfg) {
        this.refDateRecurCfg = refDateRecurCfg;
    }

    public RefDateRecurCfg getRefDateRecurCfg() {
        return refDateRecurCfg;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setJobRunDate(Timestamp jobRunDate) {
        this.jobRunDate = jobRunDate;
    }

    public Timestamp getJobRunDate() {
        return jobRunDate;
    }

    public void setShouldRunJob(String shouldRunJob) {
        this.shouldRunJob = shouldRunJob;
    }

    public String getShouldRunJob() {
        return shouldRunJob;
    }
}
