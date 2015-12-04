package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @ Crown Agents 2011
 *
 * Model class representing the table "REF_OCCUPATION_CATEGORY".
 * 
 * @since       $Date: $
 * @version     $Revision: $
 * @author      $Author: Uma shankar kathinokkula$
 * 
 */
@Entity
@NamedQuery(name = "RefOccupationCategory.findAll", 
            query = "select o from RefOccupationCategory o")
@Table(name = "REF_OCCUPATION_CATEGORY")
public class RefOccupationCategory extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
    @OneToMany(mappedBy = "refOccupationCategory")
    private List<RefOccPreciseCategory> refOccPreciseCategoryList;

    public RefOccupationCategory() {
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

    public List<RefOccPreciseCategory> getRefOccPreciseCategoryList() {
        return refOccPreciseCategoryList;
    }

    public void setRefOccPreciseCategoryList(List<RefOccPreciseCategory> refOccuPreciseCategoryList) {
        this.refOccPreciseCategoryList = refOccuPreciseCategoryList;
    }

    public RefOccPreciseCategory addRefOccupationCategory(RefOccPreciseCategory refOccPreciseCategory) {
        getRefOccPreciseCategoryList().add(refOccPreciseCategory);
        refOccPreciseCategory.setRefOccupationCategory(this);
        return refOccPreciseCategory;
    }

    public RefOccPreciseCategory removeRefOccupationCategory(RefOccPreciseCategory refOccPreciseCategory) {
        getRefOccPreciseCategoryList().remove(refOccPreciseCategory);
        refOccPreciseCategory.setRefOccupationCategory(null);
        return refOccPreciseCategory;
    }
}
