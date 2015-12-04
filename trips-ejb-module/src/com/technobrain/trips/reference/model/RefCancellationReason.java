package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefCancellationReason.findAll", 
            query = "select o from RefCancellationReason o")
@Table(name = "REF_CANCELLATION_REASON")
public class RefCancellationReason extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
//    @Column(name = "ADJUSTMENT_REASON")
//    private String adjustmentReason;
    @ManyToOne
    @JoinColumn(name = "ADJUSTMENT_TYPE", referencedColumnName = "CODE")
    private RefAdjustmentType adjustmentType;

    public RefCancellationReason() {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

//    public void setAdjustmentReason(String adjustmentReason) {
//        this.adjustmentReason = adjustmentReason;
//    }
//
//    public String getAdjustmentReason() {
//        return adjustmentReason;
//    }

    public void setAdjustmentType(RefAdjustmentType adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public RefAdjustmentType getAdjustmentType() {
        return adjustmentType;
    }
}
