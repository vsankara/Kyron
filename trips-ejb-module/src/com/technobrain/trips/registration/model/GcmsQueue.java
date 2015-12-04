package com.technobrain.trips.registration.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GcmsQueue.findAll", query = "select o from GcmsQueue o")
@Table(name = "GCMS_QUEUE")
public class GcmsQueue implements Serializable {
    @Column(name="CREATED_DATE", nullable = false)
    private Timestamp createdDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "GCMS_QUEUE_SEQ")
    @SequenceGenerator(name = "GCMS_QUEUE_SEQ", 
                       sequenceName = "GCMS_QUEUE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
     
    @Column(name="PROCESSED", nullable = false)
    private boolean processed;
    @Column(name="REQUEST_PARAMS", nullable = false)
    private byte[] requestParams;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;

    public GcmsQueue() {
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public byte[] getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(byte[] requestParams) {
        this.requestParams = requestParams;
    }

     public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isProcessed() {
        return processed;
    }
}
