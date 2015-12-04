package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Payment Source = How the payment is coming in {In Person, Web Portal, Third Party Agent, Field Visit}
 * 
 * @since $Date: 01/23/2012 18:00 PM$
 * @version $Revision: 1$
 * @author $Author: Mehmet Melik Kose$
 */

@Entity    
@NamedQueries  ( 
    {
@NamedQuery(name = "RefPaymentSource.findAll", 
    query = "select o from RefPaymentSource o"),
@NamedQuery(name = "RefPaymentSource.findByCode", 
    query = "select o from RefPaymentSource o where o.code = ?1")
    }
)
@Table(name = "REF_PAYMENT_SOURCE")
public class RefPaymentSource extends BaseRefModelObject{

    @Id
    @Column(nullable = false)
    private String code;
    
    private String description;
    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
}
