package com.technobrain.trips.account.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefDishonouredReason;

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


@Entity(name = "AccDishonouredPayment")
@NamedQueries (
    {
        @NamedQuery(name = "AccDishonouredPayment.findAll", 
            query = "select adp from AccDishonouredPayment adp "),
        @NamedQuery(name = "AccDishonouredPayment.findByTinAndInstrumentType", 
            query = "select adp from AccDishonouredPayment adp where adp.tin=?1 and adp.instrumentType=?2 and adp.reversalDate between ?3 and current_date"),
        @NamedQuery(name = "AccDishonouredPayment.findDishonouredPayment", 
            query = "select adp from AccDishonouredPayment adp " +
                    "   where adp.id=?1")
    }
)    
@Table(name = "ACC_DISHONOURED_PAYMENT")
public class AccDishonouredPayment extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ACC_DISHONOURED_PAYMENT_SEQ")
    @SequenceGenerator(name = "ACC_DISHONOURED_PAYMENT_SEQ", 
                       sequenceName = "ACC_DISHONOURED_PAYMENT_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "DISHONOURED_REASON", referencedColumnName = "CODE")
    private RefDishonouredReason dishonouredReason;
    
    @Column(name="DISHONOURED_NOTES")
    private String dishonouredNotes;
    
    @Column(name="REVERSAL_DATE")
    private Timestamp reversalDate;
    
    @Column(name="REV_COLL_RECEIPT")
    private Long revCollReceiptId;
    
    @Column(name="REV_COLL_INSTRUMENT")
    private Long revCollInstrumentId;
    
    private String tin;
    
    @Column(name="INSTRUMENT_TYPE")
    private String instrumentType;
    
    public AccDishonouredPayment() {
    }

    public void setDishonouredReason(RefDishonouredReason dishonouredReason) {
        this.dishonouredReason = dishonouredReason;
    }

    public RefDishonouredReason getDishonouredReason() {
        return dishonouredReason;
    }

    public void setDishonouredNotes(String dishonouredNotes) {
        this.dishonouredNotes = dishonouredNotes;
    }

    public String getDishonouredNotes() {
        return dishonouredNotes;
    }

    public void setReversalDate(Timestamp reversalDate) {
        this.reversalDate = reversalDate;
    }

    public Timestamp getReversalDate() {
        return reversalDate;
    }

    public void setRevCollReceiptId(Long revCollReceiptId) {
        this.revCollReceiptId = revCollReceiptId;
    }

    public Long getRevCollReceiptId() {
        return revCollReceiptId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRevCollInstrumentId(Long revCollInstrumentId) {
        this.revCollInstrumentId = revCollInstrumentId;
    }

    public Long getRevCollInstrumentId() {
        return revCollInstrumentId;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTin() {
        return tin;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getInstrumentType() {
        return instrumentType;
    }
}
