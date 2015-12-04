package com.technobrain.trips.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AccPeriodBatchVwPK implements Serializable{

    @Column(name="ACC_ACCOUNT")
    private Long accAccount;
    @Column(name="RETURN_TYPE")
    private String returnType;
    
    public AccPeriodBatchVwPK() {
    }
    public AccPeriodBatchVwPK(Long accAccount,String returnType) {
        this.accAccount = accAccount;
        this.returnType = returnType;
    }

    public void setAccAccount(Long accAccount) {
        this.accAccount = accAccount;
    }

    public Long getAccAccount() {
        return accAccount;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }
}
