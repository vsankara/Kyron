package com.technobrain.trips.application.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppAuthorisation.findAll", query = "select o from AppAuthorisation o")
@Table(name = "APP_AUTHORISATION")
public class AppAuthorisation extends BaseNormalModelObject {
    @Column(name="AUTH_DATE")
    private Timestamp authDate;
    @Column(name="AUTH_EFFECTIVE_DATE")
    private Timestamp authEffectiveDate;
    @Column(name="AUTH_EXPIRY_DATE")
    private Timestamp authExpiryDate;
    @ReferenceNumber(format="AUTH/SQL", sql="SELECT LTRIM(TO_CHAR(MOD(APP_AUTHORISATION_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")
    @Column(name="AUTH_REFERENCE")
    private String authReference;
    @Column(name="AUTH_STATUS")
    private String authStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_AUTHORISATION_SEQ")
    @SequenceGenerator(name = "APP_AUTHORISATION_SEQ", sequenceName = "APP_AUTHORISATION_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;

    public AppAuthorisation() {
    }

    public Timestamp getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Timestamp authDate) {
        this.authDate = authDate;
    }

    public Timestamp getAuthEffectiveDate() {
        return authEffectiveDate;
    }

    public void setAuthEffectiveDate(Timestamp authEffectiveDate) {
        this.authEffectiveDate = authEffectiveDate;
    }

    public Timestamp getAuthExpiryDate() {
        return authExpiryDate;
    }

    public void setAuthExpiryDate(Timestamp authExpiryDate) {
        this.authExpiryDate = authExpiryDate;
    }

    public String getAuthReference() {
        return authReference;
    }

    public void setAuthReference(String authReference) {
        this.authReference = authReference;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    }
