package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.revenueaccount.model.AccChartOfAccounts;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries (
    {
        @NamedQuery(name = "AccRevLedAccount.findAll", query = "select o from AccRevLedAccount o"),
        @NamedQuery(name = "AccRevLedAccount.findByChartOfAccountId", query = "select o from AccRevLedAccount o where o.accChartOfAccounts.id=?1"),
        @NamedQuery(name = "AccRevLedAccount.findLedgerAccountByCode", query = "select o from AccRevLedAccount o where o.accountCode=?1")
  //      @NamedQuery(name = "AccRevLedAccount.findLedgerAccountByRevenueType", query = "select o from AccRevLedAccount o where ?1 in (Select acc.revenueType from AccRevLedAccount acc")
    }
) 
@Table(name = "ACC_REV_LED_ACCOUNT")
public class AccRevLedAccount extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_ACCOUNT_SEQ")
    @SequenceGenerator(name = "ACC_REV_LED_ACCOUNT_SEQ", sequenceName = "ACC_REV_LED_ACCOUNT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ACCOUNT_CODE")
    private String accountCode;
    @Column(name="ACCOUNT_STATUS")
    private String accountStatus;

    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    @Column(name="OLD_CODE")
    private String oldCode;
    
    @Column(name="NON_TRIPS_ACCOUNT")
    private String nonTripsAccount;

    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedRevenueType> accRevLedRevenueTypeList;
    
/*    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "REVENUE_TYPE_ID", referencedColumnName = "ID")
    private AccRevLedRevenueType accRevLedRevenueType;
*/    
    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedBusSect> accRevLedBusSectList;
    
    @ManyToOne    
    @JoinColumn(name = "CHART_OF_ACCOUNT_ID", referencedColumnName = "ID")
    private AccChartOfAccounts accChartOfAccounts;
    
    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedDocType> accRevLedDocTypeList;
    
    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedChargeType> accRevLedChargeTypeList;
    
    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedTaxpayerType> accRevLedTaxpayerTypeList;
    
    @OneToMany(mappedBy = "accRevLedAccount", cascade={CascadeType.ALL})
    private List<AccRevLedSubTaxCategory> accRevLedSubTaxCategoryList;
    
    public AccRevLedAccount() {
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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

/*    public AccRevLedRevenueType getAccRevLedRevenueType() {
        return accRevLedRevenueType;
    }

    public void setAccRevLedRevenueType(AccRevLedRevenueType accRevLedRevenueType) {
        this.accRevLedRevenueType = accRevLedRevenueType;
    }
/*
    public AccRevLedRevenueType addAccRevLedRevenueType(AccRevLedRevenueType accRevLedRevenueType) {
        getAccRevLedRevenueTypeList().add(accRevLedRevenueType);
        accRevLedRevenueType.setAccRevLedAccount(this);
        return accRevLedRevenueType;
    }

    public AccRevLedRevenueType removeAccRevLedRevenueType(AccRevLedRevenueType accRevLedRevenueType) {
        getAccRevLedRevenueTypeList().remove(accRevLedRevenueType);
        accRevLedRevenueType.setAccRevLedAccount(null);
        return accRevLedRevenueType;
    }
*/
    public List<AccRevLedBusSect> getAccRevLedBusSectList() {
        return accRevLedBusSectList;
    }

    public void setAccRevLedBusSectList(List<AccRevLedBusSect> accRevLedBusSectList) {
        this.accRevLedBusSectList = accRevLedBusSectList;
    }

    public AccRevLedBusSect addAccRevLedBusSect(AccRevLedBusSect accRevLedBusSect) {
        getAccRevLedBusSectList().add(accRevLedBusSect);
        accRevLedBusSect.setAccRevLedAccount(this);
        return accRevLedBusSect;
    }

    public AccRevLedBusSect removeAccRevLedBusSect(AccRevLedBusSect accRevLedBusSect) {
        getAccRevLedBusSectList().remove(accRevLedBusSect);
        accRevLedBusSect.setAccRevLedAccount(null);
        return accRevLedBusSect;
    }

    public AccChartOfAccounts getAccChartOfAccounts() {
        return accChartOfAccounts;
    }

    public void setAccChartOfAccounts(AccChartOfAccounts accChartOfAccounts) {
        this.accChartOfAccounts = accChartOfAccounts;
    }

    public List<AccRevLedDocType> getAccRevLedDocTypeList() {
        return accRevLedDocTypeList;
    }

    public void setAccRevLedDocTypeList(List<AccRevLedDocType> accRevLedDocTypeList) {
        this.accRevLedDocTypeList = accRevLedDocTypeList;
    }

    public AccRevLedDocType addAccRevLedDocType(AccRevLedDocType accRevLedDocType) {
        getAccRevLedDocTypeList().add(accRevLedDocType);
        accRevLedDocType.setAccRevLedAccount(this);
        return accRevLedDocType;
    }

    public AccRevLedDocType removeAccRevLedDocType(AccRevLedDocType accRevLedDocType) {
        getAccRevLedDocTypeList().remove(accRevLedDocType);
        accRevLedDocType.setAccRevLedAccount(null);
        return accRevLedDocType;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    public String getOldCode() {
        return oldCode;
    }

    public void setAccRevLedRevenueTypeList(List<AccRevLedRevenueType> accRevLedRevenueTypeList) {
        this.accRevLedRevenueTypeList = accRevLedRevenueTypeList;
    }

    public List<AccRevLedRevenueType> getAccRevLedRevenueTypeList() {
        return accRevLedRevenueTypeList;
    }


    public void setAccRevLedChargeTypeList(List<AccRevLedChargeType> accRevLedChargeTypeList) {
        this.accRevLedChargeTypeList = accRevLedChargeTypeList;
    }

    public List<AccRevLedChargeType> getAccRevLedChargeTypeList() {
        return accRevLedChargeTypeList;
    }

    public void setAccRevLedTaxpayerTypeList(List<AccRevLedTaxpayerType> accRevLedTaxpayerTypeList) {
        this.accRevLedTaxpayerTypeList = accRevLedTaxpayerTypeList;
    }

    public List<AccRevLedTaxpayerType> getAccRevLedTaxpayerTypeList() {
        return accRevLedTaxpayerTypeList;
    }

    public void setAccRevLedSubTaxCategoryList(List<AccRevLedSubTaxCategory> accRevLedSubTaxCategoryList) {
        this.accRevLedSubTaxCategoryList = accRevLedSubTaxCategoryList;
    }

    public List<AccRevLedSubTaxCategory> getAccRevLedSubTaxCategoryList() {
        return accRevLedSubTaxCategoryList;
    }

    public void setNonTripsAccount(String nonTripsAccount) {
        this.nonTripsAccount = nonTripsAccount;
    }

    public String getNonTripsAccount() {
        return nonTripsAccount;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }
}
