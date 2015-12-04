package com.technobrain.trips.auditandvisit.model;

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
 * Model class representing the table AUDIT_PREPARATION_DETAIL. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditCaseDetails
 * 
 */
@Entity
@NamedQuery(name = "AuditPreparationDetail.findAll", 
    query = "select o from AuditPreparationDetail o")
@Table(name = "AUDIT_PREPARATION_DETAIL")
public class AuditPreparationDetail extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AUDIT_PREPARATION_DETAIL_SEQ")
    @SequenceGenerator(name = "AUDIT_PREPARATION_DETAIL_SEQ", 
                       sequenceName = "AUDIT_PREPARATION_DETAIL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="AUDIT_PREPARATION_TYPE")
    private String auditPreparationType;
    private String detail;
    
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private AuditCaseDetails auditCaseDetails;

    public AuditPreparationDetail() {
    }

    public String getAuditPreparationType() {
        return auditPreparationType;
    }

    public void setAuditPreparationType(String auditPreparationType) {
        this.auditPreparationType = auditPreparationType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuditCaseDetails getAuditCaseDetails() {
        return auditCaseDetails;
    }

    public void setAuditCaseDetails(AuditCaseDetails auditCaseDetails) {
        this.auditCaseDetails = auditCaseDetails;
    }
}
