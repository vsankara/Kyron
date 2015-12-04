package com.technobrain.trips.compliance.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="ComplianceJobLog")
@NamedQueries (
    {
        @NamedQuery(name = "ComplianceJobLog.findActive", 
        query = "select o from ComplianceJobLog o where o.office = ?1 and o.jobStatus = 'A'"),       
        
        @NamedQuery(name = "ComplianceJobLog.findByAllValues",
        query = "select o from ComplianceJobLog o where o.office = ?1 and o.jobStatus = ?2 ")
        
    }    
)

@Table(name = "COMPLIANCE_JOB_LOG")
public class ComplianceJobLog extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPLIANCE_JOB_LOG_SEQ")
    @SequenceGenerator(name = "COMPLIANCE_JOB_LOG_SEQ", sequenceName = "COMPLIANCE_JOB_LOG_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="JOB_STATUS")
    private String jobStatus;
    
    private String office;
    
    public ComplianceJobLog() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

}
