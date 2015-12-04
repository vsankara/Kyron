package com.technobrain.trips.account.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefRevType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name="RevenueAccount")
@Table(name="ACC_REVENUE")
@DiscriminatorValue("REVENUE")       
@Inheritance
@NamedQueries({
    @NamedQuery(name="RevenueAccount.findByRevenueType", 
        query="select o from RevenueAccount o where o.revenueType=?1"),
    @NamedQuery(name="RevenueAccount.findById", 
        query="select o from RevenueAccount o where o.id=?1")
})
public class RevenueAccount extends Account {

    @Column(name = "REVENUE_TYPE")
    private String revenueType;

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }
}
