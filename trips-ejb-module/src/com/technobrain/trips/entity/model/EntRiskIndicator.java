package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

    @NamedQueries( { @NamedQuery(name = "EntRiskIndicator.findAll", 
    query = "select o from EntRiskIndicator o"), 
    @NamedQuery(name = "EntRiskIndicator.findTaxPayerRiskIndicators", 
    query = "Select o from EntRiskIndicator o where o.entId= ?1 "),
    @NamedQuery(name = "EntRiskIndicator.findTaxPayerRiskIndicatorByIndType", 
    query = "select o from EntRiskIndicator o where o.riskIndType=?1")
    } )
@Table(name = "ENT_RISK_INDICATOR")
public class EntRiskIndicator extends BaseNormalModelObject  {
    @Column(name="RISK_IND_TYPE", nullable = false)
    private String riskIndType;
    @Column(name="ENT_ENTITY")
    private Long entId;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID", insertable=false,updatable=false)
    private EntEntity entEntity;
        
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ENT_RISK_INDICATOR_SEQ")
    @SequenceGenerator(name = "ENT_RISK_INDICATOR_SEQ", 
                       sequenceName = "ENT_RISK_INDICATOR_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long value;


    public EntRiskIndicator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setRiskIndType(String riskIndType) {
        this.riskIndType = riskIndType;
    }

    public String getRiskIndType() {
        return riskIndType;
    }

    public void setEntId(Long entId) {
        this.entId = entId;
    }

    public Long getEntId() {
        return entId;
    }
}
