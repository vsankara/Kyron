package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntIdentification;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table AUDIT_REPORT. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditReportRecord
 * 
 */
@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AuditReport.findAll",query = "select o from AuditReport o"),
    @NamedQuery(name = "AuditReport.findReportByProfileId", query = "select o from AuditReport o where o.profileId = ?1")
    })
@Table(name = "AUDIT_REPORT")
public class AuditReport extends BaseNormalModelObject {
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_REPORT_SEQ")
    @SequenceGenerator(name = "AUDIT_REPORT_SEQ", sequenceName = "AUDIT_REPORT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="PROFILE_ID")
    private String profileId;
    @Column(name="PROFILE_NAME")
    private String profileName;    
    @Column(name="REPORT_ID", nullable = false)
    private String reportId;
    @Column(name="REPORT_NAME")
    private String reportName;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "auditReport")
    private List<AuditReportRecord> auditReportRecordList;
    
    public AuditReport() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setAuditReportRecordList(List<AuditReportRecord> auditReportRecordList) {
        this.auditReportRecordList = auditReportRecordList;
    }

    public List<AuditReportRecord> getAuditReportRecordList() {
        return auditReportRecordList;
    }
    
    public AuditReportRecord addAuditReportRecord(AuditReportRecord auditReportRecord) {
        getAuditReportRecordList().add(auditReportRecord);
        auditReportRecord.setAuditReport(this);
        return auditReportRecord;
    }
    
    public AuditReportRecord removeAuditReportRecord(AuditReportRecord auditReportRecord) {
        getAuditReportRecordList().remove(auditReportRecord);
        auditReportRecord.setAuditReport(null);
        return auditReportRecord;
    }
}
