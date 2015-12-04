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
@NamedQuery(name = "RefLegalStatusFiscal.findAll", 
    query = "select o from RefLegalStatusFiscal o")
@Table(name = "REF_LEGAL_STATUS_FISCAL")
public class RefLegalStatusFiscal extends BaseRefModelObject{

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "LEGAL_STATUS", referencedColumnName = "CODE")    
    private RefLegalStatusType legalStatus;

    public RefLegalStatusFiscal() {
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

    public RefLegalStatusType getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(RefLegalStatusType legalStatus) {
        this.legalStatus = legalStatus;
    }
}
