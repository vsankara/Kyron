package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Model class representing the table CASE_CORRESPONDENCE. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */
@Entity
@NamedQuery(name = "CaseCorrespondence.findAll", 
    query = "select o from CaseCorrespondence o")
@Table(name = "CASE_CORRESPONDENCE")
public class CaseCorrespondence extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_CORRESPONDENCE_SEQ")
    @SequenceGenerator(name = "CASE_CORRESPONDENCE_SEQ", 
                       sequenceName = "CASE_CORRESPONDENCE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="CONTACT_DATETIME")
    private Timestamp contactDatetime;
    @Column(name="CONTACT_METHOD")
    private String contactMethod;
    @Column(name="CONTACT_NOTES")
    private String contactNotes;
    @Column(name = "CASE_CONTACT_PERSON_ID")
    private Long caseContactPersonId;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;

    public CaseCorrespondence() {
    }


    public Timestamp getContactDatetime() {
        return contactDatetime;
    }

    public void setContactDatetime(Timestamp contactDatetime) {
        this.contactDatetime = contactDatetime;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getContactNotes() {
        return contactNotes;
    }

    public void setContactNotes(String contactNotes) {
        this.contactNotes = contactNotes;
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


    public void setCaseContactPersonId(Long caseContactPersonId) {
        this.caseContactPersonId = caseContactPersonId;
    }

    public Long getCaseContactPersonId() {
        return caseContactPersonId;
    }
}
