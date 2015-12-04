package com.technobrain.trips.account.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefReturnType;

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


@Entity(name = "AccountPeriod")
@Table(name = "ACC_PERIOD")
@NamedQueries( { @NamedQuery(name = "AccountPeriod.findById", 
                             query = "select o from AccountPeriod o where o.id=?1"),
                 @NamedQuery(name = "AccountPeriod.findAll", 
                             query = "select o from AccountPeriod o"),
                 @NamedQuery(name = "AccountPeriod.findByAccountId", 
                             query ="select o from AccountPeriod o where o.account.id=?1 and o.periodStatus=?2" ),
                 @NamedQuery(name = "AccountPeriod.findPeriodsByAccountNumber", 
                             query ="select o from AccountPeriod o where o.account.accountNumber=?1" ),
                 @NamedQuery(name = "AccountPeriod.updatePeriodStatus",
                             query = "UPDATE AccountPeriod o SET o.status = ?1, o.periodStatus=?2 WHERE o.accAccountId = ?3"),             
                @NamedQuery(name = "AccountPeriod.findCurrentPeriodByAccountId", 
                            query = "select o from AccountPeriod o where o.account.id = ?1 " +
                                    "and o.periodStartDate <= CURRENT_TIMESTAMP " +
                                    "and (o.periodEndDate >= CURRENT_TIMESTAMP or o.periodEndDate is NULL) "),
                @NamedQuery(name = "AccountPeriod.findPeriodForGivenDateByAccountId", 
                            query = "select o from AccountPeriod o where o.account.id = ?1 " +
                                    "and o.periodStartDate <= ?2 " +
                                    "and (o.periodEndDate >= ?2 or o.periodEndDate is NULL) "),
               @NamedQuery(name = "AccountPeriod.findPeriodByAccountIdAndPeriodYear", 
                            query = "select pitP from AccountPeriod pitP where pitP.accAccountId = ?1 " +
                                    "and pitP.returnType in (select rrt.code from RefReturnType rrt where rrt.refRevType = ?2 ) " +
                                    "and pitP.periodYear = (select payeP.periodYear from AccountPeriod payeP where payeP.id= ?3) "),
                @NamedQuery(name = "AccountPeriod.findPeriodBetweenDatesByAccountId", 
                            query = "select o from AccountPeriod o where o.account.id = ?1 " +
                                    "and ?2 between o.periodStartDate and o.periodEndDate"),                                    
               @NamedQuery(name = "AccountPeriod.findIdByAccountNumberPeriodNoAndYear", 
                             query ="select o from AccountPeriod o where o.account.accountNumber=?1 and o.periodNo=?2 and o.periodYear=?3 and o.returnDocument=?4" ),
              @NamedQuery(name = "AccountPeriod.findAccountPeriodIdByAccountNoAndReturn", 
                            query ="select ap from AccountPeriod ap where ap.account.accountNumber=?1 and ap.returnDocument=?2 and ap.periodStatus=?3" ),            
              @NamedQuery(name = "AccountPeriod.findAccountPeriodByEntityAndReturnType", 
                            query ="select ap from AccountPeriod ap, RegTaxpayerStatusView rtsv, RefReturnType rr where ap.accAccountId=rtsv.taxpayerAccountId and ap.returnType=rr.code and rr.refRevMode.code=?3 and rtsv.entEntity.id=?1 and ap.returnType=?2 and ap.status='A' and ap.periodEndDate < CURRENT_TIMESTAMP" )                                        
        } )
        
public class AccountPeriod extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_PERIOD_SEQ")
    @SequenceGenerator(name = "ACC_PERIOD_SEQ", sequenceName = "ACC_PERIOD_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @Column(name = "PERIOD_DUE_DATE")
    private Timestamp periodDueDate;
    @Column(name = "PERIOD_END_DATE")
    private Timestamp periodEndDate;
    @Column(name = "PERIOD_NO")
    private Integer periodNo;
    @Column(name = "PERIOD_START_DATE")
    private Timestamp periodStartDate;
    @Column(name = "PERIOD_STATUS")
    private String periodStatus;
    @Column(name = "PERIOD_YEAR")
    private Integer periodYear;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "ACC_ACCOUNT")
    private Long accAccountId;
    @ManyToOne
    @JoinColumn(name = "ACC_ACCOUNT", referencedColumnName = "ID", insertable=false,updatable=false)
    private Account account;
    @Column(name="PAYMENT_DUE_DATE")
    private Timestamp paymentDue;
    @Column(name="PROVISIONAL_RETURN_DUE")
    private Timestamp provisionalReturnDue;
    @Column(name = "ANNUAL_APPLIED_INDICATOR")
    private String annualAppliedIndicator;
    @Column(name = "QUARTER_APPLIED_INDICATOR")
    private String quarterAppliedIndicator;
    @Column(name = "PERIOD_TYPE")
    private String periodType;
    @Column(name="PERIOD_LABEL")
    private String periodLabel;
    @Column(name="PERIOD_QUARTER")
    private Integer periodQuarter;
    
    @Column(name="DOCUMENT_TYPE")
    private String returnDocument;
    
    @Column(name="RETURN_TYPE")
    private String returnType;
    
    @JoinColumn(name = "RETURN_TYPE",referencedColumnName = "CODE", insertable=false,updatable=false)
    private RefReturnType refReturnType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPeriodDueDate() {
        return periodDueDate;
    }

    public void setPeriodDueDate(Timestamp periodDueDate) {
        this.periodDueDate = periodDueDate;
    }

    public Timestamp getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public Integer getPeriodNo() {
        return periodNo;
    }

    public void setPeriodNo(Integer periodNo) {
        this.periodNo = periodNo;
    }

    public Timestamp getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(Timestamp periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodStatus() {
        return periodStatus;
    }

    public void setPeriodStatus(String periodStatus) {
        this.periodStatus = periodStatus;
    }

    public Integer getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(Integer periodYear) {
        this.periodYear = periodYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAccAccountId(Long accAccountId) {
        this.accAccountId = accAccountId;
    }

    public Long getAccAccountId() {
        return accAccountId;
    }

    public void setPaymentDue(Timestamp paymentDue) {
        this.paymentDue = paymentDue;
    }

    public Timestamp getPaymentDue() {
        return paymentDue;
    }

    public void setProvisionalReturnDue(Timestamp provisionalReturnDue) {
        this.provisionalReturnDue = provisionalReturnDue;
    }

    public Timestamp getProvisionalReturnDue() {
        return provisionalReturnDue;
    }

    public void setAnnualAppliedIndicator(String annualAppliedIndicator) {
        this.annualAppliedIndicator = annualAppliedIndicator;
    }

    public String getAnnualAppliedIndicator() {
        return annualAppliedIndicator;
    }

    public void setQuarterAppliedIndicator(String quarterAppliedIndicator) {
        this.quarterAppliedIndicator = quarterAppliedIndicator;
    }

    public String getQuarterAppliedIndicator() {
        return quarterAppliedIndicator;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodLabel(String periodLabel) {
        this.periodLabel = periodLabel;
    }

    public String getPeriodLabel() {
        return periodLabel;
    }

    public void setPeriodQuarter(Integer periodQuarter) {
        this.periodQuarter = periodQuarter;
    }

    public Integer getPeriodQuarter() {
        return periodQuarter;
    }

    public void setReturnDocument(String returnDocument) {
        this.returnDocument = returnDocument;
    }

    public String getReturnDocument() {
        return returnDocument;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setRefReturnType(RefReturnType refReturnType) {
        this.refReturnType = refReturnType;
    }

    public RefReturnType getRefReturnType() {
        return refReturnType;
    }
}
