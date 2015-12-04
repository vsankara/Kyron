package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( { @NamedQuery(name = "RefAllocationCriteria.findAll", 
                             query = "select o from RefAllocationCriteria o"),
                 @NamedQuery(name = "RefAllocationCriteria.findCriteriasByMethod", 
                  query = "select c from RefAllocationCriteria c where  c.refAllocationMethod=?1")
        } )  
@Table(name = "REF_ALLOCATION_CRITERIA")
public class RefAllocationCriteria extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    //@ManyToOne(targetEntity=RefAllocationMethod.class)
    //@JoinColumn(name = "ALLOCATION_METHOD_CODE", referencedColumnName = "CODE")
     @Column(name="ALLOCATION_METHOD_CODE")
     private String refAllocationMethod;
   
    public RefAllocationCriteria() {
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

    public void setRefAllocationMethod(String refAllocationMethod) {
        this.refAllocationMethod = refAllocationMethod;
    }

    public String getRefAllocationMethod() {
        return refAllocationMethod;
    }
}
