package com.technobrain.trips.registration.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries( {
@NamedQuery(name = "GeRegQueue.findAll", query = "select o from GeRegQueue o"),
@NamedQuery(name = "GeRegQueue.findByProcessed", query = "select o from GeRegQueue o where o.processed = ?1")})
@Table(name = "GEREG_QUEUE")
public class GeRegQueue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "GEREG_QUEUE_SEQ")
    @SequenceGenerator(name = "GEREG_QUEUE_SEQ", 
                       sequenceName = "GCMS_QUEUE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(name = "PROCESSED", nullable = false)
    private boolean processed;

    @Column(name = "REQUEST_PARAMS", nullable = false)
    private byte[] requestParams;

    @Column(name = "SERVICE_NAME", nullable = false)
    private String serviceName;

    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;

    @Column(name = "UPDATED_DATE")
    private Timestamp updatedDate;

    public GeRegQueue() {
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
