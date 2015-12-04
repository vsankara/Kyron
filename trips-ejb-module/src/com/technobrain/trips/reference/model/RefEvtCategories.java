package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefEvtCategories.findAll", 
    query = "select o from RefEvtCategories o")
@Table(name = "REF_EVT_CATEGORIES")
public class RefEvtCategories extends BaseRefModelObject {
    
    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(nullable = false)
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @OneToMany(mappedBy = "refEvtCategories")
    private List<RefEvtTypeCat> refEvtTypeCatList;

    public RefEvtCategories() {
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

    public List<RefEvtTypeCat> getRefEvtTypeCatList() {
        return refEvtTypeCatList;
    }

    public void setRefEvtTypeCatList(List<RefEvtTypeCat> refEvtTypeCatList) {
        this.refEvtTypeCatList = refEvtTypeCatList;
    }

    public RefEvtTypeCat addRefEvtTypeCat(RefEvtTypeCat refEvtTypeCat) {
        getRefEvtTypeCatList().add(refEvtTypeCat);
        refEvtTypeCat.setRefEvtCategories(this);
        return refEvtTypeCat;
    }

    public RefEvtTypeCat removeRefEvtTypeCat(RefEvtTypeCat refEvtTypeCat) {
        getRefEvtTypeCatList().remove(refEvtTypeCat);
        refEvtTypeCat.setRefEvtCategories(null);
        return refEvtTypeCat;
    }
}
