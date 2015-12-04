package com.technobrain.trips.document.model;

import com.technobrain.trips.entity.model.EntEntity;

import java.io.Serializable;


import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DfinBadChequeRegister.findAll", 
    query = "select o from DfinBadChequeRegister o")
@Table(name = "DFIN_BAD_CHEQUE_REGISTER")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("DFINBADCHEQUE")
public class DfinBadChequeRegister extends DdocDocument    {
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;

    public DfinBadChequeRegister() {
    }

    
    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }
   
}
