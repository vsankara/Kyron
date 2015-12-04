package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.dto.DataTransferObject;


import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GenericRegimeDocumentSummaryBean implements DataTransferObject {
    private Long documentId;
    private Calendar submissionDate;
    private String documentType;
    private String documentNumber;
    private BigDecimal totalBalance;
    private List<GenericRegimeDocumentTransactionSummaryBean> genericRegimeDocumentTransactions;
    
    public GenericRegimeDocumentSummaryBean() {
    }
    public GenericRegimeDocumentSummaryBean(Long documentId,Timestamp submissionDate,String documentType,
                                    String documentNumber) {
        this.documentId = documentId;
        this.submissionDate = toDate(submissionDate);
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }
    
    public GenericRegimeDocumentSummaryBean(Long documentId,Timestamp submissionDate,String documentType,
                                    String documentNumber,BigDecimal totalBalance) {
        this.documentId = documentId;
        this.submissionDate = toDate(submissionDate);
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.totalBalance = totalBalance;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setSubmissionDate(Calendar submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Calendar getSubmissionDate() {
        return submissionDate;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setGenericRegimeDocumentTransactions(List<GenericRegimeDocumentTransactionSummaryBean> genericRegimeDocumentTransactions) {
        this.genericRegimeDocumentTransactions = genericRegimeDocumentTransactions;
    }

    public List<GenericRegimeDocumentTransactionSummaryBean> getGenericRegimeDocumentTransactions() {
        return genericRegimeDocumentTransactions;
    }
    
    private void addGenericRegimeDocumentTransactionSummaryBean(GenericRegimeDocumentTransactionSummaryBean genericRegimeDocumentTransaction ){
        if(this.genericRegimeDocumentTransactions ==null){
            genericRegimeDocumentTransactions = new ArrayList<GenericRegimeDocumentTransactionSummaryBean>();
        }
        this.genericRegimeDocumentTransactions.add(genericRegimeDocumentTransaction);
    }
    private Calendar toDate(Timestamp _timestamp) {
            if(_timestamp == null)
                return null;
            Calendar c = Calendar.getInstance();
            c.setTime(new Date(_timestamp.getTime()));
            return c;
        }

}
