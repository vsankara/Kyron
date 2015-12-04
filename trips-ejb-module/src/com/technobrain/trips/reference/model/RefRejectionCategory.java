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
@NamedQuery(name = "RefRejectionCategory.findAll", 
    query = "select o from RefRejectionCategory o")
@Table(name = "REF_REJECTION_CATEGORY")
public class RefRejectionCategory extends BaseRefModelObject {
    
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
    private List<RefRejectionCode> refRejectionCodeList;

    public RefRejectionCategory() {
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

    public void setRefRejectionCodeList(List<RefRejectionCode> refRejectionCodeList) {
        this.refRejectionCodeList = refRejectionCodeList;
    }

    public List<RefRejectionCode> getRefRejectionCodeList() {
        return refRejectionCodeList;
    }
    
    public RefRejectionCode addRefRejectionCode(RefRejectionCode refRejectionCode) {
        getRefRejectionCodeList().add(refRejectionCode);
        refRejectionCode.setCategory(this);
        return refRejectionCode;
    }

    public RefRejectionCode removeRefRejectionCode(RefRejectionCode refRejectionCode) {
        getRefRejectionCodeList().remove(refRejectionCode);
        refRejectionCode.setCategory(null);
        return refRejectionCode;
    }
}
