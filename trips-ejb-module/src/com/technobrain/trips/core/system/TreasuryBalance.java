package com.technobrain.trips.core.system;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
    {
    @NamedQuery(name = "TreasuryBalance.findAll", 
    query = "select o from TreasuryBalance o"),
    @NamedQuery(name = "TreasuryBalance.findTreasuryBalance", 
    query = "select o from TreasuryBalance o where o.code=?1")
    })
@Table(name = "TREASURY_BALANCE")
public class TreasuryBalance implements Serializable {
    @Column(name="ACCESS_LEVEL")
    private String accessLevel;
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    @Column(name="ORDER_SEQ")
    private Long orderSeq;
    private String status;
    @Column(name="UPDATED_BY")
    private String updatedBy;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;
    private BigDecimal value;
    private String version;

    public TreasuryBalance() {
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }   

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
