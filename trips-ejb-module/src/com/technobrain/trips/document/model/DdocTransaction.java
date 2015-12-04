package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( {
    @NamedQuery(name = "DdocTransaction.findAll", 
        query = "select o from DdocTransaction o"),
    @NamedQuery(name = "DdocTransaction.findByDocumentId", 
        query = "select o from DdocTransaction o where o.documentId=?1"),
        @NamedQuery(name = "DdocTransaction.findByDocumentIdChargeId", 
        query = "select o from DdocTransaction o where o.documentId=?1 and o.chargeId=?2"),    
    @NamedQuery(name = "DdocTransaction.findByTransactionId", 
        query = "select o from DdocTransaction o where o.transactionId=?1")
}
)
@Table(name = "DDOC_TRANSACTION")

public class DdocTransaction extends BaseNormalModelObject {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DDOC_TRANSACTION_SEQ")
    @SequenceGenerator(name = "DDOC_TRANSACTION_SEQ", sequenceName = "DDOC_TRANSACTION_SEQ", allocationSize = 1)        
    private Long id;
    
    @Column(name="DOCUMENT_ID", nullable = false)
    private Long documentId;
    @Column(name="EVENT_ID", nullable = false)
    private Long eventId;

    @Column(name="TRANSACTION_ID", nullable = false)
    private Long transactionId;

    @Column(name = "CHARGE_ID", nullable = false)
    private Long chargeId;

    public DdocTransaction() {
    }


    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
