package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
import javax.persistence.Version;


@Entity
@NamedQuery(name = "DdocAmendedDocument.findAll", query = "select o from DdocAmendedDocument o")
@Table(name = "DDOC_AMENDED_DOCUMENT")
public class DdocAmendedDocument extends BaseNormalModelObject  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DDOC_AMENDED_DOCUMENT_SEQ")
    @SequenceGenerator(name = "DDOC_AMENDED_DOCUMENT_SEQ", sequenceName = "DDOC_AMENDED_DOCUMENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID", nullable=false)
    private DdocDocument document;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "AMENDED_DOCUMENT", referencedColumnName = "ID", nullable=false)
    private DdocDocument amendedDocument;
    
    public void setId(Long id) {
      this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDocument(DdocDocument document) {
      this.document = document;
    }

    public DdocDocument getDocument() {
        return document;
    }
    
    public void setAmendedDocument(DdocDocument amendedDocument) {
      this.amendedDocument = amendedDocument;
    }

    public DdocDocument getAmendedDocument() {
        return amendedDocument;
    }
    
}
