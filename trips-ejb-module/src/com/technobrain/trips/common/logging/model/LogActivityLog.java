package com.technobrain.trips.common.logging.model;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "LogActivityLog.findAll", query = "select o from LogActivityLog o")
@Table(name = "LOG_ACTIVITY_LOG")
@SequenceGenerator(name = "LOG_ACTIVITY_LOG_SEQ", sequenceName = "LOG_ACTIVITY_LOG_SEQ", initialValue = 1, allocationSize = 1)
public class LogActivityLog extends BaseNormalModelObject {
    @Column(name="BPEL_INSTANCE_ID")
    private String bpelInstanceId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ACTIVITY_LOG_SEQ")
    @Column(nullable = false)
    private Long id;
    private String type;
    @Column(name="MESSAGE_CODE")
    private String messageCode;
    @Column(name="MODULE_NAME")
    private String moduleName;
    @Column(name="IS_READ")
    private String read;
    @Column(name="MESSAGE_DETAIL")
    private String messageDetail;
    @Column(name="EXCEPTION_DETAIL")
    private String exceptionDetail;
    @Column(name="OCCURENCE_CLASS")
    private String occurenceClass;
    public LogActivityLog() {
    }

    public String getBpelInstanceId() {
        return bpelInstanceId;
    }

    public void setBpelInstanceId(String bpelInstanceId) {
        this.bpelInstanceId = bpelInstanceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setOccurenceClass(String occurenceClass) {
        this.occurenceClass = occurenceClass;
    }

    public String getOccurenceClass() {
        return occurenceClass;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }
}
