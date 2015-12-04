package com.technobrain.trips.registration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RegSimplified.findAll", 
    query = "select o from RegSimplified o")
@Table(name = "REG_SIMPLIFIED")
@DiscriminatorValue(value="SIMPLIFIED")
public class RegSimplified extends RegTaxpayerEntity {

    @Column(name="DOCUMENT_ID", nullable = false)
    private Long documentId;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
}