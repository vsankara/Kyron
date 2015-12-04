package com.technobrain.trips.assembler.service;

import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.common.model.FileStore;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.dto.CodeAndDescription;

import com.technobrain.trips.reference.model.RefEvtTypeCat;

import java.util.List;

import javax.ejb.Local;


/**
 * This class contains methods that query and return
 * a list of active ('A') records that are converted to
 * a CodeAndDescription class as key and description pair.
 * <p>
 * The method signature includes a code which is bound to the selected description
 * on the page.If the code is found to be not active ('A') in the database
 * then add it to the list returned.e.g
 * <code>
 * CodeAndDescription cad = new CodeAndDescription(code,description);
 * </code>
 * Otherwise ignore this code.
 * @param code
 * @return
 */
@Local
public interface RefCodeAssemblerSessionEJBLocal extends FacadeLocal {
    /**
     * Gets cleaned up when the user logs out of the
     * system
     */
    public
    //@Remove
    void disAssemble();
    
   public List<CodeAndDescription> findAllCodeAndDescription(Object code, Class referenceClazz, String descFieldName);
   
   public List<CodeAndDescription> findAllMonthsOfYear();
   
   public List<CodeAndDescription> findRefReasonsByCategorys(Object code, String[] categoryTypes);
    
//    public List<BaseRefModelObject> findAllRefPojos(Object code, Class referenceClazz, String descFieldName);
//    
//    public List<CodeAndDescription> findWarehouseId(Object code);
//
//    public List<CodeAndDescription> findAllTransportModes(Object code);
//
//    public List<CodeAndDescription> findAllReasons(Object code, String filter);
//    public List<CodeAndDescription> findAllDeactivateReasons(Object code, String filter); 
//    
    public List<CodeAndDescription> findAllReturnTypes(Object code);
    
//    public List<CodeAndDescription> findRegReturnTypesByRevenueType(Long entityId, String revenueType);
//
//    public List<CodeAndDescription> findAllBanks(Object code, String filter);
//
//    public String findTransactionTypeDescByID(Long transactionID);
//
    public String findSystemParameter(String code);
//
//    public String findCommodityCategory(String comCode);
//    
//   // public List<CodeAndDescription> findQuarter(BigDecimal quarterNo);
//   
//    public  String findQuarter(BigDecimal quarterNo);
//	
//    public  List<RefQuarters> findQuarters(BigDecimal quarterNo);
//    
//    public List<CodeAndDescription> findAllMeasurementUnitsByMineralFormType();
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllRegimeAccountByTin(String tin, String regType);
// //TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllRegimeAccountByTinAndRegimeType(String tin, String regType);
// //TODO - RevledRevPeriod/RevledTransactionCleanup
////    public List<CodeAndDescription> findAllPeriodByRegAcc(Long acctId);
//    
////TODO - RevledRevPeriodCleanup
////    public List<CodeAndDescription> findAllNonFiledPeriodByRegAcc(Long acctId);
//    
////TODO - RevledRevPeriodCleanup
////    public List<CodeAndDescription> findAllFiledPeriodByRegAcc(Long acctId);
// //TODO - RevledRevPeriod/RevledTransactionCleanup    
////    public List<CodeAndDescription> findAllPeriodByRegAccFilterByStatus(Long acctId, String [] statusFilterStatus);
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo, String regimeType);
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodByRegimeTypeAndAcctNo(String acctNo, String regimeType,boolean descAsCode);
//
//    public String findPeriod(Long periodID);
//
//    public String findDeclarationByCustRef(String referenceNumber);
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodByRegimeAndEntity(String regimeType, Long entEntityId, boolean useDescAsCode);
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
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, String acctStatus);
//
//    /**
//     * This query shall return all registered tax type for a taxpayer, including the default taxpayer account
//     * on the boolean value set. 
//     * 
//     * @param entityID
//     * @param isWithTaxpayer
//     * @return
//     */
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllRevenueTypeByEntityIdAndAcctStatus(Long entityID, boolean isWithTaxpayer);
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findRevenueIDByEntityID(Long entityID);
//    
    public List<CodeAndDescription> findAllRevenueTypeByTin(String tin);

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
    public Long saveToFileStore(FileStore fst);

    public FileStore getFileFromStore(Long id);
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
//    public List<CodeAndDescription> findAllMeasurementUnitsByFormType(String formType);
//
//    public List<CodeAndDescription> findAllFreeZone();
//
//    public List<RefCustomsProcCode> findAllCustomsProcCode();
//    
//    public List<CodeAndDescription> findProductTypeOnCommodityCode(String code);
//    
//    public List<CodeAndDescription> findWithHoldingType(String code);
//    
//    public List<String> findWithHoldingTypeCodes(String category);
//
//    public List<CodeAndDescription> findAllPeriodTypes(Object code);
//
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
    public String findConfParameter(String code);
//
//    public List<CodeAndDescription> findAllFlexibleFormTypes(Object code);
//    
//    public List<CodeAndDescription> findAllFlexibleForms(Object code);    
//    
//    public List<CodeAndDescription> findAllFlexibleFieldsForForm(Long formId);
//
//    public List<CodeAndDescription> findAllFlexibleFieldTypes(Object code);    
//
//    public Serializable find(Object code, DataReference dataReference);
//    
//    public List<CodeAndDescription> findAllSubTaxTypeByTaxType(Object code,String filter);
//    
    public List<CodeAndDescription> findAllLegalStatusByTaxpayerType(Object code,String taxpayerType, String mode);
//    
//    public List<CodeAndDescription> findAllRevenueTypeByTaxPayerType(String taxpayerType, Object code);    
//    
//    public List<CodeAndDescription> findFilteredLegalStatusByTaxpayerType(Object code,String taxpayerType);
//    
//    public List<CodeAndDescription> findLegalStatusByTaxpayerType(String taxpayerType);
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
////TODO - RevAccCleanup                                                
////    public List<CodeAndDescription> findRefRevTypesByEntity(Object entityID);
//    
//    public String findRefRevTypePeriodByCode(String code);
////TODO - RevAccCleanup    
////    public List<CodeAndDescription> findRefRevTypesByEntityAndCode(Object entityID, String code);
//    //TODO - RevAccCleanup    
////    public List<Long> findEntityByTIN(String accountNumber);
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
//    //TODO - RevAccCleanup    
////    public Long findEntityIdByRevAcctId(Long revAccountId);
//    
//    public List<CodeAndDescription> findAllRefDateCategory();
//    
//    public List<CodeAndDescription> findAllRefDateSubCategory();
//    
//    public List<CodeAndDescription> findAllRefDateRecurCfg();
//    
//    public List<CodeAndDescription> findAllTaxType();
//   
//    public List<CodeAndDescription> findAllFormulaList();
//    
//    public List<CodeAndDescription> findAllFilingMode();
//    
//    public List<CodeAndDescription> findAllCaseStatus();
//    
//    public List<CodeAndDescription> findAllCaseOutComesByCaseType(String caseType);
//    
//    public List<CodeAndDescription> findAllCaseTypes();
//    
//    public List<CodeAndDescription> findAllCaseTypesByCaseCategory(String caseCategory);
//    
//    public List<CodeAndDescription> findAllCaseTypesByCaseType(String caseType);
//    
//    public List<CodeAndDescription> findAllCaseDocumentStatus();
//    
//    public List<CodeAndDescription> findAllCaseDocumentType();
//    
//    public List<CodeAndDescription> findAllCaseReason(String catergory);
//    
//    public List<CodeAndDescription> findAllCaseOffice();
//    
//    public List<CodeAndDescription> findAcceptingCaseOffice(String code);
//    
//    public List<OfficeSubordinates> findSubOffice(String code);
//    
//    public String findOfficeByUser (String userId);
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
//    public List<CodeAndDescription> findAllUsersByLastName();
//    
//    public Timestamp findPeriodStartRangeByPeriodId(Long id);
//    
//    public Timestamp findPeriodEndRangeByPeriodId(Long id);
//    
//    public String findCaseTypeByTaxType(String taxType, String moduleLink);
//
//    public List<CodeAndDescription> findAllTaxpayerTypeFromComplianceConfig(Object code);
//    //TODO - RevledRevPeriod/RevledTransactionCleanup
////    public String findPeriodLabel(Long periodID);
//    
//    public List<CodeAndDescription> findAllRefundAuthType();
//    
//    public List<CodeAndDescription> findAllRCOAgents(String rdo);
//    
//    public String findCollAgentByCode(String agentCode);
//
//    public List<CodeAndDescription> findAllGovBanks(String currentOffice);
//    
//    public String findUserByCode(String code);
//
//    public List<CodeAndDescription> findAllRiskAllowedFieldsInForm(String formName);
//
//    public List<CodeAndDescription> findAllRiskAllowedFieldsForSectionInForm(String formName, String sectionId);
//    
//    public List<JobDefinition> findAllJobDefinition(JobDefinition jobDefinition);
//        
//    public List<RefJobStream> findAllJobStream(RefJobStream refJobStream);
////TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodEndByRegimeAndEntity(String regimeType, Long entEntityId, 
////                                                                   boolean useDescAsCode);
//                                                                   
//    public List<CodeAndDescription> findAllLikelihood();
//    
//    public List<CodeAndDescription> findAllFrequency();
//    
//    public List<CodeAndDescription> findAllScale();
//                                                                   
//    public Timestamp findPeriodDueDateByPeriodId(Long id);
//
//    public List<CodeAndDescription> findAllRefDateRecurCfgByFilingFreq(String filter);
//    
//    public List<CodeAndDescription> findAllAuthorisationTypeByApplication(String authorizationType, 
//                                                                  String applicationType) ;
////TODO - RevAccCleanup                                                                 
////    public List<CodeAndDescription> findAllPossiblePeriodByEntityIdAndPeriodStatus(Long entityID,String periodStatus);
//    
//    public List<CodeAndDescription> findAllCodeAndDescription(Object code, Class referenceClazz, String descFieldName, String condition);
//    
//    public List<CodeAndDescription> findAllAuditProfileType();
//    //TODO - RevAccCleanup
////    public List<CodeAndDescription> findAllPeriodStartByRegimeAndEntity(String regimeType, Long entEntityId, 
////                                                                   boolean useDescAsCode);
//                                                                   
//    public List<CodeAndDescription> findAllIndustryGroup();                                                     
//    
//    public List<CodeAndDescription> findAllIndustryByGroup(String group);
//
//    public List<CodeAndDescription> findAllRiskLevels();
//    
//    public List<RefLegalStatusFiscal> findAllRefLegalStatusFiscalByLegalStatus(String legalStatus);
//    
//    public List<CodeAndDescription> findAllRelationshipTypesByCategory(Object code,String[] categoryTypes);
//    
//    public List<RefRelationshipType> findAllRefRelationshipTypeByCategory(String category);
//    
//    public List<CodeAndDescription> findAllAuditSelectItems(String refTable);
//        
//    public List<CodeAndDescription> findAllRefundAssessment();
//    
//    public RefLegalStatusType findLegalStatusByCode(String code);
//    
//    public List<CodeAndDescription> findCopyScriptFrom();
//    
//    public List<CodeAndDescription> findAllCountriesExceptLocal(String localCountry);
//    
    public RefEvtTypeCat findEvtTypeCategory(String eventType, String category);
//    
//    public List<CodeAndDescription> findAllPreciseCategorys(String category);
//    
//    public List<CodeAndDescription> findAllDistrictByRegionCode(String category);
//    
//    public List<CodeAndDescription> findAllBankBranches(Object bankBranch);
//    
//    public RefBusinessSector findBusinessSector(String businessSectorCode);
//    
//    public List<CodeAndDescription> findRefReasonsByCategorys(Object code, String[] categoryTypes);
//    
//    public List<RefIdentifierType> findAllIdentifierTypes(Object code);
//    
//    public String findEntityTinByEntId(Long entId);
//    
//    public RefIdentifierType findRefIdentifierTypeByCode(String code);
//    
//    public List<CodeAndDescription> findAllWithholdingTypeList();
//    
    public List<CodeAndDescription> findAllReturnType(String revenueType, Object code);
    
//    public List<CodeAndDescription> findAllExemptionCodes(String exemptionType, Object code);
//    
//    public List<CodeAndDescription> findAllAttachmentTypesByTaxpayerType(String type);
//    
//    public List<CodeAndDescription> findAllBusinessSectors(Object code);
//    
//  //  public List<RefCfgGenPeriod> findAllRefCfgGenPeriod(Object code);
//
//    public List<CodeAndDescription> findAllAllocationTypes(Object code);
//    
////    public List<CodeAndDescription> findAllAllocationMethods(Object code);
//    
//    public List<CodeAndDescription> findAdjustmentReasonsByType(Object adjustmentType);
//    
////    public RefAllocationMethod getAllocationMethodByCode(String code);
//    
//    public RefAllocationType getAllocationTypeByCode(String code);
//    public List<RefOffStaff> findOfficeStaffByOffice(String officeCode);
//    public List<CodeAndDescription> findTaxTypesByDocTypes(String[] docTypes);
//    
//    public List<CodeAndDescription> findTaxTypesByTaxpayerTypes(String[] taxpayerTypes);
//
//    public List<CodeAndDescription> findEntityTypes(List<String> taxpayerTypes);
//    
//    public List<RefOffStaff> findInactiveOfficeStaffByOffice(String officeCode);
//    
//    public List<CodeAndDescription> loadRefPojoData(String refClass);
//
//    public List<CodeAndDescription> findAllFinancialDocumentTypes(Object code, String[] categoryTypes);
//
//    public List<RefOffStaff> findUnallocatedOfficersForCashOffice (String officeId);
//    
//    public List<CodeAndDescription> findRefOwnerShipDetailsExceptOthers();
//    
//    public List<RefOffStaff> findAllStaff(Object code); 
//    
//    public List<RefOffStaff> findStaffByName(String name);
//    
    public List<CodeAndDescription> findReturnTypeByRevType(String revType);
    
//    public List<CodeAndDescription> findCurrencyByCode(String code);
//    public List<CodeAndDescription> findUsersInGroup(String casRole);
//    
//    public List<CodeAndDescription> findExemptionTaxtypesByExemptionId(Long id);
//    
//    public List<CodeAndDescription> findAllExemptionTypes(Object code, String dType);
//	public List<CodeAndDescription> findAllPreciseCategoryBasedOnMainCategory (String preciseCategory, String mainCategory);
//
//    public EntityManager getEntityManager();
//
//    public List<CodeAndDescription> findAllEvtType();
//    
//    public List<CodeAndDescription> findAllOperandList(Object code,String operandCategory);
//    
//    public String findDescByCodeFromRefTable(String entityName, String code);
//    
//    public List<RefSubTaxCategory> findRefSubtaxCategory(String revenuType,Long level );
//    
//    public List<RefSubTaxCategory> findRefSubtaxCategory2(String revenuType,String parent);
//  
//    public RefSubTaxCategory findRefSubTaxCategoryWithCode(String code);
//
//    public List<CodeAndDescription> findAllRevenueTypeWithReturnsByTin(String tin);
//
//    public List<RefOffPrinters> findPrintersByOffice(String officeId); 
//    
//    public List<CodeAndDescription> findAllMonthsOfYear();
//    
//    public List<CodeAndDescription> findAllRefRiskPoints();
//    
//    public List<CodeAndDescription> findAllIgnoreFieldByCategory(Object code,String ignoreCategory);
//    
//    public List<CodeAndDescription> findGroupsByCategory(String category);
//    
//    public List<CodeAndDescription> findAllRefFrequency(Object code, String frequencyCategory);
//
//    public List<CodeAndDescription> findAllRejectionCode(Object code,String filter);

}
