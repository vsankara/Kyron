package com.technobrain.trips.document.model;

import com.technobrain.trips.entity.model.EntEntity;

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
@NamedQuery(name = "DdocEntityDocRel.findAll", 
    query = "select o from DdocEntityDocRel o")
@Table(name = "DDOC_ENTITY_DOC_REL")
public class DdocEntityDocRel extends BaseNormalModelObject   {
     
     
     
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_entity_doc_rel_seq")
    @SequenceGenerator(name = "ddoc_entity_doc_rel_seq", sequenceName = "ddoc_entity_doc_rel_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
     
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "DOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    @ManyToOne
    @JoinColumn(name = "ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;
    public DdocEntityDocRel() {
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

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
