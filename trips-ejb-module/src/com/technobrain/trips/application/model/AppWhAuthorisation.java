package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocDocument;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppWhAuthorisation.findAll", query = "select o from AppWhAuthorisation o")
@Table(name = "APP_WH_AUTHORISATION")
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("WH_AUTH")
public class AppWhAuthorisation extends AppApplication {
    @Column(name="ADDITIONAL_INFORMATION")
    private String additionalInformation;
    @Column(name="ECONOMICS_CONDITIONS")
    private String economicsConditions;
    @Column(name="INVENTORY_METHOD_CODE")
    private String inventoryMethodCode;
    @Column(name="LOSS_RATE")
    private String lossRate;
    @Column(name="PRE_FIN_EXCISABLE_GOODS_IND")
    private String preFinExcisableGoodsInd;
    @Column(name="REMOVAL_DURATION")
    private java.math.BigDecimal removalDuration;
    @Column(name="REMOVAL_NOTIF_METHOD_CODE")
    private String removalNotifMethodCode;
    @Column(name="REMOVAL_PURPOSE")
    private String removalPurpose;
    @Column(name="TEMP_REMOVAL_DESTINATION")
    private String tempRemovalDestination;
    @Column(name="TEMP_REMOV_AUTH_TYPE_CODE")
    private String tempRemovAuthTypeCode;
    @Column(name="WAREHOUSE_TYPE_CODE")
    private String warehouseTypeCode;
    @Column(name="WH_AUTH_TYPE_CODE")
    private String whAuthTypeCode;
    @Column(name="WAREHOUSE_CODE")
    private String warehouseCode;
    @Column(name="WAREHOUSE_NAME")
    private String warehouseName;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppWhHandlingOps> appWhHandlingOpsList;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppWhGoods> appWhGoodsList;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppWhCustControlPoint> appWhCustControlPointList;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppWhStorageSite> appWhStorageSiteList;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppWhTransferMethod> appWhTransferMethodList;
    @OneToMany(mappedBy = "appWhAuthorisation", cascade={CascadeType.ALL})
    private List<AppGoodsIdentification> appGoodsIdentificationList;

    public AppWhAuthorisation() {
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getEconomicsConditions() {
        return economicsConditions;
    }

    public void setEconomicsConditions(String economicsConditions) {
        this.economicsConditions = economicsConditions;
    }

    public String getInventoryMethodCode() {
        return inventoryMethodCode;
    }

    public void setInventoryMethodCode(String inventoryMethodCode) {
        this.inventoryMethodCode = inventoryMethodCode;
    }

    public String getLossRate() {
        return lossRate;
    }

    public void setLossRate(String lossRate) {
        this.lossRate = lossRate;
    }

    public String getPreFinExcisableGoodsInd() {
        return preFinExcisableGoodsInd;
    }

    public void setPreFinExcisableGoodsInd(String preFinExcisableGoodsInd) {
        this.preFinExcisableGoodsInd = preFinExcisableGoodsInd;
    }

    public java.math.BigDecimal getRemovalDuration() {
        return removalDuration;
    }

    public void setRemovalDuration(java.math.BigDecimal removalDuration) {
        this.removalDuration = removalDuration;
    }

    public String getRemovalNotifMethodCode() {
        return removalNotifMethodCode;
    }

    public void setRemovalNotifMethodCode(String removalNotifMethodCode) {
        this.removalNotifMethodCode = removalNotifMethodCode;
    }

    public String getRemovalPurpose() {
        return removalPurpose;
    }

    public void setRemovalPurpose(String removalPurpose) {
        this.removalPurpose = removalPurpose;
    }

    public String getTempRemovalDestination() {
        return tempRemovalDestination;
    }

    public void setTempRemovalDestination(String tempRemovalDestination) {
        this.tempRemovalDestination = tempRemovalDestination;
    }

    public String getTempRemovAuthTypeCode() {
        return tempRemovAuthTypeCode;
    }

    public void setTempRemovAuthTypeCode(String tempRemovAuthTypeCode) {
        this.tempRemovAuthTypeCode = tempRemovAuthTypeCode;
    }

    public String getWarehouseTypeCode() {
        return warehouseTypeCode;
    }

    public void setWarehouseTypeCode(String warehouseTypeCode) {
        this.warehouseTypeCode = warehouseTypeCode;
    }

    public String getWhAuthTypeCode() {
        return whAuthTypeCode;
    }

    public void setWhAuthTypeCode(String whAuthTypeCode) {
        this.whAuthTypeCode = whAuthTypeCode;
    }

    public List<AppWhHandlingOps> getAppWhHandlingOpsList() {
        return appWhHandlingOpsList;
    }

    public void setAppWhHandlingOpsList(List<AppWhHandlingOps> appWhHandlingOpsList) {
        this.appWhHandlingOpsList = appWhHandlingOpsList;
    }

    public AppWhHandlingOps addAppWhHandlingOps(AppWhHandlingOps appWhHandlingOps) {
        getAppWhHandlingOpsList().add(appWhHandlingOps);
        appWhHandlingOps.setAppWhAuthorisation(this);
        return appWhHandlingOps;
    }

    public AppWhHandlingOps removeAppWhHandlingOps(AppWhHandlingOps appWhHandlingOps) {
        getAppWhHandlingOpsList().remove(appWhHandlingOps);
        appWhHandlingOps.setAppWhAuthorisation(null);
        return appWhHandlingOps;
    }

    public List<AppWhGoods> getAppWhGoodsList() {
        return appWhGoodsList;
    }

    public void setAppWhGoodsList(List<AppWhGoods> appWhGoodsList) {
        this.appWhGoodsList = appWhGoodsList;
    }

    public AppWhGoods addAppWhGoods(AppWhGoods appWhGoods) {
        getAppWhGoodsList().add(appWhGoods);
        appWhGoods.setAppWhAuthorisation(this);
        return appWhGoods;
    }

    public AppWhGoods removeAppWhGoods(AppWhGoods appWhGoods) {
        getAppWhGoodsList().remove(appWhGoods);
        appWhGoods.setAppWhAuthorisation(null);
        return appWhGoods;
    }

    public List<AppWhCustControlPoint> getAppWhCustControlPointList() {
        return appWhCustControlPointList;
    }

    public void setAppWhCustControlPointList(List<AppWhCustControlPoint> appWhCustControlPointList) {
        this.appWhCustControlPointList = appWhCustControlPointList;
    }

    public AppWhCustControlPoint addAppWhCustControlPoint(AppWhCustControlPoint appWhCustControlPoint) {
        getAppWhCustControlPointList().add(appWhCustControlPoint);
        appWhCustControlPoint.setAppWhAuthorisation(this);
        return appWhCustControlPoint;
    }

    public AppWhCustControlPoint removeAppWhCustControlPoint(AppWhCustControlPoint appWhCustControlPoint) {
        getAppWhCustControlPointList().remove(appWhCustControlPoint);
        appWhCustControlPoint.setAppWhAuthorisation(null);
        return appWhCustControlPoint;
    }

    public List<AppWhStorageSite> getAppWhStorageSiteList() {
        return appWhStorageSiteList;
    }

    public void setAppWhStorageSiteList(List<AppWhStorageSite> appWhStorageSiteList) {
        this.appWhStorageSiteList = appWhStorageSiteList;
    }

    public AppWhStorageSite addAppWhStorageSite(AppWhStorageSite appWhStorageSite) {
        getAppWhStorageSiteList().add(appWhStorageSite);
        appWhStorageSite.setAppWhAuthorisation(this);
        return appWhStorageSite;
    }

    public AppWhStorageSite removeAppWhStorageSite(AppWhStorageSite appWhStorageSite) {
        getAppWhStorageSiteList().remove(appWhStorageSite);
        appWhStorageSite.setAppWhAuthorisation(null);
        return appWhStorageSite;
    }

    public List<AppWhTransferMethod> getAppWhTransferMethodList() {
        return appWhTransferMethodList;
    }

    public void setAppWhTransferMethodList(List<AppWhTransferMethod> appWhTransferMethodList) {
        this.appWhTransferMethodList = appWhTransferMethodList;
    }

    public AppWhTransferMethod addAppWhTransferMethod(AppWhTransferMethod appWhTransferMethod) {
        getAppWhTransferMethodList().add(appWhTransferMethod);
        appWhTransferMethod.setAppWhAuthorisation(this);
        return appWhTransferMethod;
    }

    public AppWhTransferMethod removeAppWhTransferMethod(AppWhTransferMethod appWhTransferMethod) {
        getAppWhTransferMethodList().remove(appWhTransferMethod);
        appWhTransferMethod.setAppWhAuthorisation(null);
        return appWhTransferMethod;
    }

    public List<AppGoodsIdentification> getAppGoodsIdentificationList() {
        return appGoodsIdentificationList;
    }

    public void setAppGoodsIdentificationList(List<AppGoodsIdentification> appGoodsIdentificationList) {
        this.appGoodsIdentificationList = appGoodsIdentificationList;
    }

    public AppGoodsIdentification addAppGoodsIdentification(AppGoodsIdentification appGoodsIdentification) {
        getAppGoodsIdentificationList().add(appGoodsIdentification);
        appGoodsIdentification.setAppWhAuthorisation(this);
        return appGoodsIdentification;
    }

    public AppGoodsIdentification removeAppGoodsIdentification(AppGoodsIdentification appGoodsIdentification) {
        getAppGoodsIdentificationList().remove(appGoodsIdentification);
        appGoodsIdentification.setAppWhAuthorisation(null);
        return appGoodsIdentification;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }
}
