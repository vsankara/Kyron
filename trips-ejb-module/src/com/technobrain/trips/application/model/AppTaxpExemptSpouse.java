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
@NamedQuery(name = "AppTaxpExemptSpouse.findAll", query = "select o from AppTaxpExemptSpouse o")
@Table(name = "APP_EXEMPT_SPOUSE")
public class AppTaxpExemptSpouse extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_EXEMPT_SPOUSE_SEQ")
    @SequenceGenerator(name = "APP_EXEMPT_SPOUSE_SEQ", sequenceName = "APP_EXEMPT_SPOUSE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "SPOUSE_TIN", referencedColumnName = "ID")
    private EntEntity entity;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="MIDDLE_NAME")
    private String middleName;
    @Column(name="START_DATE")
    private Timestamp startDate;
    @Column(name="END_DATE")
    private Timestamp endDate;
    @Column(name="INSURANCE_PREMIUM")
    private BigDecimal insurancePremium;

    @Column(name="EMPLOY_SPOUSE_STATUS")
    private String employmentSpouseStatus;
    
    
    
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

    public void setInsurancePremium(BigDecimal insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    public BigDecimal getInsurancePremium() {
        return insurancePremium;
    }
    
    public void setEmploymentSpouseStatus(String employmentSpouseStatus) {
        this.employmentSpouseStatus = employmentSpouseStatus;
    }

    public String getEmploymentSpouseStatus() {
        return employmentSpouseStatus;
    }
}
