package com.technobrain.trips.taxreturn.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;


@NamedQueries( {
                @NamedQuery(name = "CalculatedExemptions.findAllExemptions", query = "select o from CalculatedExemptions o where o.documentId = ?1 and " +
                                    " o.baseTableId = ?2")
}
)
@Entity
@Table(name = "CALCULATED_EXEMPTIONS")
public class CalculatedExemptions extends BaseNormalModelObject {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALCULATED_EXEMPTIONS_SEQ")
    @Column(nullable = false)
    private Long id;    

    @Column(name="DDOC_ID")
    private long documentId;
    
    @Column(name="BASE_TABLE_ID")
    private Long baseTableId;
    
    @Column(name="SUB_TAX_TYPE")
    private String subTaxType;
    
    @Column(name="EXEMPTION_CODE")
    private String exemptionCode;
    
    @Column(name="CALCULATED_VALUE") 
    private BigDecimal calculatedValue;
    
    public CalculatedExemptions() {
    }
    
    public void setId(Long id) {
    }

    public Long getId() {
        return null;
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
    
    public String getExemptionCode() {
        return exemptionCode;
    }
    
    
    public BigDecimal getCalculatedValue() {
        return calculatedValue;
    }
    
    public void setSubTaxType(String taxType) {
         this.subTaxType = taxType;
    }
    
    public void setExemptionCode(String exempCode) {
         this.exemptionCode = exempCode;
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
}
