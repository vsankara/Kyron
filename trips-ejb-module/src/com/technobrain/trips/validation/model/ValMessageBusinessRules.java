package com.technobrain.trips.validation.model;

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
    @NamedQuery(name = "ValMessageBusinessRules.findAll", 
        query = "select o from ValMessageBusinessRules o"),
    @NamedQuery(name = "ValMessageBusinessRules.findAllByMessageType", 
        query = "select o from ValMessageBusinessRules o where o.messageType = ?1")
})
@Table(name = "VAL_MESSAGE_BUSINESS_RULES")
public class ValMessageBusinessRules extends BaseNormalModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "val_message_business_rules_seq")
    @SequenceGenerator(name = "val_message_business_rules_seq", sequenceName = "val_message_business_rules_seq", allocationSize = 1)    
    @Column(nullable = false, name="ID")
    private Long id;
    @Column(name="MESSAGE_TYPE", nullable = false)
    private String messageType;
    @Column(name="RULE_NAME", nullable = false)
    private String ruleName;

    public ValMessageBusinessRules() {
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

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
