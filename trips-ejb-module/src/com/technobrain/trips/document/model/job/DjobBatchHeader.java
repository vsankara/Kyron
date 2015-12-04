package com.technobrain.trips.document.model.job;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.model.DdocDocument;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DjobBatchHeader.findAll", 
    query = "select o from DjobBatchHeader o")
@Table(name = "DJOB_BATCH_HEADER")
public class DjobBatchHeader extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DJOB_BATCH_HEADER_seq")
    @SequenceGenerator(name = "DJOB_BATCH_HEADER_seq", sequenceName = "DJOB_BATCH_HEADER_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="DOC_TYPE")
    private String documentType;
    @Column(name="NO_OF_DOCUMENTS", nullable = false)
    private Long noOfDocuments;
    @OneToMany(cascade={CascadeType.ALL},mappedBy = "djobBatchHeader" )
    private List<DjobBatchDetail> djobBatchDetailList;
    @Column(name="JOB_TYPE")
    private String jobType;
    @Column(name="BATCH_DTIME")
    private Timestamp batchDTime;
    
    public DjobBatchHeader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoOfDocuments() {
        return noOfDocuments;
    }

    public void setNoOfDocuments(Long noOfDocuments) {
        this.noOfDocuments = noOfDocuments;
    }


    public List<DjobBatchDetail> getDjobBatchDetailList() {
        return djobBatchDetailList;
    }

    public void setDjobBatchDetailList(List<DjobBatchDetail> djobBatchDetailList) {
        this.djobBatchDetailList = djobBatchDetailList;
    }

    public DjobBatchDetail addDjobBatchDetail(DjobBatchDetail djobBatchDetail) {
        getDjobBatchDetailList().add(djobBatchDetail);
        djobBatchDetail.setDjobBatchHeader(this);
        return djobBatchDetail;
    }

    public DjobBatchDetail removeDjobBatchDetail(DjobBatchDetail djobBatchDetail) {
        getDjobBatchDetailList().remove(djobBatchDetail);
        djobBatchDetail.setDjobBatchHeader(null);
        return djobBatchDetail;
    }
    
    /**
     * Creates a batch details record
     * @param seqNo
     * @param document
     * @param template
     * @param jobID
     * @return
     */
    public DjobBatchDetail createBatchDetail(Long seqNo, DdocDocument document, String template, String controlNumber) {
       DjobBatchDetail djobBatchDetail = createBatchDocumentDetail(document);
        djobBatchDetail.setControlNumber(controlNumber);
        djobBatchDetail.setSequenceNumber(seqNo);
        djobBatchDetail.setTemplate(template);
        return djobBatchDetail;
    }
    
    /**
     * Creates a batch document details record
     * @param document
     * @return
     */
    private final DjobBatchDetail createBatchDocumentDetail(DdocDocument document) {
        if(djobBatchDetailList == null){
            djobBatchDetailList = new ArrayList<DjobBatchDetail>();
        }
        DjobBatchDetail djobBatchDetail = new DjobBatchDetail();
        djobBatchDetail.setDdocDocument(document);
//        document.markPrinted();
        this.addDjobBatchDetail(djobBatchDetail);
        return djobBatchDetail;
    }

    public void markCompleted(final String jobType) {
        this.setJobType(jobType);
        this.setStatus(Constants.Jobs.COMPLETED);
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setBatchDTime(Timestamp batchDTime) {
        this.batchDTime = batchDTime;
    }

    public Timestamp getBatchDTime() {
        return batchDTime;
    }
}
