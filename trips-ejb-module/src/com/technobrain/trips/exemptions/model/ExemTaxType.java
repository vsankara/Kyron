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
@NamedQueries(
    {
    @NamedQuery(name = "ExemTaxType.findAll", 
    query = "select o from ExemTaxType o"),
    @NamedQuery(name = "ExemTaxType.findById", 
    query = "select o.taxType from ExemTaxType o where o.ecr.id = ?1")
    })
@Table(name = "EXEM_TAX_TYPE")
public class ExemTaxType extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEM_TAX_TYPE_SEQ")
    @SequenceGenerator(name = "EXEM_TAX_TYPE_SEQ", sequenceName = "EXEM_TAX_TYPE_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="TAX_TYPE")
    private String taxType;
    @ManyToOne
    @JoinColumn(name = "ECR_ID", referencedColumnName = "ID")
    private Ecr ecr;

    public ExemTaxType() {
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
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
}
