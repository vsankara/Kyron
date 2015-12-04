package com.technobrain.trips.assembler.service;

import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.common.model.FileStore;
import com.technobrain.trips.core.service.FacadeRemote;
import com.technobrain.trips.dto.CodeAndDescription;
import java.io.Serializable;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface RefCodeAssemblerSessionEJBRemote extends FacadeRemote {
    /**
     * Gets cleaned up when the user logs out of the
     * system
     */
//    public
    //@Remove
//    void disAssemble();
    
    public List<CodeAndDescription> findAllCodeAndDescription(Object code, Class referenceClazz, String descFieldName);
    
    public List<CodeAndDescription> findAllRevenueTypeByTin(String tin);

    public FileStore getFileFromStore(Long id);
    
    public List<CodeAndDescription> findReturnTypeByRevType(String revType);
    
    public List<CodeAndDescription> findAllReturnTypes(Object code);
    
    public List<CodeAndDescription> findAllReturnType(String revenueType, Object code);
    
    public List<CodeAndDescription> findAllMonthsOfYear();
    
    public List<CodeAndDescription> findRefReasonsByCategorys(Object code, String[] categoryTypes);

    
//    public List<BaseRefModelObject> findAllRefPojos(Object code, Class referenceClazz, String descFieldName);
//    
//    public List<CodeAndDescription> findWarehouseId(Object code);
//
//    public List<CodeAndDescription> findAllTransportModes(Object code);
//
//    public List<CodeAndDescription> findAllReasons(Object code, String filter);
//    
//    public List<CodeAndDescription> findAllDeactivateReasons(Object code, String filter);
//
//    public List<CodeAndDescription> findAllBanks(Object code, String filter);
//
//    public String findTransactionTypeDescByID(Long transactionID);
//
    public String findSystemParameter(String code);
    
    
//
//    public String findCommodityCategory(String comCode);
//
//    public List<CodeAndDescription> findAllRegimeAccountByTin(String tin, String regType);
//
//    public List<CodeAndDescription> findAllRegimeAccountByTinAndRegimeType(String tin, String regType);
//
//    public List<CodeAndDescription> findAllPeriodByRegAcc(Long acctId);
//    
//    public List<CodeAndDescription> findAllNonFiledPeriodByRegAcc(Long acctId);
//    
//    public List<CodeAndDescription> findAllFiledPeriodByRegAcc(Long acctId);
//    
//    public List<CodeAndDescription> findAllPeriodByRegAccFilterByStatus(Long acctId, String [] statusFilterStatus);
//
//    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo, String regimeType);
//
//    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo, String regimeType, 
//                                                                       boolean descAsCode);
//
//    public String findPeriod(Long periodID);
//
//    public String findDeclarationByCustRef(String referenceNumber);
//
//    public Long findRevIDByEntityIdAndRevType(Long entityId, String revType);
//
//    public List<CodeAndDescription> findAllPeriodByRegimeAndEntity(String regimeType, Long entEntityId, 
//                                                                   boolean useDescAsCode);
//
//    public List<CodeAndDescription> findAllPeriodByRegime(String regimeType);
//
//    public List<CodeAndDescription> findAllPeriodByPeriodFrom(Long revAcc, Long periodId, boolean isDescAsCode);
//
//    public List<CodeAndDescription> findAllPeriodStart(Object code);
//
//    /**
//     * It returns all the revenue account type registered for a taxpayer if acctStatus is null, otherwise
//     * a list of revenue account type with the status passed.
//     * @param entityID
//     * @param acctStatus
//     * @return
//     */
//    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, String acctStatus);
//
//    /**
//     * This query shall return all registered tax type for a taxpayer, including the default taxpayer account
//     * on the boolean value set. 
//     * 
//     * @param entityID
//     * @param isWithTaxpayer
//     * @return
//     */
//    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, boolean isWithTaxpayer);
//
//    public List<CodeAndDescription> findRevenueIDByEntityID(Long entityID);
//
//    public List<CodeAndDescription> findAllRefTables();
//    
//    public List<CodeAndDescription> findAllRefTablesToManage();
//
//    public List findRefData(String entityBean, String code, String description);
//
//    /**
//     * This metod gets list of elements based on the listType passed
//     * @param listType
//     * @return
//     */
//    public
//
//    List<CodeAndDescription> findAllListItemsByListType(String listType);
//
//    public List<CodeAndDescription> findAllOperandList(String listType);
//
//    /**
//     * The method list all message sections based on the message type
//     * @param msgType
//     * @return
//     */
//    public List<CodeAndDescription> findAllSectionList(String msgType);
//
//    public List<CodeAndDescription> findAllSectionListByCode(Object code);
//
//    public List<CodeAndDescription> findAllFieldListByCode(Object code);
//
//    /**
//     * The method list all message fields based on the section
//     * @param section
//     * @return
//     */
//    public List<CodeAndDescription> findAllFieldList(Long section);
//
//    public List<CodeAndDescription> findAllPortsInCountry(String countryCode);
//
//    public List<CodeAndDescription> findAllVesselTypeList();
//
//    public Double findInterestRate();
//
//    /**
//     * This method returns list of all workflow mapping from WfWorkflowMapping entity.
//     * @param workflow
//     * @param status
//     * @param regime
//     * @param action
//     * @return
//     */
//    public List<WfWorkflowMapping> findWorkflowMappingList(String workflow, String status, String regime, 
//                                                           String action);
//
//    public Long saveToFileStore(FileStore fst);
//
//    public FileStore getFileFromStore(Long id);
//
//    /**
//     * Method is called when workflow mapping list is filtered by search fields
//     * contained in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<WfWorkflowMapping> findWorkflowMappingList(Map seachFieldsMap);
//
//    /**
//     * Method is called when customs tax type list is filtered by search fields
//     * contained in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<RefCustTaxType> findRefCustTaxTypeList(Map seachFieldsMap);
//
//    /**
//     * Method returns list of WfWorkflow entities for a given workflow
//     * @param workflow
//     * @return
//     */
//    public List<WfWorkflow> findWorkflowList(String workflow);
//
//    /**
//     * Method is called when workflow list is filtered by search fields contained
//     * in the input Map.
//     * @param seachFieldsMap
//     * @return
//     */
//    public List<WfWorkflow> findWorkflowListAfterSearch(Map seachFieldsMap);
//
//    public ProductInputType getProductInputType(Long productId);
//
//    public Long saveProduct(ProductInputType productInputType);
//
//    public List<RefCustTaxBand> findRefCustTaxCalcList(String code);
//
//    public String findLocationInCountry(Long locationId);
//
//    public List<CodeAndDescription> findAllMeasurementUnitsByMeasurement(String code);
//
//    public List<CodeAndDescription> findAllFreeZone();
//
//    public List<RefCustomsProcCode> findAllCustomsProcCode();
//
    public List<CodeAndDescription> findAllPeriodTypes(Object code);

//    /**
//     * Finds the reference codes for this dataSetType
//     * @param code
//     * @param dataSetType
//     * @return
//     */
    public List<CodeAndDescription> findAll(Object code, DataReference dataSetType);

//    public List<CodeAndDescription> findAllApplicationTypeByIndicator(String indicatorType);
//
//    public List<CodeAndDescription> findAllDocTypeByCategory(String docType, String category);
//
//    public List<CodeAndDescription> findAllProductNameById(Object productId);
//
//    public List<CodeAndDescription> findAllSensitiveProductNameByComCode(Object comCode);
//
//    public List<CodeAndDescription> findAllSuspendedProductNameByComCode(Object comCode);
//
//    public List<CodeAndDescription> findAllProductNameByComCode(Object comCode);
//
    public List<CodeAndDescription> findAllOfficesForUser(Object code, String userID);
    
//    public List<CodeAndDescription> findOfficesByOfficeType(Object code, String officeType);    
//
//    public List<CodeAndDescription> findAllTaxRateTablePeriod(Object code);
//
//    public List<CodeAndDescription> findAllTaxBand(Object code);
//
//    public RefOffice findOfficeDetails(String officeCode);
//
    public String findRefDescription(String code, DataReference dataReference);
    
//    public List<CodeAndDescription> findAllApplicationRoleByRoleType(String roleType);
//
//    public List<CodeAndDescription> findAllAppAttachmentTypesByAppType(String appType, Object code);
//    
//    public List<CodeAndDescription> findAllRevenueTypeByLegalStatus(Object code,String legalStatus);
//    
//    public String findRefGuaranteeAmountPercCode(String description);
//
//    public String findConfParameter(String code);
//
//    public List<CodeAndDescription> findAllFlexibleFormTypes(Object code);
//    
//    public List<CodeAndDescription> findAllFlexibleForms(Object code);    
//    
//    public List<CodeAndDescription> findAllFlexibleFieldsForForm(Long formId);
//
//    public List<CodeAndDescription> findAllFlexibleFieldTypes(Object code);    
//
    public Serializable find(Object code, DataReference dataReference);
//    
//    public List<CodeAndDescription> findAllSubTaxTypeByTaxType(Object code,String filter);
//    
public List<CodeAndDescription> findAllLegalStatusByTaxpayerType(Object code,String taxpayerType, String mode);
//
//    public List<CodeAndDescription> findAllFlexibleFormNameList(Object code);
//
//    public List<CodeAndDescription> findAllSubdivision(Object code, 
//                                                       String subvisionCode,
//                                                       String userOffice, 
//                                                       String string);
//
//    public List<CodeAndDescription> findAllSubdivision(String county);
//    public List<SysDbTableDefaultCols> findAllDefaultColumnsForTables();
//
//    public List<CodeAndDescription> findAllTransactionTypes(Object code, 
//                                                            String filter) ;
//                                                            
//    public List<CodeAndDescription> findAllPenaltyTypes(Object code,
//                                                            String filter);
//                                                
//    public List<CodeAndDescription> findRefRevTypesByEntity(Object entityID);
//    
//    public List<CodeAndDescription> findRefRevTypesByEntityAndCode(Object entityID, String code);
//    
//    public List<Long> findEntityByTIN(String accountNumber);
//    
//    public List<CodeAndDescription> findAllFormByTaxType(Object code,String taxType);
//    
//    public List<CodeAndDescription> findAllModeOfClaim();
//    
//    public List<CodeAndDescription> findAllRestrictions();
//    
//    public List<CodeAndDescription> findAllMannerOfIssuance();
//    
//    public List<CodeAndDescription> findAllLegalBasis();
//    
//    public Long findEntityIdByRevAcctId(Long revAccountId);
//    
//    public List<CodeAndDescription> findAllRefDateCategory();
//    
//    public List<CodeAndDescription> findAllRefDateSubCategory();
//    
//    public List<CodeAndDescription> findAllRefDateRecurCfg();
//    
//    public List<CodeAndDescription> findAllTaxType();
//    
//    public List<CodeAndDescription> findAllFilingFrequency();
//    
//    public List<CodeAndDescription> findAllCaseStatus();
//    
//    public List<CodeAndDescription> findAllCaseTypes();
//    
//    public List<CodeAndDescription> findAllCaseDocumentStatus();
//    
//    public List<CodeAndDescription> findAllCaseDocumentType();
//    
//    public List<CodeAndDescription> findAllCaseReason(String catergory);
//    
//    public List<CodeAndDescription> findAllCaseOffice();
//    
//    public List<CodeAndDescription> findAllOfficeStaff(String officeCode);
//    
    public List<CodeAndDescription> findAllSearchID(Object code);
    
//    public List<CodeAndDescription> findAllWorkflowName(Object code,
//                                                   String workflowType);
//                                                   
//    public List<CodeAndDescription> findAllClassificationOfProperty();
//                                                     
//    public List<CodeAndDescription> findAllTypeOfProperty();
//
//    public List<CodeAndDescription> findAllCollectionAgentNames(String agentName, 
//                                            String agentType) ;
//                                            
//    public List<CodeAndDescription> findAllUsers();
//    
//    public List<CodeAndDescription> findAllAttachmentTypesByTaxpayerType(String type);
//    
//    public List<CodeAndDescription> findCurrencyByCode(String code);    
//
//    public List<CodeAndDescription> findAllPreciseCategoryBasedOnMainCategory (String preciseCategory, String mainCategory);
//    
//    public List<CodeAndDescription> findAllEvtType();
   }
