package com.technobrain.trips.account.ledger;

import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeLocal;

public class RevLedgerAccessor implements IRevnueLedgerAccessor {
    private RevenueAccountFacadeLocal  facadeLocal;
    public RevLedgerAccessor(RevenueAccountFacadeLocal facadeLocal){
        this.facadeLocal = facadeLocal;
    }

    public AccRevLedAccount findRevenueLedgerAccount(String accRevLedRevenueType, 
                                                     String accRevLedBusSect, 
                                                     String accRevLedDocType, 
                                                     String accRevLedChargeType, 
                                                     String accRevLedTaxpayerType, 
                                                     String accRevLedSubTaxCategoryL1, 
                                                     String accRevLedSubTaxCategoryL2) {
        return facadeLocal.findRevenueLedgerAccount( accRevLedRevenueType, 
                                                      accRevLedBusSect, 
                                                      accRevLedDocType, 
                                                      accRevLedChargeType, 
                                                      accRevLedTaxpayerType, 
                                                      accRevLedSubTaxCategoryL1, 
                                                      accRevLedSubTaxCategoryL2);
    }
}
