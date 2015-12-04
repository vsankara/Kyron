package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntSoleProprietorInfo.findAll", 
    query = "select o from EntSoleProprietorInfo o")
@SequenceGenerator(name = "ent_sole_prop_add_info_seq", sequenceName = "ent_sole_prop_add_info_seq", initialValue = 1, allocationSize = 1)
@Table(name = "ENT_SOLE_PROP_ADD_INFO")
public class EntSoleProprietorInfo extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_sole_prop_add_info_seq")
    @Column(nullable = false)
    private Long id;
    
    @Column(name="CREDIT_FINANCING_IND")
    private String creditFinancingInd;
    @Column(name="EXISTING_BUS_CAP")
    private Long existingBusCap;
    @Column(name="INITIAL_CAPITAL_INVESTED")
    private Long initialCapitalInvested;
    @Column(name="INTENTION_TO_EMPLOY_OTHERS")
    private String intentionToEmployOthers;
    @Column(name="LEGACY_IND")
    private String legacyInd;
    @Column(name="LOANS_IND")
    private String loansInd;
    @Column(name="PAST_PERSONAL_SAVING_IND")
    private String pastPersonalSavingInd;
    @Column(name="RGD_REG_DATE")
    private Timestamp rgdRegDate;
    @Column(name="SUCC_OF_EXISTING_BUS")
    private String succOfExistingBus;
    
    @OneToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;

    public EntSoleProprietorInfo() {
    }

    public String getCreditFinancingInd() {
        return creditFinancingInd;
    }

    public void setCreditFinancingInd(String creditFinancingInd) {
        this.creditFinancingInd = creditFinancingInd;
    }

    public Long getExistingBusCap() {
        return existingBusCap;
    }

    public void setExistingBusCap(Long existingBusCap) {
        this.existingBusCap = existingBusCap;
    }

    public Long getInitialCapitalInvested() {
        return initialCapitalInvested;
    }

    public void setInitialCapitalInvested(Long initialCapitalInvested) {
        this.initialCapitalInvested = initialCapitalInvested;
    }

    public String getIntentionToEmployOthers() {
        return intentionToEmployOthers;
    }

    public void setIntentionToEmployOthers(String intentionToEmployOthers) {
        this.intentionToEmployOthers = intentionToEmployOthers;
    }

    public String getLegacyInd() {
        return legacyInd;
    }

    public void setLegacyInd(String legacyInd) {
        this.legacyInd = legacyInd;
    }

    public String getLoansInd() {
        return loansInd;
    }

    public void setLoansInd(String loansInd) {
        this.loansInd = loansInd;
    }

    public String getPastPersonalSavingInd() {
        return pastPersonalSavingInd;
    }

    public void setPastPersonalSavingInd(String pastPersonalSavingInd) {
        this.pastPersonalSavingInd = pastPersonalSavingInd;
    }

    public Timestamp getRgdRegDate() {
        return rgdRegDate;
    }

    public void setRgdRegDate(Timestamp rgdRegDate) {
        this.rgdRegDate = rgdRegDate;
    }

    public String getSuccOfExistingBus() {
        return succOfExistingBus;
    }

    public void setSuccOfExistingBus(String succOfExistingBus) {
        this.succOfExistingBus = succOfExistingBus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
