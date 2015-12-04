package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefTaskRole.findAll", query = "select o from RefTaskRole o  order by o.description")
@Table(name = "REF_TASK_ROLE")
public class RefTaskRole extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;     
     
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
    @Column(name="REQUESTED_ACTION")
    private String requestedAction;
            

    public RefTaskRole() {
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

    public void setRequestedAction(String requestedAction) {
        this.requestedAction = requestedAction;
    }

    public String getRequestedAction() {
        return requestedAction;
    }
}
