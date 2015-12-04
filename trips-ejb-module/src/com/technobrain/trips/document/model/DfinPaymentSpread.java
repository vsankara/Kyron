package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefRevType;

import java.math.BigDecimal;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * Defines spreads of a payment at a high level, e.g. Document, Period, etc.
 *
 * @since	$Date: 2011-08-04 17:50:08 +0100 (Thu, 04 Aug 2011) $
 * @version	$Rev: 22651 $
 * @author	$Author: a_dorairaj $
 * 
 */
@Entity
@NamedQuery(name = "DfinPaymentSpread.findAll", 
    query = "select o from DfinPaymentSpread o")
@Table(name = "DFIN_PAYMENT_SPREAD")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PAYMENT_SPREAD_TYPE", discriminatorType=DiscriminatorType.STRING, length=500)
public class DfinPaymentSpread extends BaseNormalModelObject {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DFIN_PAYMENT_SPREAD_SEQ")
    @SequenceGenerator(name = "DFIN_PAYMENT_SPREAD_SEQ", sequenceName = "DFIN_PAYMENT_SPREAD_SEQ", allocationSize = 1)
    private Long id;
    
    @Column(name="AMOUNT_ALLOCATED", nullable = false)
    private BigDecimal amountAllocated;

    @ManyToOne
    @JoinColumn(name = "COLL_INSTRUMENT_ID", referencedColumnName = "ID")
    private DfinRevCollInstrument instrument;
    
    @OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER,mappedBy = "paymentSpread")
    private List<DfinPaymentAllocation> paymentAllocations;
    
    @Column(name="ACC_TRANSACTION_ID")
    private Long accountTransactionId;
    
    @Column(name="REVENUE_TYPE")
    private String revenueType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REVENUE_TYPE", referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefRevType refRevType;
    
    @Column(name="RETURN_TYPE")
    private String returnType;
    
    @Column(name="LATE_PAY_EVENT_ID")
    private Long latePayEventId;
    
    public DfinPaymentSpread() {
    }

    public BigDecimal getAmountAllocated() {
        return amountAllocated;
    }

    public void setAmountAllocated(BigDecimal amountAllocated) {
        this.amountAllocated = amountAllocated;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInstrument(DfinRevCollInstrument instrument) {
        this.instrument = instrument;
    }

    public DfinRevCollInstrument getInstrument() {
        return instrument;
    }

    public void setPaymentAllocations(List<DfinPaymentAllocation> paymentAllocations) {
        this.paymentAllocations = paymentAllocations;
    }

    public List<DfinPaymentAllocation> getPaymentAllocations() {
        if(paymentAllocations == null){
            paymentAllocations = new LinkedList<DfinPaymentAllocation>();
        }
        return paymentAllocations;
    }
    
    public void addPaymentAllocation(DfinPaymentAllocation allocation){
        if (allocation != null) {
            getPaymentAllocations().add(allocation);
            allocation.setPaymentSpread(this);
        }
    }
    
    public void removePaymentAllocation(DfinPaymentAllocation allocation){
        paymentAllocations.remove(allocation);
    }

    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setRefRevType(RefRevType refRevType) {
        this.refRevType = refRevType;
    }

    public RefRevType getRefRevType() {
        return refRevType;
    }

    public void setLatePayEventId(Long latePayEventId) {
        this.latePayEventId = latePayEventId;
    }

    public Long getLatePayEventId() {
        return latePayEventId;
    }
}
