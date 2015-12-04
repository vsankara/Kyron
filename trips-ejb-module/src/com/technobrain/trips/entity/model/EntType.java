package com.technobrain.trips.entity.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntType.findAll", query = "select o from EntType o")
@Table(name = "ENT_TYPE")
public class EntType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    private String entity;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
     
     
     
     
     
    @OneToMany(mappedBy = "entType")
    private List<EntField> entFieldList;

    public EntType() {
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

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public List<EntField> getEntFieldList() {
        return entFieldList;
    }

    public void setEntFieldList(List<EntField> entFieldList) {
        this.entFieldList = entFieldList;
    }

    public EntField addEntField(EntField entField) {
        getEntFieldList().add(entField);
        entField.setEntType(this);
        return entField;
    }

    public EntField removeEntField(EntField entField) {
        getEntFieldList().remove(entField);
        entField.setEntType(null);
        return entField;
    }
}
