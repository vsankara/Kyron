package com.technobrain.trips.reference.model;
/**
 * TechnoBrain 2015
 *
 * This entity represents reference card type
 *
 * @since	$Date: 2/2/2009 5:27:04 AM$
 * @version 	$Revision: 2$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  2    TRIPS2    1.1         2/2/2009 5:27:04 AM    Howard Hill     change
 *       log[10] to log[1]
 * $
 */
import com.technobrain.trips.core.model.BaseRefModelObject;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefCardType.findAll", 
    query = "select o from RefCardType o")
@Table(name = "REF_CARD_TYPE")
public class RefCardType extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefCardType() {
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
}
