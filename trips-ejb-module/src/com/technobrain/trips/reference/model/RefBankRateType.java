package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.ratemanagement.model.RmtBankRate;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefBankRateType.findAll", 
    query = "select o from RefBankRateType o")
@Table(name = "REF_BANK_RATE_TYPE")
public class RefBankRateType extends BaseRefModelObject {
     
    @Id
    @Column(nullable = false)
    private String code;     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @OneToMany(mappedBy = "bankRateType")    
    private List<RmtBankRate> rmtBankRateList;


    public RefBankRateType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
  
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setRmtBankRateList(List<RmtBankRate> rmtBankRateList) {
        this.rmtBankRateList = rmtBankRateList;
    }

    public List<RmtBankRate> getRmtBankRateList() {
        return rmtBankRateList;
    }
    
    public RmtBankRate addRmtBankRate(RmtBankRate rmtBankRate) {
        getRmtBankRateList().add(rmtBankRate);
        rmtBankRate.setBankRateType(this);
        return rmtBankRate;
    }

    public RmtBankRate removeRmtBankRate(RmtBankRate rmtBankRate) {
        getRmtBankRateList().remove(rmtBankRate);
        rmtBankRate.setBankRateType(null);
        return rmtBankRate;
    }
}
