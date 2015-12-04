package com.technobrain.trips.reference.model;

//import com.crownagents.trips.core.jobs.model.JobSetStreamRel;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "RefSchedulableSet.findAll", 
    query = "select o from RefSchedulableSet o")
@Table(name = "REF_SCHEDULABLE_SET")
public class RefSchedulableSet extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
     
//    @OneToMany(mappedBy = "refSchedulableSet",cascade={CascadeType.ALL})
//    private List<JobSetStreamRel> jobSetStreamRelList;     

    public RefSchedulableSet() {
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

//    public JobSetStreamRel addJobSetStreamRel(JobSetStreamRel jobSetStreamRel) {
//        getJobSetStreamRelList().add(jobSetStreamRel);
//        jobSetStreamRel.setRefSchedulableSet(this);
//        return jobSetStreamRel;
//    }
//
//    public JobSetStreamRel removeJobSetStreamRel(JobSetStreamRel jobSetStreamRel) {
//        getJobSetStreamRelList().remove(jobSetStreamRel);
//        jobSetStreamRel.setRefSchedulableSet(null);
//        return jobSetStreamRel;
//    }
//
//    public void setJobSetStreamRelList(List<JobSetStreamRel> jobSetStreamRelList) {
//        this.jobSetStreamRelList = jobSetStreamRelList;
//    }
//
//    public List<JobSetStreamRel> getJobSetStreamRelList() {
//        if(jobSetStreamRelList == null){
//            jobSetStreamRelList = new ArrayList<JobSetStreamRel>();
//        }
//        return jobSetStreamRelList;
//    }
}
