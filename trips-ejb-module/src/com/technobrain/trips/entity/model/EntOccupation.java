package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * TechnoBrain 2011
 *
 * Entity for table ENT_OCCUPATION
 *
 * @since	$Date:$
 * @version 	$Revision: $
 * @author 	$Author: Uma Shankar Kathinokkula$
 * 
 * $Log[1]:
 * $
 */
@Entity
@NamedQueries  ( 
    {
@NamedQuery(name = "EntOccupation.findAll", 
    query = "select o from EntOccupation o"),
@NamedQuery(name = "EntOccupation.findOccupationById", 
    query = "select o from EntOccupation o where o.id = ?1")
    }
)
@Table(name = "ENT_OCCUPATION")
public class EntOccupation extends BaseNormalModelObject {
    @Column(name="ANNUAL_GROSS_RECEIPTS")
    private Long annualGrossReceipts;
    @OneToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "ENT_OCCUPATION_SEQ")
    @SequenceGenerator(name = "ENT_OCCUPATION_SEQ", 
                       sequenceName = "ENT_OCCUPATION_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="OCC_CAT")
    private String occCat;
    @Column(name="OCC_PRECISE_CAT")
    private String occPreciseCat;
    @Column(name="OCC_STATUS")
    private String occStatus;
    @Column(name="TOTAL_SALES_TURNOVER_PA")
    private Double totalSalesTurnoverPA;
    
    public EntOccupation() {
    }

    public Long getAnnualGrossReceipts() {
        return annualGrossReceipts;
    }

    public void setAnnualGrossReceipts(Long annualGrossReceipts) {
        this.annualGrossReceipts = annualGrossReceipts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOccCat() {
        return occCat;
    }

    public void setOccCat(String occCat) {
        this.occCat = occCat;
    }

    public String getOccPreciseCat() {
        return occPreciseCat;
    }

    public void setOccPreciseCat(String occPreciseCat) {
        this.occPreciseCat = occPreciseCat;
    }

    public String getOccStatus() {
        return occStatus;
    }

    public void setOccStatus(String occStatus) {
        this.occStatus = occStatus;
    }
    
    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setTotalSalesTurnoverPA(Double totalSalesTurnoverPA) {
        this.totalSalesTurnoverPA = totalSalesTurnoverPA;
    }

    public Double getTotalSalesTurnoverPA() {
        return totalSalesTurnoverPA;
    }
}
