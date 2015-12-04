package com.technobrain.trips.common.listhelper;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 *
 * This entity bean should be used to get the reference lists based on the list type.
 *
 * @since	$Date: 2/2/2009 5:29:19 AM$
 * @version 	$Revision: 3$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  3    TRIPS2    1.2         2/2/2009 5:29:19 AM    Howard Hill     change
 *       log10 to log1
 * $
 */


@Entity
@NamedQuery(name = "StaticList.findAll", 
    query = "select o from StaticList o")
@Table(name = "REF_STATIC_LISTS")

public class StaticList extends BaseNormalModelObject {
    @Id
    @Column(nullable = false)
    private Long id; 
     
     
     
     
    @Column(name="DISPLAY_ORDER")
    private Long displayOrder;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="ELEMENT_ID", nullable = false)
    private String elementId;
    @Column(name="ELEMENT_NAME")
    private String elementName;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="LIST_TYPE", nullable = false)
    private String listType;
     
     
     
     
     

    public StaticList() {
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }
}
