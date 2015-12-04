package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
        @NamedQuery(name = "TaxCompAutoSchedule.findAll", query = "select o from TaxCompAutoSchedule o"),
        @NamedQuery(name = "TaxCompAutoSchedule.findTaxCompAutoScheduleById", query = "select o from TaxCompAutoSchedule o where o.id=?1")
    }    
)
@Table(name = "TAX_COMP_AUTO_SCHEDULE")
public class TaxCompAutoSchedule extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMP_AUTO_SCHEDULE_SEQ")
    @SequenceGenerator(name = "TAX_COMP_AUTO_SCHEDULE_SEQ", sequenceName = "TAX_COMP_AUTO_SCHEDULE_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    @Column(name="COMPLIANCE_TYPE")
    private String complianceType;
    private String period;
    @Column(name="RETURN_TYPE")
    private String returnType;
    @Column(name="SCHEDULE_DATE")
    private Timestamp scheduleDate;
    @Column(name="TAXPAYER_TYPE")
    private String taxpayerType;
    @Column(name="TAX_TYPE")
    private String taxType;
   
   

    public TaxCompAutoSchedule() {
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Timestamp getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Timestamp scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

   

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

   
    
    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceType() {
        return complianceType;
    }
}
