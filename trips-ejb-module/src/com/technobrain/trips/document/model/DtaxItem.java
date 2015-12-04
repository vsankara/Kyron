package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DtaxItem.findAll", query = "select o from DtaxItem o")
@Table(name = "DTAX_ITEM")
public class DtaxItem extends BaseNormalModelObject   {
     
     
     
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dtax_item_seq")
    @SequenceGenerator(name = "dtax_item_seq", sequenceName = "dtax_item_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
     
    @Column(name="TAX_AMOUNT")
    private BigDecimal taxAmount;
    @Column(name="TAX_CODE")
    private String taxCode;
    @Column(name="TAX_RATE")
    private BigDecimal taxRate;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="TAX_BASE")
    private BigDecimal taxBase;        
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "DITEM", referencedColumnName = "ID")
    private DitemItem ditemItem;   
    @Column(name="DITEM",insertable=false,updatable=false)
    private Long dItem;

    public DtaxItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public DitemItem getDitemItem() {
        return ditemItem;
    }

    public void setDitemItem(DitemItem ditemItem) {
        this.ditemItem = ditemItem;
    }

    public void setTaxBase(BigDecimal taxBase) {
        this.taxBase = taxBase;
    }

    public BigDecimal getTaxBase() {
        return taxBase;
    }

    public void setDItem(Long dItem) {
        this.dItem = dItem;
    }

    public Long getDItem() {
        return dItem;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }
}
