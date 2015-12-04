package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCustTaxBand.findAll", 
    query = "select o from RefCustTaxBand o")
@Table(name = "REF_CUST_TAX_BAND")
public class RefCustTaxBand extends BaseNormalModelObject   {

    @Column(name="TAX_BAND", nullable = false)
    private String taxBand;
    @Column(name="COMMODITY_CODE")
    private String commodityCode;
    private BigDecimal rate;
    @Column(name="FIXED_VALUE")
    private Long fixedValue;
    @Column(name="UNIT_CHARGE")
    private Long unitCharge;
    
    @Column(name="DATE_APPLIES")
    private Timestamp dateApplies;
    @Column(name="MIN_TAX")
    private Long minTax;
    @Column(name="MAX_TAX")
    private Long maxTax;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_cust_tax_band_seq")
    @SequenceGenerator(name = "ref_cust_tax_band_seq", sequenceName = "ref_cust_tax_band_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="MULTIPLIER_FIELD")
    private String multiplierField;
    @Column(name="SEQ")
    private Long seq;
    @ManyToOne
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE")
    private RefCustTaxType refCustTaxType;
    

    public RefCustTaxBand() {
    }

    public Timestamp getDateApplies() {
        return dateApplies;
    }

    public void setDateApplies(Timestamp dateApplies) {
        this.dateApplies = dateApplies;
    }

    public Long getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(Long fixedValue) {
        this.fixedValue = fixedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxTax() {
        return maxTax;
    }

    public void setMaxTax(Long maxTax) {
        this.maxTax = maxTax;
    }

    public Long getMinTax() {
        return minTax;
    }

    public void setMinTax(Long minTax) {
        this.minTax = minTax;
    }

    public String getMultiplierField() {
        return multiplierField;
    }

    public void setMultiplierField(String multiplierField) {
        this.multiplierField = multiplierField;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTaxBand() {
        return taxBand;
    }

    public void setTaxBand(String taxBand) {
        this.taxBand = taxBand;
    }


    public Long getUnitCharge() {
        return unitCharge;
    }

    public void setUnitCharge(Long unitCharge) {
        this.unitCharge = unitCharge;
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

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityCode() {
        return commodityCode;
    }
}
