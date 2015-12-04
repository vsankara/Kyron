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
@NamedQuery(name = "DdocDocumentError.findAll", 
    query = "select o from DdocDocumentError o")
@Table(name = "DDOC_DOCUMENT_ERROR")
public class DdocDocumentError extends BaseNormalModelObject   {
    private String code;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_document_error_seq")
    @SequenceGenerator(name = "ddoc_document_error_seq", sequenceName = "ddoc_document_error_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    @ManyToOne
    @JoinColumn(name = "DOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;

    public DdocDocumentError() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setDdocDocument(DdocDocument ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
