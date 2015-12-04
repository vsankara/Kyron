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
@NamedQuery(name = "AppWhGoods.findAll", query = "select o from AppWhGoods o")
@Table(name = "APP_WH_GOODS")
public class AppWhGoods extends BaseNormalModelObject {
    @Column(name="COMMODITY_CODE")
    private String commodityCode;
    @Column(name="CURRENCY_CODE")
    private String currencyCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_WAREHOUSE_GOODS_SEQ")
    @SequenceGenerator(name = "APP_WAREHOUSE_GOODS_SEQ", sequenceName = "APP_WAREHOUSE_GOODS_SEQ", allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(name="NONWAREHOUSE_GOODS")
    private String nonwarehouseGoods;
    private java.math.BigDecimal quantity;
    @Column(name="GOODS_VALUE")
    private java.math.BigDecimal goodsValue;
    private String remarks;
    @Column(name="UNITS_CODE")
    private String unitsCode;
    @Column(name="MEASUREMENT_TYPE_CODE")
    private String measurementTypeCode;
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_APP_ID", referencedColumnName = "ID")
    private AppWhAuthorisation appWhAuthorisation;

    public AppWhGoods() {
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNonwarehouseGoods() {
        return nonwarehouseGoods;
    }

    public void setNonwarehouseGoods(String nonwarehouseGoods) {
        this.nonwarehouseGoods = nonwarehouseGoods;
    }

    public java.math.BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }


    public AppWhAuthorisation getAppWhAuthorisation() {
        return appWhAuthorisation;
    }

    public void setAppWhAuthorisation(AppWhAuthorisation appWhAuthorisation) {
        this.appWhAuthorisation = appWhAuthorisation;
    }

    public void setGoodsValue(BigDecimal goodsValue) {
        this.goodsValue = goodsValue;
    }

    public BigDecimal getGoodsValue() {
        return goodsValue;
    }

    public void setMeasurementTypeCode(String measurementTypeCode) {
        this.measurementTypeCode = measurementTypeCode;
    }

    public String getMeasurementTypeCode() {
        return measurementTypeCode;
    }
}
