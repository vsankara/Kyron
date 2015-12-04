package com.technobrain.trips.core.backing;


import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;

import java.util.HashMap;


/**
 * ? Crown Agents 2007 
 * <p>
 * Stores the constants for a adf process scope
 * request.
 * @since $Date: 2/16/2010 7:13:48 PM$
 * @version $Revision: 175$
 * 
 * $Log[1]:
 *  146  TRIPS2 etis.bir.gov.ph1.143.1.1   9/30/2009 10:45:24 PM  Vythilingam
 *       Pirabaharan 1st cut of batch payment and batch payment search screens
 *       of CRR module.
 */
public class BackingProcessScopeConstants {

    public BackingProcessScopeConstants() {
    }

    public String getViewMode() {
        return Constants.Modes.VIEW;
    }

    public String getEditMode() {
        return Constants.Modes.EDIT;
    }

    public String getAddMode() {
        return Constants.Modes.ADD;
    }


    public String getCancelMode() {
        return Constants.Modes.CANCEL_TRANSACTION;
    }

    public String getAddDialogMode() {
        return "addDialog";
    }


    public String getAmendMode() {
        return Constants.Modes.AMEND;
    }

    public String getAddToListMode() {
        return Constants.Modes.ADDTOLIST;
    }

    public String getWithdrawMode() {
        return "WITHDR";
    }

    public String getBasicConfig() {
        return Constants.GuiConfig.CRUD_CONFIG;
    }

    public String getWithinCaseTabs() {
        return "withinCaseTabs";
    }

    public String getRegisterRegimeConfig() {
        return "REGREGIME";
    }

    public String getRegisterBranchConfig() {
        return Constants.GuiConfig.REGISTER_BRANCH_CONFIG;
    }

    public String getBatchConfig() {
        return "BATCH";
    }

    public String getReversePayConfig() {
        return "REVERSE_PAY";
    }

    public String getRegisterFacilityConfig() {
        return Constants.GuiConfig.REGISTER_FACILITY_CONFIG;
    }

    public String getRenewBusinessRegistrationConfig() {
        return Constants.GuiConfig.REG_REN_BUSS_CONFIG;
    }

    public String getBackDateRegistrationConfig() {
        return Constants.GuiConfig.BACK_DATE_REG_CONFIG;
    }

    public String getBackDateLodgementConfig() {
        return Constants.GuiConfig.BACK_DATE_LODGE;
    }

    public String getFindActiveLogSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ACTIVITY_LOG;
    }

    public String getFindOfficeInCountrySearchKey() {
        return Constants.SEARCH_KEYS.FIND_OFFICE_IN_COUNTRY;
    }

    public String getFindEntityOrgSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_ORG;
    }

    public String getFindEntitySearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY;
    }

    public String getFindEntityTinSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_TIN;
    }

    public String getFindManifestSearchKey() {
        return Constants.SEARCH_KEYS.FIND_MANIFEST_SEARCH;
    }

    public String getFindTransactionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION;
    }

    public String getFindTransactionAllocationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION_FOR_PAYMENT_ALLOCATION;
    }

    public String getFindRevLedTransactionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION;
    }

    public String getFindDeclarationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DECLARATION;
    }

    public String getFindDeclarationsAwaitingPaymentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DECLARATIONS_AWAITING_PAYMENT;
    }

    public String getFindEntContainerSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_CONTAINER;
    }

    public String getFindRegimeAccountSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REGIME_ACCOUNT;
    }

    public String getFindCommoditySearchKey() {
        return Constants.SEARCH_KEYS.FIND_COMMODITY;
    }

    public String getFindTransactionTypeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION_TYPE;
    }

    public String getFindCustLocationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CUST_LOCATION;
    }

    public String getFindPaymentReversalSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PAYMENT_REVERSAL;
    }

    public String getFindPaymentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PAYMENT;
    }

    public String getFindResolvePaymentSearchKey() {
        return "FIND_SUSPEND_PAYMENT";
    }

    public String getFindWarehouse() {
        return Constants.SEARCH_KEYS.FIND_WAREHOUSE;
    }

    public String getFindDefermentCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DEFERMENT_CASE;
    }

    public String getFindTaxAccountingSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAS;
    }

    public String getFindTaxAccountingApprovalSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAS_APPROVAL;
    }

    public String getFindTaxLedgerInquirySearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXPAYER_LEDGER;
    }

    public String getFindTaxTranferPaymentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSFER_PAYMENT_CREDIT;
    }

    public String getFindReturnPeriodSummarySearchKey() {
        return Constants.SEARCH_KEYS.FIND_RETURN_PERIOD_SUMMARY;
    }

    public String getFindTaxYearSummarySearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAX_YEAR_SUMMARY;
    }


    /*
     * Navigations
     */


    public String getFromGenericSearchToParentJourneyDetails() {
        return "FromGenericSearchToParentJourneyDetails";
    }

    public String getFromGenericSearchToAppConfiguration() {
        return "FromGenericSearchToAppConfiguration";
    }

    public String getFromGenericSearchToApplication() {
        return "FromGenericSearchToApplication";
    }

    public String getFromGenericSearchToCaseSelection() {
        return "FromGenericSearchToCaseSelection";
    }

    public String getFromGenericSearchToCaseManagementDetails() {
        return "FromGenericSearchToCaseManagementDetails";
    }

    public String getFromGenericSearchToDocumentManagementDetails() {
        return "FromGenericSearchToDocumentManagementDetails";
    }

    public String getFromGenericSearchToBasicCaseDetails() {
        return "FromGenericSearchToBasicCaseDetails";
    }

    public String getFromGenericSearchToDeregistration() {
        return "FromGenericSearchToDeregistration";
    }

    public String getFromGenericSearchToReregisterRegime() {
        return "FromGenericSearchToReregisterRegime";
    }

    public String getFromGenericSearchToReactivateRegime() {
        return "FromGenericSearchToReactivateRegime";
    }

    public String getFromGenericSearchToSuspendRegime() {
        return "FromGenericSearchToSuspendRegime";
    }

    public String getFromGenericSearchToIndividualSummaryDetails() {
        return "FromGenericSearchToIndividualSummaryDetails";
    }

    public String getFromGenericSearchToOrganisationSummaryDetails() {
        return "FromGenericSearchToOrganisationSummaryDetails";
    }

    public String getFromGenericSearchToManifestDetails() {
        return "FromGenericSearchToManifestDetails";
    }

    public String getFromGenericSearchToDefaultNav() {
        return "none";
    }

    public String getFromGenericSearchToDocumentJobProcessor() {
        return "FromGenericSearchToDocumentJobProcessor";
    }


    public String getFromGenericSearchToTaxPayerAccountAdjustment() {
        return "FromGenericSearchToTaxPayerAccountingAdjustment";
    }

    public String getFromGenericSearchToTaxPayerTransferPayment() {
        return "FromGenericSearchToTaxPayerTransferPayment";
    }

    public String getFromGenericSearchToTaxPayerItemAdjustment() {
        return "FromGenericSearchToTaxPayerAccountingAdjustment";
    }

    public String getFromGenericSearchToTaxPayerLedgerInquiry() {
        return "FromGenericSearchToTaxPayerLedgerInquiry";
    }

    public String getFromGenericSearchToTaxPayerAccountEnquiry() {
        return "FromGenericSearchToTaxPayerAccountEnquiry";
    }

    public String getFromGenericSearchToTaxPayerReturnPeriodSummary() {
        return "FromGenericSearchToTaxPayerReturnPeriodSummary";
    }

    public String getFromGenericSearchToTaxPayerTaxYearSummary() {
        return "FromGenericSearchToTaxPayerTaxYearSummary";
    }
    
    public String getFromOnAccountPaymentToPaymentDetails() {
        return "FromOnAccountPaymentToPaymentDetails";
    }
    

    public String getFromGenericSearchToPaymentSummary() {
        return "FromGenericSearchToPaymentSummary";
    }
    public String getFromPaymentSummaryToPaymentDetails() {
        return "FromPaymentSummaryToPaymentDetails";
    }
    public String getFromPaymentDetailsToOnAccountPayment() {
        return "FromPaymentDetailsToOnAccountPayment";
    }
    

    public String getFromGenericSearchToPAYEMontlyReturn() {
        return "FromGenericSearchToPAYEMontlyReturn";
    }

    public String getFromGenericSearchToPAYEMonthlyEmployee() {
        return "FromGenericSearchToPAYEMonthlyEmployee";
    }


    public String getFromPaymentDetailsToFindDeclaration() {
        return "FromPaymentDetailsToFindDeclaration";
    }

    public String getFromPaymentDetailsToFindTransaction() {
        return "FromPaymentDetailsToFindTransaction";
    }

    public String getFromGenericSearchToRelationship() {
        return "FromGenericSearchToRelationship";
    }

    public String getFromGenericSearchToAssociations() {
        return "FromGenericSearchToAssociations";
    }

    public String getFromGenericSearchToDirectors() {
        return "FromGenericSearchToDirectors";
    }

    public String getFromGenericSearchToContacts() {
        return "FromGenericSearchToContacts";
    }

    public String getFromGenericSearchToBond() {
        return "FromGenericSearchToBond";
    }

    public String getFromGenericSearchToDeclarationDetails() {
        return "FromGenericSearchToDeclarationDetails";
    }

    public String getFromTransactionSearchToRevenueDeferment() {
        return "FromTransactionSearchToRevenueDeferment";
    }


    public String getFromGenericSearchToOffenceDetails() {
        return "FromGenericSearchToOffenceDetails";
    }

    public String getFromGenericSearchToGoodsClearance() {
        return "FromGenericSearchToGoodsClearance";
    }

    public String getFromGenericSearchToCITReturn() {
        return "FromGenericSearchToCITReturn";
    }

    public String getFromGenericSearchToExciseReturn() {
        return "FromGenericSearchToExciseReturn";
    }

    public String getFromGenericSearchToFOF() {
        return "FromGenericSearchToFOF";
    }

    public String getFromGenericSearchToPAYEReturn() {
        return "FromGenericSearchToPAYEReturn";
    }

    public String getFromGenericSearchToVATReturn() {
        return "FromGenericSearchToVATReturn";
    }

    public String getFromGenericSearchToWHTReturn() {
        return "FromGenericSearchToWHTReturn";
    }

    public String getFromGenericSearchToFBTReturn() {
        return "FromGenericSearchToFBTReturn";
    }

    public String getFromGenericSearchToIITReturn() {
        return "FromGenericSearchToIITReturn";
    }

    public String getFromGenericSearchToItemDetails() {
        return "FromGenericSearchToItemDetails";
    }

    public String getFromGenericSearchToGoodsDetails() {
        return "FromGenericSearchToGoodsDetail";
    }

    public String getFromGenericSearchToFindInspection() {
        return "FromGenericSearchToFindInspection";
    }

    public String getFromFindDeclarationToAmountAllocation() {
        return "dialog:FromFindDeclarationToAmountAllocation";
    }

    public String getFromFindTransactionToAmountAllocation() {
        return "dialog:FromFindTransactionToAmountAllocation";
    }

    public String getFromGenericSearchToFindRefundDetails() {
        return "FromGenericSearchToFindRefundDetails";
    }

    public String getFromGenericSearchToFindRefundInquiryDetails() {
        return "FromGenericSearchToFindRefundInquiryDetails";
    }

    public String getFromGenericSearchToTaskHandler() {
        return "FromGenericSearchToTaskHandler";
    }

    public String getFromGenericSearchToEnterRefundClaimsDetails() {
        return "FromGenericSearchToEnterRefundClaimsDetails";
    }

    public String getFromGenericSearchToPaymentDetails() {
        return "FromGenericSearchToPaymentDetails";
    }

    public String getFromGenericSearchTempIndex() {
        return "FromGenericSearchTempIndex";
    }

    public String getFromGenericSearchRegistrationRegimeMenu() {
        return "FromGenericSearchRegistrationRegimeMenu";
    }

    public String getFromGenericSearchToRevenue() {
        return "FromGenericSearchToRevenue";
    }

    public String getFromGenericSearchToCustomsDeclaration() {
        return "FromGenericSearchToCustomsDeclaration";
    }

    public String getFromGenericSearchToCustomsControl() {
        return "FromGenericSearchToCustomsControl";
    }

    public String getFromGenericSearchToDeclarationWithdraw() {
        return "FromGenericSearchToDeclarationWithdraw";
    }

    public String getFromGenericSearchToTaxReturns() {
        return "FromGenericSearchToTaxReturns";
    }

    public String getFromGenericSearchToAccountEnquiry() {
        return "FromGenericSearchToAccountEnquiry";
    }

    public String getFromAccountEnquiryToPaymentSummary() {
        return "FromAccountEnquiryToPaymentSummary";
    }

    public String getFromPaymentSummaryToAccountEnquiry() {
        return "FromPaymentSummaryToAccountEnquiry";
    }
    
       
    public String getFromTaxReturnToAccountEnquiry() {
        return "FromTaxReturnToAccountEnquiry";
    }

    public String getFromGenericSearchToFindVisitReport() {
        return "FromGenericSearchToFindVisitReport";
    }

    public String getFromGenericSearchToWelcome() {
        return "FromGenericSearchToWelcome";
    }

    public String getFromIndividualSummaryDetailsToTaskDetails() {
        return "FromIndividualSummaryDetailsToTaskDetails";
    }

    public String getFromOrganisationSummaryDetailsToTaskDetails() {
        return "FromOrganisationSummaryDetailsToTaskDetails";
    }

    public String getFromGenericSearchToTableManagement() {
        return "FromGenericSearchToTableManagement";
    }

    public String getFromGenericSearchToObjectionsAndAppeals() {
        return "FromGenericSearchToObjectionsAndAppeals";
    }

    public String getFromGenericSearchToUpdateRiskProfile() {
        return "FromGenericSearchToUpdateRiskProfile";
    }

    public String getFindAppConfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_APP_CONFIGURATION;
    }

    public String getFindApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_APPLICATION;
    }

    public String getFindViewApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_VIEW_APPLICATION;
    }

    public String getFindAuthorizeApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_AUTHORIZE_APPLICATION;
    }

    public String getFindRenewApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RENEW_APPLICATION;
    }

    public String getFindCancelApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CANCEL_APPLICATION;
    }

    public String getFindExpiredApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_EXPIRED_APPLICATION;
    }

    public String getFindSuspicionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SUSPICION;
    }

    public String getFromGenericSearchToUpdateIntelligenceInfo() {
        return "FromGenericSearchToUpdateIntelligenceInfo";
    }

    public String getFindSuspectSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SUSPECT;
    }

    public String getFindIntelSpotlightSearchKey() {
        return Constants.SEARCH_KEYS.INTEL_SPOTLIGHT;
    }

    public String getFromGenericSearchToUpdateSuspect() {
        return "FromGenericSearchToUpdateSuspect";
    }

    public String getFindInspectionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_INSPECTION;
    }

    public String getFromGenericSearchToUpdateInspection() {
        return "fromGenericSearchToUpdateInspection";
    }

    public String getFromGenericSearchToExemptionDetails() {
        return "fromGenericSearchToExemptionDetails";
    }

    public String getFromGenericSearchToCaseDocumentDetails() {
        return "";
    }

    public String getFindExemptionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_EXEMPTIONS;
    }


    public String getReturnToMainMenu() {
        return Constants.ReturnTo.MAIN_MENU;
    }

    public String getReturnToSuspicion() {
        return Constants.ReturnTo.SUSPICION_PAGE;
    }

    public String getReturnToRevenueDeferment() {
        return Constants.ReturnTo.REVENUE_DEFERMENT;
    }


    public String getFindRefundSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REFUND;
    }
    
    public String getFindRefundApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXPAYER_REFUND_APPLICATION;
    }

    public String getFindAuthorizedRefundForChequeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_AUTHORIZED_REFUND_FOR_CHEQUE;
    }

    public String getFindAuthorizedRefundForTRNSearchKey() {
        return Constants.SEARCH_KEYS.FIND_AUTHORIZED_REFUND_FOR_TRN;
    }

    public String getFindRefundClaimInquirySearchKey() {
        return Constants.SEARCH_KEYS.FIND_REFUND_INQUIRY;
    }

    public String getFindEntityForRefundSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_FOR_REFUND;
    }

    public String getFindCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CASE;
    }
    
    public String getFindDebtCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DEBT_CASE;
    }
    
    public String getFindAuditVisitCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_AUDIT_VISIT_CASE;
    }
    
    public String getFindObjectionAndAppealCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_OBJECTION_APPEAL_CASE;
    }
    
    public String getFindCaseDocSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CASE_DOC;
    }

    public String getFindRelatedDocumentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RELATED_DOCUMENT;
    }

    public String getFindObjectionsAndAppeals() {
        return Constants.SEARCH_KEYS.FIND_OBJECTIONS_APPEALS;
    }

    public String getFindProductSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PRODUCTS;
    }

    public String getAuditCase() {
        return Constants.CaseTypes.AUDIT_VISIT;
    }

    public String getObjectionAndAppealsCase() {
        return Constants.CaseTypes.OBJECTION_AND_APPEAL;
    }

    public String getFromGenericSearchToEnterRefundClaimDetails() {
        return "FromGenericSearchToEnterRefundClaimDetails";
    }

    public String getFromGenericSearchToProduct() {
        return "FromGenericSearchToProduct";
    }


    public String getFindRummageSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RUMMAGES;
    }

    public String getFromGenericSearchToRummage() {
        return "FromGenericSearchToRummage";
    }

    public String getAircraftSuspectType() {
        return Constants.SuspectType.AIRCRAFT;
    }

    public String getContainerSuspectType() {
        return Constants.SuspectType.CONTAINER;
    }

    public String getIndividualSuspectType() {
        return Constants.SuspectType.INDIVIDUAL;
    }

    public String getOrganizationSuspectType() {
        return Constants.SuspectType.ORGANIZATION;
    }

    public String getOtherSuspectType() {
        return Constants.SuspectType.OTHER;
    }

    public String getVehicleSuspectType() {
        return Constants.SuspectType.VEHICLE;
    }

    public String getVesselSuspectType() {
        return Constants.SuspectType.VESSEL;
    }

    public String getRunMethodForSuspectSelection() {
        return Constants.RunMethodsAfterGenericSearch.SUSPECT_SELECTION;
    }


    public String getFindSeizureSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SEIZURES;
    }

    public String getFromGenericSearchToSeizure() {
        return "FromGenericSearchToSeizure";
    }

    public String getFromProductSearchToSeizedGoods() {
        return "FromProductSearchToSeizedGoods";
    }

    public String getFindOffenceSearchKey() {
        return Constants.SEARCH_KEYS.FIND_OFFENCES;
    }

    public String getFromGenericSearchToOffence() {
        return "FromGenericSearchToOffence";
    }

    public String getFromSeizureToRummage() {
        return "FromSeizureToRummage";
    }

    public String getFromGenericSearchToSuspicion() {
        return "FromGenericSearchToSuspicion";
    }

    public String getReturnBackToSuspicion() {
        return "ReturnBackToSuspicion";
    }

    public String getRummagePageUrl() {
        return WebConstants.ViewId.RUMMAGE_VIEW_ID;
    }

    public String getOffencePageUrl() {
        return WebConstants.ViewId.OFFENCE_VIEW_ID;
    }

    public String getSeizurePageUrl() {
        return WebConstants.ViewId.SEIZURE_VIEW_ID;
    }

    public String getSuspicionPageUrl() {
        return WebConstants.ViewId.SUSPICION_VIEW_ID;
    }

    public String getFromGenericSearchToProductValuationDetails() {
        return "FromGenericSearchToProductValuationDetails";
    }

    public String getFromGenericSearchToFreightValuationDetails() {
        return "FromGenericSearchToFreightValuationDetails";
    }

    public String getFromGenericSearchToJourneyDetails() {
        return "FromGenericSearchToJourneyDetails";
    }

    public String getFindProductValuationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PRODUCT_VALUATION;
    }

    public String getFindFreightValuationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FREIGHT_VALUATION;
    }

    public String getFindFreightPriceSearchSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FREIGHTPRICESEARCHS;
    }

    public String getFromGenericSearchToFreightPriceSearch() {
        return "FromGenericSearchToFreightPriceSearch";
    }

    public String getFindProductCommoditySearchKey() {
        return Constants.SEARCH_KEYS.FIND_PRODUCT_COMMODITY;
    }

    public String getFindJourney() {
        return Constants.SEARCH_KEYS.FIND_JOURNEY;
    }

    public String getFindTransport() {
        return Constants.SEARCH_KEYS.FIND_TRANSPORT;
    }

    public String getFindDocumentJobsSearchKey() {
        return "FIND_DOCUMENT_JOBS";
    }

    public String getFindDocumentReprintJobsSearchKey() {
        return "FIND_DOCUMENT_REPRINT_JOBS";
    }

    public String getFindDocumentJobsByOfficeSearchKey() {
        return "FIND_DOCUMENT_JOBS_BY_OFFICE";
    }

    public String getFindDocumentReprintJobsByOfficeSearchKey() {
        return "FIND_DOCUMENT_REPRINT_JOBS_ANY_OFFICE";
    }


    public String getFindCarrierSearchKey() {
        return "FIND_CARRIER";
    }

    public String getFindPlaceOfEmbarkationSearchKey() {
        return "FIND_LOCATION_BY_COUNTRY";
    }

    public String getFindPointOfArrivalSearchKey() {
        return "FIND_LOCATION_BY_COUNTRY";
    }

    public String getFindPointOfDepartureSearchKey() {
        return "FIND_LOCATION_BY_COUNTRY";
    }

    public String getFromProductSearchToSuspectGoods() {
        return "FromProductSearchToSuspectGoods";
    }

    public String getFromIndividualSearchToSuspectIndividual() {
        return "FromIndividualSearchToSuspectIndividual";
    }

    public String getFromGenericSearchToAdditionalDocumentDetails() {
        return "FromGenericSearchToAdditionalDocumentDetails";
    }

    public String getFromGenericSearchToPreviousDocumentDetails() {
        return "FromGenericSearchToPreviousDocumentDetails";
    }

    public String getFindPackageSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PACKAGE;
    }

    public String getFindUsersSearchKey() {
        return Constants.SEARCH_KEYS.FIND_USERS;
    }

    public String getFromGenericSearchToDebtMgmtDetails() {
        return "FromGenericSearchToDebtMgmtDetails";
    }


    public String getSuspicionProxyCallBackHandler() {
        return "backingCustomsAuditInformation.handleReturnSuspicion";
    }

    public String getCaseAssignmentProxyCallBackHandler() {
        return "backingCaseAssignment.handleReturnCaseSave";
    }


    public String getSeizuresProxyCallBackHandler() {
        return "backingCustomsAuditInformation.handleReturnSeizures";
    }

    public String getFromGenericSearchToRouteInformation() {
        return "FromGenericSearchToRouteInformation";
    }

    public String getFromSuspectSearchToRummage() {
        return "FromSuspectSearchToRummage";
    }

    public String getFromSuspectSearchToOffence() {
        return "FromSuspectSearchToOffence";
    }

    public String getRummageProxyCallBackHandler() {
        return "backingCustomsAuditInformation.handleReturnRummage";
    }

    public String getCaseEventManagerReportDetailsProxyCallBackHandler() {
        return "backingCaseEventManager.doAction";
    }

    public String getFromOrganisationSearchToSuspectOrganisation() {
        return "FromOrganisationSearchToSuspectOrganisation";
    }


    public String getFromGenericSearchToContainerDetails() {
        return "FromGenericSearchToContainerDetails";
    }

    public String getFindProcedureSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PROCEDURE;
    }

    public String getFindContainerMeasurementsSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CONTAINER_MEASUREMENTS;
    }

    public String getFindContainerTypeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CONTAINER_TYPE;
    }

    public String getFromWelcomeToTransportSearch() {
        return "FromWelcomeToTransportSearch";
    }

    public String getFindPAndIConfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PANDICONFIGURATIONS;
    }

    public String getFromGenericSearchToPAndIConfiguration() {
        return "FromGenericSearchToPAndIConfiguration";
    }

    public String getFromGenericSearchToGuaranteeDetails() {
        return "FromGenericSearchToGuaranteeDetails";
    }

    public String getFindOfficeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_OFFICE;
    }

    public String getFromGenericSearchToOfficeMaintenance() {
        return "FromGenericSearchToOfficeMaintenance";
    }

    public String getFindPrinterSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PRINTER;
    }

    public String getFromGenericSearchToGuaranteeGoods() {
        return "FromGenericSearchToGuaranteeGoods";
    }

    public String getReportDetailsProxyCallBackHandler() {
        return "backingDebtMgmtSelection.handleReturnReport";
    }

    public String getDebtMgmtReportDetailsProxyCallBackHandler() {
        return "backingDebtMgmt.handleReturnReport";
    }

    public String getFindDocReportSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DOCREPORTS;
    }

    public String getFromGenericSearchToDocJobConfiguration() {
        return "FromGenericSearchToDocJobConfiguration";
    }

    public String getFindGuaranteeWithStatusNewSearchKey() {
        return Constants.SEARCH_KEYS.FIND_GUARANTEE_WITH_STATUS_NEW;
    }

    public String getFindRevenueDefermentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REVENUEDEFERMENTS;
    }

    public String getFromGenericSearchToRevenueDeferment() {
        return "FromGenericSearchToRevenueDeferment";
    }

    public String getFromWelcomeToTaxClearanceCertificate() {
        return "FromWelcomeToTaxClearanceCertificate";
    }

    public String getFromGenericSearchToTaxClearanceCertificate() {
        return "FromGenericSearchToTaxClearanceCertificate";
    }

    public String getFindTaxPayerTCCSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXPAYER_TCC;
    }

    public String getFromWelcomeToFindInstallmentAgreement() {
        return "FromWelcomeToFindInstallmentAgreement";
    }

    public String getFromGenericSearchToFindInstallmentAgreement() {
        return "FromGenericSearchToFindInstallmentAgreement";
    }

    public String getFindTransactionForInstallmentAgreement() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION_FOR_INSTALLMENT_AGREEMENT;
    }

    public String getFromWelcomeToAcquiredAssetsManagement() {
        return "FromWelcomeToAcquiredAssetsManagement";
    }

    public String getFromGenericSearchToAcquiredAssetsManagement() {
        return "FromGenericSearchToAcquiredAssetsManagement";
    }

    public String getFromAcquiredAssetsManagementToAcquiredAssetsDetails() {
        return "FromAcquiredAssetsManagementToAcquiredAssetsDetails";
    }

    public String getFindAcquiredAssetsSummarySearchKey() {
        return Constants.SEARCH_KEYS.ACQUIRED_ASSETS_SUMMARY;
    }

    public String getFindEntityForAcquiredAssetsSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_ACQUIRED_ASSETS;
    }

    public String getFindDocTypesSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DOCTYPES;
    }

    public String getFindComplianceconfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_COMPLIANCE_CONFIGURATION;
    }

    public String getFromGenericSearchToComplianceconfiguration() {
        return "FromGenericSearchToComplianceConfiguration";
    }

    public String getFindRefPeriodSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REF_PERIOD;
    }

    public String getFindCreditAllocationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CREDIT_ALLOCATION;
    }

    public String getFindCreditAllocationTransactionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CREDIT_ALLOCATION_TRANSACTIONS;
    }

    public String getFromGenericSearchToMaintainPeriod() {
        return "FromGenericSearchToMaintainPeriod";
    }

    public String getFromGenericSearchToCreditAllocation() {
        return "FromGenericSearchToCreditAllocation";
    }

    public String getFromGenericSearchToGuaranteePrincipal() {
        return "FromGenericSearchToGuaranteePrincipal";
    }

    public String getFindGuaranteeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_GUARANTEE;
    }

    public String getFindGuaranteeUsageSearchKey() {
        return Constants.SEARCH_KEYS.FIND_GUARANTEEUSAGES;
    }

    public String getFindGuaranteeForUsageSearchKey() {
        return Constants.SEARCH_KEYS.FIND_GUARANTEE_FOR_USAGES;
    }


    public String getFromGenericSearchToGuaranteeUsage() {
        return "FromGenericSearchToGuaranteeUsage";
    }

    public String getFromGenericSearchToGuarenteeUsageHeader() {
        return "FromGenericSearchToGuarenteeUsageHeader";
    }

    public String getFromGenericSearchToGuaranteeUsageLookup() {
        return "FromGenericSearchToGuaranteeUsageLookup";
    }

    public String getFindTaxBandConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXBANDCONFIGS;
    }

    public String getFromGenericSearchToTaxBandConfig() {
        return "FromGenericSearchToTaxBandConfig";
    }

    public String getFindTaxTypeConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXTYPECONFIGS;
    }

    public String getFromGenericSearchToTaxTypeConfig() {
        return "FromGenericSearchToTaxTypeConfig";
    }

    public String getFindTaxRateConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXRATECONFIGS;
    }

    public String getFindTaxAllocationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAXALLOCATION;
    }

    public String getFindTaxForGuaranteeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAX_ACCOUNT_FOR_GUARANTEE;
    }


    public String getFindGoodsTransferMethodSearchKey() {
        return Constants.SEARCH_KEYS.FIND_GOODS_TRANSFER_METHOD;
    }

    public String getFindHandlingOperationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_HANDLING_OPERATION;
    }

    public String getFromGenericSearchToTaxRateConfig() {
        return "FromGenericSearchToTaxRateConfig";
    }

    public String getFromGenericSearchToTaxAllocation() {
        return "FromGenericSearchToTaxAllocation";
    }

    public String getFromGenericSearchToCancelGuarantee() {
        return "FromGenericSearchToCancelGuarantee";
    }

    public String getFromGenericSearchToReleaseGuarantee() {
        return "FromGenericSearchToReleaseGuarantee";
    }

    public String getFromGenericSearchToTaxAllocationConfig() {
        return "FromGenericSearchToTaxAllocationConfig";
    }


    public String getGuaranteeForDeclaration() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_USAGE_DECLARATION;
    }

    public String getGuaranteeForTax() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_USAGE_TAX;
    }

    public String getGuaranteeForRevenueDeferment() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_USAGE_REV_DEF;
    }

    public String getGuaranteeForWarehouse() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_USAGE_WAREHOUSE;
    }

    public String getGuaranteeWithStatusNew() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_STATUS_NEW;
    }

    public String getGuaranteeWithStatusNotNew() {
        return Constants.StaticSearchInjection.FIND_GUARANTEE_FOR_STATUS_NOT_NEW;
    }

    public String getAmountMoreThanZero() {
        return Constants.StaticSearchInjection.AMOUNT_GREATER_THAN_ZERO;
    }

    public String getFindTransactionsForDeferment() {
        return Constants.StaticSearchInjection.FIND_TRANSACTIONS_FOR_DEFRMENT;
    }

    public String getFindTransactionsForPaymentAllocation() {
        return Constants.StaticSearchInjection.FIND_TRANSACTIONS_FOR_PAYMENT;
    }

    public String getEntities() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES;
    }

    public String getPaymentsToBeResolved() {
        return Constants.StaticSearchInjection.FIND_PAYMENTS_TO_RESOLVE;
    }

    public String getEntitiesWithCustomsAccount() {
        return Constants.StaticSearchInjection.FIND_ENTITY_WITH_CUSTOMS_ACCOUNT;
    }

    public String getEntitiesWithTin() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_WITH_TIN;
    }

    public String getEntitiesCanBeSuspended() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_CANBE_SUSPENDED;
    }

    public String getEntitiesCanBeReActivated() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_CANBE_REACTIVATED;
    }

    public String getEntitiesCanBeDeRegistered() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_CANBE_DEREGISTERED;
    }

    public String getEntitiesCanBeReRegistered() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_CANBE_REREGISTERED;
    }

    public String getEntitiesCanBranch() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_CAN_BRANCH;
    }

    public String getCaseDocTin() {
        return Constants.StaticSearchInjection.FIND_CASE_DOC_TIN;
    }

    public String getNonSubmittedBatch() {
        return Constants.StaticSearchInjection.NON_SUBMITTED_BATCH;
    }

    public String getFindNotCancelledDeferments() {
        return Constants.StaticSearchInjection.FIND_NOT_CANCELLED_DEFERMENTS;
    }
    /*
     * Returns the database column name that will be returned from the warehouse search.
     * It is defined in search-config.xml.
     *
     */

    public String getAddressColNameForWarehouseSearch() {
        return "ADDRESS";
    }

    public String getFindCustomsRegimeTaxSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CUSTOMSREGIMETAXS;
    }

    public String getFromGenericSearchToCustomsRegimeTax() {
        return "FromGenericSearchToCustomsRegimeTax";
    }

    public String getFromCustomRegimeTaxToGenericSearch() {
        return "dialog:FromCustomRegimeTaxToGenericSearch";
    }

    public String getFromGenericSearchToExemptionCommodity() {
        return "FromGenericSearchToExemptionCommodity";
    }

    public String getIndividualEntityType() {
        return Constants.Entity.INDIVIDUAL_TYPE;
    }

    public String getOrganizationEntityType() {
        return Constants.Entity.ORGANIZATION_TYPE;
    }

    public String getPartialForFieldOrganisationOnly() {
        return Constants.Entity.ORGANIZATION_TYPE;
    }

    public String getPartialForFieldIndividualOnly() {
        return Constants.Entity.INDIVIDUAL_TYPE;
    }

    public String getDeclarationsForAmendment() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_FOR_AMENDMENT;
    }

    public String getDeclarationsForClearance() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_FOR_CLEARANCE;
    }

    public String getDeclarationsSaved() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_SAVED;
    }

    public String getDeclarationsAwaitingOffence() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_OFFENCE;
    }

    public String getDeclarationsAwaitingPayment() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_AWAITING_PAYMENT;
    }

    public String getViewManifest() {
        return Constants.StaticSearchInjection.VIEW_MANIFEST;
    }

    public String getAmendManifest() {
        return Constants.StaticSearchInjection.AMEND_MANIFEST;
    }

    public String getReconcileManifest() {
        return Constants.StaticSearchInjection.RECONCILE_MANIFEST;
    }

    public String getAddButton() {
        return Constants.SearchActionButtons.ADD_BUTTON;
    }

    public String getCopyButton() {
        return Constants.SearchActionButtons.COPY_BUTTON;
    }

    public String getNextButton() {
        return Constants.SearchActionButtons.NEXT_BUTTON;
    }

    public String getDeclarationsAwaitingGuarantee() {
        return Constants.StaticSearchInjection.FIND_DECLARATION_AWAITING_GUARANTEE;
    }

    public String getFindFlexibleFormSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FLEXIBLEFORMS;
    }

    public String getFromGenericSearchToFlexibleFormEntry() {
        return "FromGenericSearchToFlexibleFormEntry";
    }

    public String getFromGenericSearchToFlexibleForm() {
        return "FromGenericSearchToFlexibleForm";
    }

    public String getFindFlexibleFormTypeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FLEXIBLE_FORM_TYPES;
    }

    public String getFromGenericSearchToFlexibleFormType() {
        return "FromGenericSearchToFlexibleFormType";
    }

    public String getFindFormApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FORM_APPLICATION;
    }

    public String getFromGenericSearchToSupportingAttachments() {
        return "FromGenericSearchToSupportingAttachments";
    }

    public String getFromGenericSearchToOfficeUser() {
        return "FromGenericSearchToOfficeUser";
    }

    public String getFromGenericSearchToOfficeCoverage() {
        return "FromGenericSearchToOfficeCoverage";
    }

    public String getFromGenericSearchToTransferTaxpayer() {
        return "FromGenericSearchToTransferTaxpayer";
    }

    public String getFromGenericSearchToExtendDueDate() {
        return "FromGenericSearchToExtendDueDate";
    }

    public String getFindRegimeConfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REGIME_CONFIGURATIONS;
    }

    public String getFromGenericSearchToRegimeConfiguration() {
        return "FromGenericSearchToRegimeConfiguration";
    }


    public String getFindFlexibleDBTableSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FLEXIBLE_DB_TABLES;
    }

    public String getFromGenericSearchToBatchDetails() {
        return "FromGenericSearchToBatchDetails";
    }

    public String getFindBatchDetailsSearchKey() {
        return Constants.SEARCH_KEYS.FIND_BATCH_DETAILS;
    }

    public String getFromGenericSearchToBatchPaymentDetails() {
        return "FromGenericSearchToBatchPaymentDetails";
    }

    public String getFromReconcileRefundDetails() {
        return "FromReconcileRefundDetails";
    }

    public String getFindDateManagement() {
        return Constants.SEARCH_KEYS.FIND_DATE_MANAGEMENT;
    }

    public String getFindDateHoliday() {
        return Constants.SEARCH_KEYS.FIND_DATE_HOLIDAY;
    }

    public String getFindDateLegislative() {
        return Constants.SEARCH_KEYS.FIND_DATE_LEGISLATIVE;
    }

    public String getFindDateManagementToDateDetails() {
        return "GoToDateDetails";
    }

    public String getFindBatchCollectionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_BATCH_COLLECTION;
    }

    public String getFromGenericSearchToFlexibleDBTable() {
        return "FromGenericSearchToFlexibleDBTable";
    }

    public String getFromGenericSearchToMaintainHoliday() {
        return "FromGenericSearchToMaintainHoliday";
    }

    public String getFromGenericSearchToMaintainLegislativeDate() {
        return "FromGenericSearchToMaintainLegislative";
    }

    public String getFindConfigurationSetSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CONFIGURATION_SET;
    }

    public String getFromGenericSearchToConfigurationSet() {
        return "FromGenericSearchToConfigurationSet";
    }

    public String getFromAnyOffice() {
        return "FromAnyOffice";
    }

    public String getFindFlexFormsMiniSpotLightSearchKey() {
        return Constants.SEARCH_KEYS.FIND_FLEX_FORMS_MINI_SPOT_LIGHT;
    }

    public String getFromGenericSearchToProcessReleaseRefundDetails() {
        return "FromGenericSearchToProcessReleaseRefundDetails";
    }

    public String getFindEntityTCCIssuanceSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_TCC_ISSUANCE;
    }

    public String getFromGenericSearchToCreateInstallment() {
        return "FromWelcomeToRevenueDefermentManagementEntry";
    }

    public String getFindTransactionForInstallmentAgreementSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TRANSACTION_FOR_INSTALLMENT_AGREEMENT;
    }

    public String getFindJobDefinitionSearchKey() {
        return Constants.SEARCH_KEYS.FIND_JOB_DEFINITIONS;
    }

    public String getFromGenericSearchToJobDefinition() {
        return "FromGenericSearchToJobDefinition";
    }

    public String getFromGenericSearchToJobStream() {
        return "FromGenericSearchToJobStream";
    }

    public String getFindSchedulableJobSetSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SCHEDULABLE_JOB_SET;
    }

    public String getFromGenericSearchToSchedulableJobSet() {
        return "FromGenericSearchToSchedulableJobSet";
    }

    public String getFindTCRConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TCR_CONFIGURATION;
    }

    // For Audit Search Profile

    public String getFindSelectionProfileSearchBusinessKey() {
        return Constants.SEARCH_KEYS.FIND_SELECTION_PROFILE_BUSINESS;
    }

    public String getFindSelectionProfileSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SELECTION_PROFILE;
    }
    
    public String getFindSelectionProfileToRunSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SELECTION_PROFILE_TO_RUN;
    }

    public String getFromGenericSearchToAuditProfile() {
        return "FromGenericSearchToAuditProfile";
    }
    
    public String getFromGenericSearchToAuditRunProfile() {
        return "FromGenericSearchToAuditRunProfile";
    }
    

    public String getFromGenericSearchToRunSelectionProfile() {
        return "FromGenericSearchToRunSelectionProfile";
    }

    public String getFindSelectionReportSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SELECTION_REPORT;
    }

    public String getFromGenericSearchToAuditReport() {
        return "FromGenericSearchToAuditReport";
    }

    public String getFindJobStreamSearchKey() {
        return Constants.SEARCH_KEYS.FIND_JOB_STREAMS;
    }

    //For Audit Log Profile

    public String getFindSelectionAuditLogSearchKey() {
        return Constants.SEARCH_KEYS.FIND_AUDIT_LOG;
    }

    public String getFromGenericSearchToAuditLog() {
        return "FromGenericSearchToAuditLog";
    }

    //For Generated TAMP List 06/29/2010

    public String getFindSelectionGeneratedTampListSearchKey() {
        return Constants.SEARCH_KEYS.FIND_TAMPLIST_SELECTION;
    }

    public String getFromGenericSearchToGeneratedTampList() {
        return "FromGenericSearchToGeneratedTampList";
    }

    //TCR Configuration

    public String getFromGenericSearchToTCRConfiguration() {
        return "FromGenericSearchToTCRConfiguration";
    }

    //Deposit Slip

    public String getFromGenericSearchToDepositSlip() {
        return "FromGenericSearchToDepositSlip";
    }

    public String getFromWelcomeToDepositSlip() {
        return "FromWelcomeToDepositSlip";
    }

    public String getFindDepositSlipSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DEPOSIT_SLIP;
    }

    // Risk Information

    public String getFromGenericSearchToUpdateRiskInformation() {
        return "FromGenericSearchToUpdateRiskInformation";
    }

    public String getFindRiskInformationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RISK_INFORMATION;
    }

    public String getFromGenericSearchToManageFinancialDetails() {
        return "FromGenericSearchToManageFinancialDetails";
    }

    public String getFromGenericSearchToEmployeeAndEmployerRel() {
        return "FromGenericSearchToEmployeeAndEmployerRel";
    }


    public String getFromGenericSearchToScriptManager() {
        return "FromGenericSearchToScriptManager";
    }


    public String getFindGuiPage() {
        return Constants.SEARCH_KEYS.FIND_GUI_PAGE;
    }


    public String getFindScript() {
        return Constants.SEARCH_KEYS.FIND_SCRIPT;
    }

    public String getFindMessageType() {
        return Constants.SEARCH_KEYS.FIND_MESSAGE_TYPE;
    }

    public String getFindScriptSearchKey() {
        return Constants.SEARCH_KEYS.FIND_SCRIPT;
    }

    public String getShareholders() {
        return WebConstants.ProcessScopeVariable.SHAREHOLDERS;
    }

    public String getPartners() {
        return WebConstants.ProcessScopeVariable.PARTNERS;
    }

    public String getFromGenericSearchToShareholdersPartners() {
        return "FromGenericSearchToShareholdersPartners";
    }

    public String getFromGenericSearchToPropertyDetails() {
        return "FromGenericSearchToPropertyDetails";
    }

    public String getFromGenericSearchToEmploymentDetails() {
        return "FromGenericSearchToEmploymentDetails";
    }

    public String getFromGenericSearchToRelationshipDetails() {
        return "FromGenericSearchToRelationshipDetails";
    }

    public String getFromGenericSearchToLodgementReturn() {
        return "FromGenericSearchToLodgementReturn";
    }

    public String getFromAddressToPropertyDetails() {
        return "FromAddressToPropertyDetails";
    }

    public String getSubsidiaries() {
        return WebConstants.ProcessScopeVariable.SUBSIDIARY;
    }

    public String getRelatedCompanies() {
        return WebConstants.ProcessScopeVariable.RELATED_COMPANIES;
    }

    public String getAddressToBranches() {
        return "FromAddressToBranches";
    }

    public String getRelationShips() {
        return WebConstants.ProcessScopeVariable.RELATION_SHIPS;
    }

    public String getDirectors() {
        return WebConstants.ProcessScopeVariable.DIRECTORS;
    }

    public String getFindEntitiesTransferTaxpayer() {
        return Constants.StaticSearchInjection.FIND_ENTITY_ENTITIES_TRANSFER_TAXPAYER;
    }

    public String getFindApprovedExemptions() {
        return Constants.StaticSearchInjection.FIND_APPROVED_EXEMPTIONS;
    }

    public String getFindSuspendExemptions() {
        return Constants.StaticSearchInjection.FIND_SUSPEND_EXEMPTIONS;
    }

    public String getFindPeriodFormulaSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PERIOD_FORMULA;
    }

    public String getFromGenericSearchToPeriodFormula() {
        return "FromGenericSearchToPeriodFormula";
    }

    public String getFindPeriodGenerationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PERIOD_GENERATION;
    }

    public String getFromGenericSearchToPeriodGeneration() {
        return "FromGenericSearchToPeriodGeneration";
    }

    public String getFromTempIndexToIndividualSummaryDetails() {
        return "FromTempIndexToIndividualSummaryDetails";
    }

    public String getFromTempIndexToOrganisationSummaryDetails() {
        return "FromTempIndexToOrganisationSummaryDetails";
    }

    public String getFromTempIndexToGenericSearch() {
        return "FromTempIndexToGenericSearch";
    }

    public String getGlobalGuiConfig() {
        return "globalGuiConfig";
    }

    public String getFromWelcomeToPAndIConfigurationManagement() {
        return "FromWelcomeToPAndIConfigurationManagement";
    }

    public String getFromTempIndexToAppTypeSelection() {
        return "FromTempIndexToAppTypeSelection";
    }

    public String getFromWelcomeToTableManagement() {
        return "FromWelcomeToTableManagement";
    }

    public String getFromWelcomeToWorkflowMappingManagement() {
        return "FromWelcomeToWorkflowMappingManagement";
    }

    public String getFromWelcomeToFormSelection() {
        return "FromWelcomeToFormSelection";
    }

    public String getFromWelcomeToProductManagement() {
        return "FromWelcomeToProductManagement";
    }

    public String getFromReconcileBatchPaymentDetails() {
        return "FromReconcileBatchPaymentDetails";
    }

    public String getFromWelcomeToFlexibleDBTableManagement() {
        return "FromWelcomeToFlexibleDBTableManagement";
    }

    public String getFromWelcomeToAuditCreate() {
        return "FromWelcomeToAuditCreate";
    }

    public String getFromWelcomeToCaseOutlineConfiguration() {
        return "FromWelcomeToCaseOutlineConfiguration";
    }

    public String getFromWelcomeToReturnLodgement() {
        return "FromWelcomeToReturnLodgement";
    }

    public String getFromWelcomeToPeriodReferenceDetails() {
        return "FromWelcomeToPeriodReferenceDetails";
    }

    public String getFromWelcomeToCreateRiskInformation() {
        return "FromWelcomeToCreateRiskInformation";
    }

    public String getFromWelcomeToGeneratedTampPage() {
        return "FromWelcomeToGeneratedTampPage";
    }

    public String getFromMenuToCustomsTaxManager() {
        return "FromMenuToCustomsTaxManager";
    }

    public String getFromGenericSearchToComplianceConfiguration() {
        return "FromGenericSearchToComplianceConfiguration";
    }

    public String getFromGenericSearchToMaintainAutomaticComplianceScheduling() {
        return "FromGenericSearchToMaintainAutomaticComplianceScheduling";
    }
    
    public String getFromTempIndexToCaseSelection() {
        return "FromTempIndexToCaseSelection";
    }

    public String getFromWelcomeToFlexibleFormTypeManagement() {
        return "FromWelcomeToFlexibleFormTypeManagement";
    }

    public String getFromMenuToUserSecurityControlPanel() {
        return "FromMenuToUserSecurityControlPanel";
    }

    public String getFromMenuToGroupSecurityControlPanel() {
        return "FromMenuToGroupSecurityControlPanel";
    }

    public String getGlobalTaxCompliance() {
        return "globalTaxCompliance";
    }

    public String getFromTempIndexToDocumentDetails() {
        return "FromTempIndexToDocumentDetails";
    }

    public String getFromWelcomeToRegimeConfigurationManagement() {
        return "FromWelcomeToRegimeConfigurationManagement";
    }

    public String getFromWelcomeToAddOffice() {
        return "FromWelcomeToAddOffice";
    }

    public String getFromWelcomeToSearchConfiguration() {
        return "FromWelcomeToSearchConfiguration";
    }

    public String getFromWelcomeToScriptEntry() {
        return "FromWelcomeToScriptEntry";
    }

    public String getFromWelcomeToFlexibleFormManagement() {
        return "FromWelcomeToFlexibleFormManagement";
    }

    public String getFromTempIndexToUserReports() {
        return "FromTempIndexToUserReports";
    }

    public String getFromWelcomeToRiskProfileDetails() {
        return "FromWelcomeToRiskProfileDetails";
    }

    public String getFromWelcomeToProfileSearch() {
        return "FromWelcomeToProfileSearch";
    }

    public String getFromWelcomeToGenericSearch() {
        return "FromWelcomeToGenericSearch";
    }

    public String getFromWelcomeToChangePassword() {
        return "FromWelcomeToChangePassword";
    }

    public String getFromWelcomeToJobLog() {
        return "FromWelcomeToJobLog";
    }

    public String getFindReportConfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REPORT_CONFIGURATION;
    }
    
    public String getFindMaintainTaxTypeStructure() {
        return Constants.SEARCH_KEYS.FIND_MAINTAIN_TAXTYPE_STRUCTURE;
    }
    
    public String getFindTaxRateConfiguration() {
        return Constants.SEARCH_KEYS.FIND_TAX_RATE_CONFIGURATION;
    }    

    public String getFromGenericSearchToReportsManagement() {
        return "FromGenericSearchToReportsManagement";
    }
    
    public String getFromGenericSearchToTaxTypeStructure() {
        return "FromGenericSearchToTaxTypeStructure";
    }
    
    public String getFromGenericSearchToTaxRateConfiguration() {
        return "FromGenericSearchToTaxRateConfiguration";
    }

    public String getFindReportReprintSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REPORTREPRINTS;
    }

    public String getFromGenericSearchToReportReprint() {
        return "FromGenericSearchToReportReprint";
    }

    public String getCreditAllocation() {
        return WebConstants.ProcessScopeVariable.CREDIT_ALLOCATION;
    }

    public String getDebitAllocation() {
        return WebConstants.ProcessScopeVariable.DEBIT_ALLOCATION;
    }

    public String getFindEntAccPeriodSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENT_ACC_PERIOD;
    }

    public String getFindEntityFFSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_FF;
    }

    public String getFindReceiptSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RECEIPT;
    }

    public String getFromGenericSearchToDishonourPayment() {
        return "FromGenericSearchToDishonourPayment";
    }

    public String getFindAllocationRulesConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ALLOC_CONFIG;
    }

    public String getFromGenericSearchToAllocationRules() {
        return "FromGenericSearchToAllocationRules";
    }

    public String getFindDocumentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DOCUMENT;
    }

    public String getFindDocumentOutstandingBalanceSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DOCUMENT_OUTSTANDING_BALANCE;
    }

    public String getFromWelcomeToCashOfficeSearch() {
        return "FromWelcomeToCashOfficeSearch";
    }

    public String getFindCashOfficeSearchKey() {
        return Constants.SEARCH_KEYS.FIND_REV_COLL_CASH_OFFICE;
    }

    public String getFindReturnDocumentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RETURN_DOCUMENT;
    }

    public String getFindExtendReturnDocumentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_EXTEND_RETURN_DOCUMENT;
    }

    public String getFindExemptionsSearchKey() {
        return Constants.SEARCH_KEYS.FIND_EXEMPTIONS;
    }

    public String getFindPenaltyRuleConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PENALTY_RULE_CONFIGURATION;
    }

    public String getFromGenericSearchToPenaltyRuleConfiguration() {
        return "FromGenericSearchToPenaltyRuleConfiguration";
    }
    
    public String getFindManualPenaltySearchKey() {
        return Constants.SEARCH_KEYS.FIND_MANUAL_PENALTY;
    }

    public String getFromGenericSearchToManualPenalty() {
        return "FromGenericSearchToManualPenalty";
    }

    public String getFindExemptionsApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_EXEMPTIONS_APPLICATIONS;
    }

    public String getfindEntityExemptionApplicationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_EXMN_APP_TAXPAYER;
    }


    public String getFromGenericSearchToCashOfficeMaintenanceDetails() {
        return "FromGenericSearchToCashOfficeMaintenanceDetails";
    }

    public String getFromWelcomeToReceiptDocumentControl() {
        return "FromWelcomeToReceiptDocumentControl";
    }

    public String getFromWelcomeToCashOfficeDailyControl() {
        return "FromWelcomeToCashOfficeDailyControl";
    }

    public String getFromWelcomeToFindExemption() {
        return "FromWelcomeToFindExemption";
    }

    public String getFromGenericSearchToExemptionMaintenanceDetails() {
        return "fromGenericSearchToExemptionMaintenanceDetails";
    }

    public String getFromWelcomeToExemptionsAdd() {
        return "FromWelcomeToExemptionsAdd";

    }

    public String getFromGenericSearchToConfigureDefaultOffice() {
        return "FromGenericSearchToConfigureDefaultOffice";
    }

    public String getFindConfigureDefaultOffice() {
        return Constants.SEARCH_KEYS.FIND_CONFIGURE_DEFAULT_OFFICE;
    }

    public String getFindTaxCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CASE;
    }
    public String getFindLinkedCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_LINKED_CASE;
    }
    
    
    
    public String getFindViewTaxCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_VIEW_CASE;
    }

    public String getFromGenericSearchToCreateCase() {
        return "FromGenericSearchToCreateCase";
    }

    public String getFromWelcomeToFindEntityForCreateCase() {
        return "FromWelcomeToFindEntityForCreateCase";
    }

    public String getFindEntityForCreateCaseSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_FOR_CREATE_CASE;
    }

    public String getFromGenericSearchToRelatedDocuments() {
        return "FromGenericSearchToRelatedDocuments";
    }

    public String getFindCaseRelateDocumentSearchKey() {
        return Constants.SEARCH_KEYS.FIND_CASE_RELATED_DOCUMENT;
    }

    public String getFromGenericSearchToUpdateCase() {
        return "FromGenericSearchToUpdateCase";
    }

    public String getFromGenericSearchToLinkedRelatedCases() {
        return "FromGenericSearchToLinkedRelatedCases";
    }

    public String getFromWelcomeToExemptionsApplicationsAdd() {
        return "FromWelcomeToExemptionsApplicationsAdd";
    }

    public String getFromWelcomeToFindExemptionsApplications() {
        return "FromWelcomeToFindExemptionsApplications";
    }

    public String getFromGenericSearchToExemptionApplicationDetails() {
        return "FromGenericSearchToExemptionApplicationDetails";
    }
    
    public String getFromGenericSearchToViewCase() {
        return "FromGenericSearchToViewCase";
    }
    
     //TODO move to Case management backing bean
    public String fromTempIndexToDebtManagementGenericSearch() {
        FacesUtil.removeFromProcessScope(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP);
        HashMap allocateInitVars = new HashMap();
        allocateInitVars.put(Constants.CASE_TYPE, Constants.CaseTypes.DEBT_MANAGEMENT);
        FacesUtil.getProcessScope().put(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP, allocateInitVars );
        return "FromTempIndexToGenericSearch";
    }
    
    public String fromTempIndexToAuditVisitManagementGenericSearch() {
        FacesUtil.removeFromProcessScope(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP);
        HashMap allocateInitVars = new HashMap();
        //AUDIT_VISIT
        allocateInitVars.put(Constants.CASE_TYPE, Constants.CaseTypes.AUDIT_VISIT);
        FacesUtil.getProcessScope().put(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP, allocateInitVars );
        return "FromTempIndexToGenericSearch";
    }
    
    public String fromWelcomeToObjectionAndAppealGenericSearch() {
        FacesUtil.removeFromProcessScope(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP);
        HashMap allocateInitVars = new HashMap();
        allocateInitVars.put(Constants.CASE_TYPE, Constants.CaseTypes.OBJECTION_AND_APPEAL);
        FacesUtil.getProcessScope().put(WebConstants.ProcessScopeVariable.DYNAMIC_SEARCH_CRITERIA_SETUP, allocateInitVars );
        return "FromWelcomeToGenericSearch";
    }

    public String getFromGenericSearchToLinkedRelatedDebtCases() {
        return "FromGenericSearchToLinkedRelatedDebtCases";
    }
    
    public String getFromGenericSearchToRefundClaim() {
        return "FromGenericSearchToRefundClaim";
    }
    
    public String getCasesByStatus() {
        return Constants.StaticSearchInjection.FIND_CASES_BY_STATUS;
    }
    
    public String getCasesForReviewObjection() {
        return Constants.StaticSearchInjection.FIND_CASES_FOR_REVIEW_OBJECTION;
    }
    
    public String getCasesForFinaliseObjection() {
        return Constants.StaticSearchInjection.FIND_CASES_FOR_FINALISE_OBJECTION;
    }
    
    public String getCasesForLodgeAppeal() {
        return Constants.StaticSearchInjection.FIND_CASES_FOR_LODGE_APPEAL;
    }
    
    public String getCasesForReviewAppeal() {
        return Constants.StaticSearchInjection.FIND_CASES_FOR_REVIEW_APPEAL;
    }
    
    public String getCasesForFinaliseAppeal() {
        return Constants.StaticSearchInjection.FIND_CASES_FOR_FINALISE_APPEAL;
    }
    
    public String getProcessRefundPayment() {
        return Constants.StaticSearchInjection.FIND_REFUNDS_FOR_PROCESS;
    }
   
    public String getCaseGeneralConfig() {
        return Constants.GuiConfig.CASE_GENERAL_CONFIG;
    }
    
    public String getCaseDebtConfig() {
        return Constants.GuiConfig.CASE_DEBT_CONFIG;
    }
    
    public String getCaseAuditConfig() {
        return Constants.GuiConfig.CASE_AUDIT_CONFIG;
    }
    
    public String getLodgeObjectionConfig() {
        return Constants.GuiConfig.LODGE_OBJECTION_CONFIG;
    }
    
    public String getRecordAdditionalsDetailsConfig() {
        return Constants.GuiConfig.RECORD_ADDITIONAL_DETAILS_CONFIG;
    }
    
    public String getReviewObjectionConfig() {
        return Constants.GuiConfig.REVIEW_OBJECTION_CONFIG;
    }
    public String getFinaliseObjectionConfig() {
        return Constants.GuiConfig.FINALISE_OBJECTION_CONFIG;
    }
    public String getLodgeAppealConfig() {
        return Constants.GuiConfig.LODGE_APPEAL_CONFIG;
    }
    public String getReviewAppealConfig() {
        return Constants.GuiConfig.REVIEW_APPEAL_CONFIG;
    }
    public String getFinaliseAppealConfig() {
        return Constants.GuiConfig.FINALISE_APPEAL_CONFIG;
    }
    
    public String getCaseObjectionAppealConfig() {
        return Constants.GuiConfig.CASE_OBJECTION_APPEAL_CONFIG;
    }
    
    public String getLodgeObjectionFlowMode() {
        return Constants.ObjAppFlowMode.LODGE_OBJECTION_FLOW;
    }
    
    public String getRecordAddDetailsFlowMode() {
        return Constants.ObjAppFlowMode.RECORD_ADD_DETAILS_FLOW;
    }
        
    public String getReviewObjectionFlowMode() {
        return Constants.ObjAppFlowMode.REVIEW_OBJECTION_FLOW;
    }
    
    public String getFinaliseObjectionFlowMode() {
        return Constants.ObjAppFlowMode.FINALISE_OBJECTION_FLOW;
    }
    public String getLodgeAppealFlowMode() {
        return Constants.ObjAppFlowMode.LODGE_APPEAL_FLOW;
    }
    public String getReviewAppealFlowMode() {
        return Constants.ObjAppFlowMode.REVIEW_APPEAL_FLOW;
    }
    public String getFinaliseAppealFlowMode() {
        return Constants.ObjAppFlowMode.FINALISE_APPEAL_FLOW;
    }
    
    public String getViewObjectionAppealCaseFlowMode() {
        return Constants.ObjAppFlowMode.VIEW_OBJECTION_APPEAL_CASE_FLOW;
    }
    
    public String getGeneralCaseCategory(){
        return Constants.CaseCategory.GENERAL;
    }
    
    public String getDebtCaseCategory(){
        return Constants.CaseCategory.DEBT_MANAGEMENT;
    }
    
    public String getAuditCaseCategory(){
        return Constants.CaseCategory.AUDIT_AND_VISIT;
    }
    
    public String getObjectionAndAppealCategory(){
        return Constants.CaseCategory.OBJECTION_AND_APPEAL;
    }
    
    public String getFindInstallmentAgreementSearchKey() {
        return Constants.SEARCH_KEYS.FIND_INSTALLMENT_AGREEMENT;
    }
    
    public String getFromGenericSearchToInstalmentAgreement() {
        return "FromGenericSearchToInstalmentAgreement";
    }
    
    public String getFromGenericSearchToDeskAuditConfiguration() {
        return "FromGenericSearchToDeskAuditConfiguration";
    }
    
    public String getFindDeskAuditConfigSearchKey() {
        return Constants.SEARCH_KEYS.FIND_DESK_AUDIT_CONFIGURATION;
    }
    
    public String getFindComplianceRulesSearchKey() {
        return Constants.StaticSearchInjection.FIND_TAX_COMPLIANCE_RULES;
    }
    
    public String getFindMaintainAuotomaticComplianceSearchKey() {
        return Constants.StaticSearchInjection.FIND_MAITAIN_AUTOMATIC_COMPLIANCE_SCHEDULING;
    }
    
    public String getFromTempIndexToMaintainAuditSelectionRiskBands() {
        return "FromTempIndexToMaintainAuditSelectionRiskBands";
    }
    public String getFromTempIndexToMaintainRiskIndicators(){
        return "FromTempIndexToMaintainRiskIndicators";
    }
    
    public String getFromGenericSearchToRiskProfile() {
        return "FromGenericSearchToRiskProfile";
    }
    
    public String getFindRiskProfileSearchKey() {
        return Constants.SEARCH_KEYS.FIND_RISK_PROFILE;
    }
    
    public String getFindVisitSelectionReportKey() {
        return Constants.SEARCH_KEYS.FIND_VISIT_SELECTION_REPORT;
    }
    
    public String getFromGenericSearchToVisitSelection() {
        return "FromGenericSearchToVisitSelectionReport";
    }
    
    public String getFindTransactionForObjectionKey() {
        return Constants.SEARCH_KEYS.FIND_BUSINESS_TRANSACTION_FOR_OBJECTION;
    }
    
    public String getFindParametersConfigurationSearchKey() {
        return Constants.SEARCH_KEYS.FIND_PARAMETERS_CONFIGURATION;
    }
    
    
    public String getFromGenericSearchToParametersConfiguration() {
        return "FromGenericSearchToParametersConfiguration";
    }
    
    public String getReturnDocumentsForFiling() {
        return Constants.StaticSearchInjection.FIND_RETURNS_FOR_FILING;
    }
    
    
    
    public String getFromSearchForCashOfficerToCashOfficerAllocation() {
        return "FromSearchForCashOfficerToCashOfficerAllocation";
    }
    
    public String getFindSearchForCashOfficerKey() {
        return Constants.SEARCH_KEYS.FIND_CASH_OFFICER;
    }
    
    public String getFindEntityIncludingGraSearchKey() {
        return Constants.SEARCH_KEYS.FIND_ENTITY_INCLUDING_GRA;
    }
}

