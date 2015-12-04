package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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


@Entity
@NamedQuery(name = "DdocNotes.findAll", query = "select o from DdocNotes o")
@Table(name = "DDOC_NOTES")
public class DdocNotes extends BaseNormalModelObject   {
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_notes_seq")
    @SequenceGenerator(name = "ddoc_notes_seq", sequenceName = "ddoc_notes_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String notes;
    @Column(name="NOTE_DATE")
    private Timestamp noteDate;
    private String subject;
    
    public DdocNotes() {
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setDdocDocument(DdocDocument ddocDocument) {
        this.ddocDocument = ddocDocument;
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

    public Timestamp getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Timestamp noteDate) {
        this.noteDate = noteDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
