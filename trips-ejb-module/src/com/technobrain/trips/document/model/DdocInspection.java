package com.technobrain.trips.document.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "DdocInspection.findAll", query = "select o from DdocInspection o")
@Table(name = "DDOC_INSPECTION")
public class DdocInspection extends BaseNormalModelObject   {
     
     
     
     
    @Column(name = "END_DATE")
    private Timestamp endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_inspection_seq")
    @SequenceGenerator(name = "ddoc_inspection_seq", sequenceName = "ddoc_inspection_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id; 
    @ReferenceNumber(format="INS/SQL", sql="SELECT LTRIM(TO_CHAR(MOD(INSPECTION_NO_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM dual")
    @Column(name = "INSPECTION_NO")
    private String inspectionNo;
    private String outcome;
    @Column(name = "START_DATE")
    private Timestamp startDate;
    @Column(name = "REQUEST_DATE")
    private Timestamp requestDate;   
     
     
     
     
     
     
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "DOCUMENT_STATUS")
    private String documentStatus;
    @Column(name = "EXPECTED_REVENUE")
    private BigDecimal expectedRevenue;
    @Column(name = "EXPECTED_FINE")
    private BigDecimal expectedFine;
    @Column(name = "EXPECTED_REVENUE_CURRENCY")
    private String expectedRevenueCurrency;
    @Column(name = "EXPECTED_FINE_CURRENCY")
    private String expectedFineCurency;
    @Column(name = "INSPECTION_RESULTS")
    private String inspectionResults;

    @Column(name = "DDOC_DOCUMENT_ID")
    private Long dDocDocumentId;

    @OneToMany(mappedBy = "ddocInspection", cascade = { CascadeType.ALL })
    private List<DdocInstruction> ddocInstructionList;
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private DdocDocument ddocDocument;

    public DdocInspection() {
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInspectionNo() {
        return inspectionNo;
    }

    public void setInspectionNo(String inspectionNo) {
        this.inspectionNo = inspectionNo;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public List<DdocInstruction> getDdocInstructionList() {
        return ddocInstructionList;
    }

    public void setDdocInstructionList(List<DdocInstruction> ddocInstructionList) {
        this.ddocInstructionList = ddocInstructionList;
    }

    public DdocInstruction addDdocInstruction(DdocInstruction ddocInstruction) {
        getDdocInstructionList().add(ddocInstruction);
        ddocInstruction.setDdocInspection(this);
        return ddocInstruction;
    }

    public DdocInstruction removeDdocInstruction(DdocInstruction ddocInstruction) {
        getDdocInstructionList().remove(ddocInstruction);
        ddocInstruction.setDdocInspection(null);
        return ddocInstruction;
    }

    public void removeAllInstructions() {
        if (ddocInstructionList != null)
            ddocInstructionList.clear();
    }


    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setDdocDocument(DdocDocument ddocDocument1) {
        this.ddocDocument = ddocDocument1;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setExpectedRevenue(BigDecimal expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public BigDecimal getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedFine(BigDecimal expectedFine) {
        this.expectedFine = expectedFine;
    }

    public BigDecimal getExpectedFine() {
        return expectedFine;
    }

    public void setExpectedRevenueCurrency(String expectedRevenueCurrency) {
        this.expectedRevenueCurrency = expectedRevenueCurrency;
    }

    public String getExpectedRevenueCurrency() {
        return expectedRevenueCurrency;
    }

    public void setExpectedFineCurency(String expectedFineCurency) {
        this.expectedFineCurency = expectedFineCurency;
    }

    public String getExpectedFineCurency() {
        return expectedFineCurency;
    }

    public void setInspectionResults(String inspectionResults) {
        this.inspectionResults = inspectionResults;
    }

    public String getInspectionResults() {
        return inspectionResults;
    }

    public void setDDocDocumentId(Long dDocDocumentId) {
        this.dDocDocumentId = dDocDocumentId;
    }

    public Long getDDocDocumentId() {
        return dDocDocumentId;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }
}
