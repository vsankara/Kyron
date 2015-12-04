package com.technobrain.trips.reference.model;

//import com.crownagents.trips.core.jobs.model.JobStreamRel;
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
@NamedQuery(name = "RefJobStream.findAll", 
    query = "select o from RefJobStream o")
@Table(name = "REF_JOB_STREAM")
public class RefJobStream extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;

    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    
//    @OneToMany(mappedBy = "refJobStream",cascade={CascadeType.ALL})
//    private List<JobStreamRel> jobStreamRelList;

    public RefJobStream() {
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


//    public void setJobStreamRelList(List<JobStreamRel> jobStreamRelList) {
//        this.jobStreamRelList = jobStreamRelList;
//    }
//
//    public List<JobStreamRel> getJobStreamRelList() {
//        if(jobStreamRelList == null)
//            jobStreamRelList = new ArrayList<JobStreamRel>();
//        return jobStreamRelList;
//    }
//    
//    public JobStreamRel addJobStreamRel(JobStreamRel jobStreamRel) {
//        getJobStreamRelList().add(jobStreamRel);
//        jobStreamRel.setRefJobStream(this);
//        return jobStreamRel;
//    }
//
//    public JobStreamRel removeJobStreamRel(JobStreamRel jobStreamRel) {
//        getJobStreamRelList().remove(jobStreamRel);
//        jobStreamRel.setRefJobStream(null);
//        return jobStreamRel;
//    }
}
