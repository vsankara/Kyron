package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "DdocCorrespondenceParams.findAll", query = "select o from DdocCorrespondenceParams o")
@Table(name = "DDOC_CORRESP_PARAMS")
public class DdocCorrespondenceParams extends BaseNormalModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DDOC_CORRESP_PARAMS_seq")
    @SequenceGenerator(name = "DDOC_CORRESP_PARAMS_seq", sequenceName = "DDOC_CORRESP_PARAMS_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="PARAM_NAME")
    private String paramName;
    @Column(name="PARAM_VALUE")
    private String paramValue;
    @ManyToOne
    @JoinColumn(name = "DDOC_DOCUMENT", referencedColumnName = "ID")
    private DdocDocument ddocDocument;
    
    public DdocCorrespondenceParams() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDdocDocument(DdocDocument ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public DdocDocument getDdocDocument() {
        return ddocDocument;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValue() {
        return paramValue;
    }
}
