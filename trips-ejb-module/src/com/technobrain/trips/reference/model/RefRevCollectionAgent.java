package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefRevCollectionAgent.findAll", 
    query = "select o from RefRevCollectionAgent o")
@Table(name = "REF_REV_COLLECTION_AGENT")
public class RefRevCollectionAgent extends BaseRefModelObject {
    
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="AGENT_NAME")
    private String agentName;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "AGENT_TYPE", referencedColumnName = "CODE")
    private RefRevCollAgentType agentType;
    @ManyToOne
    @JoinColumn(name = "OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;

    public RefRevCollectionAgent() {
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public RefRevCollAgentType getAgentType() {
        return agentType;
    }

    public void setAgentType(RefRevCollAgentType agentType) {
        this.agentType = agentType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }
}
