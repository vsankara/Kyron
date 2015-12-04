package com.technobrain.trips.document.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.entity.model.EntNonTaxpayerIndividual;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries( 
    {
        @NamedQuery(name = "DfinRevCollReceipt.findAll", 
            query = "select o from DfinRevCollReceipt o"),
            @NamedQuery(name = "DfinRevCollReceipt.findByReceiptNumberOnPaper", 
            query = "select o from DfinRevCollReceipt o where o.receiptNumberOnPaper=?1 "),
        @NamedQuery(name = "DfinRevCollReceipt.findById", 
            query = "select o from DfinRevCollReceipt o where o.id = ?1")
    }
)
@Table(name = "DFIN_REV_COLL_RECEIPT")
@DiscriminatorValue(value="DFIN_DOC_REV_COLL_RECEIPT")
@Inheritance
public class DfinRevCollReceipt extends DfinDocument {
    
    @Column(name="PAYMENT_AMOUNT")
    private BigDecimal paymentAmount;
    
    @Column(name="PAYMENT_DATE")
    private Timestamp paymentDate;
    
    @Column(name="NON_REG_TAXPAYER_ID")
    private Long nonRegTaxpayerId;
    
    private String currency;

    @Column(name="RECEIPT_NUMBER_ON_PAPER")
    private String receiptNumberOnPaper;

    @Column(name="PAYMENT_SOURCE")
    private String paymentSource;
    
    @Column(name="TILL_ID")
    private Long tillId;

    @OneToMany(cascade={CascadeType.ALL},mappedBy = "receipt")
    private List<DfinRevCollInstrument> instrumentList;
    
    //The following field is for receipt no generation   
    @ReferenceNumber(format = "ATTRIBUTE(issueOffice)/SQL", 
                     sql = "SELECT ATTRIBUTE(tillId)||'/'||to_char(sysdate,'YYYY')||'/'||LTRIM(TO_CHAR(MOD(DCASE_DEBT_NOTICE_SEQ.nextval,100000),'000000099')) as generatedId FROM dual")
    @Transient
    private String receiptReference;
    
    public DfinRevCollReceipt() {
        setDocType("RECEIPT");
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setInstrumentList(List<DfinRevCollInstrument> instrumentList) {
        this.instrumentList = instrumentList;
    }

    public List<DfinRevCollInstrument> getInstrumentList() {
        return instrumentList;
    }
    
    public void addInstrument(DfinRevCollInstrument instrument){
        if(instrumentList == null){
            instrumentList = new ArrayList<DfinRevCollInstrument>();
    }
        instrumentList.add(instrument);
        instrument.setReceipt(this);
    }
        
    public void removeInstrument(DfinRevCollInstrument instrument){
        instrumentList.remove(instrument);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setReceiptNumberOnPaper(String receiptNumberOnPaper) {
        this.receiptNumberOnPaper = receiptNumberOnPaper;
    }

    public String getReceiptNumberOnPaper() {
        return receiptNumberOnPaper;
    }

    public void setPaymentSource(String paymentSource) {
        this.paymentSource = paymentSource;
    }

    public String getPaymentSource() {
        return paymentSource;
    }

    public void setNonRegTaxpayerId(Long nonRegTaxpayerId) {
        this.nonRegTaxpayerId = nonRegTaxpayerId;
    }

    public Long getNonRegTaxpayerId() {
        return nonRegTaxpayerId;
    }

    public void setTillId(Long tillId) {
        this.tillId = tillId;
    }

    public Long getTillId() {
        return tillId;
    }

    public void setReceiptReference(String receiptReference) {
        this.receiptReference = receiptReference;
    }

    public String getReceiptReference() {
        return receiptReference;
    }
}
