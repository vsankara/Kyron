package com.technobrain.trips.account.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.entity.model.EntEntity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Account")
@NamedQueries( { @NamedQuery(name = "Account.findAll", 
                             query = "select o from Account o")
        , 
        @NamedQuery(name = "Account.findById", 
            query = "select o from Account o where o.id=?1")
        , 
        @NamedQuery(name = "Account.findByAccountNumber", 
            query = "select o from Account o where o.accountNumber=?1"),
        @NamedQuery(name = "Account.findByEntityId", 
            query = "select o from Account o where o.entId=?1")           
        } )
@Table(name = "ACC_ACCOUNT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACCOUNT_TYPE", 
                     discriminatorType = DiscriminatorType.STRING, 
                     length = 500)
@SequenceGenerator(name = "ACC_ACCOUNT_SEQ", sequenceName = "ACC_ACCOUNT_SEQ", 
                   allocationSize = 1)
public class Account extends BaseNormalModelObject {
    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    private String accountNumber;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ACC_ACCOUNT_SEQ")
    private Long id;
    
    @OneToMany(mappedBy = "account")
    private List<AccountPeriod> accountPeriodList;
    
    @Column(name="ACCOUNT_STATUS")
    private String accountStatus;
    
    @Column(name="ENT_ENTITY")
    private Long entId;

    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID", insertable=false,updatable=false)
    private EntEntity entEntity;
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AccountPeriod> getAccountPeriodList() {
        return accountPeriodList;
    }

    public void setAccountPeriodList(List<AccountPeriod> accountPeriodList) {
        this.accountPeriodList = accountPeriodList;
    }

    public AccountPeriod addAccountPeriod(AccountPeriod accountPeriod) {
        getAccountPeriodList().add(accountPeriod);
        accountPeriod.setAccount(this);
        return accountPeriod;
    }

    public AccountPeriod removeAccountPeriod(AccountPeriod accountPeriod) {
        getAccountPeriodList().remove(accountPeriod);
        accountPeriod.setAccount(null);
        return accountPeriod;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setEntId(Long entId) {
        this.entId = entId;
    }

    public Long getEntId() {
        return entId;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
