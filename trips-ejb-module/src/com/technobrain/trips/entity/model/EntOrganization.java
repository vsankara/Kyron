package com.technobrain.trips.entity.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.technobrain.trips.listener.EntOrganizationListener;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_ORGANIZATION
 *
 * @since	$Date: 10/6/2009 2:18:06 AM$
 * @version 	$Revision: 39$
 * @author 	$Author: Alvin Fernandez$
 * 
 * $Log[1]:
 *  39   TRIPS2 etis.bir.gov.ph1.32.1.5    10/6/2009 2:18:06 AM   Alvin
 *       Fernandez added post transaction methods
 * $
 */
@Entity
 @NamedQueries  (
    {
    @NamedQuery(name = "EntOrganization.findAll", 
        query = "select o from EntOrganization o"),
    @NamedQuery(name = "EntOrganization.findOrganizationById", 
         query = "select org from EntOrganization org where org.id = ?1")
    }
)
@Table(name = "ENT_ORGANIZATION")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("ORGANIZATION")
@EntityListeners(EntOrganizationListener.class)
public class EntOrganization extends EntEntity    {
    @Column(name="ACCOUNT_YEAR_END_DAY")
    private String accountYearEndDay;
    @Column(name="ACCOUNT_YEAR_END_MONTH")
    private String accountYearEndMonth;
    @Column(name="BUSINESS_END_DATE")
    private Timestamp businessEndDate;
    @Column(name="BUSINESS_START_DATE")
    private Timestamp businessStartDate;
    @Column(name="LEGAL_NAME")
    private String legalName;
    @Column(name="NON_TAX_TOVER_AT_REG")
    private String nonTaxToverAtReg;
    @Column(name="TAXABLE_TOVER_AT_REG")
    private String taxableToverAtReg;
    @Column(name="COMPANY_REG_NO")
    private String companyRegNo;
    @Column(name="PEROSNAL_TAX_NO")
    private String personalTaxNo;
    @Column(name="COMPANY_STATUS")
    private String companyStatus;
    @Column(name="LEGAL_NAME_PHONETIC")
    private String legalNamePhonetic;
    @Column(name="WEBSITE")
    private String website;
    @Column(name="BRANCH_FLAG")
    private String branchFlag;
    @Column(name="HQ_BRANCH_INDICATOR")
    private String hqBranchIndicator;
    @Column(name="PREFERENTIAL_CURRENCY")
    private String preferentialCurrency;
    @Column(name="COMPANY_REG_DATE")
    private Timestamp companyRegDate;
    @Column(name="PURPOSE_OF_TIN")
    private String purposeOfTin;
    @Column(name="INACTIVE_INDICATOR")
    private String inActiveIndicator;
    @Column(name="TAMP_INDICATOR")
    private String tampIndicator;
 
    @Column(name="INTENTION_TO_EMPLOY_OTHERS")
    private String intentionToEmployeOthers;
    @Column(name="EXISTING_BUS_CAP_EQUITY")
    private Long exixtingBusCapEquity;
    @Column(name="EXISTING_BUS_CAP_LOAN")
    private Long exixtingBusCapLoan; 
    

    public EntOrganization() {
    }
    
    public String getAccountYearEndDay() {
        return accountYearEndDay;
    }

    public void setAccountYearEndDay(String accountYearEndDay) {
        this.accountYearEndDay = accountYearEndDay;
    }

    public String getAccountYearEndMonth() {
        return accountYearEndMonth;
    }

    public void setAccountYearEndMonth(String accountYearEndMonth) {
        this.accountYearEndMonth = accountYearEndMonth;
    }

    public Timestamp getBusinessEndDate() {
        return businessEndDate;
    }

    public void setBusinessEndDate(Timestamp businessEndDate) {
        this.businessEndDate = businessEndDate;
    }

    public Timestamp getBusinessStartDate() {
        return businessStartDate;
    }

    public void setBusinessStartDate(Timestamp businessStartDate) {
        this.businessStartDate = businessStartDate;
    }


    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getNonTaxToverAtReg() {
        return nonTaxToverAtReg;
    }

    public void setNonTaxToverAtReg(String nonTaxToverAtReg) {
        this.nonTaxToverAtReg = nonTaxToverAtReg;
    }

    public String getTaxableToverAtReg() {
        return taxableToverAtReg;
    }

    public void setTaxableToverAtReg(String taxableToverAtReg) {
        this.taxableToverAtReg = taxableToverAtReg;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setPersonalTaxNo(String personalTaxNo) {
        this.personalTaxNo = personalTaxNo;
    }

    public String getPersonalTaxNo() {
        return personalTaxNo;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setLegalNamePhonetic(String legalNamePhonetic) {
        this.legalNamePhonetic = legalNamePhonetic;
    }

    public String getLegalNamePhonetic() {
        return legalNamePhonetic;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setBranchFlag(String branchFlag) {
        this.branchFlag = branchFlag;
    }

    public String getBranchFlag() {
        return branchFlag;
    }

    public void setHqBranchIndicator(String hqBranchIndicator) {
        this.hqBranchIndicator = hqBranchIndicator;
    }

    public String getHqBranchIndicator() {
        return hqBranchIndicator;
    }

    public void setPreferentialCurrency(String preferentialCurrency) {
        this.preferentialCurrency = preferentialCurrency;
    }

    public String getPreferentialCurrency() {
        return preferentialCurrency;
    }

    public void setCompanyRegDate(Timestamp companyRegDate) {
        this.companyRegDate = companyRegDate;
    }

    public Timestamp getCompanyRegDate() {
        return companyRegDate;
    }

    public void setPurposeOfTin(String purposeOfTin) {
        this.purposeOfTin = purposeOfTin;
    }

    public String getPurposeOfTin() {
        return purposeOfTin;
    }

    public void setInActiveIndicator(String inActiveIndicator) {
        this.inActiveIndicator = inActiveIndicator;
    }

    public String getInActiveIndicator() {
        return inActiveIndicator;
    }

    public void setTampIndicator(String tampIndicator) {
        this.tampIndicator = tampIndicator;
    }

    public String getTampIndicator() {
        return tampIndicator;
    }

    public void setIntentionToEmployeOthers(String intentionToEmployeOthers) {
        this.intentionToEmployeOthers = intentionToEmployeOthers;
    }

    public String getIntentionToEmployeOthers() {
        return intentionToEmployeOthers;
    }

    public void setExixtingBusCapEquity(Long exixtingBusCapEquity) {
        this.exixtingBusCapEquity = exixtingBusCapEquity;
    }

    public Long getExixtingBusCapEquity() {
        return exixtingBusCapEquity;
    }

    public void setExixtingBusCapLoan(Long exixtingBusCapLoan) {
        this.exixtingBusCapLoan = exixtingBusCapLoan;
    }

    public Long getExixtingBusCapLoan() {
        return exixtingBusCapLoan;
    }
}
