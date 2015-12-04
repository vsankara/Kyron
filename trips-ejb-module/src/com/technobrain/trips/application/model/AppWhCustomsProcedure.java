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
@NamedQuery(name = "AppWhCustomsProcedure.findAll", query = "select o from AppWhCustomsProcedure o")
@Table(name = "APP_WH_CUSTOMS_PROCEDURE")
public class AppWhCustomsProcedure extends BaseNormalModelObject {
    @Column(name="AUTHORISATION_INDICATOR")
    private String authorisationIndicator;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_CUSTOMS_PROCEDURE_SEQ")
    @SequenceGenerator(name = "APP_WH_CUSTOMS_PROCEDURE_SEQ", sequenceName = "APP_WH_CUSTOMS_PROCEDURE_SEQ", allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(name="PROCEDURE_CODE")
    private String procedureCode;
    @ManyToOne
    @JoinColumn(name = "WH_CUST_CONTROL_POINT_ID", referencedColumnName = "ID")
    private AppWhCustControlPoint appWhCustControlPoint;

    public AppWhCustomsProcedure() {
    }

    public String getAuthorisationIndicator() {
        return authorisationIndicator;
    }

    public void setAuthorisationIndicator(String authorisationIndicator) {
        this.authorisationIndicator = authorisationIndicator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public AppWhCustControlPoint getAppWhCustControlPoint() {
        return appWhCustControlPoint;
    }

    public void setAppWhCustControlPoint(AppWhCustControlPoint appWhCustControlPoint) {
        this.appWhCustControlPoint = appWhCustControlPoint;
    }
}
