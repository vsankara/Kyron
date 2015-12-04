package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "AccChartOfAccounts.findAllAccChartOfAccounts", 
    query = "select o from AccChartOfAccounts o order by o.accountCode asc")
@Table(name = "ACC_CHART_OF_ACCOUNTS")
public class AccChartOfAccounts  extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_CHART_OF_ACCOUNTS_SEQ")
    @SequenceGenerator(name = "ACC_CHART_OF_ACCOUNTS_SEQ", sequenceName = "ACC_CHART_OF_ACCOUNTS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;    
    @OneToMany(mappedBy = "parentCategory", cascade={CascadeType.ALL})
    private List<AccChartOfAccounts> subCategories;
    
    
    @Column(name="ACCOUNT_CODE", nullable = false)
    private String accountCode;
    @Column(name="BUSINESS_SECTOR_DIVISION")
    private String businessSectorDivision;
    @Column(name="CURRENT_ACCOUNT")
    private String currentAccount;
    @Column(nullable = false)
    private String description;
    @Column(name="EFFECTIVE_DATE", nullable = false)
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE", nullable = false)
    private Timestamp expiryDate;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private AccChartOfAccounts parentCategory;

    @OneToMany(mappedBy = "accChartOfAccounts", cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private List<AccRevLedAccount> accRevLedAccountList;

    public AccChartOfAccounts() {
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getBusinessSectorDivision() {
        return businessSectorDivision;
    }

    public void setBusinessSectorDivision(String businessSectorDivision) {
        this.businessSectorDivision = businessSectorDivision;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount) {
        this.currentAccount = currentAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AccRevLedAccount> getAccRevLedAccountList() {
        if(accRevLedAccountList == null){
            accRevLedAccountList = new ArrayList<AccRevLedAccount>();
        }
        return accRevLedAccountList;
    }

    public void setAccRevLedAccountList(List<AccRevLedAccount> accRevLedAccountList) {
        this.accRevLedAccountList = accRevLedAccountList;
    }

    public AccRevLedAccount addAccRevLedAccount(AccRevLedAccount accRevLedAccount) {
        getAccRevLedAccountList().add(accRevLedAccount);
        accRevLedAccount.setAccChartOfAccounts(this);
        return accRevLedAccount;
    }

    public AccRevLedAccount removeAccRevLedAccount(AccRevLedAccount accRevLedAccount) {
        getAccRevLedAccountList().remove(accRevLedAccount);
        accRevLedAccount.setAccChartOfAccounts(null);
        return accRevLedAccount;
    }

    public void setParentField(AccChartOfAccounts parentCategory, boolean addToChildren) {
        this.parentCategory = parentCategory;
        if(addToChildren && parentCategory != null) {
            parentCategory.addSubCategory(this);
        }
    }

    public void setParentField(AccChartOfAccounts parentCategory) {
        setParentField(parentCategory, true);
    }

    public AccChartOfAccounts getParentField() {
        return parentCategory;
    }

    public void setSubCategories(List<AccChartOfAccounts> subCategories) {
        this.subCategories = subCategories;
    }

    public List<AccChartOfAccounts> getSubCategories() {
        if(subCategories == null){
            subCategories = new ArrayList<AccChartOfAccounts>();
        }
        return subCategories;
    }
    
    public List<AccChartOfAccounts> getSortedSubCategories() {
//        Collections.sort(subCategories, new FieldOrderComparator());
        return subCategories;
    }
    
    public AccChartOfAccounts addSubCategory(AccChartOfAccounts child) {
        getSubCategories().add(child);
        child.setParentField(this, false);
        return child;
    }

    public AccChartOfAccounts removeSubCategory(AccChartOfAccounts child) {
        getSubCategories().remove(child);
        child.setParentField(null);
        return child;
    }
}