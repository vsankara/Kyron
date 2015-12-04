package com.technobrain.trips.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * © Crown Agents 2012
 *
 * Entity for table EVT_ACCT_EVENT
 *
 * @since	$Date: 12/2/2012 2:17:40 PM$
 * 
 * 
 */
@Entity
@NamedQuery(name = "EvtAcctEvent.findAll", 
    query = "select o from EvtAcctEvent o")
@Table(name = "EVT_ACCT_EVENT")
public class EvtAcctEvent extends EvtEvent  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVT_ACCT_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_ACCT_EVENT_SEQ", sequenceName = "EVT_ACCT_EVENT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    
    

    public EvtAcctEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}