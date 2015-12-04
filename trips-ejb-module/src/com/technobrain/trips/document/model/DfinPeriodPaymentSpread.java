package com.technobrain.trips.document.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * TechnoBrain 2015
 *
 * A payment spread directed at a period.
 *
 * @since	$Date: 2011-04-19 18:37:20 +0100 (Tue, 19 Apr 2011) $
 * @version	$Rev: 19215 $
 * @author	$Author: v_kumar $
 * 
 */
@Entity
@DiscriminatorValue(value="DFIN_PAYMENT_SPREAD_PERIOD")
public class DfinPeriodPaymentSpread extends DfinPaymentSpread {

    @Column(name="PERIOD_ID")
    private Long periodId;
    
    @Column(name="ACCOUNT_ID")
    private Long accountId;
    
    @Transient
    private boolean periodPayment;
    
    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setPeriodPayment(boolean periodPayment) {
        this.periodPayment = periodPayment;
    }

    public boolean isPeriodPayment() {
        return periodPayment;
    }
}
