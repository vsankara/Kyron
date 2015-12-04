package com.technobrain.trips.security.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQuery(name = "CasDBGroup.findAll", query = "select o from CasDBGroup o")
@Table(name = "CAS_GROUP")
public class CasDBGroup extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
 
    public CasDBGroup() {
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

}
