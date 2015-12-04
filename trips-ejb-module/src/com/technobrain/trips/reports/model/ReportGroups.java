package com.technobrain.trips.reports.model;

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


@Entity
@NamedQuery(name = "ReportGroups.findAll", 
    query = "select o from ReportGroups o")
@Table(name = "REPORT_GROUPS")
public class ReportGroups extends BaseNormalModelObject {
   
    @Column(name="GROUP_NAME")
    private String group;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_GROUPS_SEQ")
    @SequenceGenerator(name = "REPORT_GROUPS_SEQ", sequenceName = "REPORT_GROUPS_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "REPORT_DETAILS", referencedColumnName = "ID")
    private ReportDetails reportDetails;
   

    public ReportGroups() {
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public ReportDetails getReportDetails() {
        return reportDetails;
    }
}
