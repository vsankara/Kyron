package com.technobrain.trips.document.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.technobrain.trips.listener.EntityFieldEncriptionListener;

/**
 * TechnoBrain 2015
 *
 * A card payment.
 *
 * @since	$Date: 2010-10-06 13:54:16 +0100 (Wed, 06 Oct 2010) $
 * @version	$Rev: 10378 $
 * @author	$Author: j_sweet $
 * 
 */
@Entity
@DiscriminatorValue(value="DFIN_REV_COLL_INSTR_CARD")
@Table(name = "DFIN_REV_COLL_CARD")
@EntityListeners(EntityFieldEncriptionListener.class)
public class DfinRevCollCard extends DfinRevCollInstrument {
    
	@Transient
    private String cardNumber;
	@Column(name="CARD_NUMBER")
	private String cardNumberEncrypted;

    @Column(name="CARD_TYPE")
    private String cardType;
    
    @Column(name="ISSUE_NUMBER")
    private String issueNumber;
    
    @Column(name="NAME_ON_CARD")
    private String nameOnCard;
    
    @Transient
    private String paymentAuthCode;
    @Column(name="PAYMENT_AUTH_CODE")
    private String paymentAuthCodeEncrypted;

    @Transient
    private String securityCode;
    @Column(name="SECURITY_CODE")
    private String securityCodeEncrypted;
    
    @Column(name="VALID_FROM")
    private Timestamp validFrom;
    
    @Column(name="VALID_TO")
    private Timestamp validTo;
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setPaymentAuthCode(String paymentAuthCode) {
        this.paymentAuthCode = paymentAuthCode;
    }

    public String getPaymentAuthCode() {
        return paymentAuthCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setValidFrom(Timestamp validFrom) {
        this.validFrom = validFrom;
    }

    public Timestamp getValidFrom() {
        return validFrom;
    }

    public void setValidTo(Timestamp validTo) {
        this.validTo = validTo;
    }

    public Timestamp getValidTo() {
        return validTo;
    }

	public String getCardNumberEncrypted() {
		return cardNumberEncrypted;
	}

	public void setCardNumberEncrypted(String cardNumberEncrypted) {
		this.cardNumberEncrypted = cardNumberEncrypted;
	}

	public String getPaymentAuthCodeEncrypted() {
		return paymentAuthCodeEncrypted;
	}

	public void setPaymentAuthCodeEncrypted(String paymentAuthCodeEncrypted) {
		this.paymentAuthCodeEncrypted = paymentAuthCodeEncrypted;
	}

	public String getSecurityCodeEncrypted() {
		return securityCodeEncrypted;
	}

	public void setSecurityCodeEncrypted(String securityCodeEncrypted) {
		this.securityCodeEncrypted = securityCodeEncrypted;
	}

	
    
}