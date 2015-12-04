package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefCustTaxType.findAll", 
    query = "select o from RefCustTaxType o")
@Table(name = "REF_CUST_TAX_TYPE")
public class RefCustTaxType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    private String applyto;
    private Long basis;
    private String deferable;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @OneToMany(mappedBy = "refCustTaxType")
    private List<RefCustTaxBand> refCustTaxBandList;
    @OneToMany(mappedBy = "refCustTaxType")
    private List<RefComTaxes> refComTaxesList;
    private Long seq;

   
    public RefCustTaxType() {
    }

    public String getApplyto() {
        return applyto;
    }

    public void setApplyto(String applyto) {
        this.applyto = applyto;
    }

    public Long getBasis() {
        return basis;
    }

    public void setBasis(Long basis) {
        this.basis = basis;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDeferable() {
        return deferable;
    }

    public void setDeferable(String deferable) {
        this.deferable = deferable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public List<RefCustTaxBand> getRefCustTaxBandList() {
        return refCustTaxBandList;
    }

    public void setRefCustTaxBandList(List<RefCustTaxBand> refCustTaxBandList) {
        this.refCustTaxBandList = refCustTaxBandList;
    }

    public RefCustTaxBand addRefCustTaxBand(RefCustTaxBand refCustTaxBand) {
        getRefCustTaxBandList().add(refCustTaxBand);
        refCustTaxBand.setRefCustTaxType(this);
        return refCustTaxBand;
    }

    public RefCustTaxBand removeRefCustTaxBand(RefCustTaxBand refCustTaxBand) {
        getRefCustTaxBandList().remove(refCustTaxBand);
        refCustTaxBand.setRefCustTaxType(null);
        return refCustTaxBand;
    }

    public List<RefComTaxes> getRefComTaxesList() {
        return refComTaxesList;
    }

    public void setRefComTaxesList(List<RefComTaxes> refComTaxesList) {
        this.refComTaxesList = refComTaxesList;
    }

    public RefComTaxes addRefComTaxes(RefComTaxes refComTaxes) {
        getRefComTaxesList().add(refComTaxes);
        refComTaxes.setRefCustTaxType(this);
        return refComTaxes;
    }

    public RefComTaxes removeRefComTaxes(RefComTaxes refComTaxes) {
        getRefComTaxesList().remove(refComTaxes);
        refComTaxes.setRefCustTaxType(null);
        return refComTaxes;
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
