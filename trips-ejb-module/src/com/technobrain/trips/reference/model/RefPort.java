package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefPort.findAll", query = "select o from RefPort o")
@Table(name = "REF_PORT")
@NamedQueries(
    @NamedQuery(
    name="findRefCountryByPort",
    query="select rp.refCountry1 from RefPort rp where rp.code = ?1"
    )
)
public class RefPort extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;    
    @Column(name="REF_COUNTRY", nullable=false,insertable=false, updatable=false)
    private String countryCode;
    @ManyToOne
    @JoinColumn(name = "REF_COUNTRY", referencedColumnName = "CODE")
    private RefCountry refCountry1;



    public RefPort() {
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

    public RefCountry getRefCountry1() {
        return refCountry1;
    }

    public void setRefCountry1(RefCountry refCountry1) {
        this.refCountry1 = refCountry1;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
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
