package com.technobrain.trips.application.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppConfigurationAttachment.findAll", query = "select o from AppConfigurationAttachment o")
@Table(name = "APP_CONF_ATTACHMENT")
public class AppConfigurationAttachment extends BaseNormalModelObject {
    @Column(name="ATTACHMENT_NO")
    private Integer attachmentNo;
    @Column(name="ATTACHMENT_TYPE")
    private String attachmentType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CONF_ATTACHMENT_SEQ")
    @SequenceGenerator(name = "APP_CONF_ATTACHMENT_SEQ", sequenceName = "APP_CONF_ATTACHMENT_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "APP_CONFIGURATION_ID", referencedColumnName = "ID")
    private AppConfiguration appConfiguration;

    public AppConfigurationAttachment() {
    }

    public Integer getAttachmentNo() {
        return attachmentNo;
    }

    public void setAttachmentNo(Integer attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }
}
