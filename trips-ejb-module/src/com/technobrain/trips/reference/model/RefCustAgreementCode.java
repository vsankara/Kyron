package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCustAgreementCode.findAll", 
    query = "select o from RefCustAgreementCode o")
@Table(name = "REF_CUST_AGREEMENT_CODE")
public class RefCustAgreementCode extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
     
     
     
     
    @OneToMany(mappedBy = "refCustAgreementCode")
    private List<RefComTaxes> refComTaxesList;

    public RefCustAgreementCode() {
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

    public List<RefComTaxes> getRefComTaxesList() {
        return refComTaxesList;
    }

    public void setRefComTaxesList(List<RefComTaxes> refComTaxesList) {
        this.refComTaxesList = refComTaxesList;
    }

    public RefComTaxes addRefComTaxes(RefComTaxes refComTaxes) {
        getRefComTaxesList().add(refComTaxes);
        refComTaxes.setRefCustAgreementCode(this);
        return refComTaxes;
    }

    public RefComTaxes removeRefComTaxes(RefComTaxes refComTaxes) {
        getRefComTaxesList().remove(refComTaxes);
        refComTaxes.setRefCustAgreementCode(null);
        return refComTaxes;
    }
}
