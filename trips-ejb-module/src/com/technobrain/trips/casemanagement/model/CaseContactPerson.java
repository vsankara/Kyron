package com.technobrain.trips.casemanagement.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

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
 * Model class representing the table CASE_CONTACT_PERSON. 
 * 
 *@author
 *@version
 *@since   
 *@see CaseDetails
 * 
 */
@NamedQueries(
    {
        @NamedQuery(name = "CaseContactPerson.findAll", query = "select o from CaseContactPerson o"),
        @NamedQuery(name = "CaseContactPerson.findContactPersonListByCaseId", 
        query = "select o from CaseContactPerson o where o.caseDetails.id = ?1"),
        @NamedQuery(name = "CaseContactPerson.findAll", query = "select o from CaseContactPerson o")
    }
)
@Entity
@Table(name = "CASE_CONTACT_PERSON")
public class CaseContactPerson extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CASE_CONTACT_PERSON_SEQ")
    @SequenceGenerator(name = "CASE_CONTACT_PERSON_SEQ", 
                       sequenceName = "CASE_CONTACT_PERSON_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String address;
    private String email;
    private String fax;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="JOB_TITLE")
    private String jobTitle;
    @Column(name="LAST_NAME")
    private String lastName;
    private String mobile;
    private String notes;
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "CASE_ID", referencedColumnName = "ID")
    private CaseDetails caseDetails;

    public CaseContactPerson() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCaseDetails(CaseDetails caseDetails) {
        this.caseDetails = caseDetails;
    }

    public CaseDetails getCaseDetails() {
        return caseDetails;
    }
}
