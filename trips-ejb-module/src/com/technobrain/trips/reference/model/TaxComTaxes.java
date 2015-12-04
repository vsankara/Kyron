package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "TaxComTaxes.findAll", 
    query = "select o from TaxComTaxes o")
@Table(name = "TAX_COM_TAXES")
public class TaxComTaxes extends BaseNormalModelObject {
    @Column(name="COMM_CODE", nullable = false)
    private String commCode;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long seq;
    @Column(name="TAX_BAND")
    private Long taxBand;
    @Column(name="TAX_RATE_TABLE")
    private Long taxRateTable;

    public TaxComTaxes() {
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
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

    public Long getTaxBand() {
        return taxBand;
    }

    public void setTaxBand(Long taxBand) {
        this.taxBand = taxBand;
    }

    public Long getTaxRateTable() {
        return taxRateTable;
    }

    public void setTaxRateTable(Long taxRateTable) {
        this.taxRateTable = taxRateTable;
    }

}
