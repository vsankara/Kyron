package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TechnoBrain 2015
 *
 * For allocating a payment amount to a liability transaction.
 *
 * @since	$Date: 2011-05-19 15:20:46 +0100 (Thu, 19 May 2011) $
 * @version	$Rev: 20123 $
 * @author	$Author: m_rao $
 * 
 */
@Entity
@NamedQuery(name = "DfinPaymentAllocation.findAll", 
    query = "select o from DfinPaymentAllocation o")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ALLOCATION_TYPE")
@Table(name = "DFIN_PAYMENT_ALLOCATION")
public class DfinPaymentAllocation extends BaseNormalModelObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DFIN_PAYMENT_ALLOCATION_SEQ")
    @SequenceGenerator(name = "DFIN_PAYMENT_ALLOCATION_SEQ", sequenceName = "DFIN_PAYMENT_ALLOCATION_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="AMOUNT_ALLOCATED", nullable = false)
    private BigDecimal amountAllocated;
    
    @Column(name="BALANCE")
    private BigDecimal balance; 
        
    @ManyToOne
    @JoinColumn(name = "PAYMENT_SPREAD_ID", referencedColumnName = "ID")
    private DfinPaymentSpread paymentSpread;

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


    public void setPaymentSpread(DfinPaymentSpread paymentSpread) {
        this.paymentSpread = paymentSpread;
    }

    public DfinPaymentSpread getPaymentSpread() {
        return paymentSpread;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
