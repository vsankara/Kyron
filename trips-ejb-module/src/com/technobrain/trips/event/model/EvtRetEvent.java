package com.technobrain.trips.event.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EvtRetEvent.findAll", 
    query = "select o from EvtRetEvent o")
@Table(name = "EVT_RET_EVENT")
public class EvtRetEvent extends EvtEvent  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVT_RET_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_RET_EVENT_SEQ", sequenceName = "EVT_RET_EVENT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    
    

    public EvtRetEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
