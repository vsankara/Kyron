package com.technobrain.trips.ratemanagement.service;

import com.technobrain.trips.core.service.FacadeRemote;
import com.technobrain.trips.dto.ratemanagement.BankRate;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;
import com.technobrain.trips.ratemanagement.model.RmtBankRate;
import com.technobrain.trips.ratemanagement.model.RmtExchangeRate;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface RateManagementFacadeRemote extends FacadeRemote{
    
    public List<BankRate> findAllUnexpiredBankRate();
    
    public List<RmtBankRate> findAllRmtBankRate();
    
    public String getValue();
//    
//    public List<BankRate> findAllBankRateByRateType(String rateTypeCode);
//    
//    public String processBankRate(List<BankRate> bankRateList);
//    
    public List<ExchangeRateDTO> findAllUnexpiredExchangeRates();
    
    public List<ExchangeRateDTO> findAllExchangeRatesByCurrency(String currencyCode);
    
    public void processExchangeRateMaintenance(List<ExchangeRateDTO> exchangeRates);
    public RmtExchangeRate findActiveExchangeRateByCurrencyAndDate(String currencyCode,Calendar currancyDate);
}
