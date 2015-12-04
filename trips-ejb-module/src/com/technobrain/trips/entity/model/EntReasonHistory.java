package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "EntReasonHistory.findAll", 
    query = "select o from EntReasonHistory o")
@Table(name = "ENT_REASON_HISTORY")
public class EntReasonHistory extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_REASON_HISTORY_SEQ")
    @SequenceGenerator(name = "ENT_REASON_HISTORY_SEQ", sequenceName = "ENT_REASON_HISTORY_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    private String notes;
    
    @Column(name="REASON_CODE")
    private String reasonCode;
    
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;
    
    public EntReasonHistory() {
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

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
