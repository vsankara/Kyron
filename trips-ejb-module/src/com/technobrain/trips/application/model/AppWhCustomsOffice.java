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
@NamedQuery(name = "AppWhCustomsOffice.findAll", query = "select o from AppWhCustomsOffice o")
@Table(name = "APP_WH_CUSTOMS_OFFICE")
public class AppWhCustomsOffice extends BaseNormalModelObject {
    @Column(name="CUSTOMS_OFFICE_CODE")
    private String customsOfficeCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WH_CUSTOMS_OFFICE_SEQ")
    @SequenceGenerator(name = "APP_WH_CUSTOMS_OFFICE_SEQ", sequenceName = "APP_WH_CUSTOMS_OFFICE_SEQ", allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "WH_CUST_CONTROL_POINT_ID", referencedColumnName = "ID")
    private AppWhCustControlPoint appWhCustControlPoint;

    public AppWhCustomsOffice() {
    }

    public String getCustomsOfficeCode() {
        return customsOfficeCode;
    }

    public void setCustomsOfficeCode(String customsOfficeCode) {
        this.customsOfficeCode = customsOfficeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public AppWhCustControlPoint getAppWhCustControlPoint() {
        return appWhCustControlPoint;
    }

    public void setAppWhCustControlPoint(AppWhCustControlPoint appWhCustControlPoint) {
        this.appWhCustControlPoint = appWhCustControlPoint;
    }
}
