package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@IdClass(RefLegalStatusEffectiveFeePK.class)
@NamedQuery(name = "RefLegalStatusTypeFeeEff.findAll", 
            query = "select o from RefLegalStatusTypeFeeEff o")
@Table(name = "REF_LEGAL_STATUS_TYPE_FEE_EFF")
public class RefLegalStatusTypeFeeEff extends BaseRefModelObject implements Serializable {
    
    @Id
    @Column(name="CODE", insertable=false, updatable=false)
    private String code;
    
    @Id
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @ManyToOne
    @JoinColumn(name="CODE")
    private RefLegalStatusTypeFee refLegalStatusTypeFee;
    
    
    @Column(name="AMOUNT") 
    private BigDecimal amount;

    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    

    public RefLegalStatusTypeFeeEff() {
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setRefLegalStatusTypeFee(RefLegalStatusTypeFee refLegalStatusTypeFee) {
        this.refLegalStatusTypeFee = refLegalStatusTypeFee;
    }

    public RefLegalStatusTypeFee getRefLegalStatusTypeFee() {
        return refLegalStatusTypeFee;
    }
    
    public void setCode(String code) {
        this.code=code;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }
}
