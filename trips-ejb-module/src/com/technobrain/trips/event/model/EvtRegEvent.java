package com.technobrain.trips.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EvtRegEvent.findAll", 
    query = "select o from EvtRegEvent o")
@Table(name = "EVT_REG_EVENT")
public class EvtRegEvent extends EvtEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVT_REG_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_REG_EVENT_SEQ", sequenceName = "EVT_REG_EVENT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
   
    

    public EvtRegEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   
}
