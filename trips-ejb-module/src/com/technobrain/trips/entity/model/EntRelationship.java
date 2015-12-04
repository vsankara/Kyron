package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2006
 *
 * Entity for table ENT_RELATIONSHIP
 *
 * @since	$Date: 5/7/2009 3:17:45 AM$
 * @version 	$Revision: 16$
 * @author 	$Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  16   TRIPS2    1.15        5/7/2009 3:17:45 AM    Vythilingam Pirabaharan
 *       Second part of registration module modification as part of refactoring
 * $
 */
@Entity
@NamedQuery(name = "EntRelationship.findAll", 
    query = "select o from EntRelationship o")
@Table(name = "ENT_RELATIONSHIP")
@SequenceGenerator(name = "ent_relationship_seq",
    sequenceName = "ent_relationship_seq", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RELATION_DISCRIMINATOR")
@DiscriminatorValue("RELATION")
public class EntRelationship extends BaseNormalModelObject   {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_relationship_seq")
    @Column(nullable = false)
    private Long id;
    @Column(name="RELATIONSHIP_END_DATE")
    private Timestamp relationshipEndDate;
    @Column(name="RELATIONSHIP_START_DATE")
    private Timestamp relationshipStartDate;
    @Column(name="RELATIONSHIP_TYPE", nullable = false)
    private String relationshipType;
    @Column(name="RELATION_DISCRIMINATOR")
    private String relationDiscriminator;
    @Column(name="RELATIONSHIP_STATUS")
    private String relationshipStatus;
     /**
      * cascade.ALL removed as part of bug fix TRGHA-2441 - Any existing relation  replaces with new relation, 
      * old relation entity was removed from Trips application or DB(this was worng)
      */
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "TARGET_ENTITY", referencedColumnName = "ID")
    private EntEntity targetEntity;
    @ManyToOne
    @JoinColumn(name = "SOURCE_ENTITY", referencedColumnName = "ID")
    private EntEntity sourceEntity;
    @Column(name = "PRIMARY_INDICATOR")
    private String primaryIndicator;
    @Column(name = "OTHER_INFO")
    private String otherInfo;

    
    public EntRelationship() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getRelationshipEndDate() {
        return relationshipEndDate;
    }

    public void setRelationshipEndDate(Timestamp relationshipEndDate) {
        this.relationshipEndDate = relationshipEndDate;
    }

    public Timestamp getRelationshipStartDate() {
        return relationshipStartDate;
    }

    public void setRelationshipStartDate(Timestamp relationshipStartDate) {
        this.relationshipStartDate = relationshipStartDate;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public EntEntity getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(EntEntity entEntity) {
        this.targetEntity = entEntity;
    }

    public EntEntity getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(EntEntity entEntity1) {
        this.sourceEntity = entEntity1;
    }
    
    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }
    
    public void setPrimaryIndicator(String primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public String getPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setRelationDiscriminator(String relationDiscriminator) {
        this.relationDiscriminator = relationDiscriminator;
    }

    public String getRelationDiscriminator() {
        return relationDiscriminator;
    }

}
