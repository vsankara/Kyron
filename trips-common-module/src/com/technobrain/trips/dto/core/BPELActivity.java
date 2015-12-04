package com.technobrain.trips.dto.core;

import com.technobrain.trips.dto.DataTransferObject;

public class BPELActivity implements DataTransferObject {

	private String creationDate;
	private String faultName;
	private String label;
	private String processId;
	private String instanceId;
	private String modifyDate;
	private String revisionTag;
	private String activityState;
	
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getFaultName() {
		return faultName;
	}
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getRevisionTag() {
		return revisionTag;
	}
	public void setRevisionTag(String revisionTag) {
		this.revisionTag = revisionTag;
	}
	public String getActivityState() {
		return activityState;
	}
	public void setActivityState(String activityState) {
		this.activityState = activityState;
	}

}
