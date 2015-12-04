package com.technobrain.trips.calendarmanagement.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * TechnoBrain 2015
 * 
 * CalBusinessHoliday entity represents a business holiday with a start (date) and end (date) ie a range.
 * 
 * @author Syed Asghar
 */
@Entity
@NamedQueries( {
@NamedQuery(name = "CalBusinessHoliday.findAll", query = "select o from CalBusinessHoliday o"),
@NamedQuery(name = "CalBusinessHoliday.findBizHolsFromStartDate", 
			query = "select o from CalBusinessHoliday o where " +
                                        "o.startDate >= ?1" ),
@NamedQuery(name = "CalBusinessHoliday.findBizHolsUptoEndDate", 
			query = "select o from CalBusinessHoliday o where " +
                                        "o.endDate <= ?2" )
})

@NamedNativeQuery(name = "CalBusinessHoliday.findAllBusinessHolidaysInRange", 
            query = "select ce.*, cbh.* from CAL_BUSINESS_HOLIDAY cbh,CAL_CALENDAR_EVENT ce  where cbh.id=ce.id and " +
            "(trunc(ce.start_Date) >= TO_DATE(?1,'DD-MM-YYYY') and trunc(ce.end_Date) <= TO_DATE(?2,'DD-MM-YYYY'))",
            resultClass=CalBusinessHoliday.class)
            
@Table(name = "CAL_BUSINESS_HOLIDAY")
@DiscriminatorValue("BUSINESS_HOLIDAY")
public class CalBusinessHoliday extends CalendarEvent {

    /**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default con.
	 */
	public CalBusinessHoliday() {
	}
	
	/**
     * Constructor constructs a {@link CalBusinessHoliday}from a {@link CalBusinessHolRecursiveView}
     */
	public CalBusinessHoliday(final CalBusinessHolRecursiveView businessHolRecursiveView) {
		this.setDescription(businessHolRecursiveView.getDescription());
		this.setStartDate(businessHolRecursiveView.getStartDateFull());
		this.setEndDate(businessHolRecursiveView.getEndDateFull());
		this.setId(businessHolRecursiveView.getId());
		this.setRefBizHolidayType(businessHolRecursiveView.getRefBizHolidayType());
		this.setRecursive(true);
                this.setExpiryDate(businessHolRecursiveView.getExpiryDate());
	}
	
	/**
	 * The holiday description.
	 */
	@Column(name="DESCRIPTION")
    private String description;
	
	/**
	 * Biz holiday type code.
	 */
    @Column(name="BIZ_HOL_TYPE_CODE")
	private String refBizHolidayType;
    
    /**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the refBizHolidayType
	 */
	public String getRefBizHolidayType() {
		return refBizHolidayType;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param refBizHolidayType the refBizHolidayType to set
	 */
	public void setRefBizHolidayType(String refBizHolidayType) {
		this.refBizHolidayType = refBizHolidayType;
	}

	@Override
	public String toString() {
		return super.toString() + ": CalBusinessHoliday[Description='" + this.getDescription() + "\n"; 
	}
}
