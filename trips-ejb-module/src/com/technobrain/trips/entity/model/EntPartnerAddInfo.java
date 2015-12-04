package com.technobrain.trips.entity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity

@NamedQueries( { @NamedQuery(name = "EntPartnerAddInfo.findAll", query = "select o from EntPartnerAddInfo o")
        } )
@Table(name = "ENT_PARTNER_ADD_INFO")
@DiscriminatorValue("PARTNER")
public class EntPartnerAddInfo extends EntRelationship {
    @Column(name = "PAST_PERSONAL_SAVINGS_IND")
    private String pastPersonalSavingsInd;
    @Column(name = "SHARE_OF_CAPITAL")
    private Long shareOfCapital;
    @Column(name = "SHARE_OF_PROFIT")
    private Long shareOfProfit;

    public EntPartnerAddInfo() {
    }

    public String getPastPersonalSavingsInd() {
        return pastPersonalSavingsInd;
    }

    public void setPastPersonalSavingsInd(String pastPersonalSavingsInd) {
        this.pastPersonalSavingsInd = pastPersonalSavingsInd;
    }

    public Long getShareOfCapital() {
        return shareOfCapital;
    }

    public void setShareOfCapital(Long shareOfCapital) {
        this.shareOfCapital = shareOfCapital;
    }

    public Long getShareOfProfit() {
        return shareOfProfit;
    }

    public void setShareOfProfit(Long shareOfProfit) {
        this.shareOfProfit = shareOfProfit;
    }

}
