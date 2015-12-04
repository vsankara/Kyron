package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefStaggerSub.findAll", 
    query = "select o from RefStaggerSub o")
@Table(name = "REF_STAGGER_SUB")
public class RefStaggerSub extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
    @OneToMany(mappedBy = "refStaggerSub")
    private List<RefRevType> refRevTypeList;  
     
     
     

    public RefStaggerSub() {
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


    public void setRefRevTypeList(List<RefRevType> refRevTypeList) {
        this.refRevTypeList = refRevTypeList;
    }

    public List<RefRevType> getRefRevTypeList() {
        return refRevTypeList;
    }
    
    public RefRevType addRefRevType(RefRevType refRevType) {
        getRefRevTypeList().add(refRevType);
        refRevType.setRefStaggerSub(this);
        return refRevType;
    }

    public RefRevType removeRefRevType(RefRevType refRevType) {
        getRefRevTypeList().remove(refRevType);
        refRevType.setRefStaggerSub(null);
        return refRevType;
    }
}
