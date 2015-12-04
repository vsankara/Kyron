package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table CASE_MEMBER_LOG. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */
@Entity
@NamedQuery(name = "CaseMemberLog.findAll", 
    query = "select o from CaseMemberLog o")
@Table(name = "CASE_MEMBER_LOG")
public class CaseMemberLog extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_MEMBER_LOG_SEQ")
    @SequenceGenerator(name = "CASE_MEMBER_LOG_SEQ", 
                       sequenceName = "CASE_MEMBER_LOG_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ASSIGNED_BY")
    private String assignedBy;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
      
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;
     
    @Column(name="MEMBER_ID")
    private Long memberId;
    
    @Column(name="CASE_GROUP_ASSIGN_ID")
    private Long caseGroupAssignId;

    public CaseMemberLog() {
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }

    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setCaseGroupAssignId(Long caseGroupAssignId) {
        this.caseGroupAssignId = caseGroupAssignId;
    }

    public Long getCaseGroupAssignId() {
        return caseGroupAssignId;
    }
}
