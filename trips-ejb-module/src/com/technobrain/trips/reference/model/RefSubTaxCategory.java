package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;



import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.NamedQueries;


@Entity
@NamedQuery(name = "RefSubTaxCategory.findAll", 
    query = "select o from RefSubTaxCategory o")
@Table(name = "REF_SUB_TAX_CATEGORY")
@NamedQueries( { @NamedQuery(name = "RefSubTaxCategory.revenueType", 
                             query = "select  o  from RefSubTaxCategory o where o.revenueType = ?1 and o.level=?2 and o.status='A'")
                             ,
                 @NamedQuery(name = "RefSubTaxCategory.subTaxCategory2", 
                             query = "select  o  from RefSubTaxCategory o where o.revenueType = ?1 and o.parent=?2 and o.level=2 and o.status='A'")
                             ,                             
                             @NamedQuery(name = "RefSubTaxCategory.selectedRecord", 
                             query = "select  o  from RefSubTaxCategory o where o.code = ?1")})
public class RefSubTaxCategory extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Column(name="DEPTH")
    private Long level;
    
    @Column(name="REV_TYPE_CODE")
    private String revenueType;
    
    @Column(name="PARENT_CODE")
    private String parent;
    
    private transient String creditPostingRequiredFlag;
    
  
    public RefSubTaxCategory() {
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

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public void setCreditPostingRequiredFlag(String creditPostingRequiredFlag) {
        this.creditPostingRequiredFlag = creditPostingRequiredFlag;
    }

    public String getCreditPostingRequiredFlag() {
        return creditPostingRequiredFlag;
    }
}
