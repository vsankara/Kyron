package com.technobrain.trips.entity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_ENTITY_RISK_PROFILE
 *
 * @since	$Date: 12/10/2008 8:44:31 AM$
 * @version 	$Revision: 7$
 * @author 	$Author: Kemal Ediz$
 * 
 * */
@Entity
@NamedQuery(name = "EntEntityRiskProfile.findAll", 
    query = "select o from EntEntityRiskProfile o")
@NamedQueries(
    @NamedQuery(name = "EntEntityRiskProfile.queryFindByEntityId", 
    query = "select o from EntEntityRiskProfile o where o.id=?1")
)  
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("ENTENTITYRISKPROF")
@Table(name = "ENT_ENTITY_RISK_PROFILE")
public class EntEntityRiskProfile extends EntEntity   {
    @Column(name="RISK_SCORE")
    private Long riskScore;

    public EntEntityRiskProfile() {
    }

    public Long getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Long riskScore) {
        this.riskScore = riskScore;
    }
}
