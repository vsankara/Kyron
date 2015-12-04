package com.technobrain.trips.calendarmanagement.model;

import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/**
 * TechnoBrain 2015
 *  
 * Enum mapping day number (from {@link Calendar}) to day code in CAL_WEEKEND_DAYS. 
 * 
 * @author Syed Asghar
 */
public enum CalWeekendDayEnum {
	MON("MON", 2), TUE("TUE", 3), WED("WED", 4), THU("THU", 5), FRI("FRI", 6), SAT("SAT", 7), SUN("SUN", 1);

	private CalWeekendDayEnum(final String code, final int calDayOfWeek) {
		this.code = code;
		this.calDayOfWeek = calDayOfWeek;
	}
	
	/**
	 * The Calendar day of week int.
	 */
	private int calDayOfWeek;

	/**
	 * The DB code representing the day of the week.
	 */
	private String code;

	/**
	 * Map allowing reverse lookup.
	 */
	private static final Map<String, CalWeekendDayEnum> lookup = new HashMap<String, CalWeekendDayEnum>();

	// Init for reverse lookup.
	static {
		for (CalWeekendDayEnum s : EnumSet.allOf(CalWeekendDayEnum.class))
			lookup.put(s.getCode(), s);
	}

	/**
	 * @return the calDayOfWeek
	 */
	public int getCalDayOfWeek() {
		return calDayOfWeek;
	}

	/**
	 * @return the matching instance of this enum by the code.
	 */
	public static CalWeekendDayEnum getByCode(final String code) {
		return lookup.get(code);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
