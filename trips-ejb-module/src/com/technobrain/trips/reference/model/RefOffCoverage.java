package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefOffCoverage.findAll", 
    query = "select o from RefOffCoverage o")
@Table(name = "REF_OFF_COVERAGE")
public class RefOffCoverage extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="COVERAGE_IDENTIFIER")
    private String coverageIdentifier;
    @Column(name="COVERAGE_TYPE")
    private String coverageType;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @ManyToOne
    @JoinColumn(name = "REF_OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    
    @ManyToMany
    @JoinTable(name="OFF_COVERAGE_LOC_REL",
        joinColumns={@JoinColumn(name = "REF_OFF_COVERAGE",
                referencedColumnName = "CODE")},
        inverseJoinColumns = {@JoinColumn(name = "LOCATION",
                referencedColumnName = "ID")}
    )
    private List<RefLocationByCountry> location = new ArrayList<RefLocationByCountry>();



    public RefOffCoverage() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoverageIdentifier() {
        return coverageIdentifier;
    }

    public void setCoverageIdentifier(String coverageIdentifier) {
        this.coverageIdentifier = coverageIdentifier;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
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
    
    public List<RefLocationByCountry> getLocation(){
        return this.location;
    }
    
    public void setLocation(List<RefLocationByCountry> location){
        this.location = location;
    }
    
    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }
    
    public void addLocation(RefLocationByCountry location) {
        this.location.add(location);
    }
}
