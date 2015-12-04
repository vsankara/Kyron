package com.technobrain.trips.message.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TechnoBrain 2015
 *
 * Message type entity
 *
 * @since	$Date: 2/2/2009 5:29:20 AM$
 * @version 	$Revision: 8$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  8    TRIPS2    1.7         2/2/2009 5:29:20 AM    Howard Hill     change
 *       log10 to log1
 * $
 */

@Entity

@NamedQueries({
    @NamedQuery(name = "MsgType.queryFindByCode", 
        query = "select o from MsgType o where o.code=?1"),
    @NamedQuery(name = "MsgType.queryFindByMsgType", 
        query = "select o from MsgType o where o.msgType=?1"),
    @NamedQuery(name = "MsgType.queryFindByCode", 
        query = "select o from MsgType o where o.code=?1")    
})

@Table(name = "MSG_TYPE")
public class MsgType extends BaseRefModelObject   {
    @Id
    @Column(name="CODE", nullable = false)
    private String code;
     
    @Column(name="DESCRIPTION", nullable = false)
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="MSG_TYPE", nullable = false)
    private String msgType;
    @Column(name="HEADER_FIELD", nullable = true)
    private String headerField;  
    @Column(name="ITEM_FIELD", nullable = true)
    private String itemField;  
    @Column(name="IS_FLEXIBLE_FORM", nullable = true)
    private String isFlexibleForm;  

    public MsgType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    

    public String getHeaderField() {
        return headerField;
    }

    public void setHeaderField(String headerField) {
        this.headerField = headerField;
    }
    
    public String getItemField() {
        return itemField;
    }

    public void setItemField(String itemField) {
        this.itemField = itemField;
    }

    public void setIsFlexibleForm(String isFlexibleForm) {
        this.isFlexibleForm = isFlexibleForm;
    }

    public String getIsFlexibleForm() {
        return isFlexibleForm;
    }
}
