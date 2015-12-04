package com.technobrain.trips.entity.model;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_SITE
 *
 * @since	$Date: 7/2/2009 9:41:19 AM$
 * @version 	$Revision: 21$
 * @author 	$Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  21   TRIPS2    1.20        7/2/2009 9:41:19 AM    Vythilingam Pirabaharan
 *       Added entity site tab
 * $
 */
@Entity
@NamedQuery(name = "EntSite.findAll", query = "select o from EntSite o")
@Table(name = "ENT_SITE")
@SequenceGenerator(name = "ent_site_seq", sequenceName = "ent_site_seq", 
                   initialValue = 1, allocationSize = 1)
public class EntSite extends BaseNormalModelObject   {
     
    @Column(name = "ENTITY_SITE_TYPE")
    private String entitySiteType;
    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity parentEntity;
    @Column(insertable=false,updatable=false,name="ENT_ENTITY")
    private Long entityId;
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "ENT_LOCATION", referencedColumnName = "ID")
    private EntLocation entLocation;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ent_site_seq")
    @Column(nullable = false)
    private Long id;
    
    // Branch accounts will not be used in Core product.
//    @OneToOne
//    @JoinColumn(name = "REL_ENT_ENTITY", referencedColumnName = "ID")
//    private EntEntity relatedEntity;
    @Column(name = "FACILITY_TYPE")
    private String facilityType;
    @Column(name = "SITE_CODE")
    private String siteCode;
    @Column(name = "ENTITY_SITE_NAME")
    private String siteName;
    @Column(name = "CEASED_DATE")
    private Timestamp ceasedDate;
    
    
    public EntSite() {
    }

    public String getEntitySiteType() {
        return entitySiteType;
    }

    public void setEntitySiteType(String entitySiteType) {
        this.entitySiteType = entitySiteType;
    }

    public EntEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(EntEntity entEntity) {
        this.parentEntity = entEntity;
    }

    public EntLocation getEntLocation() {
        return entLocation;
    }

    public void setEntLocation(EntLocation entLocation) {
        this.entLocation = entLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }
//
//    public void setRelatedEntity(EntEntity relatedEntity) {
//        this.relatedEntity = relatedEntity;
//    }
//
//    public EntEntity getRelatedEntity() {
//        return relatedEntity;
//    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setCeasedDate(Timestamp ceasedDate) {
        this.ceasedDate = ceasedDate;
    }

    public Timestamp getCeasedDate() {
        return ceasedDate;
    }
}
