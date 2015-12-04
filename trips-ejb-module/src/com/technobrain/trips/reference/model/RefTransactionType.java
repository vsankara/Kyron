package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefTransactionType.findAll", 
    query = "select o from RefTransactionType o")
@Table(name = "REF_TRANSACTION_TYPE")
public class RefTransactionType extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    private String name;
    @Column(name="GL_ACC")
    private String glAcct;
    @Column(name="AR_ACC")
    private String arAcct;
    
    @ManyToOne
    @JoinColumn(name="CATEGORY" , referencedColumnName="CODE")
    private RefTransactionTypeCategory refTransactionTypeCategory;
    
    @Column(name="ACCT_TRAN")
    private String accTran;
    
    @Column(name="ACCT_TRAN_SIGN")
    private String accTranSign;
    
    public RefTransactionType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGlAcct(String glAcct) {
        this.glAcct = glAcct;
    }

    public String getGlAcct() {
        return glAcct;
    }

    public void setArAcct(String arAcct) {
        this.arAcct = arAcct;
    }

    public String getArAcct() {
        return arAcct;
    }

    

    public void setAccTran(String accTran) {
        this.accTran = accTran;
    }

    public String getAccTran() {
        return accTran;
    }

    public void setRefTransactionTypeCategory(RefTransactionTypeCategory refTransactionTypeCategory) {
        this.refTransactionTypeCategory = refTransactionTypeCategory;
    }

    public RefTransactionTypeCategory getRefTransactionTypeCategory() {
        return refTransactionTypeCategory;
    }

    public void setAccTranSign(String accTranSign) {
        this.accTranSign = accTranSign;
    }

    public String getAccTranSign() {
        return accTranSign;
    }
}
