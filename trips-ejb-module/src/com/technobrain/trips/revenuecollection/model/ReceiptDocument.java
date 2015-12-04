package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
    
@NamedQueries(
    {
    @NamedQuery(name = "ReceiptDocument.findAll", 
    query = "select o from ReceiptDocument o"),
    @NamedQuery(name = "ReceiptDocument.findByReceiptNumberForNotInStock", 
    query = "select o from ReceiptDocument o where (o.receiptNumFrom >= ?1 and o.receiptNumTo <= ?2) and o.issuedFromOfficeId=?3 and o.distributionStatus=?4"),
   
    @NamedQuery(name = "ReceiptDocument.findReceiptNumberFrom", 
    query = "select o.receiptNumFrom from ReceiptDocument o where o.distributionStatus = ?1 and o.issuedToOfficeId = ?2"),
    @NamedQuery(name = "ReceiptDocument.findReceiptNumberTo", 
    query = "select o.receiptNumTo from ReceiptDocument o where o.distributionStatus = ?1 and o.issuedToOfficeId = ?2"),
   
    @NamedQuery(name = "ReceiptDocument.findReceiptNumberFromToIssue", 
    query = "select o.receiptNumFrom from ReceiptDocument o where o.distributionStatus = ?1 and o.issuedFromOfficeId = ?2"),
    @NamedQuery(name = "ReceiptDocument.findReceiptNumberToForIssue", 
    query = "select o.receiptNumTo from ReceiptDocument o where o.distributionStatus = ?1 and o.issuedFromOfficeId = ?2"),
   
   @NamedQuery(name = "ReceiptDocument.findRcptNumFromInDamagedLostStolenScrapped", 
    query = "select o.receiptNumFrom from ReceiptDocument o where o.distributionStatus in('Damaged','Lost','Scrapped','Stolen')"),
    @NamedQuery(name = "ReceiptDocument.findRcptNumToInDamagedLostStolenScrapped", 
    query = "select o.receiptNumTo from ReceiptDocument o where o.distributionStatus in('Damaged','Lost','Scrapped','Stolen')"),
   
    @NamedQuery(name = "ReceiptDocument.findSartRangeIn", 
    query = "select o from ReceiptDocument o where ?1 between (?2) and (?3) and o.distributionStatus = ?4"),
    @NamedQuery(name = "ReceiptDocument.findToRangeIn", 
    query = "select o from ReceiptDocument o where ?1 between (?2) and (?3) and o.distributionStatus = ?4"),
    @NamedQuery(name = "ReceiptDocument.findByReceiptNumberForInStock", 
    query = "select o from ReceiptDocument o where (o.receiptNumFrom <= ?1 and o.receiptNumTo >= ?2) or (o.receiptNumFrom <= ?3 and o.receiptNumTo >= ?4)"),
    @NamedQuery(name = "ReceiptDocument.findInStockToBeUnusedReceipts", 
    query = "select o from ReceiptDocument o where ((o.receiptNumFrom <= ?1 and o.receiptNumTo >= ?2) or (o.receiptNumFrom <= ?3 and o.receiptNumTo >= ?4)) and o.issuedFromOfficeId= ?5 and o.distributionStatus='InStock'"),
    
    @NamedQuery(name = "ReceiptDocument.checkReceiptsToUpdateUnused", 
    query = "select o from ReceiptDocument o where ((o.receiptNumFrom <= ?1 and o.receiptNumTo >= ?2) or (o.receiptNumFrom <= ?3 and o.receiptNumTo >= ?4)) and o.issuedToOfficeId= ?5 and o.distributionStatus='InStock'"),
    
    @NamedQuery(name = "ReceiptDocument.checkIsValidReceiptToIssueFromOfficeId", 
    query = "select o from ReceiptDocument o where ((o.receiptNumFrom <= ?1 and o.receiptNumTo >= ?2) or (o.receiptNumFrom <= ?3 and o.receiptNumTo >= ?4)) and o.issuedFromOfficeId = ?5 and o.distributionStatus IN ('Issued','Damaged','Lost','Scrapped','Stolen')"),
    @NamedQuery(name = "ReceiptDocument.checkIssuedByFromOfficeId", 
    query = "select o from ReceiptDocument o where ((o.receiptNumFrom <= ?1 and o.receiptNumTo >= ?2) or (o.receiptNumFrom <= ?3 and o.receiptNumTo >= ?4)) and o.issuedFromOfficeId = ?5 and o.distributionStatus IN ('Issued','InStock','Damaged','Lost','Scrapped','Stolen')")
    }
)
@Table(name = "RECEIPT_DOCUMENT")
public class ReceiptDocument extends BaseNormalModelObject {

    @Column(name="DISTRIBUTION_DATE")
    private Timestamp distributionDate;
    @Column(name="DISTRIBUTION_STATUS")
    private String distributionStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIPT_DOCUMENT_SEQ")
    @SequenceGenerator(name = "RECEIPT_DOCUMENT_SEQ", sequenceName = "RECEIPT_DOCUMENT_SEQ", allocationSize = 1)
    @Column(nullable = false) 
    private Long id;
    @Column(name="ISSUED_TO_OFFICER_ID")
    private Long issuedToOfficerId;
    @Column(name="ISSUED_TO_OFFICE_ID")
    private Long issuedToOfficeId;
    @Column(name="RECEIPT_NUM_FROM")
    private Long receiptNumFrom;
    @Column(name="RECEIPT_NUM_TO")
    private Long receiptNumTo;
    @Column(name="ISSUED_FROM_OFFICE_ID")
    private Long issuedFromOfficeId;
   public ReceiptDocument() {
    }

    public Timestamp getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(Timestamp distributionDate) {
        this.distributionDate = distributionDate;
    }

    public String getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssuedToOfficerId() {
        return issuedToOfficerId;
    }

    public void setIssuedToOfficerId(Long issuedToOfficerId) {
        this.issuedToOfficerId = issuedToOfficerId;
    }

    public Long getIssuedToOfficeId() {
        return issuedToOfficeId;
    }

    public void setIssuedToOfficeId(Long issuedToOfficeId) {
        this.issuedToOfficeId = issuedToOfficeId;
    }

    public Long getReceiptNumFrom() {
        return receiptNumFrom;
    }

    public void setReceiptNumFrom(Long receiptNumFrom) {
        this.receiptNumFrom = receiptNumFrom;
    }

    public Long getReceiptNumTo() {
        return receiptNumTo;
    }

    public void setReceiptNumTo(Long receiptNumTo) {
        this.receiptNumTo = receiptNumTo;
    }

    public void setIssuedFromOfficeId(Long issuedFromOfficeId) {
        this.issuedFromOfficeId = issuedFromOfficeId;
    }

    public Long getIssuedFromOfficeId() {
        return issuedFromOfficeId;
    }
}
