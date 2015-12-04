package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity    
@NamedQueries  ( 
    {
@NamedQuery(name = "RefBusinessSector.findAll", 
    query = "select o from RefBusinessSector o"),
@NamedQuery(name = "RefBusinessSector.findByCode", 
    query = "select o from RefBusinessSector o where o.code = ?1")
    }
)
    
@Table(name = "REF_BUSINESS_SECTOR")
public class RefBusinessSector extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
     
     
     
     
//    @Column(name="GROUP_CODE")
//    private String groupCode;
//    @Column(name="GROUP_SUB_CODE")
//    private String groupSubCode;

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "CODE")
    private RefBusinessSectorCategory category;
    
    
    public RefBusinessSector() {
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

//    public void setGroupCode(String groupCode) {
//        this.groupCode = groupCode;
//    }
//
//    public String getGroupCode() {
//        return groupCode;
//    }
//
//    public void setGroupSubCode(String groupSubCode) {
//        this.groupSubCode = groupSubCode;
//    }
//
//    public String getGroupSubCode() {
//        return groupSubCode;
//    }

   

    public void setCategory(RefBusinessSectorCategory category) {
        this.category = category;
    }

    public RefBusinessSectorCategory getCategory() {
        return category;
    }
}
