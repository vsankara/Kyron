package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.listener.EntityFieldEncriptionListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * TechnoBrain 2006
 *
 * This entity represents bank details
 *
 * @since	$Date: 7/13/2009 10:21:26 AM$
 * @version 	$Revision: 8$
 * @author 	$Author: Ashok Dorairaj$
 *
 * $Log[1]:
 *  8    TRIPS2    1.7         7/13/2009 10:21:26 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */
@Entity
@NamedQuery(name = "EntBankDetails.findAll", 
    query = "select o from EntBankDetails o")
@Table(name = "ENT_BANK_DETAILS")
@SequenceGenerator(name = "ENT_BANK_DETAILS_SEQ", 
                   sequenceName = "ENT_BANK_DETAILS_SEQ", initialValue = 1, 
                   allocationSize = 1)
@EntityListeners(EntityFieldEncriptionListener.class)
public class EntBankDetails extends BaseNormalModelObject {
    @Column(name="ACCOUNT_NAME")
    private String accountName;
    @Transient
    private String bankAccountNo;
    @Column(name="BANK_ACCOUNT_NO")
    private String bankAccountNoEncrypted;
    @Column(name="BANK_NAME")
    private String bankName;
    @Transient
    private String iban;
    @Column(name="IBAN")
    private String ibanEncrypted;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ENT_BANK_DETAILS_SEQ")
    private Long id;
    @Transient
    private String sortcode;
    @Column(name="SORTCODE")
    private String sortcodeEncrypted;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;

    @Column(name="BANK_ACCOUNT_STATUS")
    private String bankAccountStatus;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    @Column(name="BRANCH_NAME")
    private String bankBranch;
    @Transient
    private String swiftCode;
    @Column(name="SWIFTCODE")
    private String swiftCodeEncrypted;


    public EntBankDetails() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    public void setParentEntity(EntEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setBankAccountStatus(String bankAccountStatus) {
        this.bankAccountStatus = bankAccountStatus;
    }

    public String getBankAccountStatus() {
        return bankAccountStatus;
    }
    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

	public String getBankAccountNoEncrypted() {
		return bankAccountNoEncrypted;
	}

	public void setBankAccountNoEncrypted(String bankAccountNoEncrypted) {
		this.bankAccountNoEncrypted = bankAccountNoEncrypted;
	}

	public String getIbanEncrypted() {
		return ibanEncrypted;
	}

	public void setIbanEncrypted(String ibanEncrypted) {
		this.ibanEncrypted = ibanEncrypted;
	}

	public String getSortcodeEncrypted() {
		return sortcodeEncrypted;
	}

	public void setSortcodeEncrypted(String sortcodeEncrypted) {
		this.sortcodeEncrypted = sortcodeEncrypted;
	}

	public String getSwiftCodeEncrypted() {
		return swiftCodeEncrypted;
	}

	public void setSwiftCodeEncrypted(String swiftCodeEncrypted) {
		this.swiftCodeEncrypted = swiftCodeEncrypted;
	}
    
    
}
