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
@NamedQuery(name = "AppWhHandlingOps.findAll", query = "select o from AppWhHandlingOps o")
@Table(name = "APP_WH_HANDLING_OPS")
public class AppWhHandlingOps extends BaseNormalModelObject {
    @Column(name="HANDLING_OP_CODE")
    private String handlingOpCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_HANDLING_OPS_SEQ")
    @SequenceGenerator(name = "APP_WH_HANDLING_OPS_SEQ", sequenceName = "APP_WH_HANDLING_OPS_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @Column(name="NOTIF_METHOD_CODE")
    private String notifMethodCode;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;

    public AppWhHandlingOps() {
    }

    public String getHandlingOpCode() {
        return handlingOpCode;
    }

    public void setHandlingOpCode(String handlingOpCode) {
        this.handlingOpCode = handlingOpCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotifMethodCode() {
        return notifMethodCode;
    }

    public void setNotifMethodCode(String notifMethodCode) {
        this.notifMethodCode = notifMethodCode;
    }

    public AppWhAuthorisation getAppWhAuthorisation() {
        return appWhAuthorisation;
    }

    public void setAppWhAuthorisation(AppWhAuthorisation appWhAuthorisation) {
        this.appWhAuthorisation = appWhAuthorisation;
    }
}
