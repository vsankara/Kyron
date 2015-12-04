package com.technobrain.trips.entity.model;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntTradingAs.findAll", 
    query = "select o from EntTradingAs o")
@Table(name = "ENT_TRADING_AS")
public class EntTradingAs extends BaseNormalModelObject  {
   
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID", nullable = false)
    private EntEntity entEntity;
    
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ENT_TRADING_AS_SEQ")
    @SequenceGenerator(name = "ENT_TRADING_AS_SEQ", 
                       sequenceName = "ENT_TRADING_AS_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = true)
    private String name;
    @Column(name="PRIMARY_INDICATOR")
    private String primaryIndicator;
   

    public EntTradingAs() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }


    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
