package com.technobrain.trips.reference.service;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.reference.model.RefCurrency;
import com.technobrain.trips.security.model.SysUserLogin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import javax.sql.DataSource;


//import com.crownagents.trips.reference.model.RefAllocationType;
//import com.crownagents.trips.reference.model.RefApplicationType;
//import com.crownagents.trips.reference.model.RefBusinessSector;
//import com.crownagents.trips.reference.model.RefCfgRegime;
//import com.crownagents.trips.reference.model.RefComAgreementType;
//import com.crownagents.trips.reference.model.RefComCode;
//import com.crownagents.trips.reference.model.RefComCodeCategory;
//import com.crownagents.trips.reference.model.RefComProcedure;
//import com.crownagents.trips.reference.model.RefComPtPurpose;
//import com.crownagents.trips.reference.model.RefComPtType;
//import com.crownagents.trips.reference.model.RefComTreatment;
//import com.crownagents.trips.reference.model.RefCommercialAccounts;
//import com.crownagents.trips.reference.model.RefCommunityCode;
//import com.crownagents.trips.reference.model.RefComplianceType;
//import com.crownagents.trips.reference.model.RefContainerType;
//import com.crownagents.trips.reference.model.RefContractType;
//import com.crownagents.trips.reference.model.RefCountry;
//import com.crownagents.trips.reference.model.RefCurrency;
//import com.crownagents.trips.reference.model.RefCustCalcType;
//import com.crownagents.trips.reference.model.RefCustLocation;
//import com.crownagents.trips.reference.model.RefCustTaxBand;
//import com.crownagents.trips.reference.model.RefCustTaxType;
//import com.crownagents.trips.reference.model.RefCustTranMode;
//import com.crownagents.trips.reference.model.RefCustTranType;
//import com.crownagents.trips.reference.model.RefCustType;
//import com.crownagents.trips.reference.model.RefCustomsProcCode;
//import com.crownagents.trips.reference.model.RefCustomsRegime;
//import com.crownagents.trips.reference.model.RefDataSource;
//import com.crownagents.trips.reference.model.RefDayOfWeek;
//import com.crownagents.trips.reference.model.RefDefermentPeriod;
//import com.crownagents.trips.reference.model.RefDeliveryTerms;
//import com.crownagents.trips.reference.model.RefDocEvent;
//import com.crownagents.trips.reference.model.RefDocStatus;
//import com.crownagents.trips.reference.model.RefDocType;
//import com.crownagents.trips.reference.model.RefDocTypeReturnTypeRel;
//import com.crownagents.trips.reference.model.RefDocTypeTaxTypeRel;
//import com.crownagents.trips.reference.model.RefEmailFormatType;
//import com.crownagents.trips.reference.model.RefEntAttType;
//import com.crownagents.trips.reference.model.RefEntRoleType;
//import com.crownagents.trips.reference.model.RefEntSiteType;
//import com.crownagents.trips.reference.model.RefEntityType;
//import com.crownagents.trips.reference.model.RefGuaranteeType;
//import com.crownagents.trips.reference.model.RefIdentifierType;
//import com.crownagents.trips.reference.model.RefInspOutcome;
//import com.crownagents.trips.reference.model.RefInstOutcome;
//import com.crownagents.trips.reference.model.RefInterestRate;
//import com.crownagents.trips.reference.model.RefLegalStatusType;
//import com.crownagents.trips.reference.model.RefMaritalStatus;
//import com.crownagents.trips.reference.model.RefMeasurement;
//import com.crownagents.trips.reference.model.RefMonthOfYear;
//import com.crownagents.trips.reference.model.RefOffStaff;
//import com.crownagents.trips.reference.model.RefOffenceOutcome;
//import com.crownagents.trips.reference.model.RefOffice;
//import com.crownagents.trips.reference.model.RefOperandType;
//import com.crownagents.trips.reference.model.RefPaymentCard;
//import com.crownagents.trips.reference.model.RefPaymentMethod;
//import com.crownagents.trips.reference.model.RefPhoneLineType;
//import com.crownagents.trips.reference.model.RefPort;
//import com.crownagents.trips.reference.model.RefReason;
//import com.crownagents.trips.reference.model.RefRegion;
//import com.crownagents.trips.reference.model.RefRelationshipType;
//import com.crownagents.trips.reference.model.RefReportPrint;
//import com.crownagents.trips.reference.model.RefReturnType;
//import com.crownagents.trips.reference.model.RefRevAccRoleType;
//import com.crownagents.trips.reference.model.RefRevMode;
//import com.crownagents.trips.reference.model.RefRevType;
//import com.crownagents.trips.reference.model.RefStagger;
//import com.crownagents.trips.reference.model.RefStaggerSub;
//import com.crownagents.trips.reference.model.RefStatus;
//import com.crownagents.trips.reference.model.RefSubTaxCategory;
//import com.crownagents.trips.reference.model.RefTaskRole;
//import com.crownagents.trips.reference.model.RefTimezones;
//import com.crownagents.trips.reference.model.RefTitle;
//import com.crownagents.trips.reference.model.RefTranLinkType;
//import com.crownagents.trips.reference.model.RefTransactionClass;
//import com.crownagents.trips.reference.model.RefTransactionType;
//import com.crownagents.trips.reference.model.RefValuationMethod;
//import com.crownagents.trips.reference.model.RefVehFuelType;
//import com.crownagents.trips.reference.model.RefVehType;
//import com.crownagents.trips.reference.model.RefVehUnit;
//import com.crownagents.trips.reference.model.RefVisit;
//import com.crownagents.trips.reference.model.RefWebType;


@Stateless(name = "ReferenceFacade",mappedName="ReferenceFacade")
@Local
@Remote
public class ReferenceFacadeBean extends FacadeBean implements ReferenceFacadeLocal, ReferenceFacadeRemote {
     
    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;
    private HashMap jdbcColumnTypeNameMap = null;
    
    
    public ReferenceFacadeBean() {
    }

//    /** <code>select o from RefBusinessSector o</code> */
//    public List<RefBusinessSector> queryRefBusinessSectorFindAll() {
//        return em.createNamedQuery("RefBusinessSector.findAll").getResultList();
//    }
//
//    public void removeRefBusinessSector(RefBusinessSector refBusinessSector) {
//        refBusinessSector = 
//                em.find(RefBusinessSector.class, refBusinessSector.getCode());
//        em.remove(refBusinessSector);
//    }
//
//    /** <code>select o from RefCfgRegime o</code> */
//    public List<RefCfgRegime> queryRefCfgRegimeFindAll() {
//        return em.createNamedQuery("RefCfgRegime.findAll").getResultList();
//    }
//
//    public void removeRefCfgRegime(RefCfgRegime refCfgRegime) {
//        refCfgRegime = em.find(RefCfgRegime.class, refCfgRegime.getCode());
//        em.remove(refCfgRegime);
//    }
//
//    /** <code>select o from RefComplianceType o</code> */
//    public List<RefComplianceType> queryRefComplianceTypeFindAll() {
//        return em.createNamedQuery("RefComplianceType.findAll").getResultList();
//    }
//
//    /** <code>select o from RefCommunityCode o</code> */
//    public List<RefCommunityCode> queryRefCommunityCodeFindAll() {
//        return em.createNamedQuery("RefCommunityCode.findAll").getResultList();
//    }
//
//    public void removeRefCommunityCode(RefCommunityCode refCommunityCode) {
//        refCommunityCode = 
//                em.find(RefCommunityCode.class, refCommunityCode.getCode());
//        em.remove(refCommunityCode);
//    }
//
//    /** <code>select o from RefDataSource o</code> */
//    public List<RefDataSource> queryRefDataSourceFindAll() {
//        return em.createNamedQuery("RefDataSource.findAll").getResultList();
//    }
//
//    public void removeRefDataSource(RefDataSource refDataSource) {
//        refDataSource = em.find(RefDataSource.class, refDataSource.getCode());
//        em.remove(refDataSource);
//    }
//
//    public void removeRefComplianceType(RefComplianceType refComplianceType) {
//        refComplianceType = 
//                em.find(RefComplianceType.class, refComplianceType.getCode());
//        em.remove(refComplianceType);
//    }
//
//    /** <code>select o from RefComAgreementType o</code> */
//    public List<RefComAgreementType> queryRefComAgreementTypeFindAll() {
//        return em.createNamedQuery("RefComAgreementType.findAll").getResultList();
//    }
//
//    public void removeRefComAgreementType(RefComAgreementType refComAgreementType) {
//        refComAgreementType = 
//                em.find(RefComAgreementType.class, refComAgreementType.getCode());
//        em.remove(refComAgreementType);
//    }
//
//    /** <code>select o from RefComCode o</code> */
//    public List<RefComCode> queryRefComCodeFindAll() {
//        return em.createNamedQuery("RefComCode.findAll").getResultList();
//    }
//
//    public void removeRefComCode(RefComCode refComCode) {
//        refComCode = em.find(RefComCode.class, refComCode.getCode());
//        em.remove(refComCode);
//    }
//
//    /** <code>select o from RefComProcedure o</code> */
//    public List<RefComProcedure> queryRefComProcedureFindAll() {
//        return em.createNamedQuery("RefComProcedure.findAll").getResultList();
//    }
//
//    public void removeRefComProcedure(RefComProcedure refComProcedure) {
//        refComProcedure = 
//                em.find(RefComProcedure.class, refComProcedure.getCode());
//        em.remove(refComProcedure);
//    }
//
//    /** <code>select o from RefComPtPurpose o</code> */
//    public List<RefComPtPurpose> queryRefComPtPurposeFindAll() {
//        return em.createNamedQuery("RefComPtPurpose.findAll").getResultList();
//    }
//
//    public void removeRefComPtPurpose(RefComPtPurpose refComPtPurpose) {
//        refComPtPurpose = 
//                em.find(RefComPtPurpose.class, refComPtPurpose.getCode());
//        em.remove(refComPtPurpose);
//    }
//
//    /** <code>select o from RefComPtType o</code> */
//    public List<RefComPtType> queryRefComPtTypeFindAll() {
//        return em.createNamedQuery("RefComPtType.findAll").getResultList();
//    }
//
//    public void removeRefComPtType(RefComPtType refComPtType) {
//        refComPtType = em.find(RefComPtType.class, refComPtType.getCode());
//        em.remove(refComPtType);
//    }
//
//    /** <code>select o from RefComTreatment o</code> */
//    public List<RefComTreatment> queryRefComTreatmentFindAll() {
//        return em.createNamedQuery("RefComTreatment.findAll").getResultList();
//    }
//
//    public void removeRefComTreatment(RefComTreatment refComTreatment) {
//        refComTreatment = 
//                em.find(RefComTreatment.class, refComTreatment.getCode());
//        em.remove(refComTreatment);
//    }
//
//    /** <code>select o from RefContainerType o</code> */
//    public List<RefContainerType> queryRefContainerTypeFindAll() {
//        return em.createNamedQuery("RefContainerType.findAll").getResultList();
//    }
//
//    public void removeRefContainerType(RefContainerType refContainerType) {
//        refContainerType = 
//                em.find(RefContainerType.class, refContainerType.getCode());
//        em.remove(refContainerType);
//    }
//
//    /** <code>select o from RefContractType o</code> */
//    public List<RefContractType> queryRefContractTypeFindAll() {
//        return em.createNamedQuery("RefContractType.findAll").getResultList();
//    }
//
//    public void removeRefContractType(RefContractType refContractType) {
//        refContractType = em.find(RefContractType.class, null);
//        em.remove(refContractType);
//    }
//
//    /** <code>select o from RefCountry o</code> */
//    public List<RefCountry> queryRefCountryFindAll() {
//        return em.createNamedQuery("RefCountry.findAll").getResultList();
//    }
//
//    public void removeRefCountry(RefCountry refCountry) {
//        refCountry = em.find(RefCountry.class, refCountry.getCode());
//        em.remove(refCountry);
//    }
//
//    /** <code>select o from RefCurrency o</code> */
//    public List<RefCurrency> queryRefCurrencyFindAll() {
//        return em.createNamedQuery("RefCurrency.findAll").getResultList();
//    }
//
//    public void removeRefCurrency(RefCurrency refCurrency) {
//        refCurrency = em.find(RefCurrency.class, refCurrency.getCode());
//        em.remove(refCurrency);
//    }
//
//    /** <code>select o from RefCustomsProcCode o</code> */
//    public List<RefCustomsProcCode> queryRefCustomsProcCodeFindAll() {
//        return em.createNamedQuery("RefCustomsProcCode.findAll").getResultList();
//    }
//
//    public void removeRefCustomsProcCode(RefCustomsProcCode refCustomsProcCode) {
//        refCustomsProcCode = 
//                em.find(RefCustomsProcCode.class, refCustomsProcCode.getCode());
//        em.remove(refCustomsProcCode);
//    }
//
//    /** <code>select o from RefCustomsRegime o</code> */
//    public List<RefCustomsRegime> queryRefCustomsRegimeFindAll() {
//        return em.createNamedQuery("RefCustomsRegime.findAll").getResultList();
//    }
//
//    public void removeRefCustomsRegime(RefCustomsRegime refCustomsRegime) {
//        refCustomsRegime = 
//                em.find(RefCustomsRegime.class, refCustomsRegime.getCode());
//        em.remove(refCustomsRegime);
//    }
//
//
//    /** <code>select o from RefCustLocation o</code> */
//    public List<RefCustLocation> queryRefCustLocationFindAll() {
//        return em.createNamedQuery("RefCustLocation.findAll").getResultList();
//    }
//
//    public void removeRefCustLocation(RefCustLocation refCustLocation) {
//        refCustLocation = 
//                em.find(RefCustLocation.class, refCustLocation.getCode());
//        em.remove(refCustLocation);
//    }
//
//    /** <code>select o from RefCustTranMode o</code> */
//    public List<RefCustTranMode> queryRefCustTranModeFindAll() {
//        return em.createNamedQuery("RefCustTranMode.findAll").getResultList();
//    }
//
//    public RefCustTranMode queryRefCustTranModeFindByCode(String code) {
//        try {
//            return (RefCustTranMode)em.createQuery("select r from RefCustTranMode r where r.code = ?1").setParameter(1, 
//                                                                                                                     code).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }
//
//    public void removeRefCustTranMode(RefCustTranMode refCustTranMode) {
//        refCustTranMode = em.find(RefCustTranMode.class, null);
//        em.remove(refCustTranMode);
//    }
//
//    /** <code>select o from RefCustTranType o</code> */
//    public List<RefCustTranType> queryRefCustTranTypeFindAll() {
//        return em.createNamedQuery("RefCustTranType.findAll").getResultList();
//    }
//
//    public void removeRefCustTranType(RefCustTranType refCustTranType) {
//        refCustTranType = 
//                em.find(RefCustTranType.class, refCustTranType.getCode());
//        em.remove(refCustTranType);
//    }
//
//    /** <code>select o from RefCustType o</code> */
//    public List<RefCustType> queryRefCustTypeFindAll() {
//        return em.createNamedQuery("RefCustType.findAll").getResultList();
//    }
//
//    public void removeRefCustType(RefCustType refCustType) {
//        refCustType = em.find(RefCustType.class, refCustType.getCode());
//        em.remove(refCustType);
//    }
//
//    /** <code>select o from RefDefermentPeriod o</code> */
//    public List<RefDefermentPeriod> queryRefDefermentPeriodFindAll() {
//        return em.createNamedQuery("RefDefermentPeriod.findAll").getResultList();
//    }
//
//    public void removeRefDefermentPeriod(RefDefermentPeriod refDefermentPeriod) {
//        refDefermentPeriod = em.find(RefDefermentPeriod.class, null);
//        em.remove(refDefermentPeriod);
//    }
//
//    /** <code>select o from RefDeliveryTerms o</code> */
//    public List<RefDeliveryTerms> queryRefDeliveryTermsFindAll() {
//        return em.createNamedQuery("RefDeliveryTerms.findAll").getResultList();
//    }
//
//    public void removeRefDeliveryTerms(RefDeliveryTerms refDeliveryTerms) {
//        refDeliveryTerms = 
//                em.find(RefDeliveryTerms.class, refDeliveryTerms.getCode());
//        em.remove(refDeliveryTerms);
//    }
//
//    /** <code>select o from RefDocEvent o</code> */
//    public List<RefDocEvent> queryRefDocEventFindAll() {
//        return em.createNamedQuery("RefDocEvent.findAll").getResultList();
//    }
//
//    public void removeRefDocEvent(RefDocEvent refDocEvent) {
//        refDocEvent = em.find(RefDocEvent.class, refDocEvent.getCode());
//        em.remove(refDocEvent);
//    }
//
//    /** <code>select o from RefDocStatus o</code> */
//    public List<RefDocStatus> queryRefDocStatusFindAll() {
//        return em.createNamedQuery("RefDocStatus.findAll").getResultList();
//    }
//
//    public void removeRefDocStatus(RefDocStatus refDocStatus) {
//        refDocStatus = em.find(RefDocStatus.class, refDocStatus.getCode());
//        em.remove(refDocStatus);
//    }
//
//    /** <code>select o from RefDocType o</code> */
//    public List<RefDocType> queryRefDocTypeFindAll() {
//        return em.createNamedQuery("RefDocType.findAll").getResultList();
//    }
//
//    public void removeRefDocType(RefDocType refDocType) {
//        refDocType = em.find(RefDocType.class, refDocType.getCode());
//        em.remove(refDocType);
//    }
//
//    /** <code>select o from RefEmailFormatType o</code> */
//    public List<RefEmailFormatType> queryRefEmailFormatTypeFindAll() {
//        return em.createNamedQuery("RefEmailFormatType.findAll").getResultList();
//    }
//
//    public void removeRefEmailFormatType(RefEmailFormatType refEmailFormatType) {
//        refEmailFormatType = 
//                em.find(RefEmailFormatType.class, refEmailFormatType.getCode());
//        em.remove(refEmailFormatType);
//    }
//
//    /** <code>select o from RefEntityType o</code> */
//    public List<RefEntityType> queryRefEntityTypeFindAll() {
//        return em.createNamedQuery("RefEntityType.findAll").getResultList();
//    }
//
//    public void removeRefEntityType(RefEntityType refEntityType) {
//        refEntityType = em.find(RefEntityType.class, refEntityType.getCode());
//        em.remove(refEntityType);
//    }
//
//    /** <code>select o from RefEntRoleType o</code> */
//    public List<RefEntRoleType> queryRefEntRoleTypeFindAll() {
//        return em.createNamedQuery("RefEntRoleType.findAll").getResultList();
//    }
//
//    public void removeRefEntRoleType(RefEntRoleType refEntRoleType) {
//        refEntRoleType = 
//                em.find(RefEntRoleType.class, refEntRoleType.getCode());
//        em.remove(refEntRoleType);
//    }
//
//    /** <code>select o from RefEntSiteType o</code> */
//    public List<RefEntSiteType> queryRefEntSiteTypeFindAll() {
//        return em.createNamedQuery("RefEntSiteType.findAll").getResultList();
//    }
//
//    public void removeRefEntSiteType(RefEntSiteType refEntSiteType) {
//        refEntSiteType = 
//                em.find(RefEntSiteType.class, refEntSiteType.getCode());
//        em.remove(refEntSiteType);
//    }
//
//    /** <code>select o from RefGuaranteeType o</code> */
//    public List<RefGuaranteeType> queryRefGuaranteeTypeFindAll() {
//        return em.createNamedQuery("RefGuaranteeType.findAll").getResultList();
//    }
//
//    public void removeRefGuaranteeType(RefGuaranteeType refGuaranteeType) {
//        refGuaranteeType = 
//                em.find(RefGuaranteeType.class, refGuaranteeType.getCode());
//        em.remove(refGuaranteeType);
//    }
//
//    /** <code>select o from RefIdentifierType o</code> */
//    public List<RefIdentifierType> queryRefIdentifierTypeFindAll() {
//        return em.createNamedQuery("RefIdentifierType.findAll").getResultList();
//    }
//
//    public void removeRefIdentifierType(RefIdentifierType refIdentifierType) {
//        refIdentifierType = 
//                em.find(RefIdentifierType.class, refIdentifierType.getCode());
//        em.remove(refIdentifierType);
//    }
//
//    /** <code>select o from RefInspOutcome o</code> */
//    public List<RefInspOutcome> queryRefInspOutcomeFindAll() {
//        return em.createNamedQuery("RefInspOutcome.findAll").getResultList();
//    }
//
//    public void removeRefInspOutcome(RefInspOutcome refInspOutcome) {
//        refInspOutcome = 
//                em.find(RefInspOutcome.class, refInspOutcome.getCode());
//        em.remove(refInspOutcome);
//    }
//
//    /** <code>select o from RefInstOutcome o</code> */
//    public List<RefInstOutcome> queryRefInstOutcomeFindAll() {
//        return em.createNamedQuery("RefInstOutcome.findAll").getResultList();
//    }
//
//    public void removeRefInstOutcome(RefInstOutcome refInstOutcome) {
//        refInstOutcome = 
//                em.find(RefInstOutcome.class, refInstOutcome.getCode());
//        em.remove(refInstOutcome);
//    }
//
//    /** <code>select o from RefInterestRate o</code> */
//    public List<RefInterestRate> queryRefInterestRateFindAll() {
//        return em.createNamedQuery("RefInterestRate.findAll").getResultList();
//    }
//
//    public void removeRefInterestRate(RefInterestRate refInterestRate) {
//        refInterestRate = 
//                em.find(RefInterestRate.class, refInterestRate.getCode());
//        em.remove(refInterestRate);
//    }
//
//    /** <code>select o from RefLegalStatusType o</code> */
//    public List<RefLegalStatusType> queryRefLegalStatusTypeFindAll() {
//        return em.createNamedQuery("RefLegalStatusType.findAll").getResultList();
//    }
//
//    public void removeRefLegalStatusType(RefLegalStatusType refLegalStatusType) {
//        refLegalStatusType = 
//                em.find(RefLegalStatusType.class, refLegalStatusType.getCode());
//        em.remove(refLegalStatusType);
//    }
//
//    /** <code>select o from RefMaritalStatus o</code> */
//    public List<RefMaritalStatus> queryRefMaritalStatusFindAll() {
//        return em.createNamedQuery("RefMaritalStatus.findAll").getResultList();
//    }
//
//    public void removeRefMaritalStatus(RefMaritalStatus refMaritalStatus) {
//        refMaritalStatus = 
//                em.find(RefMaritalStatus.class, refMaritalStatus.getCode());
//        em.remove(refMaritalStatus);
//    }
//
//    /** <code>select o from RefMeasurement o</code> */
//    public List<RefMeasurement> queryRefMeasurementFindAll() {
//        return em.createNamedQuery("RefMeasurement.findAll").getResultList();
//    }
//
//    public void removeRefMeasurement(RefMeasurement refMeasurement) {
//        refMeasurement = 
//                em.find(RefMeasurement.class, refMeasurement.getCode());
//        em.remove(refMeasurement);
//    }
//
//    /** <code>select o from RefOffenceOutcome o</code> */
//    public List<RefOffenceOutcome> queryRefOffenceOutcomeFindAll() {
//        return em.createNamedQuery("RefOffenceOutcome.findAll").getResultList();
//    }
//
//    public void removeRefOffenceOutcome(RefOffenceOutcome refOffenceOutcome) {
//        refOffenceOutcome = 
//                em.find(RefOffenceOutcome.class, refOffenceOutcome.getCode());
//        em.remove(refOffenceOutcome);
//    }
//
//    /** <code>select o from RefOffice o</code> */
//    public List<RefOffice> queryRefOfficeFindAll() {
//        return em.createNamedQuery("RefOffice.findAll").getResultList();
//    }
//
//    public void removeRefOffice(RefOffice refOffice) {
//        refOffice = em.find(RefOffice.class, refOffice.getCode());
//        em.remove(refOffice);
//    }
//
//    /** <code>select o from RefPaymentCard o</code> */
//    public List<RefPaymentCard> queryRefPaymentCardFindAll() {
//        return em.createNamedQuery("RefPaymentCard.findAll").getResultList();
//    }
//
//    public void removeRefPaymentCard(RefPaymentCard refPaymentCard) {
//        refPaymentCard = 
//                em.find(RefPaymentCard.class, refPaymentCard.getCode());
//        em.remove(refPaymentCard);
//    }
//
//    /** <code>select o from RefPaymentMethod o</code> */
//    public List<RefPaymentMethod> queryRefPaymentMethodFindAll() {
//        return em.createNamedQuery("RefPaymentMethod.findAll").getResultList();
//    }
//
//    public void removeRefPaymentMethod(RefPaymentMethod refPaymentMethod) {
//        refPaymentMethod = 
//                em.find(RefPaymentMethod.class, refPaymentMethod.getCode());
//        em.remove(refPaymentMethod);
//    }
//
//    /** <code>select o from RefPhoneLineType o</code> */
//    public List<RefPhoneLineType> queryRefPhoneLineTypeFindAll() {
//        return em.createNamedQuery("RefPhoneLineType.findAll").getResultList();
//    }
//
//    public void removeRefPhoneLineType(RefPhoneLineType refPhoneLineType) {
//        refPhoneLineType = 
//                em.find(RefPhoneLineType.class, refPhoneLineType.getCode());
//        em.remove(refPhoneLineType);
//    }
//
//    /** <code>select o from RefPort o</code> */
//    public List<RefPort> queryRefPortFindAll() {
//        return em.createNamedQuery("RefPort.findAll").getResultList();
//    }
//
//    public void removeRefPort(RefPort refPort) {
//        refPort = em.find(RefPort.class, refPort.getCode());
//        em.remove(refPort);
//    }
//
//    /** <code>select o from RefReason o</code> */
//    public List<RefReason> queryRefReasonFindAll() {
//        return em.createNamedQuery("RefReason.findAll").getResultList();
//    }
//
//    public void removeRefReason(RefReason refReason) {
//        refReason = em.find(RefReason.class, refReason.getCode());
//        em.remove(refReason);
//    }
//
//    /** <code>select o from RefRegion o</code> */
//    public List<RefRegion> queryRefRegionFindAll() {
//        return em.createNamedQuery("RefRegion.findAll").getResultList();
//    }
//
//    public void removeRefRegion(RefRegion refRegion) {
//        refRegion = em.find(RefRegion.class, refRegion.getCode());
//        em.remove(refRegion);
//    }
//
//    /** <code>select o from RefRelationshipType o</code> */
//    public List<RefRelationshipType> queryRefRelationshipTypeFindAll() {
//        return em.createNamedQuery("RefRelationshipType.findAll").getResultList();
//    }
//
//    public void removeRefRelationshipType(RefRelationshipType refRelationshipType) {
//        refRelationshipType = 
//                em.find(RefRelationshipType.class, refRelationshipType.getCode());
//        em.remove(refRelationshipType);
//    }
//
//    /** <code>select o from RefRevAccRoleType o</code> */
//    public List<RefRevAccRoleType> queryRefRevAccRoleTypeFindAll() {
//        return em.createNamedQuery("RefRevAccRoleType.findAll").getResultList();
//    }
//
//    public void removeRefRevAccRoleType(RefRevAccRoleType refRevAccRoleType) {
//        refRevAccRoleType = 
//                em.find(RefRevAccRoleType.class, refRevAccRoleType.getCode());
//        em.remove(refRevAccRoleType);
//    }
//
//    /** <code>select o from RefRevMode o</code> */
//    public List<RefRevMode> queryRefRevModeFindAll() {
//        return em.createNamedQuery("RefRevMode.findAll").getResultList();
//    }
//
//    public void removeRefRevMode(RefRevMode refRevMode) {
//        refRevMode = em.find(RefRevMode.class, refRevMode.getCode());
//        em.remove(refRevMode);
//    }
//
//    /** <code>select o from RefRevType o</code> */
//    public List<RefRevType> queryRefRevTypeFindAll() {
//        return em.createNamedQuery("RefRevType.findAll").getResultList();
//    }
//
//    /** <code>select o from RefRevType o where code</code> */
//    public RefRevType queryRefRevTypeFindByCode(String code) {
//
//        Query qryRefRevType = null;
//        qryRefRevType = 
//                em.createQuery("select o from RefRevType o " + "where o.code = ?1").setParameter(1, 
//                                                                                                 code);
//        RefRevType refRevType = null;
//        try {
//            refRevType = (RefRevType)qryRefRevType.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//        }
//        return refRevType;
//    }
//
//    /** <code>select o from RefRevType o where code</code> */
//    public RefRevMode queryRefRevModeFindByCode(String code) {
//
//        Query qryRefRevMode = null;
//        qryRefRevMode = 
//                em.createQuery("select o from RefRevMode o " + "where o.code = ?1").setParameter(1, 
//                                                                                                 code);
//        RefRevMode refRevMode = null;
//        try {
//            refRevMode = (RefRevMode)qryRefRevMode.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//        }
//        return refRevMode;
//    }
//
//    public void removeRefRevType(RefRevType refRevType) {
//        refRevType = em.find(RefRevType.class, refRevType.getCode());
//        em.remove(refRevType);
//    }
//
//    /** <code>select o from RefStagger o</code> */
//    public List<RefStagger> queryRefStaggerFindAll() {
//        return em.createNamedQuery("RefStagger.findAll").getResultList();
//    }
//
//    public void removeRefStagger(RefStagger refStagger) {
//        refStagger = em.find(RefStagger.class, null);
//        em.remove(refStagger);
//    }
//
//    /** <code>select o from RefStaggerSub o</code> */
//    public List<RefStaggerSub> queryRefStaggerSubFindAll() {
//        return em.createNamedQuery("RefStaggerSub.findAll").getResultList();
//    }
//
//    public void removeRefStaggerSub(RefStaggerSub refStaggerSub) {
//        refStaggerSub = em.find(RefStaggerSub.class, null);
//        em.remove(refStaggerSub);
//    }
//
//    /** <code>select o from RefStatus o</code> */
//    public List<RefStatus> queryRefStatusFindAll() {
//        return em.createNamedQuery("RefStatus.findAll").getResultList();
//    }
//
//    public void removeRefStatus(RefStatus refStatus) {
//        refStatus = em.find(RefStatus.class, null);
//        em.remove(refStatus);
//    }
//
//    /** <code>select o from RefTimezones o</code> */
//    public List<RefTimezones> queryRefTimezonesFindAll() {
//        return em.createNamedQuery("RefTimezones.findAll").getResultList();
//    }
//
//    public void removeRefTimezones(RefTimezones refTimezones) {
//        refTimezones = em.find(RefTimezones.class, refTimezones.getCode());
//        em.remove(refTimezones);
//    }
//
//    /** <code>select o from RefTitle o</code> */
//    public List<RefTitle> queryRefTitleFindAll() {
//        return em.createNamedQuery("RefTitle.findAll").getResultList();
//    }
//
//    public void removeRefTitle(RefTitle refTitle) {
//        refTitle = em.find(RefTitle.class, refTitle.getCode());
//        em.remove(refTitle);
//    }
//
//    /** <code>select o from RefTransactionClass o</code> */
//    public List<RefTransactionClass> queryRefTransactionClassFindAll() {
//        return em.createNamedQuery("RefTransactionClass.findAll").getResultList();
//    }
//
//    public void removeRefTransactionClass(RefTransactionClass refTransactionClass) {
//        refTransactionClass = 
//                em.find(RefTransactionClass.class, refTransactionClass.getCode());
//        em.remove(refTransactionClass);
//    }
//
//    /** <code>select o from RefTransactionType o</code> */
//    public List<RefTransactionType> queryRefTransactionTypeFindAll() {
//        return em.createNamedQuery("RefTransactionType.findAll").getResultList();
//    }
//
//    public void removeRefTransactionType(RefTransactionType refTransactionType) {
//        refTransactionType = 
//                em.find(RefTransactionType.class, refTransactionType.getCode());
//        em.remove(refTransactionType);
//    }
//
//    /** <code>select o from RefTranLinkType o</code> */
//    public List<RefTranLinkType> queryRefTranLinkTypeFindAll() {
//        return em.createNamedQuery("RefTranLinkType.findAll").getResultList();
//    }
//
//    public void removeRefTranLinkType(RefTranLinkType refTranLinkType) {
//        refTranLinkType = 
//                em.find(RefTranLinkType.class, refTranLinkType.getCode());
//        em.remove(refTranLinkType);
//    }
//
//    /** <code>select o from RefValuationMethod o</code> */
//    public List<RefValuationMethod> queryRefValuationMethodFindAll() {
//        return em.createNamedQuery("RefValuationMethod.findAll").getResultList();
//    }
//
//    public void removeRefValuationMethod(RefValuationMethod refValuationMethod) {
//        refValuationMethod = 
//                em.find(RefValuationMethod.class, refValuationMethod.getCode());
//        em.remove(refValuationMethod);
//    }
//
//    /** <code>select o from RefVehFuelType o</code> */
//    public List<RefVehFuelType> queryRefVehFuelTypeFindAll() {
//        return em.createNamedQuery("RefVehFuelType.findAll").getResultList();
//    }
//
//    public void removeRefVehFuelType(RefVehFuelType refVehFuelType) {
//        refVehFuelType = em.find(RefVehFuelType.class, null);
//        em.remove(refVehFuelType);
//    }
//
//    /** <code>select o from RefVehType o</code> */
//    public List<RefVehType> queryRefVehTypeFindAll() {
//        return em.createNamedQuery("RefVehType.findAll").getResultList();
//    }
//
//    public void removeRefVehType(RefVehType refVehType) {
//        refVehType = em.find(RefVehType.class, null);
//        em.remove(refVehType);
//    }
//
//    /** <code>select o from RefVehUnit o</code> */
//    public List<RefVehUnit> queryRefVehUnitFindAll() {
//        return em.createNamedQuery("RefVehUnit.findAll").getResultList();
//    }
//
//    public void removeRefVehUnit(RefVehUnit refVehUnit) {
//        refVehUnit = em.find(RefVehUnit.class, null);
//        em.remove(refVehUnit);
//    }
//
//    /** <code>select o from RefVisit o</code> */
//    public List<RefVisit> queryRefVisitFindAll() {
//        return em.createNamedQuery("RefVisit.findAll").getResultList();
//    }
//
//    public void removeRefVisit(RefVisit refVisit) {
//        refVisit = em.find(RefVisit.class, refVisit.getCode());
//        em.remove(refVisit);
//    }
//
//    /** <code>select o from RefWebType o</code> */
//    public List<RefWebType> queryRefWebTypeFindAll() {
//        return em.createNamedQuery("RefWebType.findAll").getResultList();
//    }
//
//    public void removeRefWebType(RefWebType refWebType) {
//        refWebType = em.find(RefWebType.class, refWebType.getCode());
//        em.remove(refWebType);
//    }
//
//    /** <code>select o from RefCustCalcType o</code> */
//    public List<RefCustCalcType> queryRefCustCalcTypeFindAll() {
//        //        return em.createNamedQuery("RefCustCalcType.findAll").getResultList();
//        Query qry = 
//            em.createQuery("select o from RefCustCalcType o order by o.seq");
//        return qry.getResultList();
//    }
//
//    /** <code>select o from RefCustTaxType o</code> */
//    public List<RefCustTaxType> queryRefCustTaxTypeFindAll() {
//        return em.createNamedQuery("RefCustTaxType.findAll").getResultList();
//    }
//
//    /**
//     * Lookup for the list of reference commodity code entities by using 
//     * the input value of the code attribute
//     * 
//     * @param entity Object
//     * @param code Object
//     * @return refComCodeCategoryList List
//     */
//    public List<RefComCodeCategory> queryFindByComCode(Object entity, 
//                                                       Object code) {
//        String entityName = entity.getClass().getName();
//        entityName = entityName.substring(entityName.lastIndexOf(".") + 1);
//        Query qry = 
//            em.createQuery("select object(o) from " + entityName + " o where  o.comCode like :comCode");
//        qry.setParameter("comCode", code);
//        return qry.getResultList();
//    }
//
//    /**
//     * 
//     * @param taxType
//     * @param taxBand
//     * @return
//     */
//    public RefCustTaxBand getTaxRates(String taxType, String taxBand) {
//        Query qryTaxRates = null;
//        RefCustTaxBand refCustTaxBand = null;
//        qryTaxRates = 
//                em.createQuery("select o from RefCustTaxBand o " + "where o.refCustTaxType.code = ?1" + 
//                               "and o.taxBand = ?2").setParameter(1, 
//                                                                  taxType).setParameter(2, 
//                                                                                        taxBand);
//        try {
//            refCustTaxBand = (RefCustTaxBand)qryTaxRates.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//        }
//        return refCustTaxBand;
//    }
//
//    /**
//     * Lookup the tax band to use when calculating customs taxes. 
//     * @param commodity
//     * @param taxType
//     * @return
//     */
//    public String getTaxBand(String commodity, String taxType) {
//        Query qryTaxBand = null;
//        String result = null;
//        qryTaxBand = 
//                (Query)em.createQuery("select ct.band from RefComTaxes ct " + 
//                                      "where ct.commCode = ?1 " + 
//                                      "and ct.refCustTaxType.code = ?2").setParameter(1, 
//                                                                                      commodity).setParameter(2, 
//                                                                                                              taxType);
//        // return a result only if the object is not null                                   
//        try {
//            result = (String)qryTaxBand.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//        }
//        return result;
//    }
//
//    /**
//     * Lookup the commodityCategory when creating DeclarationItems.
//     * @param comCode
//     * @return
//     */
//    public String getCommodityCategory(String comCode) {
//        Query qryCommodityCategory = null;
//        String result = null;
//
//        qryCommodityCategory = 
//                (Query)em.createQuery("select cc.refComCategory from RefComCodeCategory cc " + 
//                                      "where cc.comCode = ?1 ").setParameter(1, 
//                                                                             comCode);
//
//        //return a result only if the object is not null
//        try {
//            result = (String)qryCommodityCategory.getSingleResult();
//        } catch (javax.persistence.NoResultException nre) {
//            return null;
//        }
//        return result;
//    }
//
//    /**
//     * Return the system parameter matching the input code, or null if not found. Have a look in the 
//     * override properties file first, then check the DB
//     * 
//     * @param code The code of the parameter to find
//     * @return The value, or null if not found
//     */
    public String getSystemParameter(String code) {
        // TODO (MS) Completely refactor this into helpers after DB
        //TODO (HH) added major change to be reviewed

        Object PARAMETER_VALUE = null;

        Context initCtx;
        try {
            initCtx = new InitialContext();
            Context myEnv = (Context)initCtx.lookup("java:comp/env");

            // configured by the Deployer.
            PARAMETER_VALUE = myEnv.lookup(code);
//            log.debug("code: " + code + 
//                               " returns -> PARAMETER_VALUE = " + 
//                               PARAMETER_VALUE);
        } catch (NamingException e) {
            //log.error(e.getLocalizedMessage(), e);
        }

        // If we've not returned anything from the properties file, have a look in the DB
        if (null != PARAMETER_VALUE && !PARAMETER_VALUE.equals(Constants.BLANK) ) {
            //do nothing
        }else{
            try{
                PARAMETER_VALUE = 
                        em.createQuery("select s.value from SystemParameters s where s.code = ?1").setParameter(1, 
                                                                                                                code).getSingleResult();
            }
            catch(NoResultException ex) {
                return null;
            }
        }

        return String.valueOf(PARAMETER_VALUE);

    }
    
//    
//    public boolean updateSystemParameter(String code, String newValue) {
//        int effectedRowCount = em.createQuery("update SystemParameters set value = ?1, updatedBy = ?2, updatedDate = ?3 where code = ?4")
//            .setParameter(1, newValue)
//            .setParameter(2, sessionContext.getCallerPrincipal().getName())
//            .setParameter(3, new Date())
//            .setParameter(4, code).executeUpdate();
//        if(effectedRowCount == 1){
//            return true;
//        } else {
//            return false;
//        }
//    }
//    
//    public String getJobParameter(String parameterName){
//        if (parameterName == null) return null;
//        try{
//            String toReturn = 
//                (String)em.createNamedQuery("JobParameters.findParameter").setParameter(1, parameterName).getSingleResult();
//            return toReturn;
//        }catch (javax.persistence.NoResultException e){
//            return null;
//        }
//    }
//
//    public List<PeriodDetail> findAllPeriods(String regimeType) {
//        try {
//            List<PeriodDetail> resultSet = 
//                em.createQuery("select new com.crownagents.trips.dto.tax.period.PeriodDetail(rp.revenueType," + 
//                               "rp.taxPeriod,rp.taxYear,rp.periodStart,rp.periodEnd,rp.periodDueDate,rp.paymentDueDate) " + 
//                               "from RevPeriodPool rp where rp.status = 'A' and rp.revenueType =?1 ").setParameter(1, 
//                                                                                                                  regimeType).getResultList();
//            return resultSet;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    /**
//     * This method makes query to Ref_Transaction_Type table by using Code and 
//     * Revenue_type as paramters. and returns RefTransactionType object.
//     * <br>
//     * @param documentType String
//     * @param taxType RefRevType
//     * @return refTransactionType  RefTransactionType
//     */
//    public RefTransactionType findTransactionTypeByDocumentAndTaxType(String documentType, 
//                                                                      String taxType) {
//        try {
//            Query qryTransactionType = 
//                em.createQuery("select object(o) from RefTransactionType o where " + 
//                               "o.code.code = :doctype " + 
//                               "and o.revType.code = :revtype");
//            qryTransactionType.setParameter("doctype", documentType);
//            qryTransactionType.setParameter("revtype", taxType);
//
//            return (RefTransactionType)qryTransactionType.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public boolean checkIfDuplicate (String tableName, String code, String description, String action) 
//            throws TripsDuplicateFoundException{
//        try {
//            String qry = "select object(o) from " + tableName + " o where " + 
//                               "o.code = :code " +  " or o.description = :description";
//            Query qryDuplicateCheck = em.createQuery(qry);
//            Object o = qryDuplicateCheck.setParameter("code", code)
//                                         .setParameter("description", description)
//                                         .getSingleResult();            
//            if (o == null) {
//                return false;
//            }
//            else if (action.equals(Constants.OperationType.CREATE_NEW)) {
//                return true;
//            }
//        } catch (javax.persistence.NoResultException e) {
//            return false;
//        } catch (NonUniqueResultException e) {
//            return true;
//        }
//        return false;
//    }
//
//
//    public <T extends BaseModelObject> T saveOrUpdate(T entity, String action) throws TripsDuplicateFoundException {
//           try {
//               int lastIndexOf = entity.getClass().getName().lastIndexOf(".");
//               String entityName = entity.getClass().getName().substring(lastIndexOf + 1);
//               Object value = null;
//               Serializable duplicate = null;
//               Field[] fields = entity.getClass().getDeclaredFields();
//               for (int i = 0; i < fields.length; i++) {
//                   Field field = fields[i];
//                   if (field.isAnnotationPresent(javax.persistence.Id.class)) {
//                       value = 
//                               ReflectionHelper.invokeGetter(entity, field.getName());
//                   }
//               }
//
////               if (action != null && action.equals(Constants.OperationType.CREATE_NEW)){
//               // if it is a new request check if we already have this is the system... if yes raise duplicate error
////                        duplicate = (Serializable)em.find(entity.getClass(), value);
//                        
//               if (action != null && !action.equals(Constants.OperationType.UPDATE)){
//                    String code = (String)ReflectionHelper.invokeGetter(entity, "code");
//                    String description = (String)ReflectionHelper.invokeGetter(entity, "description");
//                        
//                    if (code != null){
//                        
//                        if (checkIfDuplicate(entityName, code, description, action)) {
//                            throw new TripsDuplicateFoundException();
//                        }
//                    }            
//               }
//                   
//           } catch (javax.persistence.NoResultException e) {
//               log.error(e.getLocalizedMessage(), e);
//           } catch (NoSuchMethodException e) {
//               log.error(e.getLocalizedMessage(), e);
//           }
//        
//           
//           return super.saveOrUpdate(entity);
//       }
//
//    public RefCountry findCountryByPort(String portCode) {
//        try {
//            RefCountry country = 
//                (RefCountry)em.createNamedQuery("findRefCountryByPort").setParameter(1, 
//                                                                                     portCode).getSingleResult();
//
//            return country;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public RefOperandType getOperandTypeByCode(String code) {
//        try {
//            return (RefOperandType)em.createQuery("select o from RefOperandType o where o.code = ?1 ").setParameter(1, 
//                                                                                                                    code).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public RefCustTaxType getRefCustTaxType(String code) {
//        try {
//            return (RefCustTaxType)em.createQuery("select o from RefCustTaxType o where o.code = ?1 ").setParameter(1, 
//                                                                                                                    code).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
    public String getSystemParameterReport(String code) {
        Object PARAMETER_VALUE = null;
        try {
            PARAMETER_VALUE = 
                    em.createQuery("select s.value from SystemParameters s where s.code = ?1").setParameter(1, 
                                                                                                            code).getSingleResult();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return String.valueOf(PARAMETER_VALUE);

    }

//    /**
//     * Method gets report print information based on report name and office.
//     * @param reportInput
//     * @return
//     */
//    public RefReportPrint getReportPrint(ReportsInputType reportInput) {
//        return (RefReportPrint)em.createQuery("select Object(o) from RefReportPrint o where o.reportName=?1 and o.refOffice.code=?2").setParameter(1, 
//                                                                                                                             reportInput.getReportName()).setParameter(2, 
//                                                                                                                                                                       reportInput.getPrintOffice()).getSingleResult();
//    }
//    
//    public List<RefAllocationType> getAllocationTypes() {
//        return em.createNamedQuery("RefAllocationType.findAll").getResultList();
//    }
//    
////    public List<RefAllocationMethod> getAllocationMethod() {
////        return em.createNamedQuery("RefAllocationMethod.findAll").getResultList();
////    }    
//    
//    public String findAppIndicatorCodeByAppType(String appTypeCode) {
//        RefApplicationType appType = em.find(RefApplicationType.class, appTypeCode);
//        if(appType == null)
//            return null;
//        return appType.getAppIndicator();
//    }
//
//    public RefDocType findDocumentReport(String code) {
//        try {
//            return (RefDocType)em.createQuery("select o from RefDocType o where o.code = ?1").
//            setParameter(1,code).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    /**
//     * Checks if commercial account exist in the reference table. (without looking at the status or eff/exp dates.)
//     * @param code
//     * @return
//     */
//    public boolean checkCommercialAccountByCode(String code) {
//        RefCommercialAccounts comm = em.find(RefCommercialAccounts.class, code);
//        if(comm == null)
//            return false;
//        return true;
//    }
//
//    public List<RefDayOfWeek> queryRefDayOfWeekFindAll() {
//        return em.createNamedQuery("RefDayOfWeek.findAll").getResultList();
//    }
//    
//    public List<RefMonthOfYear> queryRefMonthOfYearFindAll() {
//        return em.createNamedQuery("RefMonthOfYear.findAll").getResultList();
//    }
//
    public DataSource getDataSource() {
        try {
            // prepare context:
            InitialContext context = new InitialContext();
            // retreive DB-source
            DataSource source = (javax.sql.DataSource) 
              context.lookup(getSystemParameter("TRIPS_DATASOURCE"));

            return source;
            
          } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
          }
          
          return null;
    }
 
//    public List<String> findOfficeForWorkstation(String workstationName) {
//        try {
//            return em.
//            createQuery("select o.code from RefOffice o join " +
//                        "o.officeWorkStations ou where ou.code = ?1 ")
//                        .setParameter(1,workstationName).getResultList();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public List<String> findUserOffice(String username) {
//        try {
//            return em.
//            createQuery("select o.code from RefOffice o join " +
//                        "o.officerUsers ou where UPPER(ou.username) = ?1 and ou.status = ?2 ")
//                        .setParameter(1,username.toUpperCase())
//                        .setParameter(2,Constants.RecordStatus.ACTIVE)
//                        .getResultList();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefOffStaff findOfficeStaff(String username){
//        try {
//            return (RefOffStaff) em.
//            createQuery("select o from RefOffStaff o " +
//                        "where UPPER(o.username) = ?1 and o.status = ?2 and (o.expiryDate is NULL or o.expiryDate >= CURRENT_TIMESTAMP)  ")
//                        .setParameter(1,username.toUpperCase())
//                        .setParameter(2,Constants.RecordStatus.ACTIVE)
//                        .getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public List<RefOffStaff> findAllOffStaff(){
//        return em.createNamedQuery("RefOffStaff.findAll").getResultList();
//    }
//    /**
//     * Finds a task role based on the requested action
//     * <br>
//     * This is used to install the task role because the task notification
//     * would fail indicating the task role was not found.
//     * @param requestAction
//     * @return
//     */
//    public RefTaskRole findRefTaskRoleByAction(String requestAction) {
//        try {
//            return (RefTaskRole) em.
//            createQuery("select o from RefTaskRole o " +
//                        "where o.requestedAction = ?1 ")
//                        .setParameter(1,requestAction).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public List<RefTaskRole> findAllTaskRoles() {
//        return em.createNamedQuery("RefTaskRole.findAll").getResultList();
//    }
//
//    public Serializable refresh(Serializable entitySaved) {
//        return (Serializable)em.getReference(entitySaved.getClass(),entitySaved);
//    }
//    
    public boolean isColumnThePrimaryKeyForTable(String tableName, String column) {
        
        if (tableName == null) return false;
        if (column == null) return false;
        
        try{
              Connection  con = getDataSource().getConnection();
              ResultSet rsColumns = null;
              // All TRIPS tables will have only one primary key still have option for multiples
              
              DatabaseMetaData meta = con.getMetaData();
              rsColumns = meta.getPrimaryKeys(null, null, tableName);
              while (rsColumns.next()) {
                if(column.equals(rsColumns.getString("COLUMN_NAME"))){
                    return true;
                }
              }
          }
          catch (Exception e){
            log.error(e.getLocalizedMessage(), e);
          }        
        return false;
    }    

//    public List<CodeAndDescription> findAllColumnsForTable(String tableName) {
//        List<CodeAndDescription> columnsList = new ArrayList<CodeAndDescription>();
//        
//        if (tableName == null) return columnsList;
//        
//        try{
//              Connection  con = getDataSource().getConnection();
//
//              ResultSet rsColumns = null;
//              DatabaseMetaData meta = con.getMetaData();
//              rsColumns = meta.getColumns(null, null, tableName, null);
//              while (rsColumns.next()) {
//                  CodeAndDescription item = new CodeAndDescription(rsColumns.getString("COLUMN_NAME"), rsColumns.getString("COLUMN_NAME"));
//                  columnsList.add(item);              
//              } 
//              
//              
//          }
//          catch (Exception e){
//            log.error(e.getLocalizedMessage(), e);
//          }        
//        return columnsList;
//    }    
//    
//    public FlexibleDBTableInputType getMetaDataForTable(String tableName) {
//        List<FlexibleDBColumnsInputType> columnsList = new ArrayList<FlexibleDBColumnsInputType>();
//        FlexibleDBTableInputType typeToReturn = new FlexibleDBTableInputType();
//        
//        if (tableName == null) return typeToReturn;
//        
//        typeToReturn.setTableName(tableName);
//        try{
//              List tableDetails = em.createNativeQuery("select * from user_tab_columns where table_name=?1").
//                                setParameter(1,tableName).getResultList();
//              
//              if(tableDetails != null){
//                  for(int i=0; i<tableDetails.size(); i++){
//                      FlexibleDBColumnsInputType item = new FlexibleDBColumnsInputType();
//                      Vector row = (Vector)tableDetails.get(i);
//                      if(row.get(1) != null)
//                          item.setColumnName(row.get(1).toString());   
//                      if(row.get(2) != null)
//                          item.setColumnType(row.get(2).toString());
//                      if(row.get(5) != null)
//                          item.setSize(Double.valueOf(row.get(5).toString()));                  
//                      if(row.get(7) != null)
//                          item.setScale(Double.valueOf(row.get(7).toString()));
//                      Boolean nullable = null;
//                      if(row.get(8) != null){
//                          if(row.get(8).toString().equalsIgnoreCase(Constants.YES)){
//                              nullable = true;
//                          }else{
//                              nullable = false;
//                          }
//                      }
//                      item.setNotNull(nullable);                  
//    
//                      columnsList.add(item);     
//                  }
//                  typeToReturn.setColumns(columnsList.toArray(new FlexibleDBColumnsInputType[columnsList.size()]));
//              }
//             
////              Connection  con = getDataSource().getConnection();
////
////              ResultSet rsColumns = null;
////              DatabaseMetaData meta = con.getMetaData();
////              rsColumns = meta.getColumns(null, null, tableName, null);
////              while (rsColumns.next()) {
////                  FlexibleDBColumnsInputType item = new FlexibleDBColumnsInputType();
////                  item.setColumnName(rsColumns.getString("COLUMN_NAME"));   
////                  String columnType = rsColumns.getString("TYPE_NAME");
////                  item.setColumnType(columnType);
////
////                  item.setSize(rsColumns.getDouble("COLUMN_SIZE"));                  
//////                  item.setScale(rsColumns.getDouble("DECIMAL_DIGITS"));
////                  item.setNotNull(rsColumns.getString("NULLABLE") != null && rsColumns.getString("NULLABLE").equals("Y"));                  
////
////                  columnsList.add(item);              
////              }        
////              typeToReturn.setColumns(columnsList.toArray(new FlexibleDBColumnsInputType[columnsList.size()]));
//          }
//          catch (Exception e){
//            log.error(e.getLocalizedMessage(), e);
//          }        
//        return typeToReturn;
//    }    
//
//
//
//    
//    public String createTable(FlexibleDBTableInputType flexibleDBTableInputType) {
//        final String SPACE = " ";
//        final String COMMA = ", ";
//        final String OPEN_BRACE = "(";
//        final String CLOSE_BRACE = ")";
//        if (flexibleDBTableInputType == null) return null;
//
//        String tableName = flexibleDBTableInputType.getTableName().toUpperCase();
//
//        try{
//                StringBuffer sql = new StringBuffer();
//                sql.append("CREATE TABLE " + tableName);
//                sql.append(OPEN_BRACE);
//                boolean isFirst = true;
//                  for (FlexibleDBColumnsInputType column : flexibleDBTableInputType.getColumns()){
//                     if(column != null){
//                        if(!isFirst) sql.append(COMMA);
//                        isFirst = false;
//                        
//                        sql.append(column.getColumnName()).append(SPACE);
//                        if (column.getColumnType().equals("VARCHAR2")){
//                            sql.append(column.getColumnType()).append(OPEN_BRACE).append(column.getSize()).append(CLOSE_BRACE);
//                        }else if (column.getColumnType().equals("NUMBER")){
//                            sql.append(column.getColumnType()).append(OPEN_BRACE).append(column.getSize()).append(",").append(column.getScale()).append(CLOSE_BRACE);                        
//                        }else  if (column.getColumnType().equals("DATE")){
//                            sql.append(column.getColumnType());
//                        }
//                        
//                        if (column.getNotNull()){
//                            sql.append(" NOT NULL ") ;                                               
//                        }
//                        
//                        if(column.getPrimaryKey()){
//                           sql.append(COMMA).append(" CONSTRAINT ");                          
//                           //TODO check the length of the primary key name formed and if more truncate
//                           sql.append(" PK_").append(tableName);
//                           sql.append(" PRIMARY KEY ").append(OPEN_BRACE).append(column.getColumnName()).append(CLOSE_BRACE);
//                        }
//                    }              
//                  }
//                sql.append(CLOSE_BRACE);
//              Connection  con = getDataSource().getConnection();
//              Statement st = con.createStatement();
//              int result = st.executeUpdate(sql.toString());
//              
//              // create sequence
//              sql = new StringBuffer();
//              sql.append("CREATE SEQUENCE " + tableName + "_SEQ");
//              boolean rel = st.execute(sql.toString());
//
//              // create entry in the reference table
//              sql = new StringBuffer();
//              sql.append("INSERT INTO REF_FLEXIBLE_TABLE_NAME (CODE, DESCRIPTION, STATUS) VALUES   ('" + tableName + "', '" + tableName + "', 'A')");
//              result = st.executeUpdate(sql.toString());
//              
//          }
//          catch (Exception e){
//            log.error(e.getLocalizedMessage(), e);
//              return e.getMessage();
//          }        
//        return "SUCCESS";
//    }     
//
//    public String getJdbcTypeName(int jdbcType) {
//        if (jdbcColumnTypeNameMap == null){
//               jdbcColumnTypeNameMap = new HashMap();
//               Field[] fields = java.sql.Types.class.getFields();
//               for (int i = 0; i < fields.length; i++) {
//                 try {
//                   String name = fields[i].getName();
//                   Integer value = (Integer) fields[i].get(null);
//                   jdbcColumnTypeNameMap.put(value, name);
//                 } catch (IllegalAccessException e) {
//                 
//                 }
//               }
//           }
//      return (String)jdbcColumnTypeNameMap.get( jdbcType );
//    }
//
    public String getDTypeForRecord(String tableName, String idColName, String dtypeColName, Long id){
        if (tableName == null) return null;
        String strToReturn = null;
        String sql = "SELECT " + dtypeColName +  " FROM " + tableName + " WHERE " + idColName + " = " + id;
        try{
              Connection  con = getDataSource().getConnection();
              
              PreparedStatement st = con.prepareStatement(sql);
                if(st.execute()){
                    ResultSet rsDType = st.getResultSet();
                    while (rsDType.next()){
                        strToReturn = rsDType.getString(1);                    
                    }
                }
          }
          catch (Exception e){
            log.error(e.getLocalizedMessage(), e);
          }        
        return strToReturn;
    }

    
//    public String formatTaxIdentificationNumber(String taxIdentificationNumber, String patternDigitCount, String patternSeparator, Integer numOfChars, String tinBranchSeparator ){
//        try{
//            //Retrieve System Parameters
//            //Get the TIN based on the specified number of characters
//            String tinCharacters = taxIdentificationNumber.substring(0, numOfChars);
//            //Get the remaining characters
//            String rem = taxIdentificationNumber.substring(numOfChars, taxIdentificationNumber.length());
//            //Create a new String to represent tin characters
//            String tin = new String(tinCharacters);
//            //Apply regular expression
//            tin = tin.replaceAll(patternDigitCount, patternSeparator);
//            //Generate formatted TIN
//            String formattedTin = "";
//            if(taxIdentificationNumber.length() > numOfChars){
//                formattedTin = tin + tinBranchSeparator + rem;
//            } else {
//                formattedTin = tin;
//            }
//            //Return formatted TIN
//            return formattedTin;
//        }catch(Exception ex){
//            log.error(ex.getLocalizedMessage(), ex);
//            return null;
//        }  
//    }
//
//    public String findLegalStatus(Long entityId) {
//        try {
//            return (String)em.createQuery("select o.legalStatus from EntEntity o where o.id = ?1").
//            setParameter(1,entityId).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//
//    public boolean hasReqSupportingDocuments(AttachmentType[] attachements, 
//                                          String formType) {
//        
//        if(null == formType){
//            return true;
//        }
//        
//        EntFormApp entityForm = null;
//        try {
//            entityForm = (EntFormApp)em.createQuery("select o from EntFormApp o where o.code = ?1").
//            setParameter(1,formType).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//           // log.error(e.getLocalizedMessage(), e);
//            return true;
//        }
//        
//       
//        if(null == attachements ){
//            if(null != entityForm && null != entityForm.getRequiredAttachments() 
//                && !entityForm.getRequiredAttachments().isEmpty()){
//                return false;
//            }            
//        }
//        
//        boolean found = false;
//        for(RefEntAttType refEntAttType:entityForm.getRequiredAttachments()){
//            found = false;
//            for(AttachmentType attachment:attachements){
//                if(attachment.getAttachmentType().equalsIgnoreCase(refEntAttType.getCode())){
//                    found = true;
//                }
//            }
//            
//            if(found == false){
//                return false;
//            }
//        }
//        
//        
//        return true;
//    }
//    
//    public String getListOfReqSupportingDocuments(AttachmentType[] attachements, 
//                                          String formType) {
//        
//        if(null == formType){
//            return null;
//        }
//        
//        EntFormApp entityForm = null;
//        try {
//            entityForm = (EntFormApp)em.createQuery("select o from EntFormApp o where o.code = ?1").
//            setParameter(1,formType).getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        
//        
//        
//        boolean found = false;
//        StringBuilder message =  new StringBuilder();
//        int index = 1;
//        for(RefEntAttType refEntAttType:entityForm.getRequiredAttachments()){
//            found = false;
//            
//            if(null != attachements)
//                for(AttachmentType attachment:attachements){
//                    if(attachment.getAttachmentType().equalsIgnoreCase(refEntAttType.getCode())){
//                        found = true;
//                    }
//                }
//            
//            if(found == false){
//                if(index == 1){
//                    message.append(refEntAttType.getDescription());
//                }else{
//                    
//                    if((index-1) < entityForm.getRequiredAttachments().size()){
//                        message.append(","); 
//                    }
//                    
//                    message.append(refEntAttType.getDescription()); 
//                    
//                }
//                index++;
//            }
//        }
//        
//        return message.toString();
//    }
//    
//    
    public void logNewUserSession(String sessionId, long createdTime,String userId,String ipAddress){
        SysUserLogin sul = new SysUserLogin();
        sul.setSessionid(sessionId);
        sul.setIsDba("FALSE");
        sul.setUserid(userId);
        sul.setLoginDatetime(new Timestamp(createdTime));
        sul.setStatus("A");
        sul.setAuthType("APP");
        sul.setMachine(ipAddress);
        em.persist(sul);
    }
    
    public void endSessionAtMachine(String ipAddress, String userId){
        try {
            List<SysUserLogin> suls = (List)em.createQuery("select sul from SysUserLogin sul where sul.machine <> ?1 " +
            "and sul.userid = ?2 and sul.status = 'A' ")
            .setParameter(1,ipAddress)
            .setParameter(2,userId)
            .getResultList();
            
            for(SysUserLogin sul:suls){
                        sul.setLogoutDatetime(new Timestamp(System.currentTimeMillis()));
                        sul.setStatus("T");
                        em.merge(sul);  
            }
        }
        catch (NoResultException e) {
           //do nothing
        }    
    }
    
    public int deleteOldUserSession(Date dateBefore){
//		String sql = "DELETE from SysUserLogin o WHERE o.loginDatetime < ?1 ";
//		Query query = em.createQuery(sql);
//		query.setParameter(1, dateBefore);
//		return query.executeUpdate();
        return 0;
    }

    public boolean hasAnotherSession(String userId, String ipaddress) {
        return false;
    }

    public SysUserLogin getOtherSession(String userId, String ipaddress) {
        return null;
    }

    public void logEndUserSession(String sessionID, long lastAccessedTime) {
    }

    public boolean isSessionTerminated(String string, String ipAddress) {
        return false;
    }
//    public String getDocTypeForReturnType(String returnType){
//        String docType = null;
//        List<RefDocTypeReturnTypeRel> docTypeList=null;
//        try {
//            docTypeList  = em.createNamedQuery("RefDocTypeReturnTypeRel.findByReturnType").
//            setParameter(1,returnType).getResultList();
//            if(docTypeList!=null && docTypeList.size()==1 ){
//                docType =docTypeList.get(0).getDocType();
//                return docType;
//            }else{
//                if(docTypeList!=null && docTypeList.size()>1){
//                    for(RefDocTypeReturnTypeRel refDocType : docTypeList){
//                        if(refDocType.getDocType().endsWith(Constants.DocumentType.PROVISIONAL))
//                            docType = refDocType.getDocType();
//                        return docType;
//                    }
//                }
//            }
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//        return docType;
//    }
//    
//    public String getReturnTypeByDocType(String docType) {
//            try {
//                 RefDocTypeReturnTypeRel refDocTypeReturnTypeRel  = (RefDocTypeReturnTypeRel)em.createNamedQuery("RefDocTypeReturnTypeRel.findByDocType").
//                   setParameter(1,docType).getSingleResult();
//                 return refDocTypeReturnTypeRel.getReturnType();
//             } catch (javax.persistence.NoResultException e) {
//                 return null;
//             }
//        }
//    public String getRefRevModeByDocType(String docType){
//        try {
//            String strQuery = "select refRevMode.code from RefReturnType retType,RefDocType rdocType,RefDocTypeReturnTypeRel docRetRel,RefRevMode refRevMode where rdocType.code = docRetRel.docType and docRetRel.returnType=retType.code and retType.refRevMode.code=refRevMode.code and rdocType.refDocCategory.code=?1 and rdocType.code=?2";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, Constants.AllocationMethods.REVENUE_TYPE);
//            query.setParameter(2, docType);
//            return (String)query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefSubTaxCategory getSubTaxCategoryCode(String description, String revTypeCode, Long level) {
//        try {
//            String strQuery = "select sub from RefSubTaxCategory sub " +
//                            "where sub.description=?1 and sub.revenueType=?2 and sub.level=?3";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, description);
//            query.setParameter(2, revTypeCode);
//            query.setParameter(3, level);
//            return (RefSubTaxCategory) query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefSubTaxCategory getSubTaxCategoryCodeByRevType(String code) {
//        try {
//            String strQuery = "select sub from RefSubTaxCategory sub " +
//                            "where sub.code=?1 and sub.revenueType='CIT'";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, code);
//            return (RefSubTaxCategory) query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefReturnType getReturnTypeByDescription(String description) {
//        try {
//            String strQuery = "select type from RefReturnType type where type.description=?1";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, description);
//            return (RefReturnType) query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefReturnType getReturnTypeByCode(String code) {
//        try {
//            String strQuery = "select type from RefReturnType type where type.code=?1";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, code);
//            return (RefReturnType) query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public String getResidentIndicatorByTin(String tin) {
//        try {
//            String strQuery = "select EI.residentIndicator from EntEntity EE,EntIndividual EI,RegTaxpayer rt,RegTaxpayerEntity rte WHERE EE.id = EI.id AND rte.entId = EE.id AND rt.id = rte.id AND rt.tin =?1";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, tin);
//            String resInd =  (String)query.getSingleResult();
//            if(resInd!=null && resInd.equalsIgnoreCase(Constants.TRUE)){
//                return Constants.YES;
//            }
//            else return Constants.NO;
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public RefDocTypeTaxTypeRel findRevenueTypeByDocType(String docType) {
//        RefDocTypeTaxTypeRel revType = null;
//        try {
//            revType = (RefDocTypeTaxTypeRel)em.createNamedQuery("RefDocTypeTaxTypeRel.findByDocType")
//                            .setParameter(1, docType).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//            return null;
//        }
//        return revType;
//    }
//    
//    public String getRefRevTypeByDocType(String docType){
//        try {
//            String strQuery = "select retType.refRevType from RefReturnType retType,RefDocType rdocType,RefDocTypeReturnTypeRel docRetRel where rdocType.code = docRetRel.docType and docRetRel.returnType=retType.code and rdocType.refDocCategory.code=?1 and rdocType.code=?2";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, Constants.AllocationMethods.REVENUE_TYPE);
//            query.setParameter(2, docType);
//            return (String)query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    
//    public RefReturnType getRefReturnTypeByDocType(String docType){
//        try {
//            String strQuery = "select retType from RefReturnType retType,RefDocType rdocType,RefDocTypeReturnTypeRel docRetRel where rdocType.code = docRetRel.docType and docRetRel.returnType=retType.code and rdocType.refDocCategory.code=?1 and rdocType.code=?2";
//            Query query = em.createQuery(strQuery);
//            query.setParameter(1, Constants.AllocationMethods.REVENUE_TYPE);
//            query.setParameter(2, docType);
//            return (RefReturnType)query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//            return null;
//        }
//    }
//    
//    public List<RefReturnType> findRegReturnTypesByRevenueType(Long entityId, String revenueType) {
//            List<RefReturnType> result = em.createQuery("select obj from RefReturnType obj, RegRevenueReturns rrr, RegTaxpayerRevenue rtr, RegTaxpayerEntity rte " +
//            "where rtr.id=rrr.regRevenueId.id and rte.id=rtr.id and obj.code=rrr.returnType and rte.registrationStatus='REG' " +
//            "and  rte.entId= ?1 and  rtr.revenueType= ?2 and obj.status = ?3 ")
//            .setParameter(1, entityId).setParameter(2, revenueType).setParameter(3, Constants.RecordStatus.ACTIVE).getResultList();
//            return result;                                                                                            
//        }
    
    public RefCurrency findRefCurrencyByCode(String code) {
        RefCurrency refCurr = em.find(RefCurrency.class, code);
        return refCurr;
    }
    

}
