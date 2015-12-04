package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.math.BigDecimal;

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
@NamedQuery(name = "DdocQuery.findAll", query = "select o from DdocQuery o")
@Table(name = "DDOC_QUERY")
public class DdocQuery extends BaseNormalModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_query_seq")
    @SequenceGenerator(name = "ddoc_query_seq", sequenceName = "ddoc_query_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="QUERY_DATE")
    private Timestamp queryDate;
    @Column(name="QUERY_NOTES")
    private String queryNotes;
    private String subject;
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    
    public DdocQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Timestamp queryDate) {
        this.queryDate = queryDate;
    }

    public String getQueryNotes() {
        return queryNotes;
    }

    public void setQueryNotes(String queryNotes) {
        this.queryNotes = queryNotes;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void setDdocDocument(DdocDocument ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }
}
