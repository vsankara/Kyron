package com.technobrain.trips.revenuecollection.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
        @NamedQuery(name = "CashTill.findAll", query = "select o from CashTill o"),
        @NamedQuery(name = "CashTill.findCashTillByCashOfficeID", query = "select o from CashTill o where o.cashOfficeId=?1"),
        @NamedQuery(name = "CashTill.findCashTillByUser", query = "select o from CashTill o where o.assignedRevOfficer=?1"), 
        @NamedQuery(name = "CashTill.findOpenCashTillByUser", query = "select o from CashTill o where o.assignedRevOfficer=?1 and o.tillStatus in(?2, ?3)"),  
        @NamedQuery(name = "CashTill.findOnlyOpenTillByUser", query = "select o from CashTill o where o.assignedRevOfficer=?1 and o.tillStatus in(?2)"),
        @NamedQuery(name = "CashTill.findCashTillByUserAndSession", query = "select o from CashTill o where o.assignedRevOfficer=?1 and o.officeSessionId=?2")
    }    
)
@Table(name = "CASH_TILL")
public class CashTill  extends BaseNormalModelObject {
   
    @Column(name="APPROVED_BY")
    private String approvedBy;
    @Column(name="ASSIGNED_REV_OFFICER")
    private String assignedRevOfficer;
    @Column(name="CASH_OFFICE_ID", nullable = false)
    private Long cashOfficeId;    
    @Column(name="FLOAT_AMOUNT")
    private BigDecimal floatAmount;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASH_TILL_SEQ")
    @SequenceGenerator(name = "CASH_TILL_SEQ", sequenceName = "CASH_TILL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="OFFICE_SESSION_ID", nullable = false)
    private Long officeSessionId;
    @Column(name="PAYMENT_COLLECTED")
    private BigDecimal paymentCollected;
    @Column(name="REV_OFFICER_RECONCIL_INPUT")
    private BigDecimal revOfficerReconcilInput;   
    @Column(name="SUP_ADJ_INPUT")
    private BigDecimal supAdjInput;
    @Column(name="TILL_ADJ_REASON")
    private String tillAdjReason;
    @Column(name="TILL_REFERENCE")
    private String tillReference;
    @Column(name="TILL_REJ_REASON")
    private String tillRejReason;
    @Column(name="TILL_STATUS")
    private String tillStatus;
    @Column(name="TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    @Column(name="APPROVED_DATE")
    private Timestamp approvedDate;
    @OneToMany(mappedBy = "cashTill", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<TillReconcilLog> tillReconcilLogList;
    @OneToMany(mappedBy = "cashTill", cascade={CascadeType.ALL})
    @OrderBy("actionedDate DESC")
    private List<TillHistory> tillHistoryList;

    public CashTill() {
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getAssignedRevOfficer() {
        return assignedRevOfficer;
    }

    public void setAssignedRevOfficer(String assignedRevOfficer) {
        this.assignedRevOfficer = assignedRevOfficer;
    }

    public Long getCashOfficeId() {
        return cashOfficeId;
    }

    public void setCashOfficeId(Long cashOfficeId) {
        this.cashOfficeId = cashOfficeId;
    }

    public BigDecimal getFloatAmount() {
        return floatAmount;
    }

    public void setFloatAmount(BigDecimal floatAmount) {
        this.floatAmount = floatAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeSessionId() {
        return officeSessionId;
    }

    public void setOfficeSessionId(Long officeSessionId) {
        this.officeSessionId = officeSessionId;
    }

    public BigDecimal getPaymentCollected() {
        return paymentCollected;
    }

    public void setPaymentCollected(BigDecimal paymentCollected) {
        this.paymentCollected = paymentCollected;
    }

    public BigDecimal getRevOfficerReconcilInput() {
        return revOfficerReconcilInput;
    }

    public void setRevOfficerReconcilInput(BigDecimal revOfficerReconcilInput) {
        this.revOfficerReconcilInput = revOfficerReconcilInput;
    }

    public BigDecimal getSupAdjInput() {
        return supAdjInput;
    }

    public void setSupAdjInput(BigDecimal supAdjInput) {
        this.supAdjInput = supAdjInput;
    }

    public String getTillAdjReason() {
        return tillAdjReason;
    }

    public void setTillAdjReason(String tillAdjReason) {
        this.tillAdjReason = tillAdjReason;
    }

    public String getTillReference() {
        return tillReference;
    }

    public void setTillReference(String tillReference) {
        this.tillReference = tillReference;
    }

    public String getTillRejReason() {
        return tillRejReason;
    }

    public void setTillRejReason(String tillRejReason) {
        this.tillRejReason = tillRejReason;
    }

    public String getTillStatus() {
        return tillStatus;
    }

    public void setTillStatus(String tillStatus) {
        this.tillStatus = tillStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TillReconcilLog> getTillReconcilLogList() {
        return tillReconcilLogList;
    }

    public void setTillReconcilLogList(List<TillReconcilLog> tillReconcilLogList) {
        this.tillReconcilLogList = tillReconcilLogList;
    }

    public TillReconcilLog addTillReconcilLog(TillReconcilLog tillReconcilLog) {
        getTillReconcilLogList().add(tillReconcilLog);
        tillReconcilLog.setCashTill(this);
        return tillReconcilLog;
    }

    public TillReconcilLog removeTillReconcilLog(TillReconcilLog tillReconcilLog) {
        getTillReconcilLogList().remove(tillReconcilLog);
        tillReconcilLog.setCashTill(null);
        return tillReconcilLog;
    }

    public List<TillHistory> getTillHistoryList() {
        return tillHistoryList;
    }

    public void setTillHistoryList(List<TillHistory> tillHistoryList) {
        this.tillHistoryList = tillHistoryList;
    }

    public TillHistory addTillHistory(TillHistory tillHistory) {
        getTillHistoryList().add(tillHistory);
        tillHistory.setCashTill(this);
        return tillHistory;
    }

    public TillHistory removeTillHistory(TillHistory tillHistory) {
        getTillHistoryList().remove(tillHistory);
        tillHistory.setCashTill(null);
        return tillHistory;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Timestamp getApprovedDate() {
        return approvedDate;
    }
}
