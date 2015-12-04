package com.technobrain.trips.core.configuration.delegate;

//import com.crownagents.trips.account.config.model.CfgAllocationRuleConfig;
import com.technobrain.trips.core.delegate.BusinessDelegate;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;


public class ConfigurationDelegate  extends BusinessDelegate{

    public ConfigurationDelegate() {
    }
    
//    public PandIConfigurationInputType loadPAndIConfigurationInputType(Long id) {
//        PandIConfigurationInputType pandIConfig = null;
//        pandIConfig = getConfigurationService().getPAndIConfigurationInputType(id);
//        return pandIConfig;
//    }          
//    
//    public Long savePAndIConfiguration(PandIConfigurationInputType pandIConfig){
//        return getConfigurationService().savePAndIConfiguration(pandIConfig);
//    }    
//
//    public List<RefCfgRegime> findProcessConfig(String processName, String docType) {
//        return getConfigurationService().findProcessConfig(processName, docType);
//    }
//    
//    public List<RefCfgRegime> findProcessConfig(String processName) {
//        return getConfigurationService().findProcessConfig(processName);
//    }
//
//    public List<RefCfgRegime> findProcessConfig(String processName, String regimeCode, String decisionName, String status) {
//        return getConfigurationService().findProcessConfig(processName, regimeCode, decisionName, status);
//    }
//    
//    
//    public CalculatePenaltyInterestOutputType calculatePenaltyAndInterest(CalculatePenaltyInterestInputType calculatePenaltyInterestInputType){
//        return getConfigurationService().calculatePenaltyAndInterest(calculatePenaltyInterestInputType);
//    }    
//        
//        
//    public RegimeConfigurationInputType loadRegimeConfigurationInputType(String code) {
//        RegimeConfigurationInputType regimeConfig = null;
//        regimeConfig = getConfigurationService().getRegimeConfigurationInputType(code);
//        return regimeConfig;
//    }          
//    
//    public String saveRegimeConfiguration(RegimeConfigurationInputType regimeConfig){
//        return getConfigurationService().saveRegimeConfiguration(regimeConfig);
//    }    
//    public RefConfigSet saveOrUpdateRefConfigSet(RefConfigSet refConfigSet){
//        return getConfigurationSetService().saveOrUpdateRefConfigSet(refConfigSet);
//    }

//    public ConfigSetMode findConfigSetMode(String configSetCode, String modeCode) {
//        return getConfigurationSetService().findConfigSetMode(configSetCode, modeCode);
//    }

    /**
     * This method will load full data from ENT_ALLOCATION_CONFIG table.
     * @return
     */
//    public List<AllocationConfigInputType> findAllAllocConfigs() {
//        List<AllocationConfigInputType> allocationConfigInputType = getConfigurationService().queryCfgAllocationConfig();
//        return allocationConfigInputType;
//    }
/*
    public void removeAllocationConfig(CfgAllocationRuleConfig cfgAllocationRuleConfig) {
        getConfigurationService().removeCfgAllocationRuleConfig(cfgAllocationRuleConfig);
    }    
*/
//    public void saveAllocationConfigs(AllocationConfigInputType[] allocationConfigInputTypes) {
//        if(allocationConfigInputTypes!=null && allocationConfigInputTypes.length>0) {
//            for(int i=0; i<allocationConfigInputTypes.length; i++) {
//                AllocationConfigInputType allocConfigInputType = allocationConfigInputTypes[i];
//                getConfigurationService().saveAllocationConfiguration(allocConfigInputType);
//            }
//        }
//    }
//    public List<ReportDetails> loadReportDetails(Long id){
//        return getConfigurationService().getReportDetails(id);
//    }
//    
//    public String SaveOrUpdateReportDetails(ReportDetails reportDetails){
//        return getConfigurationService().SaveOrUpdateReportDetails(reportDetails);
//    }
    
//    public List<ReportDirectoryItem> loadReportsFromJasperServer(String absolutePath){
//
//        try {
//            return getReportingService().loadReportsFromJasperServer(absolutePath);
//        } catch (Exception e) {
//            // TODO
//        }
//        return null;
//    }
    
//    public List<ParameterNameValue> loadReportParamsFromJasperServer(String absolutePath){
//        try {
//            return getReportingService().loadReportParamsFromJasperServer(absolutePath);
//        } catch (ReportException e) {
//            // TODO
//        }
//        return null;
//    }
    
//    public List<ReportDetails> loadAllReportDetails(){
//        try {
//            return getReportingService().loadAllReportDetails();
//        } catch (ReportException e) {
//            // TODO
//        }
//        return null;
//    }
//    
//    public List<ReportParameters> loadReportParameters(Long reportDetailsId){
//        try {
//            return getReportingService().loadReportParameters(reportDetailsId);
//        } catch (ReportException e) {
//            // TODO
//        }
//        return null;
//    }
//    
//    public List<String> getUserGroupsForLoggedInUser(String userName){
//        return getConfigurationService().getUserGroupsForLoggedInUser(userName);
//    }
//
//    public ReportDetails loadReportDetails(String reportName) {
//        
//        return getReportingService().loadReportDetails(reportName);        
//    }
//    
//    public SystemParameters findSysParameters(String primaryKey){
//        SystemParameters systemParameters = getConfigurationService().findSysParameters(primaryKey);
//        return systemParameters;
//    }
//    
//    public SystemParameters saveOrUpdateSysParameters(SystemParameters sysParameters){
//        SystemParameters systemParameters = getConfigurationService().saveOrUpdateSysParameters(sysParameters);
//        return systemParameters;
//    }
//    
//    public TreasuryBalance findTreasuryBalance(){
//        return getConfigurationService().findTreasuryBalance();
//    }
//    
//    public TreasuryBalance saveOrUpdateTreasuryBalance(TreasuryBalance treasuryBalance){
//        return getConfigurationService().saveOrUpdateTreasuryBalance(treasuryBalance);
//    }
//    
//    public BigDecimal findBankRateByBankRateType(String bankRateType){
//        BigDecimal rate = null;
//        List<RmtBankRate> rmtBankRateList = getConfigurationService().findBankRateByBankRateType(bankRateType);
//        if(rmtBankRateList != null && rmtBankRateList.size()>0){
//            rate = rmtBankRateList.get(0).getBankRate();
//        }
//        
//        return rate;
//    }
//    
//    public RefRevType processRefRevenueType(RefRevType refRevType) {
//        RefRevType revType = getConfigurationService().saveRefRevType(refRevType);
//        return revType;
//    }
//
//    public void saveorUpdateProcessDecisions(RefCfgRegime cfgRegime){
//        getConfigurationService().saveOrUpdate(cfgRegime);
//    }
//    
//    public RefDocType processRefDocTypeConfiguration(RefDocType refDocType) {
//        RefDocType refDocTypeResp = getConfigurationService().saveRefDocType(refDocType);
//        return refDocTypeResp;
//    }
//    
//    public RefDocTypeReturnTypeRel processRefDocTypeRetTypeRelConfiguration(RefDocTypeReturnTypeRel refDocTypeReturnTypeRel){
//        RefDocTypeReturnTypeRel refDocTypeReturnTypeRelResp = getConfigurationService().saveRefDocTypeRetTypeRelConfiguration(refDocTypeReturnTypeRel);
//        return refDocTypeReturnTypeRelResp;
//    }
//    
//    public List<RefDocType> findAllDocTypeByPrefix(String prefix){
//        List<RefDocType> refDocTypeList =  getConfigurationService().findAllDocTypeByPrefix(prefix);
//        return refDocTypeList;
//    }
    
//    public List<SelectItem> findAllFlexibleFormByDocumentType(String documentType){
//        List<FlexibleForm> flexibleFormList = getFlexibleFormsService().
//            findAllFlexibleFormByDocumentType(documentType);
//        List<SelectItem> formList = new ArrayList<SelectItem>();
//        for(FlexibleForm ff : flexibleFormList) {            
//            formList.add(new SelectItem(ff.getFormName(), DateHelper.getDate(new Date(ff.getValidFrom().getTime()),Constants.DEFAULT_DATE_FORMAT) 
//                        + " - " + DateHelper.getDate(new Date(ff.getValidTo().getTime()),Constants.DEFAULT_DATE_FORMAT)));                        
//        }
//        return formList;        
//    }
//    
//    public List<FlexibleFormFieldSubTaxType> findAllFlexFormFieldSubTypeByFormNameDocType(String formName, String documentType){
//        List<FlexibleFormFieldSubTaxType> flexibleFormFieldSubTaxTypeList = 
//            getFlexibleFormsService().findAllFlexibleFormFieldSubTaxTypeByFormNameDocType(formName, documentType);        
//            
//        return flexibleFormFieldSubTaxTypeList;     
//    }
//    
//    public List<SelectItem> findAllFlexFieldsByUsageTypeInFormName(String usageType, String formName){
//        List<FlexibleFormField> flexibleFormFieldList = 
//            getFlexibleFormsService().findAllFlexFieldsByUsageTypeInFormName(usageType, formName);        
//        
//        List<SelectItem> fieldList = new ArrayList<SelectItem>();
//        for(FlexibleFormField ff : flexibleFormFieldList) {            
//            fieldList.add(new SelectItem(ff.getFieldName(), ff.getFieldName()));                        
//        }    
//        return fieldList; 
//    }

//    public String saveFlexibleFieldSubTaxType(List<FlexibleFormFieldSubTaxType> flexibleFieldSubTaxTypeList){
//        return getConfigurationService().saveFlexibleFieldSubTaxType(flexibleFieldSubTaxTypeList);
//    }
    
}
