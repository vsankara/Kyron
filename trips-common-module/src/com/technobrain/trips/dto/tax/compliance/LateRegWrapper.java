package com.technobrain.trips.dto.tax.compliance;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.Calendar;
import java.util.Date;

public class LateRegWrapper implements DataTransferObject{

    private Date eds;
    private Date businessStartDate;
    private String accStatus;
    private String acctNo;
    private String legalStatus;
    
    public LateRegWrapper() {
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setEds(Date eds) {
        this.eds = eds;
    }

    public Date getEds() {
        return eds;
    }

    public void setBusinessStartDate(Date businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public Date getBusinessStartDate() {
        return businessStartDate;
    }
}
