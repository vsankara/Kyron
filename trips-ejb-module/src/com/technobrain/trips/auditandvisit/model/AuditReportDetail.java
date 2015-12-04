package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
 * Model class representing the table AUDIT_REPORT_DETAIL. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditReportDetail
 * 
 */
@Entity
@NamedQuery(name = "AuditReportDetail.findAll", 
    query = "select o from AuditReportDetail o")
@Table(name = "AUDIT_REPORT_DETAIL")
public class AuditReportDetail extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AUDIT_REPORT_DETAIL_SEQ")
    @SequenceGenerator(name = "AUDIT_REPORT_DETAIL_SEQ", 
                       sequenceName = "AUDIT_REPORT_DETAIL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="AUDIT_REPORT_DETAIL_TYPE")
    private String auditReportDetailType;
    
    private String detail;
    
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private AuditCaseDetails auditCaseDetails;

    public AuditReportDetail() {
    }

    public String getAuditReportDetailType() {
        return auditReportDetailType;
    }

    public void setAuditReportDetailType(String auditReportDetailType) {
        this.auditReportDetailType = auditReportDetailType;
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
