package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "TillReconcilLog.findAll", 
    query = "select o from TillReconcilLog o")
@Table(name = "TILL_RECONCIL_LOG")
public class TillReconcilLog  extends BaseNormalModelObject {
    @Column(name="AMOUNT_ENTERED", nullable = false)
    private BigDecimal amountEntered;    
    @Column(nullable = false)    
    private Long occurance;
    @Column(name="RECONCILED_BY", nullable = false)
    private String reconciledBy;
    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TILL_RECONCIL_LOG_SEQ")
    @SequenceGenerator(name = "TILL_RECONCIL_LOG_SEQ", sequenceName = "TILL_RECONCIL_LOG_SEQ", allocationSize = 1)                    
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "TILL_ID", referencedColumnName = "ID")
    private CashTill cashTill;

    public TillReconcilLog() {
    }

    public BigDecimal getAmountEntered() {
        return amountEntered;
    }

    public void setAmountEntered(BigDecimal amountEntered) {
        this.amountEntered = amountEntered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOccurance() {
        return occurance;
    }

    public void setOccurance(Long occurance) {
        this.occurance = occurance;
    }

    public String getReconciledBy() {
        return reconciledBy;
    }

    public void setReconciledBy(String reconciledBy) {
        this.reconciledBy = reconciledBy;
    }


    public CashTill getCashTill() {
        return cashTill;
    }

    public void setCashTill(CashTill cashTill) {
        this.cashTill = cashTill;
    }
}
