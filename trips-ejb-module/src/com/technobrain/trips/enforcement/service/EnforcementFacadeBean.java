package com.technobrain.trips.enforcement.service;

import com.technobrain.trips.core.service.FacadeBean;
import javax.ejb.Stateless;



@Stateless(name = "EnforcementFacade",mappedName="EnforcementFacade")
public class EnforcementFacadeBean extends FacadeBean implements EnforcementFacadeRemote,   
                                                             EnforcementFacadeLocal {
//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;
//    
//    @EJB
//    AccountFacadeLocal accountFacade; 
//    
//    @EJB
//    RefCodeAssemblerSessionEJBLocal refFacade;
//    
//    public EnforcementFacadeBean() {
//    }
//    
//    public CfgPenaltyRule processPenaltyRule(PenaltyRuleConfigInputType penaltyRuleInputType){
//        CfgPenaltyRule cfgPenaltyRule = null;
//        if (penaltyRuleInputType != null){
//            try{
//                cfgPenaltyRule = saveOrUpdate(penaltyRuleInputType, CfgPenaltyRule.class, PenaltyConfigurationMessageHelper.class);
//            }catch(Exception ex) {  
//                log.error(ex.getLocalizedMessage(), ex);
//            }
//        } 
//        return cfgPenaltyRule;   
//    }
//    
//    public OutputType processPenalty(PenaltyInputType penaltyInputType) {
//        OutputType outputType = new OutputType();
//        
////        MessageHelper helper = initializeMessageHelper(DfinDocumentMessageHelper.class);
////        DfinManualPenalty penalty = null;
////        penalty = (DfinManualPenalty) helper.setData(penalty, penaltyInputType);
////        penalty.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
////        penalty.setCreatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
////        penalty = em.merge(penalty);
////        penaltyInputType.setId(penalty.getId());
////        boolean isSuccess= true;
////        
////        outputType.setReferenceNumber(penalty.getReference());
////        outputType.setId(penalty.getId());
////        outputType.setHasErrors(isSuccess);
////        outputType.setHasMessages(true);
////        outputType.setReturnStatus(Constants.PASS);
//        
//        SubmissionOutputType output = null;
//        DefaultClientConfig cc = new DefaultClientConfig();
//          cc.getFeatures().put(
//            FeaturesAndProperties.FEATURE_DISABLE_XML_SECURITY, true);
//        Client client = Client.create(cc);
//        String clientURI="http://localhost:7101/soa-infra/resources/default/trips-manpenalty-process/ManPenaltyRestService/service";
//        WebResource webResource = client.resource(clientURI);
//        ClientResponse response = webResource.accept(MediaType.APPLICATION_XML)
//                                  .type(MediaType.APPLICATION_XML)
//                                  .post(ClientResponse.class, penaltyInputType);
//        System.out.println("Status "+response.getStatus());
//        
//        if(response.getStatus()==500){
//            System.out.println(" Internal server error in invoking restful process");
//            return null;
//        }
//        
//        Object obj = response.getEntity(SubmissionOutputType.class);
//        if(obj instanceof SubmissionOutputType) {
//            output = (SubmissionOutputType) obj;
//        } else {
//            JAXBElement<SubmissionOutputType> root  = (JAXBElement<SubmissionOutputType>)obj;
//            output = root.getValue();    
//        }
//        outputType.setReferenceNumber(output.getReferenceNumber());
//        outputType.setHasErrors(false);
//        outputType.setHasMessages(true);
//        outputType.setReturnStatus(Constants.PASS);
//        
//        List<SystemMessage> msgList = new ArrayList<>();
//        SystemMessage msg = new SystemMessage();
//        msg.setCode("Manual Penalty");
//        msg.setMessage("Global.bpel.GenericNotification");
//        msgList.add(msg);
//        outputType.setMessages(msgList);
//        outputType.setErrors(msgList);
//
//        
//        return outputType;
//    }
//    
//    protected String createDocumentCharge(PenaltyInputType penaltyInputType) {
//        String success = Constants.PASS;
//        try{                   
//            DdocCharges dDocCahrges = new DdocCharges() ;
//            dDocCahrges.setDocumentId(penaltyInputType.getId());
//            dDocCahrges.setEventId(penaltyInputType.getEventId());
//            if(penaltyInputType.getAmount() != null){
//                dDocCahrges.setAmount(penaltyInputType.getAmount().doubleValue());
//            }            
//            dDocCahrges.setTaxType(penaltyInputType.getTaxType());
//            dDocCahrges.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
//            dDocCahrges.setCreatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//
//            dDocCahrges = em.merge(dDocCahrges);               
//        }catch(Exception ex){
//             success = Constants.FAIL;
//             log.error(ex.getLocalizedMessage(), ex);
//             throw new RuntimeException(ex); 
//         }
//         return success;
//    }
//    
////    @javax.ejb.TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//    public Long persistEvent(String eventType, String eventCategoryType, PenaltyInputType penaltyInputType) {
//
//        //TODO: How will we send category type to here? 
//        //It can come from NextActionInput, 
//        //**chose this option**Or we can determine that from Ddocdocument table, checking discriminator column.
//        EvtEvent evt = null;
//        RefEvtTypeCat refetc = refFacade.findEvtTypeCategory(eventType, eventCategoryType);
//        if(refetc == null)
//        {
//            // error.. no event type cat defined.
//            System.out.println(" ***** Category Not Found ***** ");
//        }
//        
//        if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.APPLICATION)) {
//            evt = new EvtDdocEvent();
//        }
//        else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.REGISTRATION)){
////            evt = new EvtRegEvent();
//        }
//        else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.RETURNS)){
////            evt = new EvtRetEvent();
//        }
//        else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.ACCOUNTING)){
////            evt = new EvtAcctEvent();
//        }
//        else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.EXEMPTIONS)){
////            evt = new EvtExemptionEvent();
//        }else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.ENFORCEMENT)){
//          evt = new DocumentChargesEvent();
//        }
//        else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.CASEMANAGEMENT)){
////            evt = new EvtCaseEvent();
//        }else if(eventCategoryType.equals(BpelConstants.EventCategoryTypes.TRANSFERTAXPAYER)){
////            evt = new EvtCaseEvent();
//        }
//        
//        
//        evt.setEventDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//        evt.setRelatedModuleID(penaltyInputType.getId());
//        evt.setRefEvtTypeCat(refetc.getCode());
//        evt.setWorkflowType("MANUAL_PENALTY");
//        evt.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
//        evt.setCreatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//        evt = em.merge(evt);
//        return evt.getId();
//        
//    }
//    
//    protected Long  createDocumentEvent(PenaltyInputType penaltyInputType) {
//        String success = Constants.PASS;
//        Long id = null;
//        try{
//            List<AdditionalField> additionalFields = new ArrayList<AdditionalField>();
//            AdditionalField evtCat = new AdditionalField();
//            evtCat.setFieldName(Constants.EventConstants.CATEGORY);
//            evtCat.setFieldValue(BpelConstants.EventCategoryTypes.ENFORCEMENT);
//            
//            AdditionalField docId = new AdditionalField();
//            docId.setFieldName(Constants.EventConstants.ENTID);
//            docId.setFieldValue(penaltyInputType.getId());
//
//            additionalFields.add(evtCat);
//            additionalFields.add(docId);
//            penaltyInputType.setAdditionalFields(additionalFields);
//            
//            id = persistEvent(Constants.EventTypes.MANUAL_PENALTY, BpelConstants.EventCategoryTypes.ENFORCEMENT, penaltyInputType);
//            
//        }catch(Exception ex){
//            success = BpelConstants.Outcomes.FAIL;
//            log.error(ex.getLocalizedMessage(), ex);
//            throw new RuntimeException(ex); 
//        }
//        return id;
//    }
//    
//    public OutputType savePenalty(PenaltyInputType penaltyInputType) {
//        OutputType outputType = new OutputType();
//        
//        MessageHelper helper = initializeMessageHelper(DfinDocumentMessageHelper.class);
//        DfinManualPenalty penalty = null;
//        penalty = (DfinManualPenalty) helper.setData(penalty, penaltyInputType);
////        penalty.setCreatedBy(Constants.Users.DEF_SYS_CREATED_BY);
////        penalty.setCreatedDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//                String username = sessionContext.getCallerPrincipal().getName();
//        EntityManagerImpl obj = (EntityManagerImpl)em.getDelegate();
//        obj.getActiveSession().getActiveUnitOfWork().setProperty(USER_ID_PARAM, username);
//        penalty = em.merge(penalty);
//        penaltyInputType.setId(penalty.getId());
//        boolean isSuccess= true;
//        
//        try{
//            Long eventId = createDocumentEvent(penaltyInputType);
//            penaltyInputType.setEventId(eventId);
//            penalty.setAssociatedEvent(eventId);
//            
//            String result = createDocumentCharge(penaltyInputType);
//            accountFacade.postToAccounts(penalty);
//        }catch(Exception ex){
//            ex.printStackTrace();
//            isSuccess=false;
//        }
//        
//        outputType.setReferenceNumber(penalty.getReference());
//        outputType.setId(penalty.getId());
//        outputType.setHasErrors(isSuccess);
//        outputType.setHasMessages(true);
//        outputType.setReturnStatus(Constants.PASS);
//        return outputType;
//    }
//    
//    public boolean isDuplicatePenaltyRule(PenaltyRuleConfigInputType penaltyRuleIn){
//        boolean isDuplicate = false;
//        String iputPenaltyCode = penaltyRuleIn.getPenaltyCode().replaceAll(" ","");
//        String existingPenaltyCode;
//        if(penaltyRuleIn != null && penaltyRuleIn.getPenaltyCode() != null){
//            List<CfgPenaltyRule> cfgPenaltyRuleList = null;
//            try {
//                String queryStr = null;
//                if(penaltyRuleIn.getId() != null){
//                    queryStr = "select obj from CfgPenaltyRule obj " +
//                               "where obj.status <> ?1 and obj.id <> ?2 ";
//                }else{
//                    queryStr = "select obj from CfgPenaltyRule obj " +
//                               "where obj.status <> ?1 ";
//                }
//                Query query = em.createQuery(queryStr);
//                if(penaltyRuleIn.getId() != null){
//                    query.setParameter(1,Constants.RecordStatus.DELETED);
//                    query.setParameter(2,penaltyRuleIn.getId());
//                }else{
//                    query.setParameter(1,Constants.RecordStatus.DELETED);
//                }                
//                cfgPenaltyRuleList = query.getResultList();
//            } catch (javax.persistence.NoResultException e) {
//                cfgPenaltyRuleList = null;
//            } catch (Exception e) {
//                log.error(e.getLocalizedMessage(), e);
//                cfgPenaltyRuleList = null;
//            }
//            
//            if (cfgPenaltyRuleList != null) {
//                for(CfgPenaltyRule aCfgPenaltyRule : cfgPenaltyRuleList){
//                    existingPenaltyCode = aCfgPenaltyRule.getPenaltyCode().replaceAll(" ","");
//                    if(existingPenaltyCode.equalsIgnoreCase(iputPenaltyCode)){
//                        isDuplicate = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return isDuplicate;
//    }
//    
//    public boolean canDeletePenaltyRule(String penaltyCode){
//        if(isPenaltyRuleInUse(penaltyCode)){
//            return false;
//        }else{
//            return true;
//        }
//    }
//
//    private boolean isPenaltyRuleInUse(String penaltyCode) {
//        if(penaltyCode != null){
//            List<DfinManualPenalty> penaltyList = null;
//            try {
//                penaltyList = em.createQuery("select obj from DfinManualPenalty obj " +
//                               "where obj.penaltyCode = ?1 ")
//                               .setParameter(1,penaltyCode)
//                               .getResultList();    
//            } catch (javax.persistence.NoResultException e) {
//                penaltyList = null;
//            } catch (Exception e) {
//                log.error(e.getLocalizedMessage(), e);
//                penaltyList = null;
//            }
//            
//            if (penaltyList != null && penaltyList.size() > 0) {               
//                return true;
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }
//    
//    public CfgPenaltyRule getActivePenaltyRuleByCode(String penaltyCode){
//        CfgPenaltyRule cfgPenaltyRule = null;
//        if(penaltyCode != null ){
//            try {
//                cfgPenaltyRule = (CfgPenaltyRule)em.createQuery("select obj from CfgPenaltyRule obj " +
//                               "where obj.penaltyCode = ?1 and obj.status = ?2 ")
//                               .setParameter(1,penaltyCode)
//                               .setParameter(2,Constants.RecordStatus.ACTIVE)
//                               .getSingleResult();
//            } catch (javax.persistence.NoResultException e) {
//                cfgPenaltyRule = null;
//            } catch (Exception e) {
//                log.error(e.getLocalizedMessage(), e);
//                cfgPenaltyRule = null;
//            }
//        }
//        return cfgPenaltyRule;
//    }
//    
//    public List<CfgPenaltyRule> findAllPenaltyCodeByTaxTypeAndStatus(String taxType,String status){
//        List<CfgPenaltyRule> cfgPenaltyRuleList = null;
//        if(taxType != null){
//            try {
//                cfgPenaltyRuleList = em.createQuery("select obj from CfgPenaltyRule obj, IN (obj.penaltyRuleTaxTypeList) prtt " +
//                               "where prtt.taxType = ?1 and obj.status = ?2 ")
//                               .setParameter(1,taxType)
//                               .setParameter(2,status)
//                               .getResultList();    
//            } catch (javax.persistence.NoResultException e) {
//                cfgPenaltyRuleList = null;
//            } catch (Exception e) {
//                log.error(e.getLocalizedMessage(), e);
//                cfgPenaltyRuleList = null;
//            }
//        }
//        return cfgPenaltyRuleList;
//        
////        SELECT OBJECT (o) FROM Order AS o IN (o.lineItems) li
////        WHERE li.quantity = ?1
//        
////        SELECT OBJECT(o) FROM Order o, IN (o.lineItems) li
////        WHERE li.product.product_type='Floppy Drive'
//        
////        SELECT OBJECT (o) FROM Order AS o IN(o.lineItems) li
////        WHERE li.product.product_type=?1 AND li.product.price=?2                                                                                   
//    }
//    
//    public AccountPeriod getCurrentAccPeriodByAcctIdAndReturnType(Long acctId,String returnType){
//        AccountPeriod currPeriod = null;
//        try{
//            if(returnType == null){
//                List<AccountPeriod> currPeriodList = em.createNamedQuery("AccountPeriod.findPeriodForGivenDateByAccountId")
//                            .setParameter(1,acctId)
//                            .setParameter(2,DateHelper.getSqlTimestampWithoutTime(Calendar.getInstance()))
//                            .getResultList();
//                if(currPeriodList != null && currPeriodList.size() >0){
//                    currPeriod = currPeriodList.get(0);
//                }
//            }else{
//                currPeriod = (AccountPeriod)em.createQuery("select o from AccountPeriod o where o.account.id = ?1 " + "and o.returnType = ?2 " +
//                                                    "and o.periodStartDate <= ?3 " +
//                                                    "and (o.periodEndDate >= ?3 or o.periodEndDate is NULL) ")
//                            .setParameter(1,acctId)
//                            .setParameter(2,returnType)
//                            .setParameter(3,DateHelper.getSqlTimestampWithoutTime(Calendar.getInstance()))
//                            .getSingleResult();
//            }
//        }catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            currPeriod = null;
//        }
//        return currPeriod;
//    }
//    
//    public RegTaxpayerStatusView findTaxPayerByTin(String tin) {
//        return (RegTaxpayerStatusView)em.createNamedQuery("RegTaxpayerStatusView.findTaxPayerByTin")
//                        .setParameter(1, tin)
//                        .getSingleResult(); 
//    }
}
