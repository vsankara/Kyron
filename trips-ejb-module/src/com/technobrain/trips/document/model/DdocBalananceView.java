package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQueries({
@NamedQuery(name = "DdocBalananceView.findAll", 
    query = "select o from DdocDocument o"),
@NamedQuery(name = "DdocBalananceView.findById", 
    query = "select o from DdocDocument o where o.id = ?1"),
    @NamedQuery(name = "DdocBalananceView.findDDocBalanceByAccoundIdAndAccountType", 
    query = "select ddoc from DdocBalananceView ddoc where ddoc.docType=?1 and ddoc.accountId=?2"),
@NamedQuery(name = "DdocBalananceView.findDocumentBalanceByPeriodAndDocType", 
    query = "select ddoc from DdocBalananceView ddoc where ddoc.docType=?1 and ddoc.period=?2"),
@NamedQuery(name = "DdocBalananceView.findDocumentBalanceByAccountAndDocType", 
    query = "select ddoc from DdocBalananceView ddoc where ddoc.docType=?1 and ddoc.accountId=?2"),
@NamedQuery(name = "DdocBalananceView.findByDocId", 
    query = "select o from DdocBalananceView o where o.documentId = ?1")   
})
@Entity
@Table(name = "DDOC_BALANCE")
public class DdocBalananceView implements Serializable {
    @Id
    @Column(name="DOCUMENT_ID")
    private Long documentId;
    @Column(name="TRANS_BALANCE")
    private BigDecimal transactionBalance;
    @Column(name="SUBMISSION_DATE")
    private Timestamp submissionDate;
    @Column(name="ACC_ACCOUNT")
    private Long accountId;
    @Column(name="DOC_STATUS")
    private String docStatus;
    @Column(name="DTYPE")
    private String docType;
    @Column(name="ACC_PERIOD")
    private Long period;
        
    public DdocBalananceView() {
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setTransactionBalance(BigDecimal transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public BigDecimal getTransactionBalance() {
        return transactionBalance;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getPeriod() {
        return period;
    }
}
