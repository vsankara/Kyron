package com.technobrain.trips.reports.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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


@Entity
@NamedQueries(
    { 
    @NamedQuery(name = "ReportDetails.findAll", 
    query = "select o from ReportDetails o"),
    @NamedQuery(name= "ReportDetails.findReportDetailsByName",
    query = "select o from ReportDetails o where o.reportName=?1")
    })
@Table(name = "REPORT_DETAILS")
public class ReportDetails extends BaseNormalModelObject {
    
    
    @Column(name="DEFAULT_ASSIGNMENT_GROUP")
    private String defaultAssignmentGroup;
    @Column(name="DEFAULT_ASSIGNMENT_USER")
    private String defaultAssignmentUser;
    @Column(name="ENABLE_COPIES")
    private String enableCopies;
    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_DETAILS_SEQ")
        @SequenceGenerator(name = "REPORT_DETAILS_SEQ", sequenceName = "REPORT_DETAILS_SEQ", allocationSize = 1)        
        @Column(nullable = false)
        private Long id;
    @Column(name="OWNER_GROUP")
    private String ownerGroup;
    @Column(name="OWNER_USER")
    private String ownerUser;    
    @Column(name="REPORT_NAME")
    private String reportName;
    @Column(name="PRINTER_TYPE")
    private String printerType;
    //@Column(name="REPORT_TYPE")
    //private String reportType;    
//    @Column(name="STORE_LOCATION")
//    private String storeLocation;
//    @Column(name="TASK_OFFICE")
//    private String taskOffice;
//    @Column(name="TASK_TYPE")
//    private String taskType;
    @OneToMany(mappedBy = "reportDetails",cascade={CascadeType.ALL})
    private List<ReportParameters> reportParametersList;
    
    @Column(name="CONFIGURATION_COMPLETED")
    private String configurationCompleted;
//    @OneToMany(mappedBy = "reportDetails", cascade={CascadeType.ALL})
//     private List<ReportStore> reportStorelist;
    @OneToMany(mappedBy = "reportDetails",cascade={CascadeType.ALL})
    private List<ReportGroups> reportGroupsList;

    public ReportDetails() {
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

    public String getEnableCopies() {
        return enableCopies;
    }

    public void setEnableCopies(String enableCopies) {
        this.enableCopies = enableCopies;
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

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    
    public void setReportParametersList(List<ReportParameters> reportParametersList) {
        this.reportParametersList = reportParametersList;
    }

    public List<ReportParameters> getReportParametersList() {
        return reportParametersList;
    }

//   public void setReportStorelist(List<ReportStore> reportStorelist) {
//        this.reportStorelist = reportStorelist;
//    }
//
//    public List<ReportStore> getReportStorelist() {
//        return reportStorelist;
//    }

    public void setConfigurationCompleted(String configurationCompleted) {
        this.configurationCompleted = configurationCompleted;
    }

    public String getConfigurationCompleted() {
        return configurationCompleted;
    }

    public void setReportGroupsList(List<ReportGroups> reportGroupsList) {
        this.reportGroupsList = reportGroupsList;
    }

    public List<ReportGroups> getReportGroupsList() {
        return reportGroupsList;
    }
    
    public ReportGroups addReportGroups(ReportGroups reportGroups) {
        reportGroups.setReportDetails(this);
        getReportGroupsList().add(reportGroups);
        return reportGroups;
    }

    public ReportGroups removeReportGroups(ReportGroups reportGroups) {
        getReportGroupsList().remove(reportGroups);
        return reportGroups;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public String getPrinterType() {
        return printerType;
    }
}
