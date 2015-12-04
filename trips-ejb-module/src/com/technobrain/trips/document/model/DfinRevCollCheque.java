package com.technobrain.trips.document.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 * TechnoBrain 2015
 *
 * A cheque payment.
 *
 * @since	$Date: 2010-12-15 09:08:15 +0000 (Wed, 15 Dec 2010) $
 * @version	$Rev: 14075 $
 * @author	$Author: m_rao $
 * 
 */
@Entity
@DiscriminatorValue(value="DFIN_REV_COLL_INSTR_CHEQUE")
@Table(name = "DFIN_REV_COLL_CHEQUE")
public class DfinRevCollCheque extends DfinRevCollInstrument {
    private String bank;

    @Column(name="BANK_ACCOUNT_NUMBER")
    private String bankAccountNumber;

    @Column(name="SORT_CODE")
    private String sortCode;
    
    @Column(name="CHEQUE_NUMBER")
    private String chequeNumber;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }
}
