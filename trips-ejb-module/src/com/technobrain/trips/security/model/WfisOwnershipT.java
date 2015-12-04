package com.technobrain.trips.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "WfisOwnershipT.findAll", 
    query = "select o from WfisOwnershipT o")
@Table(name = "WFIS_OWNERSHIP_T")
public class WfisOwnershipT implements Serializable {
    private String ownedrole;
    @Id
    @Column(nullable = false)
    private Long ownerid;
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM",insertable=false, updatable=false),
    @JoinColumn(name = "USEROWNER", referencedColumnName = "NAME",insertable=false, updatable=false)
    })
    private WfisUserT wfisUserT;
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM",insertable=false, updatable=false),
    @JoinColumn(name = "ROLEOWNER", referencedColumnName = "NAME",insertable=false, updatable=false)
    })
    private WfisRoleT wfisRole;

    public WfisOwnershipT() {
    }

    public String getOwnedrole() {
        return ownedrole;
    }

    public void setOwnedrole(String ownedrole) {
        this.ownedrole = ownedrole;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }


    public WfisUserT getWfisUserT() {
        return wfisUserT;
    }

    public void setWfisUserT(WfisUserT wfisUserT) {
        this.wfisUserT = wfisUserT;
    }

    public WfisRoleT getWfisRole() {
        return wfisRole;
    }

    public void setWfisRole(WfisRoleT wfisRoleT) {
        this.wfisRole = wfisRoleT;
    }
}
