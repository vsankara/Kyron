package com.technobrain.trips.riskmanagement.model;

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
@NamedQuery(name = "RskRiskProfileBusSect.findAll", 
    query = "select o from RskRiskProfileBusSect o")
@Table(name = "RSK_RISK_PROFILE_BUS_SECT")
public class RskRiskProfileBusSect extends BaseNormalModelObject{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_PROFILE_BUS_SECT_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROFILE_BUS_SECT_SEQ", sequenceName = "RSK_RISK_PROFILE_BUS_SECT_SEQ", 
                       allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(name="BUSINESS_SECTOR", nullable = false)
    private String businessSector;
    
    @ManyToOne
    @JoinColumn(name = "RISK_PROFILE", referencedColumnName = "ID",nullable = false)
    private RskRiskProfile riskProfile;

    public RskRiskProfileBusSect() {
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRiskProfile(RskRiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public RskRiskProfile getRiskProfile() {
        return riskProfile;
    }
}
