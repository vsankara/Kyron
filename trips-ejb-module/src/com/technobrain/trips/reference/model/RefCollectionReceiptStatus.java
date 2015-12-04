package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity    
@NamedQueries  ( 
    {
@NamedQuery(name = "RefCollectionReceiptStatus.findAll", 
    query = "select o from RefCollectionReceiptStatus o"),
@NamedQuery(name = "RefCollectionReceiptStatus.findByCode", 
    query = "select o from RefCollectionReceiptStatus o where o.code = ?1")
    }
)
    
@Table(name = "REF_COLLECTION_RECEIPT_STATUS")
public class RefCollectionReceiptStatus extends BaseRefModelObject{

    @Id
    @Column(nullable = false)
    private String code;
    
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
}
