package com.technobrain.trips.account.service;

import com.technobrain.trips.account.model.AccountEnquiryView;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.entityandregimeaccounting.message.PeriodType;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.entityandregimeaccounting.message.AccountType;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AccountFacadeLocal extends FacadeLocal {

    public PeriodType getPeriodType(EntityAccountType eat);
    public List<PeriodType> getPeriodTypes(RegimeAccountType rat);
    public void autoGeneratePeriod(List<PeriodType> periodType) throws Exception;
    public OutputType persistAccount(AccountType AccountType);
    public List<AccountEnquiryView> findAccountEnquiryByTinNumber(String tinNumber);
    public void postToAccounts(DdocDocument ddoc) throws Exception;
    
}
