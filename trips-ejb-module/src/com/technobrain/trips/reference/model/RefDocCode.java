package com.technobrain.trips.reference.model;


import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefDocCode.findAll", query = "select o from RefDocCode o")
@Table(name = "REF_DOC_TYPE_RET_TYPE_REL")
public class RefDocCode  extends BaseRefModelObject   {

    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    
    
    
    public RefDocCode() {
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
