package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefTransactionClass.findAll", 
    query = "select o from RefTransactionClass o")
@Table(name = "REF_TRANSACTION_CLASS")
public class RefTransactionClass extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
     
     
     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
     
     
     
     
//    @OneToMany(mappedBy = "transactionClass")
//    private List<RefTransactionType> refTransactionTypeList;

    public RefTransactionClass() {
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
/*    
    public void setRefTransactionTypeList(List<RefTransactionType> refTransactionTypeList) {
        this.refTransactionTypeList = refTransactionTypeList;
    }

    public List<RefTransactionType> getRefTransactionTypeList() {
        return refTransactionTypeList;
    }
    
    public RefTransactionType addRefTransactionType(RefTransactionType refTransactionType){
        getRefTransactionTypeList().add(refTransactionType);
//        refTransactionType.setTransactionClass(this);
        return refTransactionType;
    }
    
    public RefTransactionType removeRefTransactionType(RefTransactionType refTransactionType){
        getRefTransactionTypeList().remove(refTransactionType);
//        refTransactionType.setTransactionClass(null);
        return refTransactionType;
    }
*/    
}
