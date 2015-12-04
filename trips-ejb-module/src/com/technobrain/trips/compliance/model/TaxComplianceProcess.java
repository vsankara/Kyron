package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefReturnType;
import com.technobrain.trips.reference.model.RefRevType;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="TaxComplianceProcess")
@NamedQueries (
    {
        @NamedQuery(name = "TaxComplianceProcess.findAll", query = "select o from TaxComplianceProcess o") 
    }    
)
@Table(name = "TAX_COMPLIANCE_PROCESS")
public class TaxComplianceProcess extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAX_COMPLIANCE_PROCESS_SEQ")
    @SequenceGenerator(name = "TAX_COMPLIANCE_PROCESS_SEQ", sequenceName = "TAX_COMPLIANCE_PROCESS_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CONFIG_ID", referencedColumnName="ID")
    private TaxComplianceConf configId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="RETURN_TYPE", referencedColumnName="CODE")
    private RefReturnType returnType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TAX_TYPE", referencedColumnName="CODE")
    private RefRevType taxType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JOB_LOG_ID", referencedColumnName="ID")
    private ComplianceJobLog logId;
    
    @OneToMany(mappedBy = "processId", fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<TaxComplianceHistory> historyList;
    
    @Column(name = "ACTION_DATE")
    private Timestamp actionDate;
    
    @Column(name = "ACTIONED_BY")
    private String actionedBy;
    
    @Column(name = "COMPLIANCE_TYPE")
    private String complianceType;
    
    private String period;
    
    
    public TaxComplianceProcess() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setConfigId(TaxComplianceConf configId) {
        this.configId = configId;
    }

    public TaxComplianceConf getConfigId() {
        return configId;
    }

    public void setReturnType(RefReturnType returnType) {
        this.returnType = returnType;
    }

    public RefReturnType getReturnType() {
        return returnType;
    }

    public void setTaxType(RefRevType taxType) {
        this.taxType = taxType;
    }

    public RefRevType getTaxType() {
        return taxType;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionedBy(String actionedBy) {
        this.actionedBy = actionedBy;
    }

    public String getActionedBy() {
        return actionedBy;
    }

    public void setComplianceType(String complianceType) {
        this.complianceType = complianceType;
    }

    public String getComplianceType() {
        return complianceType;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setLogId(ComplianceJobLog logId) {
        this.logId = logId;
    }

    public ComplianceJobLog getLogId() {
        return logId;
    }

    public void setHistoryList(List<TaxComplianceHistory> historyList) {
        this.historyList = historyList;
    }

    public List<TaxComplianceHistory> getHistoryList() {
        return historyList;
    }
}
