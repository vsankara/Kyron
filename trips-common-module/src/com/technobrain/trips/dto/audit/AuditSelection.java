package com.technobrain.trips.dto.audit;

import com.technobrain.trips.dto.DataTransferObject;


public class AuditSelection implements DataTransferObject{
    private String tin;
    private String name;
    private Long entity;
    private Long riskHits;
    private String businessSector;
    private Long calculation;
    private Long auditFrequency;
    private String riskBand;
    
    
    
    
    public AuditSelection(String tin, String name, Long entity) {
        this.tin = tin;
        this.name = name;
        this.entity = entity;
    }
    
    public AuditSelection(String tin, String name, Long entity, String businessSector) {
        this.tin = tin;
        this.name = name;
        this.entity = entity;
        this.businessSector = businessSector;        
    }  
    
    public AuditSelection(String tin, String name, String businessSector, String riskBand) {
        this.tin = tin;
        this.name = name;
        this.riskBand = riskBand;
        this.businessSector = businessSector;        
    } 

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEntity(Long entity) {
        this.entity = entity;
    }

    public Long getEntity() {
        return entity;
    }

    public void setRiskHits(Long riskHits) {
        this.riskHits = riskHits;
    }

    public Long getRiskHits() {
        return riskHits;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setCalculation(Long calculation) {
        this.calculation = calculation;
    }

    public Long getCalculation() {
        return calculation;
    }

    public void setRiskBand(String riskBand) {
        this.riskBand = riskBand;
    }

    public String getRiskBand() {
        return riskBand;
    }

    public void setAuditFrequency(Long auditFrequency) {
        this.auditFrequency = auditFrequency;
    }

    public Long getAuditFrequency() {
        return auditFrequency;
    }
}
