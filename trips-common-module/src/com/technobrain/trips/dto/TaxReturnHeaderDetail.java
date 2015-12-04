package com.technobrain.trips.dto;


/**
 * TechnoBrain 2015
 * This is a DTO for tax return header details. It is used to transfer
 * the (read only)header details of tax return pages.
 * 
 * @since $Date: 2/2/2009 5:23:05 AM$
 * @version $Revision: 4$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:23:05 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */
public class TaxReturnHeaderDetail implements DataTransferObject{
    
    private String tin;
    private String name;
    private String taxpayerStatus;
    private String regimeAccount;
    private String regimeType;
    private String regimeAccountStatus;

    /**
     * @param name
     * @param regimeAccount
     * @param regimeType
     * @param regimeAccountStatus
     * This is a constructor that represents tax return header details
     */
    public TaxReturnHeaderDetail(String name,String regimeAccount,String regimeType,String regimeAccountStatus) {
        this.name = name;
        this.regimeAccount = regimeAccount;
        this.regimeType = regimeType;
        this.regimeAccountStatus = regimeAccountStatus;
    }
       
    public TaxReturnHeaderDetail(){
        
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTaxpayerStatus(String taxpayerStatus) {
        this.taxpayerStatus = taxpayerStatus;
    }

    public String getTaxpayerStatus() {
        return taxpayerStatus;
    }

    public void setRegimeAccount(String regimeAccount) {
        this.regimeAccount = regimeAccount;
    }

    public String getRegimeAccount() {
        return regimeAccount;
    }

    public void setRegimeType(String regimeType) {
        this.regimeType = regimeType;
    }

    public String getRegimeType() {
        return regimeType;
    }

    public void setRegimeAccountStatus(String regimeAccountStatus) {
        this.regimeAccountStatus = regimeAccountStatus;
    }

    public String getRegimeAccountStatus() {
        return regimeAccountStatus;
    }
}
