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
@NamedQuery(name = "RskRiskProfileOffice.findAll", 
    query = "select o from RskRiskProfileOffice o")
@Table(name = "RSK_RISK_PROFILE_OFFICE")
public class RskRiskProfileOffice extends BaseNormalModelObject{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "RSK_RISK_PROFILE_OFFICE_SEQ")
    @SequenceGenerator(name = "RSK_RISK_PROFILE_OFFICE_SEQ", sequenceName = "RSK_RISK_PROFILE_OFFICE_SEQ", 
                       allocationSize = 1)  
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String office;
    
    @ManyToOne
    @JoinColumn(name = "RISK_PROFILE", referencedColumnName = "ID",nullable = false)
    private RskRiskProfile riskProfile;
   
    public RskRiskProfileOffice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setRiskProfile(RskRiskProfile riskProfile) {
        this.riskProfile = riskProfile;
    }

    public RskRiskProfile getRiskProfile() {
        return riskProfile;
    }
}
