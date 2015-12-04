package com.technobrain.trips.dto.portal;

import java.math.BigDecimal;

import java.sql.Timestamp;


/**
 * Data transfer object for TransactionService.extractInvoiceTransactions() 
 * service
 * 
 * @author Emmanuel Comia
 */
public class InvoiceDTO {
    public InvoiceDTO() {
    }

    /**
     * Constructor
     * 
     * @param tranType
     * @param amount
     * @param number
     * @param accountNumber
     * @param transDate
     * @param revLedCode
     * @param description
     * @param office
     * @param transId
     * @param createdDate
     * @param docType
     * @param submissionDate
     * @param revEvtTypeCat
     * @param tin
     * @param taxType
     */
    public InvoiceDTO(String tranType, BigDecimal amount, String number, 
                      String accountNumber, Timestamp transDate, 
                      String revLedCode, String description, String office, 
                      String transId, String docType, Timestamp createdDate, 
                      Timestamp submissionDate, String revEvtTypeCat, 
                      String tin, String taxType) {
        this.setTranType(tranType);
        this.setAmount(amount);
        this.setNumber(number);
        this.setAccountNumber(accountNumber);
        this.setTransDate(transDate);
        this.setRevLedCode(revLedCode);
        this.setDescription(description);
        this.setOffice(office);
        this.setTransId(transId);
        this.setCreatedDate(createdDate);
        this.setDocType(docType);
        this.setSubmissionDate(submissionDate);
        this.setRevEvtTypeCat(revEvtTypeCat);
        this.setTin(tin);
        this.setTaxType(taxType);
    }

    private String tranType;
    private BigDecimal amount;
    private String number;
    private String accountNumber;
    private Timestamp transDate;
    private String revLedCode;
    private String description;
    private String office;
    private String transId;
    private Timestamp createdDate;
    private String docType;
    private Timestamp submissionDate;
    private String revEvtTypeCat;
    private String tin;
    private String taxType;

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public String getRevLedCode() {
        return revLedCode;
    }

    public void setRevLedCode(String revLedCode) {
        this.revLedCode = revLedCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getRevEvtTypeCat() {
        return revEvtTypeCat;
    }

    public void setRevEvtTypeCat(String revEvtTypeCat) {
        this.revEvtTypeCat = revEvtTypeCat;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
	
    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
	
}
