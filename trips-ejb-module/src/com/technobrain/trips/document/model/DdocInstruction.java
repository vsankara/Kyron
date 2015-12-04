package com.technobrain.trips.document.model;

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


@Entity
@NamedQuery(name = "DdocInstruction.findAll", 
    query = "select o from DdocInstruction o")
@Table(name = "DDOC_INSTRUCTION")
public class DdocInstruction extends BaseNormalModelObject   {
    @Column(name="DDOC_INSPECTION", nullable=false,insertable=false, updatable=false)
    private Long ddocInspectionId;    
    @Column(name="EXPECTED_FINE")
    private BigDecimal expectedFine;
    @Column(name="EXPECTED_FINE_CURRENCY")
    private String expectedFineCurrency;
    @Column(name="EXPECTED_REVENUE")
    private BigDecimal expectedRevenue;
    @Column(name="EXPECTED_REVENUE_CURRENCY")
    private String expectedRevenueCurrency;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_instruction_seq")
    @SequenceGenerator(name = "ddoc_instruction_seq", sequenceName = "ddoc_instruction_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    private char[] instructions;
    private String outcome;
    private char[] result;
     
     
     
     
     
     

    @Column(name="OFFENCE")
    private String offence;    

    @ManyToOne
    @JoinColumn(name = "DDOC_INSPECTION", referencedColumnName = "ID")
    private DdocInspection ddocInspection;
    @Column(name="RISK_PROFILE_ID")
    private Long riskProfileId;    

    public DdocInstruction() {
    }

    public BigDecimal getExpectedFine() {
        return expectedFine;
    }

    public void setExpectedFine(BigDecimal expectedFine) {
        this.expectedFine = expectedFine;
    }

    public String getExpectedFineCurrency() {
        return expectedFineCurrency;
    }

    public void setExpectedFineCurrency(String expectedFineCurrency) {
        this.expectedFineCurrency = expectedFineCurrency;
    }

    public BigDecimal getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(BigDecimal expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public String getExpectedRevenueCurrency() {
        return expectedRevenueCurrency;
    }

    public void setExpectedRevenueCurrency(String expectedRevenueCurrency) {
        this.expectedRevenueCurrency = expectedRevenueCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char[] getInstructions() {
        return instructions;
    }

    public void setInstructions(char[] instructions) {
        this.instructions = instructions;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public char[] getResult() {
        return result;
    }

    public void setResult(char[] result) {
        this.result = result;
    }

    public DdocInspection getDdocInspection() {
        return ddocInspection;
    }

    public void setDdocInspection(DdocInspection ddocInspection1) {
        this.ddocInspection = ddocInspection1;
    }

    public void setOffence(String offence) {
        this.offence = offence;
    }

    public String getOffence() {
        return offence;
    }

    public void setDdocInspectionId(Long ddocInspectionId) {
        this.ddocInspectionId = ddocInspectionId;
    }

    public Long getDdocInspectionId() {
        return ddocInspectionId;
    }

    public void setRiskProfileId(Long riskProfileId) {
        this.riskProfileId = riskProfileId;
    }

    public Long getRiskProfileId() {
        return riskProfileId;
    }
}
