package com.technobrain.trips.dto.tax.accounting;

import com.technobrain.trips.dto.DataTransferObject;

import java.math.BigDecimal;

public class PostingAllocationObject implements DataTransferObject {

    private String transactionRef;
    private Long transactionId;
    private BigDecimal allocAmount;
    
    public PostingAllocationObject() {
    }
    
    public PostingAllocationObject(String transactionRef, Long transactionId,  BigDecimal allocAmount){
        this.transactionRef = transactionRef;
        this.transactionId = transactionId;
        this.allocAmount = allocAmount;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getTransactionRef() {
        return transactionRef;
    }


    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setAllocAmount(BigDecimal allocAmount) {
        this.allocAmount = allocAmount;
    }

    public BigDecimal getAllocAmount() {
        return allocAmount;
    }
}
