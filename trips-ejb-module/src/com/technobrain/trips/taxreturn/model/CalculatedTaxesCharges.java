package com.technobrain.trips.taxreturn.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries( {
                @NamedQuery(name = "CalculatedTaxesCharges.findAllTaxeAndCharges", query = "select o from CalculatedTaxesCharges o where o.documentId = ?1 and " +
                                    " o.baseTableId = ?2"),
                @NamedQuery(name = "CalculatedTaxesCharges.findLodgedTaxeAndCharges", query = "select o from CalculatedTaxesCharges o where o.documentId = ?1 and " +
                                    " o.baseTableId = ?2")
                
}
)

@Entity
@Table(name = "CALCULATED_TAXES_CHARGES")
public class CalculatedTaxesCharges extends BaseNormalModelObject {
    public CalculatedTaxesCharges() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALCULATED_TAXES_CHARGES_SEQ")
    @SequenceGenerator(name = "CALCULATED_TAXES_CHARGES_SEQ", sequenceName = "CALCULATED_TAXES_CHARGES_SEQ", allocationSize = 1)
    @Column(name="ID", nullable = false)
    private Long id;
    
    @Column(name="DDOC_ID")
    private long documentId;
    
    @Column(name="BASE_TABLE_ID")
    private long baseTableId;
    
    @Column(name="TAX_TYPE")
    private String taxType;
    
    @Column(name="CHARGE_TYPE")
    private String chargetType;
   
    @Column(name="SUB_TAX_TYPE")
    private String subTaxType;
   
    @Column(name="SUB_TAX_TYPE1")
    private String subTaxType1;
   
    @Column(name="CALCULATED_VALUE") 
    private BigDecimal calculatedValue;
    
    @Column(name="CURRENCY")
    private String currency;
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public Long getDocumentId() {
        return documentId;
    }
    
    public Long getBaseTableId() {
        return baseTableId;
    }
    public String getSubTaxType() {
        return subTaxType;
    }
    
    public BigDecimal getCalculatedValue() {
        return calculatedValue;
    }
    
    public void setSubTaxType(String taxType) {
         this.subTaxType = taxType;
    }
    
    public void setCalculatedValue(BigDecimal calValue) {
         this.calculatedValue = calValue;
    }
    
    public void setDocumentId(Long docId) {
         this.documentId = docId;
    }
    
    public void setBaseTableId(Long baseId) {
         this.baseTableId = baseId;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setChargetType(String chargetType) {
        this.chargetType = chargetType;
    }

    public String getChargetType() {
        return chargetType;
    }

    public void setSubTaxType1(String subTaxType1) {
        this.subTaxType1 = subTaxType1;
    }

    public String getSubTaxType1() {
        return subTaxType1;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
