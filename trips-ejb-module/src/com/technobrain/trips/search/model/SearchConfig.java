package com.technobrain.trips.search.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "SearchConfig.findAll", 
    query = "select o from SearchConfig o")
@Table(name = "SEARCH_CONFIG")
public class SearchConfig extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEARCH_CONFIG_SEQ")
    @SequenceGenerator(name = "SEARCH_CONFIG_SEQ", sequenceName = "SEARCH_CONFIG_SEQ", allocationSize = 1)    
    @Column(nullable = false)    
    private Long id;
    @Column(name="SEARCH_ID", nullable = false)
    private String searchId;
    private char[] configuration;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public SearchConfig() {
    }

    public char[] getConfiguration() {
        return configuration;
    }

    public void setConfiguration(char[] configuration) {
        this.configuration = configuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
}
