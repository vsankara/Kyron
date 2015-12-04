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
    @NamedQuery(name = "AccRevLedBusSect.findAll", query = "select o from AccRevLedBusSect o"),
    @NamedQuery(name = "AccRevLedBusSect.findByAccRevLedAcc", query = "select busSect from AccRevLedBusSect busSect where busSect.accRevLedAccount.id=?1")
    }
) 
@Table(name = "ACC_REV_LED_BUS_SECT")
public class AccRevLedBusSect extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_BUS_SECT_SEQ")
    @SequenceGenerator(name = "ACC_REV_LED_BUS_SECT_SEQ", sequenceName = "ACC_REV_LED_BUS_SECT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="BUSINESS_SECTOR")
    private String businessSector;

    @ManyToOne
    @JoinColumn(name = "REV_LED_ACCOUNT_ID", referencedColumnName = "ID")
    private AccRevLedAccount accRevLedAccount;

    public AccRevLedBusSect() {
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
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
