package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
/**
 * Model class representing the table CASE_RELATED_DOCUMENTS. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */

@Entity
@NamedQuery(name = "CaseRelatedDocuments.findAll", 
    query = "select o from CaseRelatedDocuments o")
@Table(name = "CASE_RELATED_DOCUMENTS")
public class CaseRelatedDocuments extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_RELATED_DOCUMENTS_SEQ")
    @SequenceGenerator(name = "CASE_RELATED_DOCUMENTS_SEQ", 
                       sequenceName = "CASE_RELATED_DOCUMENTS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="DOCUMENT_ID")
    private Long documentId;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;

    public CaseRelatedDocuments() {
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }
}
