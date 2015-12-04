package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefSubTaxCategory;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;

@Entity

@NamedQueries(
                {
                    @NamedQuery(name = "FlexibleFormFieldSubTaxType.findByFieldNameAndDocType", 
                    query = "select o from FlexibleFormFieldSubTaxType o where o.fieldName = ?1 and  o.docType = ?2"),
                    @NamedQuery(name = "FlexibleFormFieldSubTaxType.getSubTaxCategoryByDocType", 
                    query = "select distinct o from FlexibleFormFieldSubTaxType o where o.docType = ?1 and o.chargeType is null ")
                }
            )
@Table(name = "FLX_FRM_FLD_SUB_TAX_CAT")
public class FlexibleFormFieldSubTaxType extends BaseNormalModelObject  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLX_FRM_FLD_SUB_TAX_CAT_SEQ")
    @SequenceGenerator(name = "FLX_FRM_FLD_SUB_TAX_CAT_SEQ", sequenceName = "FLX_FRM_FLD_SUB_TAX_CAT_SEQ", 
                       allocationSize = 1)  
    @Column(nullable = false,  updatable=false)
    private Long id;
    private String description;
    @Column(name="EFFECTIVE_DATE" , updatable=false)
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE", updatable=false)
    private Timestamp expiryDate;
    
    
    
    @Column(name="TAX_SUB_TAX_CODE",  updatable=false)
    private String taxSubTaxType;
    
    
    @Column(name="FIELD_NAME",  updatable=false)
    private String fieldName;
    
    
    @Column(name="DOCUMENT_TYPE",  updatable=false)
    private String docType;
    
    @Column(name="CHARGE_TYPE",  updatable=false)
    private String chargeType;
    
    @Column(name="CURRENCY",  updatable=false)
    private String currency;
    
   
    
    
    public FlexibleFormFieldSubTaxType() {
    }

    
    public String getDescription() {
        return description;
    }


    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }
   
    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxSubTaxType() {
        return taxSubTaxType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getChargeType() {
        return chargeType;
    }
    
   

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

  
}
