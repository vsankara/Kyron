package com.technobrain.trips.event.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EvtCaseEvent.findAll", 
    query = "select o from EvtCaseEvent o")
@Table(name = "EVT_CASE_EVENT")
@DiscriminatorValue(value="EVT_CASE_EVENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CATEGORY_TYPE", discriminatorType=DiscriminatorType.STRING, length=50)
public  class EvtCaseEvent extends EvtEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVT_CASE_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_CASE_EVENT_SEQ", sequenceName = "EVT_CASE_EVENT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    

    public EvtCaseEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
