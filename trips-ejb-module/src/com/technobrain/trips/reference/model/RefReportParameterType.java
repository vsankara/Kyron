package com.technobrain.trips.reference.model;
/**
 * TechnoBrain 2015
 *
 * This is used as a reference entity for Report Parameter Type
 *
 * @since	$Date: 2/2/2009 5:28:50 AM$
 * @version 	$Revision: 2$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  2    TRIPS2    1.1         2/2/2009 5:28:50 AM    Howard Hill     change
 *       log10 to log1
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
@NamedQuery(name = "RefReportParameterType.findAll", 
    query = "select o from RefReportParameterType o")
@Table(name = "REF_REPORT_PARAMETER_TYPE")
public class RefReportParameterType extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column( name="DESCRIPTION", nullable = false)
    private String description;

    public RefReportParameterType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
