package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefExemptionCode.findAll", 
    query = "select o from RefExemptionCode o")
@Table(name = "REF_EXEMPTION_CODE")
public class RefExemptionCode extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    @ManyToOne
    @JoinColumn(name = "COMM_CODE", referencedColumnName = "CODE", nullable = false)
    private RefComCode commCode;
     
     
     
     
    @Column(name="DATE_APPLIES")
    private Timestamp dateApplies;
    @Column(name="DATE_EXPIRES")
    private Timestamp dateExpires;
    @Column(nullable = false)
    private String description;
    private Long reduction;
    @Column(nullable = false)
    private Long seq;
    @ManyToOne
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE", nullable = false)
    private RefCustTaxType taxType;
     
     
     
     
     
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefExemptionCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCommCode(RefComCode commCode) {
        this.commCode = commCode;
    }

    public RefComCode getCommCode() {
        return commCode;
    }

    public Timestamp getDateApplies() {
        return dateApplies;
    }

    public void setDateApplies(Timestamp dateApplies) {
        this.dateApplies = dateApplies;
    }

    public Timestamp getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Timestamp dateExpires) {
        this.dateExpires = dateExpires;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReduction() {
        return reduction;
    }

    public void setReduction(Long reduction) {
        this.reduction = reduction;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public void setTaxType(RefCustTaxType taxType) {
        this.taxType = taxType;
    }

    public RefCustTaxType getTaxType() {
        return taxType;
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
}
