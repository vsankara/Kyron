package com.technobrain.trips.account.ledger;

import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;

public interface IRevnueLedgerAccessor {
    public AccRevLedAccount findRevenueLedgerAccount(String accRevLedRevenueType,
                                                        String accRevLedBusSect,
                                                        String accRevLedDocType,
                                                        String accRevLedChargeType,
                                                        String accRevLedTaxpayerType,
                                                        String accRevLedSubTaxCategoryL1,
                                                        String accRevLedSubTaxCategoryL2);
}
