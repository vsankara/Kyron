package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @ Crown Agents 2011
 *
 * Model class representing the table "REF_OCC_PRECISE_CATEGORY".
 * 
 * @since       $Date: $
 * @version     $Revision: $
 * @author      $Author: Uma shankar kathinokkula$
 * 
 */
@Entity
@NamedQuery(name = "RefOccPreciseCategory.findAll", 
            query = "select o from RefOccPreciseCategory o")
@Table(name = "REF_OCC_PRECISE_CATEGORY")
public class RefOccPreciseCategory extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
    @ManyToOne
    @JoinColumn(name = "OCCUPATION", referencedColumnName = "CODE")
    private RefOccupationCategory refOccupationCategory;

    public RefOccPreciseCategory() {
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

    public RefOccupationCategory getRefOccupationCategory() {
        return refOccupationCategory;
    }

    public void setRefOccupationCategory(RefOccupationCategory refOccupationCategory) {
        this.refOccupationCategory = refOccupationCategory;
    }
}
