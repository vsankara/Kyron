package com.technobrain.trips.assembler;

//import com.crownagents.trips.reference.model.RefAccessLevel;
//import com.crownagents.trips.reference.model.RefAccountingMethod;
//import com.crownagents.trips.reference.model.RefAddressType;
//import com.crownagents.trips.reference.model.RefAdjustmentReason;
//import com.crownagents.trips.reference.model.RefAdjustmentType;
//import com.crownagents.trips.reference.model.RefAircraftStatus;
//import com.crownagents.trips.reference.model.RefAircraftType; 
//import com.crownagents.trips.reference.model.RefAirline;
//import com.crownagents.trips.reference.model.RefAirlineStatus;
//import com.crownagents.trips.reference.model.RefAllocationMethod;
//import com.crownagents.trips.reference.model.RefAllocationType;
//import com.crownagents.trips.reference.model.RefAnalyst;
//import com.crownagents.trips.reference.model.RefAppAttType;
//import com.crownagents.trips.reference.model.RefAppealDecision;
//import com.crownagents.trips.reference.model.RefApplicationIndicator;
//import com.crownagents.trips.reference.model.RefApplicationRole;
//import com.crownagents.trips.reference.model.RefApplicationRoleType;
//import com.crownagents.trips.reference.model.RefApplicationType;
//import com.crownagents.trips.reference.model.RefAssessmentType;
//import com.crownagents.trips.reference.model.RefAssetType;
//import com.crownagents.trips.reference.model.RefAssociationLevel;
//import com.crownagents.trips.reference.model.RefAssociationStatus;
//import com.crownagents.trips.reference.model.RefAssociationType;
//import com.crownagents.trips.reference.model.RefAttachmentType;
//import com.crownagents.trips.reference.model.RefAttributes;
//import com.crownagents.trips.reference.model.RefAuditLogType;
//import com.crownagents.trips.reference.model.RefAuditReportDetailType;
//import com.crownagents.trips.reference.model.RefAuditVisitType;
//import com.crownagents.trips.reference.model.RefAuditprepDetailType;
//import com.crownagents.trips.reference.model.RefAuthorisationType;
//import com.crownagents.trips.reference.model.RefBandingType;
//import com.crownagents.trips.reference.model.RefBank;
//import com.crownagents.trips.reference.model.RefBankAccountStatus;
//import com.crownagents.trips.reference.model.RefBankBranch;
//import com.crownagents.trips.reference.model.RefBankRateType;
//import com.crownagents.trips.reference.model.RefBatchFormType;
//import com.crownagents.trips.reference.model.RefBatchJobParam;
//import com.crownagents.trips.reference.model.RefBatchStatus;
//import com.crownagents.trips.reference.model.RefBookOfAccountsType;
//import com.crownagents.trips.reference.model.RefBpels;
//import com.crownagents.trips.reference.model.RefBusinessLocation;
//import com.crownagents.trips.reference.model.RefBusinessSector;
//import com.crownagents.trips.reference.model.RefBusinessSectorCategory;
//import com.crownagents.trips.reference.model.RefCancellationReason;
//import com.crownagents.trips.reference.model.RefCardStatus;
//import com.crownagents.trips.reference.model.RefCardType;
//import com.crownagents.trips.reference.model.RefCaseDocStatus;
//import com.crownagents.trips.reference.model.RefCaseOutcome;
//import com.crownagents.trips.reference.model.RefCaseStatus;
//import com.crownagents.trips.reference.model.RefCaseType;
//import com.crownagents.trips.reference.model.RefCaseWorkingStatus;
//import com.crownagents.trips.reference.model.RefCashOfficeStatus;
//import com.crownagents.trips.reference.model.RefCashTillStatus;
//import com.crownagents.trips.reference.model.RefChemicalName;
//import com.crownagents.trips.reference.model.RefChoice;
//import com.crownagents.trips.reference.model.RefCollectionReceiptStatus;
//import com.crownagents.trips.reference.model.RefColours;
//import com.crownagents.trips.reference.model.RefComCode;
//import com.crownagents.trips.reference.model.RefComProcedure;
//import com.crownagents.trips.reference.model.RefComPtPurpose;
//import com.crownagents.trips.reference.model.RefComPtType;
//import com.crownagents.trips.reference.model.RefCommercialAccounts;
//import com.crownagents.trips.reference.model.RefCommodity;
//import com.crownagents.trips.reference.model.RefCommunityCode;
//import com.crownagents.trips.reference.model.RefCompanyType;
//import com.crownagents.trips.reference.model.RefComplianceActionType;
//import com.crownagents.trips.reference.model.RefComplianceType;
//import com.crownagents.trips.reference.model.RefComplianceUnitType;
//import com.crownagents.trips.reference.model.RefComputationBasis;
//import com.crownagents.trips.reference.model.RefComputationMethod;
//import com.crownagents.trips.reference.model.RefComputationType;
//import com.crownagents.trips.reference.model.RefConditionCode;
//import com.crownagents.trips.reference.model.RefConfigSet;
//import com.crownagents.trips.reference.model.RefConfigSetType;
//import com.crownagents.trips.reference.model.RefContMeasurements;
//import com.crownagents.trips.reference.model.RefContactMethod;
//import com.crownagents.trips.reference.model.RefContactMethodStatus;
//import com.crownagents.trips.reference.model.RefContainerOwner;
//import com.crownagents.trips.reference.model.RefContainerStatus;
//import com.crownagents.trips.reference.model.RefContainerType;
//import com.crownagents.trips.reference.model.RefCostType;
//import com.crownagents.trips.reference.model.RefCountry;
//import com.crownagents.trips.reference.model.RefCourtProcedType;
//import com.crownagents.trips.reference.model.RefCoverageType;
//import com.crownagents.trips.reference.model.RefCurrency;
//import com.crownagents.trips.reference.model.RefCustAuthDocType;
//import com.crownagents.trips.reference.model.RefCustControlPoint;
//import com.crownagents.trips.reference.model.RefCustDocType;
//import com.crownagents.trips.reference.model.RefCustLocation;
//import com.crownagents.trips.reference.model.RefCustProcedureType;
//import com.crownagents.trips.reference.model.RefCustProgress;
//import com.crownagents.trips.reference.model.RefCustTaxType;
//import com.crownagents.trips.reference.model.RefCustTranMode;
//import com.crownagents.trips.reference.model.RefCustTranType;
//import com.crownagents.trips.reference.model.RefCustomsAuditType;
//import com.crownagents.trips.reference.model.RefCustomsProcCode;
//import com.crownagents.trips.reference.model.RefCustomsRegime;
//import com.crownagents.trips.reference.model.RefDataSource;
//import com.crownagents.trips.reference.model.RefDataType;
//import com.crownagents.trips.reference.model.RefDateCategory;
//import com.crownagents.trips.reference.model.RefDateCfg;
//import com.crownagents.trips.reference.model.RefDateRecurCfg;
//import com.crownagents.trips.reference.model.RefDateSubCategory;
//import com.crownagents.trips.reference.model.RefDayType;
//import com.crownagents.trips.reference.model.RefDbColumnTypes;
//import com.crownagents.trips.reference.model.RefDebtActionType;
//import com.crownagents.trips.reference.model.RefDebtCategory;
//import com.crownagents.trips.reference.model.RefDebtPriorityTypes;
//import com.crownagents.trips.reference.model.RefDefermentPeriod;
//import com.crownagents.trips.reference.model.RefDefermentReason;
//import com.crownagents.trips.reference.model.RefDeliveryTerms;
//import com.crownagents.trips.reference.model.RefDetectionMethod;
//import com.crownagents.trips.reference.model.RefDfinRevCollInstrStatus;
//import com.crownagents.trips.reference.model.RefDfinRevCollInstrType;
//import com.crownagents.trips.reference.model.RefDishonouredReason;
//import com.crownagents.trips.reference.model.RefDisplayType;
//import com.crownagents.trips.reference.model.RefDistributionStatus;
//import com.crownagents.trips.reference.model.RefDistrict;
//import com.crownagents.trips.reference.model.RefDocCategory;
//import com.crownagents.trips.reference.model.RefDocDeliveryType;
//import com.crownagents.trips.reference.model.RefDocDestinationFormat;
//import com.crownagents.trips.reference.model.RefDocDestinationType;
//import com.crownagents.trips.reference.model.RefDocEvent;
//import com.crownagents.trips.reference.model.RefDocReport;
//import com.crownagents.trips.reference.model.RefDocStatus;
//import com.crownagents.trips.reference.model.RefDocType;
//import com.crownagents.trips.reference.model.RefDocTypeReturnTypeRel;
//import com.crownagents.trips.reference.model.RefDocumentChargeType;
//import com.crownagents.trips.reference.model.RefDocumentsProvided;
//import com.crownagents.trips.reference.model.RefDueInSpan;
//import com.crownagents.trips.reference.model.RefDuePeriod;
//import com.crownagents.trips.reference.model.RefEcrApplicationBasis;
//import com.crownagents.trips.reference.model.RefEcrCategory;
//import com.crownagents.trips.reference.model.RefEcrStatus;
//import com.crownagents.trips.reference.model.RefEmployment;
//import com.crownagents.trips.reference.model.RefEmploymentStatus;
//import com.crownagents.trips.reference.model.RefEngineCapacityUnits;
//import com.crownagents.trips.reference.model.RefEntAttType;
//import com.crownagents.trips.reference.model.RefEntRoleType;
//import com.crownagents.trips.reference.model.RefEntSiteType;
//import com.crownagents.trips.reference.model.RefEntityType;
//import com.crownagents.trips.reference.model.RefEntityTypeIndOROrg;
//import com.crownagents.trips.reference.model.RefEvaluationType;
//import com.crownagents.trips.reference.model.RefEvtCategories;
//import com.crownagents.trips.reference.model.RefEvtType;
//import com.crownagents.trips.reference.model.RefEvtTypeCat;
//import com.crownagents.trips.reference.model.RefExemAppStatus;
//import com.crownagents.trips.reference.model.RefExemptionLegalReferences;
//import com.crownagents.trips.reference.model.RefExemptionType;
//import com.crownagents.trips.reference.model.RefExemptionUsageType;
//import com.crownagents.trips.reference.model.RefFacilityType;
//import com.crownagents.trips.reference.model.RefFieldUsageType;
//import com.crownagents.trips.reference.model.RefFlexAttributeType;
//import com.crownagents.trips.reference.model.RefFlexFormTypeModeAttribute;
//import com.crownagents.trips.reference.model.RefFlexibleFormMode;
//import com.crownagents.trips.reference.model.RefFlexibleFormModeType;
//import com.crownagents.trips.reference.model.RefFlexibleReturnType;
//import com.crownagents.trips.reference.model.RefFlexibleTableName;
//import com.crownagents.trips.reference.model.RefFormMode;
//import com.crownagents.trips.reference.model.RefFormType;
//import com.crownagents.trips.reference.model.RefFrequency;
//import com.crownagents.trips.reference.model.RefFunctionCode;
//import com.crownagents.trips.reference.model.RefFunctionalRole;
//import com.crownagents.trips.reference.model.RefGender;
//import com.crownagents.trips.reference.model.RefGiftType;
//import com.crownagents.trips.reference.model.RefGoodsCondition;
//import com.crownagents.trips.reference.model.RefGoodsIdentMethod;
//import com.crownagents.trips.reference.model.RefGoodsTransferMethod;
//import com.crownagents.trips.reference.model.RefGroupCategory;
//import com.crownagents.trips.reference.model.RefGuaranteeAmountPerc;
//import com.crownagents.trips.reference.model.RefGuaranteeType;
//import com.crownagents.trips.reference.model.RefGuaranteeUsageType;
//import com.crownagents.trips.reference.model.RefHandlingOperations;
//import com.crownagents.trips.reference.model.RefIdentificationStatus;
//import com.crownagents.trips.reference.model.RefIdentifierType;
//import com.crownagents.trips.reference.model.RefIdentityCode;
//import com.crownagents.trips.reference.model.RefImportType;
//import com.crownagents.trips.reference.model.RefIncoTerms;
//import com.crownagents.trips.reference.model.RefIndividualBuild;
//import com.crownagents.trips.reference.model.RefIndividualCategory;
//import com.crownagents.trips.reference.model.RefIndividualRole;
//import com.crownagents.trips.reference.model.RefIndustClassification;
//import com.crownagents.trips.reference.model.RefInformationSource;
//import com.crownagents.trips.reference.model.RefInspAction;
//import com.crownagents.trips.reference.model.RefInspOutcome;
//import com.crownagents.trips.reference.model.RefInspStatus;
//import com.crownagents.trips.reference.model.RefInspType;
//import com.crownagents.trips.reference.model.RefInstCancelReason;
//import com.crownagents.trips.reference.model.RefInstOutcome;
//import com.crownagents.trips.reference.model.RefInstalmentAgreementStatus;
//import com.crownagents.trips.reference.model.RefInterestMethod;
//import com.crownagents.trips.reference.model.RefInventoryMethod;
//import com.crownagents.trips.reference.model.RefJobStream;
//import com.crownagents.trips.reference.model.RefLegalStatusType;
//import com.crownagents.trips.reference.model.RefLikelihood;
//import com.crownagents.trips.reference.model.RefLocationByCountry;
//import com.crownagents.trips.reference.model.RefLocationStatus;
//import com.crownagents.trips.reference.model.RefLocations;
//import com.crownagents.trips.reference.model.RefMachineType;
//import com.crownagents.trips.reference.model.RefManifestConsStatus;
//import com.crownagents.trips.reference.model.RefManifestConsType;
//import com.crownagents.trips.reference.model.RefManifestReconcRes;
//import com.crownagents.trips.reference.model.RefManifestSource;
//import com.crownagents.trips.reference.model.RefManifestStatus;
//import com.crownagents.trips.reference.model.RefManifestType;
//import com.crownagents.trips.reference.model.RefMaritalStatus;
//import com.crownagents.trips.reference.model.RefMeasurement;
//import com.crownagents.trips.reference.model.RefMeasurementUnits;
//import com.crownagents.trips.reference.model.RefMineralType;
//import com.crownagents.trips.reference.model.RefModeType;
//import com.crownagents.trips.reference.model.RefModules;
//import com.crownagents.trips.reference.model.RefMonthOfYear;
//import com.crownagents.trips.reference.model.RefNoteSubject;
//import com.crownagents.trips.reference.model.RefNoticeType;
//import com.crownagents.trips.reference.model.RefNotificationMethod;
//import com.crownagents.trips.reference.model.RefObjectionCategoryType;
//import com.crownagents.trips.reference.model.RefObjectionDecision;
//import com.crownagents.trips.reference.model.RefObjectionStatusType;
//import com.crownagents.trips.reference.model.RefObjectionType;
//import com.crownagents.trips.reference.model.RefOccPreciseCategory;
//import com.crownagents.trips.reference.model.RefOccupaClassification;
//import com.crownagents.trips.reference.model.RefOccupationCategory;
//import com.crownagents.trips.reference.model.RefOccupationStatus;
//import com.crownagents.trips.reference.model.RefOffenceOutcome;
//import com.crownagents.trips.reference.model.RefOffenceStatus;
//import com.crownagents.trips.reference.model.RefOffenceType;
//import com.crownagents.trips.reference.model.RefOffice;
//import com.crownagents.trips.reference.model.RefOfficeType;
//import com.crownagents.trips.reference.model.RefOfficerGrade;
//import com.crownagents.trips.reference.model.RefOfficerUnits;
//import com.crownagents.trips.reference.model.RefOfficers;
//import com.crownagents.trips.reference.model.RefOperandType;
//import com.crownagents.trips.reference.model.RefOrganisationRole;
//import com.crownagents.trips.reference.model.RefOwnershipType;
//import com.crownagents.trips.reference.model.RefPackageType;
//import com.crownagents.trips.reference.model.RefPaperConfig;
//import com.crownagents.trips.reference.model.RefParameterType;
//import com.crownagents.trips.reference.model.RefPayePosition;
//import com.crownagents.trips.reference.model.RefPaymentInstrument;
//import com.crownagents.trips.reference.model.RefPaymentMethod;
//import com.crownagents.trips.reference.model.RefPaymentNature;
//import com.crownagents.trips.reference.model.RefPaymentSource;
//import com.crownagents.trips.reference.model.RefPaymentSpread;
//import com.crownagents.trips.reference.model.RefPenaltyMethod;
//import com.crownagents.trips.reference.model.RefPeriodDueSpan;
//import com.crownagents.trips.reference.model.RefPort;
//import com.crownagents.trips.reference.model.RefPossibleAction;
//import com.crownagents.trips.reference.model.RefPossibleConditions;
//import com.crownagents.trips.reference.model.RefPremises;
//import com.crownagents.trips.reference.model.RefPrintStoreLocation;
//import com.crownagents.trips.reference.model.RefPrinterOptions;
//import com.crownagents.trips.reference.model.RefProductType;
//import com.crownagents.trips.reference.model.RefProfession;
//import com.crownagents.trips.reference.model.RefProfileSortCriteria;
//import com.crownagents.trips.reference.model.RefPropertyType;
//import com.crownagents.trips.reference.model.RefPropertyUse;
//import com.crownagents.trips.reference.model.RefPurposeOfTin;
//import com.crownagents.trips.reference.model.RefRateBasis;
//import com.crownagents.trips.reference.model.RefRateType;
//import com.crownagents.trips.reference.model.RefReason;
//import com.crownagents.trips.reference.model.RefReasonCategory;
//import com.crownagents.trips.reference.model.RefRefundClaimOriginator;
//import com.crownagents.trips.reference.model.RefRefundsStatus;
//import com.crownagents.trips.reference.model.RefRegimeDecision;
//import com.crownagents.trips.reference.model.RefRegimeProcesses;
//import com.crownagents.trips.reference.model.RefRegion;
//import com.crownagents.trips.reference.model.RefRegistrationSource;
//import com.crownagents.trips.reference.model.RefRelationshipStatus;
//import com.crownagents.trips.reference.model.RefRelationshipType;
//import com.crownagents.trips.reference.model.RefReportGroup;
//import com.crownagents.trips.reference.model.RefReportOutputType;
//import com.crownagents.trips.reference.model.RefReportParamType;
//import com.crownagents.trips.reference.model.RefReportParameterType;
//import com.crownagents.trips.reference.model.RefReportType;
//import com.crownagents.trips.reference.model.RefResidentType;
//import com.crownagents.trips.reference.model.RefReturnType;
//import com.crownagents.trips.reference.model.RefRevAccStatus;
//import com.crownagents.trips.reference.model.RefRevCollAgentType;
//import com.crownagents.trips.reference.model.RefRevCollectionAgent;
//import com.crownagents.trips.reference.model.RefRevCollectionRole;
//import com.crownagents.trips.reference.model.RefRevMode;
//import com.crownagents.trips.reference.model.RefRevSubType;
//import com.crownagents.trips.reference.model.RefRevType;
//import com.crownagents.trips.reference.model.RefReviewType;
//import com.crownagents.trips.reference.model.RefRiskCriteriaType;
//import com.crownagents.trips.reference.model.RefRiskIndicator;
//import com.crownagents.trips.reference.model.RefRiskLevel;
//import com.crownagents.trips.reference.model.RefRiskPoints;
//import com.crownagents.trips.reference.model.RefRiskScore;
//import com.crownagents.trips.reference.model.RefRiskType;
//import com.crownagents.trips.reference.model.RefRole;
//import com.crownagents.trips.reference.model.RefRouteIndicator;
//import com.crownagents.trips.reference.model.RefScale;
//import com.crownagents.trips.reference.model.RefSchedulableSet;
//import com.crownagents.trips.reference.model.RefSchemaType;
//import com.crownagents.trips.reference.model.RefScientificName;
//import com.crownagents.trips.reference.model.RefScrUsageType;
//import com.crownagents.trips.reference.model.RefSearchIds;
//import com.crownagents.trips.reference.model.RefSeizureReasons;
//import com.crownagents.trips.reference.model.RefSensitiveGoodsType;
//import com.crownagents.trips.reference.model.RefService;
//import com.crownagents.trips.reference.model.RefShippingLine;
//import com.crownagents.trips.reference.model.RefSortOrder;
//import com.crownagents.trips.reference.model.RefSourceReliability;
//import com.crownagents.trips.reference.model.RefStagger;
//import com.crownagents.trips.reference.model.RefStaggerSub;
//import com.crownagents.trips.reference.model.RefStatus;
//import com.crownagents.trips.reference.model.RefSubTaxCategory;
//import com.crownagents.trips.reference.model.RefSubTaxRateCategory;
//import com.crownagents.trips.reference.model.RefSuffix;
//import com.crownagents.trips.reference.model.RefSuspOutcome;
//import com.crownagents.trips.reference.model.RefSuspectReason;
//import com.crownagents.trips.reference.model.RefSuspectStatus;
//import com.crownagents.trips.reference.model.RefSuspicionReasons;
//import com.crownagents.trips.reference.model.RefSuspicionType;
//import com.crownagents.trips.reference.model.RefTarrifHead4;
//import com.crownagents.trips.reference.model.RefTarrifHead8;
//import com.crownagents.trips.reference.model.RefTarrifNumber;
//import com.crownagents.trips.reference.model.RefTaxAllocationType;
//import com.crownagents.trips.reference.model.RefTaxBandAllocationType;
//import com.crownagents.trips.reference.model.RefTaxBandSelectionMethod;
//import com.crownagents.trips.reference.model.RefTaxCalcSegment;
//import com.crownagents.trips.reference.model.RefTaxCalculationType;
//import com.crownagents.trips.reference.model.RefTaxCategoryLevel;
//import com.crownagents.trips.reference.model.RefTaxCycleDaysOfMonth;
//import com.crownagents.trips.reference.model.RefTaxHoliday;
//import com.crownagents.trips.reference.model.RefTaxRateType;
//import com.crownagents.trips.reference.model.RefTaxpayerType;
//import com.crownagents.trips.reference.model.RefTeam;
//import com.crownagents.trips.reference.model.RefTechEquipment;
//import com.crownagents.trips.reference.model.RefTempRemovAuthType;
//import com.crownagents.trips.reference.model.RefTitle;
//import com.crownagents.trips.reference.model.RefTrainType;
//import com.crownagents.trips.reference.model.RefTransactionClass;
//import com.crownagents.trips.reference.model.RefTransactionStatus;
//import com.crownagents.trips.reference.model.RefTransactionType;
//import com.crownagents.trips.reference.model.RefTransport;
//import com.crownagents.trips.reference.model.RefTripsModuleName;
//import com.crownagents.trips.reference.model.RefUserGroups;
//import com.crownagents.trips.reference.model.RefValuationMethod;
//import com.crownagents.trips.reference.model.RefValuationStatus;
//import com.crownagents.trips.reference.model.RefVehEngineCapacity;
//import com.crownagents.trips.reference.model.RefVehFuelType;
//import com.crownagents.trips.reference.model.RefVehType;
//import com.crownagents.trips.reference.model.RefVehUnit;
//import com.crownagents.trips.reference.model.RefVesselType;
//import com.crownagents.trips.reference.model.RefWarehouseAuthType;
//import com.crownagents.trips.reference.model.RefWarehouseType;
//import com.crownagents.trips.reference.model.RefWebService;
//import com.crownagents.trips.reference.model.RefWebServiceMethod;
//import com.crownagents.trips.reference.model.RefWfOperation;
//import com.crownagents.trips.reference.model.RefWithholdingType;
//import com.crownagents.trips.reference.model.TaxTaxType;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.reference.model.RefAccessLevel;
import com.technobrain.trips.reference.model.RefBusinessSector;
import com.technobrain.trips.reference.model.RefCompanyType;
import com.technobrain.trips.reference.model.RefCountry;
import com.technobrain.trips.reference.model.RefDistrict;
import com.technobrain.trips.reference.model.RefDocType;
import com.technobrain.trips.reference.model.RefEntSiteType;
import com.technobrain.trips.reference.model.RefEntityType;
import com.technobrain.trips.reference.model.RefFacilityType;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.reference.model.RefOffice;
import com.technobrain.trips.reference.model.RefPurposeOfTin;
import com.technobrain.trips.reference.model.RefReason;
import com.technobrain.trips.reference.model.RefRegion;
import com.technobrain.trips.reference.model.RefResidentType;
import com.technobrain.trips.reference.model.RefRevAccStatus;
import com.technobrain.trips.reference.model.RefRevType;
import com.technobrain.trips.reference.model.RefTaxCycleDaysOfMonth;
import com.technobrain.trips.reference.model.RefTransactionType;

import java.io.Serializable;


/**
 * @ Crown Agents
 *
 * @since	$Date: 2/8/2010 7:28:48 AM$
 * @version 	$Revision: 46$
 * @author 	$Author: Linesh Mali$
 *
 * $Log[1]:
 *  46   TRIPS2 etis.bir.gov.ph1.31.1.13   2/8/2010 7:28:48 AM    Linesh Mali
 *         Field Usage Type added
 * $
 */
public enum DataReference implements Serializable {
//    AIRCRAFT_STATUS(RefAircraftStatus.class),
//    AIRCRAFT_TYPE(RefAircraftType.class),
//    AIRLINE(RefAirline.class),
//    AIRLINE_STATUS(RefAirlineStatus.class),
//    ANALYST(RefAnalyst.class),
//    APPLICATION_INDICATOR(RefApplicationIndicator.class),
//    APPLICATION_ROLE(RefApplicationRole.class),
//    APPLICATION_ROLE_TYPE(RefApplicationRoleType.class),
//    APPLICATION_TYPE(RefApplicationType.class),
//    ASSESSMENT_TYPE(RefAssessmentType.class),
//    AUTHORISATION_TYPE(RefAuthorisationType.class),
//    AUDIT_LOG_TYPE(RefAuditLogType.class),
//    BATCH_FORM_TYPE(RefBatchFormType.class),
    BUSINESS_SECTOR(RefBusinessSector.class),
//    CARD_TYPE(RefCardType.class),
//    CASE_STATUS(RefCaseStatus.class),
//    CASE_DOC_STATUS(RefCaseDocStatus.class),
//    TRIPS_MODULE_NAME(RefTripsModuleName.class),
//    CASE_TYPE(RefCaseType.class),
//    LINKED_CASE_TYPE("obj.code<>'OBJECTION_AND_APPEAL'", RefCaseType.class),
//    CHEMICAL_NAME(RefChemicalName.class),
//    COLOURS(RefColours.class),
//    CHOICES(RefChoice.class),
//    COM_CODE(RefComCode.class),
//    COM_PROCEDURE(RefComProcedure.class),
//    COM_PT_PURPOSE(RefComPtPurpose.class),
//    COM_PT_TYPE(RefComPtType.class),
//    CONTAINER_TYPE(RefContainerType.class),
//    CONTAINER_STATUS(RefContainerStatus.class),
//    CONT_MEASUREMENTS(RefContMeasurements.class),
//    COMPUTATION_TYPE(RefComputationType.class),
//    COMPUTATION_METHOD(RefComputationMethod.class),
//    COMPLIANCE_TYPE(RefComplianceType.class),
//    NPORNF_COMPLIANCE_TYPE("obj.complianceCategory = 'NPORNF'",RefComplianceType.class),
//    COMPLIANCE_ACTION_TYPE(RefComplianceActionType.class),
//    COMPLIANCE_UNIT_TYPE(RefComplianceUnitType.class),
    COMPANY_TYPE(RefCompanyType.class),
//    COMMUNITY_CODE(RefCommunityCode.class),
//    COMMERCIAL_ACCOUNTS(RefCommercialAccounts.class),
    COUNTRY(RefCountry.class, "nationality"),
//    COUNTRY_DESC(RefCountry.class),
//    CUSTOMS_PROC_CODE(RefCustomsProcCode.class),
//    CUSTOMS_AUDIT_TYPE(RefCustomsAuditType.class),
//    CUST_TRAN_TYPE(RefCustTranType.class),
//    CUST_TRAN_MODE(RefCustTranMode.class),
//    CUST_TAX_TYPE(RefCustTaxType.class),
//    CUST_PROGRESS(RefCustProgress.class),
//    CUST_PROCEDURE_TYPE(RefCustProcedureType.class),
//    CUST_LOCATION(RefCustLocation.class),
//    CUST_DOC_TYPE(RefCustDocType.class),
//    CUST_CONTROL_POINT(RefCustControlPoint.class),
//    CUST_AUTH_DOC_TYPE(RefCustAuthDocType.class),
//    CURRENCY(RefCurrency.class),
//    COURT_PROCED_TYPE(RefCourtProcedType.class),
//    CUSTOMS_REGIME(RefCustomsRegime.class),
//    DATA_SOURCE(RefDataSource.class),
//    DEBT_ACTION_TYPE(RefDebtActionType.class),
//    DEBT_CATEGORY(RefDebtCategory.class),
//    DEBT_PRIORITY_TYPES(RefDebtPriorityTypes.class),
//    DEFERMENT_PERIOD(RefDefermentPeriod.class),
//    DEFERMENT_REASON(RefDefermentReason.class),
//    DELIVERY_TERMS(RefDeliveryTerms.class),
//    DETECTION_METHOD(RefDetectionMethod.class),
//    DOC_CATEGORY(RefDocCategory.class),
//    DOC_DELIVERY_TYPE(RefDocDeliveryType.class),
//    DOC_DESTINATION_FORMAT(RefDocDestinationFormat.class),
//    DOC_DESTINATION_TYPE(RefDocDestinationType.class),
//    DOC_REPORT(RefDocReport.class),
//    DOC_STATUS(RefDocStatus.class),
    DOC_TYPE(RefDocType.class),
//    PAYMENT_DOC_TYPE("obj.liabilityIndicator = 'Y'",RefDocType.class),
//    DOC_TYPE_NO_INSTAL_AGREEMENT("obj.liabilityIndicator = 'Y' and obj.code<>'INSTALMENT_AGREEMENT'",RefDocType.class),
//    CASE_RELATED_DOC_TYPE("obj.code<>'OFFICER_ASSESSMENT' and obj.refDocCategory.code <> 'REG'",RefDocType.class),
//    EMPLOYMENT(RefEmployment.class),
//    ENGINE_CAPACITY_UNITS(RefEngineCapacityUnits.class),
//    ENT_ATT_TYPE(RefEntAttType.class),
//    APP_ATT_TYPE(RefAppAttType.class),
//    REF_REL_TYPE(RefRelationshipType.class),
//    ENT_ROLE_TYPE(RefEntRoleType.class),
    ENT_SITE_TYPE(RefEntSiteType.class),
    ENTITY_TYPE(RefEntityType.class),
//    EVALUATION_TYPE(RefEvaluationType.class),
//    EXEMPTION_TYPE(RefExemptionType.class),
//    FUNCTIONAL_ROLE(RefFunctionalRole.class),
//    GENDER(RefGender.class),
//    GOODS_CONDITION(RefGoodsCondition.class),
//    GOODS_IDENT_METHOD(RefGoodsIdentMethod.class),
//    GOODS_TRANSFER_METHOD(RefGoodsTransferMethod.class),
//    GUARANTEE_AMOUNT_PERC(RefGuaranteeAmountPerc.class),
//    GUARANTEE_TYPE(RefGuaranteeType.class),
//    GUARANTEE_USAGE_TYPE(RefGuaranteeUsageType.class),
//    INSP_OUTCOME(RefInspOutcome.class),
//    INSP_STATUS(RefInspStatus.class),
//    INSP_ACTION(RefInspAction.class),
//    INSP_TYPE(RefInspType.class),
//    INFORMATION_SOURCE(RefInformationSource.class),
//    INDIVIDUAL_ROLE(RefIndividualRole.class),
//    INDIVIDUAL_BUILD(RefIndividualBuild.class),
//    INCO_TERMS(RefIncoTerms.class),
//    IDENTITY_CODE(RefIdentityCode.class),
//    IDENTIFIER_TYPE(RefIdentifierType.class),
//    IDENTIFICATION_STATUS(RefIdentificationStatus.class),
//    HANDLING_OPERATIONS(RefHandlingOperations.class),
//    INST_CANCEL_REASON(RefInstCancelReason.class),
//    INST_OUTCOME(RefInstOutcome.class),
//    INTEREST_METHOD(RefInterestMethod.class),
//    INVENTORY_METHOD(RefInventoryMethod.class),
    LEGAL_STATUS_TYPE(RefLegalStatusType.class),
//    LOCATIONS(RefLocations.class),
//    MANIFEST_CONS_STATUS(RefManifestConsStatus.class),
//    MANIFEST_CONS_TYPE(RefManifestConsType.class),
//    MANIFEST_RECONC_RES(RefManifestReconcRes.class),
//    MANIFEST_SOURCE(RefManifestSource.class),
//    MANIFEST_STATUS(RefManifestStatus.class),
//    MANIFEST_TYPE(RefManifestType.class),
//    MARITAL_STATUS(RefMaritalStatus.class),
//    MEASUREMENT(RefMeasurement.class),
//    MEASUREMENT_UNITS(RefMeasurementUnits.class),
//    MODULES(RefModules.class),
//    NOTIFICATION_METHOD(RefNotificationMethod.class),
//    OBJECTION_CATEGORY_TYPE(RefObjectionCategoryType.class),
//    OBJECTION_STATUS_TYPE(RefObjectionStatusType.class),
//    OBJECTION_TYPE(RefObjectionType.class),
//    OFFENCE_OUTCOME(RefOffenceOutcome.class),
//    OFFENCE_STATUS(RefOffenceStatus.class),
//    OFFENCE_TYPE(RefOffenceType.class),
    OFFICE(RefOffice.class),
//    REF_CONTACT_METHOD(RefContactMethod.class),
//    OFFICER_UNITS(RefOfficerUnits.class),
//    OFFICERS(RefOfficers.class),
//    OPERAND_TYPE(RefOperandType.class),
//    ORGANISATION_ROLE(RefOrganisationRole.class),
//    PACKAGE_TYPE(RefPackageType.class, "name"),
//    PAYE_POSITION(RefPayePosition.class),
//    PAYMENT_METHOD(RefPaymentMethod.class),
//    PAYMENT_SPREAD(RefPaymentSpread.class),    
//    PENALTY_METHOD(RefPenaltyMethod.class),
//    PORT(RefPort.class),
//    PREMISES(RefPremises.class),    
//    PROFESSION(RefProfession.class),
//    RATE_BASIS(RefRateBasis.class),
//    REASON(RefReason.class),
//    AMEND_REASON("obj.category.code='IND_AMENDMENT'",RefReason.class),
//    REASON_CATEGORY(RefReasonCategory.class),
    REGION(RefRegion.class),
//    REPORT_OUTPUT_TYPE(RefReportOutputType.class),
//    REPORT_PARAMETER_TYPE(RefReportParameterType.class),
    REV_ACC_STATUS(RefRevAccStatus.class),
//    REV_MODE(RefRevMode.class),
    REV_TYPE(RefRevType.class),
//    REF_RETURN_TYPE(RefReturnType.class),
//    REF_RETURN_TYPE_PERIODIC("obj.refRevMode.code = 'PER'",RefReturnType.class),
//    REF_DOC_RETURN_TYPE("obj.refDocCategory.code ='RET'",RefDocType.class),
//    RISK_LEVEL(RefRiskLevel.class),
//    RISK_SCORE(RefRiskScore.class),
//    RISK_TYPE(RefRiskType.class),
//    ROLE(RefRole.class),
//    ROUTE_INDICATOR(RefRouteIndicator.class),
//    SCIENTIFIC_NAME(RefScientificName.class),
//    SEIZURE_REASONS(RefSeizureReasons.class),
//    SENSITIVE_GOODS_TYPE(RefSensitiveGoodsType.class),
//    SHIPPING_LINE(RefShippingLine.class),
//    SOURCE_RELIABILITY(RefSourceReliability.class),
//    STAGGER(RefStagger.class),
//    STAGGER_WITHOUT_MULTIPLE("obj.code <> 'Multiple'",RefStagger.class),
//    STAGGER_SUB(RefStaggerSub.class),
//    STATUS(RefStatus.class),
//    STATUS_FOR_AUDIT("obj.code <> 'D'" , RefStatus.class),
    ACCESS_LEVEL(RefAccessLevel.class),
//    SUSP_OUTCOME(RefSuspOutcome.class),
//    SUSPECT_REASON(RefSuspectReason.class),
//    SUSPECT_STATUS(RefSuspectStatus.class),
//    SUSPICION_REASONS(RefSuspicionReasons.class),
//    SUSPICION_TYPE(RefSuspicionType.class),
//    TARRIF_HEAD_4(RefTarrifHead4.class),
//    TARRIF_HEAD_8(RefTarrifHead8.class),
//    TARRIF_NUMBER(RefTarrifNumber.class),
//    TAX_ALLOCATION_TYPE(RefTaxAllocationType.class),
//    TAX_BAND_ALLOCATION_TYPE(RefTaxBandAllocationType.class),
//    TAX_BAND_SELECTION_METHOD(RefTaxBandSelectionMethod.class),
//    TAX_CALC_SEGMENT(RefTaxCalcSegment.class),
//    TAX_CALCULATION_TYPE(RefTaxCalculationType.class),
//    TAXPAYER_TYPE(RefTaxpayerType.class),
//    INDIVIDUAL_CATEGORY(RefIndividualCategory.class),
//    TEAM(RefTeam.class),
//    TECH_EQUIPMENT(RefTechEquipment.class),
//    TEMP_REMOV_AUTH_TYPE(RefTempRemovAuthType.class),
//    TITLE(RefTitle.class),
//    TRAIN_TYPE(RefTrainType.class),
//    TRANSACTION_CLASS(RefTransactionClass.class),
      TRANSACTION_TYPE(RefTransactionType.class),
//    TRANSACTION_TYPE_OF_DEBIT("obj.accTran = 'DEBIT'" ,RefTransactionType.class),
//    TRANSPORT(RefTransport.class),
//    USER_GROUPS(RefUserGroups.class),
//    VALUATION_NETHOD(RefValuationMethod.class),
//    VALUATION_STATUS(RefValuationStatus.class),
//    VEH_ENGINE_CAPACITY(RefVehEngineCapacity.class),
//    VEH_FUEL_TYPE(RefVehFuelType.class),
//    VEH_TYPE(RefVehType.class),
//    VEH_UNIT(RefVehUnit.class),
//    VESSEL_TYPE(RefVesselType.class),
//    WAREHOUSE_AUTH_TYPE(RefWarehouseAuthType.class),
//    WAREHOUSE_TYPE(RefWarehouseType.class),
//    WF_OPERATION(RefWfOperation.class),
//    ATTRIBUTES(RefAttributes.class),
////    WF_WORKFLOW_CONDITION(WfWorkflowCondition.class),
////    MSG_TYPE(MsgType.class),
//    TAX_TAXTYPE(TaxTaxType.class),
//    BATCH_JOB_PARAM(RefBatchJobParam.class),
//    FORM_TYPE(RefFormType.class),
//    ASSOCIATION_TYPE(RefAssociationType.class),
//    ASSOCIATION_LEVEL(RefAssociationLevel.class),
//    ASSOCIATION_STATUS(RefAssociationStatus.class),
//    CONTACT_METHOD_STATUS(RefContactMethodStatus.class),
//    LOCATION_STATUS(RefLocationStatus.class),
//    DISPLAY_TYPE(RefDisplayType.class),
//    SCHEMA_TYPE(RefSchemaType.class),
//    BPELS(RefBpels.class),
//    SEARCH_IDS(RefSearchIds.class),
//    FLEXIBLE_FORM_MODES(RefFlexibleFormMode.class),
//    DOCUMENTS_PROVIDED(RefDocumentsProvided.class),
//    FLEX_ATTRIBUTE_TYPE(RefFlexAttributeType.class),
//    RELATIONSHIP_STATUS(RefRelationshipStatus.class),
//    BANK_ACCOUNT_STATUS(RefBankAccountStatus.class),
//    CARD_STATUS(RefCardStatus.class),
//    LOCATION_BY_COUNTRY(RefLocationByCountry.class),
//    COVERAGE_TYPE(RefCoverageType.class),
//    DOC_CATG_LIST(RefDocCategory.class),
//    ADDRESS_TYPE(RefAddressType.class),
    FACILITY_TYPE(RefFacilityType.class),
//    FLEXIBLE_RETURN_TYPE(RefFlexibleReturnType.class),
//    SUFFIX(RefSuffix.class),
    PURPOSE_OF_TIN(RefPurposeOfTin.class),
//    REGIME_PROCESSES(RefRegimeProcesses.class),
//    REGIME_DECISION(RefRegimeDecision.class),
//    CONTAINER_OWNER(RefContainerOwner.class),
//    PERMISSION_CATG(RefFacilityType.class),
//    TABLE_NAMES(RefFlexibleTableName.class),
//    DB_COLUMN_TYPES(RefDbColumnTypes.class),
//    INDUSTRIAL_CLASSIFICATION(RefIndustClassification.class),
//    BATCH_STATUS(RefBatchStatus.class),
//    FLEXIBLE_FORM_MODE_TYPE(RefFlexibleFormModeType.class),
//    FLEX_FORM_TYPE_MODE_ATTRIBUTE(RefFlexFormTypeModeAttribute.class),
//    OCCUPATIONAL_CLASSIFICATION(RefOccupaClassification.class),
//    COLLECTION_AGENT(RefRevCollectionAgent.class),
//    COLLECTION_AGENT_TYPE(RefRevCollAgentType.class),
//    PAYMENT_NATURE(RefPaymentNature.class),
//    TRANSACTION_STATUS(RefTransactionStatus.class),
//    REF_DATE_CATEGORY(RefDateCategory.class),
//    REF_DATE_SUB_CATEGORY(RefDateSubCategory.class),
//    REF_FLEX_FORMTYPE_MODE_ATT (RefFlexFormTypeModeAttribute.class),
//    FIELD_USAGE_TYPE(RefFieldUsageType.class),
//    REF_DATE_RECUR_CFG(RefDateRecurCfg.class),
//    TAX_TYPE("obj.refRevMode.code <> 'ENT'",RefRevType.class),
//    CONFIG_SET_TYPE(RefConfigSetType.class),
//    CONFIG_SET(RefConfigSet.class),
//    FORM_MODE(RefFormMode.class),
//    MODE_TYPE(RefModeType.class),
//    POSSIBLE_ACTION(RefPossibleAction.class),
//    REF_DATE_CFG(RefDateCfg.class),
//    REF_NOTICE_TYPE(RefNoticeType.class),
//    REF_OFFICE_TYPE(RefOfficeType.class),
//    JOB_STREAM(RefJobStream.class),
//    WEB_SERVICE(RefWebService.class),
//    WEB_SERVICE_METHOD(RefWebServiceMethod.class),
//    SCHEDULABLE_SET(RefSchedulableSet.class),
//    REF_LIKELIHOOD(RefLikelihood.class),
//    REF_FREQUENCY(RefFrequency.class),
//    DUE_IN_SPAN(RefDueInSpan.class),
//    DAY_TYPE(RefDayType.class),
//    DUE_PERIOD(RefDuePeriod.class),
//    REF_SCALE(RefScale.class),
//    SUB_TAX_TYPE(RefRevSubType.class),
//    REGIONS("obj.officeType = 'REGION'", RefOffice.class),
//    REF_EMPOYMENT_STATUS(RefEmploymentStatus.class),
//    REF_BOOK_OF_ACCT(RefBookOfAccountsType.class),
//    REF_MACHINE_TYPE(RefMachineType.class),
//    REF_FUNCTION_CODE(RefFunctionCode.class),
//    REF_CONDITION_CODE(RefConditionCode.class),
//    REF_USAGE_TYPE(RefScrUsageType.class),
//    REF_EVT_TYPE(RefEvtType.class),
//    REF_EVT_CATEGORIES(RefEvtCategories.class),
//    REF_EVT_TYPE_CAT(RefEvtTypeCat.class),
//    STATUS_NO_DELETED("obj.code <> 'D'",RefStatus.class),
//    REF_PROPERTY_TYPE(RefPropertyType.class),
//    REF_OWNERSHIP_TYPE(RefOwnershipType.class),
//    REF_NOTE_SUBJECT(RefNoteSubject.class),
//    REF_OCCUPATION_CATEGORY(RefOccupationCategory.class),
//    REF_OCC_PRECISE_CATEGORY(RefOccPreciseCategory.class),
//    REF_OCCUPATION_STATUS(RefOccupationStatus.class),
    REF_DISTRICT(RefDistrict.class),
//    BANK_NAME(RefBank.class),
//    REF_REV_ACC_STATUS(RefRevAccStatus.class),
//    BANK_BRANCH(RefBankBranch.class),
    REF_REASON(RefReason.class),
//    REF_PAYMENT_METHOD(RefPaymentMethod.class),
//    REF_PAYMENT_INSTRUMENT(RefPaymentInstrument.class),
//    REF_PAYMENT_INSTRUMENT_CHQ("obj.code ='CHQ'",RefPaymentInstrument.class),
//    REPORT_PARAM_TYPE(RefReportParamType.class),
//    REPORT_TYPES(RefReportType.class),
//    PAPER_CONFIG(RefPaperConfig.class),
//    PRINTER_OPTIONS(RefPrinterOptions.class),
//    REF_ADJUSTMENT_TYPE(RefAdjustmentType.class),
//    REF_ADJUSTMENT_REASON(RefAdjustmentReason.class),
//    REF_PAYMENT_SOURCE(RefPaymentSource.class),
//    PRINTER_STORE_LOCATION(RefPrintStoreLocation.class),
//    PARAMETER_TYPE(RefParameterType.class),
//    RECEIPT_STATUS(RefCollectionReceiptStatus.class),
//    ALLOCATION_TYPE(RefAllocationType.class),
//    POSSIBLE_CONDITIONS(RefPossibleConditions.class),
//    DISHONOURED_REASON(RefDishonouredReason.class),
//    PAYMENT_INSTRUMENT(RefPaymentInstrument.class),
//    REF_GENDER(RefGender.class),
//    DFIN_REV_COLL_INSTR_TYPE(RefDfinRevCollInstrType.class),
//    DFIN_REV_COLL_INSTR_STATUS(RefDfinRevCollInstrStatus.class),
//    REF_DISTRIBUTION_STATUS(RefDistributionStatus.class),
//    IMPORT_TYPE(RefImportType.class),
//    REV_COLL_ROLES(RefRevCollectionRole.class),
//    CASH_OFFICE_STATUS(RefCashOfficeStatus.class),    
//    CHARGE_TYPE(RefDocumentChargeType.class),
//    REF_MONTHOFYEAR(RefMonthOfYear.class),
//    BANDING_TYPE(RefBandingType.class),
//    RATE_TYPE(RefRateType.class),
//    TAX_RATE_TYPE(RefTaxRateType.class),
    REF_TAX_CYCLE_DAYS_OF_MONTH(RefTaxCycleDaysOfMonth.class),
//    REF_CASH_TILL_STATUS(RefCashTillStatus.class),
//    SUB_TAX_RATE_CATEGORY(RefSubTaxRateCategory.class),
//    SUB_TAX_CATEGORY(RefSubTaxCategory.class),
//    REF_EXEMPTION_TYPE(RefExemptionType.class),
//    REF_ECR_APPLICATION_BASIS(RefEcrApplicationBasis.class),
//    REF_ECR_CATEGORY(RefEcrCategory.class),
//    REF_ECR_STATUS(RefEcrStatus.class),
//    REF_CASE_STATUS(RefCaseStatus.class),
//    REF_CASE_STATUS_GENERAL("obj.caseCategory='GENERAL'",RefCaseStatus.class),
//    REF_CASE_STATUS_DEBT("obj.caseCategory='DEBT_MANAGEMENT' or obj.caseCategory='GENERAL'",RefCaseStatus.class),
//    REF_CASE_WORKING_STATUS(RefCaseWorkingStatus.class),
//    REF_AUDIT_VISIT_TYPE(RefAuditVisitType.class),
//    REF_CASE_OUTCOME(RefCaseOutcome.class),
//    REF_DEBT_CASE_OUTCOME("obj.caseType='DEBT_MANAGEMENT'",RefCaseOutcome.class),
//    CASE_OUTCOME(RefCaseOutcome.class),
//    REF_EXEMPTION_APP_STATUS(RefExemAppStatus.class),
//    INSTAL_AGREEMENTS_STATUS(RefInstalmentAgreementStatus.class),
//    REF_CANCELLATION_REASON(RefCancellationReason.class),
//    DOC_EVENT(RefDocEvent.class),
//    REFUNDS_STATUS(RefRefundsStatus.class),
//    COMPUTATION_BASIS(RefComputationBasis.class),
//    REF_DOC_CODE(RefDocTypeReturnTypeRel.class),
//    REF_EXEM_USAGE_TYPE(RefExemptionUsageType.class),
//    TAX_HOILDAY(RefTaxHoliday.class),
//    BANK_RATE_TYPE(RefBankRateType.class),
//    REF_OFFICER_GRADE(RefOfficerGrade.class),
//    RISK_CRITERIA_TYPE(RefRiskCriteriaType.class),
//    REF_RISK_POINTS(RefRiskPoints.class),
//    REF_AUDIT_VISIT_CASE_OUTCOME("obj.caseType='AUDIT_VISIT'",RefCaseOutcome.class),
//    REF_AUDIT_VISIT_CASE_TYPE("obj.caseCategory='AUDIT_AND_VISIT'",RefCaseType.class),
//    REF_DATA_TYPE(RefDataType.class),
//    REF_AUDIT_REPORT_DETAIL_TYPE(RefAuditReportDetailType.class),
//    AUDIT_REPORT_DETAIL_TYPE(RefAuditReportDetailType.class),
//    REF_PROFILE_SORT_CRITERIA(RefProfileSortCriteria.class),
//    REF_RISK_INDICATOR(RefRiskIndicator.class),
//    REF_AUDIT_PREP_DETAIL_TYPE(RefAuditprepDetailType.class),
//    REF_OBJECTION_DECISION(RefObjectionDecision.class),
//    REF_APPEAL_DECISION(RefAppealDecision.class),
//    REF_REVIEW_TYPE(RefReviewType.class),
//    REF_SUB_TAX_CATEGORY(RefSubTaxCategory.class),
//    REF_SUB_TAX_CATEGORY_1("obj.level='1'", RefSubTaxCategory.class),
//    REF_TAX_CATEGORY_LEVEL(RefTaxCategoryLevel.class),
//    REF_CASE_STATUS_OBA("obj.caseCategory='OBJECTION_AND_APPEAL'",RefCaseStatus.class),
//    REF_PERIOD_DUE_SPAN(RefPeriodDueSpan.class),
//    EXEMPTION_LEGAL_REFERENCES(RefExemptionLegalReferences.class), 
//    REPORT_GROUP(RefReportGroup.class),
//    REF_ENTITY_TYPE_INDORORG(RefEntityTypeIndOROrg.class),
//    REF_CASE_TYPE_GENERAL("obj.caseType='MANUALLY_CREATED' or obj.caseType='SYSTEM_GENERATED'",RefCaseType.class),
//    SYS_PARAMETERS(SystemParameters.class),
//    REF_CASE_TYPE(RefCaseType.class),
//    REF_REGISTRATION_SOURCE(RefRegistrationSource.class),
//    REF_SORT_ORDER(RefSortOrder.class),
//    REF_ATTACHMENT_TYPE(RefAttachmentType.class),
//    REF_REFUND_CLAIM_ORIGINATOR(RefRefundClaimOriginator.class),
//    TAX_TYPE_NO_RETURN_FALSE("obj.noReturnIndicator='F'", RefRevType.class),
//    REF_BUSINESS_SECTOR_CATEGORY(RefBusinessSectorCategory.class),
//    REF_BUSINESS_SECTOR_CLASS_CATEGORY("obj.category.code='CLASS'", 
//                                       RefBusinessSector.class),
//    ACCOUNTING_METHOD(RefAccountingMethod.class),
//    ASSET_TYPE(RefAssetType.class),
//    BUSINESS_LOCATION(RefBusinessLocation.class),
//    COMMODITY(RefCommodity.class),
//    COST_TYPE(RefCostType.class),
//    GIFT_TYPE(RefGiftType.class),
//    MINERAL_TYPE(RefMineralType.class),
//    PRODUCT_TYPE(RefProductType.class, "commodityCode"),
//    PROPERTY_USE(RefPropertyUse.class),
//    WITHHOLDING_TYPE(RefWithholdingType.class),
//    SERVICE(RefService.class),
//    ALLOCATION_METHOD(RefAllocationMethod.class),
//    GROUP_CATEGORY(RefGroupCategory.class),
    REF_RESIDENT_TYPE(RefResidentType.class);

    DataReference() {
    }
    
    <T extends BaseRefModelObject> DataReference(Class<T> _dataType,String _descriptionFieldName) {
        this.descriptionFieldName = _descriptionFieldName;
        this.dataType = _dataType;
    }
    
    <T extends BaseRefModelObject> DataReference(String condition, Class<T> _dataType) {
        this.condition = condition;
        this.dataType = _dataType;
        this.descriptionFieldName = "description";
    }

//    /**
//     * If this constructor is used, then descriptionfieldname is assumed to be
//     * "description".
//     * @param _dataType
//     */
    <T extends BaseRefModelObject> DataReference(Class<T> _dataType) {
        this.dataType = _dataType;
        this.descriptionFieldName = "description";
    }

    Class dataType;
    String descriptionFieldName;
    String condition;

    public String getCondition() {
        return this.condition;
    }

    public Class getDataType() {
        return dataType;
    }

    public String getDescriptionFieldName() {
        return descriptionFieldName;
    }
}
