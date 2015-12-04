package com.technobrain.trips.registration.service;

import com.technobrain.trips.account.service.AccountFacadeLocal;
import com.technobrain.trips.assembler.service.RefCodeAssemblerSessionEJBLocal;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;

import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.entity.model.EntTaxpayerTurnover;
import com.technobrain.trips.event.service.EventFacadeLocal;
import com.technobrain.trips.reference.service.ReferenceFacadeLocal;
import com.technobrain.trips.registration.messagehelper.TaxpayerRegistrationMessageHelper;
import com.technobrain.trips.registration.model.RegRevenueReturns;
import com.technobrain.trips.registration.model.RegTaxpayerEntity;
import com.technobrain.trips.registration.model.RegTaxpayerStatusView;
import com.technobrain.trips.core.message.AdditionalField;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.core.message.ReturnsInputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.registration.message.AccountOutputType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless(name = "RegTaxpayerFacade", mappedName = "RegTaxpayerFacade")
public class RegTaxpayerFacadeBean extends FacadeBean implements RegTaxpayerFacadeLocal, RegTaxpayerFacadeRemote {

    private static Log logger = LogFactory.getLog(RegTaxpayerFacadeBean.class);

    @PersistenceContext(unitName = "trips-ejb-module")
    private EntityManager em;
    @EJB
    EventFacadeLocal eventFacade;

    @EJB
    AccountFacadeLocal accountFacadeLocal;

    @EJB
    ReferenceFacadeLocal referenceFacade;

    public RegTaxpayerFacadeBean() {

    }

    public RegTaxpayerEntity persistRegisteredTaxpayer(RegTaxpayerEntity taxpayer) {
        RegTaxpayerEntity persistedTaxpayer = saveOrUpdate(taxpayer);
        return persistedTaxpayer;
    }

    public RegTaxpayerEntity persistRegisteredTaxpayer(InputType inputType) {
        return persistRegisteredTaxpayer((RegTaxpayerEntity) new TaxpayerRegistrationMessageHelper().setData(null, inputType));
    }

    public EntTaxpayerTurnover persistTaxpayerTurnover(EntTaxpayerTurnover taxpayerTurnover) {
        EntTaxpayerTurnover persistedTaxpayerTurnover = saveOrUpdate(taxpayerTurnover);
        return persistedTaxpayerTurnover;
    }

    public EntTaxpayerTurnover persistTaxpayerTurnover(InputType inputType) {
        TaxpayerRegistrationMessageHelper taxpayerRegistrationMessageHelper = new TaxpayerRegistrationMessageHelper();
        MessageHelper messageHelper = (TaxpayerRegistrationMessageHelper) initializeMessageHelper(TaxpayerRegistrationMessageHelper.class);
        taxpayerRegistrationMessageHelper.setEm(messageHelper.getEm());
        return persistTaxpayerTurnover((EntTaxpayerTurnover) taxpayerRegistrationMessageHelper.setTaxpayerTurnoverDataForRegime(null, inputType));
    }

    public RegRevenueReturns persistReturnType(InputType inputType, RegTaxpayerEntity entity) {
        TaxpayerRegistrationMessageHelper taxpayerRegistrationMessageHelper = new TaxpayerRegistrationMessageHelper();
        MessageHelper messageHelper = (TaxpayerRegistrationMessageHelper) initializeMessageHelper(TaxpayerRegistrationMessageHelper.class);
        taxpayerRegistrationMessageHelper.setEm(messageHelper.getEm());
        RegRevenueReturns regReveneuReturns = (RegRevenueReturns) taxpayerRegistrationMessageHelper.setRegRevenueReturnsDataForRegime(null, inputType);
        regReveneuReturns.setRegRevenueId(entity);
        return saveOrUpdate(regReveneuReturns);
    }

    public AccountOutputType registerAccountEntity(InputType inputType, String workflowType) {
        AccountOutputType output = new AccountOutputType();

        HashMap<Object, Object> additionalFieldMap = new HashMap<Object, Object>();
        additionalFieldMap.put(Constants.EventConstants.REGSTATUS, "REG");
        additionalFieldMap.put(Constants.EventConstants.CATEGORY, "REGISTRATION");

        RegTaxpayerEntity entity = (RegTaxpayerEntity) persistRegisteredTaxpayer(inputType);
        if (inputType instanceof RegimeAccountType) {
            RegimeAccountType regimeAccountType = (RegimeAccountType) inputType;
            if (regimeAccountType.getTaxableTurnoverAtRegistration() != null) {
                EntTaxpayerTurnover entityTurnover = (EntTaxpayerTurnover) persistTaxpayerTurnover(inputType);
            }
        }
        if (inputType instanceof RegimeAccountType) {
            RegimeAccountType regimeAccountType = (RegimeAccountType) inputType;
            if (regimeAccountType.getReturnTypes() != null && regimeAccountType.getReturnTypes().size() > 0) {
                List<ReturnsInputType> returnsInputType = regimeAccountType.getReturnTypes();

                List<RegRevenueReturns> lstRevReturns = em.createNamedQuery("RegRevenueReturns.findRegRevenueReturns").setParameter(1, entity.getId()).getResultList();
                if (lstRevReturns != null && lstRevReturns.size() > 0) {
                    for (RegRevenueReturns regReturnsObj : lstRevReturns) {
                        boolean updateFlag = true;
                        for (int i = 0; i < returnsInputType.size(); i++) {
                            if (regReturnsObj.getReturnType().equals(returnsInputType.get(i).getReturnTypeCode())) {
                                updateFlag = false;
                                break;
                            }
                        }
                        if (updateFlag) {
                            em.createNamedQuery("RegRevenueReturns.removeRevenueReturns").setParameter(1, entity.getId()).setParameter(2, regReturnsObj.getReturnType()).executeUpdate();
                        }
                    }
                }
                for (int i = 0; i < returnsInputType.size(); i++) {
                    returnsInputType.get(i).setRegTaxTypeId(entity.getId());
                    List<RegRevenueReturns> lstRets = em.createNamedQuery("RegRevenueReturns.findRegRevRetByRevIdandRet").setParameter(1, entity.getId()).setParameter(2, returnsInputType.get(i).getReturnTypeCode()).getResultList();
                    if (lstRets.isEmpty()) {
                        RegRevenueReturns regRevenueReturns = (RegRevenueReturns) persistReturnType(returnsInputType.get(i), entity);
                    }
                }
            }
        }

        if (inputType instanceof RegimeAccountType) {
            RegimeAccountType regType = (RegimeAccountType) inputType;
            if (null == regType.getEDR()) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                output.setEffectiveDateRegistration(cal);
            } else {
                output.setEffectiveDateRegistration(regType.getEDR());
            }
            output.setAccountNumber(regType.getRegimeNumber());
            output.setId(entity.getId());

            additionalFieldMap.put(Constants.EventConstants.ENTID, entity.getId());
            additionalFieldMap.put(Constants.EventConstants.WF_TYPE, workflowType);
            regType.getAdditionalFields().addAll(Arrays.asList(extractAndCreateAdditionalField(inputType, additionalFieldMap)));
            eventFacade.persistEvent("REVENUE", regType);

        } else if (inputType instanceof EntityAccountType) {
            EntityAccountType entType = (EntityAccountType) inputType;
            output.setEffectiveDateRegistration(entType.getEDR());
            output.setId(entity.getId());
            output.setAccountNumber(entType.getAccountNumber());

            additionalFieldMap.put(Constants.EventConstants.ENTID, entity.getId());
            additionalFieldMap.put(Constants.EventConstants.WF_TYPE, workflowType);
            entType.getAdditionalFields().addAll(Arrays.asList(extractAndCreateAdditionalField(inputType, additionalFieldMap)));
            eventFacade.persistEvent("TAXPAYER", entType);

        }

        additionalFieldMap.clear();

        output.setHasErrors(false);
        output.setHasWarnings(false);
        output.setHasMessages(false);
        output.setReturnStatus(Constants.PASS);

        return output;
    }

    private <T extends InputType> AdditionalField[] extractAndCreateAdditionalField(T inputType,
            HashMap<Object, Object> values) {
        List<AdditionalField> existing = inputType.getAdditionalFields();
        AdditionalField[] newOne
                = new AdditionalField[existing.size() + values.keySet().size()];
        int len = 0;
        if (values != null && !values.isEmpty()) {
            if (existing != null && !existing.isEmpty()) {
                len = existing.size();
                int count = -1;
                while (++count < len) {
                    newOne[count] = existing.get(count);
                }
            }
            for (Object key : values.keySet()) {
                AdditionalField addField = new AdditionalField();
                addField.setFieldName(key.toString());
                addField.setFieldValue(values.get(key));
                newOne[len++] = addField;
            }
            return newOne;
        } else {
            return existing.toArray(new AdditionalField[existing.size()]);
        }
    }

    @Override
    public RegTaxpayerStatusView findTaxpayerAccountByEntity(Long entityId) {
        Query query = em.createNamedQuery("RegTaxpayerStatusView.findTaxpayerAccountRegistration");
        query.setParameter(1, new Long(entityId));
        return (RegTaxpayerStatusView) query.getSingleResult();
    }

    @Override
    public List<RegTaxpayerStatusView> findAccountNumberByEntityAndRevenueType(Long entityId, String revenueType) {
        Query query = em.createNamedQuery("RegTaxpayerStatusView.findAccountByEntityAndRevenueType");
        query.setParameter(1, new Long(entityId));
        query.setParameter(2, revenueType);
        return query.getResultList();
    }

    public OutputType updateTaxpayerAccountId(Long taxpayerAccountId, Long registrationId) {
        OutputType output = new OutputType();

        Query query = em.createNamedQuery("RegTaxpayerEntity.updateTaxpayerAccountId");
        query.setParameter(1, taxpayerAccountId);
        query.setParameter(2, registrationId);
        query.executeUpdate();

        output.setId(registrationId);
        output.setHasErrors(false);
        output.setHasWarnings(false);
        output.setHasMessages(false);
        output.setReturnStatus(Constants.PASS);

        return output;
    }

    @Override
    public void updateAccountIdInDocument(Long accountId, Long documentId) {
        Query query = em.createNamedQuery("DdocDocument.updateAccountIdInDocument");
        query.setParameter(1, accountId);
        query.setParameter(2, documentId);
        query.executeUpdate();
    }

    private void validateRGD(OrganisationTaxpayerInputType orgRegMsg,
            ArrayList<SystemMessage> result) {
        SystemMessage systemMessage = null;
        String rgdNo = orgRegMsg.getOrganisationDetails().getCompanyRegNo();
        String legalStatus = orgRegMsg.getOrganisationDetails().getLegalStatus();
        Calendar bussRegDate = orgRegMsg.getOrganisationDetails().getCompanyRegDate();
        Calendar bussStartDate = orgRegMsg.getOrganisationDetails().getBusinessStartDate();
        Integer accountYearEndDay = orgRegMsg.getOrganisationDetails().getAccountYearEndDay();
        RefLegalStatusType refLegalStatus = null;
        if (legalStatus != null) {
            refLegalStatus = (RefLegalStatusType) queryFindByCode(
                    RefLegalStatusType.class, legalStatus);
        }

        if (!StringHelper.isNullOrEmptyString(rgdNo)) {
            if (rgdNo.length()
                    <= Constants.MandatoryFields.RGD_Length) {
                if (!StringHelper.isAlphaNumeric(rgdNo)) {
                    systemMessage = new SystemMessage();
                    systemMessage.setCode("RGD");
                    systemMessage.setMessage("Registration.msg.RGDAlphaNum");
                    result.add(systemMessage);
                }
            } else {
                systemMessage = new SystemMessage();
                systemMessage.setCode("RGD");
                systemMessage.setMessage("Registration.msg.RGDLength");
                result.add(systemMessage);
            }
        } else if (!StringHelper.isNullOrEmptyString(legalStatus)) {

            if (refLegalStatus != null) {
                if (rgdNo == null || (rgdNo != null && rgdNo.length() == 0)) { //RGD number mandatory check
                    systemMessage = new SystemMessage();
                    systemMessage.setCode("RGD No");
                    systemMessage.setMessage("Registration.msg.RGDRequiredForGivenLegalStatus");
                    result.add(systemMessage);
                }

            }
        }

        if (refLegalStatus != null) {
            if (bussRegDate == null) { //Date of Incorporation mandatory check
                systemMessage = new SystemMessage();
                systemMessage.setCode("Date of Incorporation");
                systemMessage.setMessage("Registration.msg.DateofIncorporationRequiredForGivenLegalStatus");
                result.add(systemMessage);
            }

            if (bussStartDate == null) { //Date of Commencement mandatory check
                systemMessage = new SystemMessage();
                systemMessage.setCode("Date of Commencement");
                systemMessage.setMessage("Registration.msg.DateofCommencementRequiredForGivenLegalStatus");
                result.add(systemMessage);
            }

            if (accountYearEndDay == null || (accountYearEndDay != null && accountYearEndDay.SIZE == 0)) { //Account Year End Day mandatory check
                systemMessage = new SystemMessage();
                systemMessage.setCode("Account Year End Day");
                systemMessage.setMessage("Registration.msg.AccountYearEndDayRequiredForGivenLegalStatus");
                result.add(systemMessage);
            }
        }
    }

    @Override
    public ArrayList<SystemMessage> validateRGDMandatoryFields(OrganisationTaxpayerInputType orgRegMsg) {
        ArrayList<SystemMessage> result = new ArrayList<>();
        validateRGD(orgRegMsg, result);
        return result;
    }

    @Override
    public RefLegalStatusType isRGDRegisterRequired(String legalStatus) {
        RefLegalStatusType result = null;
        try {

            result = (RefLegalStatusType) em.createNamedQuery("RefLegalStatusType.findLegalStatusObj").setParameter(1, legalStatus).getSingleResult();
        } catch (Exception nre) {
            log.error(nre.getLocalizedMessage(), nre);
            return null;
        }
        return result;
    }

}
