package com.technobrain.trips.document.model;

import com.technobrain.trips.account.model.AccountTransaction;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;


/**
 * TechnoBrain 2015
 *
 * A payment allocation directed toward individual transactions (for creation
 * of liabilities against an account).
 *
 * @since	$Date: 2010-10-27 15:32:16 +0100 (Wed, 27 Oct 2010) $
 * @version	$Rev: 11422 $
 * @author	$Author: j_sweet $
 * 
 */
@Entity
@DiscriminatorValue(value="TRANSACTION")
public class DfinTransactionAllocation extends DfinPaymentAllocation {
    @Column(name="ACC_TRANSACTION_ID")
    private Long accTransactionId;
    
    @JoinColumn(name = "ACC_TRANSACTION_ID", referencedColumnName = "ID", insertable=false,updatable=false)
    private AccountTransaction accountTransaction;
    
    public Long getAccTransactionId() {
        return accTransactionId;
    }

    public void setAccTransactionId(Long accTransactionId) {
        this.accTransactionId = accTransactionId;
    }

    public void setAccountTransaction(AccountTransaction accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }
}
