package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.casemanagement.model.CaseDetails;
import com.technobrain.trips.debtmanagement.model.DebtCaseRecovery;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Model class representing the table AUDIT_CASE_DETAILS..
 * 
 *@since   
 *@see AuditCaseTaxType, OfficerAssessment, AuditPreparationDetail, AuditReportDetail
 * 
 */
@Entity
@NamedQuery(name = "AuditCaseDetails.findAll", 
    query = "select o from AuditCaseDetails o")
@Table(name = "AUDIT_CASE_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="CTYPE")
@DiscriminatorValue("AUDITCASE")
public class AuditCaseDetails extends CaseDetails {
    @Column(name="AUDIT_END_DATE")
    private Timestamp auditEndDate;
    @Column(name="AUDIT_START_DATE")
    private Timestamp auditStartDate;
    @Column(name="AUDIT_TYPE")
    private String auditType;    
    @Column(name="NUMBER_OF_VISITS")
    private Long numberOfVisits;
    @Column(name="TAXPAYER_NOTIFIED")
    private Boolean taxPayerNotified;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "auditCaseDetails")
    private List<AuditCaseTaxType> auditCaseTaxTypeList;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "auditCaseDetails")
    private List<OfficerAssessment> officerAssessmentList;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "auditCaseDetails")
    private List<AuditPreparationDetail> auditPreparationDetailList;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "auditCaseDetails")
    private List<AuditReportDetail> auditReportDetailList;

    public AuditCaseDetails() {
    }

    public Timestamp getAuditEndDate() {
        return auditEndDate;
    }

    public void setAuditEndDate(Timestamp auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public Timestamp getAuditStartDate() {
        return auditStartDate;
    }

    public void setAuditStartDate(Timestamp auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public List<AuditCaseTaxType> getAuditCaseTaxTypeList() {
        return auditCaseTaxTypeList;
    }

    public void setAuditCaseTaxTypeList(List<AuditCaseTaxType> auditCaseTaxTypeList) {
        this.auditCaseTaxTypeList = auditCaseTaxTypeList;
    }

    public AuditCaseTaxType addAuditCaseTaxType(AuditCaseTaxType auditCaseTaxType) {
        getAuditCaseTaxTypeList().add(auditCaseTaxType);
        auditCaseTaxType.setAuditCaseDetails(this);
        return auditCaseTaxType;
    }

    public AuditCaseTaxType removeAuditCaseTaxType(AuditCaseTaxType auditCaseTaxType) {
        getAuditCaseTaxTypeList().remove(auditCaseTaxType);
        auditCaseTaxType.setAuditCaseDetails(null);
        return auditCaseTaxType;
    }

    public List<OfficerAssessment> getOfficerAssessmentList() {
        return officerAssessmentList;
    }

    public void setOfficerAssessmentList(List<OfficerAssessment> officerAssessmentList) {
        this.officerAssessmentList = officerAssessmentList;
    }

    public OfficerAssessment addOfficerAssessment(OfficerAssessment officerAssessment) {
        getOfficerAssessmentList().add(officerAssessment);
        officerAssessment.setAuditCaseDetails(this);
        return officerAssessment;
    }

    public OfficerAssessment removeOfficerAssessment(OfficerAssessment officerAssessment) {
        getOfficerAssessmentList().remove(officerAssessment);
        officerAssessment.setAuditCaseDetails(null);
        return officerAssessment;
    }

    public List<AuditPreparationDetail> getAuditPreparationDetailList() {
        return auditPreparationDetailList;
    }

    public void setAuditPreparationDetailList(List<AuditPreparationDetail> auditPreparationDetailList) {
        this.auditPreparationDetailList = auditPreparationDetailList;
    }

    public AuditPreparationDetail addAuditPreparationDetail(AuditPreparationDetail auditPreparationDetail) {
        getAuditPreparationDetailList().add(auditPreparationDetail);
        auditPreparationDetail.setAuditCaseDetails(this);
        return auditPreparationDetail;
    }

    public AuditPreparationDetail removeAuditPreparationDetail(AuditPreparationDetail auditPreparationDetail) {
        getAuditPreparationDetailList().remove(auditPreparationDetail);
        auditPreparationDetail.setAuditCaseDetails(null);
        return auditPreparationDetail;
    }

    public List<AuditReportDetail> getAuditReportDetailList() {
        return auditReportDetailList;
    }

    public void setAuditReportDetailList(List<AuditReportDetail> auditReportDetailList) {
        this.auditReportDetailList = auditReportDetailList;
    }

    public AuditReportDetail addAuditReportDetail(AuditReportDetail auditReportDetail) {
        getAuditReportDetailList().add(auditReportDetail);
        auditReportDetail.setAuditCaseDetails(this);
        return auditReportDetail;
    }

    public AuditReportDetail removeAuditReportDetail(AuditReportDetail auditReportDetail) {
        getAuditReportDetailList().remove(auditReportDetail);
        auditReportDetail.setAuditCaseDetails(null);
        return auditReportDetail;
    }

    public void setTaxPayerNotified(Boolean taxPayerNotified) {
        this.taxPayerNotified = taxPayerNotified;
    }

    public Boolean getTaxPayerNotified() {
        return taxPayerNotified;
    }
}
