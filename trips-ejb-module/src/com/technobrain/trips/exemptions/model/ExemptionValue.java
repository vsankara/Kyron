package com.technobrain.trips.exemptions.model;

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
@NamedQuery(name = "ExemptionValue.findAll", 
    query = "select o from ExemptionValue o")
@Table(name = "EXEMPTION_VALUE")
public class ExemptionValue extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEMPTION_VALUE_SEQ")
    @SequenceGenerator(name = "EXEMPTION_VALUE_SEQ", sequenceName = "EXEMPTION_VALUE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String attribute;
    @Column(name="EXEMPTION_TYPE")
    private String exemptionType;
    private String operator;
    @Column(name="UNIT_TYPE")
    private String unitType;
    private String value;
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private Ecr ecr;

    public ExemptionValue() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
  
    public String getExemptionType() {
        return exemptionType;
    }

    public void setExemptionType(String exemptionType) {
        this.exemptionType = exemptionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setEcr(Ecr ecr) {
        this.ecr = ecr;
    }

    public Ecr getEcr() {
        return ecr;
    }
}
