package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TechnoBrain 2006
 *
 * This entity represents card details
 *
 * @since $Date: 7/13/2009 10:21:28 AM$
 * @version   $Revision: 6$
 * @author  $Author: Ashok Dorairaj$
 *
 * $Log[1]:
 *  6    TRIPS2    1.5         7/13/2009 10:21:28 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */


/**
 * TechnoBrain 2006
 *
 * This entity represents card details
 *
 * @since $Date: 7/13/2009 10:21:28 AM$
 * @version   $Revision: 6$
 * @author  $Author: Ashok Dorairaj$
 *
 * $Log[1]:
 *  6    TRIPS2    1.5         7/13/2009 10:21:28 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */
@Entity
@NamedQuery(name = "EntPayCardDetails.findAll",
    query = "select o from EntPayCardDetails o")
@Table(name = "ENT_PAY_CARD_DETAILS")
@SequenceGenerator(name = "ENT_PAY_CARD_DETAILS_SEQ",
                   sequenceName = "ENT_PAY_CARD_DETAILS_SEQ", initialValue = 1,
                   allocationSize = 1)

public class EntPayCardDetails extends BaseNormalModelObject {
    @Column(name="ACCOUNT_NAME")
    private String accountName;
    @Column(name="ISSUER")
    private String issuer;
    @Column(name="CARD_NUMBER")
    private String cardNumber;
    @Column(name="CARD_TYPE")
    private String cardType;
    @Column(name="CREDIT_OR_DEBIT")
    private String creditOrDebit;
    @Column(name="END_DATE")
    private Timestamp endDate;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "ENT_PAY_CARD_DETAILS_SEQ")
    private Long id;
    @Column(name="ISSUE_NO")
    private Long issueNo;
    @Column(name="SECURITY_CODE")
    private String securityCode;
    @Column(name="START_DATE")
    private Timestamp startDate;
    @Column(name="CARD_STATUS")
    private String cardStatus;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;

    public EntPayCardDetails() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCreditOrDebit () {
        return creditOrDebit;
    }

    public void setCreditOrDebit(String creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(Long issueNo) {
        this.issueNo = issueNo;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setParentEntity(EntEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }
}

