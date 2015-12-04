package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_CONTACT_METHOD
 *
 * @since	$Date: 7/13/2009 10:21:27 AM$
 * @version 	$Revision: 18$
 * @author 	$Author: Ashok Dorairaj$
 * 
 * $Log[1]:
 *  18   TRIPS2    1.17        7/13/2009 10:21:27 AM  Ashok Dorairaj 
 *       Context_Search Column Added
 * $
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "EntContactMethod.findAll", 
        query = "select o from EntContactMethod o"),
    @NamedQuery(name = "EntContactMethod.findEntContactMethodByEntID", 
        query = "select o from EntContactMethod o where o.parentEntity = ?1")
})
@Table(name = "ENT_CONTACT_METHOD")
@SequenceGenerator(name = "ent_contact_method_seq", sequenceName = "ent_contact_method_seq", initialValue = 1, allocationSize = 1)
public class EntContactMethod extends BaseNormalModelObject   {
     
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="ENTITY_CONTACT_METHOD_PURPOSE")
    private String entityContactMethodPurpose;
    @Column(name="ENTITY_CONTACT_METHOD_TYPE")
    private String entityContactMethodType;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_contact_method_seq")
    @Column(nullable = false)
    private Long id;
    @Column(name="ENTITY_CONTACT_METHOD_DETAILS")
    private String contactMethodDetail;
    @Column(name="PRIMARY_INDICATOR")
    private String primaryIndicator;
    @Column(name="CONTACT_METHOD_STATUS")
    private String contactMethodStatus;
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;
    @Column(name="CONTEXT_SEARCH")
    private String contextSearch;
    
    public EntContactMethod() {
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEntityContactMethodPurpose() {
        return entityContactMethodPurpose;
    }

    public void setEntityContactMethodPurpose(String entityContactMethodPurpose) {
        this.entityContactMethodPurpose = entityContactMethodPurpose;
    }

    public String getEntityContactMethodType() {
        return entityContactMethodType;
    }

    public void setEntityContactMethodType(String entityContactMethodType) {
        this.entityContactMethodType = entityContactMethodType;
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

    public String getPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(EntEntity entEntity1) {
        this.parentEntity = entEntity1;
    }

    public void setContactMethodStatus(String contactMethodStatus) {
        this.contactMethodStatus = contactMethodStatus;
    }

    public String getContactMethodStatus() {
        return contactMethodStatus;
    }

    public void setContextSearch(String timeStamp) {
        this.contextSearch = timeStamp;
    }

    public void setContactMethodDetail(String contactMethodDetail) {
        this.contactMethodDetail = contactMethodDetail;
    }

    public String getContactMethodDetail() {
        return contactMethodDetail;
    }
}
