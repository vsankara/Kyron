package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
@NamedQueries( {@NamedQuery(name = "EntBusinessSector.findAll", 
            query = "select o from EntBusinessSector o"),
            @NamedQuery(name = "EntBusinessSector.findEntityBusinessSectorByEntId", 
                             query = "select o from EntBusinessSector o where  o.entEntity.id = ?1")})
@Table(name = "ENT_BUSINESS_SECTOR")
public class EntBusinessSector extends BaseNormalModelObject {
    @Column(name = "BUSINESS_SECTOR", nullable = false)
    private String businessSector;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ENT_BUSINESS_SECTOR_SEQ")
    @SequenceGenerator(name = "ENT_BUSINESS_SECTOR_SEQ", 
                       sequenceName = "ENT_BUSINESS_SECTOR_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="PRIMARY_INDICATOR")
    private String primaryIndicator;
    
    public EntBusinessSector() {
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public String getPrimaryIndicator() {
        return primaryIndicator;
    }
}
