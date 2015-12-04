package com.technobrain.trips.objectionandappeal.model;

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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Model class representing the table OBA_DISPUTED_TRANSACTION. 
 * 
 *@author
 *@version
 *@since   
 *@see ObaObjectionDetails
 * 
 */
@Entity
@NamedQuery(name = "ObaDisputedTransaction.findAll", 
    query = "select o from ObaDisputedTransaction o")
@Table(name = "OBA_DISPUTED_TRANSACTION")
public class ObaDisputedTransaction extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "OBA_DISPUTED_TRANSACTION_SEQ")
    @SequenceGenerator(name = "OBA_DISPUTED_TRANSACTION_SEQ", 
                       sequenceName = "OBA_DISPUTED_TRANSACTION_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="PERIOD_NO")
    private Integer periodNo;
    @Column(name="PERIOD_YEAR")
    private Integer periodYear;
    @Column(name="TAX_TYPE")
    private String taxType;
    @Column(name="TRANSACTION_AMOUNT")
    private BigDecimal transactionAmount;
    @Column(name="TRANSACTION_DATE")
    private Timestamp transactionDate;
    @Column(name="TRANSACTION_ID")
    private Long transactionId;
    @Column(name="TRANSACTION_REFERENCE")
    private String transactionReference;
    @Column(name="WITHIN_TIMESCALE_IND")
    private String withinTimescaleIndicator;

    @ManyToOne
    @JoinColumn(name = "OBJECTION_CASE_ID", referencedColumnName = "ID")
    private ObaObjectionDetails obaObjectionDetails;
    
    public ObaDisputedTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getPeriodNo() {
        return periodNo;
    }

    public void setPeriodNo(Integer periodNo) {
        this.periodNo = periodNo;
    }

    public Integer getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(Integer periodYear) {
        this.periodYear = periodYear;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public void setObaObjectionDetails(ObaObjectionDetails obaObjectionDetails) {
        this.obaObjectionDetails = obaObjectionDetails;
    }

    public ObaObjectionDetails getObaObjectionDetails() {
        return obaObjectionDetails;
    }

    public void setWithinTimescaleIndicator(String withinTimescaleIndicator) {
        this.withinTimescaleIndicator = withinTimescaleIndicator;
    }

    public String getWithinTimescaleIndicator() {
        return withinTimescaleIndicator;
    }
}
