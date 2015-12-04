package com.technobrain.trips.document.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * TechnoBrain 2015
 *
 * A payment spread directed at a document.
 *
 * @since	$Date: 2011-06-17 15:54:56 +0100 (Fri, 17 Jun 2011) $
 * @version	$Rev: 21079 $
 * @author	$Author: m_rao $
 * 
 */
@Entity
@DiscriminatorValue(value="DFIN_PAYMENT_SPREAD_DOCUMENT")
@Inheritance
@NamedQuery(name = "DfinDocumentPaymentSpread.findPaymentByDocument", 
    query = "select o from DfinDocumentPaymentSpread o where o.documentId=?1")
public class DfinDocumentPaymentSpread extends DfinPaymentSpread {
    @Column(name="DOCUMENT_ID")
    private Long documentId;

    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private DdocDocument document;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public void setDocument(DdocDocument document) {
        this.document = document;
    }

    public DdocDocument getDocument() {
        return document;
    }
}
