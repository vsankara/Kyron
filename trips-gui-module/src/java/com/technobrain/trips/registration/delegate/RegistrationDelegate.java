
package com.technobrain.trips.registration.delegate;

import com.technobrain.trips.core.bean.HeaderSummaryDetailsBean;
import com.technobrain.trips.core.delegate.BusinessDelegate;
import com.technobrain.trips.application.message.EntityAppInputType;
import com.technobrain.trips.application.messagehelper.ApplicationMessageHelper;
import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.ArrayHelper;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.AddressType;
import com.technobrain.trips.core.message.BusinessSectorInputType;
import com.technobrain.trips.core.message.ContactMethodType;
import com.technobrain.trips.core.message.EntitySiteType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.dto.registration.EntityHistory;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a delegate that reduces the coupling between presentation tiers of
 * registration and relevant EJB.
 * 
 * @since $Date: 2/15/2010 2:59:52 AM$
 * @version $Revision: 69$
 * @author $Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  69   TRIPS2 etis.bir.gov.ph1.63.1.4    2/15/2010 2:59:52 AM   Vythilingam
 *       Pirabaharan Organised imports and removed commented codes 
 * $
 */
public class RegistrationDelegate extends BusinessDelegate{ 
    
    /**
     * It takes an entity id as parameter and returns the header details for that entity 
     * @param entityId
     * @return the header summary details bean
     */
    public HeaderSummaryDetailsBean findHeaderDetails(Long entityId) {
        return findHeaderDetails(null, entityId);
    }
    
        /**
     * Delegates the population of the OrganisationTaxpayerInputType to the 
     * session bean 
     * @param entityId
     * @return
     */
    public OrganisationTaxpayerInputType loadOrganisationTaxpayerInputType(Long entityId) {
        
        OrganisationTaxpayerInputType orgMsgType = null;
        orgMsgType = MessageHelper.init(orgMsgType,OrganisationTaxpayerInputType.class);
        
        orgMsgType = getEntityService().findOrganisationTaxpayerInputType(entityId);
        if(orgMsgType.getEntityAccount() != null && orgMsgType.getEntityAccount().getOperatingAs() != null && 
            orgMsgType.getEntityAccount().getOperatingAs().equalsIgnoreCase(Constants.OperatingAs.BRANCH_OFFICE)){
//            EntitySiteType headOffice = getEntityService().getHeadOfficeByBranchEntityId(entityId);
//            orgMsgType.setSiteDetails(ArrayHelper.addItemToArray(orgMsgType.getSiteDetails(), headOffice));
        }
        return orgMsgType;
    }
    
        /**
     * It processes organisation taxpayer registration and returns an outputType, 
     * which contains the results of the transaction from the TripsRegOrg BPEL.
     * @param organisationTaxpayerInputType
     * @return OutputType
     */
    public OutputType processOrganisationTaxpayerInputType(OrganisationTaxpayerInputType organisationTaxpayerInputType){
        OutputType outputType = null;
        try {
//            outputType = getBpelService().registerOrganizationTaxPayer(organisationTaxpayerInputType);
            if(null != outputType)
                if(log.isDebugEnabled())log.debug(outputType.getReturnStatus());
        } catch (Exception e) {
            outputType = handleError(outputType,e);
        }
        return outputType;
    }
    
        /**
     * It takes an entity id as parameter and returns history of that entity.
     * @param entityID
     * @return
     */
    public List<EntityHistory> loadEntityHistory(Long entityID){
               List<EntityHistory> value = getDocumentService().findEntityHistory(entityID);
        return value;
    }
    
       /**
     * This method validates the RGD Number
     * @param orgRegMsg
     * @return
     */
      public ArrayList<SystemMessage> validateRGDMandatoryFields(OrganisationTaxpayerInputType orgRegMsg) {
        return getRegistrationService().validateRGDMandatoryFields(orgRegMsg);
    }
      
          /**
     * It takes an entity id as parameter and returns account id of entity account(ENTACC) 
     * for that entity.
     * (Taxpayer account not regime account).
     * @param entityId
     * @return Entity account id
     */
    public Long loadAcctIDByEntityID(Long entityId) {
        return getRegistrationService().findTaxpayerAccountByEntity(entityId).getTaxpayerAccountId();
    }
    
        /**
     * This method validates whether the address object contained has only one 
     * primary address. It returns an error message if none or more than one is 
     * selected as primary address or PASS if correct.
     * 
     * @param addressType AddressType
     * @return String
     */
    public String validateForPrimaryAddress(List<AddressType> addressType) {
        Boolean primaryIndicator = false;
        int priInd = 0;
        if(addressType != null) {
            for (int addLength = 0 ; addLength < addressType.size(); addLength++) {
                primaryIndicator = addressType.get(addLength).isPrimaryIndicator();
                if(primaryIndicator != null && primaryIndicator) {
                    priInd++;
                }
            }
            if (priInd == 0) {
                return "Global.msg.NoPrimaryAddressSelected";                        
            } else if(priInd > 1) {
                return "Global.msg.ManyPrimaryAddressSelected";                        
            } else 
                return Constants.PASS;
        }
        else  {
            return "Global.msg.NoAddressEntered";
        }
    }
    
          public List<String> validateForBusinessSectorPrimaryIndicator(List<BusinessSectorInputType> businessSectorList) {
          List<String> errorList = new ArrayList<>();
          Boolean primaryIndicator = false;
          int priInd = 0;
          if(businessSectorList != null) {
               if(businessSectorList.size() == 1){
                   if(!businessSectorList.get(0).isPrimaryIndicator()){
                       businessSectorList.get(0).setPrimaryIndicator(true);
                   }
               }
               for (int addLength = 0 ; addLength < businessSectorList.size(); addLength++) {
                   primaryIndicator = businessSectorList.get(addLength).isPrimaryIndicator();
                   if(primaryIndicator != null && primaryIndicator) {
                       priInd++;
                   }
               }
               if (priInd == 0) {
                   errorList.add("Global.msg.NoPrimaryBusinessSectorSelected");                        
               } else if(priInd > 1) {
                   errorList.add("Global.msg.ManyPrimaryBusinessSectorSelected");                        
               } 
          }
         
          return errorList;
      }
          
              /**
     * This method validates the presence of atleast one primary indicator for the 
     * contact method and also ensures not more than one detail is primary.
     * 
     * @param contactMethodType ContactMethodType
     * @return String
     */
    public String validateForPrimaryContactMethod(List<ContactMethodType> contactMethodType) {
        Boolean primaryIndicator = false;
        int priInd = 0;
        if(contactMethodType != null) {
            
            for (int contactLength = 0 ; contactLength < contactMethodType.size(); contactLength++) {
                primaryIndicator = contactMethodType.get(contactLength).isPrimaryIndicator();
                if(primaryIndicator != null && primaryIndicator) {
                    priInd++;
                }
            }
            if (priInd == 0) {
                return "Global.msg.NoPrimaryContactMethodSelected";                        
            } else if(priInd > 1) {
                return "Global.msg.ManyPrimaryContactSelected";                        
            } else 
                return Constants.PASS;
            }
            return Constants.PASS;
    }
    
        /**
     * This method validates whether the contact object containes at least one of mobile type contact
     * or phone type contact. It returns an error message if none.
     * @param contactType
     * @return String
     */
    public String validateForContactType(List<ContactMethodType> contactType) {
        if(contactType != null) {
            for(ContactMethodType contact:contactType) {
                if (contact.getContactMethodType().equalsIgnoreCase(Constants.ContactType.MOBILE)
                    || contact.getContactMethodType().equalsIgnoreCase(Constants.ContactType.PHONE) )
                    return Constants.PASS;
            }
        }
        else
            return "Global.msg.NoPhoneOrMobileContactTypeEntered";
        return "Global.msg.NoPhoneOrMobileContactTypeEntered";
        
    }
    
        /**
     * This method is used to fill the application related data.
     * @param inputType it can of type organisation or individual.
     * @param entityId
     * @param dType
     * @return
     */
    public InputType getEntityApplication(InputType inputType, Long entityId, String dType) {
        List<AppEntity> appEntity = getEntityService().findAppEntityByEntityIdAndDType(entityId, dType);
        EntityAppInputType entApp = null;
        if (appEntity != null && appEntity.size() == 1) {
            ApplicationMessageHelper appMessageHelper = (ApplicationMessageHelper)initializeMessageHelper(ApplicationMessageHelper.class);
            for(AppEntity appEntityIter : appEntity) {
                entApp = (EntityAppInputType)appMessageHelper.getData((BaseModelObject)appEntityIter);
            }
            if (inputType instanceof OrganisationTaxpayerInputType) {
                OrganisationTaxpayerInputType orgType = (OrganisationTaxpayerInputType)inputType;
                orgType.setEntityApplication(entApp);
                orgType.getEntityApplication().setSubmissionDate(DateHelper.getCalendar(appEntity.get(0).getSubmissionDate()));
                orgType.getEntityApplication().setIssueOffice(appEntity.get(0).getIssueOffice());
                return orgType;
            } else {
//                 IndividualTaxpayerInputType indType = (IndividualTaxpayerInputType)inputType;
//                indType.setEntityApplication(entApp);
//                indType.getEntityApplication().setSubmissionDate(DateHelper.getCalendar(appEntity.get(0).getSubmissionDate()));
//                indType.getEntityApplication().setIssueOffice(appEntity.get(0).getIssueOffice());
//                return indType;
                return null;
                
            }
        }
        return null;
    }
    
        /**
     * Determies if the regime selected is periodic
     * @param legalStatus
     * @return
     */
    public RefLegalStatusType isRGDRegisterRequired(final String legalStatus) {
//        if(null == legalStatus){
//            return false;
//        }else
            return getRegistrationService().isRGDRegisterRequired(legalStatus);
    }
      
      
        
}
