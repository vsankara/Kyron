package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.document.model.DdocDocument;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCaseEvent.findAll", query = "select o from RefCaseEvent o")
@Table(name = "REF_CASE_EVENT")
public class RefCaseEvent extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;    
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EVENT_TYPE")
    private String eventType;
    @Column(name="NAME")
    private String name;
    @Column(name="MANDAYS")
    private Long manDays;
    @Column(name="MANHOURS")
    private Long manHours;
    
    @OneToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "REPORT_TYPE", referencedColumnName = "CODE")
    private RefDocType reportType;  

    public RefDocType getReportType() {
        return reportType;
    }

    public void setReportType(RefDocType reportType) {
        this.reportType = reportType;
    }    
    
    public RefCaseEvent() {
    }

    public String getCode() {
    return code;
    }

    public void setCode(String code) {
    this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String eventDescription) {
        this.description = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManDays() {
        return manDays;
    }

    public void setManDays(Long manDays) {
        this.manDays = manDays;
    }

    public Long getManHours() {
        return manHours;
    }

    public void setManHours(Long manHours) {
        this.manHours = manHours;
    } 
}
