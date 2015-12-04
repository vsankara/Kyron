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
@NamedQuery(name = "AppCustomsProcedure.findAll", query = "select o from AppCustomsProcedure o")
@Table(name = "APP_CUSTOMS_PROCEDURE")
public class AppCustomsProcedure extends BaseNormalModelObject {
    @ManyToOne
    @JoinColumn(name = "APP_CONFIGURATION_ID", referencedColumnName = "ID")
    private AppConfiguration appConfiguration;
    @Column(name="CUSTOMS_PROCEDURE")
    private String customsProcedure;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CUSTOMS_PROCEDURE_SEQ")
    @SequenceGenerator(name = "APP_CUSTOMS_PROCEDURE_SEQ", sequenceName = "APP_CUSTOMS_PROCEDURE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    public AppCustomsProcedure() {
    }

    public String getCustomsProcedure() {
        return customsProcedure;
    }

    public void setCustomsProcedure(String customsProcedure) {
        this.customsProcedure = customsProcedure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }
}
