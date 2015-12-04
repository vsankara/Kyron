package com.technobrain.trips.reference.model;
/**
 * TechnoBrain 2015
 *
 * This entity represents company type of an organisation
 *
 * @since	$Date: 2/2/2009 5:27:02 AM$
 * @version 	$Revision: 2$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  2    TRIPS2    1.1         2/2/2009 5:27:02 AM    Howard Hill     change
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
@NamedQuery(name = "RefCompanyType.findAll", 
    query = "select o from RefCompanyType o")
@Table(name = "REF_COMPANY_TYPE")
public class RefCompanyType extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefCompanyType() {
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
