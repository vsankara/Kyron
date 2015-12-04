package com.technobrain.trips.dto.tax.release;

import com.technobrain.trips.dto.DataTransferObject;


import java.math.BigDecimal;

import java.util.Calendar;
import java.util.List;


public class ProcessRefundApplyToSummaryBean implements DataTransferObject {
    
    private String regionCode;
    private String bankCode;
    private BigDecimal trpAmount;
    private Calendar issuedDate;
    
    private List<Long> refundClaimIds;
    
    public ProcessRefundApplyToSummaryBean() {
    }
    
    public ProcessRefundApplyToSummaryBean(String regionCode, String bankCode, BigDecimal trpAmount, List<Long> refundClaimIds ){
        this.regionCode = regionCode;
        this.bankCode = bankCode;
        this.setTrpAmount(trpAmount);
        this.refundClaimIds = refundClaimIds;
    }


    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BigDecimal getTrpAmount() {
        return trpAmount;
    }

    public void setTrpAmount(BigDecimal trpAmount) {
        this.trpAmount = trpAmount;
    }

    public Calendar getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Calendar issuedDate) {
        this.issuedDate = issuedDate;
    }

    
    public List<Long> getRefundClaimIds() {
        return refundClaimIds;
    }

    public void setRefundClaimIds(List<Long> refundClaimIds) {
        this.refundClaimIds = refundClaimIds;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
