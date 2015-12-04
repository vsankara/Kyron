package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

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
@NamedQuery(name = "TillHistory.findAll", 
    query = "select o from TillHistory o")
@Table(name = "TILL_HISTORY")
public class TillHistory  extends BaseNormalModelObject  {
    @Column(name="ACTIONED_BY", nullable = false)
    private String actionedBy;
    @Column(name="ACTIONED_DATE", nullable = false)
    private Timestamp actionedDate;
    @Column(name="TILL_STATUS")
    private String tillStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TILL_HISTORY_SEQ")
    @SequenceGenerator(name = "TILL_HISTORY_SEQ", sequenceName = "TILL_HISTORY_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;   
    @ManyToOne
    @JoinColumn(name = "TILL_ID", referencedColumnName = "ID")
    private CashTill cashTill;
    
    public TillHistory() {
    }

    public String getActionedBy() {
        return actionedBy;
    }

    public void setActionedBy(String actionedBy) {
        this.actionedBy = actionedBy;
    }

    public Timestamp getActionedDate() {
        return actionedDate;
    }

    public void setActionedDate(Timestamp actionedDate) {
        this.actionedDate = actionedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CashTill getCashTill() {
        return cashTill;
    }

    public void setCashTill(CashTill cashTill) {
        this.cashTill = cashTill;
    }

    public void setTillStatus(String tillStatus) {
        this.tillStatus = tillStatus;
    }

    public String getTillStatus() {
        return tillStatus;
    }
}
