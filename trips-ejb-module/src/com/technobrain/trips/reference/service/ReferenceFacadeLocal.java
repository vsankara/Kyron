package com.technobrain.trips.reference.service;

import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.reference.model.RefCurrency;
import com.technobrain.trips.security.model.SysUserLogin;

import java.util.Date;

import javax.ejb.Local;

import javax.sql.DataSource;


@Local
public interface ReferenceFacadeLocal extends FacadeLocal {

    public RefCurrency findRefCurrencyByCode(String code);

//    public List<RefOffStaff> findAllOffStaff();
//    
//    List<RefBusinessSector> queryRefBusinessSectorFindAll();
//
//    void removeRefBusinessSector(RefBusinessSector refBusinessSector);
//
//    List<RefCfgRegime> queryRefCfgRegimeFindAll();
//
//    void removeRefCfgRegime(RefCfgRegime refCfgRegime);
//
//    List<RefComplianceType> queryRefComplianceTypeFindAll();
//
//    void removeRefComplianceType(RefComplianceType refComplianceType);
//
//    List<RefCommunityCode> queryRefCommunityCodeFindAll();
//
//    void removeRefCommunityCode(RefCommunityCode refCommunityCode);
//    
//    List<RefDataSource> queryRefDataSourceFindAll();
//
//    void removeRefDataSource(RefDataSource refDataSource);
//
//    List<RefComAgreementType> queryRefComAgreementTypeFindAll();
//
//    void removeRefComAgreementType(RefComAgreementType refComAgreementType);
//
//    List<RefComCode> queryRefComCodeFindAll();
//
//    void removeRefComCode(RefComCode refComCode);
//
//    List<RefComProcedure> queryRefComProcedureFindAll();
//
//    void removeRefComProcedure(RefComProcedure refComProcedure);
//
//    List<RefComPtPurpose> queryRefComPtPurposeFindAll();
//
//    void removeRefComPtPurpose(RefComPtPurpose refComPtPurpose);
//
//    List<RefComPtType> queryRefComPtTypeFindAll();
//
//    void removeRefComPtType(RefComPtType refComPtType);
//
//    List<RefComTreatment> queryRefComTreatmentFindAll();
//
//    void removeRefComTreatment(RefComTreatment refComTreatment);
//
//    List<RefContainerType> queryRefContainerTypeFindAll();
//
//    void removeRefContainerType(RefContainerType refContainerType);
//
//    List<RefContractType> queryRefContractTypeFindAll();
//
//    void removeRefContractType(RefContractType refContractType);
//
//    List<RefCountry> queryRefCountryFindAll();
//
//    void removeRefCountry(RefCountry refCountry);
//
//    List<RefCurrency> queryRefCurrencyFindAll();
//
//    void removeRefCurrency(RefCurrency refCurrency);
//
//    List<RefCustomsProcCode> queryRefCustomsProcCodeFindAll();
//
//    void removeRefCustomsProcCode(RefCustomsProcCode refCustomsProcCode);
//
//    List<RefCustLocation> queryRefCustLocationFindAll();
//
//    void removeRefCustLocation(RefCustLocation refCustLocation);
//
//    List<RefCustTranMode> queryRefCustTranModeFindAll();
//    
//    RefCustTranMode queryRefCustTranModeFindByCode(String code);
//    
//    void removeRefCustTranMode(RefCustTranMode refCustTranMode);
//
//    List<RefCustTranType> queryRefCustTranTypeFindAll();
//
//    void removeRefCustTranType(RefCustTranType refCustTranType);
//
//    List<RefCustType> queryRefCustTypeFindAll();
//
//    void removeRefCustType(RefCustType refCustType);
//
//    List<RefDefermentPeriod> queryRefDefermentPeriodFindAll();
//
//    void removeRefDefermentPeriod(RefDefermentPeriod refDefermentPeriod);
//
//    List<RefDeliveryTerms> queryRefDeliveryTermsFindAll();
//
//    void removeRefDeliveryTerms(RefDeliveryTerms refDeliveryTerms);
//
//    List<RefDocEvent> queryRefDocEventFindAll();
//
//    void removeRefDocEvent(RefDocEvent refDocEvent);
//
//    List<RefDocStatus> queryRefDocStatusFindAll();
//
//    void removeRefDocStatus(RefDocStatus refDocStatus);
//
//    List<RefDocType> queryRefDocTypeFindAll();
//
//    void removeRefDocType(RefDocType refDocType);
//
//    List<RefEmailFormatType> queryRefEmailFormatTypeFindAll();
//
//    void removeRefEmailFormatType(RefEmailFormatType refEmailFormatType);
//
//    List<RefEntityType> queryRefEntityTypeFindAll();
//
//    void removeRefEntityType(RefEntityType refEntityType);
//
//    List<RefEntRoleType> queryRefEntRoleTypeFindAll();
//
//    void removeRefEntRoleType(RefEntRoleType refEntRoleType);
//
//    List<RefEntSiteType> queryRefEntSiteTypeFindAll();
//
//    void removeRefEntSiteType(RefEntSiteType refEntSiteType);
//
//    List<RefGuaranteeType> queryRefGuaranteeTypeFindAll();
//
//    void removeRefGuaranteeType(RefGuaranteeType refGuaranteeType);
//
//    List<RefIdentifierType> queryRefIdentifierTypeFindAll();
//
//    void removeRefIdentifierType(RefIdentifierType refIdentifierType);
//
//    List<RefInspOutcome> queryRefInspOutcomeFindAll();
//
//    void removeRefInspOutcome(RefInspOutcome refInspOutcome);
//
//    List<RefInstOutcome> queryRefInstOutcomeFindAll();
//
//    void removeRefInstOutcome(RefInstOutcome refInstOutcome);
//
//    List<RefInterestRate> queryRefInterestRateFindAll();
//
//    void removeRefInterestRate(RefInterestRate refInterestRate);
//
//    List<RefLegalStatusType> queryRefLegalStatusTypeFindAll();
//
//    void removeRefLegalStatusType(RefLegalStatusType refLegalStatusType);
//
//    List<RefMaritalStatus> queryRefMaritalStatusFindAll();
//
//    void removeRefMaritalStatus(RefMaritalStatus refMaritalStatus);
//
//    List<RefMeasurement> queryRefMeasurementFindAll();
//
//    void removeRefMeasurement(RefMeasurement refMeasurement);
//
//    List<RefOffenceOutcome> queryRefOffenceOutcomeFindAll();
//
//    void removeRefOffenceOutcome(RefOffenceOutcome refOffenceOutcome);
//
//    List<RefOffice> queryRefOfficeFindAll();
//
//    void removeRefOffice(RefOffice refOffice);
//
//    List<RefPaymentCard> queryRefPaymentCardFindAll();
//
//    void removeRefPaymentCard(RefPaymentCard refPaymentCard);
//
//    List<RefPaymentMethod> queryRefPaymentMethodFindAll();
//
//    void removeRefPaymentMethod(RefPaymentMethod refPaymentMethod);
//
//    List<RefPhoneLineType> queryRefPhoneLineTypeFindAll();
//
//    void removeRefPhoneLineType(RefPhoneLineType refPhoneLineType);
//
//    List<RefPort> queryRefPortFindAll();
//
//    void removeRefPort(RefPort refPort);
//
//    List<RefReason> queryRefReasonFindAll();
//
//    void removeRefReason(RefReason refReason);
//
//    List<RefCustomsRegime> queryRefCustomsRegimeFindAll();
//
//    void removeRefCustomsRegime(RefCustomsRegime refRegime);
//
//    List<RefRegion> queryRefRegionFindAll();
//
//    void removeRefRegion(RefRegion refRegion);
//
//    List<RefRelationshipType> queryRefRelationshipTypeFindAll();
//
//    void removeRefRelationshipType(RefRelationshipType refRelationshipType);
//
//    List<RefRevAccRoleType> queryRefRevAccRoleTypeFindAll();
//
//    void removeRefRevAccRoleType(RefRevAccRoleType refRevAccRoleType);
//
//    List<RefRevMode> queryRefRevModeFindAll();
//
//    void removeRefRevMode(RefRevMode refRevMode);
//
//    List<RefRevType> queryRefRevTypeFindAll();
//    
//    public RefRevType queryRefRevTypeFindByCode(String code);
//    
//    public RefRevMode queryRefRevModeFindByCode(String code);
//
//    void removeRefRevType(RefRevType refRevType);
//
//    List<RefStagger> queryRefStaggerFindAll();
//
//    void removeRefStagger(RefStagger refStagger);
//
//    List<RefStaggerSub> queryRefStaggerSubFindAll();
//
//    void removeRefStaggerSub(RefStaggerSub refStaggerSub);
//
//    List<RefStatus> queryRefStatusFindAll();
//
//    void removeRefStatus(RefStatus refStatus);
//    
//    List<RefTimezones> queryRefTimezonesFindAll();
//
//    void removeRefTimezones(RefTimezones refTimezones);
//
//    List<RefTitle> queryRefTitleFindAll();
//
//    void removeRefTitle(RefTitle refTitle);
//    
//    List<RefTransactionClass> queryRefTransactionClassFindAll();
//
//    void removeRefTransactionClass(RefTransactionClass refTransactionClass);
//
//    List<RefTransactionType> queryRefTransactionTypeFindAll();
//
//    void removeRefTransactionType(RefTransactionType refTransactionType);
//
//    List<RefTranLinkType> queryRefTranLinkTypeFindAll();
//
//    void removeRefTranLinkType(RefTranLinkType refTranLinkType);
//
//    List<RefValuationMethod> queryRefValuationMethodFindAll();
//
//    void removeRefValuationMethod(RefValuationMethod refValuationMethod);
//
//    List<RefVehFuelType> queryRefVehFuelTypeFindAll();
//
//    void removeRefVehFuelType(RefVehFuelType refVehFuelType);
//
//    List<RefVehType> queryRefVehTypeFindAll();
//
//    void removeRefVehType(RefVehType refVehType);
//
//    List<RefVehUnit> queryRefVehUnitFindAll();
//
//    void removeRefVehUnit(RefVehUnit refVehUnit);
//
//    List<RefVisit> queryRefVisitFindAll();
//
//    void removeRefVisit(RefVisit refVisit);
//
//    List<RefWebType> queryRefWebTypeFindAll();
//
//    void removeRefWebType(RefWebType refWebType);
//    
//    List<RefCustCalcType> queryRefCustCalcTypeFindAll();
//
//    List<RefCustTaxType> queryRefCustTaxTypeFindAll();
//    
//    List<RefComCodeCategory> queryFindByComCode(Object entity, Object o);
//
//    RefCustTaxBand getTaxRates(String taxType, String taxBand);
//    
//    String getTaxBand(String commodity, String taxType);
//     
    public String getSystemParameter(String code);
//    
//    boolean updateSystemParameter(String code, String newValue);
//    
//    public String getCommodityCategory(String comCode);
//    
//    public List<PeriodDetail> findAllPeriods(String regimeType);
//    
//    public RefTransactionType findTransactionTypeByDocumentAndTaxType(String documentType, String taxType);
//
//    public RefCountry findCountryByPort(String portCode);
//    
//    public RefOperandType getOperandTypeByCode(String code);
//    
//    public RefCustTaxType getRefCustTaxType(String code);
//    
    public String getSystemParameterReport(String code);
//
//    public RefReportPrint getReportPrint(ReportsInputType reportInput);
//    
//    public String findAppIndicatorCodeByAppType(String appTypeCode);
//
//    public RefDocType findDocumentReport(String code);
//    
//    public boolean checkCommercialAccountByCode(String code);
//    
//    public List<RefDayOfWeek> queryRefDayOfWeekFindAll();
//    
//    public List<RefMonthOfYear> queryRefMonthOfYearFindAll();
//
//    public <T extends BaseModelObject> T  saveOrUpdate(T entity, String action) throws TripsDuplicateFoundException;
//    
    public DataSource getDataSource();

//    public List<String> findOfficeForWorkstation(String workstationName);
//
//    public List<String> findUserOffice(String username);
//
//    public RefOffStaff findOfficeStaff(String username);
//
//    public RefTaskRole findRefTaskRoleByAction(String requestAction);
//
//    public List<RefTaskRole> findAllTaskRoles();
//
//    public Serializable refresh(Serializable entitySaved);
//
//    public List<CodeAndDescription> findAllColumnsForTable(String tableName);
//
//    public FlexibleDBTableInputType getMetaDataForTable(String tableName) ;
//    
//    public String createTable(FlexibleDBTableInputType flexibleDBTableInputType);
//
    public boolean isColumnThePrimaryKeyForTable(String tableName, String column);

    public String getDTypeForRecord(String tableName, String idColName, String dtypeColName, Long id);

//    
//    public String formatTaxIdentificationNumber(String taxIdentificationNumber, String patternDigitCount, String patternSeparator, Integer numOfChars, String tinBranchSeparator);
//
//    public String findLegalStatus(Long entityId);
//
//    public boolean hasReqSupportingDocuments(AttachmentType[] attachements, 
//                                          String formType) ;
//                                          
//    public String getListOfReqSupportingDocuments(AttachmentType[] attachements, 
//                                            String formType) ;
//
    public boolean hasAnotherSession(String userId, String ipaddress);

    public SysUserLogin getOtherSession(String userId, String ipaddress) ;

    public void logEndUserSession(String sessionID, long lastAccessedTime);

    public boolean isSessionTerminated(String string, String ipAddress) ;

    public void logNewUserSession(String sessionId, long createdTime,String userId,String ipAddress);

    public void endSessionAtMachine(String ipAddress, String userId);
    
    int deleteOldUserSession(Date dateBefore);
//
//    public String getJobParameter(String parameterName);
//    public String getDocTypeForReturnType(String returnType);
//    public String getRefRevModeByDocType(String docType);
//    public String getReturnTypeByDocType(String docType);
//    
//    public RefSubTaxCategory getSubTaxCategoryCode(String description, String revTypeCode, Long level);
//    
//    public RefSubTaxCategory getSubTaxCategoryCodeByRevType(String code);
//    
//    public RefReturnType getReturnTypeByDescription(String description);
//    
//    public RefReturnType getReturnTypeByCode(String code);
//    
//    public String getResidentIndicatorByTin(String tin);
//    
//    public RefDocTypeTaxTypeRel findRevenueTypeByDocType(String docType);
//    
//    public String getRefRevTypeByDocType(String docType);    
//    public RefReturnType getRefReturnTypeByDocType(String docType);
//    public List<RefReturnType> findRegReturnTypesByRevenueType(Long entityId, String revenueType);
}
