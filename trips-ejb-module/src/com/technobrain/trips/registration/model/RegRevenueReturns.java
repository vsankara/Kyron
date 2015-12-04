package com.technobrain.trips.registration.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
@NamedQuery(name = "RegRevenueReturns.findAll", 
    query = "select o from RegRevenueReturns o"),
@NamedQuery(name = "RegRevenueReturns.findRegRevenueReturns", 
    query = "select o from RegRevenueReturns o where o.regRevenueId.id = ?1"),
@NamedQuery(name = "RegRevenueReturns.removeRevenueReturns", 
    query = "delete from RegRevenueReturns o where o.regRevenueId.id = ?1 and o.returnType = ?2"),     
@NamedQuery(name = "RegRevenueReturns.findRegRevRetByRevIdandRet", 
    query = "select o from RegRevenueReturns o where o.regRevenueId.id = ?1 and o.returnType = ?2")    
    }
)    
@Table(name = "REG_REVENUE_RETURNS")
public class RegRevenueReturns extends BaseNormalModelObject {
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_REVENUE_RETURNS_SEQ")
    @SequenceGenerator(name = "REG_REVENUE_RETURNS_SEQ", sequenceName = "REG_REVENUE_RETURNS_SEQ", allocationSize = 1)
    @Column(nullable = false)   
    private Long id;
    @ManyToOne
    @JoinColumn(name = "REG_REVENUE_ID", referencedColumnName = "ID")
    private RegTaxpayerEntity regRevenueId;
    @Column(name="RETURN_TYPE", nullable = false)
    private String returnType;
   

    public RegRevenueReturns() {
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

   

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }


    public void setRegRevenueId(RegTaxpayerEntity regRevenueId) {
        this.regRevenueId = regRevenueId;
    }

    public RegTaxpayerEntity getRegRevenueId() {
        return regRevenueId;
    }
}
