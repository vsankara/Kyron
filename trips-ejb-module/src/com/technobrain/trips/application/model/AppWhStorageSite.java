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
@NamedQuery(name = "AppWhStorageSite.findAll", query = "select o from AppWhStorageSite o")
@Table(name = "APP_WH_STORAGE_SITE")
public class AppWhStorageSite extends BaseNormalModelObject {
    private String address;
    @Column(name="AUTHORISATION_NO")
    private String authorisationNo;
    private String code;
    private String name;
    @Column(name="FROM_SOURCE")
    private String fromSource;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_STORAGE_SITE_SEQ")
    @SequenceGenerator(name = "APP_WH_STORAGE_SITE_SEQ", sequenceName = "APP_WH_STORAGE_SITE_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;

    public AppWhStorageSite() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthorisationNo() {
        return authorisationNo;
    }

    public void setAuthorisationNo(String authorisationNo) {
        this.authorisationNo = authorisationNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppWhAuthorisation getAppWhAuthorisation() {
        return appWhAuthorisation;
    }

    public void setAppWhAuthorisation(AppWhAuthorisation appWhAuthorisation) {
        this.appWhAuthorisation = appWhAuthorisation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getFromSource() {
        return fromSource;
    }
}
