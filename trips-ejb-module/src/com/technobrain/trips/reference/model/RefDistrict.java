package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefDistrict.findAll", query = "select o from RefDistrict o")
@Table(name = "REF_DISTRICT")
public class RefDistrict  extends BaseRefModelObject  {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name = "REG_CODE", referencedColumnName = "CODE")
    private RefRegion refRegion;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefDistrict() {
    }

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

    public void setRefRegion(RefRegion refRegion) {
        this.refRegion = refRegion;
    }

    public RefRegion getRefRegion() {
        return refRegion;
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
