package com.technobrain.trips.entity.service;

import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.AddressType;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.core.message.ReturnsInputType;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.document.model.DdocDocumentRole;

import com.technobrain.trips.dto.HeaderSummaryDetail;

import com.technobrain.trips.entity.messagehelper.EntityMessageHelperNF;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.entity.model.EntIndividual;
import com.technobrain.trips.entity.model.EntLocation;
import com.technobrain.trips.entity.model.EntOrganization;
import com.technobrain.trips.entity.model.EntTaxpayerTurnover;
import com.technobrain.trips.registration.model.RegTaxpayerStatusView;
import com.technobrain.trips.registration.service.RegTaxpayerFacadeLocal;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import com.technobrain.trips.registration.model.RegRevenueReturns;
import com.technobrain.trips.registration.model.RegTaxpayerEntity;
import com.technobrain.trips.registration.model.RegTaxpayerRevenue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "EntityFacade", mappedName = "EntityFacade")
public class EntityFacadeBean extends FacadeBean implements EntityFacadeLocal, EntityFacadeRemote {

    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;

    @EJB
    RegTaxpayerFacadeLocal regTaxpayerFacade;

    @EJB
    RefCodeAssemblerSessionEJBLocal refCodeFacade;

    public EntityFacadeBean() {
    }

    public EntEntity getEntEntity(long entityId) {
        EntEntity entEntity = (EntEntity) em.createNamedQuery("EntEntity.findTaxpayerEntity").setParameter(1, entityId).getSingleResult();
        return entEntity;
    }

    public Serializable saveOrUpdateOrganisationEntity(OrganisationTaxpayerInputType orgTaxpayerInputType) {
        return saveOrUpdate(orgTaxpayerInputType, EntOrganization.class, EntityMessageHelperNF.class);
    }

    public String findRefDescription(String businessSectorCode, DataReference dataReference) {
        return refCodeFacade.findRefDescription(businessSectorCode,
                dataReference);
    }

    public HeaderSummaryDetail findHeaderDetails(Long primaryKey) {
        try {
            String entityType = (String) em.createQuery("select e.entityType from EntEntity e where e.id = ?1").setParameter(1, primaryKey).getSingleResult();
            HeaderSummaryDetail headerSummaryDetail = findHeaderDetails(entityType, primaryKey);
            headerSummaryDetail.setEntityType(entityType);
            return headerSummaryDetail;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }

    }

    public HeaderSummaryDetail findHeaderDetails(String entityType, Long primaryKey) {

        HeaderSummaryDetail resultSet = null;

        try {
            RegTaxpayerStatusView regTaxpayer = regTaxpayerFacade.findTaxpayerAccountByEntity(primaryKey);
            resultSet = new HeaderSummaryDetail();

            if (entityType.equalsIgnoreCase(Constants.Entity.INDIVIDUAL_TYPE)) {
                EntIndividual individual = (EntIndividual) em.createNamedQuery("EntIndividual.findIndividualById").
                        setParameter(1, primaryKey).getSingleResult();
                resultSet.setId(individual.getId());
                resultSet.setTitle(individual.getTitle());
                resultSet.setFirstName(individual.getFirstName());
                resultSet.setMiddleName(individual.getMiddleName());
                resultSet.setLastName(individual.getLastName());
                resultSet.setAccountNumber(regTaxpayer.getAccountNumber());
                resultSet.setTin(regTaxpayer.getTin());
                resultSet.setEntityOffice(regTaxpayer.getOffice());

                // 21/04/2011 - for de-registration reason dropdown (TRGHA-1333)
                resultSet.setLegalStatus(individual.getLegalStatus());
            }
            if (entityType.equalsIgnoreCase(Constants.Entity.ORGANIZATION_TYPE)) {
                EntOrganization organization = (EntOrganization) em.createNamedQuery("EntOrganization.findOrganizationById").
                        setParameter(1, primaryKey).getSingleResult();

                resultSet.setId(organization.getId());
                resultSet.setTitle(organization.getLegalName());
                resultSet.setLegalName(organization.getLegalName());
                resultSet.setLegalStatus(organization.getLegalStatus());
                resultSet.setTin(regTaxpayer.getTin());
                resultSet.setAccountNumber(regTaxpayer.getAccountNumber());
                resultSet.setEntityOffice(regTaxpayer.getOffice());
                if (regTaxpayer.getEntEntity().getEntTradingAsList().size() != 0) {
                    resultSet.setTradingName(regTaxpayer.getEntEntity().getEntTradingAsList().get(0).getName());
                }
            }
            resultSet.setEntityAccountId(regTaxpayer.getId());
            resultSet.setStatus(regTaxpayer.getCurrentStatus());
            resultSet.setDisplayStatus(regTaxpayer.getDisplayStatus());
            // set the relevant effective date
            //RC: Date of registration should be shown on the screen irrespective of the current status
            // if(regTaxpayer.getCurrentStatus().equalsIgnoreCase(Constants.AccountStatus.REGISTER))
            resultSet.setDateOfRegistration(regTaxpayer.getRegisteredDate());
            if (regTaxpayer.getCurrentStatus().equalsIgnoreCase(Constants.AccountStatus.DEREGISTER)) {
                resultSet.setDateOfDeRegistration(regTaxpayer.getEffectiveDate());
            }

        } catch (NoResultException e) {
            log.error("No records to retrieve");
        }
        return resultSet;
    }

    public String getAddressAsCSV(Long id) {
        if (id == null) {
            return null;
        }
        EntLocation address = em.find(EntLocation.class, id);
        EntityMessageHelperNF helper = new EntityMessageHelperNF();
        AddressType type = helper.getAddressType(address);
        type = includeAddressAsCSV(type);
        return type.getFilledAddressDetails();
    }

    public AddressType includeAddressAsCSV(AddressType addrType) {
        // The country description is retrieved.
        String nationality
                = refCodeFacade.findRefDescription(addrType.getCountry(),
                        DataReference.COUNTRY);
        String district
                = refCodeFacade.findRefDescription(addrType.getDistrict(),
                        DataReference.REF_DISTRICT);
        String postalRegion
                = refCodeFacade.findRefDescription(addrType.getPostalRegion(),
                        DataReference.REGION);
        // Concatenating the required Address fields.                                               
        String address
                = StringHelper.getEmptyIfNull(addrType.getHouseNumber()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getBuildingName()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getStreetName()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getCounty()) + ", "
                + StringHelper.getEmptyIfNull(nationality) + ", "
                + StringHelper.getEmptyIfNull(postalRegion) + ", "
                + StringHelper.getEmptyIfNull(district) + ", "
                + StringHelper.getEmptyIfNull(addrType.getMunicipality()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getProvince()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getPostalAddressPOBox()) + ", "
                + StringHelper.getEmptyIfNull(addrType.getPostOfficeLocation());
        // resulting String for trimming extra commas. 
        String addressForDisplay = StringHelper.trimCommas(address);
        addrType.setFilledAddressDetails(addressForDisplay);
        return addrType;
    }

    @Override
    public OrganisationTaxpayerInputType findOrganisationTaxpayerInputType(Long id) {
        MessageHelper helper = initializeEntityMessageHelper();
        OrganisationTaxpayerInputType orgMsgType = (OrganisationTaxpayerInputType) getInputType(id, EntOrganization.class, helper);

        if (orgMsgType != null) {
            List<RegTaxpayerStatusView> regView = (List<RegTaxpayerStatusView>) em.createNamedQuery("RegTaxpayerStatusView.findRevenueRegistrationByEntity").setParameter(1, id).getResultList();
            List<RegimeAccountType> accountType = findRegimeAccountType(regView, id);
            if (null != accountType) {
                orgMsgType.getRegimeAccount().addAll(accountType);
            }

            List<RegTaxpayerEntity> regEntity = (List<RegTaxpayerEntity>) em.createNamedQuery("RegTaxpayerEntity.findByEntityAndRegistrationType").setParameter(1, id).setParameter(2, "TAXPAYER").getResultList();
            if (regEntity != null && regEntity.size() == 1) {
                orgMsgType.getEntityApplication().setIssueOffice(regEntity.get(0).getOffice());
            }
        }
        return orgMsgType;
    }

    private List<RegimeAccountType> findRegimeAccountType(List<RegTaxpayerStatusView> regView, Long id) {
        byte count = 0;
        List<RegimeAccountType> accountType = new ArrayList<>(regView.size());
        for (RegTaxpayerStatusView item : regView) {
            RegimeAccountType rg = new RegimeAccountType();
            rg.setOwnerId(id);
            rg.setRevenueAcctStatus(item.getCurrentStatus());
            rg.setRevenueType(item.getRevenueType());
            rg.setEDR(DateHelper.getCalendar(item.getRegisteredDate()));
            rg.setId(item.getId());
            if (item.getTaxpayerAccountId() != null) {
                rg.setRevenueAccountID(item.getTaxpayerAccountId());
            }
            rg.setRegimeNumber(item.getAccountNumber());
            RegTaxpayerRevenue revenue = (RegTaxpayerRevenue) em.createNamedQuery("RegTaxpayerRevenue.findStaggerAndSubstagger").setParameter(1, item.getId()).getSingleResult();
            rg.setStagger(revenue.getStagger());
            rg.setSubStagger(revenue.getSubStagger());
            rg.setForcedRegistrationIndicator(StringHelper.getIndicatorAsBoolean(revenue.getForcedRegistrationInd()));
            rg.setEDS(DateHelper.getCalendar(revenue.getEds()));
            Query query = em.createNamedQuery("EntTaxpayerTurnover.findEntTaxpayerTurnoverByEntIDandTaxType");
            query.setParameter(1, id);
            query.setParameter(2, item.getRevenueType());
            List<EntTaxpayerTurnover> lst = query.getResultList();
            for (EntTaxpayerTurnover entTaxpayerTurnoverObj : lst) {
                if (entTaxpayerTurnoverObj.getEndDate() == null && entTaxpayerTurnoverObj.getTurnover() != null) {
                    rg.setTaxableTurnoverAtRegistration(new BigDecimal(entTaxpayerTurnoverObj.getTurnover()));
                }
            }
            Query queryReturns = em.createNamedQuery("RegRevenueReturns.findRegRevenueReturns");
            queryReturns.setParameter(1, item.getId());
            List<RegRevenueReturns> returnsLst = queryReturns.getResultList();
            if (returnsLst != null && returnsLst.size() > 0) {
                List<ReturnsInputType> returnInputTypeList = new ArrayList<>(returnsLst.size());
                for (int i = 0; i < returnsLst.size(); i++) {
                    RegRevenueReturns regRevRet = returnsLst.get(i);
                    ReturnsInputType returnsInputType = new ReturnsInputType();
                    returnsInputType.setReturnsId(regRevRet.getId());
                    returnsInputType.setReturnTypeCode(regRevRet.getReturnType());;
                    returnsInputType.setRegTaxTypeId(regRevRet.getRegRevenueId().getId());
                    returnInputTypeList.add(returnsInputType);
                }
                rg.getReturnTypes().addAll(returnInputTypeList);
            }
            /*if(lst.size() > 0){
                EntTaxpayerTurnover entTaxpayerTurnover = lst.get(0); 
                if(entTaxpayerTurnover.getTurnover()!=null && entTaxpayerTurnover.getEndDate() == null){
                    rg.setTaxableTurnoverAtRegistration(new BigDecimal(entTaxpayerTurnover.getTurnover()));
                }
             }*/
            accountType.add(rg);
        }

        return accountType;
    }

    private EntityMessageHelperNF initializeEntityMessageHelper() {
        MessageHelper helper = initializeMessageHelper(EntityMessageHelperNF.class);
        return (EntityMessageHelperNF) helper;
    }

    /**
     * Finds AppEntity by entity_id and d_type.
     *
     * @param entityId
     * @param dType
     * @return
     */
    @Override
    public List<AppEntity> findAppEntityByEntityIdAndDType(Long entityId, String dType) {
        List<AppEntity> appEntity
                = (List<AppEntity>) em.createNamedQuery("AppEntity.findByEntityIdAndDType").setParameter(1, entityId)
                .setParameter(2, dType).getResultList();
        if (appEntity != null && appEntity.size() > 0) {
            for (AppEntity appIter : appEntity) {
                List<DdocDocumentRole> docRoles
                        = (List<DdocDocumentRole>) em.createNamedQuery("DdocDocumentRole.findByDocId").setParameter(1, appIter.getId()).getResultList();
                if (docRoles != null && docRoles.size() > 0) {
                    appIter.setDocumentRoleList(docRoles);
                }
            }
        }
        return appEntity;
    }

}
