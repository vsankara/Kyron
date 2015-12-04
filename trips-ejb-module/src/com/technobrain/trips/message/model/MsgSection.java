package com.technobrain.trips.message.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * TechnoBrain 2015
 *
 * Message section entity
 *
 * @since	$Date: 2/2/2009 5:29:20 AM$
 * @version 	$Revision: 5$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  5    TRIPS2    1.4         2/2/2009 5:29:20 AM    Howard Hill     change
 *       log10 to log1
 * $
 */

@Entity
@NamedQuery(name = "MsgSection.findAll", query = "select o from MsgSection o")
@Table(name = "MSG_SECTION")
public class MsgSection extends BaseNormalModelObject   {
     
     
     
     
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "MSG_SECTION_SEQ")
    @SequenceGenerator(name = "MSG_SECTION_SEQ", sequenceName = "MSG_SECTION_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="MSG_TYPE", nullable = false)
    private String msgType;
    @Column(name="SECTION", nullable = false)
    private String section;
     
     
     
     
     
     

    public MsgSection() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }


}
