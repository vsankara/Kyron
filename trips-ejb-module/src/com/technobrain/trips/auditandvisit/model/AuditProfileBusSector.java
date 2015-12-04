package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
 * Model class representing the table AUDIT_PROFILE_BUS_SECT. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditProfile
 * 
 */
@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AuditProfileBusSector.findAll", query = "select o from AuditProfileBusSector o"),
    @NamedQuery(name = "AuditProfileBusSector.findBusSectorByProfileId", query ="select o from AuditProfileBusSector o where o.auditProfile.id=?1")
    }
)     
@Table(name = "AUDIT_PROFILE_BUS_SECT")
public class AuditProfileBusSector extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_PROFILE_BUS_SECT_SEQ")
    @SequenceGenerator(name = "AUDIT_PROFILE_BUS_SECT_SEQ", sequenceName = "AUDIT_PROFILE_BUS_SECT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="BUSINESS_SECTOR")
    private String businessSector;

    @ManyToOne
    @JoinColumn(name = "AUDIT_PROFILE_ID", referencedColumnName = "ID")
    private AuditProfile auditProfile;

    public AuditProfileBusSector() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setAuditProfile(AuditProfile auditProfile) {
        this.auditProfile = auditProfile;
    }

    public AuditProfile getAuditProfile() {
        return auditProfile;
    }
}
