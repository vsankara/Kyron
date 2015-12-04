package com.technobrain.trips.account.model;

import java.io.Serializable;



import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( 
    {


@NamedQuery(name = "TransactionDocRefView.findTransactionsByDocRef", 
        query = "select o from TransactionDocRefView o where o.tin=?1 and o.documentReference=?2")
    }
)    
@Table(name = "TRANSACTIONS_DOCREF_VIEW")
public class TransactionDocRefView implements Serializable {
    @Id
    @Column(name="DOCUMENTID", nullable = false)
    private String documentId;
    
	@Column(name="TIN")
    private String tin;
	
	@Column(name="DOCUMENTREFERENCE")
    private String documentReference;
	
	
    @Column(name="PERIODID")
    private String periodId;
    @Column(name="ACCOUNTID")
    private String accountId;
    @Column(name="DOCTYPE")
    private String docType;
    @Column(name="TRANSBALANCE")
    private String transactionBalance;
    @Column(name="RETURNTYPE")
    private String returnType;
    @Column(name="DOCSTATUS")
    private String docStatus;
    @Column(name="TAXTYPE")
    private String taxType;
    
    public TransactionDocRefView() {
    }


    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setDocumentReference(String documentReference) {
        this.documentReference = documentReference;
    }

    public String getDocumentReference() {
        return documentReference;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setTransactionBalance(String transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    public String getTransactionBalance() {
        return transactionBalance;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }
}
