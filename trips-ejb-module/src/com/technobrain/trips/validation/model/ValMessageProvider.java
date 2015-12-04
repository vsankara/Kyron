package com.technobrain.trips.validation.model;

import com.technobrain.trips.common.constants.Constants;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "ValMessageProvider.findAll", 
    query = "select o from ValMessageProvider o"),
    @NamedQuery(name = "ValMessageProvider.findAllByMessageTypeAndValidationType",
    query = "select o from ValMessageProvider o where o.messageType =?1 and (o.validationType =?2 or '"+Constants.ALL+"' =?2)")
})

@Table(name = "VAL_MESSAGE_PROVIDER")
public class ValMessageProvider extends BaseNormalModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "val_message_provider_seq")
    @SequenceGenerator(name = "val_message_provider_seq", sequenceName = "val_message_provider_seq", allocationSize = 1)    
    @Column(nullable = false, name="ID")
    private Long id;
    @Column(nullable = false, name="MESSAGE_TYPE")
    private String messageType;
    @Column(nullable = false, name="VALIDATION_TYPE")
    private String validationType;

    @Column(nullable = false, name="PROVIDER")
    private String provider;

    public ValMessageProvider() {
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
    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public String getValidationType() {
        return validationType;
    }
}
