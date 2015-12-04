package com.technobrain.trips.application.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppAccreditation.findAll", query = "select o from AppAccreditation o")
@Table(name = "APP_ACCREDITATION")
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("ACCRED")
public class AppAccreditation extends AppApplication {
 
    @OneToMany(mappedBy = "appAccreditation", cascade={CascadeType.ALL})
    private List<AppColAgentEfficency> appColAgentEfficencyList;
    
    @Column(name="COLL_AGENT_CODE")
    String collectionAgentCode;
    @Column(name="COLL_AGENT_DESC")
    String collectionAgentDescription;
    
    @OneToMany(mappedBy = "appAccreditation", cascade={CascadeType.ALL})
    private List<AppColAgentCoverage> appColAgentCoverageList;
    
    @Column(name="EFF_DATE_SUSP")
    Timestamp effectiveDateOfSuspension;
    @Column(name="EXPIRY_DATE_SUSP")
    Timestamp expiryDateOfSuspension;
    @Column(name="REASON_SUSPENSION")
    String reasonForSuspension;
    
    String comments;
    

    public AppAccreditation() {
    }

    public AppColAgentEfficency addAppColAgentEfficency(AppColAgentEfficency appColAgentEfficency) {
        getAppColAgentEfficencyList().add(appColAgentEfficency);
        appColAgentEfficency.setAppAccreditation(this);
        return appColAgentEfficency;
    }

    public AppColAgentEfficency removeAppColAgentEfficency(AppColAgentEfficency appColAgentEfficency) {
        getAppColAgentEfficencyList().remove(appColAgentEfficency);
        appColAgentEfficency.setAppAccreditation(null);
        return appColAgentEfficency;
    }
    
    
    public AppColAgentCoverage addAppColAgentCoverage(AppColAgentCoverage appColAgentCoverage) {
        getAppColAgentCoverageList().add(appColAgentCoverage);
        appColAgentCoverage.setAppAccreditation(this);
        return appColAgentCoverage;
    }

    public AppColAgentCoverage removeAppColAgentCoverage(AppColAgentCoverage appColAgentCoverage) {
        getAppColAgentCoverageList().remove(appColAgentCoverage);
        appColAgentCoverage.setAppAccreditation(null);
        return appColAgentCoverage;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setAppColAgentEfficencyList(List<AppColAgentEfficency> appColAgentEfficencyList) {
        this.appColAgentEfficencyList = appColAgentEfficencyList;
    }

    public List<AppColAgentEfficency> getAppColAgentEfficencyList() {
        return appColAgentEfficencyList;
    }

    public void setAppColAgentCoverageList(List<AppColAgentCoverage> appColAgentCoverageList) {
        this.appColAgentCoverageList = appColAgentCoverageList;
    }

    public List<AppColAgentCoverage> getAppColAgentCoverageList() {
        return appColAgentCoverageList;
    }

    public void setCollectionAgentCode(String collectionAgentCode) {
        this.collectionAgentCode = collectionAgentCode;
    }

    public String getCollectionAgentCode() {
        return collectionAgentCode;
    }

    public void setCollectionAgentDescription(String collectionAgentDescription) {
        this.collectionAgentDescription = collectionAgentDescription;
    }

    public String getCollectionAgentDescription() {
        return collectionAgentDescription;
    }

    public void setEffectiveDateOfSuspension(Timestamp effectiveDateOfSuspension) {
        this.effectiveDateOfSuspension = effectiveDateOfSuspension;
    }

    public Timestamp getEffectiveDateOfSuspension() {
        return effectiveDateOfSuspension;
    }

    public void setExpiryDateOfSuspension(Timestamp expiryDateOfSuspension) {
        this.expiryDateOfSuspension = expiryDateOfSuspension;
    }

    public Timestamp getExpiryDateOfSuspension() {
        return expiryDateOfSuspension;
    }

    public void setReasonForSuspension(String reasonForSuspension) {
        this.reasonForSuspension = reasonForSuspension;
    }

    public String getReasonForSuspension() {
        return reasonForSuspension;
    }
}
