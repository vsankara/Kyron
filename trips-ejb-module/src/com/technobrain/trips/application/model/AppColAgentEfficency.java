package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppColAgentEfficency.findAll", 
    query = "select o from AppColAgentEfficency o")
@Table(name = "APP_COLAGENT_EFFIC")
public class AppColAgentEfficency  extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_COLAGENT_EFFIC_SEQ")
    @SequenceGenerator(name = "APP_COLAGENT_EFFIC_SEQ", sequenceName = "APP_COLAGENT_EFFIC_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="ERROR_DATE")
    Timestamp errorDate;
    @Column(name="ERROR_CODE")
    String errorCode;
    @Column(name="ERROR_DESC")
    String errorDescription;   
    
    
    @ManyToOne
    @JoinColumn(name = "APP_ACCREDITATION", referencedColumnName = "ID")
    private AppAccreditation appAccreditation;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAppAccreditation(AppAccreditation appAccreditation) {
        this.appAccreditation = appAccreditation;
    }

    public AppAccreditation getAppAccreditation() {
        return appAccreditation;
    }

    public void setErrorDate(Timestamp errorDate) {
        this.errorDate = errorDate;
    }

    public Timestamp getErrorDate() {
        return errorDate;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
