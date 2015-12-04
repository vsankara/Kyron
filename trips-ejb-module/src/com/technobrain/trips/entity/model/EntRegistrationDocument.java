package com.technobrain.trips.entity.model;

import com.technobrain.trips.document.model.DdocDocument;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @ Crown Agents 2009
 *
 *
 * @since	$Date: 8/26/2009 3:21:00 AM$
 * @version 	$Revision: 1$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]
 */
 
@Entity
@NamedQuery(name = "EntRegistrationDocument.findAll", 
            query = "select o from EntRegistrationDocument o")
@Table(name = "ENT_REG_DOCUMENT")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("REG")
@Inheritance(strategy = InheritanceType.JOINED)
public class EntRegistrationDocument extends DdocDocument {

    @OneToOne
    @JoinColumn(name = "ENT_ENTITY", table="ENT_REG_DOCUMENT",referencedColumnName = "ID")    
    private EntEntity entity;
    
    public EntRegistrationDocument() {
    }

    public void setEntity(EntEntity entity) {
        this.entity = entity;
    }

    public EntEntity getEntity() {
        return entity;
    }
}
