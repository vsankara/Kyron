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
@NamedQuery(name = "AppGoodsIdentification.findAll", query = "select o from AppGoodsIdentification o")
@Table(name = "APP_GOODS_IDENTIFICATION")
public class AppGoodsIdentification extends BaseNormalModelObject {
    private String code;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_GOODS_IDENTIFICATION_SEQ")
    @SequenceGenerator(name = "APP_GOODS_IDENTIFICATION_SEQ", sequenceName = "APP_GOODS_IDENTIFICATION_SEQ", allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;

    public AppGoodsIdentification() {
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
}
