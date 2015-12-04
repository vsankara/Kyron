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
@NamedQuery(name = "AppRole.findAll", query = "select o from AppRole o")
@Table(name = "APP_ROLE")
public class AppRole extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ROLE_SEQ")
    @SequenceGenerator(name = "APP_ROLE_SEQ", sequenceName = "APP_ROLE_SEQ", allocationSize = 1)            
    @Column(nullable = false)
    private Long id;
    private String role;
    @Column(name="ROLE_TYPE")
    private String roleType;
    @ManyToOne
    @JoinColumn(name = "APP_CONFIGURATION_ID", referencedColumnName = "ID")
    private AppConfiguration appConfiguration;

    public AppRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }
}
