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
@NamedQuery(name = "AppWhTransferMethod.findAll", query = "select o from AppWhTransferMethod o")
@Table(name = "APP_WH_TRANSFER_METHOD")
public class AppWhTransferMethod extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_TRANSFER_METHOD_SEQ")
    @SequenceGenerator(name = "APP_WH_TRANSFER_METHOD_SEQ", sequenceName = "APP_WH_TRANSFER_METHOD_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @Column(name="TRANSFER_DOC_CODE")
    private String transferDocCode;
    @Column(name="TRANSFER_METHOD_CODE")
    private String transferMethodCode;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;

    public AppWhTransferMethod() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferDocCode() {
        return transferDocCode;
    }

    public void setTransferDocCode(String transferDocCode) {
        this.transferDocCode = transferDocCode;
    }

    public String getTransferMethodCode() {
        return transferMethodCode;
    }

    public void setTransferMethodCode(String transferMethodCode) {
        this.transferMethodCode = transferMethodCode;
    }

    public AppWhAuthorisation getAppWhAuthorisation() {
        return appWhAuthorisation;
    }

    public void setAppWhAuthorisation(AppWhAuthorisation appWhAuthorisation) {
        this.appWhAuthorisation = appWhAuthorisation;
    }
}
