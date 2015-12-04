package com.technobrain.trips.reference.model;
/**
 * TechnoBrain 2015
 *
 * This entity is used as paramters for report
 *
 * @since	$Date: 5/7/2009 9:30:03 AM$
 * @version 	$Revision: 4$
 * @author 	$Author: Idris Yildiz$
 *
 * $Log[1]:
 *  4    TRIPS2    1.3         5/7/2009 9:30:03 AM    Idris Yildiz   
 *       dropDownList field added
 * $
 */

import com.technobrain.trips.core.model.BaseRefModelObject;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefReportParameters.findAll", 
            query = "select o from RefReportParameters o")
@Table(name = "REF_REPORT_PARAMETERS")
@SequenceGenerator(name = "REF_REPORT_PARAMETERS_SEQ", 
                   sequenceName = "REF_REPORT_PARAMETERS_SEQ", 
                   initialValue = 1, allocationSize = 1)
public class RefReportParameters extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "REF_REPORT_PARAMETERS_SEQ")
    private String code;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name = "PARAMETER_NAME", nullable = false)
    private String parameterName;    
    @Column(name = "PARAMETER_TECHNICAL_NAME", nullable = false)
    private String parameterTechnicalName;
    @Column(name = "REQUIRED")
    private String required;
    
    @ManyToOne
    @JoinColumn(name = "DATASOURCE_CODE", referencedColumnName = "CODE")
    private RefReportDatasource dataSource;
    
    @Column(name = "PARAMETER_TYPE", nullable = false)
    private String reportParamType;

    @Column(name = "DROPDOWN_LIST")
    private String dropDownList;

    public RefReportParameters() {
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

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
    public String getParameterTechnicalName() {
        return parameterTechnicalName;
    }

    public void setParameterTechnicalName(String parameterTechnicalName) {
        this.parameterTechnicalName = parameterTechnicalName;
    }
 
    public void setReportParamType(String reportParamType) {
        this.reportParamType = reportParamType;
    }

    public String getReportParamType() {
        return reportParamType;
    }

    public void setDataSource(RefReportDatasource dataSource) {
        this.dataSource = dataSource;
    }

    public RefReportDatasource getDataSource() {
        return dataSource;
    }

    public void setDropDownList(String dropDownList) {
        this.dropDownList = dropDownList;
    }

    public String getDropDownList() {
        return dropDownList;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
