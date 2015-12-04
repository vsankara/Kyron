package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppConfiguration.findAll", query = "select o from AppConfiguration o")
@Table(name = "APP_CONFIGURATION")
@NamedQueries({
    @NamedQuery(
    name="AppConfiguration.findAppConfigurationByAppType",
    query="select conf from AppConfiguration conf where conf.applicationType= ?1"
    ),
    @NamedQuery(
    name="AppConfiguration.findAppConfigurationById",
    query="select conf from AppConfiguration conf where conf.id = ?1"
    )
})
public class AppConfiguration extends BaseNormalModelObject {
    @Column(name="APPLICATION_FEES")
    private BigDecimal applicationFees;
    @Column(name="APPLICATION_TYPE")
    private String applicationType;
    @Column(name="DECLARATION_STATEMENT")
    private String declarationStatement;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CONFIGURATION_SEQ")
    @SequenceGenerator(name = "APP_CONFIGURATION_SEQ", sequenceName = "APP_CONFIGURATION_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @Column(name="VALIDITY_PERIOD")
    private Integer validityPeriod;
    
    @OneToMany(mappedBy = "appConfiguration",cascade={CascadeType.ALL})
    private List<AppConfigurationAttachment> appConfigurationAttachmentList;
    
    @OneToMany(mappedBy = "appConfiguration",cascade={CascadeType.ALL})
    private List<AppCustomsProcedure> appCustomsProcedureList;

    @OneToMany(mappedBy = "appConfiguration",cascade={CascadeType.ALL})
    private List<AppRole> appRoleList;

    public AppConfiguration() {
    }

    public BigDecimal getApplicationFees() {
        return applicationFees;
    }

    public void setApplicationFees(BigDecimal applicationFees) {
        this.applicationFees = applicationFees;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getDeclarationStatement() {
        return declarationStatement;
    }

    public void setDeclarationStatement(String declarationStatement) {
        this.declarationStatement = declarationStatement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
    
    public List<AppConfigurationAttachment> getAppConfigurationAttachmentList() {
        return appConfigurationAttachmentList;
    }

    public void setAppConfigurationAttachmentList(List<AppConfigurationAttachment> appConfigurationAttachmentList) {
        this.appConfigurationAttachmentList = appConfigurationAttachmentList;
    }

    public AppConfigurationAttachment addAppConfigurationAttachment(AppConfigurationAttachment appConfigurationAttachment) {
        getAppConfigurationAttachmentList().add(appConfigurationAttachment);
        appConfigurationAttachment.setAppConfiguration(this);
        return appConfigurationAttachment;
    }

    public AppConfigurationAttachment removeAppConfigurationAttachment(AppConfigurationAttachment appConfigurationAttachment) {
        getAppConfigurationAttachmentList().remove(appConfigurationAttachment);
        appConfigurationAttachment.setAppConfiguration(null);
        return appConfigurationAttachment;
    }

    public void setAppRoleList(List<AppRole> appRoleList) {
        this.appRoleList = appRoleList;
    }

    public List<AppRole> getAppRoleList() {
        return appRoleList;
    }
    
    public AppRole addAppRole(AppRole appRole) {
        getAppRoleList().add(appRole);
        appRole.setAppConfiguration(this);
        return appRole;
    }

    public AppRole removeAppRole(AppRole appRole) {
        getAppRoleList().remove(appRole);
        appRole.setAppConfiguration(null);
        return appRole;
    }

    public void setAppCustomsProcedureList(List<AppCustomsProcedure> appCustomsProcedureList) {
        this.appCustomsProcedureList = appCustomsProcedureList;
    }

    public List<AppCustomsProcedure> getAppCustomsProcedureList() {
        return appCustomsProcedureList;
    }
    
    public AppCustomsProcedure addAppCustomsProcedure(AppCustomsProcedure appCustomsProcedure) {
        getAppCustomsProcedureList().add(appCustomsProcedure);
        appCustomsProcedure.setAppConfiguration(this);
        return appCustomsProcedure;
    }

    public AppCustomsProcedure removeAppCustomsProcedure(AppCustomsProcedure appCustomsProcedure) {
        getAppCustomsProcedureList().remove(appCustomsProcedure);
        appCustomsProcedure.setAppConfiguration(null);
        return appCustomsProcedure;
    }
}
