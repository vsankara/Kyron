package com.technobrain.trips.core.system;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.technobrain.trips.core.model.BaseNormalModelObject;

@Entity
@NamedQueries({
    @NamedQuery(name = "JobLog.findAll", 
    query = "select o from JobLog o order by o.jobStartTime desc"),
    @NamedQuery(
    name="JobLog.findAllByJob",
    query="select o from JobLog o where o.jobId=?1 	order by o.jobStartTime desc"
    )
}) 
@Table(name = "SYS_JOB_LOG")
public class JobLog extends BaseNormalModelObject implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYS_JOB_LOG_SEQ")
	@SequenceGenerator(name = "SYS_JOB_LOG_SEQ", sequenceName = "SYS_JOB_LOG_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
	private Long id;
	
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="JOB_START_TIME")
	private Timestamp jobStartTime;
	
	@Column(name="JOB_END_TIME")
	private Timestamp jobEndTime;
	
	@Column(name="RUNTIME_LOG")
	private String runtimeLog;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public Timestamp getJobStartTime() {
		return jobStartTime;
	}
	public void setJobStartTime(Timestamp jobStartTime) {
		this.jobStartTime = jobStartTime;
	}
	public Timestamp getJobEndTime() {
		return jobEndTime;
	}
	public void setJobEndTime(Timestamp jobEndTime) {
		this.jobEndTime = jobEndTime;
	}
	public String getRuntimeLog() {
		return runtimeLog;
	}
	public void setRuntimeLog(String runtimeLog) {
		this.runtimeLog = runtimeLog;
	}
	
}
