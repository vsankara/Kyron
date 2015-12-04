package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Model class representing the table AUDIT_PROFILE. 
 * 
 *@author
 *@version
 *@since   
 *@see AuditProfileBusSector
 * 
 */

@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AuditProfile.findAll", query = "select o from AuditProfile o where o.status <> 'D' and (?1 IS NULL or o.id <> ?1) and o.office=?2"),
    @NamedQuery(name = "AuditProfile.findProfileByProfileId", query = "select o from AuditProfile o where o.profileId = ?1")
    }
)     
@Table(name = "AUDIT_PROFILE")
public class AuditProfile extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_PROFILE_SEQ")
    @SequenceGenerator(name = "AUDIT_PROFILE_SEQ", sequenceName = "AUDIT_PROFILE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="BUSINESS_SECTOR")
    private String businessSector;
	
    @Column(name="AUDIT_PERIOD_START")
    private Timestamp periodStartDate;
	
    @Column(name="AUDIT_PERIOD_END")
    private Timestamp periodEndDate;

    @Column(name="PROFILE_ID")
    private String profileId;
	
    @Column(name="PROFILE_NAME")
    private String profilename;
	
    @Column(name="NUM_VISITS")
    private Long numberOfVisits;
	
    @Column(name="OFFICE")
    private String office;
	
   @OneToMany(mappedBy = "auditProfile", cascade={CascadeType.ALL})
    private List<AuditProfileBusSector> auditProfileBusSectorTypeList;


    public AuditProfile() {
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

    public void setPeriodStartDate(Timestamp periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public Timestamp getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public Timestamp getPeriodEndDate() {
        return periodEndDate;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public String getProfilename() {
        return profilename;
    }

   

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }


    public void setAuditProfileBusSectorTypeList(List<AuditProfileBusSector> auditProfileBusSectorTypeList) {
        this.auditProfileBusSectorTypeList = auditProfileBusSectorTypeList;
    }

    public List<AuditProfileBusSector> getAuditProfileBusSectorTypeList() {
        return auditProfileBusSectorTypeList;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }
}
