package com.technobrain.trips.document.model;

import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.account.model.AccountTransaction;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.message.DocumentHeaderType;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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


@Entity
@NamedQuery(name = "DdocDocument.findAll", query = "select o from DdocDocument o")
@Table(name = "DDOC_DOCUMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("DOCUMENT")
@NamedQueries( { @NamedQuery(name = "DdocDocument.findFlexibleFormName", 
                             query = "select o.flexiFormName from DdocDocument o where o.id = ?1")
        , @NamedQuery(name = "DdocDocument.findById", 
                             query = "select o from DdocDocument o where o.id = ?1"), 
        @NamedQuery(name = "DdocDocument.findDocType", query = "select o.docType from DdocDocument o where o.id = ?1"),
         @NamedQuery(name = "DdocDocument.findDocType", query = "select o.docType from DdocDocument o where o.id = ?1"),
         @NamedQuery(name = "DdocDocument.updateAccountIdInDocument",query = "UPDATE DdocDocument o " +
                            "SET o.accAccount= ?1 WHERE o.id = ?2"),
         @NamedQuery(name = "DdocDocument.findDocumentsByPeriodId", query = "select o from DdocDocument o where o.accPeriod = ?1 order by o.id desc"),
         @NamedQuery(name = "DdocDocument.findDocumentByFormName", query = "select o from DdocDocument o where o.flexiFormName = ?1"),
         @NamedQuery(name = "DdocDocument.findDdocByAccountPeriodId", query = "select o from DdocDocument o where o.id=(select max(doc.id) from DdocDocument doc where doc.accPeriod = ?1)")
        } )
public class DdocDocument extends BaseNormalModelObject implements Serializable {
    private String authentication;

    @ReferenceNumber(format = "SQL", 
                     sql = "SELECT PREFIX || '/' || LTRIM(TO_CHAR(MOD(DCASE_DEBT_NOTICE_SEQ.nextval,100000),'000099'))||'/'||to_char(sysdate,'YYYY') as generatedId FROM REF_DOC_TYPE WHERE CODE = 'ATTRIBUTE(docType)'")
    @Column(name = "REFERENCE")
    private String reference;
    @Column(name = "DOC_STATUS")
    private String docStatus;
    @Column(name = "DTYPE")
    private String dtype;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_document_seq")
    @SequenceGenerator(name = "ddoc_document_seq", sequenceName = "ddoc_document_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "ISSUE_DATE")
    private Timestamp issueDate;
    @Column(name = "ISSUE_PLACE")
    private String issuePlace;
    @Column(name = "ISSUE_OFFICE")
    private String issueOffice;
    @Column(name = "ITEM_COUNT")
    private Long itemCount;
    @Column(name = "ACC_ACCOUNT")
    private Long accAccount;
//    @Column(name = "REV_ACC")
//    private Long revAcc; //The variable name is "accountNumber" in cay man implementation
    @Column(name = "ACC_PERIOD")
    private Long accPeriod;
    @JoinColumn(name = "ACC_PERIOD", referencedColumnName = "ID", insertable=false,updatable=false)
    private AccountPeriod accountPeriod;
//    @Column(name = "REVLED_REV_PERIOD")
//    private Long revledRevPeriod;
    @Column(name = "SUBMISSION_DATE")
    private Timestamp submissionDate;
    @Column(name = "DOC_TYPE")
    private String docType;
//    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
//    private List<DdocInspection> ddocInspectionList;
//    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument1")
//    private List<DtaxHeader> dtaxHeaderList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
    private List<DdocNotes> ddocNotesList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
    private List<DdocEntityDocRel> ddocEntityDocRelList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
    private List<DdocHistory> ddocHistoryList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "sourceDocument")
    private List<DdocHistory> sourceHistoryList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "targetDocument")
    private List<DdocDocumentLink> targetDocumentLinkList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "sourceDocument")
    private List<DdocDocumentLink> sourceDocumentLinkList;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
    private List<DdocDocumentError> ddocDocumentErrorList;
//    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
//    private List<DdocQuery> ddocQueryList;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
    private List<DdocCorrespondenceParams> ddocCorrespondenceParamList;

//    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "ddocDocument")
//    private List<DjobBatchDetail> djobBatchDetailList;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "document")
    private List<DdocDocumentRole> documentRoleList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "COMM_ATTACHMENT_DDOC", 
               joinColumns = { @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID")
                } , inverseJoinColumns = { @JoinColumn(name = "ATTACHMENT_ID", referencedColumnName = "ID")
                } )
    private List<CommAttachment> commAttachmentList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "COMM_ATTACHMENT_CORRESP", 
               joinColumns = { @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID")
                } , inverseJoinColumns = { @JoinColumn(name = "ATTACHMENT_ID", referencedColumnName = "ID")
                } )
    private List<CommAttachment> correspAttachmentList;

//    @ManyToOne
//    @JoinColumn(name = "REPORT_TYPE", referencedColumnName = "CODE")
//    private RefDocReport reportType;
//
//    @Column(name = "PRINT_STATUS")
//    private String printStatus;
//    @Column(name = "PRINT_COUNT")
//    private Long printCount;
//    @Column(name = "PRINT_DATE")
//    private Timestamp printDate;
//    @Column(name = "DMS_ID")
//    private String dmsID;
//    @Column(name = "TEMPLATE")
//    private String template;
//    @Column(name = "FLEXI_FORM")
//    private Long flexiForm;
//    @Column(name = "SCHEDULED")
//    private String sheduled;
    @Column(name = "FLEXI_FORM_NAME")
    private String flexiFormName;
    
    @Column(name = "PORTAL_USERNAME")
    private String portalUsername;
    
    @Transient
    private Long associatedEvent;
    
    @Transient
    private String docStatusDescription;
    
    @Transient
    private List<Long>  allocatedTransId;     
    
    @Transient
    private List<AccountTransaction>  deAllocatedTransactions; 

    public DdocDocument() {

    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

//    public Long getRevAcc() {
//        return revAcc;
//    }
//
//    public void setRevAcc(Long revAcc) {
//        this.revAcc = revAcc;
//    }

//    public Long getRevledRevPeriod() {
//        return revledRevPeriod;
//    }
//
//    public void setRevledRevPeriod(Long revledRevPeriod) {
//        this.revledRevPeriod = revledRevPeriod;
//    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

//    public List<DdocInspection> getDdocInspectionList() {
//        return ddocInspectionList;
//    }
//
//    public void setDdocInspectionList(List<DdocInspection> ddocInspectionList) {
//        this.ddocInspectionList = ddocInspectionList;
//    }

//    public DdocInspection addDdocInspection(DdocInspection ddocInspection) {
//        getDdocInspectionList().add(ddocInspection);
//        ddocInspection.setDdocDocument(this);
//        return ddocInspection;
//    }
//
//    public DdocInspection removeDdocInspection(DdocInspection ddocInspection) {
//        getDdocInspectionList().remove(ddocInspection);
//        ddocInspection.setDdocDocument(null);
//        return ddocInspection;
//    }

//    public List<DtaxHeader> getDtaxHeaderList() {
//        return dtaxHeaderList;
//    }
//
//    public void setDtaxHeaderList(List<DtaxHeader> dtaxHeaderList) {
//        this.dtaxHeaderList = dtaxHeaderList;
//    }

//    public DtaxHeader addDtaxHeader(DtaxHeader dtaxHeader) {
//        getDtaxHeaderList().add(dtaxHeader);
//        dtaxHeader.setDdocDocument1(this);
//        return dtaxHeader;
//    }
//
//    public DtaxHeader removeDtaxHeader(DtaxHeader dtaxHeader) {
//        getDtaxHeaderList().remove(dtaxHeader);
//        dtaxHeader.setDdocDocument1(null);
//        return dtaxHeader;
//    }

    public List<DdocNotes> getDdocNotesList() {
        return ddocNotesList;
    }

    public void setDdocNotesList(List<DdocNotes> ddocNotesList) {
        this.ddocNotesList = ddocNotesList;
    }

    public DdocNotes addDdocNotes(DdocNotes ddocNotes) {
        getDdocNotesList().add(ddocNotes);
        ddocNotes.setDdocDocument(this);
        return ddocNotes;
    }

    public DdocNotes removeDdocNotes(DdocNotes ddocNotes) {
        getDdocNotesList().remove(ddocNotes);
        ddocNotes.setDdocDocument(null);
        return ddocNotes;
    }

    public List<DdocHistory> getDdocHistoryList() {
        return ddocHistoryList;
    }

    public void setDdocHistoryList(List<DdocHistory> ddocHistoryList) {
        this.ddocHistoryList = ddocHistoryList;
    }

    public DdocHistory addDdocHistory(DdocHistory ddocHistory) {
        getDdocHistoryList().add(ddocHistory);
        ddocHistory.setDdocDocument(this);
        return ddocHistory;
    }

    public DdocHistory removeDdocHistory(DdocHistory ddocHistory) {
        getDdocHistoryList().remove(ddocHistory);
        ddocHistory.setDdocDocument(null);
        return ddocHistory;
    }

    public List<DdocDocumentLink> getTargetDocumentLinkList() {
        return targetDocumentLinkList;
    }

    public void setTargetDocumentLinkList(List<DdocDocumentLink> ddocDocumentLinkList) {
        this.targetDocumentLinkList = ddocDocumentLinkList;
    }

    public DdocDocumentLink addDdocDocumentLink(DdocDocumentLink ddocDocumentLink) {
        getTargetDocumentLinkList().add(ddocDocumentLink);
        ddocDocumentLink.setTargetDocument(this);
        return ddocDocumentLink;
    }

    public DdocDocumentLink removeDdocDocumentLink(DdocDocumentLink ddocDocumentLink) {
        getTargetDocumentLinkList().remove(ddocDocumentLink);
        ddocDocumentLink.setTargetDocument(null);
        return ddocDocumentLink;
    }

    public List<DdocEntityDocRel> getDdocEntityDocRelList() {
        return ddocEntityDocRelList;
    }

    public void setDdocEntityDocRelList(List<DdocEntityDocRel> ddocEntityDocRelList) {
        this.ddocEntityDocRelList = ddocEntityDocRelList;
    }

    public DdocEntityDocRel addDdocEntityDocRel(DdocEntityDocRel ddocEntityDocRel) {
        getDdocEntityDocRelList().add(ddocEntityDocRel);
        ddocEntityDocRel.setDdocDocument(this);
        return ddocEntityDocRel;
    }

    public DdocEntityDocRel removeDdocEntityDocRel(DdocEntityDocRel ddocEntityDocRel) {
        getDdocEntityDocRelList().remove(ddocEntityDocRel);
        ddocEntityDocRel.setDdocDocument(null);
        return ddocEntityDocRel;
    }

    public List<DdocHistory> getSourceHistoryList() {
        return sourceHistoryList;
    }

    public void setSourceHistoryList(List<DdocHistory> ddocHistoryList1) {
        this.sourceHistoryList = ddocHistoryList1;
    }

    public DdocHistory addDdocHistory1(DdocHistory ddocHistory) {
        getSourceHistoryList().add(ddocHistory);
        ddocHistory.setSourceDocument(this);
        return ddocHistory;
    }

    public DdocHistory removeDdocHistory1(DdocHistory ddocHistory) {
        getSourceHistoryList().remove(ddocHistory);
        ddocHistory.setSourceDocument(null);
        return ddocHistory;
    }

    public List<DdocDocumentLink> getSourceDocumentLinkList() {
        return sourceDocumentLinkList;
    }

    public void setSourceDocumentLinkList(List<DdocDocumentLink> ddocDocumentLinkList1) {
        this.sourceDocumentLinkList = ddocDocumentLinkList1;
    }

    public DdocDocumentLink addDdocDocumentLink1(DdocDocumentLink ddocDocumentLink) {
        getSourceDocumentLinkList().add(ddocDocumentLink);
        ddocDocumentLink.setSourceDocument(this);
        return ddocDocumentLink;
    }

    public DdocDocumentLink removeDdocDocumentLink1(DdocDocumentLink ddocDocumentLink) {
        getSourceDocumentLinkList().remove(ddocDocumentLink);
        ddocDocumentLink.setSourceDocument(null);
        return ddocDocumentLink;
    }

    public List<DdocDocumentError> getDdocDocumentErrorList() {
        return ddocDocumentErrorList;
    }

    public void setDdocDocumentErrorList(List<DdocDocumentError> ddocDocumentErrorList) {
        this.ddocDocumentErrorList = ddocDocumentErrorList;
    }

    public DdocDocumentError addDdocDocumentError(DdocDocumentError ddocDocumentError) {
        getDdocDocumentErrorList().add(ddocDocumentError);
        ddocDocumentError.setDdocDocument(this);
        return ddocDocumentError;
    }

    public DdocDocumentError removeDdocDocumentError(DdocDocumentError ddocDocumentError) {
        getDdocDocumentErrorList().remove(ddocDocumentError);
        //ddocDocumentError.setDdocDocument(null);
        return ddocDocumentError;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public DocumentHeaderType getDataDocumentHeaderType() {
        DocumentHeaderType documentHeaderType = new DocumentHeaderType();
        documentHeaderType.setAuthenticationCode(this.getAuthentication());
        documentHeaderType.setDocumentType(this.getDtype());
        documentHeaderType.setIssueDate(DateHelper.getCalendar(this.getIssueDate()));
        documentHeaderType.setIssuePlace(this.getIssuePlace());
        documentHeaderType.setSubmissionDate(DateHelper.getCalendar(this.getSubmissionDate()));
        return documentHeaderType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

//    public void setDdocQueryList(List<DdocQuery> ddocQueryList) {
//        this.ddocQueryList = ddocQueryList;
//    }
//
//    public List<DdocQuery> getDdocQueryList() {
//        return ddocQueryList;
//    }

//    public DdocQuery addDdocQuery(DdocQuery ddocQuery) {
//        getDdocQueryList().add(ddocQuery);
//        ddocQuery.setDdocDocument(this);
//        return ddocQuery;
//    }
//
//    public DdocQuery removeDdocQuery(DdocQuery ddocQuery) {
//        getDdocQueryList().remove(ddocQuery);
//        ddocQuery.setDdocDocument(null);
//        return ddocQuery;
//    }

    public void setCommAttachmentList(List<CommAttachment> commAttachmentList) {
        this.commAttachmentList = commAttachmentList;
    }

    public List<CommAttachment> getCommAttachmentList() {
        return commAttachmentList;
    }

    public CommAttachment addCommAttachment(CommAttachment attachment) {
        getCommAttachmentList().add(attachment);
        return attachment;
    }

    public CommAttachment removeCommAttachment(CommAttachment attachment) {
        getCommAttachmentList().remove(attachment);
        return attachment;
    }

    public CommAttachment addCorrespAttachment(CommAttachment attachment) {
        getCorrespAttachmentList().add(attachment);
        return attachment;
    }

    public CommAttachment removeCorrespAttachment(CommAttachment attachment) {
        getCorrespAttachmentList().remove(attachment);
        return attachment;
    }

    public void setDdocCorrespondenceParamList(List<DdocCorrespondenceParams> ddocCorrespondenceParamList) {
        this.ddocCorrespondenceParamList = ddocCorrespondenceParamList;
    }

    public List<DdocCorrespondenceParams> getDdocCorrespondenceParamList() {
        return ddocCorrespondenceParamList;
    }

    public DdocCorrespondenceParams addDdocCorrespondenceParam(DdocCorrespondenceParams param) {
        getDdocCorrespondenceParamList().add(param);
        param.setDdocDocument(this);
        return param;
    }

    public DdocCorrespondenceParams removeDdocCorrespondenceParam(DdocCorrespondenceParams param) {
        getDdocCorrespondenceParamList().remove(param);
        param.setDdocDocument(null);
        return param;
    }

//    public void setPrintStatus(String printStatus) {
//        this.printStatus = printStatus;
//    }
//
//    public String getPrintStatus() {
//        return printStatus;
//    }
//
//    public void setPrintCount(Long printCount) {
//        this.printCount = printCount;
//    }
//
//    public Long getPrintCount() {
//        return printCount;
//    }


//    public void markPrinted() {
//        this.printStatus = Constants.PrintStatus.PRINTED;
//        this.printCount = getNextPrintCount();
//        this.issueOffice = "HQ";
//    }
//
//    private Long getNextPrintCount() {
//        if (null == this.printCount) {
//            return new Long(1);
//        } else
//            return this.printCount.longValue() + 1;
//    }
//
//    public void dmsLink(Long fileStoreID) {
//        this.dmsID = String.valueOf(fileStoreID);
//    }
//
//    public void dmsLink(FileStore fileStore) {
//        this.dmsID = String.valueOf(fileStore.getId());
//        CommAttachment attachment = new CommAttachment();
//        attachment.setFileStoreId(fileStore.getId());
//        this.addCorrespAttachment(attachment);
//    }

//    public void setDmsID(String dmsID) {
//        this.dmsID = dmsID;
//    }
//
//    public String getDmsID() {
//        return dmsID;
//    }

//    public void setReportType(RefDocReport reportType) {
//        this.reportType = reportType;
//    }
//
//    public RefDocReport getReportType() {
//        return reportType;
//    }

    public void setCorrespAttachmentList(List<CommAttachment> correspAttachmentList) {
        this.correspAttachmentList = correspAttachmentList;
    }

    public List<CommAttachment> getCorrespAttachmentList() {
        return correspAttachmentList;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

//    public void setTemplate(String template) {
//        this.template = template;
//    }
//
//    public String getTemplate() {
//        return template;
//    }
//
//    public void setPrintDate(Timestamp printDate) {
//        this.printDate = printDate;
//    }
//
//    public Timestamp getPrintDate() {
//        return printDate;
//    }

    /**
     * Creates the document history indicating that the document has been amended.
     * <p>
     * Also creates the document history 
     * @param originalDocument
     */
    public void amend(DdocDocument originalDocument, String amendedBy) {
        originalDocument.setDocStatus(Constants.DocStatus.AMENDED);
        DdocHistory ddocHistory = new DdocHistory();
        ddocHistory.setEventCode(Constants.EventCodes.AMENDED);
        ddocHistory.setEventDate(new Timestamp(System.currentTimeMillis()));
        ddocHistory.setStatusCode(this.getDocStatus());
        ddocHistory.setCreatedBy(amendedBy);
        ddocHistory.setCreatedDate(ddocHistory.getEventDate());
        ddocHistory.setUpdatedBy(amendedBy);
        ddocHistory.setUpdatedDate(ddocHistory.getEventDate());
        this.addDdocHistory(ddocHistory);
    }

//    public void setFlexiForm(Long flexiForm) {
//        this.flexiForm = flexiForm;
//    }
//
//    public Long getFlexiForm() {
//        return flexiForm;
//    }

//    public String getSheduled() {
//        return sheduled;
//    }
//
//    public void setSheduled(String sheduled) {
//        this.sheduled = sheduled;
//    }
//
//    public List<DjobBatchDetail> getDjobBatchDetailList() {
//        return djobBatchDetailList;
//    }
//
//    public void setDjobBatchDetailList(List<DjobBatchDetail> djobBatchDetailList) {
//        this.djobBatchDetailList = djobBatchDetailList;
//    }

    public void setIssueOffice(String issueOffice) {
        this.issueOffice = issueOffice;
    }

    public String getIssueOffice() {
        return issueOffice;
    }

    public void setDocumentRoleList(List<DdocDocumentRole> documentRoleList) {
        this.documentRoleList = documentRoleList;
    }

    public List<DdocDocumentRole> getDocumentRoleList() {
        return documentRoleList;
    }

    public DdocDocumentRole addDdocDocumentRole(DdocDocumentRole param) {
    
        if(documentRoleList == null){
            documentRoleList = new ArrayList<DdocDocumentRole>();
        }
    
        getDocumentRoleList().add(param);
        param.setDocument(this);
        return param;
    }

    public DdocDocumentRole removeDdocDocumentRole(DdocDocumentRole param) {
        getDocumentRoleList().remove(param);
        param.setDocument(null);
        return param;
    }

    public void setAccAccount(Long accAccount) {
        this.accAccount = accAccount;
    }

    public Long getAccAccount() {
        return accAccount;
    }

    public void setAccPeriod(Long accPeriod) {
        this.accPeriod = accPeriod;
    }

    public Long getAccPeriod() {
        return accPeriod;
    }

    public void setAccountPeriod(AccountPeriod accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public AccountPeriod getAccountPeriod() {
        return accountPeriod;
    }

    public void setAssociatedEvent(Long associatedEvent) {
        this.associatedEvent = associatedEvent;
    }

    public Long getAssociatedEvent() {
        return associatedEvent;
    }

    public void setDocStatusDescription(String docStatusDescription) {
        this.docStatusDescription = docStatusDescription;
    }

    public String getDocStatusDescription() {
        return docStatusDescription;
    }


    public void setAllocatedTransId(List<Long> allocatedTransId) {
        this.allocatedTransId = allocatedTransId;
    }

    public List<Long> getAllocatedTransId() {
        return allocatedTransId;
    }

    public void setDeAllocatedTransactions(List<AccountTransaction> deAllocatedTransactions) {
        this.deAllocatedTransactions = deAllocatedTransactions;
    }

    public List<AccountTransaction> getDeAllocatedTransactions() {
        return deAllocatedTransactions;
    }

    public void setFlexiFormName(String flexiFormName) {
        this.flexiFormName = flexiFormName;
    }

    public String getFlexiFormName() {
        return flexiFormName;
    }

    public void setPortalUsername(String portalUsername) {
        this.portalUsername = portalUsername;
    }

    public String getPortalUsername() {
        return portalUsername;
    }
}
