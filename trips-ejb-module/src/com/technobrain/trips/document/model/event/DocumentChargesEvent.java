package com.technobrain.trips.document.model.event;

import com.technobrain.trips.event.model.EvtDdocEvent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue(value="EVT_DOC_CHARG")
@Inheritance
public class DocumentChargesEvent extends EvtDdocEvent {
    public DocumentChargesEvent() {
    }
}
