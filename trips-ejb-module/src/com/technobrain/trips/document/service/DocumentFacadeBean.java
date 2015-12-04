package com.technobrain.trips.document.service;

//import com.crownagents.trips.casemanagement.service.CaseManagementFacadeLocal;
//import com.crownagents.trips.document.messagehelper.DfinReceiptMessageHelper;
//import com.crownagents.trips.reports.message.ReportsInputType;
import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
//import com.crownagents.trips.collection.message.PaymentInputType;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.core.message.DdocDocumentInputType;
import com.technobrain.trips.core.message.DocumentHeaderType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.messagehelper.DfinDocumentMessageHelper;
import com.technobrain.trips.document.model.DdocBalananceView;
import com.technobrain.trips.document.model.DdocCurrencyAndRate;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.document.model.DdocDocumentError;
import com.technobrain.trips.document.model.DdocDocumentLink;
import com.technobrain.trips.document.model.DdocEntityDocRel;
import com.technobrain.trips.document.model.DdocHistory;
import com.technobrain.trips.document.model.DdocInspection;
import com.technobrain.trips.document.model.DdocInstruction;
import com.technobrain.trips.document.model.DdocItemLink;
import com.technobrain.trips.document.model.DdocNotes;
import com.technobrain.trips.document.model.DdocTransactionSummaryView;
import com.technobrain.trips.document.model.DfinBadChequeRegister;
import com.technobrain.trips.document.model.DfinDocument;
import com.technobrain.trips.document.model.DfinRevCollInstrument;
import com.technobrain.trips.document.model.DfinRevCollReceipt;
import com.technobrain.trips.document.model.DitemItem;
import com.technobrain.trips.document.model.DtaxHeader;
import com.technobrain.trips.document.model.DtaxItem;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.dto.registration.EntityHistory;
import com.technobrain.trips.dto.tax.TaxRefunds;
import com.technobrain.trips.dto.tax.accounting.GenericRegimeDocumentSummaryBean;
import com.technobrain.trips.dto.tax.accounting.GenericRegimeDocumentTransactionSummaryBean;
import com.technobrain.trips.dto.tax.accounting.GenericTransactionPeriodBean;
import com.technobrain.trips.dto.tax.accounting.PaymentSummaryInquiry;
import com.technobrain.trips.dto.tax.accounting.TaxCreditRefundExcessPaymentsBean;
import com.technobrain.trips.dto.tax.accounting.TaxCreditRefundSummaryBean;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.reference.model.RefOffice;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeLocal;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.sql.DataSource;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

//import oracle.toplink.essentials.config.CacheUsage;
//import oracle.toplink.essentials.config.HintValues;
//import oracle.toplink.essentials.config.TopLinkQueryHints;


//import com.crownagents.trips.returns.model.DfinAssessment;


@Stateless(name = "DocumentFacade",mappedName="DocumentFacade")
public class DocumentFacadeBean extends FacadeBean implements DocumentFacadeLocal, 
                                                              DocumentFacadeRemote {
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;

    @Resource(name = JndiConstants.DATA_SOURCE_JNDI)
    DataSource ds;

    @EJB
    RefCodeAssemblerSessionEJBLocal refCodeFacade;

    @EJB
    RevenueAccountFacadeLocal revenueFacade;

//    @EJB
//    CaseManagementFacadeLocal caseManagement;

    public DocumentFacadeBean() {
    }

    /** <code>select o from DdocDocument o</code> */
    public List<DdocDocument> queryDdocDocumentFindAll() {
        return em.createNamedQuery("DdocDocument.findAll").getResultList();
    }

    public void removeDdocDocument(DdocDocument ddocDocument) {
        ddocDocument = em.find(DdocDocument.class, ddocDocument.getId());
        em.remove(ddocDocument);
    }

    /** <code>select o from DdocDocumentError o</code> */
    public List<DdocDocumentError> queryDdocDocumentErrorFindAll() {
        return em.createNamedQuery("DdocDocumentError.findAll").getResultList();
    }

    public void removeDdocDocumentError(DdocDocumentError ddocDocumentError) {
        ddocDocumentError = 
                em.find(DdocDocumentError.class, ddocDocumentError.getId());
        em.remove(ddocDocumentError);
    }

    /** <code>select o from DdocDocumentLink o</code> */
    public List<DdocDocumentLink> queryDdocDocumentLinkFindAll() {
        return em.createNamedQuery("DdocDocumentLink.findAll").getResultList();
    }

    public void removeDdocDocumentLink(DdocDocumentLink ddocDocumentLink) {
        ddocDocumentLink = 
                em.find(DdocDocumentLink.class, ddocDocumentLink.getId());
        em.remove(ddocDocumentLink);
    }

    /** <code>select o from DdocEntityDocRel o</code> */
    public List<DdocEntityDocRel> queryDdocEntityDocRelFindAll() {
        return em.createNamedQuery("DdocEntityDocRel.findAll").getResultList();
    }

    public void removeDdocEntityDocRel(DdocEntityDocRel ddocEntityDocRel) {
        ddocEntityDocRel = 
                em.find(DdocEntityDocRel.class, ddocEntityDocRel.getId());
        em.remove(ddocEntityDocRel);
    }

    /** <code>select o from DdocHistory o</code> */
    public List<DdocHistory> queryDdocHistoryFindAll() {
        return em.createNamedQuery("DdocHistory.findAll").getResultList();
    }

    public void removeDdocHistory(DdocHistory ddocHistory) {
        ddocHistory = em.find(DdocHistory.class, ddocHistory.getId());
        em.remove(ddocHistory);
    }

    /** <code>select o from DdocInspection o</code> */
    public List<DdocInspection> queryDdocInspectionFindAll() {
        return em.createNamedQuery("DdocInspection.findAll").getResultList();
    }

    public void removeDdocInspection(DdocInspection ddocInspection) {
        ddocInspection = em.find(DdocInspection.class, ddocInspection.getId());
        em.remove(ddocInspection);
    }

    /** <code>select o from DdocInstruction o</code> */
    public List<DdocInstruction> queryDdocInstructionFindAll() {
        return em.createNamedQuery("DdocInstruction.findAll").getResultList();
    }

    public void removeDdocInstruction(DdocInstruction ddocInstruction) {
        ddocInstruction = 
                em.find(DdocInstruction.class, ddocInstruction.getId());
        em.remove(ddocInstruction);
    }

    /** <code>select o from DdocItemLink o</code> */
    public List<DdocItemLink> queryDdocItemLinkFindAll() {
        return em.createNamedQuery("DdocItemLink.findAll").getResultList();
    }

    public void removeDdocItemLink(DdocItemLink ddocItemLink) {
        ddocItemLink = em.find(DdocItemLink.class, ddocItemLink.getId());
        em.remove(ddocItemLink);
    }

    /** <code>select o from DitemItem o</code> */
    public List<DitemItem> queryDitemItemFindAll() {
        return em.createNamedQuery("DitemItem.findAll").getResultList();
    }

    public void removeDitemItem(DitemItem ditemItem) {
        ditemItem = em.find(DitemItem.class, ditemItem.getId());
        em.remove(ditemItem);
    }

    /** <code>select o from DtaxHeader o</code> */
    public List<DtaxHeader> queryDtaxHeaderFindAll() {
        return em.createNamedQuery("DtaxHeader.findAll").getResultList();
    }

    public void removeDtaxHeader(DtaxHeader dtaxHeader) {
        dtaxHeader = em.find(DtaxHeader.class, dtaxHeader.getId());
        em.remove(dtaxHeader);
    }

    /** <code>select o from DtaxItem o</code> */
    public List<DtaxItem> queryDtaxItemFindAll() {
        return em.createNamedQuery("DtaxItem.findAll").getResultList();
    }

    /**
     * Looks up the tax items for which the tax has already been calculated and 
     * persisted
     * <br>
     * @param dItem
     * @return dTaxItem DtaxItem
     */
    public List<DtaxItem> queryDtaxItemByItem(Long dItem) {
        Query qryTaxItems = null;
        qryTaxItems = 
                em.createQuery("select o from DtaxItem o " + "where o.dItem = ?1").setHint(QueryHints.REFRESH, 
                                                                                           HintValues.TRUE).setParameter(1, 
                                                                                                                         dItem);
        return qryTaxItems.getResultList();
    }


    public void removeDtaxItem(DtaxItem dtaxItem) {
        dtaxItem = em.find(DtaxItem.class, dtaxItem.getId());
        em.remove(dtaxItem);
    }




    /**
     * The method is used to fetch the entity history with the RefDocStatus code having viewInHistory falg set to 'Y'.
     * @param entityId
     * @return
     */
    public List<EntityHistory> findEntityHistory(Long entityId) {
        try {
                        List<EntityHistory> resultSet = 
                em.createQuery("select new com.technobrain.trips.dto.registration.EntityHistory(dd.updatedDate, es.description, dd.updatedBy, " +
                "rs.description) from EntEntity ee, DdocDocument dd, RefDocStatus rs, AppApplication app, RefEventStatus es where dd.id = app.id and app.entity.id = ee.id " +
                "and rs.code = dd.docStatus and dd.dtype=es.code and ee.id = ?1 and rs.viewInHistory=?2").setParameter(1,entityId).setParameter(2,Constants.YES).getResultList(); 
            
            
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<EntityHistory>();
        }
    }
    
    /**
     * Delete any existing header taxes for a customs declaration
     * @param id
     */
    public void deleteHeaderTaxes(Long id) {
        Query qryDeleteHeaderTaxes = 
            em.createQuery("delete from DtaxHeader h where h.documentId = ?1").setParameter(1, 
                                                                                            id);
        int headerDeleteCount = qryDeleteHeaderTaxes.executeUpdate();
    }

    public List<DdocNotes> findDocumentNotes(Long id) {
        try {
            List<DdocNotes> resultSet = 
                em.createQuery("select n from DdocNotes n where n.ddocDocument.id = ?1").setParameter(1, 
                                                                                                      id).getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<DdocNotes>();
        }
    }

    public void deleteNotes(DdocNotes docNotes) {

        Query qryDeleteNotes = 
            em.createQuery("delete from DdocNotes i where i.id = ?1").setParameter(1, 
                                                                                   docNotes.getId());
        int noteDeleteCount = qryDeleteNotes.executeUpdate();
        em.flush();

    }


    /**
     * Delete any existing item taxes for a customs declaration
     * @param id
     */
    public void deleteItemTaxes(Long id) {
        //        Query qryDeleteItemTaxes = 
        //                    em.createQuery("select i from DitemItem i where i.ddocDocument1.id = ?1").setParameter(1,
        //                                                                                                    id);
        Query qryDeleteItemTaxes = 
            em.createQuery("select i from DtaxItem i where i.id = ?1").setParameter(1, 
                                                                                    id);
        //        List<DitemItem> diteItemList = qryDeleteItemTaxes.getResultList();
        DtaxItem taxItem = (DtaxItem)qryDeleteItemTaxes.getSingleResult();
        try {
            //            for (DitemItem item: diteItemList){
            em.remove(taxItem);

            //            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }


        //        Query qryDeleteItemTaxes = 
        //            em.createQuery("delete from DitemItem i where i.ddocDocument1.id = ?1").setParameter(1, 
        //                                                                                            id);
        //        int itemDeleteCount = qryDeleteItemTaxes.executeUpdate();
    }

    /**
     * Delete any existing item taxes for a customs declaration
     * @param id
     */
    public String deleteItemTaxes(Long id, String code) {
        Query qryDeleteItemTaxes = 
            em.createQuery("select i from DtaxItem i where i.dItem = ?1 and i.taxType=?2").setParameter(1, 
                                                                                                        id).setParameter(2, 
                                                                                                                         code);
        //        List<DitemItem> diteItemList = qryDeleteItemTaxes.getResultList();
        List<DtaxItem> taxItemList = qryDeleteItemTaxes.getResultList();
        try {
            for (DtaxItem item: taxItemList) {
                em.remove(item);
            }
            return "T";

        } catch (javax.persistence.NoResultException e) {
            return null;
        }

    }


    public DdocInspection findDocumentInspectionById(Long id) {
        //        return em.find(DdocInspection.class, id);
        DdocInspection ddocInspection = null;
        try {
            ddocInspection = 
                    (DdocInspection)em.createQuery("select d from DdocInspection d where d.id = ?1").setHint(QueryHints.REFRESH, 
                                                                                                             HintValues.TRUE).setParameter(1, 
                                                                                                                                           id).getSingleResult();

            //            em.refresh(ddocInspection);

        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return ddocInspection;
        }

        return ddocInspection;
    }
//TODO - RevAccCleanup
    /**
     * Get any RevAcc object of a particular entity and type
     * @param entEntity Object
     * @param acctNo Object
     * @return RevAcc
     */
//    public RevAcc findRevAccByEntEntityId(Object entEntity, 
//                                          Object acctNo) throws ObjectNotFoundException {
//        Query qry = 
//            em.createQuery("select object(o) from RevAcc o where o.entEntity = ?1 and o.acctNo = ?2").setParameter("1", 
//                                                                                                                   entEntity).setParameter("2", 
//                                                                                                                                           acctNo.toString());
//        if (qry.getSingleResult() == null) {
//            throw new ObjectNotFoundException(Constants.ExceptionHandling.NORESULT + 
//                                              Constants.ExceptionHandling.SEARCH_CRITERIA);
//        }
//        return (RevAcc)qry.getSingleResult();
//    }

//    public PaymentInputType findPaymentReceiptByTrans(Long transactionId) {
//        DfinRevCollReceipt dfinRevCollReceipt = 
//            revenueFacade.findReceiptIdByTrans(transactionId);
//        if (null == dfinRevCollReceipt) {
//            return null;
//        }
//        return findPaymentReceipt(dfinRevCollReceipt.getId());
//    }
//
//    public PaymentInputType findPaymentReceipt(Long receiptId) {
//        PaymentInputType payInput = null;
//        try {
//            DfinRevCollReceipt receiptEntity = (DfinRevCollReceipt)em.createNamedQuery("DfinRevCollReceipt.findById").setParameter(1, receiptId).getSingleResult();
////            DfinReceiptMessageHelper mh = new DfinReceiptMessageHelper();
////            mh.setEm(em);
////            payInput = mh.getPaymentInputType(receiptEntity);
//            return payInput;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        
//    }

    public Long findDeclarationIDByRevInvoice(Long revInvoiceId) {
        return (Long)em.createQuery("select t.ddocDocument from RevledTransaction t where t.id = ?1").setParameter(1, 
                                                                                                                   revInvoiceId).getSingleResult();
    }

    public String findDeclarationByCustRef(String referenceNumber) {
        try {
            String value = 
                (String)em.createQuery("select cd.customsReference from DdecCargoDeclaration cd where cd.customsReference = ?1").setParameter(1, 
                                                                                                                                              referenceNumber).getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

//    /** <code>select o from DfinRefundClaim o</code> */
//    public List<DfinRefundClaim> queryDfinRefundClaimFindAll() {
//        return em.createNamedQuery("DfinRefundClaim.findAll").getResultList();
//    }
//
//    public void removeDfinRefundClaim(DfinRefundClaim dfinRefundClaim) {
//        dfinRefundClaim = 
//                em.find(DfinRefundClaim.class, dfinRefundClaim.getId());
//        em.remove(dfinRefundClaim);
//    }

//TODO - RevAccCleanup
    /**
     * Get List of  RevAcc object of a particular entity and revenue type
     * @param revenueType Object
     * @return RevAcc
     */
//    public List<RevAcc> findRevAccByTypeAndStatus(Object revenueType) throws ObjectNotFoundException {
//        Query qry = 
//            em.createQuery("select object(o) from RevAcc o where o.revType.code = ?1 and o.status = ?2");
//        qry.setParameter("1", revenueType);
//        qry.setParameter("2", "A");
//
//        if (qry.getResultList() == null) {
//            throw new ObjectNotFoundException(Constants.ExceptionHandling.NORESULT + 
//                                              Constants.ExceptionHandling.SEARCH_CRITERIA);
//        }
//        return qry.getResultList();
//    }

    /**
     * Get List of  RevledRevPeriod object of a particular RevAcc 
     * @param revAccId Object
     * @return RevledRevPeriod
     */
    public List findRevledRevPeriodByRevAccId(Long revAccId, Integer periodNo, 
                                              String periodYear) throws ObjectNotFoundException {
        try {
            Query qry = 
                em.createQuery("select object(o) from AccountPeriod o where o.accAccountId = ?1 and o.periodNo=?2 and o.periodYear=?3");
            qry.setParameter("1", revAccId);
            qry.setParameter("2", periodNo);
            qry.setParameter("3", periodYear);
            return qry.getResultList();
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }

    }

    public Long findArrayIdFromDitemItem(DdocDocument document, Long ItemRef) {
        try {
            Query qry = 
                em.createQuery("select o.id from DitemDecItem o join o.ddecCargoDeclaration d where d.id = ?1 and o.itemNumber=?2");
            qry.setParameter("1", document.getId());
            qry.setParameter("2", ItemRef);
            List l = qry.getResultList();
            if (l != null) {
                if (l.size() > 0) {
                    return (Long)l.get(0);
                }
            }
            return null;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }

    }

    public List<CodeAndDescription> findDocumentErrors(Long docId) {
        try {
            List<CodeAndDescription> result = 
                em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.code,obj.description,obj.createdDate) " + 
                               "from DdocDocumentError obj join obj.ddocDocument d where d.id = ?1 ").setParameter(1, 
                                                                                                                   docId).getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }


    //    public List<DocumentTaxSummary> findDocumentTaxes(Long documentId) {
    //        try {
    //            List<DocumentTaxSummary> resultSet = 
    //                (List<DocumentTaxSummary>)em.createQuery(
    //                "select new com.crownagents.trips.dto.customs.DocumentTaxSummary(docTax.taxCode,docTax.taxBase," + 
    //                "docTax.taxAmount,docTax.taxRate) " +
    //                "from DtaxHeader docTax where docTax.documentId = ?1 ").setParameter(1,documentId).getResultList();
    //            return resultSet;
    //        } catch (javax.persistence.NoResultException e) {
    //            return null;
    //        }
    //    }
//TODO - RevAccCleanup
//    public RevAcc findRevAccByEntEntityIdAndRegimeNumber(Long entityId, 
//                                                         Long documentId) {
//
//        Object accountNumber = 
//            em.createQuery("select o.revAcc from DdocDocument o where o.id = ?1").setParameter("1", 
//                                                                                               documentId).getSingleResult();
//
//        Query qry = 
//            em.createQuery("select object(o) from RevAcc o where o.id = ?1").setParameter("1", 
//                                                                                          accountNumber);
//        if (qry.getSingleResult() == null) {
//            return null;
//        }
//        return (RevAcc)qry.getSingleResult();
//    }
//TODO - RevAccCleanup
//    public List<CodeAndDescription> findAllPeriodsByEntEntityIdAndRegimeNumber(Long entityId, 
//                                                                               Long documentId) {
//        RevAcc account = 
//            findRevAccByEntEntityIdAndRegimeNumber(entityId, documentId);
//        if (account == null)
//            return null;
//        return refCodeFacade.findAllPeriodByRegAcc(account.getId());
//    }


    public DocumentHeaderType getDocumentHeaderType(Long periodId, 
                                                    Long accountId) {

        try {
            DdocDocument ddocDocument = 
                findDocumentByPeriodAndAccount(periodId, accountId);
            return ddocDocument.getDataDocumentHeaderType();
        } catch (NoResultException e) {
            return null;
        }

    }

    //    public List<RevledTransaction> findPaymentSpread(Long docID) {
    //        List<RevledTransaction> revledTran = null; 
    //        revledTran = 
    //                em.createQuery("Select dfinRevCollSpread from DfinRevCollSpread dfinRevCollSpread where dfinRevCollSpread.ddocDocument=?1").setParameter(1, 
    //                                                                                                                        docID).getResultList();
    //        return revledTran;
    //    }

    public String findDeclarationRefByDecId(Long decId) {
        try {
            String decRef = 
                (String)em.createQuery("select cd.customsReference from DdecCargoDeclaration cd where cd.id = ?1").setParameter(1, 
                                                                                                                                decId).getSingleResult();
            return decRef;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<TaxRefunds> findRefundByRefundId(Long refundId) {
        try {
            List<TaxRefunds> resultSet = 
                (List<TaxRefunds>)em.createQuery("select new com.technobrain.trips.dto.tax.TaxRefunds(dr.id,dr.claimDate,ra.revType.code," + 
                                                 "ra.acctNo,dr.periodFrom,ra.acctBal,dr.claimAmount) from DfinRefundClaim dr,RevAcc ra " + 
                                                 "where dr.revAcc = ra.id and dr.id = ?1 and dr.docStatus= ?2 ").setParameter(1, 
                                                                                                                              refundId).setParameter(2, 
                                                                                                                                                     Constants.DocStatus.SUB).getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    /**
     * Find the refunds belong to an entity with the specified document status.
     * If no status is given then all the statuses are returned back.
     * 
     * @param entityId
     * @param docStatus
     * @return
     */
    public List<TaxRefunds> findRefundsByEntityIdAndStatus(Long entityId, 
                                                           String docStatus) {
        try {

            List resultSet;

            //There is no way to use left outer join in EJB QL for non related objects
            //As a result Native query usage is mandatory
            String nativeSQLQueryString = 
                "select dr.id,dr.claim_Date,rrt.code," + 
                "  ra.acct_No,dr.period_From,ra.acct_Bal," + 
                "  dr.claim_Amount,dd.doc_Status,rrp1.period_No," + 
                "  rrp1.period_Year,rrp2.period_No,rrp2.period_Year " + 
                "from Dfin_Refund_Claim dr" + 
                "     left outer join Revled_Rev_Period rrp1 on rrp1.ID = dr.period_From" + 
                "     left outer join Revled_Rev_Period rrp2 on rrp2.ID = dr.period_To, " + 
                "     Rev_Acc ra, Ddoc_Document dd, Ref_Rev_Type rrt " + 
                "where dr.ID = dd.id and dd.Rev_Acc=ra.id " + 
                "     and rrt.code=ra.revenue_type  and ra.ent_Entity=?1";
            if (docStatus != null) {
                //Status is provided then return the records having the status given
                nativeSQLQueryString = 
                        nativeSQLQueryString + " and dd.doc_Status= ?2";
                resultSet = 
                        em.createNativeQuery(nativeSQLQueryString).setParameter(1, 
                                                                                entityId).setParameter(2, 
                                                                                                       docStatus).getResultList();

            } else {
                //No status is given then return all the records
                resultSet = 
                        em.createNativeQuery(nativeSQLQueryString).setParameter(1, 
                                                                                entityId).getResultList();
            }


            //Since TaxRefunds is not an entity class it can not be used in
            //em.createNativeQuery(String, Class) method.
            //em.createNativeQuery(String) is used and the result should be
            //wrapped to the TaxRefunds.

            List<TaxRefunds> wrappedRefundData = new ArrayList<TaxRefunds>();
            for (Object obj: resultSet) {
                Vector vector = (Vector)obj;

                Long documentID = 
                    vector.get(0) != null ? ((BigDecimal)vector.get(0)).longValue() : 
                    null;
                BigDecimal amountClaimed = 
                    vector.get(6) != null ? ((BigDecimal)vector.get(6)) : 
                    null;

                TaxRefunds taxRefund = new TaxRefunds(documentID, (Timestamp)vector.get(1), 
                                                   (String)vector.get(2), 
                                                   (String)vector.get(3), 
                                                   (String)vector.get(4), 
                                                   (BigDecimal)vector.get(5), amountClaimed, 
                                                   (String)vector.get(7), 
                                                   (BigDecimal)vector.get(8), 
                                                   (String)vector.get(9), 
                                                   (BigDecimal)vector.get(10), 
                                                   (String)vector.get(11));

                wrappedRefundData.add(taxRefund);
            }
            return wrappedRefundData;

        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<TaxRefunds>();
        }
    }

    public DtaxItem findTaxByItemAndCode(Long itemId, String taxCode) {
        try {
            return (DtaxItem)em.createQuery("select o from DtaxItem o where o.ditemItem.id=?1 and o.taxCode=?2").setParameter(1, 
                                                                                                                              itemId).setParameter(2, 
                                                                                                                                                   taxCode);
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * Returns the applicable period to which a document can be posted to, 
     * based on tax type, taxpayer id and submission date. 
     * 
     * For Customs if there is no period a period is generated automatically.
     * 
     * Example: taxpayerId=1, taxType=Customs, submissionDate=20/1/2008,
     * returns the period to which the document can be applied to 
     * 
     * @param accountInputType
     * @return
     */
//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public ApplyInformationOutputType applyInformation(AccountInputType accountInputType) {
//        //included for testing purposes
//        //        accountInputType = new AccountInputType();
//        //        accountInputType.setTaxpayerId(new Long(1));
//        //        accountInputType.setTaxType("CUSTOMS");
//        //        accountInputType.setSubmissionDate(Calendar.getInstance());
//
//        ApplyInformationOutputType output = new ApplyInformationOutputType();
//
//        output.setHasErrors(false);
//        output.setHasWarnings(false);
//        output.setHasMessages(false);
//        //get the applicable period based on the input information
//        RevledRevPeriod revLedPeriod = 
//            findApplicablePeriodNumber(accountInputType.getTaxpayerId(), 
//                                       accountInputType.getTaxType(), 
//                                       accountInputType.getSubmissionDate());
//
//        if (revLedPeriod != null) {
//            output.setPeriodId(revLedPeriod.getId());
//            output.setId(revLedPeriod.getRevAcc());
//            output.setReturnStatus(Constants.PASS);
//        } else if (Constants.Regimes.CUSTOMS.equals(accountInputType.getTaxType())) {
//
//            //For Customs if there is no period generate a period for the entire year
//            //For Customs if there is no period generate a period for the entire year
//            PeriodType periodType = new PeriodType();
//
//            periodType.setRegimeType(Constants.Regimes.CUSTOMS);
//
//            Calendar calendar = Calendar.getInstance();
//
//            periodType.setPeriodYear(calendar.get(Calendar.YEAR));
//            periodType.setPeriodNo(1);
//
//            //Set period start to start day of current year
//            calendar.setTime(DateHelper.getDate(1, 1, 
//                                                calendar.get(Calendar.YEAR)));
//            periodType.setPeriodStart(calendar);
//            log.debug(periodType.getPeriodStart());
//
//            //No need for period end return due dates for customs
//            periodType.setPeriodEnd(null);
//            periodType.setReturnDue(null);
//
//            calendar = Calendar.getInstance();
//            calendar.setTime(DateHelper.getDate(1, 1, 
//                                                calendar.get(Calendar.YEAR) + 
//                                                1));
//            periodType.setPaymentDue(calendar);

            //find the revenue account based on taxpayer id, tax type and registered status
            //TODO: potential problem when dual tax types exist for an entity 
            // and both are registered
//TODO - RevAccCleanup
//            RevAcc revAcc = 
//                revenueFacade.findRevAccByRevTypeAndAccStatus(accountInputType.getTaxpayerId(), 
//                                                              accountInputType.getTaxType(), 
//                                                              Constants.Regimes.REGISTER);
//            periodType.setRegimeAccountId(revAcc.getId());
//            RevenueMessageHelper revenueMessageHelper = 
//                new RevenueMessageHelper();
//            RevledRevPeriod newRevPeriod = new RevledRevPeriod();
//            newRevPeriod = 
//                    revenueMessageHelper.setRevledRevPeriodData(newRevPeriod, 
//                                                                periodType);
//            newRevPeriod.setRevAcc(revAcc.getId());
//            newRevPeriod.setPeriodstatus(Constants.RevPeriodStatus.CREATED);
//
//            newRevPeriod = saveOrUpdate(newRevPeriod);
//            output.setPeriodId(newRevPeriod.getId());
//            output.setId(newRevPeriod.getRevAcc());
//            output.setReturnStatus(Constants.PASS);
//        } else {
//            output.setReturnStatus(Constants.FAIL);
//        }

//        return output;
//    }

    /**
     * This method returns a period object which is the applicable period 
     * based on taxpayerId, taxType and the submission date of the document.
     * 
     * @param taxpayerId
     * @param taxType
     * @param submissionDate
     * @return RevledRevPeriod
     */
//TODO - RevledRevPeriod/RevledTransactionCleanup
//    public RevledRevPeriod findApplicablePeriodNumber(Long taxpayerId, 
//                                                      String taxType, 
//                                                      Calendar submissionDate) {
//        try {
            //find the revenue account based on taxpayer id, tax type and registered status
            //TODO: potential problem when dual tax types exist for an entity 
            // and both are registered
//TODO - RevAccCleanup
//            RevAcc revAcc = 
//                revenueFacade.findRevAccByRevTypeAndAccStatus(taxpayerId, 
//                                                              taxType, 
//                                                              Constants.Regimes.REGISTER);
//            //get the lost of applicable periods based on the revenue account
//            List<RevledRevPeriod> periodsAvailable = 
//                revenueFacade.findAllApplicablePeriods(revAcc);
//            //loop through all the periods and find the most applicable
//            for (RevledRevPeriod period: periodsAvailable) {
//                //TODO: perhaps better way is to get only active periods
//                if (period.getStatus().equalsIgnoreCase(Constants.RecordStatus.ACTIVE)) {
//                    Calendar periodStart = 
//                        DateHelper.getCalendar(period.getPeriodStart());
//                    Calendar periodEnd = 
//                        DateHelper.getCalendar(period.getPeriodEnd());
//
//                    boolean afterPeriodStart = 
//                        submissionDate.after(periodStart);
//                    boolean beforePeriodEnd = 
//                        null == periodEnd ? true : submissionDate.before(periodEnd);
//                    //submission date has to be between start and end to be valid period
//                    if (afterPeriodStart && beforePeriodEnd) {
//                        return period;
//                    }
//                }
//            }
//        } catch (NoResultException nre) {
//            nrlog.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return null;
//    }

    public DdocDocument findDocumentByPeriodAndAccount(Long periodId, 
                                                       Long accountId) {
        try {
            DdocDocument ddocDocument = 
                (DdocDocument)em.createQuery("select o from DdocDocument o where o.revledRevPeriod = ?1 and o.revAcc = ?2").setParameter("1", 
                                                                                                                                         periodId).setParameter("2", 
                                                                                                                                                                accountId).getSingleResult();
            return ddocDocument;
        } catch (NoResultException e) {
            return null;
        }
    }

//    public DdocDocument generateDocument(ReportsInputType reportInput, 
//                                         Long documentManagmentId) {
//
//        DocumentMessageHelper helper = 
//            (DocumentMessageHelper)initializeMessageHelper(DocumentMessageHelper.class);
//
//        DdocDocument document = new DdocDocument();
//        //If documentManagmentId is not null, gets the DdocDocument object based on create query to update the record.
//        if (documentManagmentId != null) {
//            document = 
//                    (DdocDocument)em.createQuery("select o from DdocDocument o where o.id=?1").setParameter(1, 
//                                                                                                            documentManagmentId).getSingleResult();
//        } else {
//        //If documentManagmentId is null, creates DdocDocument object and saves the record.
//            document = 
//                    helper.getDdocDocumentFromReportInputType(reportInput, documentManagmentId);
//        }
//
////        document.markPrinted();
//        try{
//        document = saveOrUpdate(document);
//        }catch(Exception e){
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return document;
//
//    }

    public boolean computeExcessPayments(Long entityId, String taxType, Timestamp startDate, Timestamp endDate) {

        boolean hasExcessPayments = false;
        try {

            String sql = null;  //TODO - RevledRevPeriod/RevledTransactionCleanup
             //TODO - RevledRevPeriod/RevledTransactionCleanup
//            String sql ="select new com.crownagents.trips.dto.tax.accounting." + 
//                                 "TaxCreditRefundExcessPaymentsBean(rlt.transactionType, rlt.amount, rlt.balance, rrt.code, rtt.accTran, rtt.accTranSign) " + 
//                                 "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                 "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                 "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate";

            Query query = em.createQuery(sql);
            query.setParameter("entityID", entityId)
            .setParameter("revenueType", taxType)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate);

            List<TaxCreditRefundExcessPaymentsBean> results = 
                query.getResultList();

            BigDecimal otherTransactionTypesDebit = new BigDecimal(0);
            BigDecimal otherTransactionTypesCredit = new BigDecimal(0);
            BigDecimal payments = new BigDecimal(0);
            
            if (results != null) {
                for (TaxCreditRefundExcessPaymentsBean paymentBean: results) {
                    if (!paymentBean.getTransactionType().equalsIgnoreCase(Constants.TransactionType.PAYMENT)) {
                        if (paymentBean.getAcctTran().equalsIgnoreCase(Constants.AccountingType.DEBIT)) {
                            otherTransactionTypesDebit = otherTransactionTypesDebit.add(paymentBean.getAmount());
                        } else if (paymentBean.getAcctTran().equalsIgnoreCase(Constants.AccountingType.CREDIT)) {
                            otherTransactionTypesCredit = otherTransactionTypesCredit.add(paymentBean.getAmount());
                        }
                    } else {
                        payments = payments.add(paymentBean.getAmount());
                    }
                }
            }
            
            if (payments.equals(new BigDecimal(0))) {
                return hasExcessPayments;
            }
            
            if (otherTransactionTypesDebit.equals(new BigDecimal(0))) {
                return hasExcessPayments;
            }
            
            if (otherTransactionTypesDebit.doubleValue() >= otherTransactionTypesCredit.doubleValue()) {
                BigDecimal result = new BigDecimal(0);
                result = otherTransactionTypesCredit.subtract(otherTransactionTypesDebit);
                BigDecimal excessPayments = new BigDecimal(0);
                excessPayments = payments.subtract(result);
                if (excessPayments.doubleValue() > 0) {
                    hasExcessPayments = true;
                    return hasExcessPayments;
                } else {
                    hasExcessPayments = false;
                    return hasExcessPayments; 
                }
            } else {
                hasExcessPayments = true;
                return hasExcessPayments;
            }
            
        } catch (javax.persistence.NoResultException e) {
            return hasExcessPayments;
        }
    }

    public void setErrorToResolved(DdocDocumentError error) {
        error.setStatus(Constants.RecordStatus.INACTIVE);
        em.merge(error);
    }


//    public List<DdocDocumentError> findErrorsOn(PaymentInputType paymentInputType) {
//
//        try {
//            List<DdocDocumentError> errors = 
//                em.createQuery("select obj from DdocDocumentError obj where " + 
//                               "  obj.status = ?1 and obj.ddocDocument.id = ?2").setParameter(1, 
//                                                                                              Constants.RecordStatus.ACTIVE).setParameter(2, 
//                                                                                                                                          paymentInputType.getId()).getResultList();
//            return errors;
//        } catch (NoResultException e) {
//            return null;
//        }
//
//    }
//
//    public void setReceiptAsNew(PaymentInputType paymentInputType) {
//        DfinRevCollReceipt receipt = 
//            em.find(DfinRevCollReceipt.class, paymentInputType.getId());
//        receipt.setDocStatus(Constants.DocStatus.SAV);
//        em.merge(receipt);
//    }

    public Long findEntityIdForReceipt(Long receipt) {
        DfinRevCollReceipt dfinReceipt = 
            em.find(DfinRevCollReceipt.class, receipt);
        if (null == receipt)
            return null;
        return revenueFacade.findEntityIdByAccountID(dfinReceipt.getAccAccount());
    }

    public List<PaymentSummaryInquiry> findPaymentsByEntityIdAndStatus(Long entityId, 
                                                                       String status) {


        Long revAccId = null;//TODO - RevAccCleanup
         //TODO - RevAccCleanup
//        revenueFacade.findAcctIDByEntityID(entityId);
        List<DfinRevCollReceipt> dfinRevCollReceipts = 
            em.createQuery("select r from DfinRevCollReceipt r where r.revAcc = ?1 and r.docStatus <> ?2 and r.docStatus is not null").setParameter(1, 
                                                                                                                                                    revAccId).setParameter(2, 
                                                                                                                                                                           Constants.DocStatus.SAV).getResultList();

        List<PaymentSummaryInquiry> paymentSummaryInquirys = 
            new ArrayList<PaymentSummaryInquiry>(dfinRevCollReceipts.size());

        PaymentSummaryInquiry paymentSummaryInquiry = null;
        for (DfinRevCollReceipt dfinRevCollReceipt: dfinRevCollReceipts) {

            paymentSummaryInquiry = new PaymentSummaryInquiry();
            paymentSummaryInquiry.setPaymentAmount(dfinRevCollReceipt.getPaymentAmount());
            paymentSummaryInquiry.setReceiptID(dfinRevCollReceipt.getId());
            paymentSummaryInquiry.setPaymentDate(DateHelper.getCalendar(dfinRevCollReceipt.getPaymentDate()));
            paymentSummaryInquiry.setReceiptNumber(dfinRevCollReceipt.getReference());
            paymentSummaryInquiry.setPaymentStatus(dfinRevCollReceipt.getDocStatus());

            GenericTransactionPeriodBean genericTransactionPeriodBean = null;
//TODO - RevledRevPeriod/RevledTransactionCleanup
//            for (DfinRevCollInstrument dfinRevCollInstrument: 
//                 dfinRevCollReceipt.getInstrumentList()) {
//                List<RevledTransaction> revledTransactions = 
//                    revenueFacade.findTransactionsByDDocumentID(dfinRevCollInstrument.getId());
//
//                for (RevledTransaction revledTransaction: revledTransactions) {
//                    if (null == revledTransaction) {
//                        continue;
//                    }
//                    genericTransactionPeriodBean = 
//                            new GenericTransactionPeriodBean();
//
//                    genericTransactionPeriodBean.setId(revledTransaction.getId());
//                    genericTransactionPeriodBean.setTransReference(revledTransaction.getTransactionRef());
//                    genericTransactionPeriodBean.setDate(DateHelper.getCalendar(revledTransaction.getTransactionDate()));
//                    genericTransactionPeriodBean.setDescription(revledTransaction.getTransactionType());
////TODO - RevAccCleanup
////                    if (null != revledTransaction.getRevAccount()) {
////                        genericTransactionPeriodBean.setRevType(revledTransaction.getRevAccount().getRevType().getDescription());
////                    }
//
//                    if (null != revledTransaction.getRevledRevPeriod1()) {
//                        genericTransactionPeriodBean.setPeriodLabel(revledTransaction.getRevledRevPeriod1().getPeriodLabel());
//                    }
//
//                    genericTransactionPeriodBean.setAmount(revledTransaction.getAmount());
//                    paymentSummaryInquiry.add(genericTransactionPeriodBean);
//                }
//            }

            paymentSummaryInquirys.add(paymentSummaryInquiry);
        }

        return paymentSummaryInquirys;
    }

    public List<PaymentSummaryInquiry> findPaymentsByPeriod(Long entityId, 
                                                            String status, 
                                                            Timestamp startDate, 
                                                            Timestamp endDate) {

        Long revAccId = null;//TODO - RevAccCleanup
        //TODO - RevAccCleanup
//        revenueFacade.findAcctIDByEntityID(entityId);//TODO - RevAccCleanup
        List<DfinRevCollReceipt> dfinRevCollReceipts = 
            em.createQuery("select r from DfinRevCollReceipt r where r.revAcc = ?1 and r.docStatus <> ?2 and r.docStatus is not null").setParameter(1, 
                                                                                                                                                    revAccId).setParameter(2, 
                                                                                                                                                                           Constants.DocStatus.SAV).getResultList();

        List<PaymentSummaryInquiry> paymentSummaryInquirys = 
            new ArrayList<PaymentSummaryInquiry>(dfinRevCollReceipts.size());

        PaymentSummaryInquiry paymentSummaryInquiry = null;
        for (DfinRevCollReceipt dfinRevCollReceipt: dfinRevCollReceipts) {

            paymentSummaryInquiry = new PaymentSummaryInquiry();
            paymentSummaryInquiry.setPaymentAmount(dfinRevCollReceipt.getPaymentAmount());
            paymentSummaryInquiry.setReceiptID(dfinRevCollReceipt.getId());
            paymentSummaryInquiry.setPaymentDate(DateHelper.getCalendar(dfinRevCollReceipt.getPaymentDate()));
            paymentSummaryInquiry.setReceiptNumber(dfinRevCollReceipt.getReference());
            paymentSummaryInquiry.setPaymentStatus(dfinRevCollReceipt.getDocStatus());

            GenericTransactionPeriodBean genericTransactionPeriodBean = null;
            for (DfinRevCollInstrument dfinRevCollInstrument: 
                 dfinRevCollReceipt.getInstrumentList()) {
//TODO - RevledRevPeriod/RevledTransactionCleanup
//                List<RevledTransaction> revledTransactions = 
//                    revenueFacade.findTransactionsByDDocumentID(dfinRevCollInstrument.getId());
//
//                for (RevledTransaction revledTransaction: revledTransactions) {
//                    if (validatePeriodDates(revledTransaction, startDate, 
//                                            endDate)) {
//
//                        if (null == revledTransaction) {
//                            continue;
//                        }
//                        genericTransactionPeriodBean = 
//                                new GenericTransactionPeriodBean();
//
//                        genericTransactionPeriodBean.setId(revledTransaction.getId());
//                        genericTransactionPeriodBean.setTransReference(revledTransaction.getTransactionRef());
//                        genericTransactionPeriodBean.setDate(DateHelper.getCalendar(revledTransaction.getTransactionDate()));
//                        genericTransactionPeriodBean.setDescription(revledTransaction.getTransactionType());
////TODO - RevAccCleanup
////                        if (null != revledTransaction.getRevAccount()) {
////                            genericTransactionPeriodBean.setRevType(revledTransaction.getRevAccount().getRevType().getDescription());
////                        }
//
//                        if (null != revledTransaction.getRevledRevPeriod1()) {
//                            genericTransactionPeriodBean.setPeriodLabel(revledTransaction.getRevledRevPeriod1().getPeriodLabel());
//                        }
//
//                        genericTransactionPeriodBean.setAmount(revledTransaction.getAmount());
//                        paymentSummaryInquiry.add(genericTransactionPeriodBean);
//                    }
//                }
            }
            
            if(null != paymentSummaryInquiry.getPaymentTransactionList() 
                && paymentSummaryInquiry.getPaymentTransactionList().size() !=0){
                paymentSummaryInquirys.add(paymentSummaryInquiry);
            }
        }
        return paymentSummaryInquirys;

    }

//TODO - RevledRevPeriod/RevledTransactionCleanup
//    private boolean validatePeriodDates(RevledTransaction revledTransaction, 
//                                        Timestamp startDate, 
//                                        Timestamp endDate) {
//
//        boolean passed = false;
//        if (null != startDate 
//            && DateHelper.compareDatesIgnoreTime(startDate, revledTransaction.getRevledRevPeriod1().getPeriodStart()) <=0
//            && null != endDate 
//            && DateHelper.compareDatesIgnoreTime(endDate, revledTransaction.getRevledRevPeriod1().getPeriodEnd()) >=0) {
//                
//                passed = true;
//        
//        } else if (null == startDate 
//                    && null != endDate 
//                    && DateHelper.compareDatesIgnoreTime(endDate, revledTransaction.getRevledRevPeriod1().getPeriodEnd()) >=0) {
//                    
//                passed = true;
//
//        } else if (null != startDate 
//                    &&  DateHelper.compareDatesIgnoreTime(startDate, revledTransaction.getRevledRevPeriod1().getPeriodStart()) <=0 
//                    && null == endDate) {
//                    
//                passed = true;
//                
//        }
//
//        return passed;
//
//    }

    public boolean isBadCheque(String chequeNumber) {
        DfinBadChequeRegister dfinBadChequeRegister = null;
        try {
            dfinBadChequeRegister = 
                    (DfinBadChequeRegister)em.createQuery("select obj from DfinBadChequeRegister obj where " + 
                                                          " obj.reference = ?1").setParameter(1, 
                                                                                              chequeNumber).getSingleResult();

        } catch (NoResultException e) {
            return false;
        }
        if (null != dfinBadChequeRegister) {
            return true;
        }
        return false;
    }

//    public List<DfinRefundClaim> findDfinRefundClaimByRevIDTaxTypeAndReturnPeriod(Long revID, 
//                                                                                  String taxType, 
//                                                                                  Timestamp startDate,
//                                                                                  Timestamp endDate) {
//        List<DfinRefundClaim> dfinRefundClaimDuplicateList = new ArrayList<DfinRefundClaim>();
//        try {
//
//            StringBuffer sql = 
//                new StringBuffer("select o from DfinRefundClaim o where o.id in " + 
//                                 "(select ddd.id from DdocDocument ddd, DfinRefundClaim dfrc " + 
//                                 "where ddd.id = dfrc.id and ddd.revAcc = :revID " + 
//                                 "and dfrc.regime = :taxType)");
//                                 //"and dfrc.startDate = :startDate " +
//                                 //"and dfrc.endDate = :endDate)");
//
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("revID", revID)
//            .setParameter("taxType", taxType);
//            //.setParameter("startDate", startDate)
//            //.setParameter("endDate", endDate);
//            
//            List<DfinRefundClaim> dfinRefundClaimList = query.getResultList();
//
//            for (DfinRefundClaim refundClaim : dfinRefundClaimList) {
//               if (startDate.equals(refundClaim.getStartDate())
//                || startDate.equals(refundClaim.getEndDate())
//                || endDate.equals(refundClaim.getStartDate())
//                || endDate.equals(refundClaim.getEndDate())) {
//                    dfinRefundClaimDuplicateList.add(refundClaim);
//                } else if ((startDate.before(refundClaim.getStartDate()) && endDate.before(refundClaim.getStartDate())) 
//                || (startDate.after(refundClaim.getEndDate()) && endDate.after(refundClaim.getEndDate()))) {
//                } else {
//                    dfinRefundClaimDuplicateList.add(refundClaim);
//                }
//            }
//
//        } catch (javax.persistence.NoResultException e) {
//            return dfinRefundClaimDuplicateList;
//        }
//
//        return dfinRefundClaimDuplicateList;
//    }
//    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public String findFormTypeForRefundClaim(Long entityId, String taxType, Timestamp startDate, Timestamp endDate) {
//        String formType = "NON_1700";
//        
//        if (!taxType.equalsIgnoreCase(Constants.Regimes.IIT)) {
//            return formType;
//        }
//        
//        try {
//            StringBuffer sql = 
//                            new StringBuffer("select distinct iit.formType " + 
//                                            "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp, DdocDocument ddd, ItrIndividualTxn iit " + 
//                                            "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code and ddd.revAcc = ra.id and ddd.id = iit.ddocDocumentId " + 
//                                            "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate and rlt.transactionType = :transactionType");
//            
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("entityID", entityId)
//            .setParameter("revenueType", taxType)
//            .setParameter("startDate", startDate)
//            .setParameter("endDate", endDate)
//            .setParameter("transactionType", Constants.TransactionType.RETURN);
//            List<String> formTypeList = query.getResultList();
//            
//            for (String docType : formTypeList) {
//                if (docType.equalsIgnoreCase("1700")) {
//                    formType = "1700";
//                }
//            }
//            
//        } catch (javax.persistence.NonUniqueResultException e) {
//            return formType;
//        } catch (javax.persistence.NoResultException e) {
//            return formType;
//        }
//        return formType;
//    }

    /**
     * Save entry to cheque note table
     * @param chequeNote
     * @return
     */
    public BaseModelObject saveChequeNote(InputType type) {
//
//        DfinRefundChequeNote dfinChequeNote = 
//            (DfinRefundChequeNote)super.saveOrUpdate(type, 
//                                                     DfinRefundChequeNote.class, 
//                                                     ChequeNoteMessageHelper.class);

        return null;
    }

    public TaxCreditRefundSummaryBean findTCCDetails(String transRef) {
        TaxCreditRefundSummaryBean taxCreditRefundSummaryBean = null;
        try {

            StringBuffer sql = 
                new StringBuffer("select new com.technobrain.trips.dto.tax.accounting.TaxCreditRefundSummaryBean(rlt.transactionRef, " + 
                                 "ddd.docStatus, drc.legalBasis, drc.claimDate, drc.claimAmount, drc.actualRefundAmount) " + 
                                 "from DdocDocument ddd, DfinRefundClaim drc, RevledTransaction rlt " + 
                                 "where ddd.id = drc.id " + 
                                 "and ddd.revAcc = rlt.revAcc " + 
                                 "and rlt.transactionRef = :transRef");

            Query query = em.createQuery(sql.toString());
            query.setParameter("transRef", transRef);
            taxCreditRefundSummaryBean = 
                    (TaxCreditRefundSummaryBean)query.getSingleResult();

        } catch (javax.persistence.NoResultException e) {
            return new TaxCreditRefundSummaryBean();
        }

        return taxCreditRefundSummaryBean;
    }

//    public DfinRefundClaim findDfinRefundClaimByDocumentRef(String refundClaimNumber) {
//        DfinRefundClaim dfinRefundClaim = null;
//        try {
//
//            StringBuffer sql = 
//                new StringBuffer("select dfrc from DdocDocument ddd, DfinRefundClaim dfrc " + 
//                                 "where ddd.id = dfrc.id and dfrc.claimReference = :refundClaimNumber");
//
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("refundClaimNumber", refundClaimNumber);
//            dfinRefundClaim = (DfinRefundClaim)query.getSingleResult();
//
//        } catch (javax.persistence.NoResultException e) {
//            return dfinRefundClaim;
//        }
//
//        return dfinRefundClaim;
//    }
    
//    public TaxRefundNoticeInputType findTRNByRefundClaimId(Long refundId)
//    {
//        try
//        {
//            StringBuffer sql = new StringBuffer("SELECT new com.crownagents.trips.refund.model.DfinRefundTRN(trn.*) FROM DfinRefu" +
//                                "ndClaim claim, DfinRefundTRN trn  WHERE trn.refundClaim = claim.id AND claim.id " +
//                                "= :refundId");
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("refundId", refundId);
//            TaxRefundNoticeInputType taxrefundnoticeinputtype = null;
//            return taxrefundnoticeinputtype;
//        }
//        catch(NoResultException e)
//        {
//            TaxRefundNoticeInputType taxrefundnoticeinputtype1 = null;
//            return taxrefundnoticeinputtype1;
//        }
//    }

    public List listSubordinatesOfRegion(String regionCode) {
        try {
            List summary = new ArrayList();
            StringBuffer nativeSql = 
                new StringBuffer("SELECT office.sub_office,SUM(claim.total_refund_amount) FROM OFFICE_SUBORDINATES" + 
                                 " office,REV_ACC revaccount,DDOC_DOCUMENT ddocument,DFIN_REFUND_CLAIM claim WHERE" + 
                                 " ddocument.id=claim.id AND revaccount.id=ddocument.rev_acc AND office.sub_office" + 
                                 "= revaccount.ref_office AND office.ref_office= ?1 AND claim.approve_indicator='T" + 
                                 "' AND ddocument.doc_status='AFR' GROUP BY office.sub_office");
            StringBuffer sqlNotGrouped = 
                new StringBuffer("SELECT office.sub_office,claim.id FROM OFFICE_SUBORDINATES office,REV_ACC revacc" + 
                                 "ount,DDOC_DOCUMENT ddocument,DFIN_REFUND_CLAIM claim WHERE ddocument.id=claim.id" + 
                                 " AND revaccount.id=ddocument.rev_acc AND office.sub_office= revaccount.ref_offic" + 
                                 "e AND office.ref_office= ?1 AND claim.approve_indicator='T' AND ddocument.doc_st" + 
                                 "atus='AFR' ORDER BY office.sub_office");
            Query query = em.createNativeQuery(nativeSql.toString());
            query.setParameter(1, regionCode);
            Query query2 = em.createNativeQuery(sqlNotGrouped.toString());
            query2.setParameter(1, regionCode);
            List list = query.getResultList();
            List list2 = query2.getResultList();
            HashMap secondResult = parseTwoValuedStringResult(list2);
            if (list != null) {
                int counter = 0;
                do {
                    if (list.get(counter) != null) {
                        String values[] = 
                            list.get(counter).toString().split(",");
                        String regCode = values[0].replace("[", " ").trim();
                        BigDecimal totaAmount = 
                            new BigDecimal(values[1].replace("]", " ").trim());
                        log.debug((new StringBuilder()).append("Size of secondResult===>").append(secondResult.size()).toString());
                        Iterator iterator = secondResult.entrySet().iterator();
                        List refundClaimIds = new ArrayList();
                        while (iterator.hasNext()) {
                            java.util.Map.Entry me = 
                                (java.util.Map.Entry)iterator.next();
                            log.debug((new StringBuilder()).append("me.getValue().toString():====> ").append(me.getValue().toString()).append("me.getKey.toString: ").append(me.getKey().toString()).toString());
                            if (regCode.equalsIgnoreCase(me.getKey().toString())) {
                                refundClaimIds.add(Long.valueOf(Long.parseLong(me.getValue().toString())));
                                log.debug((new StringBuilder()).append("regCode:====>").append(regCode).append("me.getKey.toString:").append(me.getKey().toString()).toString());
                            }
                        }
//                        ProcessRefundApplyToSummaryBean item = 
//                            new ProcessRefundApplyToSummaryBean(regCode, "", 
//                                                                totaAmount, 
//                                                                refundClaimIds);
//                        summary.add(item);
                    }
                } while (++counter < list.size());
            }
            List list1 = summary;
            return list1;
        } catch (NoResultException ex) {
            log.error(ex.getLocalizedMessage(), ex);
        }
        return null;
    }

    private HashMap parseTwoValuedStringResult(List list) {

        HashMap result = new HashMap();

        if (list != null) {
            int counter = 0;

            do {
                if (list.get(counter) != null) {

                    String[] values = list.get(counter).toString().split(",");

                    String regCode = values[0].replace("[", " ").trim();

                    Long refundClaimIds = 
                        new Long(values[1].replace("]", " ").trim());

                    result.put(regCode, refundClaimIds);
                }
                counter++;
            } while (counter < list.size());
        }

        return result;
    }

    /**
     * 
     * @param entity
     * @param serializable
     * @return
     */
//    public RefundClaimInputType queryFindRefundClaimById(Long id) {
//
//        try {
//            DfinRefundClaim claim = 
//                (DfinRefundClaim)em.createNativeQuery("SELECT e.* FROM DFIN_REFUND_CLAIM e WHERE e.Id = ?1", 
//                                                      DfinRefundClaim.class).setParameter(1, 
//                                                                                          id).getSingleResult();
//            return claim.getData();
//        } catch (NoResultException nrex) {
//            nrlog.error(ex.getLocalizedMessage(), ex);
//        }
//
//        return null;
//    }
    

    public List<DdocDocumentError> findDocumentErrorsOnForm(Long formId, 
                                                                String formType) {
        try {
            List<DdocDocumentError> result = 
                em.createQuery("select obj " + 
                               "from DdocDocumentError obj join obj.ddocDocument d " +
                               "where d.flexiForm = ?1 and d.docType = ?2").
                               setParameter(1,formId).
                               setParameter(2,formType)
                               .getResultList();
            return result;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }                                                           
                                                                        
    }
    
//    public CaseInputType createAuditRefundCase(RefundClaimInputType refundInputType, String office) {
//        
//        CaseInputType caseInputType = new CaseInputType();
//        
//        caseInputType.setEntityID(refundInputType.getEntityId());
//        caseInputType.setCreationReason("CMS_CSC72");
//        caseInputType.setTransRefNo(0L);
//        
//        CaseStatusInputType caseStatusInputType = new CaseStatusInputType();
//        caseStatusInputType.setStartDate(refundInputType.getStartDate());
//        GregorianCalendar endDate = new GregorianCalendar();
//        endDate.setTime(new Date(Constants.CaseManagementConstants.END_DATE));
//        caseStatusInputType.setEndDate(endDate);
//        caseStatusInputType.setCaseStatus(Constants.CaseManagementConstants.OPEN);
//        caseStatusInputType.setReason(refundInputType.getReasonForFiling());
//        CaseStatusInputType[] caseStatusInputTypeList = new CaseStatusInputType[]{caseStatusInputType};
//        
//        CaseTaxTypeInputType caseTaxTypeInputType = new CaseTaxTypeInputType();
//        caseTaxTypeInputType.setCode(refundInputType.getRegime());
//        caseTaxTypeInputType.setExcept(Constants.CaseManagementConstants.FALSE);
//        CaseTaxTypeInputType[] caseTaxTypeInputTypeList = new CaseTaxTypeInputType[]{caseTaxTypeInputType};
//        
//        CaseOfficeCustodianInputType caseOfficeCustodianInputType = new CaseOfficeCustodianInputType();
//        caseOfficeCustodianInputType.setReason("");
//        caseOfficeCustodianInputType.setOffice(office);
//        caseOfficeCustodianInputType.setCustodyStatus("ACTIVE");
//        CaseOfficeCustodianInputType[] caseOfficeCustodianInputTypeList = new CaseOfficeCustodianInputType[]{caseOfficeCustodianInputType};
//        
//        caseInputType.setCaseStatusHistory(caseStatusInputTypeList);
//        caseInputType.setCaseTaxTypes(caseTaxTypeInputTypeList);
//        caseInputType.setCaseOfficeCustodian(caseOfficeCustodianInputTypeList);
//        
//        return caseInputType;
//    }
    
    public String validateTaskAuthority(BigDecimal amount, String userName, String permission){
        try {
            List result = 
                em.createQuery("select obj " + 
                               "from RefundAuth obj join obj.refundAuthDetailsList d " +
                               "where ?1 between obj.amtFrom and obj.amtTo and obj.authType = '" + permission + "' and UPPER(d.userName)=?2").
                               setParameter(1,amount).
                               setParameter(2,userName.toUpperCase())
                               .getResultList();
            //return result;
            if(result.size() > 0){
                return Constants.YES;
            }else{
                return Constants.NO;
            }
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return Constants.NO;
        } catch(Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Constants.NO;
        }
    }
//TODO - RevledRevPeriodCleanup
//    public List<RevledTransaction> getRevledTransactionsByEntityIdTaxTypeAndPeriodRange(Long entityId, String taxType, Timestamp startDate, Timestamp endDate) {
//                                            
//        List<RevledTransaction> returnAmountsList = null;
//        try {
//
//                StringBuffer sql = 
//                    new StringBuffer("select rlt " + 
//                                    "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                    "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                    "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate and rlt.transactionType = :transactionType");
//
//                Query query = em.createQuery(sql.toString());
//                query.setParameter("entityID", entityId)
//                .setParameter("revenueType", taxType)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setParameter("transactionType", Constants.TransactionType.RETURN);
//
//                returnAmountsList = query.getResultList();
//            
//                return returnAmountsList;
//        } catch (javax.persistence.NoResultException e) {
//            return returnAmountsList;
//        }
//    }

//TODO - RevledRevPeriodCleanup
//    public List<RevledTransaction> getRevledTransactionsForErroneousAndDoublePayment(Long entityId, String taxType, Timestamp startDate, Timestamp endDate) {
//                                            
//        List<RevledTransaction> returnAmountsList = null;
//        try {
//
//                StringBuffer sql = 
//                    new StringBuffer("select rlt " + 
//                                    "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                    "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                    "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart = :startDate and rlrp.periodEnd = :endDate and rlt.transactionType = :transactionType");
//
//                Query query = em.createQuery(sql.toString());
//                query.setParameter("entityID", entityId)
//                .setParameter("revenueType", taxType)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setParameter("transactionType", Constants.TransactionType.RETURN);
//
//                returnAmountsList = query.getResultList();
//            
//                return returnAmountsList;
//        } catch (javax.persistence.NoResultException e) {
//            return returnAmountsList;
//        }
//    }

    //Methods for TCR Configuration in getting user list
    
    public RefOffice getOfficeByRDO(String selectedRDO) {
        
        try{
            RefOffice officeType = (RefOffice) em.createQuery("select obj from RefOffice obj where obj.code = ?1")
                                    .setParameter(1, selectedRDO)
                                    .getSingleResult();
            return officeType;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }        
    }

    public String getOfficeBySubOffice(String selectedRDO) {
    
        try{
            String office = (String) em.createQuery("select obj.refOffice.code from OfficeSubordinates obj where obj.subOffice.code = ?1")
                                    .setParameter(1, selectedRDO)
                                    .getSingleResult();
            
            return office;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public List<CodeAndDescription> getUsersByOfficeByLastName(String rdo) {
        List<CodeAndDescription> results = new ArrayList <CodeAndDescription>();  
        
        try{
            results = em.createQuery("select new com.technobrain.trips.dto.CodeAndDescription(obj.name,obj.displayname) " +
                "from WfisUserT obj, RefOffStaff obj2 where obj2.username = obj.name and obj.status = ?1 and obj2.refOffice.code = ?2 order by obj.lastname ")
                .setParameter(1, Constants.RecordStatus.ACTIVE)
                .setParameter(2, rdo)
                .getResultList();
                
        }catch (javax.persistence.NoResultException nre) {
            log.error(nre.getLocalizedMessage(), nre);
            return null;
        }                                    
        return results;
    }
        
    public boolean checkIfTaxpayerHasFraudCase(Long entityId) {
                                            
        boolean exists = false;
        try {

            StringBuffer sql = 
                new StringBuffer("select oc.id " + 
                                 "from OpsCase oc, OpsCaseStatus ocs " + 
                                 "where oc.id =  ocs.opsCase.id " + 
                                 "and oc.entityId = :entityId and ocs.caseStatus = :caseStatus");

            Query query = em.createQuery(sql.toString());
            query.setParameter("entityId", entityId).setParameter("caseStatus", Constants.CaseManagementConstants.OPEN);

            List<Long> idList = query.getResultList();
            
            if (idList == null) {
                return exists;
            } else if(idList.size() == 0) {
                return exists;
            } else {
                exists = true;
                return exists;
            }
        } catch (javax.persistence.NoResultException e) {
            return exists;
        }
    }
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public boolean checkIfRefundClaimEqualsPayment(Long entityId, BigDecimal claimAmount, String taxType, Timestamp startDate, Timestamp endDate) {
//                                                
//        boolean equals = false;
//        try {
//            
//                StringBuffer sql = 
//                    new StringBuffer("select rlt.amount " + 
//                                        "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                        "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                        "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate and rlt.transactionType = :transactionType");
//
//                Query query = em.createQuery(sql.toString());
//                query.setParameter("entityID", entityId)
//                .setParameter("revenueType", taxType)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setParameter("transactionType", Constants.TransactionType.PAYMENT);
//
//                List<BigDecimal> paymentAmountList = query.getResultList();
//              
//                if (paymentAmountList == null) {
//                    return equals;
//                } else if(paymentAmountList.size() == 0) {
//                    return equals;
//                } else {
//                    BigDecimal payment = new BigDecimal(0);
//                    for (BigDecimal amount : paymentAmountList) {
//                        payment = payment.add(amount);
//                    }
//                    return payment.equals(claimAmount);
//                }
//        } catch (javax.persistence.NoResultException e) {
//            return equals;
//        }
//    }
    
//    public DfinRefundClaim maintainRefundClaims(RefundClaimInputType refundClaimInputType) {
//        if (refundClaimInputType != null){
//            try{
//                    if(refundClaimInputType.getDocStatus() == null || 
//                            refundClaimInputType.getDocStatus().equalsIgnoreCase(Constants.DocStatus.SUB) ||
//                            refundClaimInputType.getDocStatus().equalsIgnoreCase(Constants.DefermentStatus.REJECTED)){
//                        return saveOrUpdateRefundClaims(refundClaimInputType);
//                    }else if(refundClaimInputType.getDocStatus().equalsIgnoreCase(Constants.DocStatus.POSTED)){
//                        //TODO - RevledRevPeriod/RevledTransactionCleanup
////                        return postRefundClaimsTransaction(refundClaimInputType);
//                        return null;
//                    }
//            }catch(Exception ex) {  
//                log.error(ex.getLocalizedMessage(), ex);
//            }
//        }
//        return null;            
//    }
    
//    public DfinRefundClaim saveOrUpdateRefundClaims(RefundClaimInputType refundClaimInputType) {
//        if (refundClaimInputType != null) {
//            DocumentMessageHelper documentMessageHelper = new DocumentMessageHelper();
//            try {
//                DfinRefundClaim dfinRefundClaim = new DfinRefundClaim();
//                dfinRefundClaim = findDfinRefundClaimByRefundClaimId(refundClaimInputType.getId());
//                if (dfinRefundClaim == null) {
//                    dfinRefundClaim = new DfinRefundClaim();
//                }
//                dfinRefundClaim = documentMessageHelper.setDfinRefundClaimData(dfinRefundClaim, refundClaimInputType);
//                dfinRefundClaim = (DfinRefundClaim)persistEntity(dfinRefundClaim);
//                return dfinRefundClaim;
//            } catch (Exception exception) {
//            }
//        }
//        return null;
//    }
    
//    public DfinRefundClaim findDfinRefundClaimByRefundClaimId(Long refundClaimId) {
//        DfinRefundClaim dfinRefundClaim = null;
//        try {
//
//            StringBuffer sql = 
//                new StringBuffer("select dfrc from DdocDocument ddd, DfinRefundClaim dfrc " + 
////                                 "where ddd.id = dfrc.id and dfrc.id = :refundClaimId");
//
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("refundClaimId", refundClaimId);
//            dfinRefundClaim = (DfinRefundClaim)query.getSingleResult();
//
//        } catch (javax.persistence.NoResultException e) {
//            return dfinRefundClaim;
//        }
//
//        return dfinRefundClaim;
//    }
//TODO - RevledRevPeriodCleanup
//    public DfinRefundClaim postRefundClaimsTransaction(RefundClaimInputType refundClaimInputType) {
//        try{   
//            String paymentMode = null;
//            TransactionInputType tranType = null;
//            BigDecimal creditInterestDue = new BigDecimal(0.00);
//            
//            List<RevledTransaction> revledTransactionList = getRevledTransactionsByEntityIdTaxTypeAndPeriodRange(refundClaimInputType.getEntityId(), refundClaimInputType.getRegime(), DateHelper.getSqlTimestamp(refundClaimInputType.getStartDate()), DateHelper.getSqlTimestamp(refundClaimInputType.getEndDate()));
//            if (refundClaimInputType.getModeOfClaim().equalsIgnoreCase(Constants.TaxCreditRefundModeOfClaim.TAX_REFUND)) {
//                for (RevledTransaction revledTransaction : revledTransactionList) {
//                    if (computeCreditInterestDue(refundClaimInputType.getEntityId(), refundClaimInputType.getRegime(), revledTransaction.getRevledRevPeriod1().getId(), refundClaimInputType.getApprovalDate(), refundClaimInputType.getActualRefundAmount()) != null) {
//                        creditInterestDue = creditInterestDue.add(computeCreditInterestDue(refundClaimInputType.getEntityId(), refundClaimInputType.getRegime(), revledTransaction.getRevledRevPeriod1().getId(), refundClaimInputType.getApprovalDate(), refundClaimInputType.getActualRefundAmount()));
//                    }
//                }
//                if (creditInterestDue != null && !creditInterestDue.equals(new BigDecimal(0.00))) {
//                    refundClaimInputType.setInterestAmount(creditInterestDue);
//                }
//                
//                paymentMode = determinePaymentMode(refundClaimInputType.getActualRefundAmount());
//                if (paymentMode.equalsIgnoreCase(Constants.TaxCreditRefundPaymentMode.CHEQUE)) {
//                    // TAXPAYER NOTIFICATION FOR APPROVED REFUND - Process
//                }
//            } else {
//                // CREATES TCN NOTIFICATION FOR PRINTING - Process
//                
//                TaxCreditCertificateInputType taxCreditCertificateInputType = new TaxCreditCertificateInputType();
//                taxCreditCertificateInputType.setTin("");
//                taxCreditCertificateInputType.setTaxType(refundClaimInputType.getRegime());
//                taxCreditCertificateInputType.setReturnPeriod("");
//                taxCreditCertificateInputType.setIssueDate(Calendar.getInstance());
//                taxCreditCertificateInputType.setReissueDate(Calendar.getInstance());
//                taxCreditCertificateInputType.setExpiryDate(Calendar.getInstance());
//                taxCreditCertificateInputType.setIssuingAgency("");
//                taxCreditCertificateInputType.setSerialNo("");
//                taxCreditCertificateInputType.setTccAmt(new BigDecimal(0));
//                taxCreditCertificateInputType.setMannerOfIssuance("");
//                taxCreditCertificateInputType.setTransfereeTcc("");
//                taxCreditCertificateInputType.setTransferFlag(false);
//                taxCreditCertificateInputType.setRdoCode("");
//                taxCreditCertificateInputType.setLegalBasis("");
//                taxCreditCertificateInputType.setRestrictions("");
//                taxCreditCertificateInputType.setRemarks("");
//                taxCreditCertificateInputType.setTccStatus("");
//                saveOrUpdateTaxCreditCertificate(taxCreditCertificateInputType);
//            }
//            
//            refundClaimInputType.setPaymentMode(paymentMode);
//            refundClaimInputType.setRequestStatus(Constants.DocStatus.APP);
//                        
//            if (refundClaimInputType.getReasonForFiling().equalsIgnoreCase(Constants.ReasonForFilingTaxCreditRefund.OVER_PAY)
//                || refundClaimInputType.getReasonForFiling().equalsIgnoreCase(Constants.ReasonForFilingTaxCreditRefund.CLAIM_EPT)) {
//                boolean isPaymentEqual = checkIfRefundClaimEqualsPaymentMinusReturn(refundClaimInputType.getEntityId(), refundClaimInputType.getClaimAmount(), refundClaimInputType.getRegime(), DateHelper.getSqlTimestamp(refundClaimInputType.getStartDate()), DateHelper.getSqlTimestamp(refundClaimInputType.getEndDate()));
//                if (!isPaymentEqual) {
//                    refundClaimInputType.setDocStatus(Constants.DefermentStatus.REJECTED);
//                    refundClaimInputType.setRejectIndicator(StringHelper.getIndicatorAsBoolean(Constants.TRUE));
//                    refundClaimInputType.setApproveIndicator(StringHelper.getIndicatorAsBoolean(Constants.FALSE));
//                    return saveOrUpdateRefundClaims(refundClaimInputType);
//                } else {
//                    List<RevledTransaction> revledTransactionListForErroneousAndDoublePayment = getRevledTransactionsForErroneousAndDoublePayment(refundClaimInputType.getEntityId(), refundClaimInputType.getRegime(), DateHelper.getSqlTimestamp(refundClaimInputType.getStartDate()), DateHelper.getSqlTimestamp(refundClaimInputType.getEndDate()));
//                    if (revledTransactionListForErroneousAndDoublePayment != null && revledTransactionListForErroneousAndDoublePayment.size() > 1) {
//                        List<RevledTransaction> tempList = new ArrayList<RevledTransaction>();
//                        for (RevledTransaction revledTransaction : revledTransactionListForErroneousAndDoublePayment) {
//                            if (revledTransaction.getAmount().equals(refundClaimInputType.getClaimAmount())) {
//                                tempList.add(revledTransaction);
//                            }
//                        }
//                        if (tempList.size() == 1) {
//                            tranType = new TransactionInputType();
//                            tranType.setAccountID(refundClaimInputType.getOwnerId().toString());
//                            tranType.setAmount(tempList.get(0).getAmount());
//                            //                        tranType.setCurrency(refundClaimInputType.getTransactionCurrency());
//                            tranType.setDocumentID(refundClaimInputType.getDocumentID());
//                            tranType.setPeriodID(tempList.get(0).getRevledRevPeriod1().getId());
//                            tranType.setTransactionType(Constants.TransactionType.CANCEL_RETURN);  
//                            tranType.setTransactionDate(Calendar.getInstance());
//                            RevledTransaction transactionReturn = revLedBusFacade.processTransaction(tranType);
//                        } else if (tempList.size() > 1) {
//                            RevledTransaction[] revledTransactionArray = (RevledTransaction[])tempList.toArray();
//                            for(int y = 1; y < revledTransactionArray.length; y++) {
//                                for (int x = 1; x < revledTransactionArray.length; x++) {
//                                    RevledTransaction revledTransaction = new RevledTransaction();
//                                    if (revledTransactionArray[x-1].getId() > revledTransactionArray[x].getId()) {
//                                        revledTransaction = revledTransactionArray[x-1];
//                                        revledTransactionArray[x-1] = revledTransactionArray[x];
//                                        revledTransactionArray[x] = revledTransaction;
//                                    }
//                                }
//                            }
//                            tranType = new TransactionInputType();
//                            tranType.setAccountID(refundClaimInputType.getOwnerId().toString());
//                            tranType.setAmount(tempList.get(revledTransactionArray.length-1).getAmount());
////                            tranType.setCurrency(refundClaimInputType.getTransactionCurrency());
//                            tranType.setDocumentID(refundClaimInputType.getDocumentID());
//                            tranType.setPeriodID(tempList.get(revledTransactionArray.length-1).getRevledRevPeriod1().getId());
//                            tranType.setTransactionType(Constants.TransactionType.CANCEL_RETURN);  
//                            tranType.setTransactionDate(Calendar.getInstance());
//                            RevledTransaction transactionReturn = revLedBusFacade.processTransaction(tranType);
//                        }
//                    }
//                }
//            } else {
//                boolean hasExcessPayments = computeExcessPayments(refundClaimInputType.getEntityId(), refundClaimInputType.getRegime(), DateHelper.getSqlTimestamp(refundClaimInputType.getStartDate()), DateHelper.getSqlTimestamp(refundClaimInputType.getEndDate()));
//                if (!hasExcessPayments) {
//                    refundClaimInputType.setDocStatus(Constants.DefermentStatus.REJECTED);
//                    refundClaimInputType.setRejectIndicator(StringHelper.getIndicatorAsBoolean(Constants.TRUE));
//                    refundClaimInputType.setApproveIndicator(StringHelper.getIndicatorAsBoolean(Constants.FALSE));
//                    return saveOrUpdateRefundClaims(refundClaimInputType);
//                } 
//            }
//
//            BigDecimal tempRefundAmount = refundClaimInputType.getClaimAmount();
//            for (RevledTransaction revledTransaction : revledTransactionList) {
//                tranType = new TransactionInputType();
//                tranType.setAccountID(refundClaimInputType.getOwnerId().toString());
//                if (tempRefundAmount.doubleValue() > revledTransaction.getAmount().doubleValue()) {
//                    tranType.setAmount(revledTransaction.getAmount());
//                    tempRefundAmount = tempRefundAmount.subtract(revledTransaction.getAmount());
//                } else {
//                    tranType.setAmount(tempRefundAmount);
//                }
//                //            tranType.setCurrency(refundClaimInputType.getTransactionCurrency());
//                tranType.setDocumentID(refundClaimInputType.getDocumentID());
//                tranType.setPeriodID(revledTransaction.getRevledRevPeriod1().getId());
//                tranType.setTransactionType(Constants.TransactionType.REFUND);  
//                tranType.setTransactionDate(Calendar.getInstance());
//                RevledTransaction transactionRefund = revLedBusFacade.processTransaction(tranType);
//            }
//
//            if (!(refundClaimInputType.getClaimAmount().subtract(refundClaimInputType.getActualRefundAmount()).equals(new BigDecimal(0)))) {
//                if (refundClaimInputType.getCasesForDisapproval().equalsIgnoreCase(Constants.CasesForDisapprovalOfRefund.NOT_QUALIFIED)
//                    || refundClaimInputType.getCasesForDisapproval().equalsIgnoreCase(Constants.CasesForDisapprovalOfRefund.NO_DOCUMENTATION)
//                    || refundClaimInputType.getCasesForDisapproval().equalsIgnoreCase(Constants.CasesForDisapprovalOfRefund.OUT_OF_PERIOD)) {
//                                                
//                    BigDecimal claimAmount = refundClaimInputType.getClaimAmount();
//                    BigDecimal approvedAmount = refundClaimInputType.getActualRefundAmount();
//                    for (RevledTransaction revledTransaction : revledTransactionList) {
//                        if (claimAmount.doubleValue() > revledTransaction.getAmount().doubleValue() 
//                        && approvedAmount.doubleValue() > revledTransaction.getAmount().doubleValue()) {
//                            claimAmount = claimAmount.subtract(revledTransaction.getAmount());
//                            approvedAmount = approvedAmount.subtract(revledTransaction.getAmount());
//                        } else {
//                            tranType = new TransactionInputType();
//                            tranType.setAmount(claimAmount.subtract(approvedAmount));
//                            tranType.setAccountID(refundClaimInputType.getOwnerId().toString());
//                            //            tranType.setCurrency(refundClaimInputType.getTransactionCurrency());
//                            tranType.setDocumentID(refundClaimInputType.getDocumentID());
//                            tranType.setPeriodID(revledTransaction.getRevledRevPeriod1().getId());
//                            tranType.setTransactionType(Constants.TransactionType.WRITEOFF);  
//                            tranType.setTransactionDate(Calendar.getInstance());
//                            RevledTransaction transactionWriteUp = revLedBusFacade.processTransaction(tranType);
//                        }
//                    }
//                }
//            }
//            
//            for (RevledTransaction revledTransaction : revledTransactionList) {
//                RevledRevPeriod basePeriod = (RevledRevPeriod)queryFindById(RevledRevPeriod.class, revledTransaction.getRevledRevPeriod1().getId());
//                basePeriod.setPeriodstatus(Constants.RevPeriodStatus.CREATED);
//                basePeriod.setRevAcc(refundClaimInputType.getOwnerId());
//                saveOrUpdate(basePeriod);
//            }
//        } catch (Exception ex) {  
//            log.error(ex.getLocalizedMessage(), ex);
//        }
//        refundClaimInputType.setRejectIndicator(StringHelper.getIndicatorAsBoolean(Constants.FALSE));
//        refundClaimInputType.setApproveIndicator(StringHelper.getIndicatorAsBoolean(Constants.TRUE));
//        return saveOrUpdateRefundClaims(refundClaimInputType);
//    }
 //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public boolean checkIfRefundClaimEqualsPaymentMinusReturn(Long entityId, BigDecimal claimAmount, String taxType, Timestamp startDate, Timestamp endDate) {
//                                                
//        boolean equals = false;
//        try {
//            
//                StringBuffer sql = 
//                    new StringBuffer("select rlt.amount " + 
//                                        "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                        "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                        "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate and rlt.transactionType = :transactionType");
//
//                Query query = em.createQuery(sql.toString());
//                query.setParameter("entityID", entityId)
//                .setParameter("revenueType", taxType)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setParameter("transactionType", Constants.TransactionType.PAYMENT);
//
//                List<BigDecimal> paymentAmountList = query.getResultList();
//                
//                sql = new StringBuffer("select rlt.amount " + 
//                                        "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp " + 
//                                        "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code " + 
//                                        "and ee.id = :entityID and rrt.code = :revenueType and rlrp.periodStart >= :startDate and rlrp.periodEnd <= :endDate and rlt.transactionType = :transactionType");
//
//                query = em.createQuery(sql.toString());
//                query.setParameter("entityID", entityId)
//                .setParameter("revenueType", taxType)
//                .setParameter("startDate", startDate)
//                .setParameter("endDate", endDate)
//                .setParameter("transactionType", Constants.TransactionType.RETURN);
//
//                List<BigDecimal> returnAmountList = query.getResultList();
//              
//                BigDecimal paymentAmount = new BigDecimal(0);
//                for (BigDecimal amount : paymentAmountList) {
//                    paymentAmount = paymentAmount.add(amount);
//                }
//                
//                BigDecimal returnAmount = new BigDecimal(0);
//                for (BigDecimal amount : returnAmountList) {
//                    returnAmount = returnAmount.add(amount);
//                }
//              
//                BigDecimal totalAmount = new BigDecimal(0);
//                totalAmount = paymentAmount.subtract(returnAmount);
//                    
//                return totalAmount.equals(claimAmount);
//        } catch (javax.persistence.NoResultException e) {
//            return equals;
//        }
//    }
    
    public DdocDocument findDocumentById(Long id) {
        try {
            DdocDocument ddocDocument = 
                (DdocDocument)em.createQuery("select o from DdocDocument o where o.id = ?1").setParameter("1", id).getSingleResult();
            return ddocDocument;
        } catch (NoResultException e) {
            return null;
        }
    }
        
//    public List<DfinAssessment> findAssessmentDetails(Long transId){
//        try {
//            return em.createQuery("select o from DfinAssessment o where o.transactionId = ?1").setParameter("1", transId).getResultList();
//        } catch (NoResultException e) {
//            return new ArrayList<DfinAssessment>();
//        }
//    }
    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public Timestamp getReturnFilingDate(Long entityId, String taxType, Long periodId) {
//                                            
//        Timestamp returnFilingDate = null;
//        try {
//        
//            String taxTypeTable = getTableForCorrespondingTaxType(entityId, taxType);
//            if (taxTypeTable == null) {
//                return null;
//            }
//
//            StringBuffer sql = 
//                new StringBuffer("select distinct tax.formType, tax.dateFiled " + 
//                                "from RevledTransaction rlt, RevAcc ra, RefTransactionType rtt, RefRevType rrt, EntEntity ee, RevledRevPeriod rlrp, DdocDocument ddd, " + taxTypeTable + " tax " + 
//                                "where rlrp.id = rlt.revledRevPeriod1.id and ee.id = ra.entEntity and rlt.revAcc = ra.id and ra.revType = rrt.code and rlt.transactionType = rtt.code and ddd.revAcc = ra.id and ddd.id = tax.ddocDocumentId " + 
//                                "and ee.id = :entityID and rrt.code = :revenueType and rlrp.id = :periodId and rlt.transactionType = :transactionType");
//
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("entityID", entityId)
//            .setParameter("revenueType", taxType)
//            .setParameter("periodId", periodId)
//            .setParameter("transactionType", Constants.TransactionType.RETURN);
//
//            List formTypeAndDateFiledList = query.getResultList();
//                
//            returnFilingDate = getDateFiledForCorrespondingTaxTypeAndFormType(entityId, taxType, formTypeAndDateFiledList);
//                
//            return returnFilingDate;
//        } catch (javax.persistence.NoResultException e) {
//            return returnFilingDate;
//        }
//    }
    
    public String getTableForCorrespondingTaxType(Long entityId, String taxType) {
        String table = null;
        EntEntity entEntity = null;
        
        if (entityId != null) {
            entEntity = em.find(EntEntity.class, entityId);
        }
        
        if (taxType != null) {
            if (taxType.equalsIgnoreCase(Constants.Regimes.IIT)) {
                if (entEntity != null && entEntity.getEntityType() != null) {
                    if (entEntity.getEntityType().equalsIgnoreCase(Constants.Entity.INDIVIDUAL_TYPE)) {
                        table = "ItrIndividualTxn";
                    } else {
                        table = "ItrNonIndividualTxn";
                    }
                }
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.VAT)) {
                table = "VatReturnTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.PTX)
                || taxType.equalsIgnoreCase(Constants.Regimes.PTX_IPO)
                || taxType.equalsIgnoreCase(Constants.Regimes.PTX_Q)
                || taxType.equalsIgnoreCase(Constants.Regimes.PTX_SL)
                || taxType.equalsIgnoreCase(Constants.Regimes.PTX_STK)) {
                table = "PercentageTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.EXC_ANE)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_AP)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_AV)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_MP)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_PP)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_SP)
                || taxType.equalsIgnoreCase(Constants.Regimes.EXC_TP)) {
                table = "ExciseTaxTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.ESTATE)) {
                table = "EstateTaxTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.WTX_BNK)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_COM)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_EXP)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_FB)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_FIN)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_OTH)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_PTX)
                || taxType.equalsIgnoreCase(Constants.Regimes.WTX_VAT)) {
                table = "WithholdingTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.CGT_RP)
                || taxType.equalsIgnoreCase(Constants.Regimes.CGT_ST_CS)) {
                table = "CapitalGainTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.DST)
                || taxType.equalsIgnoreCase(Constants.Regimes.DST_R)) {
                table = "DocumentStampTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.DON)) {
                table = "DonorsTaxTxn";
            } else if (taxType.equalsIgnoreCase(Constants.Regimes.IAE)) {
                table = "AccEarningTxn";
            }
        }
        
        return table;
    }
    
    public Timestamp getDateFiledForCorrespondingTaxTypeAndFormType(Long entityId, String taxType, List formTypeAndDateFiledList) {
    
        Timestamp dateFiled = null;
        EntEntity entEntity = null;
    
        if (entityId != null) {
            entEntity = em.find(EntEntity.class, entityId);
        }
    
        for (int i = 0; i < formTypeAndDateFiledList.size(); i++) {
            Object[] columns = (Object[])formTypeAndDateFiledList.get(i);
            String formType = (String)columns[0];
            Timestamp date = (Timestamp)columns[1];
            if (taxType != null) {
                if (taxType.equalsIgnoreCase(Constants.Regimes.IIT)) {
                    if (entEntity != null && entEntity.getEntityType() != null) {
                        if (entEntity.getEntityType().equalsIgnoreCase(Constants.Entity.INDIVIDUAL_TYPE)) {
                            if (formType.equalsIgnoreCase("1700")) {
                                dateFiled = date;
                            }
                        } else {
                            dateFiled = date;
                        }
                    }
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.VAT)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.PTX)
                    || taxType.equalsIgnoreCase(Constants.Regimes.PTX_IPO)
                    || taxType.equalsIgnoreCase(Constants.Regimes.PTX_Q)
                    || taxType.equalsIgnoreCase(Constants.Regimes.PTX_SL)
                    || taxType.equalsIgnoreCase(Constants.Regimes.PTX_STK)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.EXC_ANE)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_AP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_AV)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_MP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_PP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_SP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.EXC_TP)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.ESTATE)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.WTX_BNK)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_COM)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_EXP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_FB)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_FIN)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_OTH)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_PTX)
                    || taxType.equalsIgnoreCase(Constants.Regimes.WTX_VAT)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.CGT_RP)
                    || taxType.equalsIgnoreCase(Constants.Regimes.CGT_ST_CS)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.DST)
                    || taxType.equalsIgnoreCase(Constants.Regimes.DST_R)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.DON)) {
                    dateFiled = date;
                } else if (taxType.equalsIgnoreCase(Constants.Regimes.IAE)) {
                    dateFiled = date;
                }
            }
        }
        return dateFiled;
    }
    
    public BigDecimal computeCreditInterestDue(Long entityId, String taxType, Long periodId, Calendar approvalDate, BigDecimal actualRefundAmount) {
        Calendar returnFilingDate = null;  //TODO - RevledRevPeriod/RevledTransactionCleanup
         //TODO - RevledRevPeriod/RevledTransactionCleanup
//        Calendar returnFilingDate = DateHelper.getCalendar(getReturnFilingDate(entityId, taxType, periodId));
        BigDecimal creditInterestDue = null;

        if (approvalDate != null && returnFilingDate != null) {
            if (approvalDate.get(Calendar.YEAR) == returnFilingDate.get(Calendar.YEAR) 
            && approvalDate.get(Calendar.MONTH) == returnFilingDate.get(Calendar.MONTH)
            && approvalDate.get(Calendar.DAY_OF_MONTH) == returnFilingDate.get(Calendar.DAY_OF_MONTH)) {
            } else if(approvalDate.after(returnFilingDate)) {
                        
                int daysLate = 0;
                        
                int approvalYear = approvalDate.get(Calendar.YEAR);
                int approvalMonth = approvalDate.get(Calendar.MONTH) + 1;
                int approvalDay = approvalDate.get(Calendar.DAY_OF_MONTH);
                        
                int returnPeriodYear = returnFilingDate.get(Calendar.YEAR);
                int returnPeriodMonth = returnFilingDate.get(Calendar.MONTH) + 1;
                int returnPeriodDay = returnFilingDate.get(Calendar.DAY_OF_MONTH);
                                
                int tempFirstInstallmentMonth = 11;
                int tempDueDateMonth = returnPeriodMonth;
                for (int x = returnPeriodYear; x <= approvalYear; x++) {
                    if (x != returnPeriodYear) {
                        tempDueDateMonth = 0;
                    }
                    if (x == approvalYear) {
                        tempFirstInstallmentMonth = approvalMonth;
                    }
                    if (approvalYear == returnPeriodYear && approvalMonth == returnPeriodMonth) {
                        daysLate = approvalDay - returnPeriodDay;
                    } else {
                        for(int y = tempDueDateMonth; y <= tempFirstInstallmentMonth; y++) {
                            Calendar cal = null;
                            if (y == returnPeriodMonth && x == returnPeriodYear) {
                                cal = new GregorianCalendar(x, y, returnPeriodDay);
                                daysLate = daysLate + (cal.getActualMaximum(Calendar.DAY_OF_MONTH) - returnPeriodDay);
                            } else if (y == approvalMonth && x == approvalYear) {
                                daysLate = daysLate + approvalDay;
                            } else {
                                cal = new GregorianCalendar(x, y, 1);
                                daysLate = daysLate + cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                            }
                        }
                    }
                }
                creditInterestDue = ((actualRefundAmount.multiply(new BigDecimal(0.06))).multiply(new BigDecimal(daysLate)));
            } 
        }
        return creditInterestDue;
    }
        
//    public OpsCase createAuditRefundCase(CaseInputType caseInputType) {
//        return caseManagement.saveOrUpdate(caseInputType, OpsCase.class, CaseManagementMessageHelper.class);
//    }
//    
//    public OpsCase getCaseDetailsByEntityIdCaseTypeTaxTypeAndPeriodRange(Long entityId, String caseType, String taxType, Timestamp startDate, Timestamp endDate) {
//        OpsCase opsCase = null;
//        try{
//            StringBuffer sql = 
//                new StringBuffer("select oc " + 
//                                "from OpsCase oc, OpsCaseTaxType optt " + 
//                                "where oc.id = optt.opsCase.id " +
//                                "and oc.caseType = 'AD' " + 
//                                "and oc.entityId = :entityId " +
//                                "and oc.caseStatus = :caseStatus " +
//                                "and optt.taxType.code = :taxType " +
//                                "and oc.taxPeriodStartDate = :startDate " + 
//                                "and oc.taxPeriodEndDate = :endDate");
//        
//            Query query = em.createQuery(sql.toString());
//            query.setParameter("entityId", entityId)
//            .setParameter("caseStatus", Constants.CaseManagementConstants.OPEN)
//            .setParameter("taxType", taxType)
//            .setParameter("startDate", startDate)
//            .setParameter("endDate", endDate);
//
//            opsCase = (OpsCase)query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        return opsCase;
//    }
    
    public Long findFlexibleFormId(Long documentId){
        try{
            return (Long)em.createQuery("select ff.id from DdocDocument dd, FlexibleForm ff where dd.id = ?1 " +
                            "and dd.flexiFormName = ff.formName").setParameter(1,documentId).getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public String findDocumentType(Long documentId){
       try {
           return (String)em.createNamedQuery("DdocDocument.findDocType").setParameter(1,documentId).getSingleResult();
       }
       catch (javax.persistence.NoResultException e) {
           return null;
       }
    }
    

    //TODO - RevledRevPeriod/RevledTransactionCleanup
//    public Long findRevIDByEntityIdRevTypeAndPeriodID(Long entityId, String revType, Long periodID) {
//
//        try {
//            Long value =
//                (Long)em.createQuery("select distinct ra.id from RevAcc ra, RevledTransaction rlt, RevledRevPeriod rlrp " +
//                                    "where ra.id = rlt.revAcc and rlt.revledRevPeriod1.id = rlrp.id " +
//                                    "and ra.entEntity = ?1 " +
//                                    "and ra.revType.code = ?2 " +
//                                    "and ra.accStatus =?3 " +
//                                    "and rlrp.id = ?4")
//                                    .setParameter(1,entityId)
//                                    .setParameter(2,revType)
//                                    .setParameter(3,Constants.Regimes.REGISTER)
//                                    .setParameter(4,periodID)
//                                    .getSingleResult();
//            return value;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        } catch (NonUniqueResultException e) {
//            return null;
//        }
//    }
    
    public Long findRevIDByEntityIdAndRevType(Long entityId, String revType) {

        try {
            Long value =
                (Long)em.createQuery("select distinct ra.id from RevAcc ra " +
                                    "where ra.entEntity = ?1 " +
                                    "and ra.revType.code = ?2 " +
                                    "and ra.accStatus =?3")
                                    .setParameter(1,entityId)
                                    .setParameter(2,revType)
                                    .setParameter(3,Constants.Regimes.REGISTER)
                                    .getSingleResult();
            return value;
        } catch (javax.persistence.NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    
    public List<AccountPeriod> findPeriodByStartDateAndRevId(Timestamp startDate, Long accId) {
        try {
            String sql = "select o from AccountPeriod o where o.periodStartDate = :startDate and o.accAccountId = :accId";

            Query query = em.createQuery(sql);
            query.setParameter("startDate", startDate)
            .setParameter("accId", accId);

            List<AccountPeriod> periodList = query.getResultList();
            return periodList;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
    
    public List<AccountPeriod> findPeriodByEndDateAndRevId(Timestamp endDate, Long accId) {
        try {
            String sql = "select o from AccountPeriod o where o.periodEndDate = :periodEnd and o.accAccountId = :accId";

            Query query = em.createQuery(sql);
            query.setParameter("periodEnd", endDate)
            .setParameter("accId", accId);

            List<AccountPeriod> periodList = query.getResultList();
            return periodList;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
    
    public List<AccountPeriod> findPeriodByPeriodRangeAndRevId(Timestamp startDate, Timestamp endDate, Long accId) {
        try {
            String sql = "select o from AccountPeriod o where o.periodStartDate >= :startDate and o.periodEndDate <= :endDate and o.accAccountId = :accId";

            Query query = em.createQuery(sql);
            query.setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .setParameter("revId", accId);

            List<AccountPeriod> periodList = query.getResultList();
            return periodList;
        } catch (javax.persistence.NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
    
//TODO - RevAccCleanup
    /**
     * @param periodType
     * @return
     * @throws Exception
     */
//    public Long generatePeriod(PeriodType periodType) throws Exception{
//        // COPIED this entire method from TaxpayerAccountingService... did not change anything in it.. 
//        // just got rid of OutputType, since we should not be using that in facade beans...
//        //
//        assert periodType != null;
//        Long id =  null;
//        String regimeType = periodType.getRegimeType();
//        List revledrevPeriodList = new ArrayList();
//        RevenueMessageHelper revenueMessageHelper = new RevenueMessageHelper();
//   
//        //get the list of all RevAcc with the given regime type
//        List revAccList = findRevAccByTypeAndStatus(regimeType);
//        for(int i =0; i < revAccList.size(); i++) {
//            RevAcc revAcc = (RevAcc) revAccList.get(i);
//            
//            //Periods that are after the EDR of RevAcc should not be created
//            Date periodStartDate = periodType.getPeriodStart().getTime();
//            Date periodEndDate = periodType.getPeriodEnd().getTime();
//            if(!periodStartDate.before(revAcc.getEdr()) || (periodStartDate.before(revAcc.getEdr()) 
//                        && !periodEndDate.before(revAcc.getEdr()))){
//
//                Integer periodNo = periodType.getPeriodNo();
//                String periodYear = periodType.getPeriodYear().toString();
//                //get a list of RevLedRevPeriod based on revacc id, period Number and period year               
//                revledrevPeriodList  = findRevledRevPeriodByRevAccId(revAcc.getId(),periodNo,periodYear);
//                // there are no registered period for the rev acc 
//                // hence create a new period
//                if (revledrevPeriodList.size() == 0) {
//                    RevledRevPeriod newRevPeriod = new RevledRevPeriod();
//                    newRevPeriod = revenueMessageHelper.setRevledRevPeriodData(newRevPeriod, periodType);
//                    newRevPeriod.setRevAcc(revAcc.getId());
//                    newRevPeriod.setPeriodstatus(Constants.RevPeriodStatus.CREATED);
//                    newRevPeriod = persistEntity(newRevPeriod);
//                    id = newRevPeriod.getId();
//                }
//            }
//        }
//
//        return id;
//    }
    
    
//TODO - RevledRevPeriodCleanup   
    /**
     * 
     * @param periodType
     * @return
     */
//    public Long autoGeneratePeriod(PeriodType periodType) {
//        // COPIED this entire method from TaxpayerAccountingService... did not change anything in it.. 
//        // just got rid of OutputType, since we should not be using that in facade beans...
//        
//        assert periodType != null;
//        RevenueMessageHelper revenueMessageHelper = new RevenueMessageHelper();
//        Long revAccId = periodType.getRegimeAccountId();
//        RevledRevPeriod newRevPeriod = new RevledRevPeriod();
//        newRevPeriod = revenueMessageHelper.setRevledRevPeriodData(newRevPeriod, periodType);
//        newRevPeriod.setRevAcc(revAccId);
//        newRevPeriod.setPeriodstatus(Constants.RevPeriodStatus.CREATED);
//        newRevPeriod = (RevledRevPeriod) persistEntity(newRevPeriod);
//       
//        return newRevPeriod.getId();
//    }
    
    public List<GenericRegimeDocumentSummaryBean> findGenericRegimeDocumentSummaries(String accountNo) {
        try {
            Long accountId = 
                (Long)em.createQuery("select acc.id from Account acc where acc.accountNumber =?1").setParameter(1, 
                                                                                                                accountNo).getSingleResult();

            List<GenericRegimeDocumentSummaryBean> results = 
                em.createQuery("select new com.technobrain.trips.dto.tax.accounting.GenericRegimeDocumentSummaryBean(doc.id," + 
                               "doc.submissionDate,doc.dtype,doc.reference) from DdocDocument doc where doc.dtype ='DECLARE'  and  doc.revAcc =?1 order by doc.id desc").setParameter(1, 
                                                                                                                                                                                             accountId).getResultList();

            List<GenericRegimeDocumentTransactionSummaryBean> beans = null;
            for (GenericRegimeDocumentSummaryBean summary: results) {
                beans = 
                        em.createQuery("select new com.technobrain.trips.dto.tax.accounting." + "GenericRegimeDocumentTransactionSummaryBean(ddoc.id,ddoc.transactionType,ddoc.taxType,ddoc.chargeAmount," + 
                                       "ddoc.glAccount,ddoc.transactionBalance) " + 
                                       "from DdocTransactionSummaryView ddoc  where  ddoc.documentId =?1 ").setParameter(1, 
                                                                                                                         summary.getDocumentId().longValue() + 
                                                                                                                         "").getResultList();

                summary.setTotalBalance(getDocumentTotalBalance(beans));

                summary.setGenericRegimeDocumentTransactions(beans);
            }

            return results;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<GenericRegimeDocumentSummaryBean>();
        }
    }
    
    private BigDecimal getDocumentTotalBalance(List<GenericRegimeDocumentTransactionSummaryBean> beans){
        BigDecimal regimeBalance = new BigDecimal(0);
        for (GenericRegimeDocumentTransactionSummaryBean docTransSummaryBean: beans){
            regimeBalance = regimeBalance.add(docTransSummaryBean.getTransactionBalance());
        }
        return regimeBalance;
    }
    
    public DdocDocument findByDocumentID(Long documentId) {
        return (DdocDocument)em.createNamedQuery("DdocDocument.findById").setParameter(1, documentId).getSingleResult();
    }
    
    public List<DdocBalananceView> findDDocBalanceByAccoundId(Long accountId){
        return  em.createQuery("select ddoc from DdocBalananceView ddoc " +
        "    where  ddoc.transactionBalance >0 and  ddoc.accountId=?1").setParameter(1, accountId).getResultList();
    }

    public List<DdocTransactionSummaryView> findDdocTransactionSummaries(String documentId){
       return  em.createQuery("select ddoc from DdocTransactionSummaryView ddoc  where ddoc.transactionBalance >0 and ddoc.documentId =?1").setParameter(1, documentId).getResultList();
    }
    
    
    
    
    public DdocDocumentInputType findDfinDdocDocumentInputType(Long id) {
        return (DdocDocumentInputType)getInputType(id, DfinDocument.class, initializeMessageHelper(DfinDocumentMessageHelper.class));
    }
    
    public DdocCurrencyAndRate findDdocCurrencyAndRateByDocId(Long ddocId){
        
            try {
                DdocCurrencyAndRate ddocCurrencyAndRate = 
                    (DdocCurrencyAndRate)em.createNamedQuery("DdocCurrencyAndRate.finByDocumentId")
                    .setParameter(1,ddocId)
                    .getSingleResult();
                    
                return ddocCurrencyAndRate;
            } catch (NoResultException e) {
                return null;
            }
            
        }

    public List<DdocBalananceView> findDDocBalByDocTypeAndPeriodId(String docType, 
                                                             Long periodId) {

        return em.createNamedQuery("DdocBalananceView.findDocumentBalanceByPeriodAndDocType")
        .setParameter(1,docType)
        .setParameter(2,periodId)
        .getResultList();

    }
    
    public List<DdocBalananceView> findDDocBalByDocTypeAndAccountId(String docType,Long accountId){
        return  em.createNamedQuery("DdocBalananceView.findDocumentBalanceByAccountAndDocType")
                .setParameter(1, docType)
                .setParameter(2, accountId)
                .getResultList();
    }
    
    public List<Long>   findDocumentIdsByPeriodAndEventType(Long periodId, String  eventType){
    
        String nativeQueryStr ="select distinct dt.document_id from ddoc_transaction dt, acc_transaction  act, evt_ddoc_event evt where act.id = dt.transaction_id " +
        " and evt.id = dt.event_id and act.account_period =?1  and evt.ref_evt_type_cat =?2";
        
        Query query = em.createNativeQuery(nativeQueryStr);
        
        Vector resultSet =null;
        Set<Long> documentIds= new HashSet<Long>();
                   
        query.setParameter(1,periodId);
        query.setParameter(2,eventType);   
        
        try {
            resultSet = (Vector) query.getResultList(); 
            if(resultSet != null && resultSet.size() > 0) {
                for(int i=0;i<resultSet.size();i++)    {
                    Vector  alreadyClaimedForCurrentId = (Vector)(resultSet.get(i));
                    documentIds.add(((BigDecimal)alreadyClaimedForCurrentId.get(0)).longValue());
                }
            }
              
        }catch (NoResultException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return new ArrayList<Long>(documentIds);
        
    }

    public DfinRevCollReceipt findDfinRevCollReceiptByReference(String reference) {
        try {
            String sqlStr = 
                "select r from DfinRevCollReceipt r where r.reference = ?1";

            return (DfinRevCollReceipt)em.createQuery(sqlStr).setParameter(1, 
                                                                           reference).getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }
    
    public List<DdocDocument> findDocumentsByFormName(String formName){
        return  em.createNamedQuery("DdocDocument.findDocumentByFormName")
                .setParameter(1, formName)
                .getResultList();
    }

}
