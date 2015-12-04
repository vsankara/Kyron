package com.technobrain.trips.document.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DfinDocument.findAll", 
    query = "select o from DfinDocument o")
@Table(name = "DFIN_DOCUMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class DfinDocument extends DdocDocument {
    
    @Column(name="REASON_CODE", nullable = false)
    private String reasonCode;
    
    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

}
