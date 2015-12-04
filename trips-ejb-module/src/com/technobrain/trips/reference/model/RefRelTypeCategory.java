package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefRelTypeCategory.findAll", 
    query = "select o from RefRelTypeCategory o")
@Table(name = "REF_REL_TYPE_CATEGORY")
public class RefRelTypeCategory extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @OneToMany(mappedBy = "category")
    @OrderBy("description ASC")
    private List<RefRelationshipType> refRelationshipTypeList;
   

    public RefRelTypeCategory() {
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
   
    public RefRelationshipType addRefRelationshipType(RefRelationshipType refRelationshipType) {
        getRefRelationshipTypeList().add(refRelationshipType);
        refRelationshipType.setCategory(this);
        return refRelationshipType;
    }

    public RefRelationshipType removeRefRelationshipType(RefRelationshipType refRelationshipType) {
        getRefRelationshipTypeList().remove(refRelationshipType);
        refRelationshipType.setCategory(null);
        return refRelationshipType;
    }

    public void setRefRelationshipTypeList(List<RefRelationshipType> refRelationshipTypeList) {
        this.refRelationshipTypeList = refRelationshipTypeList;
    }

    public List<RefRelationshipType> getRefRelationshipTypeList() {
        return refRelationshipTypeList;
    }
}
