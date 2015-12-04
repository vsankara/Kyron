package com.technobrain.trips.entity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntOther.findAll", query = "select o from EntOther o")
@Table(name = "ENT_OTHER")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("OTHER")
public class EntOther extends EntEntity    {
    @Column(name="ENTITY_DETAILS")
    private String entityDetails;
//    @Column(name="ENTITY_NAME")
//    private String entityName;

    public EntOther() {
    }

    public String getEntityDetails() {
        return entityDetails;
    }

    public void setEntityDetails(String entityDetails) {
        this.entityDetails = entityDetails;
    }

//    public String getEntityName() {
//        return entityName;
//    }
//
//    public void setEntityName(String entityName) {
//        this.entityName = entityName;
//    }
}
