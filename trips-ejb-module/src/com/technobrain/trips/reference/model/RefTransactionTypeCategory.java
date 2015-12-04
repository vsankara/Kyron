package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefTransactionTypeCategory.findAll", query = "select o from RefTransactionTypeCategory o")
@Table(name = "REF_TRANSACTION_TYPE_CATEGORY")
public class RefTransactionTypeCategory extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;
    
    @Column(name="DESCRIPTION")
    private String description;

    public RefTransactionTypeCategory() {
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
