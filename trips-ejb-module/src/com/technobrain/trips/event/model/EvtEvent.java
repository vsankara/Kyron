package com.technobrain.trips.event.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EvtEvent extends BaseNormalModelObject {

    @Column(name="EFFECTIVE_DATE")
    protected Timestamp effectiveDate;
    @Column(name="EVENT_DATE")
    protected Timestamp eventDate;// nullable false.
    @Column(name="EXPIRY_DATE")
    protected Timestamp expiryDate; 
    @Column(name="INITIATED_BY")
    protected String initiatedBy; // nullable false
    protected String notes;
    @Column(name="WORKFLOW_TYPE")
    protected String workflowType;
    @Column(name="PARENT_EVENT")
    protected Long parentEvent;
    @Column(name="REF_EVT_TYPE_CAT")
    protected String refEvtTypeCat; // nullable false
    @Column(name="RELATED_MODULE_ID")
    protected Long relatedModuleId; // nullable false
    @Column(name="REGISTRATION_STATUS")
    protected String registrationStatus;
    @Column(name="REASON")
    protected String reason;

    public EvtEvent() {
    }

    
    
    
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    
    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getParentEvent() {
        return parentEvent;
    }

    public void setParentEvent(Long parentEvent) {
        this.parentEvent = parentEvent;
    }

    public String getRefEvtTypeCat() {
        return refEvtTypeCat;
    }

    public void setRefEvtTypeCat(String refEvtTypeCat) {
        this.refEvtTypeCat = refEvtTypeCat;
    }
    
    
    public Long getRelatedModuleId() {
        return relatedModuleId;
    }

    public void setRelatedModuleID(Long relatedModuleId) {
        this.relatedModuleId = relatedModuleId;
    }

    public void setWorkflowType(String workflowType) {
        this.workflowType = workflowType;
    }

    public String getWorkflowType() {
        return workflowType;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
