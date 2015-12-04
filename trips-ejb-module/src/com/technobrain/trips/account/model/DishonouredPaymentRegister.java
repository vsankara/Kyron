package com.technobrain.trips.account.model;

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
@NamedQueries(
{
@NamedQuery(name = "DishonouredPaymentRegister.findByTinAndInstrumentType", 
    query = "select o from DishonouredPaymentRegister o where o.tin=?1 and o.paymentInstrumentType=?2"),
@NamedQuery(name = "DishonouredPaymentRegister.findByPaymentDate",     
    query ="select o from DishonouredPaymentRegister o where o.tin=?1 and ?2 between o.blockStartDate and o.blockEndDate")
 } 
)
@Table(name = "DISHON_PAYMENT_REGISTER")


public class DishonouredPaymentRegister extends BaseNormalModelObject{

    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "DISHON_PAYMENT_REGISTER_SEQ")
    @SequenceGenerator(name = "DISHON_PAYMENT_REGISTER_SEQ", 
                       sequenceName = "DISHON_PAYMENT_REGISTER_SEQ", 
                       allocationSize = 1)
    @Id
    @Column(nullable = false)
    private Long id;
    
    @Column(name="BLOCK_END_DATE")
    private Timestamp blockEndDate;
    @Column(name="BLOCK_START_DATE")
    private Timestamp blockStartDate;
    @Column(name="PAYMENT_INSTRUMENT_TYPE")
    private String paymentInstrumentType;

    private String tin;
    
    public DishonouredPaymentRegister() {
    }

    public Timestamp getBlockEndDate() {
        return blockEndDate;
    }

    public void setBlockEndDate(Timestamp blockEndDate) {
        this.blockEndDate = blockEndDate;
    }

    public Timestamp getBlockStartDate() {
        return blockStartDate;
    }

    public void setBlockStartDate(Timestamp blockStartDate) {
        this.blockStartDate = blockStartDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setPaymentInstrumentType(String paymentInstrumentType) {
        this.paymentInstrumentType = paymentInstrumentType;
    }

    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

}
