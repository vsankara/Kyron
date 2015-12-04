package com.technobrain.trips.event.service;

import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
import com.technobrain.trips.common.constants.BpelConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.message.AdditionalField;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.model.event.DocumentChargesEvent;
import com.technobrain.trips.event.model.EvtAcctEvent;
import com.technobrain.trips.event.model.EvtCaseEvent;
import com.technobrain.trips.event.model.EvtDdocEvent;
import com.technobrain.trips.event.model.EvtEnforceEvent;
import com.technobrain.trips.event.model.EvtEvent;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name="EventFacade")
public class EventFacadeBean extends FacadeBean implements EventFacadeLocal {
@PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;
    
    @EJB
    RefCodeAssemblerSessionEJBLocal refFacade;
    
    public EventFacadeBean() {
    
    }
    
    
//    @javax.ejb.TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//    public void persistEvent(String eventType,WorkflowInfoInputType wib) {
//
//        //TODO: How will we send category type to here? 
//        //It can come from NextActionInput, 
//        //**chose this option**Or we can determine that from Ddocdocument table, checking discriminator column.
//        EvtEvent evt = null;
//        RefEvtTypeCat refetc = refFacade.findEvtTypeCategory(eventType, wib.getEventCategoryType());
//        if(refetc == null)
//        {
//            // error.. no event type cat defined.
//        }
//        
//        if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.APPLICATION)) {
//            evt = new EvtDdocEvent();
//        }
//        else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.REGISTRATION)){
//            evt = new EvtRegEvent();
//        }
//        else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.RETURNS)){
//            evt = new EvtRetEvent();
//        }
//        else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.ACCOUNTING)){
//            evt = new EvtAcctEvent();
//        }
//        else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.EXEMPTIONS)){
//            evt = new EvtExemptionEvent();
//        }else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.ENFORCEMENT)){
//            evt = new EvtEnforceEvent();
//        }
//        else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.CASEMANAGEMENT)){
//            evt = new EvtCaseEvent();
//        }else if(wib.getEventCategoryType().equals(BpelConstants.EventCategoryTypes.TRANSFERTAXPAYER)){
//            evt = new EvtCaseEvent();
//        }
//        
//        
//        evt.setEventDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//        evt.setRelatedModuleID(wib.getRelatedID());
//
//        if(refetc != null) {
//            evt.setRefEvtTypeCat(refetc.getCode());
//            evt.setWorkflowType(wib.getWorkflowType());
//            saveOrUpdate(evt);
//        }
//        
//    }
    
    /**
     * Overloaded method persistEvent accepts CategoryType, RegistrationStatus and
     * Entity_Id which should be set in the Additional Fields of the inputType.
     * @param eventType
     * @param inputType
     */
     @javax.ejb.TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
     public <T extends InputType> Long persistEvent(String eventType, T inputType) {
     
        Long docID = null;
        String categoryType = null, registrationStatus = null, wf_type = null;
        
        
        for(AdditionalField addField : inputType.getAdditionalFields()) {
        try {
          if(StringHelper.isNullOrEmptyString(categoryType) || 
             StringHelper.isNullOrEmptyString(registrationStatus) || null == docID || StringHelper.isNullOrEmptyString(wf_type)) {
            if(addField.getFieldName().equals(Constants.EventConstants.CATEGORY)) {
                categoryType = (String)addField.getFieldValue();
                continue;
            } else if(addField.getFieldName().equals(Constants.EventConstants.REGSTATUS)) {
                registrationStatus = (String)addField.getFieldValue();
                continue;
            } else if(addField.getFieldName().equals(Constants.EventConstants.ENTID)) {
                docID = (Long)addField.getFieldValue();
                continue;
            } else if(addField.getFieldName().equals(Constants.EventConstants.WF_TYPE)) {
                wf_type = (String)addField.getFieldValue();
                continue;
            }
          } else { 
                break;
          }
        } catch(NullPointerException npe) {
            //continue the loop...        
        }
    }

         //TODO: How will we send category type to here? 
         //It can come from NextActionInput, 
         //**chose this option**Or we can determine that from Ddocdocument table, checking discriminator column.
         EvtEvent evt = null;
//         RefEvtTypeCat refetc = refFacade.findEvtTypeCategory(eventType, categoryType);
//         if(refetc == null)
//         {
//             // error.. no event type cat defined.
//         }
//         
//         if(categoryType.equals(BpelConstants.EventCategoryTypes.APPLICATION)) {
//             evt = new EvtDdocEvent();
//         }
//         else if(categoryType.equals(BpelConstants.EventCategoryTypes.REGISTRATION)){
//             evt = new EvtRegEvent();
//             //evt.setRegistrationStatus(additionalParameters.get("REGSTATUS"));
//         }
//         else if(categoryType.equals(BpelConstants.EventCategoryTypes.RETURNS) 
//                  && (Constants.EventTypes.CREATE_DOC_CHARG_FILE_RETURNS.equals(eventType) || Constants.EventTypes.LODGEMENT.equals(eventType))) {
//                      evt = new DocumentChargesEvent();
//                  }
//         else if(categoryType.equals(BpelConstants.EventCategoryTypes.RETURNS)){
//              evt = new EvtRetEvent();
//              //evt.setRegistrationStatus(additionalParameters.get("REGSTATUS"));
//         }
//         else if(categoryType.equals(BpelConstants.EventCategoryTypes.ENFORCEMENT)){
//              evt = new DocumentChargesEvent();
//         }
//       else if(categoryType.equals(BpelConstants.EventCategoryTypes.EXEMPTIONS)){
//            evt = new EvtExemptionEvent();
//            AppEcrType type = (AppEcrType)inputType;
//            evt.setEventDate(DateHelper.getSqlTimestamp(type.getActionDate()));
//            evt.setInitiatedBy(type.getRoleName());
//            evt.setNotes(type.getNotes());
//            evt.setReason(type.getReason());
//        }
//         
//         evt.setEventDate(DateHelper.getSqlTimestamp(Calendar.getInstance()));
//         evt.setRelatedModuleID(docID);
//         evt.setRefEvtTypeCat(refetc.getCode());
//         evt.setRegistrationStatus(registrationStatus);
//         evt.setWorkflowType(wf_type);
//         evt = saveOrUpdate(evt);
         return evt.getId();
         
     }
     
    public Long persistEvent(EvtEvent evt, Long docId) {
        evt.setRelatedModuleID(docId);
        evt = saveOrUpdate(evt);
        return evt.getId();
    }
}
