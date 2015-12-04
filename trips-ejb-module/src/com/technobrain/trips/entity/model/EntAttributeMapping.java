package com.technobrain.trips.entity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntAttributeMapping.findAll", 
    query = "select o from EntAttributeMapping o")
@Table(name = "ENT_ATTRIBUTE_MAPPING")
@SequenceGenerator(name = "ent_attribute_mapping_seq", sequenceName = "ent_attribute_mapping_seq", initialValue = 1, allocationSize = 1)
public class EntAttributeMapping extends BaseNormalModelObject   {
    @Column(name="ATTRIBUTE_ID", nullable = false)
    private String attributeId;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_attribute_mapping_seq")    
    @Column(nullable = false)
    private Long id;

    public EntAttributeMapping() {
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public EntEntity getEntity() {
        return entity;
    }

    public void setEntity(EntEntity entity) {
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
