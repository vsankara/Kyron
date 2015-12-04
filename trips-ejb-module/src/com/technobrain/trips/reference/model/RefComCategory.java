package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefComCategory.findAll", 
    query = "select o from RefComCategory o")
@Table(name = "REF_COM_CATEGORY")
public class RefComCategory extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
     
     
     
     
    @OneToMany(mappedBy = "refComCategory")
    private List<RefComCodeCategory> refComCodeCategoryList;

    public RefComCategory() {
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

    public List<RefComCodeCategory> getRefComCodeCategoryList() {
        return refComCodeCategoryList;
    }

    public void setRefComCodeCategoryList(List<RefComCodeCategory> refComCodeCategoryList) {
        this.refComCodeCategoryList = refComCodeCategoryList;
    }

    public RefComCodeCategory addRefComCodeCategory(RefComCodeCategory refComCodeCategory) {
        getRefComCodeCategoryList().add(refComCodeCategory);
        refComCodeCategory.setRefComCategory(this);
        return refComCodeCategory;
    }

    public RefComCodeCategory removeRefComCodeCategory(RefComCodeCategory refComCodeCategory) {
        getRefComCodeCategoryList().remove(refComCodeCategory);
        refComCodeCategory.setRefComCategory(null);
        return refComCodeCategory;
    }
}
