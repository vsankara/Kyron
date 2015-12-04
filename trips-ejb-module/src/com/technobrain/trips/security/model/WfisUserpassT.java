package com.technobrain.trips.security.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "WfisUserpassT.findAll", 
    query = "select o from WfisUserpassT o")
@Table(name = "WFIS_USERPASS_T")
@IdClass(WfisUserpassTPK.class)
public class WfisUserpassT implements Serializable {
    @Column(nullable = false)
    private Long id;
    @Id
    @Column(nullable = false, insertable = false, updatable = false)
    private String name;
    @Column(name = "PASS_EXPIRY_DATE")
    private Timestamp passwordExpiryDate;    
    @Column(nullable = false)
    private String pass;
    @Id
    @Column(nullable = false, insertable = false, updatable = false)
    private String realm;
    @OneToOne
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM"),
    @JoinColumn(name = "NAME", referencedColumnName = "NAME")
    })
    private WfisUserT wfisUserT;

    public WfisUserpassT() {
    }

    public Long getId() { 
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public WfisUserT getWfisUserT() {
        return wfisUserT;
    }

    public void setWfisUserT(WfisUserT wfisUserT) {
        this.wfisUserT = wfisUserT;
    }

    public void setPasswordExpiryDate(Timestamp passwordExpiryDate) {
        this.passwordExpiryDate = passwordExpiryDate;
    }

    public Timestamp getPasswordExpiryDate() {
        return passwordExpiryDate;
    }
}
