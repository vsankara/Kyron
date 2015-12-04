package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.revenuecollection.model.RevCollCashOffice;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AttachmentInfo.findAll", 
    query = "select o from AttachmentInfo o")
@Table(name = "ATTACHMENT_INFO")
public class AttachmentInfo extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTACHMENT_INFO_SEQ")
    @SequenceGenerator(name = "ATTACHMENT_INFO_SEQ", sequenceName = "ATTACHMENT_INFO_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;    
    private String description;
    @Column(name="MANDATORY_IND")
    private String mandatoryInd;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private Ecr ecr;

    public AttachmentInfo() {
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

    public String getMandatoryInd() {
        return mandatoryInd;
    }

    public void setMandatoryInd(String mandatoryInd) {
        this.mandatoryInd = mandatoryInd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEcr(Ecr ecr) {
        this.ecr = ecr;
    }

    public Ecr getEcr() {
        return ecr;
    }
}
