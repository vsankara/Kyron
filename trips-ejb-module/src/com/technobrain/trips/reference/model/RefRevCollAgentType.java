package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefRevCollAgentType.findAll", 
    query = "select o from RefRevCollAgentType o")
@Table(name = "REF_REV_COLL_AGENT_TYPE")
public class RefRevCollAgentType extends BaseRefModelObject{

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @OneToMany(mappedBy = "agentType")
    private List<RefRevCollectionAgent> refRevCollectionAgentList;

    public RefRevCollAgentType() {
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

    public void setRefRevCollectionAgentList(List<RefRevCollectionAgent> refRevCollectionAgentList) {
        this.refRevCollectionAgentList = refRevCollectionAgentList;
    }

    public List<RefRevCollectionAgent> getRefRevCollectionAgentList() {
        return refRevCollectionAgentList;
    }
    
    public RefRevCollectionAgent addRefRevCollectionAgent(RefRevCollectionAgent refRevCollectionAgent) {
        getRefRevCollectionAgentList().add(refRevCollectionAgent);
        refRevCollectionAgent.setAgentType(this);
        return refRevCollectionAgent;
    }

    public RefRevCollectionAgent removeRefRevCollectionAgent(RefRevCollectionAgent refRevCollectionAgent) {
        getRefRevCollectionAgentList().remove(refRevCollectionAgent);
        return refRevCollectionAgent;
    }
}
