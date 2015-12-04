package com.technobrain.trips.account.delegate;

import com.technobrain.trips.core.delegate.BusinessDelegate;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.account.model.AccountEnquiryView;
import com.technobrain.trips.document.model.DdocDocument;
import com.technobrain.trips.dto.tax.accounting.GenericRegimePeriodSummaryBean;
import com.technobrain.trips.dto.tax.accounting.RegimeSummary;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;


public class TaxpayerAccountDelegate extends BusinessDelegate {
    public TaxpayerAccountDelegate() {


    }
    
    /**
     * Finds a list of accounts and their summary details to be displayed
     * takes the input of taxpayer identification number.
     * 
     * @param tinNumber
     * @return
     */
    public List<RegimeSummary> findAccountEnquirySummaryDetails(String tinNumber) {
        List<RegimeSummary> list = null;
        RegimeSummary summary = null;
        
        String balanceSummaryForDisplay =null;
        if (tinNumber == null || tinNumber.trim().length() == 0) {
            return null;
        }

        List<AccountEnquiryView> accList = 
            getAccountService().findAccountEnquiryByTinNumber(tinNumber);

        if (accList != null && accList.size() > 0) {
            list = new ArrayList<RegimeSummary>();
            for (AccountEnquiryView account: accList) {
                summary = new RegimeSummary();
                

                balanceSummaryForDisplay = getFormattedValue(account.getBalance());
                
                summary.setBalanceForDisplay(balanceSummaryForDisplay);
                
                summary.setBalance(account.getBalance());
                summary.setRegimeDescription(account.getDescription());
                summary.setRegimeNumber(account.getAccountNumber());
                summary.setAccountType(account.getAccountType());
                summary.setRevenueType(account.getRevenueType());
                summary.setStatus(account.getAccountStatus());
                summary.setModeType(account.getModeType());
                summary.setAccountId(account.getAccountId());
                list.add(summary);
            }
        }
        return list;
    }
    
    public List<GenericRegimePeriodSummaryBean> findRegimePeriodSummaries(Long accountId) {
        if (accountId == null) {
            return null;
        }
        BigDecimal periodBalance = null;
        String periodBalForDisplay =null;
        String transactionType = null;
        List<GenericRegimePeriodSummaryBean> regimePerSummaryListNew = new ArrayList<GenericRegimePeriodSummaryBean>();
        
        List<GenericRegimePeriodSummaryBean> regimePerSummaryList = getRevenueAccountService().findRegimePeriodSummaryList(accountId);
        if (regimePerSummaryList != null) {
            for(GenericRegimePeriodSummaryBean perSummaryBean : regimePerSummaryList){
            
                  periodBalForDisplay = getFormattedValue(perSummaryBean.getPeriodBalance());
                  perSummaryBean.setPeriodBalForDisplay(periodBalForDisplay);
                regimePerSummaryListNew.add(perSummaryBean);
            }
        }
            
        return regimePerSummaryListNew;
    }
    
    private String getFormattedValue(BigDecimal valueToFormat){
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(FacesUtil.getLocale());
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setGroupingUsed(true);  
        String balanceForDisplay =null;
        String transactionType = null;
        
        if (valueToFormat.doubleValue()<0){
            transactionType = "CR";
        }else
                transactionType = "";
        balanceForDisplay = decimalFormat.format(valueToFormat.abs()) + " "+transactionType;

        return balanceForDisplay;
    }
    
    public String findDocumentType(Long documentId) {
        return getDocumentService().findDocumentType(documentId);
    }
    
    public Long findFlexibleFormId(Long documentId) {
        return getDocumentService().findFlexibleFormId(documentId);
    }
    
    public String findByDocumentID(Long docId){
        DdocDocument entity = getDocumentService().findByDocumentID(docId);
        return entity.getDocStatus();
    }


}
