package com.technobrain.trips.core.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;

@MappedSuperclass
public abstract class BaseModelObject implements Serializable {
    public static final Logger log = Logger.getLogger(BaseModelObject.class);
    
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    @Column(name="UPDATED_BY")
    private String updatedBy;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;
    @Column(name="STATUS")
    protected String status;
    @Column(name="VERSION")
    private Long version;
    @Column(name="ACCESS_LEVEL")
    private String accessLevel;
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }   
    
    public abstract boolean equals(Object other);

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public final void setStatus(String status) {
        this.status = status;
    }

    public final String getStatus() {
        return status;
    }

    public final void setVersion(Long version) {
        this.version = version;
    }

    public final Long getVersion() {
        return version;
    }
    
    /**
     * Provide common functions for a business object
     * @return
     */
    public FunctionalBusinessObject getFunctions(){
        return new FunctionalBusinessObject(this);
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}
