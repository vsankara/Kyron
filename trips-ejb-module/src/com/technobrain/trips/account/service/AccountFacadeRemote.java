package com.technobrain.trips.account.service;

import com.technobrain.trips.account.model.AccDishonouredPayment;
import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.account.model.AccountEnquiryView;
import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.account.model.AccountPeriodView;
import com.technobrain.trips.account.model.AccountTransactionSummaryView;
import com.technobrain.trips.account.model.DishonouredPaymentRegister;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.document.model.DdocDocument;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface AccountFacadeRemote extends FacadeLocal {

    public List<AccountEnquiryView> findAccountEnquiryByTinNumber(String tinNumber);
}
