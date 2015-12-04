package com.technobrain.trips.security.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "SysUserLogin.findAll", 
    query = "select o from SysUserLogin o")
@Table(name = "SYS_USER_LOGIN")
@SequenceGenerator(name = "SYS_USER_LOGIN_SEQ", 
                   sequenceName = "SYS_USER_LOGIN_SEQ", initialValue = 1, 
                   allocationSize = 1)
public class SysUserLogin implements Serializable {
    @Column(name="ACCESS_LEVEL")
    private String accessLevel;
    @Column(name="AUTH_TYPE")
    private String authType;
    @Column(name="CREATED_BY")
    private String createdBy;
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    @Column(name="ELAPSED_TIME")
    private Long elapsedTime;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "SYS_USER_LOGIN_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(name="IS_DBA")
    private String isDba;
    @Column(name="LOGIN_DATETIME", nullable = false)
    private Timestamp loginDatetime;
    @Column(name="LOGIN_TIME")
    private String loginTime;
    @Column(name="LOGOUT_DATETIME")
    private Timestamp logoutDatetime;
    @Column(name="LOGOUT_TIME")
    private String logoutTime;
    private String machine;
    private String sessionid;
    private String status;
    @Column(name="UPDATED_BY")
    private String updatedBy;
    @Column(name="UPDATED_DATE")
    private Timestamp updatedDate;
    private String userid;
    private String version;

    public SysUserLogin() {
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDba() {
        return isDba;
    }

    public void setIsDba(String isDba) {
        this.isDba = isDba;
    }

    public Timestamp getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Timestamp loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getLogoutDatetime() {
        return logoutDatetime;
    }

    public void setLogoutDatetime(Timestamp logoutDatetime) {
        this.logoutDatetime = logoutDatetime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
