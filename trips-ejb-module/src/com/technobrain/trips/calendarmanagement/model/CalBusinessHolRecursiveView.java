package com.technobrain.trips.calendarmanagement.model;

import com.technobrain.trips.core.model.BaseModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 * 
 * The persistent class for the CAL_BIZ_HOL_RECURSIVE database table.
 * 
 * @author Syed Asghar
 */
@Entity
@NamedQueries( {
	@NamedQuery(name = "CalBusinessHolRecursiveView.findAll", query = "select o from CalBusinessHolRecursiveView o"),
        @NamedQuery(name = "CalBusinessHolRecursiveView.findBizHolsFromStartDate", 
			query = "select o from CalBusinessHolRecursiveView o where " +
                                        "o.startMonthPlusDate >= ?1" ),
        @NamedQuery(name = "CalBusinessHolRecursiveView.findBizHolsUptoEndDate", 
			query = "select o from CalBusinessHolRecursiveView o where " +
                                        "o.endMonthPlusDate <= ?2" ),
	@NamedQuery(name = "CalBusinessHolRecursiveView.findBizHolsInRange", 
			query = "select o from CalBusinessHolRecursiveView o where " +
                                        "(o.startMonthPlusDate <= ?1 AND o.endMonthPlusDate >= ?2) " + //Holiday totally encapsulates range
					"OR " +
					"(o.startMonthPlusDate >= ?1 AND o.startMonthPlusDate <= ?2) " + //Range breaks the holiday's start barrier
					"OR " +
					"(o.endMonthPlusDate >= ?1 AND o.endMonthPlusDate <= ?2) " )//Range breaks the holiday's end barrier),
                                            
	})
@Table(name="CAL_BUSINESS_HOL_RECURSIVE")
public class CalBusinessHolRecursiveView extends BaseModelObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "DESCRIPTION")
	private String description;

//	@Column(name="END_DATE")
//	private Integer endDate;

        @Column(name="END_MONTH_PLUS_DATE")
        private Integer endMonthPlusDate;

	@Column(name="END_DATE_FULL")
	private Timestamp endDateFull;

//	@Column(name="END_MONTH")
//	private Integer endMonth;

	@Id
	@Column(name = "ID")
	private Long id;

//	@Column(name="START_DATE")
//	private Integer startDate;
    
        @Column(name="START_MONTH_PLUS_DATE")
        private Integer startMonthPlusDate;

	@Column(name="START_DATE_FULL")
	private Timestamp startDateFull;

//	@Column(name="START_MONTH", insertable=false, updatable=false)
//	private Integer startMonth;

    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;

	/**
	 * Biz holiday type code.
	 */
    @Column(name="BIZ_HOL_TYPE_CODE")
	private String refBizHolidayType;
	
	/**
	 * @return the refBizHolidayType
	 */
	public String getRefBizHolidayType() {
		return refBizHolidayType;
	}

	/**
	 * @param refBizHolidayType the refBizHolidayType to set
	 */
	public void setRefBizHolidayType(String refBizHolidayType) {
		this.refBizHolidayType = refBizHolidayType;
	}

	public CalBusinessHolRecursiveView() {
    }

    @Override
    public final boolean equals(Object other) {
        if(other instanceof CalBusinessHolRecursiveView){
            final CalBusinessHolRecursiveView otherRecBizHol = (CalBusinessHolRecursiveView)other;
    
            if (getId() != null && otherRecBizHol.getId() != null) {
                return getId().equals(otherRecBizHol.getId());
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(getId() != null) {
            return getId().hashCode();
        } 
        else   
            return super.hashCode();
    }

    /**
     * @return the description.
     */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return the end date.
	 */
	public Integer getEndDate() {
		return getDate(getEndMonthPlusDate());
	}

    /**
	 * @return the endDateFull
	 */
	public Timestamp getEndDateFull() {
		return endDateFull;
	}

	public Integer getEndMonth() {
		return getMonth(getEndMonthPlusDate());
	}

	public Long getId() {
		return this.id;
	}

	public Integer getStartDate() {
		return getDate(getStartMonthPlusDate());
	}

	/**
	 * @return the startDateFull
	 */
	public Timestamp getStartDateFull() {
		return startDateFull;
	}

	public Integer getStartMonth() {
            return getMonth(getStartMonthPlusDate());
        }

	public void setDescription(String description) {
		this.description = description;
	}

//	public void setEndDate(Integer endDate) {
//		this.endDate = endDate;
//	}

	/**
	 * @param endDateFull the endDateFull to set
	 */
	public void setEndDateFull(Timestamp endDateFull) {
		this.endDateFull = endDateFull;
	}

//	public void setEndMonth(Integer endMonth) {
//		this.endMonth = endMonth;
//	}

	public void setId(Long id) {
		this.id = id;
	}

//	public void setStartDate(Integer startDate) {
//		this.startDate = startDate;
//	}

	/**
	 * @param startDateFull the startDateFull to set
	 */
	public void setStartDateFull(Timestamp startDateFull) {
		this.startDateFull = startDateFull;
	}

//    public void setStartMonth(Integer startMonth) {
//		this.startMonth = startMonth;
//	}


    public void setEndMonthPlusDate(Integer endMonthPlusDate) {
        this.endMonthPlusDate = endMonthPlusDate;
    }

    public Integer getEndMonthPlusDate() {
        return endMonthPlusDate;
    }

    public void setStartMonthPlusDate(Integer startMonthPlusDate) {
        this.startMonthPlusDate = startMonthPlusDate;
    }

    public Integer getStartMonthPlusDate() {
        return startMonthPlusDate;
    }
    
    public boolean isSpanningAYear(){
        return getEndMonthPlusDate() >= 10000;
    }
    
    private Integer getMonth(Integer monthPlusDate){
        String asString = monthPlusDate.toString();
        int start = asString.length() >= 4 ? asString.length() - 4 : 0;
        String subString = asString.substring(start, asString.length() - 2);
        return Integer.valueOf(subString);
    }
    
    private Integer getDate(Integer monthPlusDate){
        String asString = monthPlusDate.toString();
        String subString = asString.substring(asString.length() - 2, asString.length());
        return Integer.valueOf(subString);
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }
}
