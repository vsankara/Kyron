package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "OfficeSubordinates.findAll", query = "select o from OfficeSubordinates o")
@Table(name = "OFFICE_SUBORDINATES")
public class OfficeSubordinates extends  BaseNormalModelObject {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFICE_SUBORDINATES_SEQ")
    @SequenceGenerator(name = "OFFICE_SUBORDINATES_SEQ", sequenceName = "OFFICE_SUBORDINATES_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
        
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "REF_OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    
    @ManyToOne
    @JoinColumn(name = "SUB_OFFICE", referencedColumnName = "CODE")
    private RefOffice subOffice;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }

    public void setSubOffice(RefOffice subOffice) {
        this.subOffice = subOffice;
    }

    public RefOffice getSubOffice() {
        return subOffice;
    }
}
