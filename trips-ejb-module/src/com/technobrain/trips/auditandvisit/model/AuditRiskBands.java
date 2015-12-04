package com.technobrain.trips.auditandvisit.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Model class representing the table AUDIT_RISK_BANDS. 
 * 
 *@author
 *@version
 *@since   
 * 
 */

@Entity
@NamedQueries (
    {
    @NamedQuery(name = "AuditRiskBands.findActiveRiskBands", query = "select o from AuditRiskBands o where o.status='A' order by o.id"),
    @NamedQuery(name = "AuditRiskBands.findRiskBandsExistWithInRange", 
    query = "select o from AuditRiskBands o where o.status='A' and (o.ratingFrom <= ?1 and o.ratingTo >= ?2) or (o.ratingFrom <= ?3 and o.ratingTo >= ?4) or o.bandCode = ?5"),
        @NamedQuery(name = "AuditRiskBands.findRiskBandsExist", 
    query = "select o from AuditRiskBands o where o.status='A' and o.id <> ?5 and ((o.ratingFrom <= ?1 and o.ratingTo >= ?2) or (o.ratingFrom <= ?3 and o.ratingTo >= ?4))"),
    @NamedQuery(name = "AuditRiskBands.findAll", query = "select o from AuditRiskBands o order by o.id"),
    @NamedQuery(name = "AuditRiskBands.findAuditRiskBandsInThatRange", query = "select o from AuditRiskBands o where o.status='A' and ?1 between o.ratingFrom and o.ratingTo")
    }
) 
@Table(name = "AUDIT_RISK_BANDS")
public class AuditRiskBands extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "AUDIT_RISK_BANDS_SEQ")
    @SequenceGenerator(name = "AUDIT_RISK_BANDS_SEQ", 
                       sequenceName = "AUDIT_RISK_BANDS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="BAND_CODE", nullable = false)
    private Long bandCode;
    @Column(nullable = false)
    private String description;
    
    @Column(name="NUM_AUDITS_PERFORMED", nullable = false)
    private Long numberOfAuditsPerformed;
    @Column(name="NUM_AUDIT_DAYS", nullable = false)
    private Long numberOfAuditDays;
    @Column(name="NUM_OFFICERS_REQUIRED", nullable = false)
    private Long numberOfOfficersRequired;
    @Column(name="OFFICER_GRADE", nullable = false)
    private String officerGrade;
    @Column(name="RATING_FROM", nullable = false)
    private Long ratingFrom;
    @Column(name="RATING_TO", nullable = false)
    private Long ratingTo;
    @Column(name="AUDIT_FREQUENCY", nullable = false)
    private Long auditFrequency;
    
    public AuditRiskBands() {
    }
   
    public Long getBandCode() {
        return bandCode;
    }

    public void setBandCode(Long bandCode) {
        this.bandCode = bandCode;
    }   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficerGrade() {
        return officerGrade;
    }

    public void setOfficerGrade(String officerGrade) {
        this.officerGrade = officerGrade;
    }

    public Long getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(Long ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public Long getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(Long ratingTo) {
        this.ratingTo = ratingTo;
    }

    public void setAuditFrequency(Long auditFrequency) {
        this.auditFrequency = auditFrequency;
    }

    public Long getAuditFrequency() {
        return auditFrequency;
    }

    public void setNumberOfAuditsPerformed(Long numberOfAuditsPerformed) {
        this.numberOfAuditsPerformed = numberOfAuditsPerformed;
    }

    public Long getNumberOfAuditsPerformed() {
        return numberOfAuditsPerformed;
    }

    public void setNumberOfAuditDays(Long numberOfAuditDays) {
        this.numberOfAuditDays = numberOfAuditDays;
    }

    public Long getNumberOfAuditDays() {
        return numberOfAuditDays;
    }

    public void setNumberOfOfficersRequired(Long numberOfOfficersRequired) {
        this.numberOfOfficersRequired = numberOfOfficersRequired;
    }

    public Long getNumberOfOfficersRequired() {
        return numberOfOfficersRequired;
    }
}
