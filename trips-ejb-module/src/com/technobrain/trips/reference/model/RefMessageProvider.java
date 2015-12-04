package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//TODO: set proper inheritience -- attach to sequence
@Entity
@NamedQuery(name = "RefMessageProvider.findAll", 
    query = "select o from RefMessageProvider o")
@Table(name = "REF_MESSAGE_PROVIDER")
public class RefMessageProvider extends BaseNormalModelObject {
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="MESSAGE_TYPE")
    private String messageType;
    private String provider;
    @Column(name="PROVIDER_TYPE")
    private String providerType;

    public RefMessageProvider() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }


}
