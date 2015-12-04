package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "RefDateRecurCfg")
@Table(name = "REF_DATE_RECUR_CFG")
@NamedQueries( { @NamedQuery(name = "RefDateRecurCfg.findAll", 
                             query = "select o from RefDateRecurCfg o")
        , 
        @NamedQuery(name = "RefDateRecurCfg.findFrequency", query = "select o.refStagger.code from RefDateRecurCfg o where o.code=?1")
        } )
public class

RefDateRecurCfg extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RETURN_DUE_IN")
    private Integer returnDueIn;

    @Column(name = "PROVISIONAL_DUE_IN")
    private Integer provisionalDueIn;

    @Column(name = "PAYMENT_DUE_IN")
    private Integer paymentDueIn;

    @Column(name = "RETURN_DUE_IN_SPAN")
    private String returnDueInSpan;

    @Column(name = "PROVISIONAL_DUE_IN_SPAN")
    private String provisionalDueInSpan;

    @Column(name = "PAYMENT_DUE_IN_SPAN")
    private String paymentDueInSpan;
    
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;

    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;

    @Column(name = "PAYMENT_DUE_PERIOD")
    private String paymentDuePeriod;

    @Column(name = "RETURN_DUE_PERIOD")
    private String returnDuePeriod;

    @Column(name = "PROVISIONAL_DUE_PERIOD")
    private String provisionalDuePeriod;

    @Column(name = "PAYMENT_DUE_DAY_TYPE")
    private String paymentDueDayType;

    @Column(name = "RETURN_DUE_DAY_TYPE")
    private String returnDueDayType;

    @Column(name = "PROVISIONAL_DUE_DAY_TYPE")
    private String provisionalDueDayType;

    @ManyToOne
    @JoinColumn(name = "RECURRENCE_STRING", referencedColumnName = "CODE")
    private RefStagger refStagger;

    public RefDateRecurCfg() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setRefStagger(RefStagger refStagger) {
        this.refStagger = refStagger;
    }

    public RefStagger getRefStagger() {
        return refStagger;
    }


    public void setReturnDueIn(Integer returnDueIn) {
        this.returnDueIn = returnDueIn;
    }

    public Integer getReturnDueIn() {
        return returnDueIn;
    }

    public void setProvisionalDueIn(Integer provisionalDueIn) {
        this.provisionalDueIn = provisionalDueIn;
    }

    public Integer getProvisionalDueIn() {
        return provisionalDueIn;
    }

    public void setPaymentDueIn(Integer paymentDueIn) {
        this.paymentDueIn = paymentDueIn;
    }

    public Integer getPaymentDueIn() {
        return paymentDueIn;
    }

    public void setReturnDueInSpan(String returnDueInSpan) {
        this.returnDueInSpan = returnDueInSpan;
    }

    public String getReturnDueInSpan() {
        return returnDueInSpan;
    }

    public void setProvisionalDueInSpan(String provisionalDueInSpan) {
        this.provisionalDueInSpan = provisionalDueInSpan;
    }

    public String getProvisionalDueInSpan() {
        return provisionalDueInSpan;
    }

    public void setPaymentDueInSpan(String paymentDueInSpan) {
        this.paymentDueInSpan = paymentDueInSpan;
    }

    public String getPaymentDueInSpan() {
        return paymentDueInSpan;
    }

    public void setPaymentDuePeriod(String paymentDuePeriod) {
        this.paymentDuePeriod = paymentDuePeriod;
    }

    public String getPaymentDuePeriod() {
        return paymentDuePeriod;
    }

    public void setReturnDuePeriod(String returnDuePeriod) {
        this.returnDuePeriod = returnDuePeriod;
    }

    public String getReturnDuePeriod() {
        return returnDuePeriod;
    }

    public void setProvisionalDuePeriod(String provisionalDuePeriod) {
        this.provisionalDuePeriod = provisionalDuePeriod;
    }

    public String getProvisionalDuePeriod() {
        return provisionalDuePeriod;
    }

    public void setPaymentDueDayType(String paymentDueDayType) {
        this.paymentDueDayType = paymentDueDayType;
    }

    public String getPaymentDueDayType() {
        return paymentDueDayType;
    }

    public void setReturnDueDayType(String returnDueDayType) {
        this.returnDueDayType = returnDueDayType;
    }

    public String getReturnDueDayType() {
        return returnDueDayType;
    }

    public void setProvisionalDueDayType(String provisionalDueDayType) {
        this.provisionalDueDayType = provisionalDueDayType;
    }

    public String getProvisionalDueDayType() {
        return provisionalDueDayType;
    }
}
