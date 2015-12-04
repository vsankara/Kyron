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
    @NamedQuery(name = "AccRevLedTaxpayerType.findAll", query = "select o from AccRevLedTaxpayerType o"),
    @NamedQuery(name = "AccRevLedTaxpayerType.findByAccRevLedAccount", query = "select o from AccRevLedTaxpayerType o where o.accRevLedAccount.id=?1")
    }
) 
@Table(name = "ACC_REV_LED_TAXPAYER_TYPE")
public class AccRevLedTaxpayerType extends BaseNormalModelObject {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_REV_LED_TAXPAYER_TYPE_SEQ")
        @SequenceGenerator(name = "ACC_REV_LED_TAXPAYER_TYPE_SEQ", sequenceName = "ACC_REV_LED_TAXPAYER_TYPE_SEQ", allocationSize = 1)
        @Column(nullable = false)
        private Long id;
        
        @Column(name="TAXPAYER_TYPE")
        private String taxpayerType;

        @ManyToOne
        @JoinColumn(name = "REV_LED_ACCOUNT_ID", referencedColumnName = "ID")
        private AccRevLedAccount accRevLedAccount;

        public AccRevLedTaxpayerType() {
        }

        public String getTaxpayerType() {
            return taxpayerType;
        }

        public void setTaxpayerType(String taxpayerType) {
            this.taxpayerType = taxpayerType;
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
