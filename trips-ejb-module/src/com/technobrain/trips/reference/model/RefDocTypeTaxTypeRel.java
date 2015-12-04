package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( 
    {
        @NamedQuery(name = "RefDocTypeTaxTypeRel.findAll", query = "select o from RefDocTypeTaxTypeRel o"),
        @NamedQuery(name = "RefDocTypeTaxTypeRel.findByTaxType", 
            query = "select o from RefDocTypeTaxTypeRel o where o.taxType.code=?1"),
        @NamedQuery(name = "RefDocTypeTaxTypeRel.findByDocType", 
            query = "select o from RefDocTypeTaxTypeRel o where o.docType.code=?1")
    } 
)
@Table(name = "REF_DOC_TYPE_TAX_TYPE_REL")
public class RefDocTypeTaxTypeRel extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE", insertable=false, updatable=false)
    private RefRevType taxType;
    @JoinColumn(name = "DOC_TYPE", referencedColumnName = "CODE", insertable=false, updatable=false)
    private RefDocType docType;
    @Column(name="DOC_TYPE_CATEGORY")
    private String docTypeCategory;    

    public RefDocTypeTaxTypeRel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setDocTypeCategory(String docTypeCategory) {
        this.docTypeCategory = docTypeCategory;
    }

    public String getDocTypeCategory() {
        return docTypeCategory;
    }

    public void setTaxType(RefRevType taxType) {
        this.taxType = taxType;
    }

    public RefRevType getTaxType() {
        return taxType;
    }

    public void setDocType(RefDocType docType) {
        this.docType = docType;
    }

    public RefDocType getDocType() {
        return docType;
    }
}
