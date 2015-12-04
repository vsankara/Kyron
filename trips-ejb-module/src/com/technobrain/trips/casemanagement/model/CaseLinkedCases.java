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
 * Model class representing the table CASE_LINKED_CASES. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */
@Entity
@NamedQuery(name = "CaseLinkedCases.findAll", 
    query = "select o from CaseLinkedCases o")
@Table(name = "CASE_LINKED_CASES")
public class CaseLinkedCases extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_LINKED_CASES_SEQ")
    @SequenceGenerator(name = "CASE_LINKED_CASES_SEQ", 
                       sequenceName = "CASE_LINKED_CASES_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
        
    @ManyToOne
    @JoinColumn(name = "LINKED_CASE_ID", referencedColumnName = "ID")
    private CaseDetails linkedCaseDetails;
    
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;

    public CaseLinkedCases() {
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

    public void setLinkedCaseDetails(CaseDetails linkedCaseDetails) {
        this.linkedCaseDetails = linkedCaseDetails;
    }

    public CaseDetails getLinkedCaseDetails() {
        return linkedCaseDetails;
    }
}
