package com.technobrain.trips.ratemanagement.delegate;

import com.technobrain.trips.core.delegate.BusinessDelegate;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;

import java.util.List;


/**
 * This is a delegate for rate management that reduces the coupling between presentation tiers of
 * rate management and relevant EJB.
 */
public class RateManagementDelegate extends BusinessDelegate {
    public RateManagementDelegate() {
    }

    /**
     * It returns list of bank rates which dont have expiry date (expiry date is null)
     * @return List of BankRate
     */
//    public List<BankRate> findAllUnexpiredBankRate(){
//        List<BankRate> bankRate = getRateManagementService().findAllUnexpiredBankRate();
//        return bankRate;
//    }

    /**
     * It takes rate type code and returns all rates for that rate type in descending order
     * @param rateTypeCode
     * @return List of BankRate
     */
//    public List<BankRate> findAllBankRateByRateType(String rateTypeCode){
//        List<BankRate> bankRate = getRateManagementService().findAllBankRateByRateType(rateTypeCode);
//        return bankRate;
//    }

    /**
     * It takes list of bank rates and save them to DB
     * @param bankRateList
     * @return
     */
//    public String processBankRate(List<BankRate> bankRateList) {
//        getRateManagementService().processBankRate(bankRateList);
//        return null;
//    }
    
    /**
     * It returns list of exchangerates with expiry date as null
     * @return List of ExchangeRateDTO
     */
    public List<ExchangeRateDTO> findAllUnexpiredExchangeRates(){
        List<ExchangeRateDTO> exchangeRates = getRateManagementService().findAllUnexpiredExchangeRates();
        return exchangeRates;
    }
    
    /**
     * It takes currency code and returns all exchange rates for that currency in descending order
     * @param currencyCode
     * @return List of ExchangeRateDTO
     */
    public List<ExchangeRateDTO> findAllExchangeRatesByCurrency(String currencyCode){
        List<ExchangeRateDTO> exchangeRates = getRateManagementService().findAllExchangeRatesByCurrency(currencyCode);
        return exchangeRates;
    }
    
    /**
     * This method takes a list of exchange rates and saves them to Database
     * @param exchangeRates
     * @return
     */
    public void processExchangeRateMaintenance(List<ExchangeRateDTO> exchangeRates){
        getRateManagementService().processExchangeRateMaintenance(exchangeRates);
    }
}
