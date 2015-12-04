package com.technobrain.trips.casemanagement.model;

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
 * Model class representing the table CASE_GROUP_ASSIGN_LOG. 
 * 
 *@author
 *@version
 *@since   
 *@see
 * 
 */

@Entity
            
@NamedQueries( { @NamedQuery(name = "CaseGroupAssignLog.findAll", 
    query = "select o from CaseGroupAssignLog o"),
    @NamedQuery(name = "CaseGroupAssignLog.findActiveCaseGroup", 
    query = "select cgal.assignedGroupName from CaseGroupAssignLog cgal where cgal.caseDetails.id =?1 and cgal.status = 'A'")
})
    
@Table(name = "CASE_GROUP_ASSIGN_LOG")
public class CaseGroupAssignLog extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_GROUP_ASSIGN_LOG_SEQ")
    @SequenceGenerator(name = "CASE_GROUP_ASSIGN_LOG_SEQ", 
                       sequenceName = "CASE_GROUP_ASSIGN_LOG_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ASSIGNED_BY")
    private String assignedBy;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;
   
    @Column(name="ASSIGNED_GROUP_NAME")
    private String assignedGroupName;
    
    @Column(name="CASE_GROUP_ID")
    private Long caseGroupID;    
        
    @Column(name="CASE_OFFICE")
    private String caseOffice;

    public CaseGroupAssignLog() {
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

   public CaseDetails getTaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails =caseDetails;
    }
    
    public void setAssignedGroupName(String assignedGroupName) {
        this.assignedGroupName = assignedGroupName;
    }

    public String getAssignedGroupName() {
        return assignedGroupName;
    }

    public void setCaseGroupID(Long caseGroupID) {
        this.caseGroupID = caseGroupID;
    }

    public Long getCaseGroupID() {
        return caseGroupID;
    }

    public void setCaseOffice(String caseOffice) {
        this.caseOffice = caseOffice;
    }

    public String getCaseOffice() {
        return caseOffice;
    }

}
