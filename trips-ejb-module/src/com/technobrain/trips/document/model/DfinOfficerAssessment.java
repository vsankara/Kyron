package com.technobrain.trips.document.model;


import com.technobrain.trips.auditandvisit.model.OfficerAssessment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@NamedQuery(name = "DfinOfficerAssessment.findAll", 
            query = "select o from DfinOfficerAssessment o")
@Table(name = "DFIN_OFFICER_ASSESSMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("OfficerAssessment")
public class DfinOfficerAssessment extends DfinDocument {

    @OneToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "OFF_ASS_ID", referencedColumnName = "ID")
    private OfficerAssessment officerAssessment;
    @Transient
    private List<DdocCharges> ddocCharges;

    public DfinOfficerAssessment() {
    }

    public void setOfficerAssessment(OfficerAssessment officerAssessment) {
        this.officerAssessment = officerAssessment;
    }

    public OfficerAssessment getOfficerAssessment() {
        return officerAssessment;
    }

    public void setDdocCharges(List<DdocCharges> ddocCharges) {
        this.ddocCharges = ddocCharges;
    }

    public List<DdocCharges> getDdocCharges() {
        return ddocCharges;
    }
}
