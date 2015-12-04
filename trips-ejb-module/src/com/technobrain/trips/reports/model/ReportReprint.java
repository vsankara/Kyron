package com.technobrain.trips.reports.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@NamedQuery(name = "ReportReprint.findAll", 
    query = "select o from ReportReprint o")
@Table(name = "REPORT_REPRINT")
public class ReportReprint extends BaseNormalModelObject {
    @Column(name="DEFAULT_ASSIGNMENT_GROUP")
    private String defaultAssignmentGroup;
    @Column(name="DEFAULT_ASSIGNMENT_USER") 
    private String defaultAssignmentUser;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_REPRINT_SEQ")
    @SequenceGenerator(name = "REPORT_REPRINT_SEQ", sequenceName = "REPORT_REPRINT_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;


    @Column(name="OWNER_GROUP")
    private String ownerGroup;
    @Column(name="OWNER_USER")
    private String ownerUser;
    @Column(name="REPRINT_REASON")
    private String reprintReason;
    
    @Column(name="WATERMARK_USED")
    private String waterMarkUsed;
    

    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "REP_STORE_ID", referencedColumnName = "ID")
    private ReportStore reportstore;
  
    @Column(name = "REPRINT_DATE")
    private Timestamp reprintDate;

    public ReportReprint() {
    }

    public String getDefaultAssignmentGroup() {
        return defaultAssignmentGroup;
    }

    public void setDefaultAssignmentGroup(String defaultAssignmentGroup) {
        this.defaultAssignmentGroup = defaultAssignmentGroup;
    }

    public String getDefaultAssignmentUser() {
        return defaultAssignmentUser;
    }

    public void setDefaultAssignmentUser(String defaultAssignmentUser) {
        this.defaultAssignmentUser = defaultAssignmentUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerGroup() {
        return ownerGroup;
    }

    public void setOwnerGroup(String ownerGroup) {
        this.ownerGroup = ownerGroup;
    }

    public String getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(String ownerUser) {
        this.ownerUser = ownerUser;
    }


    public void setReprintReason(String reprintReason) {
        this.reprintReason = reprintReason;
    }

    public String getReprintReason() {
        return reprintReason;
    }

       public void setReprintDate(Timestamp reprintDate) {
        this.reprintDate = reprintDate;
    }

    public Timestamp getReprintDate() {
        return reprintDate;
    }

    public void setWaterMarkUsed(String waterMarkUsed) {
        this.waterMarkUsed = waterMarkUsed;
    }

    public String getWaterMarkUsed() {
        return waterMarkUsed;
    }

    public void setReportstore(ReportStore reportstore) {
        this.reportstore = reportstore;
    }

    public ReportStore getReportstore() {
        return reportstore;
    }
}
