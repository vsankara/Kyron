package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
    
    
    
@NamedQueries(
 {
  @NamedQuery
  (
    name = "RefTaxBandSelectionMethod.findAll", 
    query = "select o from RefTaxBandSelectionMethod o"
  ),
  @NamedQuery
  (
   name = "RefTaxBandSelectionMethod.findByCode", 
   query = "select o from RefTaxBandSelectionMethod o where o.code=?1"
  )
 }
)      
    
    
@Table(name = "REF_TAX_BAND_SELECTION_METHOD")
public class RefTaxBandSelectionMethod  extends BaseRefModelObject{
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="PROVIDER")
    private String provider;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

    public RefTaxBandSelectionMethod() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

}
