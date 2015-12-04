package com.technobrain.trips.application.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppTaxpayerExempt.findAll", query = "select o from AppTaxpayerExempt o")
@Table(name = "APP_TAXPAYER_EXEMPT")
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("TAXPAYER_EXEMPTION")
public class AppTaxpayerExempt extends AppApplication {
    @Column(name="AGENT_DETAILS")
    private Long agentDetails;
    private String comments;
    @Column(name="COMMUNITY_CODE")  
    private String communityCode;
    @Column(name="EXEMPTION_CODE")
    private String exemptionCode;
    @Column(name="EXEMPTION_TYPE")
    private String exemptionType;
    @Column(name="LEGAL_REFERENCE")
    private String legalReference;
    private BigDecimal rate;
    private BigDecimal reduction;
    @Column(name="TAX_TYPE", nullable = false)
    private String taxType;
    @Column(name="CUSTOMS_TAX_TYPE")
    private String customsTaxType;    
    @Column(name="ALL_COMMODITIES_INDICATOR")
    private String allCommoditiesIndicator;
    @OneToMany(mappedBy = "appTaxpayerExempt", cascade={CascadeType.ALL})
    private List<AppTaxpExemptCommodity> appTaxpExemptCommodityList;
    
    @Column(name="PERSONAL_EXEMPT")
    private BigDecimal personalExempt;
    @Column(name="ADDITIONAL_EXEMPT")
    private BigDecimal additonalExemption;
    @Column(name="INSURANCE_PREMUIM")
    private BigDecimal insurancePremuim;
    @Column(name="WITH_DEPENDENTS")
    private String withDependents; 
    @Column(name="SPOUSE_CLAIM_EXEMPT")
    private String spouseClaimAdditionalExemption; 
    @Column(name="WAIVER_ATTACHED")
    private String waiverAttached; 
    
    @OneToMany(mappedBy = "appTaxpayerExempt", cascade={CascadeType.ALL})
    private List<AppTaxpExemptSpouse> appTaxpExemptSpouseList;
    
    @OneToMany(mappedBy = "appTaxpayerExempt", cascade={CascadeType.ALL})
    private List<AppTaxpExemptDependents> appTaxpExemptDependentsList;
    
    public AppTaxpayerExempt() {
    }

    public AppTaxpExemptDependents addAppTaxpExemptDependents(AppTaxpExemptDependents appTaxpExemptDependents) {
        getAppTaxpExemptDependentsList().add(appTaxpExemptDependents);
        appTaxpExemptDependents.setAppTaxpayerExempt(this);
        return appTaxpExemptDependents;
    }

    public AppTaxpExemptDependents removeAppTaxpExemptDependents(AppTaxpExemptDependents appTaxpExemptDependents) {
        getAppTaxpExemptDependentsList().remove(appTaxpExemptDependents);
        appTaxpExemptDependents.setAppTaxpayerExempt(null);
        return appTaxpExemptDependents;
    }
    
    public AppTaxpExemptSpouse addAppTaxpExemptSpouse(AppTaxpExemptSpouse appTaxpExemptSpouse) {
        getAppTaxpExemptSpouseList().add(appTaxpExemptSpouse);
        appTaxpExemptSpouse.setAppTaxpayerExempt(this);
        return appTaxpExemptSpouse;
    }

    public AppTaxpExemptSpouse removeAppTaxpExemptSpouse(AppTaxpExemptSpouse appTaxpExemptSpouse) {
        getAppTaxpExemptSpouseList().remove(appTaxpExemptSpouse);
        appTaxpExemptSpouse.setAppTaxpayerExempt(null);
        return appTaxpExemptSpouse;
    }
    
    public Long getAgentDetails() {
        return agentDetails;
    }

    public void setAgentDetails(Long agentDetails) {
        this.agentDetails = agentDetails;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getExemptionCode() {
        return exemptionCode;
    }

    public void setExemptionCode(String exemptionCode) {
        this.exemptionCode = exemptionCode;
    }

    public String getExemptionType() {
        return exemptionType;
    }

    public void setExemptionType(String exemptionType) {
        this.exemptionType = exemptionType;
    }

    public String getLegalReference() {
        return legalReference;
    }

    public void setLegalReference(String legalReference) {
        this.legalReference = legalReference;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public List<AppTaxpExemptCommodity> getAppTaxpExemptCommodityList() {
        return appTaxpExemptCommodityList;
    }

    public void setAppTaxpExemptCommodityList(List<AppTaxpExemptCommodity> appTaxpExemptCommodityList) {
        this.appTaxpExemptCommodityList = appTaxpExemptCommodityList;
    }

    public AppTaxpExemptCommodity addAppTaxpExemptCommodity(AppTaxpExemptCommodity appTaxpExemptCommodity) {
        getAppTaxpExemptCommodityList().add(appTaxpExemptCommodity);
        appTaxpExemptCommodity.setAppTaxpayerExempt(this);
        return appTaxpExemptCommodity;
    }

    public AppTaxpExemptCommodity removeAppTaxpExemptCommodity(AppTaxpExemptCommodity appTaxpExemptCommodity) {
        getAppTaxpExemptCommodityList().remove(appTaxpExemptCommodity);
        appTaxpExemptCommodity.setAppTaxpayerExempt(null);
        return appTaxpExemptCommodity;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setAllCommoditiesIndicator(String allCommoditiesIndicator) {
        this.allCommoditiesIndicator = allCommoditiesIndicator;
    }

    public String getAllCommoditiesIndicator() {
        return allCommoditiesIndicator;
    }

    public void setCustomsTaxType(String customsTaxType) {
        this.customsTaxType = customsTaxType;
    }

    public String getCustomsTaxType() {
        return customsTaxType;
    }

    public void setPersonalExempt(BigDecimal personalExempt) {
        this.personalExempt = personalExempt;
    }

    public BigDecimal getPersonalExempt() {
        return personalExempt;
    }

    public void setInsurancePremuim(BigDecimal insurancePremuim) {
        this.insurancePremuim = insurancePremuim;
    }

    public BigDecimal getInsurancePremuim() {
        return insurancePremuim;
    }

    public void setWithDependents(String withDependents) {
        this.withDependents = withDependents;
    }

    public String getWithDependents() {
        return withDependents;
    }

    public void setSpouseClaimAdditionalExemption(String spouseClaimAdditionalExemption) {
        this.spouseClaimAdditionalExemption = spouseClaimAdditionalExemption;
    }

    public String getSpouseClaimAdditionalExemption() {
        return spouseClaimAdditionalExemption;
    }

    public void setWaiverAttached(String waiverAttached) {
        this.waiverAttached = waiverAttached;
    }

    public String getWaiverAttached() {
        return waiverAttached;
    }

    public void setAppTaxpExemptSpouseList(List<AppTaxpExemptSpouse> appTaxpExemptSpouseList) {
        this.appTaxpExemptSpouseList = appTaxpExemptSpouseList;
    }

    public List<AppTaxpExemptSpouse> getAppTaxpExemptSpouseList() {
        return appTaxpExemptSpouseList;
    }

    public void setAppTaxpExemptDependentsList(List<AppTaxpExemptDependents> appTaxpExemptDependentsList) {
        this.appTaxpExemptDependentsList = appTaxpExemptDependentsList;
    }

    public List<AppTaxpExemptDependents> getAppTaxpExemptDependentsList() {
        return appTaxpExemptDependentsList;
    }

    public void setAdditonalExemption(BigDecimal additonalExemption) {
        this.additonalExemption = additonalExemption;
    }

    public BigDecimal getAdditonalExemption() {
        return additonalExemption;
    }
}
