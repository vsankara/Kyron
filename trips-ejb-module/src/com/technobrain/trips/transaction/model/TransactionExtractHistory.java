package com.technobrain.trips.transaction.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( { 
@NamedQuery(name = "TransactionExtractHistory.findAll", 
    query = "select o from TransactionExtractHistory o"), 
@NamedQuery(name = "TransactionExtractHistory.findByDateTimeFrom", 
    query = "select o from TransactionExtractHistory o where o.dateTimeFrom = ?1"), 
@NamedQuery(name = "TransactionExtractHistory.findMaxByDateTimeTo", 
    query = "select o from TransactionExtractHistory o where o.createdDate = (select max(o2.createdDate) from TransactionExtractHistory o2 where o2.service = ?1) and o.service = ?2 order by o.id desc")
        } )
@Table(name = "TRANS_EXTRACT_HIST")
public class TransactionExtractHistory extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "TRANS_EXTRACT_HIST_SEQ")
    @SequenceGenerator(name = "TRANS_EXTRACT_HIST_SEQ", 
                       sequenceName = "TRANS_EXTRACT_HIST_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "CALL_START_DATE_TIME", nullable = false)
    private Timestamp callStartDateTime;
    @Column(name = "CALL_DURATION", nullable = false)
    private Long callDuration;
    @Column(name = "DATE_TIME_FROM", nullable = false)
    private Timestamp dateTimeFrom;
    @Column(name = "DATE_TIME_TO", nullable = false)
    private Timestamp dateTimeTo;
    @Column(name = "SERVICE")
    private String service;
    @Column(name = "TRANSACTIONS")
    private char[] transactions;

    public TransactionExtractHistory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCallStartDateTime() {
        return callStartDateTime;
    }

    public void setCallStartDateTime(Timestamp callStartDateTime) {
        this.callStartDateTime = callStartDateTime;
    }

    public Long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Long callDuration) {
        this.callDuration = callDuration;
    }

    public Timestamp getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(Timestamp dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public Timestamp getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(Timestamp dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public char[] getTransactions() {
        return transactions;
    }

    public void setTransactions(char[] transactions) {
        this.transactions = transactions;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
