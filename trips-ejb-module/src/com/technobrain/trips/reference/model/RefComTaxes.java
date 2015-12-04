package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefComTaxes.findAll", 
    query = "select o from RefComTaxes o")
@Table(name = "REF_COM_TAXES")
public class RefComTaxes extends BaseNormalModelObject   {
    private String band;
    @Column(name="COMM_CODE", nullable = false)
    private String commCode;
     
     
     
     
    @Column(name="DATE_APPLIES")
    private Timestamp dateApplies;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_com_taxes_seq")
    @SequenceGenerator(name = "ref_com_taxes_seq", sequenceName = "ref_com_taxes_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long seq;
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "AGREEMENT_CODE", referencedColumnName = "CODE")
    private RefCustAgreementCode refCustAgreementCode;
    @ManyToOne
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE")
    private RefCustTaxType refCustTaxType;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    public RefComTaxes() {
    }


    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public Timestamp getDateApplies() {
        return dateApplies;
    }

    public void setDateApplies(Timestamp dateApplies) {
        this.dateApplies = dateApplies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public RefCustAgreementCode getRefCustAgreementCode() {
        return refCustAgreementCode;
    }

    public void setRefCustAgreementCode(RefCustAgreementCode refCustAgreementCode) {
        this.refCustAgreementCode = refCustAgreementCode;
    }

    public RefCustTaxType getRefCustTaxType() {
        return refCustTaxType;
    }

    public void setRefCustTaxType(RefCustTaxType refCustTaxType) {
        this.refCustTaxType = refCustTaxType;
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
