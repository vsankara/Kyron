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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "ExemBusSector.findAll", 
    query = "select o from ExemBusSector o")
@Table(name = "EXEM_BUS_SECTOR")
public class ExemBusSector extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEM_BUS_SECTOR_SEQ")
    @SequenceGenerator(name = "EXEM_BUS_SECTOR_SEQ", sequenceName = "EXEM_BUS_SECTOR_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String code;
    @Column(name="MANDATORY_IND")
    private String mandatoryInd;
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private Ecr ecr;

    public ExemBusSector() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setEcr(Ecr ecr) {
        this.ecr = ecr;
    }

    public Ecr getEcr() {
        return ecr;
    }
}
