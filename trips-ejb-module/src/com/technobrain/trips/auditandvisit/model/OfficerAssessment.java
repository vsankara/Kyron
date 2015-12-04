package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Model class representing the table OFFICER_ASSESSMENT. 
 * 
 *@author
 *@version
 *@since   
 *@see v, DebtCaseWriteOff
 * 
 */
@Entity
@NamedQuery(name = "OfficerAssessment.findAll", 
    query = "select o from OfficerAssessment o")
@Table(name = "OFFICER_ASSESSMENT")
public class OfficerAssessment extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFICER_ASSESSMENT_SEQ")
    @SequenceGenerator(name = "OFFICER_ASSESSMENT_SEQ", sequenceName = "OFFICER_ASSESSMENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ADJUSTMENT_TYPE")
    private String adjustmentType;
    @Column(name="ASSESSMENT_DATE")
    private Timestamp assessmentDate;
    @Column(name="DUE_FROM_COMMISSIONER")
    private BigDecimal dueFromCommissioner;
    @Column(name="DUE_TO_COMMISSIONER")
    private BigDecimal dueToCommissioner;    
    @Column(name="NET_PAYABLE")
    private BigDecimal netPayable;
    private Long period;
    private String reason;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="ACCOUNT_ID")
    private Long accountId;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private AuditCaseDetails auditCaseDetails;

    public OfficerAssessment() {
    }

    public String getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Timestamp getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Timestamp assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public BigDecimal getDueFromCommissioner() {
        return dueFromCommissioner;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public AuditCaseDetails getAuditCaseDetails() {
        return auditCaseDetails;
    }

    public void setAuditCaseDetails(AuditCaseDetails auditCaseDetails) {
        this.auditCaseDetails = auditCaseDetails;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getPeriod() {
        return period;
    }


    public void setDueFromCommissioner(BigDecimal dueFromCommissioner) {
        this.dueFromCommissioner = dueFromCommissioner;
    }

    public void setDueToCommissioner(BigDecimal dueToCommissioner) {
        this.dueToCommissioner = dueToCommissioner;
    }

    public BigDecimal getDueToCommissioner() {
        return dueToCommissioner;
    }

    public void setNetPayable(BigDecimal netPayable) {
        this.netPayable = netPayable;
    }

    public BigDecimal getNetPayable() {
        return netPayable;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
