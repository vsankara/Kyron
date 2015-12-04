package com.technobrain.trips.account.model;

import com.technobrain.trips.core.annotation.ReferenceNumber;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import com.technobrain.trips.dto.tax.accounting.PostingAllocationObject;

import com.technobrain.trips.instalmentagreement.model.InstalmentTransaction;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * TechnoBrain 2010
 *
 * Records transactions against an account.
 *
 * @since	November 2010
 * @author	j_sweet
 * 
 */
@Entity
@NamedQueries


( { @NamedQuery(name = "AccountTransaction.findAll", 
                query = "select o from AccountTransaction o")
        , 
        @NamedQuery(name = "AccountTransaction.findById", 
                    query = 
                    "select o from AccountTransaction o where o.id = ?1")
        , 
        @NamedQuery(name = "AccountTransaction.findAllocationsByTransactionId", 
                    query = 
                    "select o from AccTranAllocation o where o.targetTransaction = ?1 or o.sourceTransaction = ?1")
        , 
        @NamedQuery(name = "AccountTransaction.findOffsetTransactionsByAccountAndType", query = 
                    "select o from AccountTransaction o where o.accAccount = ?1 and o.transactionType <> ?2 and o.balance <> 0")
        , 
        @NamedQuery(name = "AccountTransaction.findOffsetTransactionsByPeriod", query = 
                    "select o from AccountTransaction o where o.accAccount = ?1 and o.accountPeriod = ?2 and o.transactionType <> ?3 and o.balance <> 0")
        , 
        @NamedQuery(name = "AccountTransaction.findByTypeAndId", query = "select o from AccountTransaction o where o.transactionType=?1 and o.id IN (?2)")
        , 
        @NamedQuery(name = "AccountTransaction.findTransactionsByAccountNumber", 
                    query = 
                    "select o from AccountTransaction o where o.accAccount=?1 ")
                , 
        @NamedQuery(name = "AccountTransaction.findTransactionsByTransactionIds", 
                    query = 
                    "select o from AccountTransaction o where o.id IN (?1) "),
                    
        @NamedQuery(name = "AccountTransaction.findTransactionByTransactionRef", 
                    query = 
                    "select o from AccountTransaction o where o.transactionRef=?1 "),
                    
        @NamedQuery(name = "AccountTransaction.findTransactionsByTransactionRefs", 
                    query = 
                    "select o from AccountTransaction o where o.transactionRef in (?1) ")
        } )
@Table(name = "ACC_TRANSACTION")
@SequenceGenerator(name = "ACC_TRANSACTION_SEQ", 
                   sequenceName = "ACC_TRANSACTION_SEQ", initialValue = 1, 
                   allocationSize = 1)
public class AccountTransaction extends BaseNormalModelObject {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ACC_TRANSACTION_SEQ")
    private Long id;
    @Column(name = "TRANSACTION_REF")
    @ReferenceNumber(format = "TRAN/SQL", 
                     sql = "SELECT LTRIM(TO_CHAR(MOD(ACC_TRANSACTION_SEQ.nextval,100000),'000099'))||'/'" + 
                     "||to_char(sysdate,'YYYY') as generatedId FROM dual")
    private String transactionRef;
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;
    @Column(name = "CHARGE_TYPE")
    private String chargeType;
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "ACC_REV_LED")
    private Long accRevLedId;

    @Column(name = "ACCOUNT_PERIOD")
    private Long accountPeriod;

    @Column(name = "ACC_ACCOUNT")
    private Long accAccount;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "TRANSACTION_DATE")
    private Timestamp transactionDate;

    @Transient 
    private Long chargeId;
    @Transient
    private Long eventId;
    
    private transient Long instalmentId;
    
    private transient List<PostingAllocationObject> targetAllocationList;
    
    @JoinColumn(name = "ID", referencedColumnName = "TRANSACTION_ID", insertable=false,updatable=false)
    private InstalmentTransaction instalmentTransaction;
    
    public AccountTransaction() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionId) {
        this.transactionRef = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAccountPeriod(Long accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public Long getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccAccount(Long accAccount) {
        this.accAccount = accAccount;
    }

    public Long getAccAccount() {
        return accAccount;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setAccRevLedId(Long accRevLedId) {
        this.accRevLedId = accRevLedId;
    }

    public Long getAccRevLedId() {
        return accRevLedId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setInstalmentId(Long instalmentId) {
        this.instalmentId = instalmentId;
    }

    public Long getInstalmentId() {
        return instalmentId;
    }

    public void setTargetAllocationList(List<PostingAllocationObject> targetAllocationList) {
        this.targetAllocationList = targetAllocationList;
    }

    public List<PostingAllocationObject> getTargetAllocationList() {
        return targetAllocationList;
    }

    public void setInstalmentTransaction(InstalmentTransaction instalmentTransaction) {
        this.instalmentTransaction = instalmentTransaction;
    }

    public InstalmentTransaction getInstalmentTransaction() {
        return instalmentTransaction;
    }
}
