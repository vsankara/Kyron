package com.technobrain.trips.debtmanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

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

/**
 * Model class representing the table DEBT_CASE_RECOVERY. 
 * 
 *@author
 *@version
 *@since   
 *@see DebtCaseDetails
 * 
 */
@Entity
@NamedQuery(name = "DebtCaseRecovery.findAll", 
            query = "select o from DebtCaseRecovery o")
@Table(name = "DEBT_CASE_RECOVERY")
public class DebtCaseRecovery extends BaseNormalModelObject {

    @Column(name = "ASSET_LOCATION")
    private String assetLocation;
    @Column(name = "ASSET_NAME")
    private String assetName;
    @Column(name = "ASSET_SALE_VALUE")
    private BigDecimal assetSaleValue;
    @Column(name = "ASSET_VALUE")
    private BigDecimal assetValue;

    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "DEBT_CASE_RECOVERY_SEQ")
    @SequenceGenerator(name = "DEBT_CASE_RECOVERY_SEQ", 
                       sequenceName = "DEBT_CASE_RECOVERY_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private DebtCaseDetails debtCaseDetails;

    public DebtCaseRecovery() {
    }


    public String getAssetLocation() {
        return assetLocation;
    }

    public void setAssetLocation(String assetLocation) {
        this.assetLocation = assetLocation;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getAssetSaleValue() {
        return assetSaleValue;
    }

    public void setAssetSaleValue(BigDecimal assetSaleValue) {
        this.assetSaleValue = assetSaleValue;
    }

    public BigDecimal getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(BigDecimal assetValue) {
        this.assetValue = assetValue;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setDebtCaseDetails(DebtCaseDetails debtCaseDetails) {
        this.debtCaseDetails = debtCaseDetails;
    }

    public DebtCaseDetails getDebtCaseDetails() {
        return debtCaseDetails;
    }
}
