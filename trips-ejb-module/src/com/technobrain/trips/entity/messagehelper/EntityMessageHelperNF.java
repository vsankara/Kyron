package com.technobrain.trips.entity.messagehelper;

import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.messagehelpers.ComplexAssociationHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.message.AddressType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.entity.model.EntBankDetails;
import com.technobrain.trips.entity.model.EntBusinessSector;
import com.technobrain.trips.entity.model.EntContactMethod;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.entity.model.EntIdentification;
import com.technobrain.trips.entity.model.EntIndustryOccupation;
import com.technobrain.trips.entity.model.EntLocation;
import com.technobrain.trips.entity.model.EntNotes;
import com.technobrain.trips.entity.model.EntOrganization;
import com.technobrain.trips.entity.model.EntPartnerAddInfo;
import com.technobrain.trips.entity.model.EntPayCardDetails;
import com.technobrain.trips.entity.model.EntProperty;
import com.technobrain.trips.entity.model.EntReasonHistory;
import com.technobrain.trips.entity.model.EntRelationship;
import com.technobrain.trips.entity.model.EntSimplified;
import com.technobrain.trips.entity.model.EntSite;
import com.technobrain.trips.entity.model.EntTradingAs;
import com.technobrain.trips.entity.model.EntVehicle;
import com.technobrain.trips.entity.service.EntityFacadeLocal;
import com.technobrain.trips.reference.model.RefIdentifierType;
import com.technobrain.trips.registration.messagehelper.TaxpayerRegistrationMessageHelper;
import com.technobrain.trips.taxreturn.model.TaxpayerLandlordDetails;
import com.technobrain.trips.core.message.AttachmentType;
import com.technobrain.trips.core.message.BankDetailsInputType;
import com.technobrain.trips.core.message.BusinessSectorInputType;
import com.technobrain.trips.core.message.CardDetailsInputType;
import com.technobrain.trips.core.message.CommercialVehicalDetailsInputType;
import com.technobrain.trips.core.message.ContactMethodType;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.EntityIndustryOccupationType;
import com.technobrain.trips.core.message.EntitySiteType;
import com.technobrain.trips.core.message.IdentificationType;
import com.technobrain.trips.core.message.NoteType;
import com.technobrain.trips.core.message.OrganisationType;
import com.technobrain.trips.core.message.PropertyInputType;
import com.technobrain.trips.core.message.RelationshipType;
import com.technobrain.trips.core.message.TradingAsInputType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import com.technobrain.trips.registration.message.ReasonHistoryInputType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EntityMessageHelperNF extends MessageHelper {

    TaxpayerRegistrationMessageHelper taxpayerRegistrationMessageHelper = null;

    public EntityMessageHelperNF() {
        taxpayerRegistrationMessageHelper = new TaxpayerRegistrationMessageHelper();
        taxpayerRegistrationMessageHelper.setEm(em);
    }

    public AddressType getAddressType(EntLocation entLocation) {

        return getAddressType(entLocation, false);
    }

    public AddressType getAddressType(EntLocation entLocation, boolean idToEntSite) {
        AddressType addressType = new AddressType();
        if (entLocation != null) {
            addressType.setAddressTypeStr(entLocation.getAddressType());
            addressType.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entLocation.getIdentifyingAddressIndicator()));
            addressType.setForeignIndicator(StringHelper.getIndicatorAsBoolean(entLocation.getForeignAddressIndicator()));
            addressType.setStreetName(entLocation.getStreetName());
            addressType.setBuildingName(entLocation.getBuildingName());
            addressType.setHouseNumber(entLocation.getHouseNumber());
            addressType.setCity(entLocation.getCity());
            addressType.setCountry(entLocation.getCountry());
            addressType.setProvince(entLocation.getProvince());
            addressType.setState(entLocation.getState());
            addressType.setCounty(entLocation.getCounty());
            addressType.setEffectiveDate(DateHelper.getCalendar(entLocation.getAddressEffectiveDate()));
            addressType.setExpiryDate(DateHelper.getCalendar(entLocation.getAddressExpirationDate()));
            addressType.setPostalCode(entLocation.getPostalCode());
            addressType.setStatus(entLocation.getStatus());
            addressType.setLocationStatus(entLocation.getLocationStatus());
            addressType.setDistrict(entLocation.getDistrict());
            addressType.setMunicipality(entLocation.getMunicipality());
            addressType.setPostalRegion(entLocation.getPostalRegion());
            addressType.setPostalAddressPOBox(entLocation.getPostalAddressPOBox());
            addressType.setPostOfficeLocation(entLocation.getPostOfficeLocation());
            addressType.setPmb(StringHelper.getIndicatorAsBoolean(entLocation.getPmb()));
            addressType.setGPSLatitude(entLocation.getGPSLatitude());
            addressType.setGPSLongitude(entLocation.getGPSLongitude());
            addressType.setId(entLocation.getId());
//            if (facade instanceof EntityFacadeLocal) {
//                ((EntityFacadeLocal)facade).includeAddressAsCSV(addressType);
//            }
        }
        return addressType;
    }

    public BaseModelObject setOrganisationTypeData(BaseModelObject pojo, InputType type) {

        EntOrganization entOrganization = pojo == null ? new EntOrganization() : (EntOrganization) pojo;
        OrganisationType organizationType = (OrganisationType) type;

        entOrganization.setEntityName(organizationType.getLegalName());
        entOrganization.setEntityType(Constants.Entity.ORGANIZATION_TYPE);
        if (organizationType.getEntityStatus() != null) {
            entOrganization.setEntStatus(organizationType.getEntityStatus());
        }

        if (organizationType.getAccountYearEndDay() != null) {
            entOrganization.setAccountYearEndDay(String.valueOf(organizationType.getAccountYearEndDay()));
        }
        if (organizationType.getAccountYearEndMonth() != null) {
            entOrganization.setAccountYearEndMonth(String.valueOf(organizationType.getAccountYearEndMonth()));
        }
        entOrganization.setLegalName(organizationType.getLegalName());
        entOrganization.setBusinessStartDate(DateHelper.getSqlTimestamp(organizationType.getBusinessStartDate()));
        entOrganization.setBusinessEndDate(DateHelper.getSqlTimestamp(organizationType.getBusinessEndDate()));
        entOrganization.setLegalStatus(organizationType.getLegalStatus());

        if (organizationType.getTaxableTurnoverAtRegistration() != null) {
            entOrganization.setTaxableToverAtReg(String.valueOf(organizationType.getTaxableTurnoverAtRegistration()));
        }

        entOrganization.setExportIndicator(StringHelper.getIndicatorAsString(organizationType.isExportIndicator()));
        entOrganization.setImportIndicator(StringHelper.getIndicatorAsString(organizationType.isImportIndicator()));

        entOrganization.setBusinessEndDate(DateHelper.getSqlTimestamp(organizationType.getBusinessEndDate()));
        entOrganization.setBusinessStartDate(DateHelper.getSqlTimestamp(organizationType.getBusinessStartDate()));
        entOrganization.setCompanyRegNo(organizationType.getCompanyRegNo());

        entOrganization.setCompanyRegDate(DateHelper.getSqlTimestamp(organizationType.getCompanyRegDate()));
        entOrganization.setId(organizationType.getId());

//        if (facade instanceof EntityFacadeLocal) {
//            ((EntityFacadeLocal) facade).setEntTaxpayerTurnoverData(entOrganization, organizationType, organizationType.getTotalSalesTurnoverPA());
//        }
        entOrganization.setIntentionToEmployeOthers(StringHelper.getIndicatorAsString(organizationType.isIntentionToEmployOthersIndicator()));
        entOrganization.setExixtingBusCapEquity(organizationType.getExistingBusinessCapitalEquity());
        entOrganization.setExixtingBusCapLoan(organizationType.getExistingBusinessCapitalLoan());
        entOrganization.setWebsite(organizationType.getWebsite());
        entOrganization.setTaxConsultantIndicator(StringHelper.getIndicatorAsString(organizationType.isTaxConsultantStatusIndicator()));

        if (entOrganization.getId() == null || entOrganization.getId() == 0) {
            entOrganization.setEregNew(Constants.TRUE);
            entOrganization.setEregUpdate(Constants.FALSE);
        } else {
            entOrganization.setEregNew(Constants.FALSE);
            entOrganization.setEregUpdate(Constants.TRUE);
        }
        /* The default value of EregProcessed is false and it will be set to true 
        by DB adapter when the record is processed **/
        entOrganization.setEregProcessed(Constants.FALSE);
//	  /* This is code added to store data Orgin -source of registraion  */
//        if(organizationType != null && organizationType.getRgdRegistration()!= null &&organizationType.getRgdRegistration().equals(true)){ 
//        entOrganization.setOrigin(Constants.RGD);
//        }else{
//         entOrganization.setOrigin(Constants.GRA);
//        }
        entOrganization.setCreatedBy(organizationType.getCreatedBy());
        entOrganization.setUpdatedBy(organizationType.getUpdatedBy());
        return entOrganization;
    }

    public ComplexAssociationHelper getIdentificationAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntIdentificationList() == null) {
                    ((EntEntity) parent).setEntIdentificationList(new ArrayList<EntIdentification>());
                }

                ((EntEntity) parent).addEntIdentification((EntIdentification) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntIdentification((EntIdentification) child);
            }

            public Class getChildPojoClass() {
                return EntIdentification.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {

                ((EntityMessageHelperNF) messageHelper).setEntIdentificationData((EntIdentification) newChildPojo,
                        (IdentificationType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntIdentification) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntIdentification) pojo).getId());
                }
            }
        };
    }

    public EntIdentification setEntIdentificationData(EntIdentification entIdentification,
            IdentificationType identificationType) {
        entIdentification.setAccessLevel(identificationType.getAccessLevel());
        entIdentification.setCountryOfIssue(identificationType.getCountryOfIssue());
        entIdentification.setEffectiveDate(DateHelper.getSqlTimestamp(identificationType.getEffectiveDate()));
        entIdentification.setExpiryDate(DateHelper.getSqlTimestamp(identificationType.getExpiryDate()));
        entIdentification.setFalseIdentification(
                StringHelper.getIndicatorAsString(identificationType.isFalseIdentification()));
        entIdentification.setId(identificationType.getId());
        entIdentification.setIdentificationIssuer(identificationType.getIdentificationIssuer());
        entIdentification.setIdentificationNumber(identificationType.getIdentificationNumber());
        entIdentification.setIdentificationStatus(identificationType.getIdentificationStatus());
        entIdentification.setIdentificationType(identificationType.getIdentificationType());
        entIdentification.setPlaceOfIssue(identificationType.getPlaceOfIssue());
        entIdentification.setStatus(identificationType.getStatus());
        entIdentification.setContextSearch(DateHelper.getTimeInMillisecs());
        entIdentification.setDecByThumbprint(identificationType.isDeclarationByThumbPrint() == true ? 'Y' : 'N');
        entIdentification.setDateOfSignature(DateHelper.getSqlTimestamp(identificationType.getDateOfSignature()));
        entIdentification.setIdVerificationCode(identificationType.getIdVerificationCode());
        return entIdentification;
    }

    public EntLocation setEntLocationData(EntLocation entLocation, AddressType addressType) {
        entLocation = entLocation == null
                ? new EntLocation()
                : entLocation;

        entLocation.setStreetName(addressType.getStreetName());
        entLocation.setBuildingName(addressType.getBuildingName());
        entLocation.setHouseNumber(addressType.getHouseNumber());
        entLocation.setCity(addressType.getCity());
        entLocation.setCountry(addressType.getCountry());
        entLocation.setCounty(addressType.getCounty());
        entLocation.setPostalCode(addressType.getPostalCode());
        entLocation.setProvince(addressType.getProvince());
        entLocation.setAddressEffectiveDate(DateHelper.getSqlTimestamp(addressType.getEffectiveDate()));
        entLocation.setAddressExpirationDate(DateHelper.getSqlTimestamp(addressType.getExpiryDate()));
        entLocation.setStatus(addressType.getStatus());
        entLocation.setLocationStatus(addressType.getLocationStatus());
        // fill ent site
        entLocation.setIdentifyingAddressIndicator(StringHelper.getIndicatorAsString(addressType.isPrimaryIndicator()));
        entLocation.setForeignAddressIndicator(StringHelper.getIndicatorAsString(addressType.isForeignIndicator()));
        entLocation.setAddressType(addressType.getAddressTypeStr());
        // set association between entsite and location
//        entSite.setEntLocation(entLocation);
        entLocation.setCreatedBy(addressType.getCreatedBy());
        entLocation.setCreatedDate(DateHelper.getSqlTimestamp(addressType.getCreatedDate()));
        entLocation.setContextSearch(DateHelper.getTimeInMillisecs());
//        if(idToEntSite)
//            entSite.setId(addressType.getId());
//        else
        entLocation.setId(addressType.getId());
        entLocation.setState(addressType.getState());
        entLocation.setDistrict(addressType.getDistrict());
        entLocation.setMunicipality(addressType.getMunicipality());
        entLocation.setPostalRegion(addressType.getPostalRegion());
        entLocation.setPostalAddressPOBox(addressType.getPostalAddressPOBox());
        entLocation.setPmb(StringHelper.getIndicatorAsString(addressType.isPmb()));
        entLocation.setPostOfficeLocation(addressType.getPostOfficeLocation());
        entLocation.setGPSLongitude(addressType.getGPSLongitude());
        entLocation.setGPSLatitude(addressType.getGPSLatitude());

        return entLocation;
    }

    public ComplexAssociationHelper getEntLocationAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntLocationList() == null) {
                    ((EntEntity) parent).setEntLocationList(new ArrayList<EntLocation>());
                }

                ((EntEntity) parent).addEntLocation((EntLocation) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntLocation((EntLocation) child);
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

                ((EntityMessageHelperNF) messageHelper).setEntLocationData((EntLocation) newChildPojo,
                        (AddressType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntLocation) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntLocation) pojo).getId());
                }
            }
        };
    }

    public EntContactMethod setEntContactMethodData(EntContactMethod entContactMethods,
            ContactMethodType contactMethodType) {
        entContactMethods.setId(contactMethodType.getId());
        entContactMethods.setEffectiveDate(DateHelper.getSqlTimestamp(contactMethodType.getEffectiveDate()));
        entContactMethods.setContactMethodDetail(contactMethodType.getContactMethodDetail());
        entContactMethods.setEntityContactMethodPurpose(contactMethodType.getPurpose());
        entContactMethods.setEntityContactMethodType(contactMethodType.getContactMethodType());
        entContactMethods.setExpiryDate(DateHelper.getSqlTimestamp(contactMethodType.getExpiryDate()));
        //entContactMethods.setPhoneNumber(contactMethodType.getPhoneNumber());
        entContactMethods.setPrimaryIndicator(StringHelper.getIndicatorAsString(contactMethodType.isPrimaryIndicator()));
        entContactMethods.setContactMethodStatus(contactMethodType.getContactMethodStatus());
        entContactMethods.setContextSearch(DateHelper.getTimeInMillisecs());

        return entContactMethods;
    }

    public ComplexAssociationHelper getEntContactMethodAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntContactMethodList() == null) {
                    ((EntEntity) parent).setEntContactMethodList(new ArrayList<EntContactMethod>());
                }

                ((EntEntity) parent).addEntContactMethod((EntContactMethod) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntContactMethod((EntContactMethod) child);
            }

            public Class getChildPojoClass() {
                return EntContactMethod.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntContactMethodData((EntContactMethod) newChildPojo,
                        (ContactMethodType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntContactMethod) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntContactMethod) pojo).getId());
                }
            }
        };
    }

    public EntRelationship setEntRelationshipData(EntRelationship entRelationship,
            RelationshipType relationshipType) {
//        if (relationshipType.getPartnerAddInfoType() != null
//                && relationshipType.getRelationshipType().equals(Constants.RelationshipType.PARTNERS)) {
//            entRelationship = (EntPartnerAddInfo) setEntPartnerAddInfoData(entRelationship, relationshipType.getPartnerAddInfoType());
//        }

        entRelationship.setId(relationshipType.getId());
        entRelationship.setRelationshipStartDate(DateHelper.getSqlTimestamp(relationshipType.getRelationshipStartDate()));
        entRelationship.setRelationshipEndDate(DateHelper.getSqlTimestamp(relationshipType.getRelationshipEndDate()));
        entRelationship.setRelationshipType(relationshipType.getRelationshipType());
        entRelationship.setStatus(relationshipType.getStatus());
        entRelationship.setRelationshipStatus(relationshipType.getRelationshipStatus());
        //entRelationship.setNameOfEntity(relationshipType.getTargetEntityName());
        //The following if block should be executed when relationship type is Child(Simplified).
        if (relationshipType.getRelationshipTargetID() == null && !relationshipType.getRelationshipType().equals(Constants.RelationshipType.CHILD)) {
            EntSimplified simplified = new EntSimplified();
            simplified.setName(relationshipType.getTargetEntityName());
            simplified.setEntityType(Constants.RelationshipType.SIMPLIFIED);
            entRelationship.setTargetEntity(simplified);
        } //        else if (relationshipType.getSimplifiedInfoType() != null
        //                && relationshipType.getRelationshipType().equals(Constants.RelationshipType.CHILD)) {
        //            if (relationshipType.getRelationshipTargetID() != null) {
        //                EntEntity entity = em.find(EntEntity.class, relationshipType.getRelationshipTargetID());
        //                if (entity instanceof EntSimplified) {
        //                    EntSimplified simplified = (EntSimplified) entity;
        //                    simplified = setEntSimplifiedInfoData(simplified, relationshipType.getSimplifiedInfoType());
        //                }
        //                entRelationship.setTargetEntity(entity);
        //            } else {
        //                EntSimplified simplified = new EntSimplified();
        //                simplified = setEntSimplifiedInfoData(simplified, relationshipType.getSimplifiedInfoType());
        //                entRelationship.setTargetEntity(simplified);
        //            }
        //        }
        else if (relationshipType.getRelationshipTargetID() != null) {
            EntEntity entity = em.find(EntEntity.class, relationshipType.getRelationshipTargetID());
            entRelationship.setTargetEntity(entity);
        }
        entRelationship.setPrimaryIndicator(StringHelper.getIndicatorAsString(relationshipType.isPrimaryIndicator()));
        entRelationship.setOtherInfo(relationshipType.getOtherInfo());
        return entRelationship;
    }

    public ComplexAssociationHelper getEntRelationshipAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getOutgoingRelationshipList() == null) {
                    ((EntEntity) parent).setOutgoingRelationshipList(new ArrayList<EntRelationship>());
                }

                ((EntEntity) parent).addEntRelationship((EntRelationship) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntRelationship((EntRelationship) child);
            }

            public Class getChildPojoClass(InputType type) {
                if (((RelationshipType) type).getRelationshipType().equals(Constants.RelationshipType.PARTNERS)) {
                    return EntPartnerAddInfo.class;
                } else {
                    return getChildPojoClass();
                }
            }

            public Class getChildPojoClass() {
                return EntRelationship.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntRelationshipData((EntRelationship) newChildPojo,
                        (RelationshipType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntRelationship) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntRelationship) pojo).getId());
                }
            }
        };
    }

    public ComplexAssociationHelper getEntNotesAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntNotesList() == null) {
                    ((EntEntity) parent).setEntNotesList(new ArrayList<EntNotes>());
                }

                ((EntEntity) parent).addEntNotes((EntNotes) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntNotes((EntNotes) child);
            }

            public Class getChildPojoClass() {
                return EntNotes.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntNotesData((EntNotes) newChildPojo,
                        (NoteType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntNotes) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntNotes) pojo).getId());
                }
            }
        };
    }

    public EntNotes setEntNotesData(EntNotes entNotes, NoteType noteType) {
        entNotes.setId(noteType.getId());
        entNotes.setNoteDate(DateHelper.getSqlTimestamp(noteType.getNoteDate()));
        entNotes.setNotes(noteType.getNotes());
        entNotes.setSubject(noteType.getSubject());
        entNotes.setContextSearch(DateHelper.getTimeInMillisecs());
        entNotes.setOfficer(noteType.getOfficer());
        entNotes.setOtherSubject(noteType.getOtherSubject());
        return entNotes;
    }

    public ComplexAssociationHelper getCommAttachmentAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getCommAttachmentList() == null) {
                    ((EntEntity) parent).setCommAttachmentList(new ArrayList<CommAttachment>());
                }

                ((EntEntity) parent).addCommAttachment((CommAttachment) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeCommAttachment((CommAttachment) child);
            }

            public Class getChildPojoClass() {
                return CommAttachment.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntAttachmentData((CommAttachment) newChildPojo,
                        (AttachmentType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((CommAttachment) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((CommAttachment) pojo).getId());
                }
            }
        };
    }

    public CommAttachment setEntAttachmentData(CommAttachment commAttachment,
            AttachmentType attachmentType) {
        commAttachment.setId(attachmentType.getId());
        commAttachment.setAttachmentDate(DateHelper.getSqlTimestamp(attachmentType.getAttachmentDate()));
        commAttachment.setAttachmentType(attachmentType.getAttachmentType());
        commAttachment.setAttachmentPath(attachmentType.getAttachmentPath());
        commAttachment.setNotes(attachmentType.getNotes());
        commAttachment.setReference(attachmentType.getReference());
        commAttachment.setFileStoreId(attachmentType.getFileStoreId());
        return commAttachment;
    }

    public ComplexAssociationHelper getEntBankDetailsAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getBankDetailsList() == null) {
                    ((EntEntity) parent).setBankDetailsList(new ArrayList<EntBankDetails>());
                }

                ((EntEntity) parent).addEntBankDetails((EntBankDetails) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntBankDetails((EntBankDetails) child);
            }

            public Class getChildPojoClass() {
                return EntBankDetails.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntBankDetailsData((EntBankDetails) newChildPojo,
                        (BankDetailsInputType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntBankDetails) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntBankDetails) pojo).getId());
                }
            }
        };
    }

    public EntBankDetails setEntBankDetailsData(EntBankDetails entBankDetails,
            BankDetailsInputType bankDetailsInputType) {
        entBankDetails.setId(bankDetailsInputType.getId());
        entBankDetails.setAccountName(bankDetailsInputType.getAccountName());
        entBankDetails.setBankAccountNo(bankDetailsInputType.getBankAccountNo());
        entBankDetails.setBankName(bankDetailsInputType.getBankName());
        entBankDetails.setIban(bankDetailsInputType.getIBAN());
        entBankDetails.setSortcode(bankDetailsInputType.getSortCode());
        entBankDetails.setBankAccountStatus(bankDetailsInputType.getBankAccountStatus());
        entBankDetails.setContextSearch(DateHelper.getTimeInMillisecs());
        entBankDetails.setBankBranch(bankDetailsInputType.getBankBranch());
        entBankDetails.setSwiftCode(bankDetailsInputType.getSwiftCode());
        return entBankDetails;
    }

    public ComplexAssociationHelper getCommVehicleAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntCommercialVehicleList() == null) {
                    ((EntEntity) parent).setEntCommercialVehicleList(new ArrayList<EntVehicle>());
                }

                ((EntEntity) parent).addCommercialVehicle((EntVehicle) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeCommercialVehicle((EntVehicle) child);
            }

            public Class getChildPojoClass() {
                return EntVehicle.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntCommercialVehicleData((EntVehicle) newChildPojo,
                        (CommercialVehicalDetailsInputType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntVehicle) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntVehicle) pojo).getId());
                }
            }
        };
    }

    public EntVehicle setEntCommercialVehicleData(EntVehicle entVehicle,
            CommercialVehicalDetailsInputType vehicleInputType) {
        entVehicle.setId(vehicleInputType.getId());
        entVehicle.setChassisNumber(vehicleInputType.getChassisNumber());
        entVehicle.setVehicleType(vehicleInputType.getVehicleCategory());
        entVehicle.setMake(vehicleInputType.getMake());
        entVehicle.setModel(vehicleInputType.getModel());
        entVehicle.setEntityType(Constants.Entity.VEHICLE_TYPE);
        entVehicle.setVehicleDescription(vehicleInputType.getDescription());
        entVehicle.setRegistrationNumber(vehicleInputType.getVehicleRegNo());
        entVehicle.setDeferredStartDate(DateHelper.getSqlTimestamp(vehicleInputType.getDeferredStartDate()));
        entVehicle.setDeferredEndDate(DateHelper.getSqlTimestamp(vehicleInputType.getDeferredEndDate()));
        entVehicle.setWaived(StringHelper.getIndicatorAsString(vehicleInputType.isWaived()));

        return entVehicle;
    }

    public ComplexAssociationHelper getEntPayCardDetailsAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getPayCardDetailsList() == null) {
                    ((EntEntity) parent).setPayCardDetailsList(new ArrayList<EntPayCardDetails>());
                }

                ((EntEntity) parent).addEntPayCardDetails((EntPayCardDetails) child);

            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntPayCardDetails((EntPayCardDetails) child);
            }

            public Class getChildPojoClass() {
                return EntPayCardDetails.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntPayCardDetailsData((EntPayCardDetails) newChildPojo,
                        (CardDetailsInputType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntPayCardDetails) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntPayCardDetails) pojo).getId());
                }
            }
        };
    }

    public EntPayCardDetails setEntPayCardDetailsData(EntPayCardDetails entPayCardDetails,
            CardDetailsInputType cardDetailsInputType) {
        entPayCardDetails.setId(cardDetailsInputType.getId());
        entPayCardDetails.setStartDate(DateHelper.getSqlTimestamp(cardDetailsInputType.getStartDate()));
        entPayCardDetails.setEndDate(DateHelper.getSqlTimestamp(cardDetailsInputType.getEndDate()));
        entPayCardDetails.setAccountName(cardDetailsInputType.getAccountName());
        entPayCardDetails.setIssuer(cardDetailsInputType.getBankIssuer());
        entPayCardDetails.setCardNumber(cardDetailsInputType.getCardNumber());
        entPayCardDetails.setCardType(cardDetailsInputType.getCardType());
        entPayCardDetails.setCreditOrDebit(cardDetailsInputType.getCreditOrDebit());
        entPayCardDetails.setIssueNo(cardDetailsInputType.getIssueNo());
        entPayCardDetails.setSecurityCode(cardDetailsInputType.getSecurityCode());
        entPayCardDetails.setCardStatus(cardDetailsInputType.getCardStatus());
        entPayCardDetails.setContextSearch(DateHelper.getTimeInMillisecs());
        return entPayCardDetails;
    }

    private void setReasonHistoryData(EntEntity entEntity,
            ReasonHistoryInputType reasonHistoryInputType) {

        if (reasonHistoryInputType != null && reasonHistoryInputType.getReason() != null) {
            EntReasonHistory entReasonHistory = new EntReasonHistory();
            entReasonHistory.setReasonCode(reasonHistoryInputType.getReason());
            entReasonHistory.setNotes(reasonHistoryInputType.getNotes());
            entReasonHistory.setEntEntity(entEntity);

            if (entEntity.getReasonHistories() == null) {
                entEntity.setReasonHistories(new ArrayList<EntReasonHistory>());
            }

            entEntity.getReasonHistories().add(entReasonHistory);
        }
    }

//    private void setRegistrationDocument(EntEntity entEntity,
//            DocumentHeaderType documentHeaderType) {
//
//        if (documentHeaderType != null && documentHeaderType.getDocumentNumber() != null) {
//
//            if (entEntity.getRegDocument() == null) {
//                EntRegistrationDocument entRegDoc = new EntRegistrationDocument();
//                entEntity.setRegDocument(entRegDoc);
//                entRegDoc.setEntity(entEntity);
//            }
//
//            entEntity.getRegDocument().setReference(documentHeaderType.getDocumentNumber());
//        }
//    }
    public ComplexAssociationHelper getPropertyDetailsHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getPropertyDetails() == null) {
                    ((EntEntity) parent).setPropertyDetails(new ArrayList<EntProperty>());
                }
                ((EntEntity) parent).addEntProperty((EntProperty) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntProperty((EntProperty) child);
            }

            public Class getChildPojoClass() {
                return EntProperty.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                ((EntityMessageHelperNF) messageHelper).setEntPropertyDetail((EntProperty) newChildPojo,
                        (PropertyInputType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntProperty) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntProperty) pojo).getId());
                }
            }
        };
    }

    public EntProperty setEntPropertyDetail(EntProperty entProperty,
            PropertyInputType propertyType) {
        entProperty.setId(propertyType.getId());
        entProperty.setDirectionToPremises(propertyType.getTradersPremises());
        EntLocation location = null;

        if (propertyType.getAddressType() != null && propertyType.getAddressType().getId() != null) {
            location = em.find(EntLocation.class, propertyType.getAddressType().getId());
            entProperty.setEntLocation(setEntLocationData(location,
                    propertyType.getAddressType()));
        } else {
            entProperty.setEntLocation(setEntLocationData(null,
                    propertyType.getAddressType()));
        }
        if (Constants.propertyDetails.RENTED.equals(propertyType.getOwnership())
                || Constants.propertyDetails.OTHER.equals(propertyType.getOwnership())) {
            if (propertyType.getLandlordTIN() != null) {
                entProperty.setLandlordEntityId(propertyType.getLandlordEntityId());
            } else {
                entProperty.setLandlordName(propertyType.getLandlordName());
                entProperty.setLandlordAddress(propertyType.getLandlordAddress());
            }
        }
        entProperty.setPropertyType(propertyType.getPropertyType());
        entProperty.setOwnershipType(propertyType.getOwnership());
        entProperty.setPropertyTypeIndicator(StringHelper.getIndicatorAsString(propertyType.isPropertyTypeIndicator()));
        return entProperty;
    }

    public ComplexAssociationHelper getEntBusinessSectorAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntBusinessSectorList() == null) {
                    ((EntEntity) parent).setEntBusinessSectorList(new ArrayList<EntBusinessSector>());
                }

                ((EntEntity) parent).addEntBusinessSector((EntBusinessSector) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntBusinessSector((EntBusinessSector) child);
            }

            public Class getChildPojoClass() {
                return EntBusinessSector.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {

                ((EntityMessageHelperNF) messageHelper).setEntBusinessSectorData((EntBusinessSector) newChildPojo,
                        (BusinessSectorInputType) messageChild);
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntBusinessSector) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntBusinessSector) pojo).getId());
                }
            }
        };
    }

    public EntBusinessSector setEntBusinessSectorData(EntBusinessSector entBusinessSector,
            BusinessSectorInputType businessSectorType) {
        entBusinessSector.setBusinessSector(businessSectorType.getCode());
        entBusinessSector.setPrimaryIndicator(StringHelper.getIndicatorAsString(businessSectorType.isPrimaryIndicator()));
        return entBusinessSector;
    }

    public ComplexAssociationHelper getEntTradingAsAssociationHelper() {
        return new ComplexAssociationHelper() {
            public void add(BaseModelObject parent,
                    BaseModelObject child) {
                if (((EntEntity) parent).getEntTradingAsList() == null) {
                    ((EntEntity) parent).setEntTradingAsList(new ArrayList<EntTradingAs>());
                }

                ((EntEntity) parent).addEntTradingAs((EntTradingAs) child);
            }

            public void remove(BaseModelObject parent,
                    BaseModelObject child) {
                ((EntEntity) parent).removeEntTradingAs((EntTradingAs) child);
            }

            public Class getChildPojoClass() {
                return EntTradingAs.class;
            }

            public Class getMessageHelperClass() {
                return EntityMessageHelperNF.class;
            }

            public void setData(InputType messageChild,
                    BaseModelObject newChildPojo,
                    MessageHelper messageHelper) {
                TradingAsInputType tradingAsInputType = (TradingAsInputType) messageChild;
                if (tradingAsInputType.getName() != null && !tradingAsInputType.getName().trim().equals(Constants.BLANK)) {
                    ((EntityMessageHelperNF) messageHelper).setEntTradingAsData((EntTradingAs) newChildPojo,
                            (TradingAsInputType) messageChild);
                }
            }

            public Boolean compare(InputType messageChild,
                    BaseModelObject pojo) {
                if (messageChild.getId() == null
                        || ((EntTradingAs) pojo).getId() == null) {
                    return null; //return null because cannot compare
                } else {
                    return messageChild.getId().equals(((EntTradingAs) pojo).getId());
                }
            }
        };
    }

    public EntTradingAs setEntTradingAsData(EntTradingAs entTradingAs,
            TradingAsInputType tradingAsInputType) {
        entTradingAs.setName(tradingAsInputType.getName());
        entTradingAs.setPrimaryIndicator(StringHelper.getIndicatorAsString(tradingAsInputType.isPrimaryIndicator()));
        entTradingAs.setEffectiveDate(DateHelper.getSqlTimestamp(tradingAsInputType.getEffectiveDate()));
        entTradingAs.setExpiryDate(DateHelper.getSqlTimestamp(tradingAsInputType.getExpiryDate()));
        return entTradingAs;
    }

    public BaseModelObject setOrganisationTaxpayerInputTypeData(BaseModelObject pojo, InputType type) {
        if (type == null) {
            return null;
        }
        OrganisationTaxpayerInputType orgTaxpayerInputType = (OrganisationTaxpayerInputType) type;
        EntOrganization entOrganization = (EntOrganization) setOrganisationTypeData(pojo, orgTaxpayerInputType.getOrganisationDetails());

        // set origin
        if (orgTaxpayerInputType.getOrigin().equals(Constants.Origin.RGD)) {
            entOrganization.setOrigin(Constants.DBOrigin.RGD);
        } else if (orgTaxpayerInputType.getOrigin().equals(Constants.Origin.TRIPS)) {
            entOrganization.setOrigin(Constants.DBOrigin.TRIPS);
        } else if (orgTaxpayerInputType.getOrigin().equals(Constants.Origin.PORTAL)) {
            entOrganization.setOrigin(Constants.DBOrigin.PORTAL);
        }

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getIdentification().toArray(new IdentificationType[orgTaxpayerInputType.getIdentification().size()]),
                entOrganization.getEntIdentificationList(),
                getIdentificationAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getAddress().toArray(new AddressType[orgTaxpayerInputType.getAddress().size()]),
                entOrganization.getEntLocationList(),
                getEntLocationAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getContactMethod().toArray(new ContactMethodType[orgTaxpayerInputType.getContactMethod().size()]),
                entOrganization.getEntContactMethodList(),
                getEntContactMethodAssociationHelper());

        List<RelationshipType> relList = new ArrayList<>();
        if (orgTaxpayerInputType.getDirector() != null) {
            relList.addAll(orgTaxpayerInputType.getDirector());
        }
        if (orgTaxpayerInputType.getRelationship() != null) {
            relList.addAll(orgTaxpayerInputType.getRelationship());
        }
        if (orgTaxpayerInputType.getContact() != null) {
            relList.addAll(orgTaxpayerInputType.getContact());
        }
        if (orgTaxpayerInputType.getSubsidiaries() != null) {
            relList.addAll(orgTaxpayerInputType.getSubsidiaries());
        }
        if (orgTaxpayerInputType.getRelatedCompanies() != null) {
            relList.addAll(orgTaxpayerInputType.getRelatedCompanies());
        }
        if (orgTaxpayerInputType.getPartners() != null) {
            relList.addAll(orgTaxpayerInputType.getPartners());
        }
        if (orgTaxpayerInputType.getShareholders() != null) {
            relList.addAll(orgTaxpayerInputType.getShareholders());
        }

        setAssociationData(entOrganization,
                relList.toArray(new RelationshipType[relList.size()]),
                entOrganization.getOutgoingRelationshipList(),
                getEntRelationshipAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getOrganisationNotes().toArray(new NoteType[orgTaxpayerInputType.getOrganisationNotes().size()]),
                entOrganization.getEntNotesList(),
                getEntNotesAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getAttachment().toArray(new AttachmentType[orgTaxpayerInputType.getAttachment().size()]),
                entOrganization.getCommAttachmentList(),
                getCommAttachmentAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getBankDetails().toArray(new BankDetailsInputType[orgTaxpayerInputType.getBankDetails().size()]),
                entOrganization.getBankDetailsList(),
                getEntBankDetailsAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getCommercialVehicleDetails().toArray(new CommercialVehicalDetailsInputType[orgTaxpayerInputType.getCommercialVehicleDetails().size()]),
                entOrganization.getEntCommercialVehicleList(),
                getCommVehicleAssociationHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getCardDetails().toArray(new CardDetailsInputType[orgTaxpayerInputType.getCardDetails().size()]),
                entOrganization.getPayCardDetailsList(),
                getEntPayCardDetailsAssociationHelper());

        setReasonHistoryData(entOrganization, orgTaxpayerInputType.getUpdateReason());

//        setRegistrationDocument(entOrganization, orgTaxpayerInputType.getDocumentHeader());
        setAssociationData(entOrganization, orgTaxpayerInputType.getProperty().toArray(new PropertyInputType[orgTaxpayerInputType.getProperty().size()]),
                entOrganization.getPropertyDetails(),
                getPropertyDetailsHelper());

        setAssociationData(entOrganization,
                orgTaxpayerInputType.getBusinessSector().toArray(new BusinessSectorInputType[orgTaxpayerInputType.getBusinessSector().size()]),
                entOrganization.getEntBusinessSectorList(),
                getEntBusinessSectorAssociationHelper());

        if (orgTaxpayerInputType.getTradingAsDetails() != null && orgTaxpayerInputType.getTradingAsDetails().size() > 0) {
            TradingAsInputType tradingAs = orgTaxpayerInputType.getTradingAsDetails().get(0);
            if (tradingAs != null && tradingAs.getName() != null && !tradingAs.getName().trim().equals(Constants.BLANK)) {

                setAssociationData(entOrganization,
                        orgTaxpayerInputType.getTradingAsDetails().toArray(new TradingAsInputType[orgTaxpayerInputType.getTradingAsDetails().size()]),
                        entOrganization.getEntTradingAsList(),
                        getEntTradingAsAssociationHelper());
            }
        }

        if (null != orgTaxpayerInputType.getId()) {
            entOrganization.setId(orgTaxpayerInputType.getId());
        }

        return entOrganization;
    }

    @Override
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        if (type == null) {
            return null;
        } else if (type instanceof OrganisationTaxpayerInputType) {
            return setOrganisationTaxpayerInputTypeData(pojo, type);
        } else if (type instanceof OrganisationType) {
            return setOrganisationTypeData(pojo, type);
        } else {
            return null;
        }
    }

    @Override
    public InputType getData(BaseModelObject pojo) {
        if (pojo == null) {
            return null;
        } else if (pojo instanceof EntOrganization) {
            return getOrganisationTaxpayerInputTypeData(pojo);
        } else {
            return null;
        }
    }

    public IdentificationType getIdentificationType(EntIdentification entIdentification) {
        IdentificationType identificationType = new IdentificationType();
        if (entIdentification != null) {
            identificationType.setEffectiveDate(DateHelper.getCalendar(entIdentification.getEffectiveDate()));
            identificationType.setExpiryDate(DateHelper.getCalendar(entIdentification.getExpiryDate()));
            identificationType.setId(entIdentification.getId());
            identificationType.setCountryOfIssue(entIdentification.getCountryOfIssue());
            identificationType.setFalseIdentification(StringHelper.getIndicatorAsBoolean(entIdentification.getFalseIdentification()));
            identificationType.setIdentificationIssuer(entIdentification.getIdentificationIssuer());
            identificationType.setIdentificationNumber(entIdentification.getIdentificationNumber());
            identificationType.setIdentificationStatus(entIdentification.getIdentificationStatus());
            identificationType.setIdentificationType(entIdentification.getIdentificationType());
            identificationType.setPlaceOfIssue(entIdentification.getPlaceOfIssue());
            char decByThumbprint = entIdentification.getDecByThumbprint();
            identificationType.setDeclarationByThumbPrint(decByThumbprint == 'Y' ? true : false);
            identificationType.setDateOfSignature(DateHelper.getCalendar(entIdentification.getDateOfSignature()));

            RefIdentifierType tempRefIType = em.find(RefIdentifierType.class, entIdentification.getIdentificationType());
            identificationType.setVerificationType(tempRefIType.getVerificationType());
            identificationType.setAutoApproval(tempRefIType.getAutoApproval());
            identificationType.setIdVerificationCode(entIdentification.getIdVerificationCode());

        }
        return identificationType;
    }

    public ContactMethodType getContactMethodType(EntContactMethod entContactMethod) {
        ContactMethodType contactMethod = new ContactMethodType();
        if (entContactMethod != null) {
            contactMethod.setEffectiveDate(DateHelper.getCalendar(entContactMethod.getEffectiveDate()));
            contactMethod.setId(entContactMethod.getId());
            contactMethod.setContactMethodDetail(entContactMethod.getContactMethodDetail());
            contactMethod.setPurpose(entContactMethod.getEntityContactMethodPurpose());
            contactMethod.setContactMethodType(entContactMethod.getEntityContactMethodType());
            contactMethod.setStatus(entContactMethod.getStatus());
            contactMethod.setExpiryDate(DateHelper.getCalendar(entContactMethod.getExpiryDate()));
            //contactMethod.setPhoneNumber(entContactMethod.getPhoneNumber());
            contactMethod.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entContactMethod.getPrimaryIndicator()));
            contactMethod.setContactMethodStatus(entContactMethod.getContactMethodStatus());
        }
        return contactMethod;
    }

    public CommercialVehicalDetailsInputType getCommercialVehicleInputType(EntVehicle entVehicle) {
        CommercialVehicalDetailsInputType commercialVehicleType = new CommercialVehicalDetailsInputType();
        if (entVehicle != null) {
            commercialVehicleType.setId(entVehicle.getId());
            commercialVehicleType.setChassisNumber(entVehicle.getChassisNumber());
            commercialVehicleType.setVehicleCategory(entVehicle.getVehicleType());
            commercialVehicleType.setMake(entVehicle.getMake());
            commercialVehicleType.setModel(entVehicle.getModel());
            //commercialVehicleType.setEntityType(Constants.Entity.VEHICLE_TYPE);
            commercialVehicleType.setDescription(entVehicle.getVehicleDescription());
            commercialVehicleType.setVehicleRegNo(entVehicle.getRegistrationNumber());
            commercialVehicleType.setDeferredStartDate(DateHelper.getCalendar(entVehicle.getDeferredStartDate()));
            commercialVehicleType.setDeferredEndDate(DateHelper.getCalendar(entVehicle.getDeferredEndDate()));
            commercialVehicleType.setWaived(StringHelper.getIndicatorAsBoolean(entVehicle.getWaived()));
        }
        return commercialVehicleType;
    }

    public RelationshipType getRelationshipType(EntRelationship entRelationship) {
        RelationshipType relType = new RelationshipType();

        if (entRelationship != null) {
            relType.setRelationshipEndDate(DateHelper.getCalendar(entRelationship.getRelationshipEndDate()));
            relType.setRelationshipStartDate(DateHelper.getCalendar(entRelationship.getRelationshipStartDate()));
            relType.setRelationshipType(entRelationship.getRelationshipType());
            if (entRelationship.getTargetEntity() != null) {
                relType.setTargetEntityType(entRelationship.getTargetEntity().getEntityType());

                {
                    relType.setTargetEntityName(entRelationship.getTargetEntity().getEntityName());
                }
                AddressType addressTypePrimary = null;
                if (entRelationship.getTargetEntity().getEntLocationList() != null && entRelationship.getTargetEntity().getEntLocationList().size() != 0) {
                    EntLocation entLocPrimary = entRelationship.getTargetEntity().getPrimaryAddress();
                    addressTypePrimary = getAddressType(entLocPrimary);
                }
                if (addressTypePrimary != null) {
                    relType.setAddress(addressTypePrimary.getFilledAddressDetails());
                }
                relType.setEmployerTIN(entRelationship.getTargetEntity().getTin());
                relType.setRelationshipTargetID(entRelationship.getTargetEntity().getId());

                // TRGHA-6825 - fix contact detail value
                String[] relTypeListForContactDetails = new String[]{Constants.RelationshipType.Director};

                for (String validRelType : relTypeListForContactDetails) {
                    if (validRelType.equals(relType.getRelationshipType())) {
                        List<EntContactMethod> contactMethodList = entRelationship.getTargetEntity().getEntContactMethodList();

                        for (EntContactMethod entContactMethod : contactMethodList) {
                            if (entContactMethod.getPrimaryIndicator() != null && Constants.TRUE.equalsIgnoreCase(entContactMethod.getPrimaryIndicator())) {
                                String contactMethodDetail = entContactMethod.getContactMethodDetail() != null ? entContactMethod.getContactMethodDetail() : "";
                                String contactMethodType = entContactMethod.getEntityContactMethodType();

                                relType.setContactDetails(contactMethodType + " " + contactMethodDetail);
                                break;
                            }
                        }
                    }
                }
                // end of fix for contact detail value

            } else {
            }
            relType.setId(entRelationship.getId());
            relType.setStatus(entRelationship.getStatus());
            relType.setRelationshipStatus(entRelationship.getRelationshipStatus());
            relType.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entRelationship.getPrimaryIndicator()));
            relType.setOtherInfo(entRelationship.getOtherInfo());
        }
        return relType;
    }

    public NoteType getNoteType(EntNotes entNotes) {
        NoteType noteType = new NoteType();
        if (entNotes != null) {
            noteType.setNoteDate(DateHelper.getCalendar(entNotes.getNoteDate()));
            noteType.setId(entNotes.getId());
            noteType.setNotes(entNotes.getNotes());
            noteType.setStatus(entNotes.getStatus());
            noteType.setSubject(entNotes.getSubject());
            noteType.setOfficer(entNotes.getOfficer());
            noteType.setOtherSubject(entNotes.getOtherSubject());
        }
        return noteType;
    }

    public AttachmentType getAttachmentType(CommAttachment commAttachment) {
        AttachmentType attachmentInputType = new AttachmentType();
        if (commAttachment != null) {
            attachmentInputType.setId(commAttachment.getId());
            attachmentInputType.setAttachmentDate(DateHelper.getCalendar(commAttachment.getAttachmentDate()));
            attachmentInputType.setAttachmentType(commAttachment.getAttachmentType());
            attachmentInputType.setAttachmentPath(commAttachment.getAttachmentPath());
            attachmentInputType.setNotes(commAttachment.getNotes());
            attachmentInputType.setReference(commAttachment.getReference());
            attachmentInputType.setFileStoreId(commAttachment.getFileStoreId());
        }
        return attachmentInputType;
    }

    public BankDetailsInputType getBankDetailsInputType(EntBankDetails entBankDetails) {
        BankDetailsInputType bankDetailsType = new BankDetailsInputType();
        if (entBankDetails != null) {
            bankDetailsType.setId(entBankDetails.getId());
            bankDetailsType.setAccountName(entBankDetails.getAccountName());
            bankDetailsType.setBankAccountNo(entBankDetails.getBankAccountNo());
            bankDetailsType.setBankName(entBankDetails.getBankName());
            bankDetailsType.setIBAN(entBankDetails.getIban());
            bankDetailsType.setSortCode(entBankDetails.getSortcode());
            bankDetailsType.setBankAccountStatus(entBankDetails.getBankAccountStatus());
            bankDetailsType.setBankBranch(entBankDetails.getBankBranch());
            bankDetailsType.setSwiftCode(entBankDetails.getSwiftCode());
        }
        return bankDetailsType;
    }

    public CardDetailsInputType getCardDetailsInputType(EntPayCardDetails entPayCardDetails) {
        CardDetailsInputType cardDetailsType = new CardDetailsInputType();
        if (entPayCardDetails != null) {
            cardDetailsType.setEndDate(DateHelper.getCalendar(entPayCardDetails.getEndDate()));
            cardDetailsType.setStartDate(DateHelper.getCalendar(entPayCardDetails.getStartDate()));
            cardDetailsType.setId(entPayCardDetails.getId());
            cardDetailsType.setAccountName(entPayCardDetails.getAccountName());
            cardDetailsType.setBankIssuer(entPayCardDetails.getIssuer());
            cardDetailsType.setCardNumber(entPayCardDetails.getCardNumber());
            cardDetailsType.setCardType(entPayCardDetails.getCardType());
            cardDetailsType.setCreditOrDebit(entPayCardDetails.getCreditOrDebit());
            cardDetailsType.setIssueNo(entPayCardDetails.getIssueNo());
            cardDetailsType.setCardStatus(entPayCardDetails.getCardStatus());
            if (entPayCardDetails.getSecurityCode() != null) {
                cardDetailsType.setSecurityCode(entPayCardDetails.getSecurityCode());
            }
        }
        return cardDetailsType;
    }

    public EntityIndustryOccupationType getEntityIndustryOccupationType(EntIndustryOccupation entIndustryOccupation) {
        EntityIndustryOccupationType industryOccupationType = new EntityIndustryOccupationType();
        if (entIndustryOccupation != null) {
            industryOccupationType.setId(entIndustryOccupation.getId());
            industryOccupationType.setIndustryOccupationCode(entIndustryOccupation.getCode());
            industryOccupationType.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entIndustryOccupation.getPrimaryIndicator()));
            industryOccupationType.setClassificationType(entIndustryOccupation.getType());
        }
        return industryOccupationType;
    }

    public BusinessSectorInputType getBusinessSectorType(EntBusinessSector entBusinessSector) {
        BusinessSectorInputType businessSectorType = new BusinessSectorInputType();
        if (businessSectorType != null) {
            businessSectorType.setId(entBusinessSector.getId());
            businessSectorType.setCode(entBusinessSector.getBusinessSector());
            businessSectorType.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entBusinessSector.getPrimaryIndicator()));
            if (facade != null && facade instanceof EntityFacadeLocal) {
                businessSectorType.setDescription(((EntityFacadeLocal) facade).findRefDescription(entBusinessSector.getBusinessSector(), DataReference.BUSINESS_SECTOR));
            }
        }
        return businessSectorType;
    }

    public TradingAsInputType getTradingAsType(EntTradingAs entTradingAs) {
        TradingAsInputType taType = new TradingAsInputType();
        if (entTradingAs != null) {
            taType.setId(entTradingAs.getId());
            taType.setName(entTradingAs.getName());
            taType.setPrimaryIndicator(StringHelper.getIndicatorAsBoolean(entTradingAs.getPrimaryIndicator()));
            taType.setEffectiveDate(DateHelper.getCalendar(entTradingAs.getEffectiveDate()));
            taType.setExpiryDate(DateHelper.getCalendar(entTradingAs.getExpiryDate()));
        }
        return taType;
    }

    public EntitySiteType getEntitySiteType(EntSite entSite) {
        EntitySiteType siteType = new EntitySiteType();
        if (entSite != null) {
            siteType.setId(entSite.getId());
            siteType.setSiteType(entSite.getEntitySiteType());
            siteType.setSiteName(entSite.getSiteName());
            siteType.setCeasedDate(DateHelper.getCalendar(entSite.getCeasedDate()));
            if (entSite.getEntLocation() != null) {
                siteType.setAddressType(getAddressType(entSite.getEntLocation()));
                siteType.setAddress(getAddressType(entSite.getEntLocation()).getFilledAddressDetails());
            }
        }
        return siteType;
    }

    public PropertyInputType getPropertyInputType(EntProperty property) {
        PropertyInputType propertyType = new PropertyInputType();
        if (property != null) {
            propertyType.setId(property.getId());
            propertyType.setTradersPremises(property.getDirectionToPremises());
            propertyType.setPropertyType(property.getPropertyType());
            if (Constants.propertyDetails.RENTED.equals(property.getOwnershipType())
                    || Constants.propertyDetails.OTHER.equals(property.getOwnershipType())) {
                if (property.getLandlordEntityId() != null) {
                    EntEntity entEntity
                            = ((EntityFacadeLocal) facade).getEntEntity(property.getLandlordEntityId());
                    propertyType.setLandlordTIN(entEntity.getTin());
                    propertyType.setLandlordName(entEntity.getEntityName());
                    propertyType.setLandlordEntityId(property.getLandlordEntityId());

                    List<TaxpayerLandlordDetails> landlordList = em.createNamedQuery("TaxpayerLandlordDetails.findLandlordAddressByLandlordTin")
                            .setParameter(1, property.getLandlordEntityId()).getResultList();
                    if (landlordList != null && landlordList.size() > 0) {
                        propertyType.setLandlordAddress(landlordList.get(0).getLandlordAddress());
                    }

                } else {
                    propertyType.setLandlordName(property.getLandlordName());
                    propertyType.setLandlordAddress(property.getLandlordAddress());
                }
            }
            propertyType.setAddressType(getAddressType(property.getEntLocation()));
            propertyType.setAddress(getAddressType(property.getEntLocation()).getFilledAddressDetails());
            propertyType.setOwnership(property.getOwnershipType());
            propertyType.setPropertyTypeIndicator(StringHelper.getIndicatorAsBoolean(property.getPropertyTypeIndicator()));
        }

        return propertyType;
    }

    public InputType getOrganisationTaxpayerInputTypeData(BaseModelObject pojo) {
        EntOrganization entOrganization = (EntOrganization) pojo;
        OrganisationTaxpayerInputType orgTaxpayerInputType = null;
        orgTaxpayerInputType = MessageHelper.init(orgTaxpayerInputType, OrganisationTaxpayerInputType.class);
        OrganisationType orgType = orgTaxpayerInputType.getOrganisationDetails();
        setCommonFieldsDataToInputType(entOrganization, orgTaxpayerInputType);

        orgType.setLegalName(entOrganization.getEntityName());

        // set origin
        switch (entOrganization.getOrigin()) {
            case Constants.DBOrigin.RGD:
                orgTaxpayerInputType.setOrigin(Constants.Origin.RGD);
                break;
            case Constants.DBOrigin.TRIPS:
                orgTaxpayerInputType.setOrigin(Constants.Origin.TRIPS);
                break;
            case Constants.DBOrigin.PORTAL:
                orgTaxpayerInputType.setOrigin(Constants.Origin.PORTAL);
                break;
            default:
                break;
        }

        if (entOrganization.getAccountYearEndDay() != null) {
            orgType.setAccountYearEndDay(Integer.valueOf(entOrganization.getAccountYearEndDay()));
        }
        if (entOrganization.getAccountYearEndMonth() != null) {
            orgType.setAccountYearEndMonth(Integer.valueOf(entOrganization.getAccountYearEndMonth()));
        }
        orgType.setLegalName(entOrganization.getLegalName());
        orgType.setBusinessStartDate(DateHelper.getCalendar(entOrganization.getBusinessStartDate()));
        orgType.setBusinessEndDate(DateHelper.getCalendar(entOrganization.getBusinessEndDate()));
        orgType.setLegalStatus(entOrganization.getLegalStatus());

        if (entOrganization.getTaxableToverAtReg() != null) {
            orgType.setTaxableTurnoverAtRegistration(new BigDecimal(entOrganization.getTaxableToverAtReg()));
        }

        orgType.setBusinessEndDate(DateHelper.getCalendar(entOrganization.getBusinessEndDate()));
        orgType.setBusinessStartDate(DateHelper.getCalendar(entOrganization.getBusinessStartDate()));
        orgType.setExportIndicator(StringHelper.getIndicatorAsBoolean(entOrganization.getExportIndicator()));
        orgType.setImportIndicator(StringHelper.getIndicatorAsBoolean(entOrganization.getImportIndicator()));
        orgType.setCompanyRegNo(entOrganization.getCompanyRegNo());
        orgType.setCompanyRegDate(DateHelper.getCalendar(entOrganization.getCompanyRegDate()));
        orgType.setId(entOrganization.getId());
        Long taxpayerTurnover = null;
//        if (facade instanceof EntityFacadeLocal) {
//            taxpayerTurnover= (Long)((EntityFacadeLocal)facade).getEntTaxpayerTurnoverData(entOrganization);
//        }

        orgType.setTotalSalesTurnoverPA(taxpayerTurnover);
        orgType.setIntentionToEmployOthersIndicator(StringHelper.getIndicatorAsBoolean(entOrganization.getIntentionToEmployeOthers()));
        orgType.setExistingBusinessCapitalEquity(entOrganization.getExixtingBusCapEquity());
        orgType.setExistingBusinessCapitalLoan(entOrganization.getExixtingBusCapLoan());
        orgType.setWebsite(entOrganization.getWebsite());
        orgType.setTaxConsultantStatusIndicator(StringHelper.getIndicatorAsBoolean(entOrganization.getTaxConsultantIndicator()));

        orgTaxpayerInputType.setId(entOrganization.getId());

        if (entOrganization.getEntIdentificationList() != null) {
            int noOfIdentification = entOrganization.getEntIdentificationList().size();
            List<IdentificationType> identificationType = new ArrayList<>();
            for (int i = 0; i < noOfIdentification; i++) {
                identificationType.add(getIdentificationType(entOrganization.getEntIdentificationList().get(i)));
            }
            orgTaxpayerInputType.getIdentification().addAll(identificationType);
        }

        if (entOrganization.getEntLocationList() != null) {
            int noOfSites = entOrganization.getEntLocationList().size();
            List<AddressType> addressType = new ArrayList<>();
            for (int i = 0; i < noOfSites; i++) {
                addressType.add(getAddressType(entOrganization.getEntLocationList().get(i)));
            }
            orgTaxpayerInputType.getAddress().addAll(addressType);
        }

        if (entOrganization.getEntContactMethodList() != null) {
            int noOfConMethod = entOrganization.getEntContactMethodList().size();
            List<ContactMethodType> conMethod = new ArrayList<>();
            for (int i = 0; i < noOfConMethod; i++) {
                conMethod.add(getContactMethodType(entOrganization.getEntContactMethodList().get(i)));
            }
            orgTaxpayerInputType.getContactMethod().addAll(conMethod);
        }

        if (entOrganization.getEntCommercialVehicleList() != null) {
            int noOfCommVehicle = entOrganization.getEntCommercialVehicleList().size();
            List<CommercialVehicalDetailsInputType> vehs = new ArrayList<>();
            for (int i = 0; i < noOfCommVehicle; i++) {
                vehs.add(getCommercialVehicleInputType(entOrganization.getEntCommercialVehicleList().get(i)));
            }
            orgTaxpayerInputType.getCommercialVehicleDetails().addAll(vehs);
        }

        if (entOrganization.getOutgoingRelationshipList() != null) {
            int noOfRelationship = entOrganization.getOutgoingRelationshipList().size();
            List<RelationshipType> relationshipList = new ArrayList<>();
            List<RelationshipType> contactList = new ArrayList<>();
            List<RelationshipType> directorList = new ArrayList<>();
            List<RelationshipType> subsidiariesList = new ArrayList<>();
            List<RelationshipType> relatedCompaniesList = new ArrayList<>();
            List<RelationshipType> partnersList = new ArrayList<>();
            List<RelationshipType> shareholdersList = new ArrayList<>();
            for (int i = 0; i < noOfRelationship; i++) {
                if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.CONTACT)) {
                    contactList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.DIRECTOR)) {
                    directorList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.SUBSIDIARIES)) {
                    subsidiariesList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.RELATED_COMPANIES)) {
                    relatedCompaniesList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.PARTNERS)) {
                    partnersList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else if (entOrganization.getOutgoingRelationshipList().get(i).getRelationshipType().
                        equalsIgnoreCase(Constants.RelationshipType.SHAREHOLDERS)) {
                    shareholdersList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                } else {
                    relationshipList.add(getRelationshipType(entOrganization.getOutgoingRelationshipList().get(i)));
                }
            }
            orgTaxpayerInputType.getRelationship().addAll(relationshipList);
            orgTaxpayerInputType.getDirector().addAll(directorList);
            orgTaxpayerInputType.getContact().addAll(contactList);
            orgTaxpayerInputType.getSubsidiaries().addAll(subsidiariesList);
            orgTaxpayerInputType.getRelatedCompanies().addAll(relatedCompaniesList);
            orgTaxpayerInputType.getPartners().addAll(partnersList);
            orgTaxpayerInputType.getShareholders().addAll(shareholdersList);
        }

        if (entOrganization.getEntNotesList() != null) {
            int noOfNotes = entOrganization.getEntNotesList().size();
            List<NoteType> notes = new ArrayList<>();
            for (int i = 0; i < noOfNotes; i++) {
                notes.add(getNoteType(entOrganization.getEntNotesList().get(i)));
            }
            orgTaxpayerInputType.getOrganisationNotes().addAll(notes);
        }

        if (entOrganization.getCommAttachmentList() != null) {
            int noOfAttachments = entOrganization.getCommAttachmentList().size();
            List<AttachmentType> attachments = new ArrayList<>();
            for (int i = 0; i < noOfAttachments; i++) {
                attachments.add(getAttachmentType(entOrganization.getCommAttachmentList().get(i)));
            }
            orgTaxpayerInputType.getAttachment().addAll(attachments);
        }

        if (entOrganization.getBankDetailsList() != null) {
            int noOfBankDetails = entOrganization.getBankDetailsList().size();
            List<BankDetailsInputType> bankDetails = new ArrayList<>();
            for (int i = 0; i < noOfBankDetails; i++) {
                bankDetails.add(getBankDetailsInputType(entOrganization.getBankDetailsList().get(i)));
            }
            orgTaxpayerInputType.getBankDetails().addAll(bankDetails);
        }

        if (entOrganization.getEntIndustryOccupationList() != null) {
            int noOfOccupation = entOrganization.getEntIndustryOccupationList().size();
            List<EntityIndustryOccupationType> occupationType = new ArrayList<>();
            for (int i = 0; i < noOfOccupation; i++) {
                occupationType.add(getEntityIndustryOccupationType(entOrganization.getEntIndustryOccupationList().get(i)));
            }
            orgTaxpayerInputType.getIndustry().addAll(occupationType);
        }

        if (entOrganization.getPayCardDetailsList() != null) {
            int noOfCardDetails = entOrganization.getPayCardDetailsList().size();
            List<CardDetailsInputType> cardDetails = new ArrayList<>();
            for (int i = 0; i < noOfCardDetails; i++) {
                cardDetails.add(getCardDetailsInputType(entOrganization.getPayCardDetailsList().get(i)));
            }
            orgTaxpayerInputType.getCardDetails().addAll(cardDetails);
        }

        if (entOrganization.getEntBusinessSectorList() != null) {
            int noOfBusiSecs = entOrganization.getEntBusinessSectorList().size();
            List<BusinessSectorInputType> businessSectorType = new ArrayList<>();
            for (int i = 0; i < noOfBusiSecs; i++) {
                businessSectorType.add(getBusinessSectorType(entOrganization.getEntBusinessSectorList().get(i)));
            }
            orgTaxpayerInputType.getBusinessSector().addAll(businessSectorType);
        }

        InputType tempInputType = taxpayerRegistrationMessageHelper.getEntityAccountFromRegList(entOrganization.getRegTaxpayerEntityList());
        if (tempInputType != null) {
            orgTaxpayerInputType.setEntityAccount((EntityAccountType) tempInputType);
        }

        orgTaxpayerInputType.setUpdateReason(MessageHelper.init(ReasonHistoryInputType.class));

        if (entOrganization.getEntSiteList() != null) {
            int noOfSites = entOrganization.getEntSiteList().size();
            List<EntitySiteType> sites = new ArrayList<>();
            for (int i = 0; i < noOfSites; i++) {
                sites.add(getEntitySiteType(entOrganization.getEntSiteList().get(i)));
            }
            orgTaxpayerInputType.getSiteDetails().addAll(sites);
        }

        if (entOrganization.getPropertyDetails() != null) {
            int noOfProperties = entOrganization.getPropertyDetails().size();
            List<PropertyInputType> propertyDetails = new ArrayList<>();
            for (int i = 0; i < noOfProperties; i++) {
                propertyDetails.add(getPropertyInputType(entOrganization.getPropertyDetails().get(i)));
            }
            orgTaxpayerInputType.getProperty().addAll(propertyDetails);
        }

        if (entOrganization.getEntTradingAsList() != null) {
            int noOfTradeNames = entOrganization.getEntTradingAsList().size();
            List<TradingAsInputType> tradingDetails = new ArrayList<>();
            for (int i = 0; i < noOfTradeNames; i++) {
                tradingDetails.add(getTradingAsType(entOrganization.getEntTradingAsList().get(i)));
            }
            orgTaxpayerInputType.getTradingAsDetails().addAll(tradingDetails);
        }

        return orgTaxpayerInputType;
    }
}
