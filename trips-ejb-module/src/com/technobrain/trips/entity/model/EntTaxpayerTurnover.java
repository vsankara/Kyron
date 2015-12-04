package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntEntity;

import java.io.Serializable;

import java.sql.Timestamp;

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
@SequenceGenerator(name = "ENT_TAXPAYER_TURNOVER_SEQ", sequenceName = "ENT_TAXPAYER_TURNOVER_SEQ", initialValue = 1, allocationSize = 1)
@Entity
   
@NamedQueries ({
    @NamedQuery(name = "EntTaxpayerTurnover.findAll", 
        query = "select o from EntTaxpayerTurnover o"),
    @NamedQuery(name = "EntTaxpayerTurnover.findEntTaxpayerTurnoverByEntID", 
        query = "select o from EntTaxpayerTurnover o where o.entEntity.id = ?1 and o.turnoverType='TOT_TO' "),
    @NamedQuery(name = "EntTaxpayerTurnover.findEntTaxpayerTurnoverByEntIDandTaxType", 
        query = "select o from EntTaxpayerTurnover o where o.entEntity.id = ?1 and o.taxType=?2 and o.turnoverType='TAX_TO' ")    
})    
    
    
@Table(name = "ENT_TAXPAYER_TURNOVER")
public class EntTaxpayerTurnover extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_TAXPAYER_TURNOVER_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(name="TAXTYPE")
    private String taxType;
    private Long turnover;
    @Column(name="TURNOVER_TYPE")
    private String turnoverType;
    @Column(name="END_DATE")
    private Timestamp endDate;
    @Column(name="START_DATE")
     private Timestamp startDate;



    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;

    public EntTaxpayerTurnover() {
    }
    public Timestamp getEndDate() {
        return endDate;
    }
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getTurnover() {
        return turnover;
    }
    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }
    public String getTurnoverType() {
        return turnoverType;
    }
    public void setTurnoverType(String turnoverType) {
        this.turnoverType = turnoverType;
    }
    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }
}
