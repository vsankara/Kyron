package com.technobrain.trips.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries ({ 
@NamedQuery(name = "EvtExemptionEvent.findAll", 
            query = "select o from EvtExemptionEvent o"),
@NamedQuery(name = "EvtExemptionEvent.findEventByDdocId", 
            query = "select o from EvtExemptionEvent o where o.id = (select max(ev.id) from EvtExemptionEvent ev where ev.relatedModuleId = ?1)")
})
@Table(name = "EVT_EXEMPTION_EVENT")
public class EvtExemptionEvent extends EvtEvent {
    public EvtExemptionEvent() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "EVT_EXEMPTION_EVENT_SEQ")
    @SequenceGenerator(name = "EVT_EXEMPTION_EVENT_SEQ", 
                       sequenceName = "EVT_EXEMPTION_EVENT_SEQ", 
                       initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
