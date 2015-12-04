package com.technobrain.trips.exemptions.model;

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

@Entity
@NamedQueries({
@NamedQuery(name = "ExemptionQualificationAttribute.findAll", 
    query = "select o from ExemptionQualificationAttribute o"),
 @NamedQuery(name = "ExemptionQualificationAttribute.findByAttributeName", query = "select o from ExemptionQualificationAttribute o where o.ecr.id=?1 and o.attributeName=?2")
    })
@Table(name = "EXEM_QUALIFICATION_ATT")
public class ExemptionQualificationAttribute extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEM_QUALIFICATION_ATT_SEQ")
    @SequenceGenerator(name = "EXEM_QUALIFICATION_ATT_SEQ", sequenceName = "EXEM_QUALIFICATION_ATT_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ATTRIBUTE_NAME")
    private String attributeName;
    @Column(name="ATTRIBUTE_DATA_TYPE")
    private String attributeDataType;
    @Column(name="MANDATORY_IND")
    private String mandatoryInd;
    @Column(name="DESCRIPTION")
    private String attributeDescription;
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private Ecr ecr;

    public ExemptionQualificationAttribute() {
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public void setEcr(Ecr ecr) {
        this.ecr = ecr;
    }

    public Ecr getEcr() {
        return ecr;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeDataType(String attributeDataType) {
        this.attributeDataType = attributeDataType;
    }

    public String getAttributeDataType() {
        return attributeDataType;
    }

    public void setMandatoryInd(String mandatoryInd) {
        this.mandatoryInd = mandatoryInd;
    }

    public String getMandatoryInd() {
        return mandatoryInd;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }
}
