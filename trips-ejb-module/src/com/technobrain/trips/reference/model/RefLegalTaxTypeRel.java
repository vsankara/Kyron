package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefLegalTaxTypeRel.findAll", 
    query = "select o from RefLegalTaxTypeRel o")
@Table(name = "REF_LEGAL_TAX_TYPE_REL")
public class RefLegalTaxTypeRel extends BaseRefModelObject {

    @Id  
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_legal_tax_type_rel_seq")
    @SequenceGenerator(name = "ref_legal_tax_type_rel_seq", sequenceName = "ref_legal_tax_type_rel_seq", allocationSize = 1)
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @ManyToOne
    @JoinColumn(name = "LEGAL_STATUS", referencedColumnName = "CODE")    
    private RefLegalStatusType refLegalStatus; 
    @ManyToOne
    @JoinColumn(name = "TAX_TYPE", referencedColumnName = "CODE")    
    private RefRevType refRevType; 

    public RefLegalTaxTypeRel() {
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

    public void setRefLegalStatus(RefLegalStatusType refLegalStatus) {
        this.refLegalStatus = refLegalStatus;
    }

    public RefLegalStatusType getRefLegalStatus() {
        return refLegalStatus;
    }

    public void setRefRevType(RefRevType refRevType) {
        this.refRevType = refRevType;
    }

    public RefRevType getRefRevType() {
        return refRevType;
    }
}
