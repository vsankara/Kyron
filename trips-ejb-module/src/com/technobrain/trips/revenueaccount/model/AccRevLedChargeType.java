package com.technobrain.trips.revenueaccount.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.revenueaccount.model.AccRevLedAccount;

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
    @NamedQuery(name = "AccRevLedChargeType.findAll", query = "select o from AccRevLedChargeType o"),
    @NamedQuery(name = "AccRevLedChargeType.findByAccRevLedAccount", query = "select o from AccRevLedChargeType o where o.accRevLedAccount.id=?1")
    }
) 
@Table(name = "ACC_REV_LED_CHARGE_TYPE")
public class AccRevLedChargeType extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_CHARGE_TYPE_SEQ")
    @SequenceGenerator(name = "ACC_REV_LED_CHARGE_TYPE_SEQ", sequenceName = "ACC_REV_LED_CHARGE_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="CHARGE_TYPE")
    private String chargeType;

    @ManyToOne
    @JoinColumn(name = "REV_LED_ACCOUNT_ID", referencedColumnName = "ID")
    private AccRevLedAccount accRevLedAccount;

    public AccRevLedChargeType() {
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccRevLedAccount getAccRevLedAccount() {
        return accRevLedAccount;
    }

    public void setAccRevLedAccount(AccRevLedAccount accRevLedAccount) {
        this.accRevLedAccount = accRevLedAccount;
    }
}
