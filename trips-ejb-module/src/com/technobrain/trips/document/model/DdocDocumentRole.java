package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefOffStaff;

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

@Entity
@NamedQueries( {@NamedQuery(name = "DdocDocumentRole.findAll", query = "select o from DdocDocumentRole o")
        , 
        @NamedQuery(name = "DdocDocumentRole.findByDocId", query = "select o from DdocDocumentRole o where o.document.id=?1")

} )
@Table(name = "DDOC_DOCUMENT_ROLE")
public class DdocDocumentRole extends BaseNormalModelObject {
    @Column(name="ACTION_DATE")
    private Timestamp actionDate;
    @Column(name="APPLICANT_TIN")
    private String applicantTin;
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID")
    private DdocDocument document;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DDOC_DOCUMENT_ROLE_SEQ")
    @SequenceGenerator(name = "DDOC_DOCUMENT_ROLE_SEQ", sequenceName = "DDOC_DOCUMENT_ROLE_SEQ", allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "OFFICER", referencedColumnName = "ID")
    private RefOffStaff officer;
    private String position;
    @Column(name="ROLE_NAME")
    private String roleName;

    public DdocDocumentRole() {
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public String getApplicantTin() {
        return applicantTin;
    }

    public void setApplicantTin(String applicantTin) {
        this.applicantTin = applicantTin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setOfficer(RefOffStaff officer) {
        this.officer = officer;
    }

    public RefOffStaff getOfficer() {
        return officer;
    }

    public void setDocument(DdocDocument document) {
        this.document = document;
    }

    public DdocDocument getDocument() {
        return document;
    }
}
