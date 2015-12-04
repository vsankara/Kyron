package com.technobrain.trips.calendarmanagement.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.technobrain.trips.core.model.BaseNormalModelObject;


/**
 * TechnoBrain 2015
 *  
 * The persistent class for the CAL_WEEKEND_DAYS database table.
 * 
 * @author Syed Asghar
 */
@Entity
@NamedQueries( {
@NamedQuery(name = "CalWeekendDay.findAll", query = "select o from CalWeekendDay o")
})
@Table(name="CAL_WEEKEND_DAYS")
public class CalWeekendDay extends BaseNormalModelObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAL_WEEKEND_DAYS_SEQ") 
    @SequenceGenerator(name = "CAL_WEEKEND_DAYS_SEQ", sequenceName = "CAL_WEEKEND_DAYS_SEQ", allocationSize = 1)
	@Column(unique=true, nullable=false, precision=30)
	private Long id;

	@Column(name="DAY_OF_WEEK_CODE", nullable=false, length=500)
	private String dayOfWeekCode;

	@Column(name="DAY_OF_WEEK_DESC", nullable=false, length=500)
	private String dayOfWeekDesc;
	
    /**
	 * @return the dayOfWeekDesc
	 */
	public String getDayOfWeekDesc() {
		return dayOfWeekDesc;
	}

	/**
	 * @param dayOfWeekDesc the dayOfWeekDesc to set
	 */
	public void setDayOfWeekDesc(String dayOfWeekDesc) {
		this.dayOfWeekDesc = dayOfWeekDesc;
	}

	public CalWeekendDay() {
    }

	public String getDayOfWeekCode() {
		return this.dayOfWeekCode;
	}

	public void setDayOfWeekCode(String dayOfWeekCode) {
		this.dayOfWeekCode = dayOfWeekCode;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	/**
	 * @return an int representing the Calendar date of week representation.
	 */
	public int getCalDayOfWeek() {
		return CalWeekendDayEnum.getByCode(this.getDayOfWeekCode()).getCalDayOfWeek();
	}
	
	@Override
	public String toString() {
		return super.toString() + ": ID='" + this.getId() + "', CalWeekendDay[dayOfWeekCode='" + this.getDayOfWeekCode() + "\n"; 
	}
}