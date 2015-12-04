package com.technobrain.trips.registration.messagehelper;

import com.technobrain.trips.account.model.AccRevenueAccountVw;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.entity.model.EntTaxpayerTurnover;
import com.technobrain.trips.registration.model.RegRevenueReturns;
import com.technobrain.trips.registration.model.RegTaxpayer;
import com.technobrain.trips.registration.model.RegTaxpayerEntity;
import com.technobrain.trips.registration.model.RegTaxpayerRevenue;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.core.message.ReturnsInputType;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

public class TaxpayerRegistrationMessageHelper extends MessageHelper {

    /**
     * Converts applicable InputTypes into a RegTaxpayer.
     *
     * @param pojo pass an object if you want the data to be appended, or null
     * if you want a new object returned.
     * @param type the input type from which data will be extracted.
     * @return a RegTaxpayer object populated from the supplied InputType.
     */
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {

        return null;
    }

    public BaseModelObject setTaxpayerTurnoverDataForRegime(BaseModelObject pojo,
            InputType inputType) {
        long turnover = 0;
        long entityId = 0;
        String strRevenueType = null;
        boolean checkUpdate = false;

        EntTaxpayerTurnover entTaxpayerTurnover
                = (pojo == null) ? new EntTaxpayerTurnover()
                        : (EntTaxpayerTurnover) pojo;

        if (inputType instanceof RegimeAccountType) {
            RegimeAccountType regimeAccountType = (RegimeAccountType) inputType;
            turnover
                    = regimeAccountType.getTaxableTurnoverAtRegistration().longValue();
            entityId = regimeAccountType.getOwnerId();
            strRevenueType = regimeAccountType.getRevenueType();
            //List<EntTaxpayerTurnover> lst = regTaxpayerFacadefindEntTaxpayerTurnoverByEntIDandTaxType(entityId, strRevenueType);
            em = getEm();
            Query query
                    = em.createNamedQuery("EntTaxpayerTurnover.findEntTaxpayerTurnoverByEntIDandTaxType");
            query.setParameter(1, entityId);
            query.setParameter(2, strRevenueType);
            List<EntTaxpayerTurnover> lst = query.getResultList();

            for (EntTaxpayerTurnover entTaxpayerTurnoverObj : lst) {
                if (entTaxpayerTurnoverObj.getEndDate() == null
                        && entTaxpayerTurnoverObj.getTurnover().compareTo(turnover)
                        != 0) {
                    entTaxpayerTurnoverObj.setEndDate(new Timestamp((new Date()).getTime()));
                    entTaxpayerTurnoverObj.setId(entTaxpayerTurnoverObj.getId());
                    checkUpdate = true;
                }
            }

            if (lst.size() == 0) {
                entTaxpayerTurnover.setTurnoverType(Constants.EntTaxpayerTurnoverRefData.TURNOVER_TYPE_TAX_TO);
                entTaxpayerTurnover.setTurnover(turnover);
                entTaxpayerTurnover.setStartDate(new Timestamp((new Date()).getTime()));
                entTaxpayerTurnover.setEndDate(null);
                EntEntity entEntity = new EntEntity();
                entEntity.setId(entityId);
                entTaxpayerTurnover.setEntEntity(entEntity);
                entTaxpayerTurnover.setTaxType(strRevenueType);
            }
        }

        if (checkUpdate) {
            entTaxpayerTurnover.setTurnoverType(Constants.EntTaxpayerTurnoverRefData.TURNOVER_TYPE_TAX_TO);
            entTaxpayerTurnover.setTurnover(turnover);
            entTaxpayerTurnover.setStartDate(new Timestamp((new Date()).getTime()));
            entTaxpayerTurnover.setEndDate(null);
            EntEntity entEntity = new EntEntity();
            entEntity.setId(entityId);
            entTaxpayerTurnover.setEntEntity(entEntity);
            entTaxpayerTurnover.setTaxType(strRevenueType);
        }
        return entTaxpayerTurnover;
    }

    public BaseModelObject setRegRevenueReturnsDataForRegime(BaseModelObject pojo,
            InputType inputType) {
        String strRevenueType = null;
        boolean checkUpdate = false;

        RegRevenueReturns regRevenueReturns
                = (pojo == null) ? new RegRevenueReturns()
                        : (RegRevenueReturns) pojo;

        if (inputType instanceof ReturnsInputType) {
            ReturnsInputType returnsInputType = (ReturnsInputType) inputType;
            //turnover = 
            //      regimeAccountType.getTaxableTurnoverAtRegistration().longValue();
            //entityId = regimeAccountType.getOwnerId();
            //strRevenueType = regimeAccountType.getRevenueType();
            //List<EntTaxpayerTurnover> lst = regTaxpayerFacadefindEntTaxpayerTurnoverByEntIDandTaxType(entityId, strRevenueType);
            /* em = getEm();
            Query query = 
                em.createNamedQuery("EntTaxpayerTurnover.findEntTaxpayerTurnoverByEntIDandTaxType");
            query.setParameter(1, entityId);
            query.setParameter(2, strRevenueType);
            List<EntTaxpayerTurnover> lst = query.getResultList();

            for (EntTaxpayerTurnover entTaxpayerTurnoverObj: lst) {
                if (entTaxpayerTurnoverObj.getEndDate() == null && 
                    entTaxpayerTurnoverObj.getTurnover().compareTo(turnover) != 
                    0) {
                    entTaxpayerTurnoverObj.setEndDate(new Timestamp((new Date()).getTime()));
                    entTaxpayerTurnoverObj.setId(entTaxpayerTurnoverObj.getId());
                    checkUpdate = true;
                }
            }*/

            //if (lst.size() == 0) {
            regRevenueReturns.setReturnType(returnsInputType.getReturnTypeCode());
            regRevenueReturns.setStatus("A");
//                entTaxpayerTurnover.setEndDate(null);
//                EntEntity entEntity = new EntEntity();
//                entEntity.setId(entityId);
//                entTaxpayerTurnover.setEntEntity(entEntity);
//                entTaxpayerTurnover.setTaxType(strRevenueType);
            //  }
            //}

//        if (checkUpdate) {
//            entTaxpayerTurnover.setTurnoverType(Constants.EntTaxpayerTurnoverRefData.TURNOVER_TYPE_TAX_TO);
//            entTaxpayerTurnover.setTurnover(turnover);
//            entTaxpayerTurnover.setStartDate(new Timestamp((new Date()).getTime()));
//            entTaxpayerTurnover.setEndDate(null);
//            EntEntity entEntity = new EntEntity();
//            entEntity.setId(entityId);
//            entTaxpayerTurnover.setEntEntity(entEntity);
//            entTaxpayerTurnover.setTaxType(strRevenueType);
//        }
//        return entTaxpayerTurnover;
        }
        return regRevenueReturns;
    }

    /**
     * Does not perform any function at present. Only exists to satisfy the
     * inheritance model.
     *
     * @param pojo
     * @return null.
     */
    public InputType getData(BaseModelObject pojo) {
        RegTaxpayerEntity reg = (RegTaxpayerEntity) pojo;
        InputType type = null;
        if (reg instanceof RegTaxpayer) {
            type = MessageHelper.init(EntityAccountType.class);
            getEntityAccountTypeData((EntityAccountType) type, (RegTaxpayer) reg);
        } else if (reg instanceof RegTaxpayerRevenue) {
            type = MessageHelper.init(RegimeAccountType.class);
            getRegimeAccountTypeData((RegimeAccountType) type, (RegTaxpayerRevenue) reg);
        }
        return type;
    }

    public InputType getEntityAccountFromRegList(List<RegTaxpayerEntity> pojoList) {
        for (RegTaxpayerEntity rte : pojoList) {
            if (rte instanceof RegTaxpayer) {
                return getData(rte);
            }
        }
        return null;
    }

    private EntityAccountType getEntityAccountTypeData(EntityAccountType type, RegTaxpayer taxpayer) {

        type.setEntityAcctStatus(taxpayer.getRegistrationStatus());
        type.setEDR(DateHelper.getCalendar(taxpayer.getEdr()));
        type.setOffice(taxpayer.getOffice());
        type.setAccountNumber(taxpayer.getTin());
        type.setOwnerId(taxpayer.getEntId());
        type.setId(taxpayer.getId());
        type.setRGDNo(taxpayer.getRgdNo());
        type.setEDS(DateHelper.getCalendar(taxpayer.getEds()));
        type.setForcedRegistrationIndicator(StringHelper.getIndicatorAsBoolean(taxpayer.getForcedRegistrationInd()));
        type.setOffice(taxpayer.getOffice());
        type.setEDD(DateHelper.getCalendar(taxpayer.getEdd()));
        type.setStatus(taxpayer.getStatus());
        type.setPreviousAccountNumber(taxpayer.getPreviousTin());
        type.setIRSFileNumber(taxpayer.getIrsFileNumber());
        type.setDeRegistrationReason(taxpayer.getReason());
        return type;
    }

    private RegimeAccountType getRegimeAccountTypeData(RegimeAccountType type, RegTaxpayerRevenue reg) {

        type.setId(reg.getId());
        type.setOwnerId(reg.getEntId());
        type.setRevenueAccountID(reg.getTaxpayerAccountId());
        type.setRevenueType(reg.getRevenueType());
        type.setEDR(DateHelper.getCalendar(reg.getEdr()));
        type.setRevenueAcctStatus(reg.getRegistrationStatus());
        return type;
    }

    public RegimeAccountType getRegimeAccountType(AccRevenueAccountVw accRevenueAccountVw) {
        RegimeAccountType type = new RegimeAccountType();
        if (accRevenueAccountVw != null) {
            type.setId(accRevenueAccountVw.getRegTaxpayerRevenue());
            type.setOwnerId(accRevenueAccountVw.getEntEntity());
            type.setRevenueAccountID(accRevenueAccountVw.getAccAccount());
            type.setRevenueType(accRevenueAccountVw.getRevenueType());
            type.setEDR(DateHelper.getCalendar(accRevenueAccountVw.getEdr()));
            type.setRevenueAcctStatus(accRevenueAccountVw.getRegistrationStatus());
            type.setStagger(accRevenueAccountVw.getStagger());
            if (accRevenueAccountVw.getReturnType() != null) {
                ReturnsInputType[] returnTypes = new ReturnsInputType[1];
                ReturnsInputType returnsInputType = new ReturnsInputType();
                returnsInputType.setReturnTypeCode(accRevenueAccountVw.getReturnType());
                returnTypes[0] = returnsInputType;
                type.getReturnTypes().add(returnsInputType);
            }

        }
        return type;
    }
}
