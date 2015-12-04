package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.casemanagement.model.CaseGroupAssignLog;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.riskmanagement.model.RskRiskProcess;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Model class representing the table CASE_DETAILS. This is the base class for all the case domain objects.
 * 
 *@author
 *@version
 *@since   
 *@see CommAttachment, CaseGroupAssignLog, CaseNotes, CaseRelatedDocuments, CaseLinkedCases, CaseCorrespondence, CaseContactPerson, CaseMemberLog
 * 
 */

@Entity

@NamedQueries( { @NamedQuery(name = "CaseDetails.findAll", 
            query = "select o from CaseDetails o"),
    @NamedQuery(name = "CaseDetails.findCaseDetailsById", 
    query = "select o from CaseDetails o where o.id=?1")
})
@Table(name = "CASE_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CTYPE")
@DiscriminatorValue("CASE")

public class CaseDetails extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_DETAILS_SEQ")
    @SequenceGenerator(name = "CASE_DETAILS_SEQ", 
                       sequenceName = "CASE_DETAILS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String ctype;
    @Column(name = "CASE_CREATED_DATE")
    private Timestamp caseCreatedDate;
    @Column(name = "CASE_CREATED_BY")
    private String caseCreatedBy;
    //The following field is for case number generation   
    @ReferenceNumber(format = "ATTRIBUTE(prefix)SQL", 
                     sql = "SELECT LTRIM(TO_CHAR(MOD(CASE_NUMBER_SEQ.nextval,000000000),'000000099')) as generatedId FROM dual")
    @Column(name = "CASE_NUMBER")
    private String caseNumber;
    @Column(name = "CASE_OFFICE")
    private String caseOffice;
    @Column(name = "CASE_OUTCOME")
    private String caseOutcome;
    @Column(name = "CASE_STATUS")
    private String caseStatus;
    @Column(name = "CASE_WORKING_STATUS")
    private String caseWorkingStatus;
    @Column(name = "CASE_TITLE")
    private String caseTitle;
    @Column(name = "CASE_TYPE")
    private String caseType;
    @Transient
    private String prefix;
    @Column(name = "CLOSE_NOTES")
    private String closeNotes;
    @Column(name = "CLOSE_REASON")
    private String closeReason;
    @Column(name = "ENTITY_ID")
    private Long entityId;
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="CASE_ATTACHMENT",
        joinColumns={@JoinColumn(name = "CASE_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "COMM_ATTACHMENT_ID",
                referencedColumnName = "ID")}
    )
    private List<CommAttachment> commAttachmentList = new ArrayList<CommAttachment>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseGroupAssignLog> caseGroupAssignLogList = new ArrayList<CaseGroupAssignLog>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseNotes> caseNotesList = new ArrayList<CaseNotes>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseRelatedDocuments> caseRelatedDocumentsList = new ArrayList<CaseRelatedDocuments>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseLinkedCases> caseLinkedCasesList = new ArrayList<CaseLinkedCases>(); 
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseCorrespondence> caseCorrespondenceList = new ArrayList<CaseCorrespondence>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseContactPerson> caseContactPersonList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "caseDetails")
    private List<CaseMemberLog> caseMemberLogList= new ArrayList<CaseMemberLog>();    
    @JoinColumn(name = "ID", referencedColumnName = "CASE_ID", insertable = false, updatable = false)
    private RskRiskProcess rskRiskProcess;
    public CaseDetails() {
    }

    public Timestamp getCaseCreatedDate() {
        return caseCreatedDate;
    }

    public void setCaseCreatedDate(Timestamp caseCreatedDate) {
        this.caseCreatedDate = caseCreatedDate;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getCaseOffice() {
        return caseOffice;
    }

    public void setCaseOffice(String caseOffice) {
        this.caseOffice = caseOffice;
    }

    public String getCaseOutcome() {
        return caseOutcome;
    }

    public void setCaseOutcome(String caseOutcome) {
        this.caseOutcome = caseOutcome;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCloseNotes() {
        return closeNotes;
    }

    public void setCloseNotes(String closeNotes) {
        this.closeNotes = closeNotes;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CaseGroupAssignLog> getCaseGroupAssignLogList() {
        return caseGroupAssignLogList;
    }

    public void setCaseGroupAssignLogList(List<CaseGroupAssignLog> caseGroupAssignLogList) {
        this.caseGroupAssignLogList = caseGroupAssignLogList;
    }

    public CaseGroupAssignLog addCaseGroupAssignLog(CaseGroupAssignLog caseGroupAssignLogList) {
        getCaseGroupAssignLogList().add(caseGroupAssignLogList);
        caseGroupAssignLogList.setCaseDetails(this);
        return caseGroupAssignLogList;
    }

    public CaseGroupAssignLog removeCaseGroupAssignLog(CaseGroupAssignLog caseGroupAssignLogList) {
        getCaseGroupAssignLogList().remove(caseGroupAssignLogList);
        caseGroupAssignLogList.setCaseDetails(null);
        return caseGroupAssignLogList;
    }

    public List<CaseNotes> getCaseNotesList() {
        return caseNotesList;
    }

    public void setCaseNotesList(List<CaseNotes> caseNotesList) {
        this.caseNotesList = caseNotesList;
    }

    public CaseNotes addCaseNotes(CaseNotes caseNotesList) {
        getCaseNotesList().add(caseNotesList);
        caseNotesList.setCaseDetails(this);
        return caseNotesList;
    }

    public CaseNotes removeCaseNotes(CaseNotes caseNotesList) {
        getCaseNotesList().remove(caseNotesList);
        caseNotesList.setCaseDetails(null);
        return caseNotesList;
    }

    public List<CaseRelatedDocuments> getCaseRelatedDocumentsList() {
        return caseRelatedDocumentsList;
    }

    public void setCaseRelatedDocumentsList(List<CaseRelatedDocuments> caseRelatedDocumentsList) {
        this.caseRelatedDocumentsList = caseRelatedDocumentsList;
    }

    public CaseRelatedDocuments addCaseRelatedDocuments(CaseRelatedDocuments caseRelatedDocuments) {
        getCaseRelatedDocumentsList().add(caseRelatedDocuments);
        caseRelatedDocuments.setCaseDetails(this);
        return caseRelatedDocuments;
    }

    public CaseRelatedDocuments removeCaseRelatedDocuments(CaseRelatedDocuments caseRelatedDocuments) {
        getCaseRelatedDocumentsList().remove(caseRelatedDocuments);
        caseRelatedDocuments.setCaseDetails(null);
        return caseRelatedDocuments;
    }

    public List<CaseLinkedCases> getCaseLinkedCasesList() {
        return caseLinkedCasesList;
    }

    public void setCaseLinkedCasesList(List<CaseLinkedCases> caseLinkedCasesList) {
        this.caseLinkedCasesList = caseLinkedCasesList;
    }

    public CaseLinkedCases addCaseLinkedCases(CaseLinkedCases caseLinkedCasesList) {
        getCaseLinkedCasesList().add(caseLinkedCasesList);
        caseLinkedCasesList.setCaseDetails(this);
        return caseLinkedCasesList;
    }

    public CaseLinkedCases removeCaseLinkedCases(CaseLinkedCases caseLinkedCases) {
        getCaseLinkedCasesList().remove(caseLinkedCases);
        caseLinkedCases.setCaseDetails(null);
        return caseLinkedCases;
    }

    public List<CaseCorrespondence> getCaseCorrespondenceList() {
        return caseCorrespondenceList;
    }

    public void setCaseCorrespondenceList(List<CaseCorrespondence> caseCorrespondenceList) {
        this.caseCorrespondenceList = caseCorrespondenceList;
    }

    public CaseCorrespondence addCaseCorrespondence(CaseCorrespondence caseCorrespondence) {
        getCaseCorrespondenceList().add(caseCorrespondence);
        caseCorrespondence.setCaseDetails(this);
        return caseCorrespondence;
    }

    public CaseCorrespondence removeCaseCorrespondence(CaseCorrespondence caseCorrespondence) {
        getCaseCorrespondenceList().remove(caseCorrespondence);
        caseCorrespondence.setCaseDetails(null);
        return caseCorrespondence;
    }

//    public CaseAttachment addCaseAttachment(CaseAttachment caseAttachment) {
//        getCaseAttachmentList().add(caseAttachment);
//        caseAttachment.setCaseDetails(this);
//        return caseAttachment;
//    }
//
//    public CaseAttachment removeCaseAttachment(CaseAttachment caseAttachment) {
//        getCaseAttachmentList().remove(caseAttachment);
//        caseAttachment.setCaseDetails(null);
//        return caseAttachment;
//    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setCaseCreatedBy(String caseCreatedBy) {
        this.caseCreatedBy = caseCreatedBy;
    }

    public String getCaseCreatedBy() {
        return caseCreatedBy;
    }

    public List<CaseContactPerson> getCaseContactPersonList() {
        return caseContactPersonList;
    }

    public void setCaseContactPersonList(List<CaseContactPerson> caseContactPersonList) {
        this.caseContactPersonList = caseContactPersonList;
    }
    
    public CaseContactPerson addCaseContactPerson(CaseContactPerson caseContactPerson) {
        caseContactPerson.setCaseDetails(this);
        getCaseContactPersonList().add(caseContactPerson);
        return caseContactPerson;
    }

    public CaseContactPerson removeCaseContactPerson(CaseContactPerson caseContactPerson) {
        getCaseContactPersonList().remove(caseContactPerson);
        return caseContactPerson;
    }


    public void setCommAttachmentList(List<CommAttachment> commAttachmentList) {
        this.commAttachmentList = commAttachmentList;
    }

    public List<CommAttachment> getCommAttachmentList() {
        return commAttachmentList;
    }
    
    public CommAttachment addCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().add(commAttachment);
        return commAttachment;
    }

    public CommAttachment removeCommAttachment(CommAttachment commAttachment) {
        getCommAttachmentList().remove(commAttachment);
        return commAttachment;
    }

    public void setCaseMemberLogList(List<CaseMemberLog> caseMemberLogList) {
        this.caseMemberLogList = caseMemberLogList;
    }

    public List<CaseMemberLog> getCaseMemberLogList() {
        return caseMemberLogList;
    }
    
    public CaseMemberLog addCaseMemberLog(CaseMemberLog caseMemberLogList) {
        getCaseMemberLogList().add(caseMemberLogList);
        caseMemberLogList.setCaseDetails(this);
        return caseMemberLogList;
    }

    public CaseMemberLog removeCaseMemberLog(CaseMemberLog caseMemberLogList) {
        getCaseMemberLogList().remove(caseMemberLogList);
        caseMemberLogList.setCaseDetails(null);
        return caseMemberLogList;
    }


    public void setCaseWorkingStatus(String caseWorkingStatus) {
        this.caseWorkingStatus = caseWorkingStatus;
    }

    public String getCaseWorkingStatus() {
        return caseWorkingStatus;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCtype() {
        return ctype;
    }

    public void setRskRiskProcess(RskRiskProcess rskRiskProcess) {
        this.rskRiskProcess = rskRiskProcess;
    }

    public RskRiskProcess getRskRiskProcess() {
        return rskRiskProcess;
    }
}
