package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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
@NamedQuery(name = "AppColAgentCoverage.findAll", 
    query = "select o from AppColAgentCoverage o")
@Table(name = "APP_COLAGENT_COV")
public class AppColAgentCoverage extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_COLAGENT_COV_SEQ")
    @SequenceGenerator(name = "APP_COLAGENT_COV_SEQ", sequenceName = "APP_COLAGENT_COV_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="OFFICE_CODE")
    String officeCode;
    
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

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeCode() {
        return officeCode;
    }
}
