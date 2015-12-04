package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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
  * Model Object representing the table "CASE_GROUP".
  * 
  *@author  $Author: Uma shankar kathinokkula$
  *@since   $Date: $
  * 
  */
@Entity
@NamedQueries (
    {
        @NamedQuery(name = "CaseDefaultOfficeGroup.findAll", query = "select o from CaseDefaultOfficeGroup o"),
        @NamedQuery(name = "CaseDefaultOfficeGroup.findCaseDefaultOffice", query = "select o from CaseDefaultOfficeGroup o where o.id=?1"),
        @NamedQuery(name = "CaseDefaultOfficeGroup.findCaseGroupByCaseType", query = "select o from CaseDefaultOfficeGroup o where o.caseType = ?1"),
        @NamedQuery(name = "CaseDefaultOfficeGroup.findCaseGroupByOffice", query = "select o from CaseDefaultOfficeGroup o where o.office=?1")
    }
)             
@Table(name = "CASE_GROUP")
public class CaseDefaultOfficeGroup extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_GROUP_SEQ")
    @SequenceGenerator(name = "CASE_GROUP_SEQ", 
                       sequenceName = "CASE_GROUP_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name = "CASE_TYPE")
    private String caseType;
    @Column(name = "CASE_OFF_GRP_NAME")
    private String caseOffGroupName;
    @Column(name = "CASE_CLOSE_GRP_NAME")
    private String caseCloseGroupName;    
    @Column(name = "OVERRIDE_INT_OFF")
    private Boolean overrideIntOff;
    private String office; 
   
    public CaseDefaultOfficeGroup() {
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseOffGroupName() {
        return caseOffGroupName;
    }

    public void setCaseOffGroupName(String caseOffGroupName) {
        this.caseOffGroupName = caseOffGroupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setCaseCloseGroupName(String caseCloseGroupName) {
        this.caseCloseGroupName = caseCloseGroupName;
    }

    public String getCaseCloseGroupName() {
        return caseCloseGroupName;
    }


    public void setOverrideIntOff(Boolean overrideIntOff) {
        this.overrideIntOff = overrideIntOff;
    }

    public Boolean getOverrideIntOff() {
        return overrideIntOff;
    }
}
