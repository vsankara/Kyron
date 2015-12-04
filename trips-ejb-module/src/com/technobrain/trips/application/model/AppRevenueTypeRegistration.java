package com.technobrain.trips.application.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_REVENUE_TYPE")
@DiscriminatorColumn(name="REV_REG_APP_TYPE")
@DiscriminatorValue("REV_REG")
public class AppRevenueTypeRegistration extends AppRevenueType {
    @Column(name="AUTO_REFUND_IND")
    private String autoRefundInd;
    @Column(name="REFUND_INHIBIT_IND")
    private String refundInhibitInd;
    public AppRevenueTypeRegistration() {
    }

    public void setAutoRefundInd(String autoRefundInd) {
        this.autoRefundInd = autoRefundInd;
    }

    public String getAutoRefundInd() {
        return autoRefundInd;
    }

    public void setRefundInhibitInd(String refundInhibitInd) {
        this.refundInhibitInd = refundInhibitInd;
    }

    public String getRefundInhibitInd() {
        return refundInhibitInd;
    }
}
