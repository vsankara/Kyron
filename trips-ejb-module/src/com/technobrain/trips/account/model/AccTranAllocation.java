package com.technobrain.trips.account.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( 
    { 
        @NamedQuery(name = "AccTranAllocation.findAll", 
            query = "select o from AccTranAllocation o"),
    
        @NamedQuery(name = "AccTranAllocation.findAllocationsByTransactionId", 
            query = "select o from AccTranAllocation o where (o.targetTransaction = ?1 or o.sourceTransaction = ?1) and o.status = 'A'"),

        @NamedQuery(name = "AccTranAllocation.findExistingAllocationReversal", 
            query = "select o from AccTranAllocation o where o.sourceTransaction = ?1 and o.targetTransaction = ?2 and o.status = 'R'"),
    
        @NamedQuery(name = "AccTranAllocation.findAllocationsByTargetTransactionId", 
            query = "select o from AccTranAllocation o where o.targetTransaction = ?1 and o.status = 'A'")
    }
)
@Table(name = "ACC_TRAN_ALLOCATION")
@SequenceGenerator(name = "ACC_TRAN_ALLOCATION_SEQ", 
                   sequenceName = "ACC_TRAN_ALLOCATION_SEQ", initialValue = 1, 
                   allocationSize = 1)
public class AccTranAllocation extends BaseNormalModelObject {
    @Column(name="ALLOCATION_VALUE", nullable = false)
    private BigDecimal allocationValue;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ACC_TRAN_ALLOCATION_SEQ")
    private Long id;
    @Column(name="TARGET_TRANSACTION", nullable = false)
    private Long targetTransaction;
    @Column(name="TIME_STAMP", nullable = false)
    private Timestamp timeStamp;
    
    @Column(name = "SOURCE_TRANSACTION")
    private Long sourceTransaction;
    

    public AccTranAllocation() {
    }

    public BigDecimal getAllocationValue() {
        return allocationValue;
    }

    public void setAllocationValue(BigDecimal allocationValue) {
        this.allocationValue = allocationValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTargetTransaction() {
        return targetTransaction;
    }

    public void setTargetTransaction(Long targetTransaction) {
        this.targetTransaction = targetTransaction;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setSourceTransaction(Long sourceTransaction) {
        this.sourceTransaction = sourceTransaction;
    }

    public Long getSourceTransaction() {
        return sourceTransaction;
    }
}
