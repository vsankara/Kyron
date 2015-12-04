package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefDocReport.findAll", 
    query = "select o from RefDocReport o")
@Table(name = "REF_DOC_REPORT")
public class RefDocReport extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name = "DOC_TYPE", referencedColumnName = "CODE")
    private RefDocType docType;

    @ManyToOne
    @JoinColumn(name = "DOC_CATEGORY", referencedColumnName = "CODE")
    private RefDocCategory docCategory;

    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefDocReport() {
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

    public void setDocType(RefDocType docType) {
        this.docType = docType;
    }

    public RefDocType getDocType() {
        return docType;
    }

    public void setDocCategory(RefDocCategory docCategory) {
        this.docCategory = docCategory;
    }

    public RefDocCategory getDocCategory() {
        return docCategory;
    }
}
