package com.technobrain.trips.entity.model;

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


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_NOTES
 *
 * @since	$Date: 7/14/2009 8:28:35 AM$
 * @version 	$Revision: 18$
 * @author 	$Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  18   TRIPS2    1.17        7/14/2009 8:28:35 AM   Vythilingam Pirabaharan
 *       Added officer to notes input type.
 * $
 */
@Entity
@NamedQuery(name = "EntNotes.findAll", query = "select o from EntNotes o")
@Table(name = "ENT_NOTES")
@SequenceGenerator(name = "ent_notes_seq", sequenceName = "ent_notes_seq", initialValue = 1, allocationSize = 1)
public class EntNotes extends BaseNormalModelObject   {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_notes_seq")
    @Column(nullable = false)
    private Long id;
    private String notes;
    @Column(name="NOTE_DATE")
    private Timestamp noteDate;
    private String subject;
    @Column(name="TRIPS_ENTITY")
    private String tripsEntity;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    private String officer;
    @Column(name="OTHER_SUBJECT")
    private String otherSubject;

    public EntNotes() {
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

    public String getTripsEntity() {
        return tripsEntity;
    }

    public void setTripsEntity(String tripsEntity) {
        this.tripsEntity = tripsEntity;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(EntEntity entEntity1) {
        this.parentEntity = entEntity1;
    }

    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOtherSubject(String otherSubject) {
        this.otherSubject = otherSubject;
    }

    public String getOtherSubject() {
        return otherSubject;
    }
}
