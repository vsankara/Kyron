package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCountry.findAll", query = "select o from RefCountry o")
@Table(name = "REF_COUNTRY")
public class RefCountry  extends BaseRefModelObject  {
    @Id
    @Column(nullable = false)
    private String code;
    private String currency;
    private String description;
    private String name;

    private String nationality;
    @OneToMany(mappedBy = "refCountry")
    private List<RefRegion> refRegionList;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

 
    public RefCountry() {
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setRefRegionList(List<RefRegion> refRegionList) {
        this.refRegionList = refRegionList;
    }

    public List<RefRegion> getRefRegionList() {
        return refRegionList;
    }

       public RefRegion addRefRegion(RefRegion refRegion) {
           getRefRegionList().add(refRegion);
           refRegion.setRefCountry(this);
           return refRegion;
       }

       public RefRegion removeRefRegion(RefRegion refRegion) {
           getRefRegionList().remove(refRegion);
           refRegion.setRefCountry(null);
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

