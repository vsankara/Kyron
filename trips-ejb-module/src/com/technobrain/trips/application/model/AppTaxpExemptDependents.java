package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntEntity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppTaxpExemptDependents.findAll", query = "select o from AppTaxpExemptDependents o")
@Table(name = "APP_EXEMPT_DEPENDENT")
public class AppTaxpExemptDependents extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_EXEMPT_DEPENDENT_SEQ")
    @SequenceGenerator(name = "APP_EXEMPT_DEPENDENT_SEQ", sequenceName = "APP_EXEMPT_DEPENDENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "DEPENDENT_TIN", referencedColumnName = "ID")
    private EntEntity entity;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="MIDDLE_NAME")
    private String middleName;
    @Column(name="DATE_OF_BIRTH")
    private Timestamp dateOfBirth;
    @Column(name="RELATIONSHIP_TYPE")
    private String relationshipType;
    @Column(name="START_DATE")
    private Timestamp startDate;
    @Column(name="END_DATE")
    private Timestamp endDate;
    @Column(name="INCAPACITATED")
    private String incapacitated;
    @Column(name="QUALIF_DEPENDENT")
    private String qualifiedDependent;
    @Column(name="REGISTERED_ENTITY")
    private String registeredEntity;
    @Column(name="GAINFUL_EMPLOYED")
    private String gainfullyEmployed;
    
    
    @ManyToOne
    @JoinColumn(name = "TAXPAYER_EXEMPT_APP_ID", referencedColumnName = "ID")
    private AppTaxpayerExempt appTaxpayerExempt;

    public void setId(Long id) {
        this.id= id;
    }

    public Long getId() {
        return id;
    }

    public void setAppTaxpayerExempt(AppTaxpayerExempt appTaxpayerExempt) {
        this.appTaxpayerExempt = appTaxpayerExempt;
    }
    
    public AppTaxpayerExempt getAppTaxpayerExempt(){
        return appTaxpayerExempt;
    }
    
    
    public void setEntity(EntEntity entity) {
        this.entity = entity;
    }

    public EntEntity getEntity() {
        return entity;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setIncapacitated(String incapacitated) {
        this.incapacitated = incapacitated;
    }

    public String getIncapacitated() {
        return incapacitated;
    }

    public void setQualifiedDependent(String qualifiedDependent) {
        this.qualifiedDependent = qualifiedDependent;
    }

    public String getQualifiedDependent() {
        return qualifiedDependent;
    }

    public void setRegisteredEntity(String registeredEntity) {
        this.registeredEntity = registeredEntity;
    }

    public String getRegisteredEntity() {
        return registeredEntity;
    }
    
    public void setGainfullyEmployed(String gainfullyEmployed) {
        this.gainfullyEmployed = gainfullyEmployed;
    }

    public String getGainfullyEmployed() {
    return gainfullyEmployed;
    }
}
