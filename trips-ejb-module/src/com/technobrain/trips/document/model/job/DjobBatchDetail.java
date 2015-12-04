package com.technobrain.trips.document.model.job;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocDocument;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "DjobBatchDetail.findAll", 
    query = "select o from DjobBatchDetail o")
@Table(name = "DJOB_BATCH_DETAIL")
public class DjobBatchDetail extends BaseNormalModelObject {
  
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "DOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DJOB_BATCH_DETAIL_seq")
    @SequenceGenerator(name = "DJOB_BATCH_DETAIL_seq", sequenceName = "DJOB_BATCH_DETAIL_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @ManyToOne (cascade={CascadeType.ALL})
    @JoinColumn(name = "JOB_HEADER", referencedColumnName = "ID")
    private DjobBatchHeader djobBatchHeader;
    
    @Column(name="TEMPLATE")
    private String template;
    @Column(name="JOB_ID")
    private String jobID;
    @Column(name="MANUAL_JOB_ID")
    private String manualJobID;
    @Column(name="SEQUENCE_NUMBER", nullable = false)
    private Long sequenceNumber;
    @Column(name="CONTROL_NUMBER", nullable = false)
    private String controlNumber;
    public DjobBatchDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public DjobBatchHeader getDjobBatchHeader() {
        return djobBatchHeader;
    }

    public void setDjobBatchHeader(DjobBatchHeader djobBatchHeader) {
        this.djobBatchHeader = djobBatchHeader;
    }

    public void setDdocDocument(DdocDocument ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getJobID() {
        return jobID;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setManualJobID(String manualJobID) {
        this.manualJobID = manualJobID;
    }

    public String getManualJobID() {
        return manualJobID;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getControlNumber() {
        return controlNumber;
    }
}
