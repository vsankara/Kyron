package com.technobrain.trips.core.delegate;

import com.technobrain.trips.core.annotation.ReferenceEntity;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.model.FileStore;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.dto.CodeAndDescription;
import com.technobrain.trips.dto.tax.accounting.GenericRegimePeriodSummaryBean;
import com.technobrain.trips.reference.model.RefCurrency;
import com.technobrain.trips.reference.model.RefEntityType;
import com.technobrain.trips.reference.model.RefOffice;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.registration.model.RegTaxpayerStatusView;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;
import com.technobrain.trips.search.helpers.SearchConfigHelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.model.UploadedFile;


/**
 * Techno Brain 2015
 * <p>
 * Provides the coupling between the reference code assembler ejb or
 * any data access service that provides reference data to the view
 * layer.
 * @since $Date: 2/18/2010 11:49:00 AM$
 * @version $Revision: 246$
 * @author $Author: Ariel Balita$
 *
 * $Log[1]:
 *  246  TRIPS2 etis.bir.gov.ph1.203.1.41  2/18/2010 11:49:00 AM  Ariel Balita
 *         added missing methods
 * $
 * $Log[1]:
 *  246  TRIPS2 etis.bir.gov.ph1.203.1.41  2/18/2010 11:49:00 AM  Ariel Balita
 *         added missing methods
 * $
 */
public class ReferenceCodeDelegate extends BusinessDelegate {
    String patternDigitCount, patternSeparator, tinBranchSeparator;
    Integer numOfChars;

//    public String findLegalStatus(Long entityId) {
//        return getReferenceService().findLegalStatus(entityId);
//    }
//
//    public List<SelectItem> findAllCollectionAgentNames(String agentName, 
//                                                        String agentType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCollectionAgentNames(agentName, 
//                                                                     agentType);
//        return FacesUtil.convertToSelectItems(l);
//    }

//    public String getRevenueMode(String regime) {
//        return getRevenueService().findRevenueMode(regime);
//    }
//    public RefDocTypeReturnTypeRel findRefDocTypeRetTypeRelByFormName(String formName){
//        return getRevenueService().findRefDocTypeRetTypeRelByFormName(formName);
//    }
//    public boolean isBadCheque(String chequeNumber) {
//        return getDocumentService().isBadCheque(chequeNumber);
//    }
//TODO - RevledRevPeriod/RevledTransactionCleanup 
//    public String findPeriodLabel(Long periodID) {
//        return getRefCodeAssemblerService().findPeriodLabel(periodID);
//    }
    
//    public List<SelectItem> findAllRefDateRecurCfgByFilingFreq(String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRefDateRecurCfgByFilingFreq(filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<SelectItem> findAllAuthorisationTypeByApplication(String authorizationType, 
//                                                                  String applicationType) {
//        
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().
//            findAllAuthorisationTypeByApplication(authorizationType,applicationType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String getOfficeTypeByRDO(String currentOffice) {
//        return getDocumentService().getOfficeByRDO(currentOffice).getOfficeType();
//    }
//
//    public List<SelectItem> findAllAllocationTypes(String allocationType) {
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().
//            findAllAllocationTypes(allocationType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllChargeType(Object allocationMethods) {
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().
//            findAll(allocationMethods,DataReference.CHARGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllAllocationMethods(Object allocationMethods) {
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().
//            findAll(allocationMethods,DataReference.ALLOCATION_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSubTaxCategories(Object subTaxes) {
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().
//            findAll(subTaxes,DataReference.SUB_TAX_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    static class SingletonHolder {
        static ReferenceCodeDelegate instance = new ReferenceCodeDelegate();
    }

    public static ReferenceCodeDelegate getInstance() {
        return SingletonHolder.instance;
    }

//    @ReferenceEntity(reference = RefStatus.class)
//    public List<SelectItem> findAllStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    
//    @ReferenceEntity(reference = RefRevCollectionRole.class)
//    public List<SelectItem> findAllRevCollectionRole(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REV_COLL_ROLES);
//        return FacesUtil.convertToSelectItems(l);
//    }
// 
//   
//    public List<SelectItem> findAllAuditPreparationDetails(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_AUDIT_PREP_DETAIL_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    @ReferenceEntity(reference =RefAuditReportDetailType.class)
//    public List<SelectItem> findAllAuditReportDetails(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_AUDIT_REPORT_DETAIL_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference =RefOfficerGrade.class)
//    public List<CodeAndDescription> findOfficerGradeDetails(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_OFFICER_GRADE);
//        return l;
//    }
//    
//    public List<CodeAndDescription> findAuditReportDetailsType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AUDIT_REPORT_DETAIL_TYPE);
//        return l;
//    }
//   
//    
    public Serializable find(Object code, DataReference dataReference) {

        return getRefCodeAssemblerService().find(code, dataReference);

    }
//
//    public List<SelectItem> findAllTitles(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TITLE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllSearchIds(Object code) {
        List<SelectItem> searchIdList = new ArrayList<SelectItem>();
        String loadFromDB = 
            findSystemParameter(Constants.SystemParameterCode.LOAD_GENERIC_SEARCH_FROM_DB);
        if (loadFromDB != null && loadFromDB.equalsIgnoreCase(Constants.YES)) {
            searchIdList = findAllSearchID(code);
        } else {
            List<String> ids = SearchConfigHelper.getSearchIds();
            for (String item: ids) {
                if (item != null) {
                    SelectItem selItem = new SelectItem(item, item);
                    searchIdList.add(selItem);
                }
            }
        }
        return searchIdList;
    }

//    public List<String> findAllSearchIds() {
//        try {
//            String searchFilename = "search.config.xml";
//            ConfigurationHelper configurationHelper = 
//                new ConfigurationHelper();
//            InputStream searchFilenameStream = 
//                Thread.currentThread().getContextClassLoader().getResourceAsStream(searchFilename);
//            configurationHelper.createDom(searchFilenameStream);
//
//            int eachEntry = 1;
//            ArrayList<String> searchIdsList = new ArrayList<String>();
//
//            while (eachEntry > 0) {
//                configurationHelper.setPath("/searchList/search[" + 
//                                            String.valueOf(eachEntry) + "]");
//                if (configurationHelper.pathExists()) {
//                    String id = configurationHelper.getElement("id");
//
//                    if (id != null) {
//                        searchIdsList.add(id);
//                        eachEntry++;
//                        continue;
//                    }
//                } else {
//                    eachEntry = -1;
//                }
//            }
//            return searchIdsList;
//        } catch (XMLAccessException exp) {
//            log.error(exp.getLocalizedMessage(), exp);
//            return null;
//        }
//    }
//
//    public List<SelectItem> findAllMaritalStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MARITAL_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllGender(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GENDER);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllNationality(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COUNTRY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllCountry(Object code) {
//        List<CodeAndDescription> l = 
//        getRefCodeAssemblerService().findAll(code, DataReference.COUNTRY_DESC);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOtherNationality(Object code) {
//        return findAllNationality(code);
//    }
//
//    public List<SelectItem> findAllPenaltyMethods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PENALTY_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDataSources(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DATA_SOURCE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCommunityCodes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMMUNITY_CODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDefermentPeriod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DEFERMENT_PERIOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAttributes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ATTRIBUTES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefCountry.class)
//    public List<SelectItem> findAllCountries(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COUNTRY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    @ReferenceEntity(reference = RefCountry.class)
//    public List<SelectItem> findAllCountriesExceptLocal(String localCountry) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCountriesExceptLocal(localCountry);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findBaseCountry() {
//        String code = findSystemParameter(Constants.SystemParameterCode.BASE_COUNTRY);
//        String description = findSystemParameter(Constants.SystemParameterCode.BASE_COUNTRY_DESC);
//        CodeAndDescription item = new CodeAndDescription(code, description);
//        List<CodeAndDescription> l = new ArrayList<CodeAndDescription>();
//        l.add(item);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCounties(Object code, String countryCode, 
//                                            String userOffice) {
//        List<CodeAndDescription> l = null;
//        String localCountry = 
//            getRefCodeAssemblerService().findSystemParameter(Constants.SystemParameterCode.BASE_COUNTRY);
//        if (null != countryCode && !localCountry.equals(countryCode)) {
//            getRefCodeAssemblerService().findAllSubdivision(countryCode);
//        } else {
//            l = 
//  getRefCodeAssemblerService().findAllSubdivision(code, countryCode, 
//                                                  userOffice, "PROVINCE");
//        }
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAddressTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ADDRESS_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllIdentificationTypes(Object code) {
//    
//        List<RefIdentifierType> results = null;
//            results = getRefCodeAssemblerService().findAllIdentifierTypes(code);
//
//        List<SelectItem> selectItems = new ArrayList<SelectItem>();
//        if(null == results){
//            return null;
//        }else{
//            for (RefIdentifierType refObj : results){
//                if (refObj != null){
//                    selectItems.add(new SelectItem(refObj, refObj.getDescription()));
//                }
//            }
//        }
//        return selectItems;
//    }
//
//    public List<SelectItem> findAllIdentificationTypesWithCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.IDENTIFIER_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
    public List<SelectItem> findAllRegimeTypes(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.REV_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }

    public String findRegimeTypesDescription(String code) {
        return getRefCodeAssemblerService().findRefDescription(code, 
                                                               DataReference.REV_TYPE);        
    }
    
//    public List<SelectItem> findAllStaggers(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.STAGGER);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSubStaggers(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.STAGGER_SUB);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllBusinessLines(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllBusinessSectors(code);
//        return FacesUtil.convertToSelectItemsUseCodeDescTogether(l,false," - ");
//    }
//    
//    public List<SelectItem> findAllISICCodes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllBusinessSectors(code);
//        //We need only ISIC codes not all business sectors. All ISIC Code  length is 4 only.
//        //So I am loading only codes with length 4.
//        List<CodeAndDescription> finalList = new ArrayList<CodeAndDescription>();
//        for (CodeAndDescription codeDesc: l) {
//            if (null != codeDesc.getCode() && codeDesc.getCode().toString().length() == 4) {
//                finalList.add(codeDesc);
//            }
//        }
//        //return FacesUtil.convertToCodeAndShortDesc(finalList,false," - ");
//         return FacesUtil.convertToSelectItemsUseCodeDescTogether(finalList,false," - ");
//    }
//
//    
//    public List<SelectItem> findAllBusinessLinesAbbreviated(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllBusinessSectors(code);
//        //We need only divisions not all business sectors. All division's code length is 2 only.
//        //So I am loading only codes with length 2.
//        List<CodeAndDescription> finalList = new ArrayList<CodeAndDescription>();
//        for (CodeAndDescription codeDesc: l) {
//            if (null != codeDesc.getCode() && codeDesc.getCode().toString().length() == 2) {
//                finalList.add(codeDesc);
//            }
//        }
//        //return FacesUtil.convertToCodeAndShortDesc(finalList,false," - ");
//         return FacesUtil.convertToSelectItemsUseCodeDescTogether(finalList,false," - ");
//    }
//
//
//    public RefBusinessSector findBusinessSector(String code) {
//        RefBusinessSector i = 
//            getRefCodeAssemblerService().findBusinessSector(code);
//        return i;
//    }
//    
//    public List<SelectItem> findAllRelationshipTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_REL_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllEntAttachmentTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ENT_ATT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllContactMethodTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COM_PT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPurposes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COM_PT_PURPOSE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllLegalStatus(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.LEGAL_STATUS_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllTaxpayerTypeFromComplianceConfig(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllTaxpayerTypeFromComplianceConfig(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findWarehouseId(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findWarehouseId(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefCurrency.class)
//    public List<SelectItem> findAllCurrencies(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CURRENCY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    @ReferenceEntity(reference = RefOffice.class)
    public List<SelectItem> findAllOffices(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.OFFICE);
        return FacesUtil.convertToSelectItems(l);
    }
    
//    @ReferenceEntity(reference = RefContactMethod.class)
//    public List<SelectItem> findAllContactMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_CONTACT_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    
//    public List<CodeAndDescription> findAllReferenceByObject(Object code,String dataSetType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().loadRefPojoData(dataSetType);
//        return l;
//    }
//
    public List<SelectItem> findAllTransactionTypes(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.TRANSACTION_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }

//    public List<SelectItem> findAllUserGroups(Object code) {
//        List<CasRole> l = getSecurityService().findAllGroupRoles();
//        List<CodeAndDescription> cd = 
//            new ArrayList<CodeAndDescription>(l.size());
//        for (CasRole role: l) {
//            cd.add(new CodeAndDescription(role.getRoleName(), 
//                                          role.getDescription()));
//        }
//        return FacesUtil.convertToSelectItems(cd);
//    }
//
//    public List<SelectItem> findAllTransportModes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_TRAN_MODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDeliveryTerms(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DELIVERY_TERMS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllValutaionMethods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VALUATION_NETHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDeclarationRegime(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUSTOMS_REGIME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllVehicleFuelTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VEH_FUEL_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllVehicleTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VEH_TYPE);
//        return FacesUtil.convertToSelectItemsUseCodeDescTogether(l,false," - ");
//    }
//
//    public List<SelectItem> findAllVehicleUnits(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VEH_UNIT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllContainerType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONTAINER_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllContainerOwner(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONTAINER_OWNER);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllQuantityUnits(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MEASUREMENT_UNITS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCustLocations(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_LOCATION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllReasons(Object code, String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllReasons(code, filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPenaltyTypes(Object code, String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPenaltyTypes(code, filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTransactionTypes(Object code, 
//                                                    String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllTransactionTypes(code, filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInspectionOutcomes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INSP_OUTCOME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOffenceOutcomes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OFFENCE_OUTCOME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInstructionOutcomes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INST_OUTCOME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllPeriodTypes(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllPeriodTypes(code);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllBanks(Object code, String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllBanks(code, filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    //TODO (VP) Need to uncomment when entity for card type become available
//    //    public List<SelectItem> findAllCardTypes(Object code) {
//    //        List<CodeAndDescription> l =
//    //            getRefCodeAssemblerService().findAllCardTypes(code);
//    //        return FacesUtil.convertToSelectItems(l);
//    //    }
//
//    public List<SelectItem> findAllPaymentMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PAYMENT_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPaymentInstrument(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_PAYMENT_INSTRUMENT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findChqPaymentInstrument(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_PAYMENT_INSTRUMENT_CHQ);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//
    public List<SelectItem> findAllRevenueAccountStatus(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.REV_ACC_STATUS);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllGuaranteeTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GUARANTEE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDocumentStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCustomsProcedureCodes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUSTOMS_PROC_CODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefCustTaxType.class)
//    public List<SelectItem> findAllCustomsTaxTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_TAX_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findTransactionTypeByID(Long key) {
//        return getRefCodeAssemblerService().findTransactionTypeDescByID(key);
//    }
//
////TODO - RevAccCleanup
////    public List<SelectItem> findAllRegimeAccountByTin(String tin, 
////                                                      String regType) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllRegimeAccountByTin(tin, 
////                                                                   regType);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//    //TODO - RevAccCleanup
////    public List<SelectItem> findAllRegimeAccountByTinAndRegimeType(String tin, 
////                                                                   String regType) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllRegimeAccountByTinAndRegimeType(tin, 
////                                                                                regType);
////        return FacesUtil.convertToSelectItems(l);
////    }
// //TODO - RevledRevPeriod/RevledTransactionCleanup 
////    public List<SelectItem> findAllPeriodByRegAcc(Long acctId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPeriodByRegAcc(acctId);
////        return FacesUtil.convertToSelectItems(l);
////    }
//    //TODO - RevledRevPeriod/RevledTransactionCleanup
////    public List<SelectItem> findAllNonFiledPeriodByRegAcc(Long acctId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllNonFiledPeriodByRegAcc(acctId);
////        return FacesUtil.convertToSelectItems(l);
////    }
// //TODO - RevledRevPeriod/RevledTransactionCleanup
////    public List<SelectItem> findAllFiledPeriodByRegAcc(Long acctId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllFiledPeriodByRegAcc(acctId);
////        return FacesUtil.convertToSelectItems(l);
////    }
//    //TODO - RevAccCleanup
////    public List<SelectItem> findAllPeriodByRegimeTypeAndAcctNo(String acctNo, 
////                                                               String regimeType, 
////                                                               boolean descAsCode) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPeriodByRegimeTypeAndAcctNo(acctNo, 
////                                                                            regimeType, 
////                                                                            descAsCode);
////       return FacesUtil.convertToSelectItems(l);
////    }
//
//    public List<SelectItem> findAllProcedureCodes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COM_PROCEDURE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPeriodByRegime(String regimeType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPeriodByRegime(regimeType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public String findPeriod(Long periodID) {
//        return getRefCodeAssemblerService().findPeriod(periodID);
//    }
//
    public String findSystemParameter(String code) {
        return getRefCodeAssemblerService().findSystemParameter(code);
    }
//
//    public String findConfParameter(String code) {
//        return getRefCodeAssemblerService().findConfParameter(code);
//    }
//
//    public String findCommodityCategory(String comCode) {
//        return getRefCodeAssemblerService().findCommodityCategory(comCode);
//
//    }
//
//    public String findCommodityDescription(String comCode) {
//        return getRefCodeAssemblerService().findRefDescription(comCode, 
//                                                               DataReference.COM_CODE);
//    }
//
    @ReferenceEntity(reference = RefRevType.class)
    public List<SelectItem> findAllRevType(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.REV_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }
//    
//    @ReferenceEntity(reference = RefTaxRateType.class)
//    public List<SelectItem> findAllTaxRateType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_RATE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllTaxpayerTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAXPAYER_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPeriodStart(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPeriodStart(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefDocStatus.class)
//    public List<SelectItem> findAllRefDocStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefCustomsRegime.class)
//    public List<SelectItem> findAllRefCustomsRegime(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUSTOMS_REGIME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefWfOperation.class)
//    public List<SelectItem> findAllRefWfOperation(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.WF_OPERATION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = WfWorkflowCondition.class)
//    public List<SelectItem> findAllWfWorkflowCondition(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.WF_WORKFLOW_CONDITION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllPeriodByPeriodFrom(Long revAcc, 
//                                                      Long periodId) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPeriodByPeriodFrom(revAcc, 
//                                                                   periodId, 
//                                                                   false);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
////    public List<SelectItem> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, String acctStatus) {
////         //The commented code using REV_ACC which we are not supposed to use.
////        //        List<CodeAndDescription> l = 
////        //            getRefCodeAssemblerService().findAllRevenueTypeByEntityIdAndAcctStatus(entityID, 
////        //                                                                                   acctStatus);
////        //        return FacesUtil.convertToSelectItems(l);
////        List<RegTaxpayerStatusView> regTaxpayerStatusViews = 
////            getRegistrationService().findByEntityAndStatus(entityID, acctStatus);
////        return addSelectItems(regTaxpayerStatusViews);
////    }
////    
////    public List<SelectItem> findAllRevenueTypeByEntityId(Long entityID) {
////        List<RegTaxpayerStatusView> regTaxpayerStatusViews = 
////            getRegistrationService().findRevenueAccountsForDereg(entityID);
////        List<SelectItem> selectItems = new ArrayList<SelectItem>();
////        //TODO check this with requirements
////        for (RegTaxpayerStatusView regTaxpayerStatusView : regTaxpayerStatusViews) {
////            SelectItem selectItem = new SelectItem(regTaxpayerStatusView.getRevenueType(), regTaxpayerStatusView.getRevenueDescription());
////            selectItems.add(selectItem);
////        }
////        return selectItems;
////    }
//    
////    public String findByTaxpayerAccountId(Long accountId) {
////        RegTaxpayerStatusView regTaxpayerStatusView = 
////            getRegistrationService().findByTaxpayerAccountId(accountId);
////
////        return regTaxpayerStatusView.getRevenueType();
////    }
////    
////    
////    public List<SelectItem> findAccountNumberByEntityAndRevenueType(Long entityId, String revenueType){
////    
////        List<RegTaxpayerStatusView> regTaxpayerStatusViews =  getRegistrationService().findAccountNumberByEntityAndRevenueType(entityId, revenueType);
////        List<SelectItem> selectItems = new ArrayList<SelectItem>();
////        //TODO check this with requirements
////        for (RegTaxpayerStatusView regTaxpayerStatusView : regTaxpayerStatusViews) {
////            SelectItem selectItem = new SelectItem(regTaxpayerStatusView.getTaxpayerAccountId(), regTaxpayerStatusView.getAccountNumber());
////            selectItems.add(selectItem);
////        }
////        return selectItems;
////       
////    }
////    
    public Long findAccountIdByEntityAndRevenueType(Long entityId, String revenueType){
        List<RegTaxpayerStatusView> regTaxpayerStatusViews =  getRegistrationService().findAccountNumberByEntityAndRevenueType(entityId, revenueType);
        Long accountId = null; 
        for (RegTaxpayerStatusView regTaxpayerStatusView : regTaxpayerStatusViews) {
            accountId = regTaxpayerStatusView.getTaxpayerAccountId();
        }
        return accountId;
    }
    
    public List<SelectItem> findAllRevenueTypeByTin(String tin) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllRevenueTypeByTin(tin);
        
        return FacesUtil.convertToSelectItems(l);
    }
////    
////    public List<SelectItem> findAllRevenueTypeWithReturnsByTin(String tin) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllRevenueTypeWithReturnsByTin(tin);
////        
////        return FacesUtil.convertToSelectItems(l);
////    }
////
////    private List<SelectItem> addSelectItems(List<RegTaxpayerStatusView> regTaxpayerStatusViews) {
////        List<SelectItem> selectItems = new ArrayList<SelectItem>();
////        //TODO check this with requirements
////        for (RegTaxpayerStatusView regTaxpayerStatusView : regTaxpayerStatusViews) {
////            SelectItem selectItem = new SelectItem(regTaxpayerStatusView.getRevenueType(), regTaxpayerStatusView.getRevenueType());
////            selectItems.add(selectItem);
////        }
////        return selectItems;
////    }
////TODO - RevAccCleanup    
////    public List<SelectItem> findAllPeriodByRegimeAndEntity(String regimeType, 
////                                                           Long entEntityId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPeriodByRegimeAndEntity(regimeType, 
////                                                                        entEntityId, 
////                                                                        false);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//    public List<SelectItem> findAllRefTables() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRefTables();
//       // l = TripsFeature.getInstance().enableTableMgtFeature(l);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findDataReferenceList() {
//        List<String> dataReferenceList = new ArrayList<String>();
//        List<SelectItem> selectItems = new ArrayList<SelectItem>();
//        int dataRefCount = 1;
//        for(DataReference en : DataReference.values()){
//            dataReferenceList.add(en.name());
//            dataRefCount++;
//        }
//        if(dataReferenceList==null || dataReferenceList.size()==0){
//            return null;
//        }
//        Collections.sort(dataReferenceList);
//        Iterator i = dataReferenceList.iterator();
//        while(i.hasNext()){
//            String dataReference = (String)i.next();
//            if (null != dataReference){
//                selectItems.add(new SelectItem(dataReference, dataReference));
//            }
//        }
//       
//        return selectItems;
//    }
//
//    public List<SelectItem> findAllRefTablesForTblManager() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRefTablesToManage();
//      //  l = TripsFeature.getInstance().enableTableMgtFeature(l);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<BaseRefModelObject> findRefData(String entityBean, String code, 
//                                                String description) {
//        return getRefCodeAssemblerService().findRefData(entityBean, code, 
//                                                        description);
//    }
//
//    public BaseModelObject saveOrUpdateRecord(BaseModelObject entity) throws TripsDuplicateFoundException {
//
//        BaseModelObject entitySaved = 
//            getReferenceService().saveOrUpdate(entity);
//        return entitySaved;
//    }
//
//    public BaseModelObject saveOrUpdateRecord(BaseModelObject entity, 
//                                              String action) throws TripsDuplicateFoundException {
//
//        return getReferenceService().saveOrUpdate(entity, action);
//    }
//
    /**
     * Find the list of results for a field. This field is linked to
     * a reference table.
     * <br>
     * e.g this Field RefCountry is linked to a method to findAllCountries.
     * @param fieldName
     * @param fieldValue
     * @return a list of Select Items
     */
    public List<SelectItem> findAllReferenceEntity(String fieldName, 
                                                   Object fieldValue) {
        //Class fieldType =  field.getType();
        Method[] methodsArray = this.getClass().getMethods();
        for (int i = 0; i < methodsArray.length; i++) {
            Method method = methodsArray[i];
            if (method.isAnnotationPresent(ReferenceEntity.class)) {
                ReferenceEntity referenceEntity = 
                    method.getAnnotation(ReferenceEntity.class);
                Class entityClass = referenceEntity.reference();
                if (entityClass.getSimpleName().equals(fieldName)) {
                    try {
                        return (List<SelectItem>)method.invoke(this, 
                                                               new Object[] { fieldValue });
                    } catch (IllegalAccessException e) {
                        log.error(e.getLocalizedMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.error(e.getLocalizedMessage(), e);
                    }
                }
            }
        }
        return new ArrayList<SelectItem>();
    }
//
    public List<SelectItem> findAllPojoAndDescription(String className, 
                                                      Object value) {
        List<BaseRefModelObject> results = null;
//        try {
//            results = 
//                    getRefCodeAssemblerService().findAllRefPojos(value, Class.forName(className), 
//                                                                 Constants.DescriptionColumnName.DESCRIPTION);
//        } catch (ClassNotFoundException e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
        return FacesUtil.convertPojoAndDescriptionToSelectItems(results, 
                                                                Constants.DescriptionColumnName.DESCRIPTION);
    }
//
//    public List<SelectItem> findUnallocatedOfficersForCashOffice(String officeId) {
//        List<SelectItem> results = null;
//        try {
//            List<RefOffStaff> staffs = 
//                    getRefCodeAssemblerService().findUnallocatedOfficersForCashOffice(officeId);
//                
//            if(staffs != null && staffs.size()> 0){
//                results = new ArrayList<SelectItem>();
//                for (RefOffStaff staff : staffs){
//                    results.add(new SelectItem (staff.getId(), staff.getUsername()));                
//                }
//            }
//                    
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return results;
//    }
//
//    
//
//
//    @ReferenceEntity(reference = RefRevMode.class)
//    public List<SelectItem> findAllRevMode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REV_MODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefDocType.class)
//    public List<SelectItem> findAllDocTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFinancialDocumentTypes(Object code, String[] categoryTypes){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFinancialDocumentTypes(code, categoryTypes);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefDocCategory.class)
//    public List<SelectItem> findAllDocCategories(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefTransactionType.class)
//    public List<SelectItem> findAllCustomsTransaction(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TRANSACTION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefTransactionClass.class)
//    public List<SelectItem> findAllTransactionClass(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TRANSACTION_CLASS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * This metod gets list of elements based on the listType passed
//     * @param listType
//     * @return
//     */
//    @ReferenceEntity(reference = RefTransactionClass.class)
//    public List<SelectItem> findAllListItemsByListType(String listType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllListItemsByListType(listType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * This method returns a list of all operands from RefOperandType entity.
//     * @return
//     */
//    @ReferenceEntity(reference = RefOperandType.class)
//    public List<SelectItem> findAllOperandList(String operandCategory) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllOperandList(null, operandCategory);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * This method returns a list of all documents from MsgType entity.
//     * @return
//     */
//    @ReferenceEntity(reference = MsgType.class)
//    public List<SelectItem> findAllDocumentList() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(null, DataReference.MSG_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//        /**
//     * The method list all message sections based on the message type
//     * @param msgType
//     * @return
//     */    
//    public List<SelectItem> findAllSectionList(String msgTypeName) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSectionList(msgTypeName);
//        
//        return FacesUtil.convertToSelectItems(l); 
//    }
//
//
////    public List<SelectItem> findAllSectionList(MsgType msgType) {
////        if (msgType == null) return null;
////        // check if the msgType is Flexible Form if so load all the flexible form fields in the list
////         List<CodeAndDescription> l = null;
////        if(msgType.getIsFlexibleForm() != null && msgType.getIsFlexibleForm().equals(Constants.TRUE)){
////            // get details of the form being used... load all the defined sections
////            l.add(new CodeAndDescription(new Long(0), "Page"));
//////            return findAllFlexibleFieldsForForm();
////        }else{
////            l = getRefCodeAssemblerService().findAllSectionList(msgType.getCode());
////        }
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//
//    /**
//     * This method returns a list of all scores from RefRiskScore entity.
//     * @return
//     */
//    public List<SelectItem> findAllRiskScoreList(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.RISK_SCORE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllSectionListByCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSectionListByCode(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllOperandListByCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OPERAND_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public String findDescByCodeFromRefTable(String entityName, String code) {
//        return getRefCodeAssemblerService().findDescByCodeFromRefTable(entityName, 
//                                                                       code);
//    }
//
//    public List<SelectItem> findAllFieldListByCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFieldListByCode(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    /**
//     * The method list all message fields based on the section
//     * @param section
//     * @return
//     */
//    public List<SelectItem> findAllFieldList(Long section) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFieldList(section);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRiskAllowedFieldsForSectionInForm(String formName, String sectionId) {
//        List<CodeAndDescription> l =
//            getRefCodeAssemblerService().findAllRiskAllowedFieldsForSectionInForm(formName, sectionId);
//        return FacesUtil.convertToSelectItems(l);    
//    }
//    /**
//     * This method gets list of elements for all active risk levels
//     * @param code
//     * @return
//     */
//    public List<SelectItem> findAllRiskLevels(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.RISK_LEVEL);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRiskLevelsArranged() {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAllRiskLevels());
//    }
//    
//    /**
//     * This method gets list of elements for all active analysts
//     * @param code
//     * @return
//     */
//    public List<SelectItem> findAllAnalysts(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ANALYST);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * This method gets list of elements for all active teams
//     * @param code
//     * @return
//     */
//    public List<SelectItem> findAllTeams(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TEAM);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCriteriaType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MSG_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSourceReliability(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SOURCE_RELIABILITY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllEvaluationTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.EVALUATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRiskTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.RISK_TYPE);
//
//
//        return FacesUtil.convertToSelectItems(l);
//
//    }
//
//    public List<SelectItem> findAllUnits(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MEASUREMENT_UNITS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPortsInCountry(String countryCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPortsInCountry(countryCode);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllVesselTypeList() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllVesselTypeList();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAircraftTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AIRCRAFT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCustomProgress(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_PROGRESS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInspectionAction(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INSP_ACTION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOffence(Object code) {
//        //TODO dummy data will be put now, later it will change.
//
//        SelectItem item1 = new SelectItem();
//        item1.setValue("dummy 1");
//        item1.setLabel("dummy 1");
//        SelectItem item2 = new SelectItem();
//        item2.setValue("dummy 2");
//        item2.setLabel("dummy 2");
//        SelectItem item3 = new SelectItem();
//        item3.setValue("dummy 3");
//        item3.setLabel("dummy 3");
//
//        List<SelectItem> items = new ArrayList<SelectItem>();
//        items.add(item1);
//        items.add(item2);
//        items.add(item3);
//        return items;
//    }
//
//
//    public List<SelectItem> findAllMeasurementQualifiers(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MEASUREMENT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    //   public List<SelectItem> findAllContainerStatus(Object code) {
//    //       return  findAllStatus(code);
//    //   }
//
//
//    public List<SelectItem> findAllManifestStatuses(Object code) {
//        return findAllStatus(code);
//    }
//
//    public List<SelectItem> findAllCommodityStatuses(Object code) {
//        return findAllStatus(code);
//    }
//
//    public List<SelectItem> findAllGoodsStatuses(Object code) {
//        return findAllStatus(code);
//    }
//
//
////    public String findEntityName(String entityId) {
////        if (null != entityId) {
////            return getEntityService().findEntityName(Long.valueOf(entityId));
////        } else {
////            return null;
////        }
////    }
////
////    public String findEntityName(Long entityId) {
////        if (null != entityId) {
////            return getEntityService().findEntityName(entityId);
////        } else {
////            return null;
////        }
////    }
////
////    public List<SelectItem> findAllAssessmentTypes(Object code) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAll(code, DataReference.ASSESSMENT_TYPE);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//    public List<SelectItem> findAllCaseStatus(Object code) {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAll(code, 
//                                                                                   DataReference.CASE_STATUS));
//        //
//        //         SelectItem item1 = new SelectItem();
//        //         item1.setValue("dummy 1");
//        //         item1.setLabel("dummy 1");
//        //         SelectItem item2 = new SelectItem();
//        //         item2.setValue("dummy 2");
//        //         item2.setLabel("dummy 2");
//        //         SelectItem item3 = new SelectItem();
//        //         item3.setValue("dummy 3");
//        //         item3.setLabel("dummy 3");
//        //
//        //         List<SelectItem> items = new ArrayList<SelectItem>();
//        //         items.add(item1);
//        //         items.add(item2);
//        //         items.add(item3);
//        //         return items;
//    }
//
//    public List<SelectItem> findAllTeamResponsible(Object code) {
//        //TODO
//        SelectItem item1 = new SelectItem();
//        item1.setValue("team1");
//        item1.setLabel("Team1");
//        SelectItem item2 = new SelectItem();
//        item2.setValue("team2");
//        item2.setLabel("Team2");
//        SelectItem item3 = new SelectItem();
//        item3.setValue("team3");
//        item3.setLabel("Team3");
//
//        List<SelectItem> items = new ArrayList<SelectItem>();
//        items.add(item1);
//        items.add(item2);
//        items.add(item3);
//        return items;
//    }
//
//    public List<SelectItem> findAllOfficerResponsible(String previousOfficerName, 
//                                                      String officerType) {
//        List<CasUser> l = 
//            getSecurityService().findUsersOfFunctionalRole(officerType);
//        List<CodeAndDescription> cd = 
//            new ArrayList<CodeAndDescription>(l.size());
//
//        if (previousOfficerName != null) {
//            boolean previousOfficerExists = false;
//            for (CasUser user: l) {
//                cd.add(new CodeAndDescription(user.getUsername(), 
//                                              user.getUsername()));
//                if (user.getUsername().equals(previousOfficerName)) {
//                    previousOfficerExists = true;
//                }
//            }
//
//            if (!previousOfficerExists) {
//                //Add the previous user to the list otherwise it will not be in the list
//                cd.add(new CodeAndDescription(previousOfficerName, 
//                                              previousOfficerName));
//            }
//        } else {
//            for (CasUser user: l) {
//                cd.add(new CodeAndDescription(user.getUsername(), 
//                                              user.getUsername()));
//            }
//        }
//
//        return FacesUtil.convertToSelectItems(cd);
//    }
//
//    public List<CodeAndDescription> findAllDocumentTypes(Object code) {
//        return getRefCodeAssemblerService().findAll(code, 
//                                                    DataReference.DOC_TYPE);
//    }
//
    public List<SelectItem> findAllDocumentTypesAsSelectItems(Object code) {
        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAll(code, 
                                                    DataReference.DOC_TYPE));
    }
//
//    public List<SelectItem> findAllObjectionsAppealsTypes(Object code) {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAll(code, 
//                                                                                   DataReference.OBJECTION_TYPE));
//    }
//
//
//    public List<SelectItem> findAllObjectionsCategories(Object code) {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAll(code, 
//                                                                                   DataReference.OBJECTION_CATEGORY_TYPE));
//        //
//        //         SelectItem item1 = new SelectItem();
//        //         item1.setValue("dummy 1");
//        //         item1.setLabel("dummy 1");
//        //         SelectItem item2 = new SelectItem();
//        //         item2.setValue("dummy 2");
//        //         item2.setLabel("dummy 2");
//        //         SelectItem item3 = new SelectItem();
//        //         item3.setValue("dummy 3");
//        //         item3.setLabel("dummy 3");
//        //
//        //         List<SelectItem> items = new ArrayList<SelectItem>();
//        //         items.add(item1);
//        //         items.add(item2);
//        //         items.add(item3);
//        //         return items;
//    }
//
//    public List<SelectItem> findAllObjectionStatus(Object code) {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAll(code, 
//                                                                                   DataReference.OBJECTION_STATUS_TYPE));
//        //
//        //         SelectItem item1 = new SelectItem();
//        //         item1.setValue("dummy 1");
//        //         item1.setLabel("dummy 1");
//        //         SelectItem item2 = new SelectItem();
//        //         item2.setValue("dummy 2");
//        //         item2.setLabel("dummy 2");
//        //         SelectItem item3 = new SelectItem();
//        //         item3.setValue("dummy 3");
//        //         item3.setLabel("dummy 3");
//        //
//        //         List<SelectItem> items = new ArrayList<SelectItem>();
//        //         items.add(item1);
//        //         items.add(item2);
//        //         items.add(item3);
//        //         return items;
//    }
//
//    public List<SelectItem> findAllCaseTypes(Object caseType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(caseType, 
//                                                 DataReference.CASE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findEscalateReason(Object caseType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(caseType, 
//                                                 DataReference.REF_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public byte[] getBytesArray(InputStream inStream) throws IOException {
        BufferedOutputStream bufOut = null;
        ByteArrayOutputStream bAOut = null;
        int availableLength = inStream.available();
        int c;
        BufferedInputStream bufIn = 
            new BufferedInputStream(inStream, availableLength);
        bAOut = new ByteArrayOutputStream();
        bufOut = new BufferedOutputStream(bAOut, availableLength);
        while ((c = bufIn.read()) != -1) {
            bufOut.write((char)c);
        }
        bufOut.flush();
        bufOut.close();
        return bAOut.toByteArray();
    }
//
    public Long saveToFileStore(UploadedFile upFile) {
        FileStore fst = new FileStore();
        fst.setFileName(upFile.getFileName());
        fst.setFileType(upFile.getContentType());
        try {
            byte[] totalBytes = getBytesArray(upFile.getInputstream());
            fst.setFileContents(totalBytes);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
//        return getRefCodeAssemblerService().saveToFileStore(fst);
        return null;
    }
//
//    public Long saveFileStore(FileStore productImage) {
//        return getRefCodeAssemblerService().saveToFileStore(productImage);
//    }
//
//    public FileStore createFileStore(UploadedFile upFile) {
//        FileStore fst = new FileStore();
//        fst.setFileName(upFile.getFilename());
//        fst.setFileType(getAppropriateContentType(upFile.getContentType()));
//
//        try {
//            fst.setFileContents(getBytesArray(upFile.getInputStream()));
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return fst;
//    }
//
//    /**
//     * Set MIME type for .jpeg and .png images as IE sets different MIME type for 
//     * these extensions and that introduces problems on IE while uploading 
//     * and displaying images with these extensions.
//     * @param contentType
//     * @return MIME Content Type
//     */
//    public String getAppropriateContentType(String contentType) {
//        if (contentType.equalsIgnoreCase("image/pjpeg")) {
//            contentType = "image/jpeg";
//        } else if (contentType.equalsIgnoreCase("image/x-png")) {
//            contentType = "image/png";
//        } else {
//            //do nothing
//        }
//        return contentType;
//    }
//
    public FileStore getFileFromStore(Long id) {
        return getRefCodeAssemblerService().getFileFromStore(id);
    }
//
//    public List<SelectItem> findAllIdentityCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.IDENTITY_CODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllScientificName(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SCIENTIFIC_NAME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllProfessions(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PROFESSION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllColors(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COLOURS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllChemicalNames(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CHEMICAL_NAME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllEmployments(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.EMPLOYMENT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllIndividualBuilds(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INDIVIDUAL_BUILD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllIndividualRoles(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INDIVIDUAL_ROLE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCommodityCodes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COM_CODE);
//        return FacesUtil.convertToSelectItemsUseCodeOnly(l);
//    }
//
//    public List<SelectItem> findAllPremises(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PREMISES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllTarrifHead4(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TARRIF_HEAD_4);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTarrifHead8(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TARRIF_HEAD_8);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public ProductInputType loadProductInputType(Long productId) {
//        ProductInputType productInputType = null;
//        productInputType = 
//                getRefCodeAssemblerService().getProductInputType(productId);
//        return productInputType;
//    }
//
//
//    public Long saveProduct(ProductInputType productInputType) {
//        return getRefCodeAssemblerService().saveProduct(productInputType);
//    }
//
//    public List<SelectItem> findAllCaseOfficers(Object code) {
//        List<CasUser> l = getSecurityService().findAllUsers(UserType.OFFICER);
//        List<CodeAndDescription> cd = 
//            new ArrayList<CodeAndDescription>(l.size());
//        for (CasUser user: l) {
//            cd.add(new CodeAndDescription(user.getUsername(), 
//                                          user.getUsername()));
//        }
//        return FacesUtil.convertToSelectItems(cd);
//    }
//
//    public List<SelectItem> findAllOfficeStaff(String officeCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllOfficeStaff(officeCode);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllUserOfFunctionalRoleUnderOffice(String officeCode, 
//                                                                   String role) {
//
//        List<CodeAndDescription> finalList = 
//            new ArrayList<CodeAndDescription>();
//        List<CasUser> officers = 
//            getSecurityService().findUsersOfFunctionalRole(role);
//        List<CodeAndDescription> offstaffs = 
//            getRefCodeAssemblerService().findAllOfficeStaff(officeCode);
//
//        for (CodeAndDescription staff: offstaffs) {
//
//            for (CasUser officer: officers) {
//                if (officer.getUsername().equalsIgnoreCase(staff.getCode().toString())) {
//                    finalList.add(staff);
//                }
//            }
//        }
//        return FacesUtil.convertToSelectItems(finalList);
//    }
//
//    public List<SelectItem> findAllUsers() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllUsers();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findUsersOfFunctionalRole(String functionalRole) {
//        List<CasUser> l = 
//            getSecurityService().findUsersOfFunctionalRole(functionalRole);
//        List<CodeAndDescription> cd = 
//            new ArrayList<CodeAndDescription>(l.size());
//        for (CasUser user: l) {
//            cd.add(new CodeAndDescription(user.getUsername(), 
//                                          user.getUsername()));
//        }
//        return FacesUtil.convertToSelectItems(cd);
//    }
//
//    public List<SelectItem> findAllTechEquipments(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TECH_EQUIPMENT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspOutcomes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUSP_OUTCOME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllLocations(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.LOCATIONS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDetectionMethods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DETECTION_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllGoodsCondition(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GOODS_CONDITION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOffenceType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OFFENCE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOffenceStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OFFENCE_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllOfficerUnits(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OFFICER_UNITS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspicionTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUSPICION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInformationSources(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INFORMATION_SOURCE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspicionReasons(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUSPICION_REASONS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCardType(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CARD_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAirlineStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AIRLINE_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllShippingLines(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SHIPPING_LINE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllOrganisationRole(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ORGANISATION_ROLE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRole(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ROLE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspectReason(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUSPECT_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspectStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUSPECT_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllContMeasurements(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONT_MEASUREMENTS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAirline(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AIRLINE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllContainerStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONTAINER_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllReportOutputType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REPORT_OUTPUT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPorts(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PORT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAircraftStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AIRCRAFT_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllEngineCapacityUnits(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ENGINE_CAPACITY_UNITS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllCompanyType(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.COMPANY_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }
//
    @ReferenceEntity(reference = RefEntityType.class)
    public List<SelectItem> findAllEntityType(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.ENTITY_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }
    
//    public List<SelectItem> findEntityTypes(List<String> codes) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findEntityTypes(codes);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllValuationStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VALUATION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllConditionOfShipment(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INCO_TERMS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllManifestType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public RefProducts findRefProducts(Object code) {
//        RefProducts product = null;
//        product = 
//                (RefProducts)getReferenceService().queryFindById(RefProducts.class, 
//                                                                 code);
//
//        return product;
//    }
//
//    public List<SelectItem> findAllPackageTypes(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PACKAGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllManifestStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllManifestConsStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_CONS_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllManifestConsType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_CONS_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCustDocType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_DOC_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * Find the country description of a country with this code
//     * @param code
//     * @return
//     */
//    public String findCountryDescription(String code) {
//        if (code == null)
//            return null;
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.COUNTRY);
//    }
//
//    /**
//     * Finds the transport description for this code
//     * @param code
//     * @return
//     */
//    public String findTransportDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.TRANSPORT);
//    }
//
//    /**
//     * Finds the location description in a country for this code
//     * @param code
//     * @return
//     */
//    public String findLocationInCountry(String code) {
//        if (code == null)
//            return null;
//        return getRefCodeAssemblerService().findLocationInCountry(Long.valueOf(code));
//    }
//
//    public List<SelectItem> findAllSeizureReasons(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SEIZURE_REASONS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllVehEngineCapacity(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.VEH_ENGINE_CAPACITY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * Converts the list in the form of Code and Desciption to Select Item, which 
//     * will be used in the GUI to display it as a dropdown
//     * @param code
//     * @return
//     */
//    public List<SelectItem> findAllRefReportParameterTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REPORT_PARAMETER_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * Converts the result to drop down display in GUI.
//     * @param entityID
//     * @param acctStatus
//     * @return
//     */
//     //TODO - RevAccCleanup     
////    public List<SelectItem> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, 
////                                                                      boolean isWithTaxpayer) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllRevenueTypeByEntityIdAndAcctStatus(entityID, 
////                                                                                   isWithTaxpayer);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//    public List<SelectItem> findAllManifestReconcRes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_RECONC_RES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findCountryDescription(String countryCode, 
//                                         List<SelectItem> availableCountryList) {
//        for (SelectItem item: availableCountryList) {
//            if (countryCode.equals(item.getValue())) {
//                return item.getLabel();
//            }
//        }
//        throw new IllegalAccessError("No description code, check code");
//    }
//
//    public List<SelectItem> findAllCustomAuditTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUSTOMS_AUDIT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTransportType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_TRAN_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAuthorisedLocOfGoods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_LOCATION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCustomSubPlace(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OFFICE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSensitiveGoodsType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SENSITIVE_GOODS_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAdditionalDocType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_AUTH_DOC_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllManifestSource(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MANIFEST_SOURCE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRouteIndicator(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ROUTE_INDICATOR);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findPackageTypeDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.PACKAGE_TYPE);
//    }
//
//    public List<SelectItem> findAllMeasurementUnitsByMeasurement(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllMeasurementUnitsByMeasurement(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public RefCustTranMode findRefCustTranModeFindByCode(String code) {
//        if (code == null)
//            return null;
//        return getReferenceService().queryRefCustTranModeFindByCode(code);
//    }
//
//
//    /**
//     * Finds the container measurements description for this code
//     * @param code
//     * @return
//     */
//    public String findContMeasurementsDescription(String code) {
//        if (code == null)
//            return null;
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CONT_MEASUREMENTS);
//    }
//
//    /**
//     * Finds the container type description for this code
//     * @param code
//     * @return
//     */
//    public String findContainerTypeDescription(String code) {
//        if (code == null)
//            return null;
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CONTAINER_TYPE);
//    }
//
//    public List<SelectItem> findAllCustomsControlResult(Object code) {
//        SelectItem accept = new SelectItem();
//        accept.setValue("ACCEPTED");
//        accept.setLabel("ACCEPTED");
//        SelectItem reject = new SelectItem();
//        reject.setValue("REJECTED");
//        reject.setLabel("REJECTED");
//        List<SelectItem> controlResult = new ArrayList<SelectItem>();
//        controlResult.add(accept);
//        controlResult.add(reject);
//        return controlResult;
//    }
//
//    public List<SelectItem> findAllTrainType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TRAIN_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    @ReferenceEntity(reference = RefCustomsProcCode.class)
//    public List<SelectItem> findAllRefCustomsProcCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUSTOMS_PROC_CODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllApplicationType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.APPLICATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllApplicationRole(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.APPLICATION_ROLE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllApplicationRoleByRoleType(String roleType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllApplicationRoleByRoleType(roleType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllApplicationRoleType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.APPLICATION_ROLE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllComputationMethods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPUTATION_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllComputationTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPUTATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInterestMethods(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INTEREST_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllModules(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MODULES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRateBasis(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.RATE_BASIS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllRefPeriodDueSpan(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_PERIOD_DUE_SPAN);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    /**
//     * Generic method to find an this entity using value of <b>code</b> field
//     * @param code value of the <b>code</b> field of the entity
//     * @return a entity POJO
//     */
    public Object findRefEntityByCode(Class clazz, Object code) {
        Object result = null;
        result = getReferenceService().queryFindByCode(clazz, code);

        return result;
    }

//    public List<SelectItem> findAllApplicationIndicator(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.APPLICATION_INDICATOR);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllApplicationTypeByIndicator(String indicator) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllApplicationTypeByIndicator(indicator);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findAppIndicatorCodeByAppType(String appTypeCode) {
//        return getReferenceService().findAppIndicatorCodeByAppType(appTypeCode);
//    }
//
//    public List<SelectItem> findAllDebtMgmtProfiles(String debtProfileType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(debtProfileType, 
//                                                 DataReference.DOC_REPORT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDebtCategory(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DEBT_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDebtActionTypes(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DEBT_ACTION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCourtProceeding(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COURT_PROCED_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDebtPriority(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DEBT_PRIORITY_TYPES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
////    public ReportBean findDocumentReportInfo(String debtProfileType) {
////        RefDocType refDocReport = 
////            getReferenceService().findDocumentReport(debtProfileType);
////        ReportBean rb = new ReportBean();
////        rb.setDisplayName(refDocReport.getDescription());
////        rb.setPath(refDocReport.getReportPathInfo().getPath());
////        return rb;
////    }
//
//    public List<SelectItem> findAllDocTypeByCategory(String docType, 
//                                                     String category) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllDocTypeByCategory(docType, 
//                                                                  category);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAuthorisationType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.AUTHORISATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * Checks if there is a commercial account with this code in the database.
//     * @param code
//     * @return
//     */
//    public boolean checkCommercialAccountByCode(String code) {
//        return getReferenceService().checkCommercialAccountByCode(code);
//    }
//
//    public List<SelectItem> findAllCommercialAccount(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMMERCIAL_ACCOUNTS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findApplicationRoleTypeDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.APPLICATION_ROLE_TYPE);
//    }
//
//    public List<SelectItem> findAllGuaranteeRefAmountPerc(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GUARANTEE_AMOUNT_PERC);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDocDeliveryTypes(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_DELIVERY_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDocDestinationTypes(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_DESTINATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllGuaranteeUsageAccountType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GUARANTEE_USAGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDocDestinationFormats(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOC_DESTINATION_FORMAT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllExemptionType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.EXEMPTION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findMeasurementDescription(String measCode) {
//        return getRefCodeAssemblerService().findRefDescription(measCode, 
//                                                               DataReference.MEASUREMENT);
//    }
//
//    public String findMeasurementUnitsDescription(String measCode) {
//        return getRefCodeAssemblerService().findRefDescription(measCode, 
//                                                               DataReference.MEASUREMENT_UNITS);
//    }
//
//    public RefGuaranteeType findRefGuaranteeType(Object code) {
//        RefGuaranteeType guaranteeType = null;
//        guaranteeType = 
//                (RefGuaranteeType)getReferenceService().queryFindByCode(RefGuaranteeType.class, 
//                                                                        code);
//
//        return guaranteeType;
//    }
//
//    public Collection<SelectItem> findAllDayOfWeeks() {
//
//        Collection l = getReferenceService().queryRefDayOfWeekFindAll();
//        return FacesUtil.convertToSelectItemsObjectsAsValue(l, "code");
//    }
//
    public List<SelectItem> findAllMonthOfYear() {

         List<CodeAndDescription> l = getRefCodeAssemblerService().findAllMonthsOfYear();
        return FacesUtil.convertToSelectItems(l);
    }
//    
    public List<SelectItem> findAllTaxCycleDaysOfMonth(Object code) {

         List<CodeAndDescription> l = getRefCodeAssemblerService().findAll(code, DataReference.REF_TAX_CYCLE_DAYS_OF_MONTH);
        return FacesUtil.convertToSelectItems(l);
    }
//    
//
//    public List<SelectItem> findAllInstallmentCancelReasons(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INST_CANCEL_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDefermentReasons(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DEFERMENT_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPaymentSpread(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PAYMENT_SPREAD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllRefComplianceType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPLIANCE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findNonPayORNonFileRefComplianceType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.NPORNF_COMPLIANCE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRefComplianceActionType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPLIANCE_ACTION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRefFrequency(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_FREQUENCY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllRefFrequency(Object code, String frequencyCategory) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRefFrequency(code, frequencyCategory);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllProductNameById(Object productId) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllProductNameById(productId);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSensitiveProductNameByComCode(Object comCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSensitiveProductNameByComCode(comCode);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSuspendedProductNameByComCode(Object comCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSuspendedProductNameByComCode(comCode);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllProductNameByComCode(Object comCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllProductNameByComCode(comCode);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllOfficesForUser(Object code, String userID) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllOfficesForUser(code, userID);
        return FacesUtil.convertToSelectItems(l);
    }

//    public List<SelectItem> findOfficesByOfficeType(Object code, 
//                                                    String officeType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findOfficesByOfficeType(code, 
//                                                                 officeType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findProductCommonName(Long productId, 
//                                        List<SelectItem> availableProductList) {
//        for (SelectItem item: availableProductList) {
//            if (productId.equals(item.getValue())) {
//                return item.getLabel();
//            }
//        }
//        throw new IllegalAccessError("No description code, check code");
//    }
//
//
//    public List<SelectItem> findAllTaxBandAllocationType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_BAND_ALLOCATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxCalcSegment(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_CALC_SEGMENT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxBandSelectionMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_BAND_SELECTION_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxCalculationType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_CALCULATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_TAXTYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxRateTablePeriod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllTaxRateTablePeriod(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTaxBand(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllTaxBand(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllWarehouseAuthType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.WAREHOUSE_AUTH_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllCustControlPoint(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_CONTROL_POINT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllInventoryMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INVENTORY_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTempRemovAuthType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TEMP_REMOV_AUTH_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllNotificationMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.NOTIFICATION_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllNoticeType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_NOTICE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllGoodsTransferMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GOODS_TRANSFER_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllHandlingOperations(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.HANDLING_OPERATIONS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public RefOffice findOfficeDetails(String officeCode) {
//        RefOffice o = 
//            getRefCodeAssemblerService().findOfficeDetails(officeCode);
//        return o;
//    }
//    public List<RefOffStaff> findInactiveOfficeStaffByOffice(String officeCode) {
//        List<RefOffStaff> o = 
//            getRefCodeAssemblerService().findInactiveOfficeStaffByOffice(officeCode);
//        return o;
//    }
//    
//    public List<RefOffStaff> findOfficeStaffByOffice(String officeCode){
//        List<RefOffStaff> o = 
//            getRefCodeAssemblerService().findOfficeStaffByOffice(officeCode);
//        return o;
//    }
//    
//    public List<SelectItem> findAllCustProcedureType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_PROCEDURE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findCurrencyDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CURRENCY);
//    }
//
//    public String findCustomsControlPointDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CUST_CONTROL_POINT);
//    }
//
//    public String findCustProcedureTypeDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CUST_PROCEDURE_TYPE);
//    }
//
//    public String findGoodsIdentMethodDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.GOODS_IDENT_METHOD);
//    }
//
//    public List<SelectItem> findAllGoodsIdentMethod(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GOODS_IDENT_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findGoodsTransferMethodDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.GOODS_TRANSFER_METHOD);
//    }
//
//    public String findCustDocTypeDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.CUST_DOC_TYPE);
//
//    }
//    
//    public String findDocTypeDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.DOC_TYPE);
//    }
//
//    public List<SelectItem> findAllGoodsTransferMethod(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GOODS_TRANSFER_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findNotificationMethodDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.NOTIFICATION_METHOD);
//    }
//
//    public String findHandlingOperationDescription(String code) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.HANDLING_OPERATIONS);
//    }
//
//    public List<SelectItem> findAllTaxAllocationType(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_ALLOCATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllGuaranteeTypesUseCodeOnly(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GUARANTEE_TYPE);
//        return FacesUtil.convertToSelectItemsUseCodeOnly(l);
//    }
//
//    public List<SelectItem> findAllCountriesUseCodeDescTogether(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COUNTRY);
//        return FacesUtil.convertToSelectItemsUseCodeDescTogether(l, false);
//    }
//
//    public List<SelectItem> findAllNationalityUseCodeDescTogether(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COUNTRY);
//        return FacesUtil.convertToSelectItemsUseCodeDescTogether(l, false);
//    }
//
//    public List<SelectItem> findAllTransportTypeUseCodeDescTogether(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CUST_TRAN_TYPE);
//        return FacesUtil.convertToSelectItemsUseCodeDescTogether(l, false);
//    }
//
//    public List<SelectItem> findAllCountriesForLoading(Object code) {
//        return findAllCountries(code);
//    }
//
//    public List<SelectItem> findAllCountriesForDischarge(Object code) {
//        return findAllCountries(code);
//    }
//
    public List<SelectItem> findAll(String code, String dataListName) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.valueOf(dataListName));
        return FacesUtil.convertToSelectItems(l);
    }

    public List<SelectItem> findAll(String code, DataReference dataList) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, dataList);
        return FacesUtil.convertToSelectItems(l);
    }
    
    public List<CodeAndDescription> findAllCodeAndDescription(String code, DataReference dataList) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, dataList);
        return l;
    }

    public List<SelectItem> findAll(String code, Class refClazz) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllCodeAndDescription(code, 
                                                                   refClazz, 
                                                                   Constants.DescriptionColumnName.DESCRIPTION);
        return FacesUtil.convertToSelectItems(l);
    }

    public List<CodeAndDescription> findAllCodeAndDescription(String code, 
                                                              Class refClazz) {
        return getRefCodeAssemblerService().findAllCodeAndDescription(code, 
                                                                      refClazz, 
                                                                      Constants.DescriptionColumnName.DESCRIPTION);
    }
//
//    public List<SelectItem> findAllAppAttachmentTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.APP_ATT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAppAttachmentTypesByAppType(String appType, 
//                                                               Object code) {
//        if (appType == null) {
//            return findAllAppAttachmentTypes(code);
//        } else {
//            List<CodeAndDescription> l = 
//                getRefCodeAssemblerService().findAllAppAttachmentTypesByAppType(appType, 
//                                                                                code);
//            return FacesUtil.convertToSelectItems(l);
//        }
//
//    }
//
//    public List findAllBatchSizes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BATCH_JOB_PARAM);
//        return FacesUtil.convertToSelectItems(l);
//    }
//   
//    public List findAllDocTemplates(Object code) {
//        List<CodeAndDescription> l = new ArrayList<CodeAndDescription>();
//        if (null == code) {
//            return l;
//        } else {
//            ReportManager reportManager = null;
//            try {
//                reportManager = 
//                        new ReportManager("Administrator", "Administrator");
//            } catch (ReportException e) {
//                log.error(e.getLocalizedMessage(), e);
//            }
//            ReportDefInfo reportDefInfo = null;
////            try {
////                ReportBean reportBean = 
////                    this.findDocumentReportInfo(String.valueOf(code));
////                reportDefInfo = 
////                        reportManager.getReportDefinition(reportBean.getPath());
////            } catch (ReportException e) {
////                log.error(e.getLocalizedMessage(), e);
////            }
//            for (String template: reportDefInfo.getTemplateIds()) {
//                l.add(new CodeAndDescription(template, template));
//            }
//        }
//
//        return l;
//    }
//
//    public List<SelectItem> findAllRevenueTypeByLegalStatus(Object code, 
//                                                            String legalStatus) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRevenueTypeByLegalStatus(code, 
//                                                                         legalStatus);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllRevenueTypeByTaxpayerType(Object code, 
//                                                             String taxpayerType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllLegalStatusByTaxpayerType(code, 
//                                                                          taxpayerType, null);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRevenueType(String taxpayerType, Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRevenueTypeByTaxPayerType(taxpayerType, code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String findRefDescription(String code, 
//                                     DataReference dataReference) {
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               dataReference);
//    }
//
//    public String findRefGuaranteeAmountPercCode(String description) {
//        return getRefCodeAssemblerService().findRefGuaranteeAmountPercCode(description);
//    }
//
    public String getSystemParameter(String parameterCode) {
        return getReferenceService().getSystemParameter(parameterCode);
    }
//    
//    public boolean updateSystemParameter(String code, String newValue) {
//        return getReferenceService().updateSystemParameter(code, newValue);
//    }
//    
//
//    public List<SelectItem> findAllAssociationType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ASSOCIATION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllAssociationStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ASSOCIATION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public List<SelectItem> findAllAssociationLevel(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.ASSOCIATION_LEVEL);
//
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllAccessLevel(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.ACCESS_LEVEL);
        return FacesUtil.convertToSelectItems(l);
    }

//    public List<SelectItem> findAllContactMethodStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONTACT_METHOD_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllLocationStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.LOCATION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDisplayType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DISPLAY_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSchemaType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SCHEMA_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SelectItem> findAllBpels(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BPELS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    //    public List<SelectItem> findAllSearchIds(Object code){
//    //        List<CodeAndDescription> l = 
//    //            getRefCodeAssemblerService().findAll(code, DataReference.SEARCH_IDS);
//    //        return FacesUtil.convertToSelectItems(l);
//    //    }    
//
//    public List<SelectItem> findAllFlexibleFormModes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FLEXIBLE_FORM_MODES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRelationshipStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.RELATIONSHIP_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllBankAccountStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BANK_ACCOUNT_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllBankNames(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BANK_NAME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllBankBranches(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllBankBranches(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllCardStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CARD_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDocumentsProvided(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DOCUMENTS_PROVIDED);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFormType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFlexibleFormTypes(code);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
//////
//    public List<SelectItem> findAllFlexibleMappedType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REV_TYPE);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
////    public List<SelectItem> findAllFlexibleForms(Object code) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllFlexibleForms(code);
////        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
////        return FacesUtil.convertToSelectItems(l);
////    }
////
//    public List<SelectItem> findAllFlexibleFieldsForForm(Long formId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllFlexibleFieldsForForm(formId);
//        List<CodeAndDescription> l = null;
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }  
//
//    public List<SelectItem> findAllIdentificationStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.IDENTIFICATION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFlexAttributeType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FLEX_ATTRIBUTE_TYPE);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
//////
//    public List<SelectItem> findAllFlexibleFieldType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFlexibleFieldTypes(code);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllChoiceOpt(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CHOICES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    /**
     * To be reviewed
     * @param userID
     * @return
     */
    public String findUserOffice(String userID) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllOfficesForUser(null, userID);

        if (null != l && !l.isEmpty()) {
            return (String)l.get(0).getCode();
        }
        return null;
    }

    public List<SelectItem> findAllEntityOperatingAs(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.ENT_SITE_TYPE);

        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllSubTaxTypeByTaxType(Object code, 
//                                                       String taxType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSubTaxTypeByTaxType(code, 
//                                                                    taxType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllLegalStatusByTaxpayerType(Object code, 
                                                             String taxpayerType) {
        
        return findAllLegalStatusByTaxpayerType(code, taxpayerType, null);
    }
    
    public List<SelectItem> findAllLegalStatusByTaxpayerType(Object code, 
                                                             String taxpayerType, String mode) {
        List<CodeAndDescription> l = null;
            l = getRefCodeAssemblerService().findAllLegalStatusByTaxpayerType(code, taxpayerType, mode);
        return FacesUtil.convertToSelectItems(l);
    }
    
//    public List<SelectItem> findFilteredLegalStatusByTaxpayerType(Object code, 
//                                                             String taxpayerType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findFilteredLegalStatusByTaxpayerType(code, 
//                                                                          taxpayerType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllFacilityType(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.FACILITY_TYPE);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllFlexibleReturnType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FLEXIBLE_RETURN_TYPE);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
//////
//    public List<SelectItem> findAllFlexibleFormNameList(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFlexibleFormNameList(code);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SelectItem> findAllSuffix(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.SUFFIX);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRegimeProcesses(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REGIME_PROCESSES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRegimeDecision(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REGIME_DECISION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSubivision(String county) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllSubdivision(county);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findAllPurposeOfTin(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.PURPOSE_OF_TIN);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllTablesForFlexibleFields(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TABLE_NAMES);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
//////
//    public List<SelectItem> findAllColumnsForTable(String tableName) {
//        List<CodeAndDescription> l = 
//            getReferenceService().findAllColumnsForTable(tableName);
//        GuiGenerationUtil.sortListOfCodeAndDescription(l, true);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SelectItem> findAllDbColumnTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DB_COLUMN_TYPES);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SysDbTableDefaultCols> findAllDefaultColumnsForTables() {
//        return getRefCodeAssemblerService().findAllDefaultColumnsForTables();
//    }
//
//    public List<SelectItem> findAllIndustrialGroup() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllIndustryGroup();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllIndustrialClassification(String group) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllIndustryByGroup(group);
//        
//            return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllIndustrialClassification(Object code, 
//                                                            boolean descAsCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INDUSTRIAL_CLASSIFICATION);
//        if (descAsCode)
//            return FacesUtil.convertToSelectItemsUseCodeOnly(l);
//        else
//            return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllOccupationalClassification(Object code, 
//                                                              boolean descAsCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.OCCUPATIONAL_CLASSIFICATION);
//        if (descAsCode)
//            return FacesUtil.convertToSelectItemsUseCodeOnly(l);
//        else
//            return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String formatTaxIdentificationNumber(String taxIdentificationNumber) {
//        patternDigitCount = 
//                null != patternDigitCount ? patternDigitCount : getReferenceService().getSystemParameter(Constants.SystemParameterCode.TIN_PATTERN_DIGIT_COUNT);
//        patternSeparator = 
//                null != patternSeparator ? patternSeparator : getReferenceService().getSystemParameter(Constants.SystemParameterCode.TIN_PATTERN_SEPARATOR);
//        numOfChars = 
//                null != numOfChars ? numOfChars : Integer.parseInt(getReferenceService().getSystemParameter(Constants.SystemParameterCode.TIN_NUMBER_OF_CHARACTERS));
//        tinBranchSeparator = 
//                null != tinBranchSeparator ? tinBranchSeparator : getReferenceService().getSystemParameter(Constants.SystemParameterCode.TIN_BRANCH_SEPARATOR);
//
//        String tin = 
//            getReferenceService().formatTaxIdentificationNumber(taxIdentificationNumber, 
//                                                                patternDigitCount, 
//                                                                patternSeparator, 
//                                                                numOfChars, 
//                                                                tinBranchSeparator);
//        return tin;
//    }
//
//    public List<SelectItem> findAllCollectionAgent(Object code, 
//                                                   boolean descAsCode) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COLLECTION_AGENT);
//        if (descAsCode)
//            return FacesUtil.convertToSelectItemsUseCodeOnly(l);
//        else
//            return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCollectionAgentType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COLLECTION_AGENT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    //TODO - RevAccCleanup
////    public List<SelectItem> findRefRevTypesByEntity(Object entityID) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findRefRevTypesByEntity(entityID);
////        return FacesUtil.convertToSelectItems(l);
////    }
//    
//    public String findRefRevTypePeriodByCode(String code) {
//        String str = 
//            getRefCodeAssemblerService().findRefRevTypePeriodByCode(code);
//        return str;
//    }
//    //TODO - RevAccCleanup
////    public List<SelectItem> findRefRevTypesByEntityAndCode(Object entityID, 
////                                                           String code) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findRefRevTypesByEntityAndCode(entityID, 
////                                                                        code);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
// //TODO - RevAccCleanup
////    public String findEntityNameByTIN(String acctNum) {
////        List<Long> entityID = 
////            getRefCodeAssemblerService().findEntityByTIN(acctNum);
////
////        String entityName = "";
////        if (entityID.size() > 0) {
////            entityName = findEntityName(entityID.get(0));
////        }
////
////        return entityName;
////    }
//
// //TODO - RevAccCleanup
////    public Long findEntityByTIN(String accountNumber) {
////        try {
////            List<Long> list = 
////                getRefCodeAssemblerService().findEntityByTIN(accountNumber);
////            return list.get(0);
////        } catch (Exception e) {
////            return null;
////        }
////    }
//
//    public List<SelectItem> findAllNatureOfPayment(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PAYMENT_NATURE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFormByTaxType(Object code, String taxType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllFormByTaxType(code, taxType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    /**
//     * Check if the attachments has the required supporting documents for this formType
//     * @param types
//     * @param formType
//     * @return
//     */
//    public boolean hasReqSupportingDocuments(AttachmentType[] types, 
//                                             String formType) {
//        return getReferenceService().hasReqSupportingDocuments(types, 
//                                                               formType);
//    }
//
//    public String getListOfReqSupportingDocuments(AttachmentType[] types, 
//                                                  String formType) {
//        return getReferenceService().getListOfReqSupportingDocuments(types, 
//                                                                     formType);
//    }
//
//    public List<SelectItem> findAllBatchFormType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BATCH_FORM_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllBatchStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BATCH_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//
//    public RefBatchFormType findBatchFormTypeInfoBag(String code) {
//        return (RefBatchFormType)getRefCodeAssemblerService().find(code, 
//                                                                   DataReference.BATCH_FORM_TYPE);
//    }
//
//    public List<SelectItem> findAllFlexibleFormModeType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FLEXIBLE_FORM_MODE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SelectItem> findAllFlexibleFormModeAttribute(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_FLEX_FORMTYPE_MODE_ATT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllModeOfClaim() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllModeOfClaim();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllRestrictions() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRestrictions();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllMannerOfIssuance() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllMannerOfIssuance();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllLegalBasis() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllLegalBasis();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllClassificationOfProperty() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllClassificationOfProperty();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTypeOfProperty() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllTypeOfProperty();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    //TODO - RevAccCleanup
////    public Long findEntityIdByRevAcctId(Long revAccountId) {
////        Long l = 
////            getRefCodeAssemblerService().findEntityIdByRevAcctId(revAccountId);
////        return l;
////    }
//
//    public List<SelectItem> findAllRefDateCategory() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllRefDateCategory();
//        return FacesUtil.convertToSelectItems(list);
//    }
//
//    public List<SelectItem> findAllRefDateSubCategory() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllRefDateSubCategory();
//        return FacesUtil.convertToSelectItems(list);
//    }
//
//    public List<SelectItem> findAllRefDateRecurCfg() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllRefDateRecurCfg();
//        return FacesUtil.convertToSelectItems(list);
//    }
//
//    public List<SelectItem> findAllTaxType() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllTaxType();
//        return FacesUtil.convertToSelectItems(list);
//    }
//
//    public List<SelectItem> findAllFilingFrequency(Object code) {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAll(code,DataReference.STAGGER);
//        return FacesUtil.convertToSelectItems(list);
//    }
//
//    public List<SelectItem> findAllFormulaList() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllFormulaList();
//        return FacesUtil.convertToSelectItems(list);
//    }
//    
//    public List<SelectItem> findAllFilingMode() {
//        List<CodeAndDescription> list = 
//            getRefCodeAssemblerService().findAllFilingMode();
//        return FacesUtil.convertToSelectItems(list);
//    }
//
    public List<SelectItem> findAllSearchID(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllSearchID(code);
        return FacesUtil.convertToSelectItems(l);
    }

//    public List<SelectItem> findAllWorkflowName(Object code, 
//                                                String workflowType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllWorkflowName(code, 
//                                                             workflowType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllTransactionStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TRANSACTION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFieldUsageType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FIELD_USAGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseStatus() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseStatus();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<SelectItem> findAllCaseOutComesByCaseType(String caseType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseOutComesByCaseType(caseType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseTypes() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseTypes();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllCaseTypesByCaseCategory(String category) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseTypesByCaseCategory(category);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllCaseTypesByCaseType(String caseType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseTypesByCaseType(caseType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseDocumentStatus() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseDocumentStatus();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseDocumentType() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseDocumentType();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseReason(String category) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseReason(category);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllAuditProfileType() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllAuditProfileType();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllCaseOffice() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllCaseOffice();
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAcceptingCaseOffice(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAcceptingCaseOffice(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<OfficeSubordinates> findSubOffice(String code) {
//        return getRefCodeAssemblerService().findSubOffice(code);
//    }
//
//    public String findOfficeByUser(String userId) {
//        return getRefCodeAssemblerService().findOfficeByUser(userId);
//    }
//
//    public List<SelectItem> findAllConfigSetType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONFIG_SET_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllConfigSet(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.CONFIG_SET);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllFormMode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.FORM_MODE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllModeType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.MODE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllPossibleAction(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.POSSIBLE_ACTION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public String getJobParameter(String parameterName) {
//        return getReferenceService().getJobParameter(parameterName);
//    }
//
//    public Timestamp findPeriodStartRangeByPeriodId(Long id) {
//        return getRefCodeAssemblerService().findPeriodStartRangeByPeriodId(id);
//    }
//
//    public Timestamp findPeriodEndRangeByPeriodId(Long id) {
//        return getRefCodeAssemblerService().findPeriodEndRangeByPeriodId(id);
//    }
//
//    public String findCaseTypeByTaxType(String taxType, String moduleLink) {
//        return getRefCodeAssemblerService().findCaseTypeByTaxType(taxType, 
//                                                                  moduleLink);
//    }
//
//    public List<DdocDocumentError> findDocumentErrorsOnForm(Long formId, 
//                                                            String formType) {
//        return getDocumentService().findDocumentErrorsOnForm(formId, formType);
//    }
//
//    public List<SelectItem> findAllJobStream(Object code) {
//        List<CodeAndDescription> l = new ArrayList<CodeAndDescription>();
//            //getRefCodeAssemblerService().findAll(code, DataReference.JOB_STREAM);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllWebServices(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.WEB_SERVICE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllWebServiceMethod(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.WEB_SERVICE_METHOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllSchedulableSet(Object code) {
//        List<CodeAndDescription> l = new ArrayList<CodeAndDescription>();
//           // getRefCodeAssemblerService().findAll(code, DataReference.SCHEDULABLE_SET);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public String findUserByCode(String code){
//        return getRefCodeAssemblerService().findUserByCode(code);
//    }
//
//    public List<SelectItem> findAllRiskAllowedFieldsInForm(String formName){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRiskAllowedFieldsInForm(formName);
//        return FacesUtil.convertToSelectItems(l);
//    }    
//    
//
//    public List<SelectItem> findAllJobDefinition(JobDefinition jobDefinition) {
//        List<JobDefinition> results = null;
//        try {
//            results = 
//                    getRefCodeAssemblerService().findAllJobDefinition(jobDefinition);
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return (List<SelectItem>)FacesUtil.convertToSelectItemsObjectsAsValue(results, "jobName");
//    }
//    
//    public List<SelectItem> findAllJobStream(RefJobStream refJobStream) {
//        List<RefJobStream> results = null;
//        try {
//            results = 
//                    getRefCodeAssemblerService().findAllJobStream(refJobStream);
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return (List<SelectItem>)FacesUtil.convertToSelectItemsObjectsAsValue(results, Constants.DescriptionColumnName.DESCRIPTION);
//    }
//    
//    public List<SelectItem> findAllDesignation(){
//    
//        SelectItem item1 = new SelectItem();
//        SelectItem item2 = new SelectItem();
//        SelectItem item3 = new SelectItem();
//        
//        item1.setLabel(getReferenceService().getSystemParameter(Constants.CaseManagementConstants.DESIGNATION_LEAD)); 
//        item1.setValue(Constants.CaseManagementConstants.DESIGNATION_LEAD_CODE);
//        
//        item2.setLabel(getReferenceService().getSystemParameter(Constants.CaseManagementConstants.DESIGNATION_GS));
//        item2.setValue(Constants.CaseManagementConstants.DESIGNATION_GS_CODE);
//        
//        item3.setLabel(getReferenceService().getSystemParameter(Constants.CaseManagementConstants.DESIGNATION_RO));
//        item3.setValue(Constants.CaseManagementConstants.DESIGNATION_RO_CODE);
//        
//        List<SelectItem> designationSelectItem = new ArrayList<SelectItem>();
//        
//        designationSelectItem.add(item1);
//        designationSelectItem.add(item2);
//        designationSelectItem.add(item3);
//        
//        return designationSelectItem;
//    }
//
//    //TODO - RevAccCleanup    
////    public List<SelectItem> findAllPeriodEndByRegimeAndEntity(String regimeType, 
////                                                           Long entEntityId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPeriodEndByRegimeAndEntity(regimeType, 
////                                                                        entEntityId, 
////                                                                        false);
////        return FacesUtil.convertToSelectItems(l);
////    }
//
//
//    /**
//     * This method returns a list of all likelihood from RefLikelihood entity.
//     * @return
//     */
//    @ReferenceEntity(reference = RefLikelihood.class)
//    public List<SelectItem> findAllLikelihoodList() {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAllLikelihood());
//    }
//    
//    /**
//     * This method returns a list of all frequency from RefFrequency entity.
//     * @return
//     */
//    @ReferenceEntity(reference = RefFrequency.class)
//    public List<SelectItem> findAllFrequencyList() {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAllFrequency());
//    }
//    
//    /**
//     * This method returns a list of all scale from RefScale entity.
//     * @return
//     */
//    @ReferenceEntity(reference = RefScale.class)
//    public List<SelectItem> findAllScaleList() {
//        return FacesUtil.convertToSelectItems(getRefCodeAssemblerService().findAllScale());
//    }
//    
//    public List<SelectItem> findYesNo(){
//    
//        SelectItem item1 = new SelectItem();
//        SelectItem item2 = new SelectItem();
//        List<SelectItem> designationSelectItem = new ArrayList<SelectItem>();
//        
//        item1.setLabel("Yes"); 
//        item1.setValue(Constants.YES);
//        item2.setLabel("No"); 
//        item2.setValue(Constants.NO);
//        
//        designationSelectItem.add(item1);
//        designationSelectItem.add(item2);        
//        return designationSelectItem;
//    }
//
//    public Timestamp findPeriodDueDateByPeriodId(Long id) {
//        return getRefCodeAssemblerService().findPeriodDueDateByPeriodId(id);
//    }
////TODO - RevAccCleanup
////    public List<SelectItem> findAllPossiblePeriodByEntityIdAndPeriodStatus(Long entityID,String periodStatus) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPossiblePeriodByEntityIdAndPeriodStatus(entityID,periodStatus);
////        return FacesUtil.convertToSelectItems(l);
////    }
//    
//    public List<SelectItem> findAllTransactionTypeForPaymentAllocation(String[] allowedTranType) {  
//        List<CodeAndDescription> transactionTypeOfDebit = getRefCodeAssemblerService().findAllCodeAndDescription(null,RefTransactionType.class,Constants.DescriptionColumnName.DESCRIPTION,"obj.accTran = 'DEBIT'");
//        List<CodeAndDescription> finalList = new ArrayList<CodeAndDescription>();
//        if(transactionTypeOfDebit != null && allowedTranType  !=null){
//            List listAllowedTranType =  Arrays.asList(allowedTranType);   
//            for(int i=0; i<transactionTypeOfDebit.size(); i++){
//                CodeAndDescription cad = transactionTypeOfDebit.get(i);
//                if(listAllowedTranType.contains(cad.getCode())){
//                    finalList.add(cad);
//                }
//            }
//        }
//        return FacesUtil.convertToSelectItems(finalList);
//    }
//
//    //TODO - RevAccCleanup
////    public List<SelectItem> findAllPeriodStartByRegimeAndEntity(String regimeType, 
////                                                           Long entEntityId) {
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAllPeriodStartByRegimeAndEntity(regimeType, 
////                                                                        entEntityId, 
////                                                                        false);
////        return FacesUtil.convertToSelectItems(l);
////    }
//    
//    public String findSubTaxTypeDescription(String code) {
//        if (code == null)
//            return null;
//        return getRefCodeAssemblerService().findRefDescription(code, 
//                                                               DataReference.SUB_TAX_TYPE);
//    }
//    
//    public List<RefLegalStatusFiscal> findAllRefLegalStatusFiscalByLegalStatus(String legalStatus){
//        if (legalStatus == null)
//            return null;
//        return getRefCodeAssemblerService().findAllRefLegalStatusFiscalByLegalStatus(legalStatus);
//    }
//    
//    public List<SelectItem> findAllRelationshipTypesByCategory(Object code, String[] categoryTypes) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRelationshipTypesByCategory(code, categoryTypes);
//        return FacesUtil.convertToSelectItems(l);
//    }
//   
//    public List<SelectItem> findAllAuditSelectItems(String refTable){
//        List<CodeAndDescription> l =  getRefCodeAssemblerService().findAllAuditSelectItems(refTable);
//        
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllBatchJobParam(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BATCH_JOB_PARAM);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllRefundAssessment() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRefundAssessment();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public Long findEntityIdByAccountID(Long revId) {
////        return getRevenueService().findEntityIdByAccountID(revId);
//    return 0L;
//    }
//    
//    public RefLegalStatusType findLegalStatusByCode(String code){
//        return getRefCodeAssemblerService().findLegalStatusByCode(code);
//    }
//    public List<SelectItem> findUsageType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_USAGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
////
//    public List<SelectItem> findCopyScriptFrom(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findCopyScriptFrom();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllPropertyTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_PROPERTY_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllOwnershipTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_OWNERSHIP_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    @ReferenceEntity(reference = RefRegion.class)
//    public List<SelectItem> findAllRegions(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REGION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllNoteSubjects(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_NOTE_SUBJECT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllOccupationStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_OCCUPATION_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllOccupations(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_OCCUPATION_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }  
//    
//    public List<SelectItem> findAllPreciseCategorys(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllPreciseCategorys(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<SelectItem> findAllRefDistrict(String code) {
//        List<CodeAndDescription> l = 
//        getRefCodeAssemblerService().findAll(code, DataReference.REF_DISTRICT);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<SelectItem> findAllDistrictByRegionCode(String code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllDistrictByRegionCode(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
////    public List<SelectItem> findAllRefMonths() {
////    
////        final int MONTH_SIZE = 12;
////    
////        List<SelectItem> months = new ArrayList<SelectItem>();
////        SelectItem[] items = new SelectItem[MONTH_SIZE];
////        for(int i=1; i<=MONTH_SIZE ; i++)  {
////            items[i-1] = new SelectItem();
////            String label = (i<10) ? "0"+i : ""+i;
////            items[i-1].setLabel(label);
////            items[i-1].setValue(i);
////            months.add(items[i-1]);
////        }
////        return months;
////    }
////    
////    public List<SelectItem> findAllRefDays() {
////        final int DAYS_SIZE = 31;
////        List<SelectItem> days= new ArrayList<SelectItem>();
////        SelectItem[] items = new SelectItem[DAYS_SIZE];
////        for(int i=0; i<DAYS_SIZE; i++)  {
////            items[i] = new SelectItem();
////            items[i].setLabel(i+1 + "");
////            items[i].setValue(i+1 );
////            days.add(items[i]);
////        }
////        return days;        
////    }
//
    public List<SelectItem> findRefReasonsByCategorys(Object code, String[] categoryTypes) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findRefReasonsByCategorys(code, categoryTypes);
        return FacesUtil.convertToSelectItems(l);
    }
//
//    public List<SelectItem> findAllRefYears() {
//        final int YEARS_SIZE = 30;
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        List<SelectItem> years = new ArrayList<SelectItem>();
//        SelectItem[] items = new SelectItem[YEARS_SIZE];
//        for(int i=0; i<YEARS_SIZE; i++) {
//            items[i] = new SelectItem();
//            items[i].setLabel("" + (year-i));
//            items[i].setValue(year-i);
//            years.add(items[i]);
//        }
//        return years;
//    }
//    
//    public String findEntityTinByEntId(Long entId) {
//        return getRefCodeAssemblerService().findEntityTinByEntId(entId);
//    }
//    
//    public RefIdentifierType findRefIdentifierTypeByCode(String code) {
//        return getRefCodeAssemblerService().findRefIdentifierTypeByCode(code);
//    }
//    
    public List<SelectItem> findAllReasons(Object code) {
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAll(code, DataReference.REF_REASON);
        return FacesUtil.convertToSelectItems(l);
    }
//    
//    public List<SelectItem> findAllWithholdingTypeList() {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllWithholdingTypeList();
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
    public List<SelectItem> findAllReturnType(String revenueType, Object code){
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findAllReturnType(revenueType, code);
        return FacesUtil.convertToSelectItems(l); 
    }
    
//    public List<SelectItem> findRegReturnTypesByRevenueType(Long entityId, String revenueType){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findRegReturnTypesByRevenueType(entityId, revenueType);
//        return FacesUtil.convertToSelectItems(l); 
//    }
//    
//    public List<SelectItem> findAllExemptionCodes(String exemptionType, Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllExemptionCodes(exemptionType, code);
//        return FacesUtil.convertToSelectItems(l); 
//    }
//    
//    public List<SelectItem> findExemptionTaxtypesByExemptionId(Long id){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findExemptionTaxtypesByExemptionId(id);
//        return FacesUtil.convertToSelectItems(l); 
//    }
//    
//    public List<SelectItem> findAllReturnTypes(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllReturnTypes(code);
//        return FacesUtil.convertToSelectItems(l); 
//    }
//    
//    public List<SelectItem> findAllAttachmentTypesByTaxpayerType(String code) {
//        List<CodeAndDescription> l =
//            getRefCodeAssemblerService().findAllAttachmentTypesByTaxpayerType(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllReportParamType(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REPORT_PARAM_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }    
//
//    
////    public List<RefCfgGenPeriod> findAllRefCfgGenPeriod(Object code){
////        List<RefCfgGenPeriod> l =
////            getRefCodeAssemblerService().findAllRefCfgGenPeriod(code);
////        return l;      
////    }
//    
//    public List<SelectItem> findAllReportTypes(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REPORT_TYPES);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllPaperConfigs(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PAPER_CONFIG);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllPrinters(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PRINTER_OPTIONS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllStoreLocations(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PRINTER_STORE_LOCATION);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAdjustmentTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_ADJUSTMENT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAdjustmentReasonsByType(Object adjustmentType) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAdjustmentReasonsByType(adjustmentType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllParameterTypes(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.PARAMETER_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllImportTypes(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.IMPORT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllDishonouredReasons(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DISHONOURED_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findTaxTypesByDocTypes(String[] docTypes) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findTaxTypesByDocTypes(docTypes);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findTaxTypesByTaxpayerTypes(String[] taxpayerTypes) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findTaxTypesByTaxpayerTypes(taxpayerTypes);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findAllDueInSpan(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DUE_IN_SPAN);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllDueDayType(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DAY_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllDuePeriod(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.DUE_PERIOD);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    
//
//    public List<SelectItem> findAllPossibleConditions(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.POSSIBLE_CONDITIONS);
//        return FacesUtil.convertToSelectItems(l);
//    } 
//    
//    public List<SelectItem> findAllUserName(Object code){
//       
//        List<RefOffStaff> staffs = 
//                getRefCodeAssemblerService().findAllStaff(code);
//        List<SelectItem> results = null;    
//        if(staffs != null && staffs.size()> 0){
//            results = new ArrayList<SelectItem>();
//            for (RefOffStaff staff : staffs){
//                results.add(new SelectItem (staff.getId(), staff.getUsername()));                
//            }
//        }    
//            
//        return results;
//    } 
//    
//    
//    public List<SelectItem> findAllUserRole(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REV_COLL_ROLES);
//        return FacesUtil.convertToSelectItems(l);
//    } 
//    
//    public List<RefOffStaff> findStaffByName(String name){
//        List<RefOffStaff> staffList = getRefCodeAssemblerService().findStaffByName(name);
//        
//        return staffList;
//    }
//    
    public List<SelectItem> findReturnTypeByRevType(String revType){
        List<CodeAndDescription> l = 
            getRefCodeAssemblerService().findReturnTypeByRevType(revType);
        return FacesUtil.convertToSelectItems(l);       
    }
     
//    public List<SelectItem> findAllTillStatus(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_CASH_TILL_STATUS);
//        return FacesUtil.convertToSelectItems(l);       
//    }
//    
//    public List<SelectItem> findAllExemptionTypes(Object code, String dType) {
//        List<CodeAndDescription> l =
//            getRefCodeAssemblerService().findAllExemptionTypes(code, dType);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllApplicationBasics(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_ECR_APPLICATION_BASIS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllExemptionCategory(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_ECR_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllExemptionTypelist(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_EXEMPTION_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    
//    public List<SelectItem> findAllExemptionUsageType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_EXEM_USAGE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllExemptionStatus(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_ECR_STATUS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllCancellationReason(Object code) {
//        List<CodeAndDescription> l = getRefCodeAssemblerService().findAll(code, DataReference.REF_CANCELLATION_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllAdjustmentReason(Object code) {
//        List<CodeAndDescription> l = getRefCodeAssemblerService().findAll(code, DataReference.REF_ADJUSTMENT_REASON);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    
//    public List<SelectItem> findAllCaseOutcomes(Object code) {
//        List<CodeAndDescription> l = getRefCodeAssemblerService().findAll(code, DataReference.CASE_OUTCOME);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public RefReturnType getReturnTypeByCode(String code){
//          return getReferenceService().getReturnTypeByCode(code);
//    }
//    
//    
//    
//      
//    public RefReturnType getRefReturnTypeByDocType(String docType){
//          return getReferenceService().getRefReturnTypeByDocType(docType);
//    }
//    
//    public List<SelectItem> findUsersInGroup(String code) {
//        List<CodeAndDescription> l = getRefCodeAssemblerService().findUsersInGroup(code);
//        return FacesUtil.convertToSelectItems(l);
//    }
//      
//    public List<SelectItem> findAllComplianceUnitType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPLIANCE_UNIT_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllTaxTypeWithoutRevModeEnt(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.TAX_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
    public List<SelectItem> findPeriodByTaxTypeAndReturnType(String taxType, Long entityId,String returnType){
        List<GenericRegimePeriodSummaryBean> periodObjectList = getRevenueAccountService().findPeriodsOnRegimeandEntityId(taxType, entityId, returnType);
        List<SelectItem> periodList = new ArrayList<>();
        periodObjectList.stream().forEach((genericRegimePeriodSummaryBean) -> {
            periodList.add(new SelectItem(genericRegimePeriodSummaryBean.getPeriodId(), genericRegimePeriodSummaryBean.getPeriod()));
        });
        return periodList;        
    }
//    
    public AccRevLedAccount findRevenueLedgerAccount(String taxType,String busSect,String docType,String chargeType,
                                                        String taxpayerType,String subTaxCategoryL1,String subTaxCategoryL2){
//        try{
//            return getRevenueAccountService().findRevenueLedgerAccount(taxType,busSect,docType,chargeType,taxpayerType,
//                                                        subTaxCategoryL1,subTaxCategoryL2);                                                        
//        }catch(Exception ex){
            return null;
//        }
    }
    
////    public List<CodeAndDescription> findAllRefundStatus(Object code) {
////        
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAll(code, DataReference.REFUNDS_STATUS);
////        return l;
////    }
////    
////    public List<CodeAndDescription> findAllRefRegistrationSource(Object code) {
////        
////        List<CodeAndDescription> l = 
////            getRefCodeAssemblerService().findAll(code, DataReference.REF_REGISTRATION_SOURCE);
////        return l;
////    }
//    
//    public List<CodeAndDescription> findAllRefSortOrder(Object code) {
//        
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_SORT_ORDER);
//        return l;
//    }
//    
//    public List<SelectItem> findAllStatusWithoutDeleted(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.STATUS_NO_DELETED);
//        return FacesUtil.convertToSelectItems(l);
//    }
//
//    public List<SelectItem> findIndividualCategoryTypes(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.INDIVIDUAL_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findLegalStatusByTaxpayerType(String  taxpayer) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findLegalStatusByTaxpayerType(taxpayer);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllComputationBasis(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.COMPUTATION_BASIS);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllReturnDocumentType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_DOC_RETURN_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllBankRateType(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.BANK_RATE_TYPE);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findProfileSortCriterias(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_PROFILE_SORT_CRITERIA);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findRefSubTaxCategoryCode(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_SUB_TAX_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<SelectItem> findRefTaxCategoryLevel(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_TAX_CATEGORY_LEVEL);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    public List<RefSubTaxCategory> findRefSubtaxCategory(String revenuType,Long level) {
//    List<RefSubTaxCategory> parentCodelist = null;
//       parentCodelist =    getRefCodeAssemblerService().findRefSubtaxCategory(revenuType,level);
//       return parentCodelist;
//    }
//
//    public List<RefSubTaxCategory> findRefSubtaxCategory2(String revenuType,String parent) {
//    List<RefSubTaxCategory> categoryList = null;
//       categoryList =    getRefCodeAssemblerService().findRefSubtaxCategory2(revenuType,parent);
//       return categoryList;
//    }    
//    
//    
//    public RefSubTaxCategory findRefSubTaxCategoryWithCode(String code) {
//       RefSubTaxCategory subTaxCategory = 
//            getRefCodeAssemblerService().findRefSubTaxCategoryWithCode(code);
//       return subTaxCategory;
//    } 
//    
//    public List<SelectItem> findPrintersByOffice(String officeId){
//        List<RefOffPrinters> refOffPrinters = getRefCodeAssemblerService().findPrintersByOffice(officeId);
//        List<SelectItem> results = null;
//        if(refOffPrinters != null && refOffPrinters.size()> 0){
//            results = new ArrayList<SelectItem>();
//            for (RefOffPrinters refOffPrinter : refOffPrinters){
//                results.add(new SelectItem (refOffPrinter.getRefPrinter().getCode(), refOffPrinter.getRefPrinter().getDescription()));                
//            }
//        }   
//        
//        return results;
//    }
//    
//    public RefOffPrinters findDefaultPrinterByOffice(String officeId){
//        List<RefOffPrinters> refOffPrinters = getRefCodeAssemblerService().findPrintersByOffice(officeId);
//        RefOffPrinters defaultPrinter = null;
//        if(refOffPrinters!=null && refOffPrinters.size()>0){
//            
//            for(RefOffPrinters refOffPrinter : refOffPrinters){
//               if(refOffPrinter.getDefaultPrinter().equals("Y")) {
//                   defaultPrinter = refOffPrinter;
//                   break;
//               }
//            }         
//        }
//        return defaultPrinter;
//    }
//    
//    public List<SelectItem> findAllReportGroups(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REPORT_GROUP);
//        return FacesUtil.convertToSelectItems(l);
//    } 
//    
//    public List<CodeAndDescription> findAllAttachmentTypes(Object code){
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.REF_ATTACHMENT_TYPE);
//        return l;
//    }
//    
//    public List<SelectItem> findApplicationSourceList(Object code) {
//        List<CodeAndDescription> l =
//            getRefCodeAssemblerService().findAll(code,DataReference.REF_REFUND_CLAIM_ORIGINATOR);
//        return FacesUtil.convertToSelectItems(l);    
//    }
//    
//    public List<SelectItem> findAllRefRiskPoints() {
//        List<CodeAndDescription> l =
//            getRefCodeAssemblerService().findAllRefRiskPoints();
//        List<SelectItem> riskPointsList = FacesUtil.convertToSelectItems(l);
//        List<SelectItem> selectItems = new ArrayList<SelectItem>();
//        for(SelectItem riskPointItem : riskPointsList) {            
//            selectItems.add(new SelectItem(new Integer((String)riskPointItem.getValue()), riskPointItem.getLabel()));                        
//        }
//        return selectItems;    
//    }
//
//    /**
//     * This method returns a list of all operands from RefIgnoreField entity.
//     * @return
//     */
//    @ReferenceEntity(reference = RefIgnoreField.class)
//    public List<String> findIgnoreFieldsByCategory(Object code, 
//                                                   String ignoreCategory) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllIgnoreFieldByCategory(code, 
//                                                                      ignoreCategory);
//        if (null == l)
//            return null;
//        else {
//            List<String> ignoreFields = new ArrayList<String>(l.size() + 1);
//            Iterator i = l.iterator();
//            while (i.hasNext()) {
//                CodeAndDescription cad = (CodeAndDescription)i.next();
//                // Filter out items that have been created but are both null
//                if ((null != cad.getCode()))
//                    ignoreFields.add((String)cad.getCode());
//            }
//            return ignoreFields;
//        }
//    }
//    
//    @ReferenceEntity(reference = RefGroupCategory.class)
//    public List<SelectItem> findAllGroupCategories(Object code) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAll(code, DataReference.GROUP_CATEGORY);
//        return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findGroupsByCategory(String category){
//            List<CodeAndDescription> l = 
//                getRefCodeAssemblerService().findGroupsByCategory(category);
//            return FacesUtil.convertToSelectItems(l);
//    }
//    
//    public List<SelectItem> findAllRejectionCode(Object code, String filter) {
//        List<CodeAndDescription> l = 
//            getRefCodeAssemblerService().findAllRejectionCode(code, filter);
//        return FacesUtil.convertToSelectItems(l);
//    }
    
	public RefCurrency findRefCurrencyByCode(String code) {
		return getReferenceService().findRefCurrencyByCode(code);
	}
    
}

