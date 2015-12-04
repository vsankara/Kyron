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
@NamedQuery(name = "RskRiskProfileRegion.findAll", 
    query = "select o from RskRiskProfileRegion o")
@Table(name = "RSK_RISK_PROFILE_REGION")
public class RskRiskProfileRegion extends BaseNormalModelObject{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_PROFILE_REGION_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROFILE_REGION_SEQ", sequenceName = "RSK_RISK_PROFILE_REGION_SEQ", 
                       allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String region;
    
    @ManyToOne
    @JoinColumn(name = "RISK_PROFILE", referencedColumnName = "ID",nullable = false)
    private RskRiskProfile riskProfile;
    
    public RskRiskProfileRegion() {
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRiskProfile(RskRiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public RskRiskProfile getRiskProfile() {
        return riskProfile;
    }
}
