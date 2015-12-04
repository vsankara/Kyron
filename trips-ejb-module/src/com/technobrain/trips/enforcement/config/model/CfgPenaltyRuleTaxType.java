package com.technobrain.trips.enforcement.config.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "CfgPenaltyRuleTaxType.findAll", 
    query = "select o from CfgPenaltyRuleTaxType o")
@Table(name = "CFG_PENALTY_RULE_TAX_TYPE")
public class CfgPenaltyRuleTaxType extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CFG_PENALTY_RULE_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "CFG_PENALTY_RULE_TAX_TYPE_SEQ", sequenceName = "CFG_PENALTY_RULE_TAX_TYPE_SEQ", 
                       allocationSize = 1)      
    @Column(nullable = false)
    private Long id;
    @Column(name="TAX_TYPE", nullable = false)
    private String taxType;
    
    @ManyToOne
    @JoinColumn(name = "PENALTY_RULE", referencedColumnName = "ID",nullable = false)
    private CfgPenaltyRule penaltyRule;

    public CfgPenaltyRuleTaxType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CfgPenaltyRule getPenaltyRule() {
        return penaltyRule;
    }

    public void setPenaltyRule(CfgPenaltyRule penaltyRule) {
        this.penaltyRule = penaltyRule;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

}
