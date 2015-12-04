package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefRegion.findAll", query = "select o from RefRegion o")
@Table(name = "REF_REGION")
public class RefRegion  extends BaseRefModelObject  {
    @Id
    @Column(nullable = false)
    private String code;
    private String country;
    private String description;
   

    @OneToMany(mappedBy = "refRegion")
    private List<RefDistrict> refDistrictList;
    @ManyToOne
    @JoinColumn(name = "REF_COUNTRY", referencedColumnName = "CODE")
    private RefCountry refCountry;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefRegion() {
    }
    public RefDistrict addRefDistrict(RefDistrict refDistrict) {
        getRefDistrictList().add(refDistrict);
        refDistrict.setRefRegion(this);
        return refDistrict;
    }

    public RefDistrict removeRefDistrict(RefDistrict refDistrict) {
        getRefDistrictList().remove(refDistrict);
        refDistrict.setRefRegion(null);
        return refDistrict;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRefDistrictList(List<RefDistrict> refDistrictList) {
        this.refDistrictList = refDistrictList;
    }

    public List<RefDistrict> getRefDistrictList() {
        return refDistrictList;
    }

    public void setRefCountry(RefCountry refCountry) {
        this.refCountry = refCountry;
    }

    public RefCountry getRefCountry() {
        return refCountry;
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
