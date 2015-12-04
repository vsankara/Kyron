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
@NamedQuery(name = "DtaxHeader.findAll", query = "select o from DtaxHeader o")
@Table(name = "DTAX_HEADER")
public class DtaxHeader extends BaseNormalModelObject   {
     
     
     
     
    private String dtype;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dtax_header_seq")
    @SequenceGenerator(name = "dtax_header_seq", sequenceName = "dtax_header_seq", allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
     
    @Column(name="TAX_AMOUNT")
    private BigDecimal taxAmount;
    @Column(name="TAX_CODE")
    private String taxCode;
    @Column(name="TAX_RATE")
    private Long taxRate;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="TAX_BASE")
    private Long taxBase;    
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument1;
    @Column(name="DDOC_DOCUMENT", insertable=false, updatable=false)
    private Long documentId; 
    
    public DtaxHeader() {
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
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

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public DdocDocument getDdocDocument1() {
        return ddocDocument1;
    }

    public void setDdocDocument1(DdocDocument ddocDocument1) {
        this.ddocDocument1 = ddocDocument1;
    }

    public void setTaxBase(Long taxBase) {
        this.taxBase = taxBase;
    }

    public Long getTaxBase() {
        return taxBase;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }
}
