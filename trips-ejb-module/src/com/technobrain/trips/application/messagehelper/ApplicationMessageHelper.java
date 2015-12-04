package com.technobrain.trips.application.messagehelper;

import com.technobrain.trips.application.message.ApplicationAuthorisationInputType;
import com.technobrain.trips.application.message.ApplicationInputType;
import com.technobrain.trips.application.message.EntityAppInputType;
import com.technobrain.trips.application.message.RevenueTypeAppInputType;
import com.technobrain.trips.application.model.AppApplication;
import com.technobrain.trips.application.model.AppAuthorisation;
import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.application.model.AppEntityRegistration;
import com.technobrain.trips.application.model.AppRevenueType;
import com.technobrain.trips.application.model.AppRevenueTypeRegistration;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.messagehelpers.AttachmentMessageHelper;
import com.technobrain.trips.common.messagehelpers.ComplexAssociationHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.message.AddressType;
import com.technobrain.trips.core.message.AttachmentType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.document.messagehelper.DocumentMessageHelper;
import com.technobrain.trips.entity.messagehelper.EntityMessageHelperNF;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.entity.model.EntLocation;
//import com.crownagents.trips.exemption.message.ExExemptionCommodityInputType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ApplicationMessageHelper extends MessageHelper {
    public ApplicationMessageHelper() {
    }
    
    private AppApplication getProperInstance(AppApplication pojo, InputType type) {
        if (type instanceof EntityAppInputType) {
            EntityAppInputType entAppInputType = (EntityAppInputType) type;
            if(Constants.ApplicationDocumentTypes.AppEntityRegistration.equals(entAppInputType.getDocType()))
            {
                pojo = new AppEntityRegistration();
            }
        } 
        else if (type instanceof RevenueTypeAppInputType) {
            RevenueTypeAppInputType revTypeAppInputType = (RevenueTypeAppInputType) type;
            if(Constants.ApplicationDocumentTypes.AppRegimeRegistration.equals(revTypeAppInputType.getDocType()))
            {
                pojo = new AppRevenueTypeRegistration();
            }
        }
        else {
            pojo = new AppApplication();
        }
        return pojo;
    }
    
    
    private AppApplication setDataToAppPojos(AppApplication application, InputType type) {
        if(application instanceof AppEntity) {
            setEntityApplicationDataToPojo((AppEntity)application, (EntityAppInputType)type);
            if (application instanceof AppEntityRegistration) {
                setEntityRegistrationApplicationDataToPojo((AppEntityRegistration)application, (EntityAppInputType)type);
            }
        }
        else if(application instanceof AppRevenueType) {
            setRevenueApplicationDataToPojo((AppRevenueType)application, (RevenueTypeAppInputType)type);
            if (application instanceof AppRevenueTypeRegistration) {
                // do nothing yet... nothing specific..
            }
        
        }
        return application;
    }
    
    @Override
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        
        AppApplication application = (AppApplication)pojo;
        if(pojo == null || ((BaseNormalModelObject)pojo).getId() == null) {
            // if you created new pojos for new applications, you should change getProperInstance method.
            application = getProperInstance(application, type);
        }
        
        ApplicationInputType appInputType = (ApplicationInputType)type;
        
        //application.setDocType(appInputType.getDocType());
        application.setReason(appInputType.getReason());
        application.setRejectReason(appInputType.getRejectReason());
        application.setAccountsOfficesAddress(appInputType.getAccountsOfficeAddress());
        application.setId(appInputType.getId());
        if(appInputType.getAppAuthorisation() == null) {
            application.setAppAuthorisation(null);
        }
        else {
        // TODO: app authorisation later, we are not using appconfiguration and appauthorisation in Registration module
//            application.setAppAuthorisation(setAppAuthorisationData(application.getAppAuthorisation(), 
//                appInputType.getAppAuthorisation()));
        }
 
        application.setApplicationFeeIndicator(
            StringHelper.getIndicatorAsString(appInputType.isApplicationFeeIndicator()));
        application.setApplicationReference(appInputType.getApplicationReference());
        
        //listToReturn.toArray(new OutstandingDebtType[listToReturn.size()])
        
        
        application.setAttachmentCount(appInputType.getAttachmentCount());
        application.setAuthType(appInputType.getAuthorisationType());
        setAssociationData(application, appInputType.getAttachments().toArray(new AttachmentType[appInputType.getAttachments().size()]), 
            application.getCommAttachmentList(), getCommAttachmentAssociationHelper());
        application.setCommercialAccounts(appInputType.getCommercialAccounts());
        application.setPreviousAuthorisationNo(appInputType.getPreviousAuthorisationNo());
        
        // if you created new pojos for new applications, or added new attributes to app pojos, you should change setDataToAppPojos method.
        application = setDataToAppPojos(application, type);
        
        DocumentMessageHelper docMessageHelper = 
            initMessageHelper(DocumentMessageHelper.class);
        docMessageHelper.setDdocDocumentDataToPojo(application, appInputType);
        
        
        return application;
    }
    
   
    
    private AppAuthorisation setAppAuthorisationData(AppAuthorisation authorisation, 
        ApplicationAuthorisationInputType authInputType) {

        if(authorisation == null)
            authorisation = new AppAuthorisation();
        authorisation.setId(authInputType.getId());
        authorisation.setAuthDate(DateHelper.getSqlTimestamp(authInputType.getAuthDate()));
        authorisation.setAuthEffectiveDate(DateHelper.getSqlTimestamp(authInputType.getAuthEffectiveDate()));
        authorisation.setAuthExpiryDate(DateHelper.getSqlTimestamp(authInputType.getAuthExpiryDate()));
        authorisation.setAuthReference(authInputType.getAuthReference());
        authorisation.setAuthStatus(authInputType.getAuthStatus());

        return authorisation;
    }
    
    private ApplicationAuthorisationInputType getApplicationAuthorisationInputTypeData(AppAuthorisation pojo) {
        ApplicationAuthorisationInputType type = 
            MessageHelper.init(ApplicationAuthorisationInputType.class);
        type.setAuthDate(DateHelper.getCalendar(pojo.getAuthDate()));
        type.setAuthEffectiveDate(DateHelper.getCalendar(pojo.getAuthEffectiveDate()));
        type.setAuthExpiryDate(DateHelper.getCalendar(pojo.getAuthExpiryDate()));
        type.setAuthReference(pojo.getAuthReference());
        type.setAuthStatus(pojo.getAuthStatus());
        type.setId(pojo.getId());
        return type;
    }
    

    
    private AttachmentType[] getAttachmentDetails(List<CommAttachment> list) {
    
        AttachmentType[] types = 
            new AttachmentType[list.size()];
        int i = 0;
        AttachmentMessageHelper attachMessageHelper = 
            initMessageHelper(AttachmentMessageHelper.class);
        for (CommAttachment item: list) {
            types[i++] = (AttachmentType)attachMessageHelper.getData(item);
        }
        return types;
    }  
    
    
    @Override
    public InputType getData(BaseModelObject pojo) {
        ApplicationInputType appInputType = null;

        AppApplication application = (AppApplication)pojo;
        
        if(pojo instanceof AppEntity) {
            appInputType = MessageHelper.init(EntityAppInputType.class);
        }
        else if(pojo instanceof AppRevenueType) {
            appInputType = MessageHelper.init(RevenueTypeAppInputType.class);
        }
        
        appInputType.setAccountsOfficeAddress(application.getAccountsOfficesAddress());
        appInputType.setId(application.getId());
        //appInputType.setDocType(application.getDocType());
        if(application.getAppAuthorisation() != null)
            appInputType.setAppAuthorisation(getApplicationAuthorisationInputTypeData(application.getAppAuthorisation()));
        appInputType.setApplicationFeeIndicator(
            StringHelper.getIndicatorAsBoolean(application.getApplicationFeeIndicator()));
        appInputType.setApplicationReference(application.getApplicationReference());
//        appInputType.setApplicationStatus(application.getApplicationStatus());
        appInputType.setAttachmentCount(application.getAttachmentCount());
        appInputType.setAuthorisationType(application.getAuthType());
        appInputType.getAttachments().addAll(Arrays.asList(getAttachmentDetails(application.getCommAttachmentList()))) ;
        appInputType.setCommercialAccounts(application.getCommercialAccounts());
        appInputType.setPreviousAuthorisationNo(application.getPreviousAuthorisationNo());
        appInputType.setIssuePlace(application.getIssuePlace());
        appInputType.setIssueDate(DateHelper.getCalendar(application.getIssueDate()));
        appInputType.setReason(application.getReason());        
        DocumentMessageHelper docMessageHelper = 
            initMessageHelper(DocumentMessageHelper.class);
        docMessageHelper.setDdocDocumenDateToInputType(application, appInputType);
        
        
        if(appInputType.getDocStatus() == null) {
            appInputType.setDocStatus(Constants.DocStatus.NEW);
        }
        
        if(application instanceof AppEntity) {
            setAppEntityToInputType((AppEntity)application, (EntityAppInputType)appInputType);
        }
        else if(application instanceof AppRevenueType) {
            setAppRevenueTypeToInputType((AppRevenueType)application, (RevenueTypeAppInputType)appInputType);
        }
        
        return appInputType;
    }  
    
    
    private void setAppEntityToInputType(AppEntity application, 
                                             EntityAppInputType appInputType) {
            
        appInputType.setNewOffice(application.getNewOffice());
        if(application.getEntity() != null){
            appInputType.setEntityId(application.getEntity().getId());
        }
                                            
    }


    private void setAppRevenueTypeToInputType(AppRevenueType application, 
                                             RevenueTypeAppInputType appInputType) {
            
        appInputType.setRevenueType(application.getRevenueType());
       // TODO: more set statements needs to be written?
                                             
    }
    

    
   
    
    private ComplexAssociationHelper getCommAttachmentAssociationHelper() {
        return new ComplexAssociationHelper() {

        public void add(BaseModelObject parent, 
                        BaseModelObject child) {
            if (((AppApplication)parent).getCommAttachmentList() == 
                null) {
                ((AppApplication)parent).setCommAttachmentList(new ArrayList<CommAttachment>());
            }

            ((AppApplication)parent).addCommAttachment((CommAttachment)child);
        }

        public void remove(BaseModelObject parent, 
                           BaseModelObject child) {
            ((AppApplication)parent).removeCommAttachment((CommAttachment)child);
        }

        public Class getChildPojoClass() {
            return CommAttachment.class;
        }

        public Class getMessageHelperClass() {
            return AttachmentMessageHelper.class;
        }

        public void setData(InputType messageChild, 
                            BaseModelObject newChildPojo, 
                            MessageHelper messageHelper) {
            ((AttachmentMessageHelper)messageHelper).setData((CommAttachment)newChildPojo, 
                                                             (AttachmentType)messageChild);
        }

        public Boolean compare(InputType messageChild, 
                               BaseModelObject pojo) {
            if (messageChild.getId() == null || 
                ((CommAttachment)pojo).getId() == null) {
                return null; //return null because cannot compare
            } else {
                return messageChild.getId().equals(((CommAttachment)pojo).getId());
            }
        }
        };
    }
    
    

    public ComplexAssociationHelper getEntLocationAssociationHelper() {
        return new ComplexAssociationHelper() {
                public void add(BaseModelObject parent, 
                                BaseModelObject child) {
                    if (((EntEntity)parent).getEntLocationList() == null) {
                        ((EntEntity)parent).setEntLocationList(new ArrayList<EntLocation>());
                    }

                    ((EntEntity)parent).addEntLocation((EntLocation)child);
                }

                public void remove(BaseModelObject parent, 
                                   BaseModelObject child) {
                    ((EntEntity)parent).removeEntLocation((EntLocation)child);
                }

                public Class getChildPojoClass() {
                    return EntLocation.class;
                }

                public Class getMessageHelperClass() {
                    return EntityMessageHelperNF.class;
                }

                public void setData(InputType messageChild, 
                                    BaseModelObject newChildPojo, 
                                    MessageHelper messageHelper) {

                    ((EntityMessageHelperNF)messageHelper).setEntLocationData((EntLocation)newChildPojo, 
                                                                                 (AddressType)messageChild);
                }

                public Boolean compare(InputType messageChild, 
                                       BaseModelObject pojo) {
                    if (messageChild.getId() == null || 
                        ((EntLocation)pojo).getId() == null) {
                        return null; //return null because cannot compare
                    } else {
                        return messageChild.getId().equals(((EntLocation)pojo).getId());
                    }
                }
            };
    }
    
    

    private AppEntity setEntityApplicationDataToPojo(AppEntity pojo, 
                                                             EntityAppInputType type) {
        if(type.getEntityId() != null ){
            pojo.setEntity(em.find(EntEntity.class, type.getEntityId()));
            pojo.setEntityId(type.getEntityId());
        }
        pojo.setNewOffice(type.getNewOffice());
        return pojo;
                                                             
    }


    private AppRevenueType setRevenueApplicationDataToPojo(AppRevenueType pojo, 
                                                             RevenueTypeAppInputType type) {
        
        pojo.setRevenueType(type.getRevenueType());
        if(type.getEntityId()!=null) {
            pojo.setEntityId(type.getEntityId());
        }
        return pojo;
                                                             
    }
    
     private AppEntityRegistration setEntityRegistrationApplicationDataToPojo(AppEntityRegistration pojo, 
                                                              EntityAppInputType type) {
         // currently this is empty, because there is nothing specific to appentity.
         // this is for further use.
         return pojo;
                                                              
     }    

}

