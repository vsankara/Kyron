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
@NamedQuery(name = "AppOffice.findAll", query = "select o from AppOffice o")
@Table(name = "APP_OFFICE")
public class AppOffice extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_OFFICE_SEQ")
    @SequenceGenerator(name = "APP_OFFICE_SEQ", sequenceName = "APP_OFFICE_SEQ", allocationSize = 1)            
    @Column(nullable = false)
    private Long id;
    private String office;
    @Column(name="OFFICE_ROLE")
    private String officeRole;
    @ManyToOne
    @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID")
    private AppApplication appApplication;

    public AppOffice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOfficeRole() {
        return officeRole;
    }

    public void setOfficeRole(String officeRole) {
        this.officeRole = officeRole;
    }

    public AppApplication getAppApplication() {
        return appApplication;
    }

    public void setAppApplication(AppApplication appApplication) {
        this.appApplication = appApplication;
    }
}
