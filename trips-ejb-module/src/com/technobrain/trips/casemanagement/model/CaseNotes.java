package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

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
 * Model class representing the table CASE_NOTES. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */
@Entity
@NamedQuery(name = "CaseNotes.findAll", 
    query = "select o from CaseNotes o")
@Table(name = "CASE_NOTES")
public class CaseNotes extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_NOTES_SEQ")
    @SequenceGenerator(name = "CASE_NOTES_SEQ", 
                       sequenceName = "CASE_NOTES_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String notes;
    @Column(name="NOTES_CREATED_BY")
    private String notesCreatedBy;
    @Column(name="NOTES_CREATED_DATE")
    private Timestamp notesCreatedDate;
    private String title;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;

    public CaseNotes() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotesCreatedBy() {
        return notesCreatedBy;
    }

    public void setNotesCreatedBy(String notesCreatedBy) {
        this.notesCreatedBy = notesCreatedBy;
    }

    public Timestamp getNotesCreatedDate() {
        return notesCreatedDate;
    }

    public void setNotesCreatedDate(Timestamp notesCreatedDate) {
        this.notesCreatedDate = notesCreatedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CaseDetails getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }
}
