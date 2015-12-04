package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DdocDocumentLink.findAll", 
    query = "select o from DdocDocumentLink o")
@Table(name = "DDOC_DOCUMENT_LINK")
public class DdocDocumentLink extends BaseNormalModelObject   {
     
     
     
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_document_link_seq")
    @SequenceGenerator(name = "ddoc_document_link_seq", sequenceName = "ddoc_document_link_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    @Column(name="RELATIONSHIP_TYPE")
    private Long relationshipType;
     
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "TARGET", referencedColumnName = "ID")
    private DdocDocument targetDocument;
    @ManyToOne
    @JoinColumn(name = "SOURCE", referencedColumnName = "ID")
    private DdocDocument sourceDocument;

    public DdocDocumentLink() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(Long relationshipType) {
        this.relationshipType = relationshipType;
    }

    public DdocDocument getTargetDocument() {
        return targetDocument;
    }

    public void setTargetDocument(DdocDocument ddocDocument) {
        this.targetDocument = ddocDocument;
    }

    public DdocDocument getSourceDocument() {
        return sourceDocument;
    }

    public void setSourceDocument(DdocDocument ddocDocument1) {
        this.sourceDocument = ddocDocument1;
    }
}
