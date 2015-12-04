package com.technobrain.trips.gui.model;

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

@Entity
@NamedQuery(name = "CasGroup.findAll", query = "select o from CasGroup o")
@Table(name = "CAS_GROUP_VIEW")
public class CasGroup extends BaseModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
     
     

    public CasGroup() {
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

    @Override
    public final boolean equals(Object other) {
        if(other instanceof CasGroup){
            final CasGroup refModel = (CasGroup)other;
    
            if (getCode() != null && refModel.getCode() != null) {
                return getCode().equals(refModel.getCode());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(this.getCode() != null) {
            return this.getCode().hashCode();
        } 
        else   
            return super.hashCode();
    }
}
