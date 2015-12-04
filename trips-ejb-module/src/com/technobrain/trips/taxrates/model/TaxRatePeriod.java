package com.technobrain.trips.taxrates.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefTaxRateType;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name="TaxRatePeriod")
@NamedQueries (
    {
        @NamedQuery(name = "TaxRatePeriod.findAll", query = "select o from TaxRatePeriod o"),
        @NamedQuery(
            name = "TaxRatePeriod.findTaxRatePeriodByConfig", 
            query = "select periods from TaxRatePeriod as periods " +
                    "where periods.taxRateConfig=:config and " +
                    "      periods.effectiveDate<=:date1 and (periods.expiryDate is null or periods.expiryDate>=:date2)"
            )
    }    
)
@Table(name = "TRM_TAX_RATE_PERIOD")
public class TaxRatePeriod extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRM_TAX_RATE_PERIOD_SEQ")
    @SequenceGenerator(name = "TRM_TAX_RATE_PERIOD_SEQ", sequenceName = "TRM_TAX_RATE_PERIOD_SEQ", allocationSize = 1)
    @Column(name="TRM_TAX_RATE_PERIOD_ID", nullable = false)
    private Long id;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "TAX_RATE_CONFIG_ID", referencedColumnName = "TRM_TAX_RATE_CONFIG_ID")
    private TaxRateConfig taxRateConfig;
    
    @Column(name="TAX_RATE")
    private BigDecimal taxRate;

    @ManyToOne
    @JoinColumn(name="TAX_RATE_TYPE_CODE", referencedColumnName = "CODE")
    private RefTaxRateType taxRateType;
    
    @Column(name="TAX_CAP")
    private Integer taxCap;
    
    
    @OneToMany(mappedBy = "taxRatePeriod", cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private List<TaxRateBand> taxRates = new ArrayList<TaxRateBand>();
    

    /** Used to manage validations on the selected period accross two tables */     
    private transient boolean selected=false; 
    
    public TaxRatePeriod() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTaxRateConfig(TaxRateConfig taxRateConfig) {
        this.taxRateConfig = taxRateConfig;
    }

    public TaxRateConfig getTaxRateConfig() {
        return taxRateConfig;
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

    public void setTaxCap(Integer taxCap) {
        this.taxCap = taxCap;
    }

    public Integer getTaxCap() {
        return taxCap;
    }

    public void setTaxRates(List<TaxRateBand> taxRates) {
        this.taxRates = taxRates;
    }

    public List<TaxRateBand> getTaxRates() {
        return taxRates;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
    
    public String getTaxRateTypeDescription(){
        if(getTaxRateType() != null){
             return getTaxRateType().getDescription();
        }
        return null;
    }
    
    /// BANDS INFO FOR EASY FORMATTING/SORTING
    private TaxRateBand getTaxRateBand() {
        if(getTaxRates() != null && !getTaxRates().isEmpty()) {
            return getTaxRates().get(0);
        }
        return null;
    }
    
    public String getBandName() {
        if(getTaxRateBand() != null) {
            return getTaxRateBand().getBandName();
        }
        return null;
    }
    
    public BigDecimal getBandLowerLimit() {
        if(getTaxRateBand() != null) {
            return getTaxRateBand().getLowerBandLimit();
        }
        return null;
    }
    
    public BigDecimal getBandUpperLimit() {
        if(getTaxRateBand() != null) {
            return getTaxRateBand().getUpperBandLimit();
        }
        return null;
    }
    
    public BigDecimal getBandTaxRate(){
        if(getTaxRateBand() != null) {
            return getTaxRateBand().getTaxRate();
        }
        return null;
    }
    
    public String getBandTaxRateTypeDescription(){
        if(getTaxRateBand() != null && getTaxRateBand().getTaxRateType() != null){
             return getTaxRateBand().getTaxRateType().getDescription();
        }
        return null;
    }
}
