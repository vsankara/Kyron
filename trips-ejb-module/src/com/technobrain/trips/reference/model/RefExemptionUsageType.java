package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefExemptionUsageType.findAll", 
            query = "select o from RefExemptionUsageType o")
@Table(name = "REF_EXEM_USAGE_TYPE")
public class RefExemptionUsageType extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;

    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefExemptionUsageType() {
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

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
}
