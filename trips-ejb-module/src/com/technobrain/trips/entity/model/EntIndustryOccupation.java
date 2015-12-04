package com.technobrain.trips.entity.model;

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
@NamedQuery(name = "EntIndustryOccupation.findAll", 
    query = "select o from EntIndustryOccupation o")
@Table(name = "ENT_INDUSTRY_OCCUPATION")
@SequenceGenerator(name = "ent_industry_occupation_seq", sequenceName = "ent_industry_occupation_seq", initialValue = 1, allocationSize = 1)
public class EntIndustryOccupation extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_industry_occupation_seq")
    @Column(nullable = false)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;
    @Column(name="PRIMARY_INDICATOR")
    private String primaryIndicator;
    private String type;

    public EntIndustryOccupation() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(EntEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
