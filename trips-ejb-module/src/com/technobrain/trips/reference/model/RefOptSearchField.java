package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefOptSearchField.findAll", query = "select o from RefOptSearchField o")
@Table(name = "REF_OPT_SEARCH_FIELD")
public class RefOptSearchField extends BaseNormalModelObject {
    @Column(name="FIELD_NAME")
    private String fieldName;
    @Id    
    @Column(nullable = false)
    private Long id;
    @Column(name="SEARCH_NAME")
    private String searchName;
    @Column(name="FIELD_ORDER")
    private Integer fieldOrder;

    public RefOptSearchField() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }
}
