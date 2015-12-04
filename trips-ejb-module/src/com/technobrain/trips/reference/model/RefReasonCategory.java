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
@NamedQuery(name = "RefReasonCategory.findAll", 
    query = "select o from RefReasonCategory o")
@Table(name = "REF_REASON_CATEGORY")
public class RefReasonCategory extends BaseRefModelObject {
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
    private List<RefReason> refReasonList;
   

    public RefReasonCategory() {
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

    public void setRefReasonList(List<RefReason> refReasonList) {
        this.refReasonList = refReasonList;
    }

    public List<RefReason> getRefReasonList() {
        return refReasonList;
    }
    
    public RefReason addRefReason(RefReason refReason) {
        getRefReasonList().add(refReason);
        refReason.setCategory(this);
        return refReason;
    }

    public RefReason removeRefReason(RefReason refReason) {
        getRefReasonList().remove(refReason);
        refReason.setCategory(null);
        return refReason;
    }
}
