package com.technobrain.trips.ratemanagement.service;

import com.technobrain.trips.dto.ratemanagement.BankRate;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;
import com.technobrain.trips.ratemanagement.model.RmtBankRate;
import com.technobrain.trips.ratemanagement.model.RmtExchangeRate;

import java.util.Hashtable;
import java.util.List;
import javax.ejb.EJB;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RateManagementSessionClient {
    @EJB(name = "RateManagementFacade")
    static RateManagementFacadeRemote rateRemote;
    
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            RateManagementFacadeRemote rateManagementSession =
                (RateManagementFacadeRemote) context.lookup("RateManagementFacade#com.technobrain.trips.ratemanagement.service.RateManagementFacadeRemote");
            
            System.out.println(" Return data is "+rateManagementSession.getValue());
        
for (RmtBankRate rmtbankrate : (List<RmtBankRate>) rateManagementSession.findAllRmtBankRate()) {
                           System.out.println(" value is "+rmtbankrate.getBankRate());
                           System.out.println(" value is "+rmtbankrate.getBankRateType());
                        }
for (BankRate rmtbankrate : (List<BankRate>) rateManagementSession.findAllUnexpiredBankRate()) {
                           System.out.println(" value is "+rmtbankrate.getRateTypeCode());
                           System.out.println(" value is "+rmtbankrate.getRate());
                           System.out.println(" value is "+rmtbankrate.getRateTypeDesc());
                        }

            for (ExchangeRateDTO rmtbankrate : (List<ExchangeRateDTO>) rateManagementSession.findAllUnexpiredExchangeRates()) {
                            printRmtBankRate(rmtbankrate);
                        }
            
            
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printRmtBankRate(ExchangeRateDTO rmtbankrate) {
        System.out.println("accessLevel = " + rmtbankrate.getCurrencyCode());
        System.out.println("bankRate = " + rmtbankrate.getExchangeRate());
        System.out.println("bankRateType = " + rmtbankrate.getCurrencyDescription());
        
    }

    private static void printRmtExchangeRate(RmtExchangeRate rmtexchangerate) {
        System.out.println("accessLevel = " + rmtexchangerate.getAccessLevel());
        System.out.println("baseCurrency = " + rmtexchangerate.getBaseCurrency());
        System.out.println("createdBy = " + rmtexchangerate.getCreatedBy());
        System.out.println("createdDate = " + rmtexchangerate.getCreatedDate());
        System.out.println("currency = " + rmtexchangerate.getCurrency());
        System.out.println("effectiveDate = " + rmtexchangerate.getEffectiveDate());
        System.out.println("exchangeRate = " + rmtexchangerate.getExchangeRate());
        System.out.println("expiryDate = " + rmtexchangerate.getExpiryDate());
        System.out.println("id = " + rmtexchangerate.getId());
        System.out.println("status = " + rmtexchangerate.getStatus());
        System.out.println("updatedBy = " + rmtexchangerate.getUpdatedBy());
        System.out.println("updatedDate = " + rmtexchangerate.getUpdatedDate());
        System.out.println("version = " + rmtexchangerate.getVersion());
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7001");
        return new InitialContext(env);
    }
}
