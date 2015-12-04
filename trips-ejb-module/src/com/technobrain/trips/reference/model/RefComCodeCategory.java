package com.technobrain.trips.reference.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "RefComCodeCategory.findAll", 
    query = "select o from RefComCodeCategory o")
@Table(name = "REF_COM_CODE_CATEGORY")
public class RefComCodeCategory extends BaseNormalModelObject   {
    @Column(name="COM_CODE")
    private String comCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_com_code_category_seq")
    @SequenceGenerator(name = "ref_com_code_category_seq", sequenceName = "ref_com_code_category_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "COM_CATEGORY", referencedColumnName = "CODE")
    private RefComCategory refComCategory;    
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefComCodeCategory() {
    }


    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RefComCategory getRefComCategory() {
        return refComCategory;
    }

    public void setRefComCategory(RefComCategory refComCategory) {
        this.refComCategory = refComCategory;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
}
