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
@NamedQuery(name = "EvtEnforceEvent.findAll", 
    query = "select o from EvtEnforceEvent o")
@Table(name = "EVT_ENFORCE_EVENT")
public class EvtEnforceEvent extends EvtEvent  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVT_ENFORCE_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_ENFORCE_EVENT_SEQ", sequenceName = "EVT_ENFORCE_EVENT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    
    

    public EvtEnforceEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
