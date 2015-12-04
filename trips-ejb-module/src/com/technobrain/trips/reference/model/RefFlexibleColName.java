package com.technobrain.trips.reference.model;

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
@NamedQuery(name = "RefFlexibleColName.findAll", query = "select o from RefFlexibleColName o")
@Table(name = "REF_FLEXIBLE_COL_NAME")
public class RefFlexibleColName extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "TABLE_NAME", referencedColumnName = "CODE")
    private RefFlexibleTableName refFlexibleTableName;

    public RefFlexibleColName() {
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

    public RefFlexibleTableName getRefFlexibleTableName() {
        return refFlexibleTableName;
    }

    public void setRefFlexibleTableName(RefFlexibleTableName refFlexibleTableName) {
        this.refFlexibleTableName = refFlexibleTableName;
    }
}
