package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefTaxRebates.findAll", 
    query = "select o from RefTaxRebates o")
@Table(name = "REF_TAX_REBATES")
public class RefTaxRebates extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
	
	@Column(name="AMOUNT_OF_TAX")
    private Long amountOfTax;
	
	@Column(name="RATE")
    private Long rate;
	
	@Column(name="TYPE_OF_REBATE")
    private String typeOfRebate;
    
    public RefTaxRebates() {
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

    public void setAmountOfTax(Long amountOfTax) {
        this.amountOfTax = amountOfTax;
    }

    public Long getAmountOfTax() {
        return amountOfTax;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getRate() {
        return rate;
    }

    public void setTypeOfRebate(String typeOfRebate) {
        this.typeOfRebate = typeOfRebate;
    }

    public String getTypeOfRebate() {
        return typeOfRebate;
    }
}
