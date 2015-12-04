package com.technobrain.trips.registration.model;

import com.technobrain.trips.reference.model.RefRevType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
@NamedQuery(name = "RegTaxpayerRevenue.findAll", 
    query = "select o from RegTaxpayerRevenue o"),
@NamedQuery(name = "RegTaxpayerRevenue.findStaggerAndSubstagger", 
    query = "select o from RegTaxpayerRevenue o where o.id = ?1")
    }
)
@Table(name = "REG_TAXPAYER_REVENUE")
@DiscriminatorValue(value="REVENUE")
@Inheritance
public class RegTaxpayerRevenue extends RegTaxpayerEntity {

    @Column(name="REVENUE_TYPE", nullable = false)
    private String revenueType;
    @Column(name="STAGGER", nullable = true)
    private String stagger;
    @Column(name="SUB_STAGGER", nullable = true)
    private String subStagger;
//    @ManyToOne
//    @JoinColumn(name = "REF_REV_TYPE", referencedColumnName = "CODE")
//    private RefRevType refRevType;


    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }
    
//    public void setRefRevType(RefRevType refRevType) {
//         this.refRevType = refRevType;
//    }
//
//    public RefRevType getRefRevType() {
//        return refRevType;
//    }

    public void setStagger(String stagger) {
        this.stagger = stagger;
    }

    public String getStagger() {
        return stagger;
    }

    public void setSubStagger(String subStagger) {
        this.subStagger = subStagger;
    }

    public String getSubStagger() {
        return subStagger;
    }
}
