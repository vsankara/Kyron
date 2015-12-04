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
@NamedQuery(name = "ReportParameters.findAll", 
    query = "select o from ReportParameters o")
@Table(name = "REPORT_PARAMETERS")
public class ReportParameters extends BaseNormalModelObject {
    
    @Column(name="DEFAULT_VALUE")
    private String defaultValue;
    @Column(name="FIELD_NAME")
    private String fieldName;
    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_PARAMETERS_SEQ")
        @SequenceGenerator(name = "REPORT_PARAMETERS_SEQ", sequenceName = "REPORT_PARAMETERS_SEQ", allocationSize = 1)        
        @Column(nullable = false)
        private Long id;
    private String label;
    @Column(name="LIST_NAME")
    private String listName;
    @Column(name="SEQUENCE_NUMBER")
    private Long sequenceNumber;
    private String mandatory;
    @Column(name="HAS_OPTION_ALL_IN_LIST") 
    private String hasOptionAllInList;
    @ManyToOne
    @JoinColumn(name = "REPORT_DETAILS", referencedColumnName = "ID")
    private ReportDetails reportDetails;
    
    private String type;        

    public ReportParameters() {
    }   

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public ReportDetails getReportDetails() {
        return reportDetails;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }
    
    public void setHasOptionAllInList(String hasOptionAllInList) {
        this.hasOptionAllInList = hasOptionAllInList;
    }

    public String getHasOptionAllInList() {
        return hasOptionAllInList;
    }
}
