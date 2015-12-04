package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.math.BigDecimal;

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
@NamedQuery(name = "AppTaxpExemptCommodity.findAll", query = "select o from AppTaxpExemptCommodity o")
@Table(name = "APP_TAXP_EXEMPT_COMMODITY")
public class AppTaxpExemptCommodity extends BaseNormalModelObject {
    @Column(name="EXEMPT_COMMODITY")
    private String exemptCommodity;
    @Column(name="EXEMPT_QUANTITY")
    private BigDecimal exemptQuantity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_TAXP_EXEMPT_COMMODITY_SEQ")
    @SequenceGenerator(name = "APP_TAXP_EXEMPT_COMMODITY_SEQ", sequenceName = "APP_TAXP_EXEMPT_COMMODITY_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String measurement;
    @ManyToOne
    @JoinColumn(name = "TAXPAYER_EXEMPT_APP_ID", referencedColumnName = "ID")
    private AppTaxpayerExempt appTaxpayerExempt;

    public AppTaxpExemptCommodity() {
    }

    public String getExemptCommodity() {
        return exemptCommodity;
    }

    public void setExemptCommodity(String exemptCommodity) {
        this.exemptCommodity = exemptCommodity;
    }

    public BigDecimal getExemptQuantity() {
        return exemptQuantity;
    }

    public void setExemptQuantity(BigDecimal exemptQuantity) {
        this.exemptQuantity = exemptQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public AppTaxpayerExempt getAppTaxpayerExempt() {
        return appTaxpayerExempt;
    }

    public void setAppTaxpayerExempt(AppTaxpayerExempt appTaxpayerExempt) {
        this.appTaxpayerExempt = appTaxpayerExempt;
    }
}
