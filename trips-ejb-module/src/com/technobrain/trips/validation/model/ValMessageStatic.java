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
    @NamedQuery(name = "ValMessageStatic.findAll", 
    query = "select o from ValMessageStatic o"),
    @NamedQuery(name = "ValMessageStatic.findByMessageType", 
    query = "select o from ValMessageStatic o where o.msgType = ?1"),
    @NamedQuery(name = "ValMessageStatic.findByMessageTypeValType", 
    query = "select o from ValMessageStatic o where o.msgType = ?1  and (o.validationType =?2 or \"" + Constants.ALL + "\" =?2)"),
    @NamedQuery(name = "ValMessageStatic.findByMessageTypeValTypeProperty", 
    query = "select o from ValMessageStatic o where UPPER(o.msgType) = UPPER(?1) " +
            "and UPPER(o.validationType) = UPPER(?2) and UPPER(o.msgAttrib) = UPPER(?3)")
})
@Table(name = "VAL_MESSAGE_STATIC")
public class ValMessageStatic extends BaseNormalModelObject   {
    @Column(name="SAVE_WITH_ERRORS")
    private String saveWithErrors;
    @Column(name="VALIDATION_TYPE")
    private String validationType;
    private String list;
    private String mandatory;
    @Column(name="DB_COL")
    private String dbCol;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "val_message_static_seq")
    @SequenceGenerator(name = "val_message_static_seq", sequenceName = "val_message_static_seq", allocationSize = 1)    
    @Column(nullable = false, name="ID")
    private Long id;
    private String mask;
    private Long max;
    private Long min;
    @Column(name="MSG_ATTRIB", nullable = false)
    private String msgAttrib;
    @Column(name="MSG_TYPE", nullable = false)
    private String msgType;

    public ValMessageStatic() {
    }

    public String getDbCol() {
        return dbCol;
    }

    public void setDbCol(String dbCol) {
        this.dbCol = dbCol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public String getMsgAttrib() {
        return msgAttrib;
    }

    public void setMsgAttrib(String msgAttrib) {
        this.msgAttrib = msgAttrib;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgClass) {
        this.msgType = msgClass;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public String getSaveWithErrors() {
        return saveWithErrors;
    }

    public void setSaveWithErrors(String saveWithErrors) {
        this.saveWithErrors = saveWithErrors;
    }

    public boolean isMandatory() {
        return null != mandatory ? mandatory.equalsIgnoreCase(Constants.TRUE) : false;
    }

    public boolean isOptional() {
         return null != saveWithErrors ? saveWithErrors.equalsIgnoreCase(Constants.TRUE) : false;
     }
}
