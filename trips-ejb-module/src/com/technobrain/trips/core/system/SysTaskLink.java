package com.technobrain.trips.core.system;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;

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

@Entity
@NamedQueries({
@NamedQuery(name = "SysTaskLink.findAll", 
    query = "select o from SysTaskLink o"),
@NamedQuery(name = "SysTaskLink.findByEntity", 
    query = "select o from SysTaskLink o where o.entityId=?1"),
@NamedQuery(name = "SysTaskLink.findByTask", 
    query = "select o from SysTaskLink o where o.taskId=?1")
    })
@Table(name = "SYS_TASK_LINK")
@SequenceGenerator(name = "SYS_TASK_LINK_SEQ", sequenceName = "SYS_TASK_LINK_SEQ", initialValue =1, allocationSize = 1)
public class SysTaskLink extends BaseNormalModelObject implements Serializable {
    @Column(name="ENTITY_ID", nullable = false)
    private Long entityId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SYS_TASK_LINK_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(name="LOCK_ENTITY")
    private String lockEntity;
    @Column(name="OBJECT_ID")
    private Long objectId;
    @Column(name="OBJECT_TYPE")
    private String objectType;
    @Column(name="TASK_ID")
    private Long taskId;
    @Column(name="TASK_TYPE")
    private String taskType;

    public SysTaskLink() {
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLockEntity() {
        return lockEntity.equals(Constants.TRUE);
    }

    public void setLockEntity(boolean lockEntity) {
        this.lockEntity = lockEntity?Constants.TRUE:Constants.FALSE;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
