package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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


@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AccRevLedRevenueType.findAll", query = "select o from AccRevLedRevenueType o"),
    @NamedQuery(name = "AccRevLedRevenueType.findByAccRevLedAccount", query = "select o from AccRevLedRevenueType o where o.accRevLedAccount.id=?1"),
    @NamedQuery(name = "AccRevLedRevenueType.findLedgerAccountByRevenueType", query = "select acc.accRevLedAccount from AccRevLedRevenueType acc where acc.revenueType = ?1")
    }
)     
@Table(name = "ACC_REV_LED_REVENUE_TYPE")
public class AccRevLedRevenueType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_REVENUE_TYPE_SEQ")
    @SequenceGenerator(name = "ACC_REV_LED_REVENUE_TYPE_SEQ", sequenceName = "ACC_REV_LED_REVENUE_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="REVENUE_TYPE")
    private String revenueType;

    @ManyToOne
    @JoinColumn(name = "REV_LED_ACCOUNT_ID", referencedColumnName = "ID")
    private AccRevLedAccount accRevLedAccount;

    public AccRevLedRevenueType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public AccRevLedAccount getAccRevLedAccount() {
        return accRevLedAccount;
    }

    public void setAccRevLedAccount(AccRevLedAccount accRevLedAccount) {
        this.accRevLedAccount = accRevLedAccount;
    }
}
