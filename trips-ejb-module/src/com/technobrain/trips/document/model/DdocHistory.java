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
@NamedQuery(name = "DdocHistory.findAll", 
    query = "select o from DdocHistory o")
@Table(name = "DDOC_HISTORY")
public class DdocHistory extends BaseNormalModelObject   {
    @Column(name="ADDITIONAL_INFO")
    private char[] additionalInfo;
     
     
     
     
    @Column(name="DOCUMENT_STATUS", nullable = false)
    private String documentStatus;
    @Column(name="EVENT_CODE", nullable = false)
    private String eventCode;
    @Column(name="EVENT_DATE")
    private Timestamp eventDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_history_seq")
    @SequenceGenerator(name = "ddoc_history_seq", sequenceName = "ddoc_history_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    @Column(name="STATUS_CODE", nullable = false)
    private String statusCode;
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    @ManyToOne
    @JoinColumn(name = "SOURCE_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument sourceDocument;

    public DdocHistory() {
    }

    public char[] getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(char[] additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setDdocDocument(DdocDocument ddocDocument1) {
        this.ddocDocument = ddocDocument1;
    }

    public DdocDocument getSourceDocument() {
        return sourceDocument;
    }

    public void setSourceDocument(DdocDocument ddocDocument) {
        this.sourceDocument = ddocDocument;
    }
}
