package com.technobrain.trips.core.system;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "SysTaskLog.findAll", 
    query = "select o from SysTaskLog o")
@Table(name = "SYS_TASK_LOG")
//@SequenceGenerator(name = "SYS_TASK_LOG_SEQ", sequenceName = "SYS_TASK_LOG_SEQ", initialValue =1, allocationSize = 1)
public class SysTaskLog extends BaseNormalModelObject implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SYS_TASK_LOG_SEQ")
    @Column(name="TASK_ID",nullable = false)
    private Long taskId;
//    private Long id;
//    private Long taskId;

    @Column(name="USER_NAME")
    private String userName;
    @Column(name="OBJECT_TYPE")
    private String objectType;

    public SysTaskLog() {
    }

    public Long getId() {
        return taskId;
    }

    public void setId(Long id) {
        this.taskId = id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
