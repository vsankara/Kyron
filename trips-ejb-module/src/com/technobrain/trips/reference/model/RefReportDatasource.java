package com.technobrain.trips.reference.model;

/**
 * TechnoBrain 2015
 *
 * This entity is used as datasource for reports
 *
 * @since	$Date: 2/2/2009 5:27:03 AM$
 * @version 	$Revision: 4$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:27:03 AM    Howard Hill     change
 *       log[10] to log[1]
 * $
 */
import com.technobrain.trips.core.model.BaseRefModelObject;
import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefReportDatasource.findAll", 
    query = "select o from RefReportDatasource o")
@Table(name = "REF_REPORT_DATASOURCE")
@SequenceGenerator(name = "REF_REPORT_DATASOURCE_SEQ", sequenceName = "REF_REPORT_DATASOURCE_SEQ", initialValue = 1, allocationSize = 1)
public class RefReportDatasource extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REF_REPORT_DATASOURCE_SEQ")
    private String code;
    @Column(name="DATASOURCE_NAME")
    private String datasourceName;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(nullable = false)
    private String query;
    
    @OneToMany(mappedBy = "dataSource", cascade = { CascadeType.ALL })
    private List<RefReportParameters> refParameterList;

    public RefReportDatasource() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setRefParameterList(List<RefReportParameters> refParameterList) {
        this.refParameterList = refParameterList;
    }

    public List<RefReportParameters> getRefParameterList() {
        return refParameterList;
    }
    
    public RefReportParameters addRefReportParamaters(RefReportParameters refReportParameters) {
        refParameterList.add(refReportParameters);
        refReportParameters.setDataSource(this);
        return refReportParameters;
    }
    
    public RefReportParameters removeRefReportParamaters(RefReportParameters refReportParameters) {
        refParameterList.remove(refReportParameters);
        return refReportParameters;
    }
}
