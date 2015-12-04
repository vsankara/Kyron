package com.technobrain.trips.ratemanagement.service;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.dto.ratemanagement.BankRate;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;
import com.technobrain.trips.ratemanagement.model.RmtBankRate;
import com.technobrain.trips.ratemanagement.model.RmtExchangeRate;
import com.technobrain.trips.reference.model.RefCurrency;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name = "RateManagementFacade",mappedName="RateManagementFacade")
//@Remote
//@Local
public class RateManagementFacadeBean extends FacadeBean implements RateManagementFacadeRemote, 
                                                                    RateManagementFacadeLocal {

//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;

    public RateManagementFacadeBean() {
    }

    /**
     * It queries and returns list of bank rates which dont have expiry date
     * @return List of BankRate
     */
    public List<BankRate> findAllUnexpiredBankRate() {
        try {
            List<BankRate> resultSet = 
                em.createNamedQuery("RmtBankRate.findAllUnexpiredBankRate")
                .setParameter(1,Constants.RecordStatus.ACTIVE)
                .getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<>();
        }
    }
    
    public String getValue(){
        return " *** VALUE *** ";
    }
    
    @Override
    public List<RmtBankRate> findAllRmtBankRate() {
        try {
            List<RmtBankRate> resultSet = 
                em.createNamedQuery("RmtBankRate.findAll")
                .getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<>();
        }
    }

    /**
     * It queries and returns list of bank rates for a given bank rate type passed in.
     * @param rateTypeCode
     * @return List of BankRate
     */
    public List<BankRate> findAllBankRateByRateType(String rateTypeCode) {
        try {
            List<BankRate> resultSet = 
                em.createNamedQuery("RmtBankRate.findAllBankRateByRateType").setParameter(1,rateTypeCode).getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<BankRate>();
        }
    }

    /**
     * It takes a list of BankRate DTO and copies the data from BankRate DTO to 
     * RmtBankRate and save them to DB
     * @param bankRateList
     * @return 
     */
//    public String processBankRate(List<BankRate> bankRateList) {
//        List<RmtBankRate> rmtBankRateList = populateRmtBankRate(bankRateList);
//        if(rmtBankRateList != null){
//            for (RmtBankRate rmtBankRate: rmtBankRateList)  {
//                if(rmtBankRate != null){
//                    saveOrUpdate(rmtBankRate);
//                }
//            }
//        }
//        return null;
//    }
    
    /**
     * It takes a list of BankRate DTO and copies the data from BankRate DTO to 
     * RmtBankRate and returns a list of RmtBankRate
     * @param bankRateList
     * @return List of RmtBankRate
     */
//    private List<RmtBankRate> populateRmtBankRate(List<BankRate> bankRateList) {
//        List<RmtBankRate> rmtBankRateList = null;
//        if(bankRateList != null && bankRateList.size() > 0){
//            rmtBankRateList = new ArrayList<RmtBankRate>();
//            for (BankRate bankRate: bankRateList)  {
//                if(bankRate != null && bankRate.getRate() != null){
//                    RmtBankRate rmtBankRate = new RmtBankRate();
//                    rmtBankRate.setId(bankRate.getRateId());
//                    rmtBankRate.setBankRate(bankRate.getRate());
//                    rmtBankRate.setEffectiveDate(DateHelper.getSqlTimestamp(bankRate.getRateEffectiveDate()));
//                    rmtBankRate.setExpiryDate(DateHelper.getSqlTimestamp(bankRate.getRateExpiryDate()));
//                    RefBankRateType refBankRateType = new RefBankRateType();
//                    refBankRateType.setCode(bankRate.getRateTypeCode());
//                    rmtBankRate.setBankRateType(refBankRateType);
//                    rmtBankRate.setCreatedBy(bankRate.getRateCreatedBy());
//                    rmtBankRate.setCreatedDate(DateHelper.getSqlTimestamp(bankRate.getRateCreatedDate()));
//                    rmtBankRate.setStatus(bankRate.getRateStatus());
//                    rmtBankRateList.add(rmtBankRate);
//                }
//            }
//        }
//        return rmtBankRateList;
//    }
    
    /**
     * The method is to retrieve the list of all the exchange rates, for currency which are in active state and, 
     * the rates that have expiry date as null. If there are no rates available for a currency, the record is displayed
     * with effective date and exchange rate as empty
     * 
     * @param 
     * @return List of ExchangeRateDTO
     */
    public List<ExchangeRateDTO> findAllUnexpiredExchangeRates() {
        try {
            List<ExchangeRateDTO> resultSet = 
                em.createNamedQuery("RmtExchangeRate.findAllExchangeRates").setParameter(1,Constants.RecordStatus.ACTIVE).getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<ExchangeRateDTO>();
        }
    }
    
     /**
      * The method is to retrieve the list of all the exchange rates for provided currency code ordered 
      * by expiry date in descending order.
      * These rates are for display in the selected exchange rate history in the ExchangeRateMaintenance.jspx.
      * 
      * @param currencyCode
      * @return List of ExchangeRateDTO
      */
    public List<ExchangeRateDTO> findAllExchangeRatesByCurrency(String currencyCode) {
        try {
            List<ExchangeRateDTO> resultSet = 
                em.createNamedQuery("RmtExchangeRate.findAllExchangeRatesByCurrency").setParameter(1,currencyCode).getResultList();
            return resultSet;
        } catch (javax.persistence.NoResultException e) {
            return new ArrayList<ExchangeRateDTO>();
        }
    }
    
    /**
     * The method is to populate the RmtExchangeRate model object with the data from ExchangeRateDTO.
     * 
     * @param exchangeRateDTO, rmtExchangeRate
     * @return RmtExchangeRate
     */
    private RmtExchangeRate setExchangeRatePojo(ExchangeRateDTO exchangeRateDTO, RmtExchangeRate rmtExchangeRate){
        RefCurrency currency = new RefCurrency();
        
        rmtExchangeRate.setId(exchangeRateDTO.getExchangeRateId());
        rmtExchangeRate.setEffectiveDate(DateHelper.getSqlTimestamp(exchangeRateDTO.getEffectiveDate()));
        rmtExchangeRate.setExchangeRate(exchangeRateDTO.getExchangeRate());
        rmtExchangeRate.setExpiryDate(DateHelper.getSqlTimestamp(exchangeRateDTO.getExpiryDate()));
        currency.setCode(exchangeRateDTO.getCurrencyCode());
        currency.setDescription(exchangeRateDTO.getCurrencyDescription());
        rmtExchangeRate.setCurrency(currency);
        
        return rmtExchangeRate;
    }
    
    /**
     * The method is to save or update the values from ExchangeRateMaintenance.jspx.
     * 
     * @param exchangeRates
     * @return void
     */
    public void processExchangeRateMaintenance(List<ExchangeRateDTO> exchangeRates) {
        RmtExchangeRate rmtExchangeRate = null;
        for(ExchangeRateDTO exchangeRateDTO : exchangeRates){
            if(exchangeRateDTO.getEffectiveDate()!=null && exchangeRateDTO.getExchangeRate()!=null){
                if(exchangeRateDTO.getExchangeRateId()!=null){
//                    rmtExchangeRate = (RmtExchangeRate)queryFindById(RmtExchangeRate.class,exchangeRateDTO.getExchangeRateId());
                    rmtExchangeRate =
                                              (RmtExchangeRate) em.createNamedQuery("RmtExchangeRate.findById")
                        .setParameter(1,exchangeRateDTO.getExchangeRateId())
                        .getSingleResult();
                    
                    rmtExchangeRate = setExchangeRatePojo(exchangeRateDTO,rmtExchangeRate);
                } else {
                    rmtExchangeRate  = new RmtExchangeRate();
                    rmtExchangeRate = setExchangeRatePojo(exchangeRateDTO,rmtExchangeRate);
                }
                em.merge(rmtExchangeRate);
//                saveOrUpdate(rmtExchangeRate);
            }
        }
    }

    public RmtExchangeRate findActiveExchangeRateByCurrencyAndDate(String currencyCode,Calendar currancyDate) {
        List<RmtExchangeRate> rmtExchangeRate = new  ArrayList<RmtExchangeRate>();
        try{
//            String nativeQueryStr ="SELECT * FROM RMT_EXCHANGE_RATE WHERE CURRENCY=?1 AND ( (TO_DATE(?2,'DD-MM-YY hh24:mi:ss') between EFFECTIVE_DATE and EXPIRY_DATE) " +
//            "or (TO_DATE(?2,'DD-MM-YY hh24:mi:ss') > EFFECTIVE_DATE and EXPIRY_DATE is null) )";
                String nativeQueryStr ="select * from ( (SELECT * FROM RMT_EXCHANGE_RATE WHERE CURRENCY=?1 AND ( (TO_DATE(?2,'DD-MM-YYYY') between trunc(EFFECTIVE_DATE) and EXPIRY_DATE)) " + 
                            "union SELECT * FROM RMT_EXCHANGE_RATE WHERE CURRENCY=?1 AND (TO_DATE(?2,'DD-MM-YYYY') >= trunc(EFFECTIVE_DATE) and EXPIRY_DATE is null) ) " + 
                            ") order by expiry_date desc";
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            
                           
             rmtExchangeRate = em.createNativeQuery(nativeQueryStr,RmtExchangeRate.class)
                    .setParameter(1,currencyCode)
                    .setParameter(2,simpleDateFormat.format(currancyDate.getTime())).getResultList();         
            } catch (javax.persistence.NoResultException e) {
                throw new RuntimeException(e); 
            }
            if(rmtExchangeRate!=null && rmtExchangeRate.size()>0){
                return rmtExchangeRate.get(0);
            }else{
                throw new RuntimeException();
            }
    
    }
}
