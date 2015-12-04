package com.technobrain.trips.search.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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
@NamedQuery(name = "SavedSearchField.findAll", query = "select o from SavedSearchField o")
@Table(name = "SAVED_SEARCH_FIELD")
public class SavedSearchField extends BaseNormalModelObject {
    @Column(name="FIELD_NAME")
    private String fieldName;
    @Column(name="FIELD_VALUE")
    private String fieldValue;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAVED_SEARCH_FIELD_SEQ")
    @SequenceGenerator(name = "SAVED_SEARCH_FIELD_SEQ", sequenceName = "SAVED_SEARCH_FIELD_SEQ", allocationSize = 1)       
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "SEARCH_ID", referencedColumnName = "ID")
    private SavedSearch savedSearch;

    public SavedSearchField() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public SavedSearch getSavedSearch() {
        return savedSearch;
    }

    public void setSavedSearch(SavedSearch savedSearch) {
        this.savedSearch = savedSearch;
    }
}
