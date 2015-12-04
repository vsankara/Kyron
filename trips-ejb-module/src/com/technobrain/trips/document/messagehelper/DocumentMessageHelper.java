package com.technobrain.trips.document.messagehelper;

//import com.crownagents.trips.document.model.DfinAccAdjustment;
//import com.crownagents.trips.document.model.DfinTransferPaymentCredit;
//import com.crownagents.trips.entityandregimeaccounting.message.AccountAdjustmentInputType;
//import com.crownagents.trips.entityandregimeaccounting.message.TransferPaymentInputType;
//import com.crownagents.trips.reports.message.ReportsInputType;
//import com.crownagents.trips.reports.message.TaxpayerCertificateInputType;
//import com.crownagents.trips.reports.message.TaxtypeCertificateInputType;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.messagehelpers.ComplexAssociationHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.DDocDocumentRoleInputType;
import com.technobrain.trips.core.message.DdocDocumentInputType;
import com.technobrain.trips.core.message.DocumentHeaderType;
import com.technobrain.trips.core.message.InputType;
//import com.technobrain.trips.core.message.LodgmentInputType;
import com.technobrain.trips.core.message.NoteType;
//import com.crownagents.trips.core.message.ParameterType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.document.model.DdocCorrespondenceParams;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DdocDocumentRole;
import com.technobrain.trips.document.model.DdocLodgement;
import com.technobrain.trips.document.model.DdocNotes;
import com.technobrain.trips.reference.model.RefOffStaff;

import java.util.ArrayList;
//import com.crownagents.trips.common.messagehelpers.MessageHelper;

/**
 * TechnoBrain 2006
 *
 * Provide  methods to load a message bean from entities and vice-versa
 * for Document related entities
 *
 * @since	$Date: 12/20/2009 10:56:58 PM$
 * @version 	$Revision: 11$
 * @author 	$Author: Oliver Ralleta$
 * 
 * $Log[1]:
 *  11   TRIPS2 etis.bir.gov.ph1.5.1.4     12/20/2009 10:56:58 PM Oliver
 *       Ralleta  Added additional fields
 * $
 */
public class DocumentMessageHelper extends MessageHelper {

    public DdocDocument setDdocDocumentDataToPojo(DdocDocument doc, DdocDocumentInputType docInputType) {
        doc.setIssueDate(DateHelper.getSqlTimestamp(docInputType.getIssueDate()));
        doc.setIssuePlace(docInputType.getIssuePlace());
        doc.setItemCount(docInputType.getItemCount());
        doc.setAccAccount(docInputType.getAccountId());
        doc.setAccPeriod(docInputType.getPeriodId());
        doc.setDocStatus(docInputType.getDocStatus());
        doc.setDocType(docInputType.getDocType());
        doc.setSubmissionDate(DateHelper.getSqlTimestamp(docInputType.getSubmissionDate()));
        doc.setIssueOffice(docInputType.getIssueOffice());
        doc.setPortalUsername(docInputType.getPortalUsername());
        doc.setUpdatedBy(docInputType.getUpdatedBy());
        doc.setCreatedBy(docInputType.getCreatedBy());
        doc.setCreatedDate(DateHelper.getSqlTimestamp(docInputType.getCreatedDate()));
        doc.setUpdatedDate(DateHelper.getSqlTimestamp(docInputType.getUpdatedDate()));
        MessageHelper[] helpers = new MessageHelper[] { this };
//        setAssociationData(doc, docInputType.getDdocDocumentRoles(), 
//                           doc.getDocumentRoleList(), 
//                           getDocumentRoleAssociationHelper(), helpers);               
                           
        return doc;
    }
    
    public DdocDocumentInputType setDdocDocumenDateToInputType(DdocDocument doc, DdocDocumentInputType docInputType) {
        docInputType.setIssueDate(DateHelper.getCalendar(doc.getIssueDate()));
        docInputType.setIssuePlace(doc.getIssuePlace());
        docInputType.setItemCount(doc.getItemCount());
        docInputType.setAccountId(doc.getAccAccount());
        docInputType.setPeriodId(doc.getAccPeriod());
        docInputType.setDocStatus(doc.getDocStatus());
        docInputType.setDocType(doc.getDocType());
        docInputType.setReference(doc.getReference());
        docInputType.setSubmissionDate(DateHelper.getCalendar(doc.getSubmissionDate()));
        docInputType.setIssueOffice(doc.getIssueOffice());
        docInputType.setPortalUsername(doc.getPortalUsername());
        docInputType.setUpdatedBy(doc.getUpdatedBy());    
        docInputType.setCreatedBy(doc.getCreatedBy());
        docInputType.setCreatedDate(DateHelper.getCalendar(doc.getCreatedDate()));
        docInputType.setUpdatedDate(DateHelper.getCalendar(doc.getUpdatedDate()));
        
        if(doc.getDocumentRoleList() != null){
            int noOfRoles = doc.getDocumentRoleList().size();
            DDocDocumentRoleInputType[] documentRoleIT = new DDocDocumentRoleInputType[noOfRoles];
            for(int i=0;i<noOfRoles;i++){
                documentRoleIT[i] = (getDocumentRoleType(doc.getDocumentRoleList().get(i)));
            }
//            docInputType.setDdocDocumentRoles(documentRoleIT);
        }
        
        return docInputType;
    }
    
    
    public DDocDocumentRoleInputType getDocumentRoleType(DdocDocumentRole docRole) {
        DDocDocumentRoleInputType type = new DDocDocumentRoleInputType();
        if(docRole!= null) {
            type.setId(docRole.getId());
            type.setPosition(docRole.getPosition());
            type.setRoleName(docRole.getRoleName());
            type.setOfficerId(docRole.getOfficer().getId());
            type.setApplicantTin(docRole.getApplicantTin());
//            type.setActionDate(DateHelper.getCalendar(docRole.getActionDate()));
        }
        return type;
    }
    
    public DdocDocumentInputType getDdocDocumentInputType(DdocDocument doc) {
        DdocDocumentInputType docInputType = new  DdocDocumentInputType();
        docInputType.setIssueDate(DateHelper.getCalendar(doc.getIssueDate()));
        docInputType.setIssuePlace(doc.getIssuePlace());
        docInputType.setItemCount(doc.getItemCount());
        docInputType.setAccountId(doc.getAccAccount());
        docInputType.setPeriodId(doc.getAccPeriod());
        docInputType.setDocStatus(doc.getDocStatus());
        docInputType.setDocType(doc.getDocType());
        docInputType.setSubmissionDate(DateHelper.getCalendar(doc.getSubmissionDate()));
        docInputType.setIssueOffice(doc.getIssueOffice());
        docInputType.setUpdatedBy(doc.getUpdatedBy());    
        docInputType.setCreatedBy(doc.getCreatedBy());
        docInputType.setCreatedDate(DateHelper.getCalendar(doc.getCreatedDate()));
        docInputType.setUpdatedDate(DateHelper.getCalendar(doc.getUpdatedDate()));
        docInputType.setId(doc.getId());
        docInputType.setDtype(doc.getDtype());
        docInputType.setReference(doc.getReference());
        docInputType.setDocStatus(doc.getDocStatus());
        return docInputType;
    }
    
    /**
     * This method takes the input of NoteType with the populated data
     * and sets to DdocNotes and returns the object with populated data.
     * <br>
     * This method throws Exception when the input type is null.
     * <br>
     * @param docNotes DdocNotes
     * @param noteType NoteType
     * @return docNotes DdocNotes
     * @throws Exception 
     */
    public  DdocNotes setNoteTypeData(DdocNotes docNotes, 
                                            NoteType noteType) throws Exception {
        if(noteType.getNoteDate() != null){
//            docNotes.setNoteDate(DateHelper.getSqlTimestamp(noteType.getNoteDate()));
        }

        if (noteType.getNotes() != null) {
            docNotes.setNotes(new String(noteType.getNotes()));
        }
        
        docNotes.setSubject(noteType.getSubject());
        
        
        if(noteType.getId() != null){
            docNotes.setId(noteType.getId());
        }
        
        if(noteType.getCreatedDate() != null){
            docNotes.setCreatedDate(DateHelper.getSqlTimestamp(noteType.getCreatedDate()));
        }
        
        return docNotes;
    } // end of method setNoteTypeData

    /**
     * This method takes the input of QueryDetailType with the populated data
     * and sets to DdocQuery and returns the object with populated data.
     * <br>
     * This method throws Exception when the input type is null.
     * <br>
     * @param docQuery DdocQuery
     * @param queryType QueryDetailType
     * @return docQuery DdocQuery
     * @throws Exception
     */
//    public  DdocQuery setQueryTypeData(DdocQuery docQuery, 
//                                             QueryDetailType queryType) throws Exception {
//                                             
////TODO: Need more info on what is needed for persist and what maps to what
//// Linked to CR 4330(31-August-2007)
//
//        if (queryType == null)
//            throw new Exception("Query Detail Type not set.");
//
//        if (docQuery == null)
//            docQuery = 
//                    MessageHelper.init(docQuery, DdocQuery.class);
//
//        //setting the properties of the entity
//        if(queryType.getQueryDate() != null){
//        docQuery.setQueryDate(DateHelper.getSqlTimestamp(queryType.getQueryDate()));
//        }
//        
//        
//        if (queryType.getQueryMessage() != null) {
//            docQuery.setQueryNotes(new String(queryType.getQueryMessage()));
//        }
//        
////        if(queryType.getQueryOfficer() != null){
////            docQuery.set
////        }
//        docQuery.setSubject(queryType.getSubject());
//        return docQuery;
//    }

    /**
     * @param dDocLodgment DdocLodgement
     * @param lodgment LodgmentInputType
     * @return dDocLodgment DdocLodgement
     * @throws Exception
     */
//    public  DdocLodgement setDdocLodgmentData(DdocLodgement dDocLodgment, 
//                                                    LodgmentInputType lodgment) throws Exception {
//        return dDocLodgment;
//    }

    /**
     * This method takes the parameters of AccountAdjustmentInputType, DfinAccAdjustment
     * and RevAcc, sets the data accordingly from the input type and RevAcc to  
     * DfinAccAdjustment and returns a populated data of the same. 
     * <br>
     * @param adjustment AccountAdjustmentInputType
     * @param finAdjustment DfinAccAdjustment
     * @return finAdjustment DfinAccAdjustment
     * @throws Exception
     */
//    public  DfinAccAdjustment setDfinAccAdjustmentData(AccountAdjustmentInputType adjustment, 
//                                                             DfinAccAdjustment finAdjustment) throws Exception {
//
//        if (adjustment == null)
//            throw new Exception("Account Adjustment Input Type not set.");
//
//       if (finAdjustment == null)
//            finAdjustment = 
//                    MessageHelper.init(finAdjustment,DfinAccAdjustment.class);
//
//        //setting the properties of the bean
//        finAdjustment.setAdjustmentDate(DateHelper.getSqlTimestamp(adjustment.getAdjustmentDate()));
//        finAdjustment.setAmount(adjustment.getAmount());
//        //Commented as part of Taxpayer adjustment module.
//        /*finAdjustment.setDescription(adjustment.getDescription());
//        finAdjustment.setAccAccount(adjustment.getRegimeAccountID());
//        finAdjustment.setPenaltyType(adjustment.getPenaltyType());
//        finAdjustment.setDescription(adjustment.getDescription());*/
//
//        return finAdjustment;
//    } // end of method setDfinAccAdjustmentData
//    
//    public DfinTransferPaymentCredit setDfinTransferPaymentCredit(TransferPaymentInputType transferPaymentInputType, 
//                                                                        DfinTransferPaymentCredit dfinTransferPaymentCredit) throws Exception {
//        if(transferPaymentInputType == null){
//            throw new Exception("Transfer Payment Input Type not set!");
//        }
//        
//        if(dfinTransferPaymentCredit == null){
//            dfinTransferPaymentCredit = MessageHelper.init(dfinTransferPaymentCredit, DfinTransferPaymentCredit.class);
//        }
//        
//        dfinTransferPaymentCredit.setAmount(transferPaymentInputType.getAmount());
//        dfinTransferPaymentCredit.setTransferType(transferPaymentInputType.getTransferType());
//        dfinTransferPaymentCredit.setTaxType(transferPaymentInputType.getTaxType());
//        dfinTransferPaymentCredit.setRevAccId(transferPaymentInputType.getRevAccID());
//        dfinTransferPaymentCredit.setRemarks(transferPaymentInputType.getRemarks());
//        dfinTransferPaymentCredit.setDDocumentId(transferPaymentInputType.getDDocDocumentID());
//        dfinTransferPaymentCredit.setPostingDate(new java.sql.Timestamp(new java.util.Date().getTime()));
//        
//        return dfinTransferPaymentCredit;
//    }
//
 
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        return setDdocDocumentDataToPojo((DdocDocument)pojo,(DdocDocumentInputType)type);
    }

    public InputType getData(BaseModelObject pojo) {
        return setDdocDocumenDateToInputType((DdocDocument)pojo,new DdocDocumentInputType());
    }

    public DocumentHeaderType getDocumentHeader(DdocDocument document) {
        DocumentHeaderType documentHeaderType = new DocumentHeaderType();
        documentHeaderType.setDocumentName(null);
        documentHeaderType.setDocumentNumber(document.getReference());
        documentHeaderType.setDocumentType(document.getDocType());
        return documentHeaderType;
    }
    
//    public DdocDocument getDdocDocumentFromReportInputType(ReportsInputType report, Long dmsId){
//        
//        DdocDocument document = null;
//             
//        /*
//         * Other reports should have different implementation 
//         * for mapping values in the DdocDocument
//         */
//        if(report instanceof TaxpayerCertificateInputType){
//           TaxpayerCertificateInputType taxpayerCert =  (TaxpayerCertificateInputType)report;
//          document=  new DdocDocument();
//           document.setId(dmsId);
//           document.setDocType(taxpayerCert.getDocType()); 
//           document.setDocStatus(taxpayerCert.getDocStatus());
//           document.setDtype(taxpayerCert.getDtype());                        
//           document.setAccAccount(taxpayerCert.getRevAcc());                                     
////           document.setTemplate(taxpayerCert.getTemplate());     
//           document.setIssueDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//           if(taxpayerCert.getDtype() != null && taxpayerCert.getReportParameters() != null){
//               ParameterType[] paramaters = taxpayerCert.getReportParameters();
//               //Appending TIN number to dType to generate Reference number
//               String reference = taxpayerCert.getDtype()+"/"+ paramaters[0].getParameterStringValue();
//               document.setReference(reference);
//           }
//            
//        }
//        if(report instanceof TaxtypeCertificateInputType){
//           TaxtypeCertificateInputType taxtypeCert =  (TaxtypeCertificateInputType)report;
//            document=  new DdocDocument();
//            document.setId(dmsId);
//           document.setDocType(taxtypeCert.getDocType()); 
//           document.setDtype(taxtypeCert.getDtype()); 
////           document.setTemplate(taxtypeCert.getTemplate());
//           document.setDocStatus(taxtypeCert.getDocStatus());
//           document.setIssueDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//           if(taxtypeCert.getDtype() != null && taxtypeCert.getReportParameters() != null){
//               ParameterType[] paramaters = taxtypeCert.getReportParameters();
//               //Appending TIN number to dType to generate Reference number
//               String reference = taxtypeCert.getDtype()+"/"+ paramaters[0].getParameterStringValue();
//               document.setReference(reference);
//           }
//            
//        }
//        
//
//        
//        MessageHelper[] helpers = new MessageHelper[] { this };
//        setAssociationData(document, report.getReportParameters(), 
//                           document.getDdocCorrespondenceParamList(), 
//                           getParamAssociationHelper(), helpers);
//
//                    
//        return document;
//        
//    }
    
//    public void setCorresParamData(DdocCorrespondenceParams corresParam, 
//                                  ParameterType inputType) {
//
//        corresParam.setParamName(inputType.getParameterKey());
//        corresParam.setParamValue(inputType.getParameterStringValue());
//    
//    }
    
    public void setDocumentRoleData(DdocDocumentRole role, 
                                  DDocDocumentRoleInputType inputType) {

        role.setId(inputType.getId());
        role.setApplicantTin(inputType.getApplicantTin());
//        role.setActionDate(DateHelper.getSqlTimestamp(inputType.getActionDate()));
        role.setPosition(inputType.getPosition());
        role.setRoleName(inputType.getRoleName());
        role.setOfficer(em.find(RefOffStaff.class, inputType.getOfficerId()));
    }
    
//    public ComplexAssociationHelper getParamAssociationHelper() {
//        return new ComplexAssociationHelper() {
//
//             public void add(BaseModelObject parent, 
//                             BaseModelObject child) {
//                 if (((DdocDocument)parent).getDdocCorrespondenceParamList() == null) {
//                     ((DdocDocument)parent).setDdocCorrespondenceParamList(new ArrayList<DdocCorrespondenceParams>());
//                 }
//
//                 ((DdocDocument)parent).addDdocCorrespondenceParam((DdocCorrespondenceParams)child);
//
//             }
//
//             public void remove(BaseModelObject parent, 
//                                BaseModelObject child) {
//                 ((DdocDocument)parent).removeDdocCorrespondenceParam((DdocCorrespondenceParams)child);
//             }
//
//             public Class getChildPojoClass() {
//                 return DdocCorrespondenceParams.class;
//             }
//
//             public Class getMessageHelperClass() {
//                 return DocumentMessageHelper.class;
//             }
//
//             public void setData(InputType messageChild, 
//                                 BaseModelObject newChildPojo, 
//                                 MessageHelper messageHelper) {
//                 ((DocumentMessageHelper)messageHelper).setCorresParamData((DdocCorrespondenceParams)newChildPojo, 
//                                                                               (ParameterType)messageChild);
//             }
//
//             public Boolean compare(InputType messageChild, 
//                                    BaseModelObject pojo) {
//                 if (messageChild.getId() == null || 
//                     ((DdocCorrespondenceParams)pojo).getId() == null) {
//                     return null; //return null because cannot compare
//                 } else {
//                     return messageChild.getId().equals(((DdocCorrespondenceParams)pojo).getId());
//                 }
//             }
//         };
//    }
    
    
    public ComplexAssociationHelper getDocumentRoleAssociationHelper() {
        return new ComplexAssociationHelper() {

             public void add(BaseModelObject parent, 
                             BaseModelObject child) {
                 if (((DdocDocument)parent).getDocumentRoleList() == null) {
                     ((DdocDocument)parent).setDocumentRoleList(new ArrayList<DdocDocumentRole>());
                 }

                 ((DdocDocument)parent).addDdocDocumentRole((DdocDocumentRole)child);

             }

             public void remove(BaseModelObject parent, 
                                BaseModelObject child) {
                 ((DdocDocument)parent).removeDdocDocumentRole((DdocDocumentRole)child);
             }

             public Class getChildPojoClass() {
                 return DdocDocumentRole.class;
             }

             public Class getMessageHelperClass() {
                 return DocumentMessageHelper.class;
             }

             public void setData(InputType messageChild, 
                                 BaseModelObject newChildPojo, 
                                 MessageHelper messageHelper) {
                 ((DocumentMessageHelper)messageHelper).setDocumentRoleData((DdocDocumentRole)newChildPojo, 
                                                                               (DDocDocumentRoleInputType)messageChild);
             }

             public Boolean compare(InputType messageChild, 
                                    BaseModelObject pojo) {
                 if (messageChild.getId() == null || 
                     ((DdocDocumentRole)pojo).getId() == null) {
                     return null; //return null because cannot compare
                 } else {
                     return messageChild.getId().equals(((DdocDocumentRole)pojo).getId());
                 }
             }
         };
    }
    
    
   
    
} // end of DocumentMessageHelper class
