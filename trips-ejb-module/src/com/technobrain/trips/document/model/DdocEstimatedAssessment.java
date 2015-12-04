package com.technobrain.trips.document.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "DdocEstimatedAssessment.findAll", 
    query = "select o from DdocEstimatedAssessment o")
@Table(name = "DDOC_EST_ASSESSMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("COMP_EST_ASSESS")
public class DdocEstimatedAssessment extends DdocDocument {


    private Long entity;

    @Column(name="EST_LIABILITY")
    private Long estLiability;
    
    private Long period;
    
    @Column(name="PERIOD_NO")
    private Long periodNo;
    
    @Column(name="DOCUMENT_TYPE")
    private String documentType;
    
    private String tin;

    public void setEntity(Long entity) {
        this.entity = entity;
    }

    public Long getEntity() {
        return entity;
    }

    public void setEstLiability(Long estLiability) {
        this.estLiability = estLiability;
    }

    public Long getEstLiability() {
        return estLiability;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriodNo(Long periodNo) {
        this.periodNo = periodNo;
    }

    public Long getPeriodNo() {
        return periodNo;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }
}
