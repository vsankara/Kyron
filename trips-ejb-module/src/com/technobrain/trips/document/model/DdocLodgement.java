package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DdocLodgement.findAll", 
    query = "select o from DdocLodgement o")
@Table(name = "DDOC_LODGEMENT")
public class DdocLodgement extends BaseNormalModelObject   {
     
     
     
     
    @Column(name="DOC_TYPE")
    private String docType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_lodgement_seq")
    @SequenceGenerator(name = "ddoc_lodgement_seq", sequenceName = "ddoc_lodgement_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    private String reference;
     
     
     
     
     
     

    public DdocLodgement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }
}
