package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntEntity;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table AUDIT_REPORT_RECORD. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditReport
 * 
 */
@Entity
@NamedQueries ({
@NamedQuery(name = "AuditReportRecord.findAll",query = "select o from AuditReportRecord o"),
@NamedQuery(name = "AuditReportRecord.findReportBySystemCaseStatus", query = "select distinct arr from  AuditReportRecord arr where arr.sysCaseCreated is null or arr.sysCaseCreated <> ?1"),
@NamedQuery(name = "AuditReportRecord.findReportByTin", query = "select o from AuditReportRecord o where o.id = (select max(a.id) from AuditReportRecord a where a.tin=?1)")
})

@Table(name = "AUDIT_REPORT_RECORD")
public class AuditReportRecord extends BaseNormalModelObject {    
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_REPORT_RECORD_SEQ")
    @SequenceGenerator(name = "AUDIT_REPORT_RECORD_SEQ", sequenceName = "AUDIT_REPORT_RECORD_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "AUDIT_REPORT_ID", referencedColumnName = "ID")     
    private AuditReport auditReport;
    @Column(name="BUSINESS_SECTOR")
    private String businessSector;   
    
    @Column(name="REPORT_INCLUSION_INDICATOR")
    private String reportInclusionIndicator;
    @Column(name="RISK_BAND_CODE")
    private String riskBandCode;
    private Long score;    
    private String tin;
    @Column(name="SYSTEM_CASE_CRATED")
    private String sysCaseCreated;

    public AuditReportRecord() {
    }
    
    
    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportInclusionIndicator() {
        return reportInclusionIndicator;
    }

    public void setReportInclusionIndicator(String reportInclusionIndicator) {
        this.reportInclusionIndicator = reportInclusionIndicator;
    }

    public String getRiskBandCode() {
        return riskBandCode;
    }

    public void setRiskBandCode(String riskBandCode) {
        this.riskBandCode = riskBandCode;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    } 

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setAuditReport(AuditReport auditReport) {
        this.auditReport = auditReport;
    }

    public AuditReport getAuditReport() {
        return auditReport;
    }


    public void setSysCaseCreated(String sysCaseCreated) {
        this.sysCaseCreated = sysCaseCreated;
    }

    public String getSysCaseCreated() {
        return sysCaseCreated;
    }
}
