package com.technobrain.trips.taxrates.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefReturnType;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.reference.model.RefSubTaxCategory;

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


@Entity(name="TaxRateConfig")
@NamedQueries (
    {
        @NamedQuery(
            name = "TaxRateConfig.findAll", 
            query = "select config from TaxRateConfig config " +
                    "   left outer join config.taxRatePeriods period"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRate0", 
            query = "select periods from TaxRateConfig as config " +
                    "   left outer join config.taxRatePeriods as periods " +
                    "   where config.returnType=:type " +
                    "       and periods.effectiveDate<=:date1 and (periods.expiryDate is null or periods.expiryDate>=:date2)"
            ),            
        @NamedQuery(
            name = "TaxRateConfig.findTaxRate1", 
            query = "select periods from TaxRateConfig as config " +
                    "   left outer join config.taxRatePeriods as periods " +
                    "   where config.returnType=:type " +
                    "       and config.subTaxCategory1=:sub1" +
                    "       and periods.effectiveDate<=:date1 and (periods.expiryDate is null or periods.expiryDate>=:date2)"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRate2", 
            query = "select periods from TaxRateConfig as config " +
                    "   left outer join config.taxRatePeriods as periods " +
                    "   where config.returnType=:type " +
                    "       and config.subTaxCategory1=:sub1" +
                    "       and config.subTaxCategory2=:sub2" +
                    "       and periods.effectiveDate<=:date1 and (periods.expiryDate is null or periods.expiryDate>=:date2)"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRateConfig0", 
            query = "select config from TaxRateConfig config " +
                    "   where config.returnType=:type"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRateConfig1", 
            query = "select config from TaxRateConfig config " +
                    "   where config.returnType=:type " +
                    "       and config.subTaxCategory1=:sub1"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRateConfig2", 
            query = "select config from TaxRateConfig config " +
                    "   where config.returnType=:type " +
                    "       and config.subTaxCategory1=:sub1 " +
                    "       and config.subTaxCategory2=:sub2"
            ),
        @NamedQuery(
            name = "TaxRateConfig.findTaxRateMap", 
            query = "select config from TaxRateConfig as config " +
                    "   left outer join config.taxRatePeriods as periods " +
                    "   where config.returnType=:type"
            )
    }    
)
@Table(name = "TRM_TAX_RATE_CONFIG")
public class TaxRateConfig extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRM_TAX_RATE_CONFIG_SEQ")
    @SequenceGenerator(name = "TRM_TAX_RATE_CONFIG_SEQ", sequenceName = "TRM_TAX_RATE_CONFIG_SEQ", allocationSize = 1)
    @Column(name="TRM_TAX_RATE_CONFIG_ID", nullable = false)
    private Long id;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TAX_TYPE_CODE", referencedColumnName="CODE", nullable = false, updatable=true, insertable=true)
    private RefRevType taxType;
    
        
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "SUB_TAX_CATEGORY_CODE_1", referencedColumnName = "CODE", nullable=false, updatable=true, insertable=true)
    private RefSubTaxCategory subTaxCategory1;
        
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "SUB_TAX_CATEGORY_CODE_2", referencedColumnName = "CODE", nullable=false, updatable=true, insertable=true)
    private RefSubTaxCategory subTaxCategory2;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "RETURN_TYPE_CODE", referencedColumnName = "CODE", nullable = false, updatable=true, insertable=true)
    private RefReturnType returnType;
        
    @Column(name="BANDING_INDICATOR")
    private String bandingIndicator;
    
    @Column(name="SUB_TAX_CATEGORY_INDICATOR")
    private String subCategoryIndicator;

    
    @OneToMany(mappedBy = "taxRateConfig", fetch = FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.PERSIST})
    private List<TaxRatePeriod> taxRatePeriods = new ArrayList<TaxRatePeriod>();
    
    
    public TaxRateConfig() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTaxType(RefRevType taxType) {
        this.taxType = taxType;
    }

    public RefRevType getTaxType() {
        return taxType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setReturnType(RefReturnType returnType) {
        this.returnType = returnType;
    }

    public RefReturnType getReturnType() {
        return returnType;
    }

    public void setBandingIndicator(String bandingIndicator) {
        this.bandingIndicator = bandingIndicator;
    }

    public String getBandingIndicator() {
        return bandingIndicator;
    }

    public void setTaxRatePeriods(List<TaxRatePeriod> taxRatePeriods) {
        this.taxRatePeriods = taxRatePeriods;
    }
    
//    public TaxRatePeriod addCfgAllocationRule(TaxRatePeriod taxRatePeriod) {
//        taxRatePeriod.setTaxRatePeriods(this);
//        getCfgAllocationRules().add(cfgAllocationRule);
//        return cfgAllocationRule;
//    }


    public List<TaxRatePeriod> getTaxRatePeriods() {
        return taxRatePeriods;
    }

    public void setSubTaxCategory1(RefSubTaxCategory subTaxCategory1) {
        this.subTaxCategory1 = subTaxCategory1;
    }

    public RefSubTaxCategory getSubTaxCategory1() {
        return subTaxCategory1;
    }

    public void setSubTaxCategory2(RefSubTaxCategory subTaxCategory2) {
        this.subTaxCategory2 = subTaxCategory2;
    }

    public RefSubTaxCategory getSubTaxCategory2() {
        return subTaxCategory2;
    }

    public void setSubCategoryIndicator(String subCategoryIndicator) {
        this.subCategoryIndicator = subCategoryIndicator;
    }

    public String getSubCategoryIndicator() {
        return subCategoryIndicator;
    }
}
