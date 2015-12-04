package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCaseModuleLink.findAll", query = "select o from RefCaseModuleLink o")
@Table(name = "REF_CASE_MODULE_LINK")
public class RefCaseModuleLink extends BaseRefModelObject {
    
    @Id
    @Column(nullable = false)
    private String code;    
    private String description;
    
    @Column(name="COMPLIANCE_TYPE")
    private String complianceType;
    @Column(name="MODULE_LINK")
    private String moduleLink;
    @Column(name="CASE_REASON")
    private String caseReason;
    @Column(name="CASE_STATUS")
    private String caseStatus;
    @Column(name="CASE_TYPE")
    private String caseType;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @Column(name="TAX_TYPE")
    private String taxType;

    public RefCaseModuleLink() {
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getModuleLink() {
        return moduleLink;
    }

    public void setModuleLink(String moduleLink) {
        this.moduleLink = moduleLink;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }
}
