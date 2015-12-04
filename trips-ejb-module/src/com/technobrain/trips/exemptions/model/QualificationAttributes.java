package com.technobrain.trips.exemptions.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "QualificationAttributes.findAll", 
    query = "select o from QualificationAttributes o")
@Table(name = "QUALIFICATION_ATTBTS")
public class QualificationAttributes extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUALIFICATION_ATTBTS_SEQ")
    @SequenceGenerator(name = "QUALIFICATION_ATTBTS_SEQ", sequenceName = "QUALIFICATION_ATTBTS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;    
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private AppEcr appEcr;
    @Column(name="ATTRIBUTE_NAME")
    private String attributeName;
    @Column(name="ATTRIBUTE_VALUE")
    private String attributeValue;
    
    public QualificationAttributes() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAppEcr(AppEcr appEcr) {
        this.appEcr = appEcr;
    }

    public AppEcr getAppEcr() {
        return appEcr;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getAttributeValue() {
        return attributeValue;
    }
}
