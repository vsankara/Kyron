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
 * Message field entity
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
@NamedQuery(name = "MsgField.findAll", query = "select o from MsgField o")
@Table(name = "MSG_FIELD")
public class MsgField extends BaseNormalModelObject   {

    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="FIELD", nullable = false)
    private String field;
    @Column(name="SECTION_FIELD", nullable = false)
    private String sectionField;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "msg_field_seq")
    @SequenceGenerator(name = "msg_field_seq", sequenceName = "msg_field_seq",
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    private String code;

    @Column(name="SECTION", nullable = false)
    private Long section;

    @Column(name="ENTITY_LOOKUP")
    private String entityLookup;
    @Column(name="EJBQL")
    private String ejbql;


    public MsgField() {
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSectionField() {
        return sectionField;
    }

    public void setSectionField(String sectionField) {
        this.sectionField = sectionField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public void setEntityLookup(String entityLookup) {
        this.entityLookup = entityLookup;
    }

    public String getEntityLookup() {
        return entityLookup;
    }

    public void setEjbql(String ejbql) {
        this.ejbql = ejbql;
    }

    public String getEjbql() {
        return ejbql;
    }
}
