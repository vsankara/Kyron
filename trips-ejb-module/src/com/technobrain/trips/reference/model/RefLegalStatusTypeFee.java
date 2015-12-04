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
@NamedQuery(name = "RefLegalStatusTypeFee.findAll", 
            query = "select o from RefLegalStatusTypeFee o")
@Table(name = "REF_LEGAL_STATUS_TYPE_FEE")
public class RefLegalStatusTypeFee extends BaseRefModelObject{
    
    
    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "LEGAL_STATUS_TYPE_CODE", referencedColumnName = "CODE")
    private RefLegalStatusType refLegalStatusType;
    
    @ManyToOne
    @JoinColumn(name = "FEE_TYPE_CODE", referencedColumnName = "CODE")
    private RefFeeType refFeeType;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    public RefLegalStatusTypeFee() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setRefLegalStatusType(RefLegalStatusType refLegalStatusType) {
        this.refLegalStatusType = refLegalStatusType;
    }

    public RefLegalStatusType getRefLegalStatusType() {
        return refLegalStatusType;
    }

    public void setRefFeeType(RefFeeType refFeeType) {
        this.refFeeType = refFeeType;
    }

    public RefFeeType getRefFeeType() {
        return refFeeType;
    }
}
