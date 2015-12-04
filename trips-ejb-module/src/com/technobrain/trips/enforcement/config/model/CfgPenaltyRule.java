package com.technobrain.trips.enforcement.config.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "CfgPenaltyRule.findAll", 
    query = "select o from CfgPenaltyRule o")
@Table(name = "CFG_PENALTY_RULE")
public class CfgPenaltyRule extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CFG_PENALTY_RULE_SEQ")
    @SequenceGenerator(name = "CFG_PENALTY_RULE_SEQ", sequenceName = "CFG_PENALTY_RULE_SEQ", 
                       allocationSize = 1)       
    @Column(nullable = false)
    private Long id;
    @Column(name="PENALTY_CODE", nullable = false)
    private String penaltyCode;
    @Column(nullable = false)
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="LEGAL_REFERENCE")
    private String legalReference;
    @Column(name="MAXIMUM_AMOUNT")
    private BigDecimal maximumAmount;
    @Column(name="MINIMUM_AMOUNT")
    private BigDecimal minimumAmount;
    @Column(name="PENALTY_RULE_TYPE")
    private String penaltyRuleType;
    @Column(name="PENALTY_UNIT_TYPE")
    private String penaltyUnitType;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "penaltyRule")
    private List<CfgPenaltyRuleTaxType> penaltyRuleTaxTypeList;
   
    public CfgPenaltyRule() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLegalReference() {
        return legalReference;
    }

    public void setLegalReference(String legalReference) {
        this.legalReference = legalReference;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getPenaltyRuleType() {
        return penaltyRuleType;
    }

    public void setPenaltyRuleType(String penaltyRuleType) {
        this.penaltyRuleType = penaltyRuleType;
    }

    public String getPenaltyUnitType() {
        return penaltyUnitType;
    }

    public void setPenaltyUnitType(String penaltyUnitType) {
        this.penaltyUnitType = penaltyUnitType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPenaltyCode(String penaltyCode) {
        this.penaltyCode = penaltyCode;
    }

    public String getPenaltyCode() {
        return penaltyCode;
    }
   
    public CfgPenaltyRuleTaxType addCfgPenaltyRuleTaxType(CfgPenaltyRuleTaxType cfgPenaltyRuleTaxType) {
        cfgPenaltyRuleTaxType.setPenaltyRule(this);
        getPenaltyRuleTaxTypeList().add(cfgPenaltyRuleTaxType);
        return cfgPenaltyRuleTaxType;
    }

    public CfgPenaltyRuleTaxType removeCfgPenaltyRuleTaxType(CfgPenaltyRuleTaxType cfgPenaltyRuleTaxType) {
        getPenaltyRuleTaxTypeList().remove(cfgPenaltyRuleTaxType);
        return cfgPenaltyRuleTaxType;
    }

    public void setPenaltyRuleTaxTypeList(List<CfgPenaltyRuleTaxType> penaltyRuleTaxTypeList) {
        this.penaltyRuleTaxTypeList = penaltyRuleTaxTypeList;
    }

    public List<CfgPenaltyRuleTaxType> getPenaltyRuleTaxTypeList() {
        return penaltyRuleTaxTypeList;
    }
}
