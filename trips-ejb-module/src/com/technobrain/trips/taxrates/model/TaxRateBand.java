package com.technobrain.trips.taxrates.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefBandingType;
import com.technobrain.trips.reference.model.RefTaxRateType;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TaxRateBand")
@NamedQueries (
    {
        @NamedQuery(
            name = "TaxRateBand.findTaxRateByConfig", 
            query = "select band from TaxRateBand band " +
                    "where (band.lowerBandLimit<=:amount1 and " +
                    "   (band.upperBandLimit is null or band.upperBandLimit>=:amount2)) and " +
                    "   band.taxRatePeriod.taxRateConfig =:config and " +
                    "   band.taxRatePeriod.effectiveDate<=:date1 and " +
                    "   (band.taxRatePeriod.expiryDate is null or band.taxRatePeriod.expiryDate>=:date2)"
        ),
        @NamedQuery(
            name = "TaxRateBand.findTaxBandsByConfig", 
            query = "select band from TaxRateBand band " +
                    "where (:amount > band.upperBandLimit or " +
                    "   (:amount between band.lowerBandLimit and band.upperBandLimit) or " +
                    "   (:amount >= band.lowerBandLimit and band.upperBandLimit is null)) and " +
                    "   band.taxRatePeriod.taxRateConfig =:config and " +
                    "   band.taxRatePeriod.effectiveDate<=:date1 and " +
                    "   (band.taxRatePeriod.expiryDate is null or band.taxRatePeriod.expiryDate>=:date2) " +
                    "order by band.lowerBandLimit"
        )        
    }    
)
@Table(name = "TRM_TAX_RATE_BAND")
public class TaxRateBand extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRM_TAX_RATE_BAND_SEQ")
    @SequenceGenerator(name = "TRM_TAX_RATE_BAND_SEQ", sequenceName = "TRM_TAX_RATE_BAND_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    @Column(name="TAX_RATE")
    private BigDecimal taxRate;

    @ManyToOne
    @JoinColumn(name="TAX_RATE_TYPE_CODE", referencedColumnName = "CODE")
    private RefTaxRateType taxRateType;
    

    @ManyToOne
    @JoinColumn(name="TAX_RATE_PERIOD_ID", referencedColumnName = "TRM_TAX_RATE_PERIOD_ID" )
    private TaxRatePeriod taxRatePeriod;
    
    @Column(name="BAND_NAME")
    private String bandName;

    @Column(name="LOWER_BAND_LIMIT")
    private BigDecimal lowerBandLimit;
    
    @Column(name="UPPER_BAND_LIMIT")
    private BigDecimal upperBandLimit;
    
    @Column(name="TAX_CAP")
    private Integer taxCap;
    
    public TaxRateBand() {
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLowerBandLimit(BigDecimal lowerBandLimit) {
        this.lowerBandLimit = lowerBandLimit;
    }

    public BigDecimal getLowerBandLimit() {
        return lowerBandLimit;
    }

    public void setUpperBandLimit(BigDecimal upperBandLimit) {
        this.upperBandLimit = upperBandLimit;
    }

    public BigDecimal getUpperBandLimit() {
        return upperBandLimit;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRateType(RefTaxRateType taxRateType) {
        this.taxRateType = taxRateType;
    }

    public RefTaxRateType getTaxRateType() {
        return taxRateType;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setTaxCap(Integer taxCap) {
        this.taxCap = taxCap;
    }

    public Integer getTaxCap() {
        return taxCap;
    }

    public void setTaxRatePeriod(TaxRatePeriod taxRatePeriod) {
        this.taxRatePeriod = taxRatePeriod;
    }

    public TaxRatePeriod getTaxRatePeriod() {
        return taxRatePeriod;
    }
}
