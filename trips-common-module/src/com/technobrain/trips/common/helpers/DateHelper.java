package com.technobrain.trips.common.helpers;

import com.technobrain.trips.common.constants.Constants;

import java.sql.Time;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

public class DateHelper {
    static final Logger log = Logger.getLogger(DateHelper.class);
    public static final int FINANCIAL_MONTH_END = 3;
            public static final int FINANCIAL_MONTH_START = 4;
            public static final int FINANCIAL_DAY_START = 1;
            public static final int FINANCIAL_DAY_END = 31;

            /**
             * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th day of December in the year 2002
             */
            public static final String ISO_DATE_FORMAT = "yyyyMMdd";

            /**
             * Expanded ISO 8601 Date format yyyy-MM-dd i.e., 2002-12-25 for the 25th day of December in the year 2002
             */
            public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

            /**
             * Basic ISO 8601 Time format HHmmssSSSzzz i.e., 143212333-500 for 2 pm 32 min 12 secs 333 mills -5 hours from GMT
             * 24 hour clock
             */
            public static final String ISO_TIME_FORMAT = "HHmmssSSSzzz";

            /**
             * Basic ISO 8601 Time format HH:mm:ss,SSSzzz i.e., 14:32:12,333-500 for 2 pm 32 min 12 secs 333 mills -5 hours from GMT
             * 24 hour clock
             */
            public static final String ISO_EXPANDED_TIME_FORMAT = "HH:mm:ss,SSSzzz";

            public static final String TEXT_TIME_FORMAT = "h:mm a";

            /**
             * Base ISO 8601 Date format yyyyMMddTHHmmssSSSzzz i.e., 20021225T143212333-500 for
             * the 25th day of December in the year 2002 at 2 pm 32 min 12 secs 333 mills -5 hours from GMT
             */
            public static final String ISO_DATE_TIME_FORMAT = "yyyyMMdd'T'HHmmssSSSzzz";
            /**
             * Base ISO 8601 Date format yyyy-MM-ddTHH:mm:ss,SSSzzz i.e., 2002-12-25T14:32:12,333-500 for
             * the 25th day of December in the year 2002 at 2 pm 32 min 12 secs 333 mills -5 hours from GMT
             */
            public static final String ISO_EXPANDED_DATE_TIME_FORMAT =
                    "yyyy-MM-dd'T'HH:mm:ss,SSSzzz";
            public static final DateFormatSymbols dateFormatSymbles;
            private static final String[][] foo;
            private static final int JAN_1_1_JULIAN_DAY = 1721426;
            // January 1, year 1 (Gregorian)
            private static final int EPOCH_JULIAN_DAY = 2440588;
            // Jaunary 1, 1970 (Gregorian)
            private static final int EPOCH_YEAR = 1970;

            // Useful millisecond constants.  Although ONE_DAY and ONE_WEEK can fit
            // into ints, they must be longs in order to prevent arithmetic overflow
            // when performing (bug 4173516).
            private static final int ONE_SECOND = 1000;
            private static final int ONE_MINUTE = 60 * ONE_SECOND;
            private static final int ONE_HOUR = 60 * ONE_MINUTE;
            private static final long ONE_DAY = 24 * ONE_HOUR;
            private static final long ONE_WEEK = 7 * ONE_DAY;
            private final static String DATE_FORMAT = "dd/MM/yyyy";

    
            static {
                    // override the timezone strings
                    foo = new String[0][];
                    dateFormatSymbles = new DateFormatSymbols();
                    dateFormatSymbles.setZoneStrings(foo);
            }

    public static String getDate(Date inputDate, String pattern) {
        if (inputDate == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(inputDate);
    }

    public static String getFormattedDate(Date inputDate) {
        return getDate(inputDate, "dd MMMMM, yyyy");
    }

    public static String getFormattedDateDefaultToNa(Date inputDate) {
        if (StringHelper.returnBlankIfNull(getDate(inputDate,
                                                   "dd MMMMM, yyyy")).equals("")) {
            return "n/a";
        } else {
            return getDate(inputDate, "dd MMMMM, yyyy");
        }

    }

    public static String getFormattedDateWithHoursAndMinutesOnly(Date inputDate) {
        return getDate(inputDate, "dd MMMMM, yyyy HH:mm");
    }


    public static String getFormattedDateWithoutTime(Date inputDate) {
        return getDate(inputDate, "dd/MM/yyyy");
    }


    public static String getFormattedDate(String day, String month,
                                          String year) {
        Date inputDate = getDate(day, month, year);
        return getDate(inputDate, "dd MMMMM, yyyy");
    }

    public static String getFormattedDateWithoutComma(Date inputDate) {
        return getDate(inputDate, "dd MMMMM yyyy");
    }

    public static String getFormattedTimeStamp(Date inputDate) {
        Calendar call = Calendar.getInstance();
        call.setTime(inputDate);
        int hour = call.get(Calendar.HOUR_OF_DAY);
        int minute = call.get(Calendar.MINUTE);
        int second = call.get(Calendar.SECOND);
        if (hour == 0 && minute == 0 && second == 0) {
            return getFormattedDate(inputDate);
        } else {
            return getDate(inputDate, "dd MMMMM, yyyy HH:mm:ss");
        }
    }

    public static String getFormattedTime(Date inputDate) {
        return getDate(inputDate, "HH:mm:ss");
    }

    public static Date getDate(int day, int month, int year) {
        Calendar currDate = Calendar.getInstance();
        currDate.clear();
        currDate.set(year, month - 1, day, 0, 0, 0);
        return currDate.getTime();
    }

    public static Date getTodaysDate() {
        Date tempDate = new Date();
        return getDate(getDay(tempDate), getMonth(tempDate),
                       getYear(tempDate));
    }

    public static Date getDate(String day, String month, String year) {
        int intDay = 0;
        int intMonth = 0;
        int intYear = 0;
        try {
            intDay = Integer.parseInt(day);
            intMonth = Integer.parseInt(month);
            intYear = Integer.parseInt(year);
        } catch (NumberFormatException ex) {log.error(ex.getLocalizedMessage(), ex);}
        Calendar currDate = Calendar.getInstance();
        currDate.clear();
        currDate.set(intYear, intMonth - 1, intDay, 0, 0, 0);
        return currDate.getTime();
    }

    public static Date getDate(int day, int month, int year, int hour,
                               int minute, int second) {
        Calendar currDate = Calendar.getInstance();
        currDate.set(year, month - 1, day, hour, minute, second);
        return currDate.getTime();
    }

    public static Date getDate(String day, String month, String year,
                               String hour, String minute, String second) {
        int intDay = 0;
        int intMonth = 0;
        int intYear = 0;
        int intHour = 0;
        int intMinute = 0;
        int intSecond = 0;
        try {
            intDay = Integer.parseInt(day);
            intMonth = Integer.parseInt(month);
            intYear = Integer.parseInt(year);
            intHour = Integer.parseInt(hour);
            intMinute = Integer.parseInt(minute);
            intSecond = Integer.parseInt(second);
        } catch (NumberFormatException ex) {log.error(ex.getLocalizedMessage(), ex);}
        Calendar currDate = Calendar.getInstance();
        currDate.set(intYear, intMonth - 1, intDay, intHour, intMinute,
                     intSecond);
        return currDate.getTime();
    }

    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getHour_12HrFormat(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR);
    }

    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    public static int getMilliSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MILLISECOND);
    }
    
    public static int getAM_PM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.AM_PM);
    }

    public static Date addDate(Date date, int yrs, int mnths) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, yrs);
        calendar.add(Calendar.MONTH, mnths);
        return calendar.getTime();
    }

    public static Date addDate(Date date, int yrs, int mnths, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, yrs);
        calendar.add(Calendar.MONTH, mnths);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static Date addTime(Date date, int hrs, int mins, int secs) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, secs);
        calendar.add(Calendar.MINUTE, mins);
        calendar.add(Calendar.HOUR_OF_DAY, hrs);
        return calendar.getTime();
    }

    public static   int getDiffYears(Date lowDate, Date highDate) {
        GregorianCalendar lowCal = new GregorianCalendar();
        lowCal.setTime(lowDate);
        GregorianCalendar highCal = new GregorianCalendar();
        highCal.setTime(highDate);
        boolean neg = false;
        int lowYear = lowCal.get(Calendar.YEAR);
        int highYear = highCal.get(Calendar.YEAR);
        if (highYear == lowYear) {
            return 0;
        }
        if (lowYear > highYear) {
            neg = true;
            int yx = highYear;
            highYear = lowYear;
            lowYear = yx;
        }
        int years = highYear - lowYear;
        int dayLow = lowCal.get(Calendar.DAY_OF_YEAR);
        int dayHigh = highCal.get(Calendar.DAY_OF_YEAR);
        if (highCal.isLeapYear(highYear)) {
            if (dayHigh > 60) {
                dayHigh--;
            }
        }
        if (lowCal.isLeapYear(lowYear)) {
            if (dayLow > 60) {
                dayLow--;
            }
        }
        if (dayHigh < dayLow) {
            years--;
        }
        if (neg) {
            years = -years;
        }
        return years;
    }

    public static boolean isDateBetweenGivenDates(Date date, Date startDate,
                                                  Date endDate) {
        boolean isBetweenFlag = false;
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        if ((rightNow.after(startCalendar) && rightNow.before(endCalendar))) {
            isBetweenFlag = true;
        }
        return isBetweenFlag;
    }

    public static boolean areDatesEqual(Date date, Date comparedToDate) {
        if (compareDates(date, comparedToDate) == 0) {
            return true;
        }
        return false;
    }


    public static Date getPriorDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static void main(String[] args) {
     log.debug(DateHelper.getSqlTimestampWithoutTime(Calendar.getInstance()));
    }

    public static String printDate(Date dt) {
        if (dt != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            return " " + day + "-" + month + "-" + year;
        } else {
            return " ";
        }
    }
    
    /**
     * Compares this calendarA with this calendarB to determine if they are 
     * equal or less than or greater.
     * <p>
     * This method does not take time into consideration only the date which
     * is made up of DAY, MONTH, YEAR.
     * @param calendarA
     * @param calendarB
     * @return 
     * 0 if this calendarA equal to calendarB
     * <br>
     * -1 if this calendarA less than calendarB
     * <br>
     * 1 if this calendarA greater than calendarB
     */
    public static int compareDates(Calendar calendarA, Calendar calendarB) {
        int day1 = calendarA.get(Calendar.DATE);
        int month1 = calendarA.get(Calendar.MONTH);
        int year1 = calendarA.get(Calendar.YEAR);

        int day2 = calendarB.get(Calendar.DATE);
        int month2 = calendarB.get(Calendar.MONTH);
        int year2 = calendarB.get(Calendar.YEAR);

        if (day1 == day2 && month1 == month2 && year1 == year2) {
            return 0;
        } else if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        } else if (month1 < month2) {
            return -1;
        } else if (month1 > month2) {
            return 1;
        } else if (day1 < day2) {
            return -1;
        } else if (day1 > day2) {
            return 1;
        }
        return 1;
    }

    public static int compareDatesIgnoreTime(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DATE);
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        int day2 = cal2.get(Calendar.DATE);
        int month2 = cal2.get(Calendar.MONTH);
        int year2 = cal2.get(Calendar.YEAR);

        if (day1 == day2 && month1 == month2 && year1 == year2) {
            return 0;
        } else if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        } else if (month1 < month2) {
            return -1;
        } else if (month1 > month2) {
            return 1;
        } else if (day1 < day2) {
            return -1;
        } else if (day1 > day2) {
            return 1;
        }
        return 1;
    }

    public static int compareDates(Date cal1, Date cal2) {
        Calendar instance1 = Calendar.getInstance();
        instance1.setTime(cal1);

        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(cal2);

        return compareDates(instance1, instance2);
    }

    public static boolean isDateAfterToday(Date date) {
        Date now = Calendar.getInstance().getTime();
        now = clearOutTimeElements(now);
        date = clearOutTimeElements(date);
        int value = date.compareTo(now);
        if (value == 0) {
            return false;
        } else if (value < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void printAllDateParams(Date date) {
        log.debug(date.toString());
    }

    public static boolean isDateBeforeToday(Date date) {
        Date now = Calendar.getInstance().getTime();
        now = clearOutTimeElements(now);
        date = clearOutTimeElements(date);
        int value = date.compareTo(now);
        if (value == 0) {
            return false;
        } else if (value < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Date clearOutTimeElements(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.HOUR);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTime();
    }
    
    public static Calendar clearOutCalendarTimeElements(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0); 
        cal.set(Calendar.MINUTE, 0); 
        cal.set(Calendar.SECOND, 0); 
        cal.set(Calendar.MILLISECOND, 0); 
        return cal;
    }

    public static boolean isDateToday(Date date) {
        Date now = Calendar.getInstance().getTime();
        now = clearOutTimeElements(now);
        date = clearOutTimeElements(date);

        int value = date.compareTo(now);
        if (value == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isDateOnOrBeforeToday(Date date) {
        return (isDateBeforeToday(date) || isDateToday(date));
    }

    public static boolean isDateOnOrAfterToday(Date date) {
        return (isDateAfterToday(date) || isDateToday(date));
    }

    public static Date parseDate(String inputDate, String pattern) {
        if (inputDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date returnDate = null;
        try {
            sdf.setLenient(false);
            returnDate = sdf.parse(inputDate);
        } catch (Exception e) {
            returnDate = null;
        }
        return returnDate;
    }

    public static Date parseDateToDefaultFormat(String inputDate) {
        if (inputDate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date returnDate = null;
        try {
            sdf.setLenient(false);
            returnDate = sdf.parse(inputDate);
        } catch (Exception e) {
            returnDate = null;
        }
        return returnDate;
    }

    /**
     * Validates date.
     * @param inputDate
     * @return
     */
    public static boolean isValidDate(String inputDate) {
        if (inputDate == null)
            return false;
        SimpleDateFormat dateFormat = 
            new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT);
        if (inputDate.trim().length() != dateFormat.toPattern().length())
            return false;
        dateFormat.setLenient(false);
        try {
            //parse the inDate parameter
            dateFormat.parse(inputDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static String getMonthString(int month) {
        return getDate(getDate(1, month, 200), "MMMM");
    }

    public static Date trimTimeFromDate(Date date) {
        int day = getDay(date);
        int month = getMonth(date);
        int year = getYear(date);
        return getDate(day, month, year);
    }

    public static int calculateAge(java.util.Date pDateOfBirth) {
        return getDiffYears(pDateOfBirth, new Date());
    }

    public static int getEndDayOfTheMonth(Date d) {
        Date nextMothDate = addDate(d, 0, 1, 0);
        Date nextMonthFirtsDate =
            getDate(1, getMonth(nextMothDate), getYear(nextMothDate));
        Date prevMonthLastDate = addDate(nextMonthFirtsDate, 0, 0, -1);
        return getDay(prevMonthLastDate);
    }

    public static Date getTodaysDateWithTime() {
        Date tempDate = new Date();
        return getDate(getDay(tempDate), getMonth(tempDate), getYear(tempDate),
                       getHour(tempDate), getMinute(tempDate),
                       getSecond(tempDate));
    }
    
     public static Timestamp getSqlTimestamp(Date calendar) {

        Timestamp sqlTimestamp = null;
        if (calendar != null) {
            sqlTimestamp = new Timestamp(calendar.getTime());
        }
        return sqlTimestamp;
    }

    /**
     * This method takes the input of Calendar object and returns
     * a java.sql.Timestamp object after conversion to insert into database
     * <br>.
     * @param calendar java.util.Calendar
     * @return sqlTimeStamp java.sql.Timestamp
     */
    public static Timestamp getSqlTimestamp(Calendar calendar) {

        Timestamp sqlTimestamp = null;
        if (calendar != null) {
            sqlTimestamp = new Timestamp(calendar.getTimeInMillis());
        }
        return sqlTimestamp;
    }

    /**
     * This method takes the input of java.sql.Timestamp object and returns
     * a Calendar object after conversion to display the data in calendar form
     * <br>.
     * @param sqlTimestamp java.sql.Timestamp
     * @return Calendar java.uti.Calendar
     */
    public static Calendar getCalendar(Timestamp sqlTimestamp) {

        Calendar calendar = Calendar.getInstance();
        if (sqlTimestamp != null) {
            calendar.setTimeInMillis(sqlTimestamp.getTime());
            return calendar;
        }else{
            return null;
        }

    }
    
    
    public static XMLGregorianCalendar getXMLGregorianCalendar(Timestamp sqlTimestamp) {

        XMLGregorianCalendar calendar;
        try {
            calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            if (sqlTimestamp != null) {
            //            calendar.setTime(hour, minute, second, millisecond);                (0,0,0,sqlTimestamp.getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(sqlTimestamp.getTime());
            calendar.setYear(cal.get(Calendar.YEAR));
            calendar.setDay(cal.get(Calendar.DAY_OF_MONTH));
            calendar.setMonth(cal.get(Calendar.MONTH) + 1);
            calendar.setHour(cal.get(Calendar.HOUR_OF_DAY));
            calendar.setMinute(cal.get(Calendar.MINUTE));
            calendar.setSecond(cal.get(Calendar.SECOND));
            calendar.setMillisecond(cal.get(Calendar.MILLISECOND));
            // Calendar ZONE_OFFSET and DST_OFFSET fields are in milliseconds.
            int offsetInMinutes = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000);
            calendar.setTimezone(offsetInMinutes);
                
            return calendar;
          }
        } catch (DatatypeConfigurationException e) {
        }
        return null;
    }
    
    public static Timestamp getSqlTimestampWithoutTime(Calendar calendar) {

        Timestamp sqlTimestamp = null;
        if (calendar != null) {
            Calendar newCal = Calendar.getInstance();
            newCal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
            0, 0, 0);
            newCal.set(Calendar.MILLISECOND, 0);
            sqlTimestamp = new Timestamp(newCal.getTimeInMillis());
        }
        return sqlTimestamp;
    }

    /**
     * Takes the input of Date timestamp and returns
     * a java.util.Date object after conversion
     * <br>.
     * @param timestamp any Date object, e.g., java.sql.Timestamp
     * @return Date java.util.Date
     */
    public static Date getDate(Date timestamp) {

        return null == timestamp ? null : new Date(timestamp.getTime());
    }

    public static long getNbrOfDaysBetweenTwoDates(Date endDate,Date startDate){
        endDate=DateHelper.trimTimeFromDate(endDate);
        startDate=DateHelper.trimTimeFromDate(startDate);
        return (endDate.getTime()-startDate.getTime())/Constants.MILI_SEC_PER_DAY;

    }

    public static long getNbrOfDaysBetweenTwoDates(Calendar aDate,Calendar anotherDate){
        long timeDifference=0;
        if(aDate != null && anotherDate != null)
            timeDifference = aDate.getTimeInMillis() - anotherDate.getTimeInMillis();
        return timeDifference/Constants.MILI_SEC_PER_DAY;
    }
    
    public static long getNbrOfMonths(long days) {
        return days/30L;
    }

    public static Calendar getCalendar(java.sql.Date date) {

            Calendar calendar = Calendar.getInstance();
            if (date != null) {
                calendar.setTimeInMillis(date.getTime());
                return calendar;
            }else{
                return null;
            }
    }
    
    public static Calendar getCalendar(java.util.Date date) {

            Calendar calendar = Calendar.getInstance();
            if (date != null) {
                calendar.setTimeInMillis(date.getTime());
                return calendar;
            }else{
                return null;
            }
    }

    public static String getTimeInMillisecs() {
        return Long.toString( Calendar.getInstance().getTimeInMillis() );
    }

    //~ Methods ////////////////////////////////////////////////////////////////

    /**
     *
     * @param isoString
     * @param expanded
     * @return True id leap year
     * @throws IllegalAccessError
     */
    public static final boolean isLeapYear(String isoString, boolean expanded)
            throws IllegalAccessError {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(isoToDate(isoString, expanded));

            return cal.isLeapYear(cal.get(Calendar.YEAR));
    }

    /**
     *
     * @param isoString
     * @return true if is leap year
     * @throws IllegalAccessError
     */
    public static final boolean isLeapYear(String isoString)
            throws IllegalAccessError {
            return isLeapYear(isoString, false);
    }

    public static final TimeZone getTimeZoneFromDateTime(
            String date,
            boolean expanded)  {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            formatter.parse(date);
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
        return formatter.getTimeZone();
    }

    public static final TimeZone getTimeZoneFromDateTime(String date) throws ParseException {
            return getTimeZoneFromDateTime(date, false);
    }

    /**
     * Date Arithmetic function.
     * Adds the specified (signed) amount of time to the given time field,
     * based on the GregorianCalendar's rules.
    
     * @param isoString
     * @param field
     * @param amount
     * @param expanded use formating char's
     * @return ISO 8601 Date String
     * @throws IllegalAccessError
     */
    public static final String add(
            String isoString,
            int field,
            int amount,
            boolean expanded)
            throws IllegalAccessError {
            Calendar cal =
                    GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTime(isoToDate(isoString, expanded));
            cal.add(field, amount);

            return dateToISO( new Date(cal.getTime().getTime()), expanded);
    }

    /**
     * Date Arithmetic function.
     * Adds the specified (signed) amount of time to the given time field,
     * based on the GregorianCalendar's rules.
     * no formating char's
     *
     * @param isoString
     * @param field
     * @param amount
     * @return ISO 8601 Date String
     * @throws IllegalAccessError
     */
    public static final String add(String isoString, int field, int amount)
            throws IllegalAccessError {
            return add(isoString, field, amount, false);
    }

    /**
     * Simply add the number of months to the date
     * @author hhill
     */
    public static final Date addMonths(Date date, int numberOfMonths)
            throws IllegalAccessError {
            String newDate = add(dateToISO(date), Calendar.MONTH, numberOfMonths);
            return isoToDate(newDate);
    }

    /**
     * Simply add the number of days to the date
     * @author hhill
     * 
     */
    public static final Date addDays(Date date, int numberOfDays)
            throws IllegalAccessError {
            String newDate = add(dateToISO(date), Calendar.DATE, numberOfDays);
            return isoToDate(newDate);
    }
    
    /**
     * Simply add the number of days to the date
     * @author hhill
     * 
     */
    public static final Calendar addDays(Calendar calendar, int numberOfDays)
            {
            String newDate = add(dateToISO(calendar.getTime()), Calendar.DATE, numberOfDays);
            Date date = isoToDate(newDate);
            Calendar  c = Calendar.getInstance();
            c.setTime(date);
            return c;
    }
    
    /**
     * @author hhill
     * 
     * Adds the unit amount to a date given a partiular date
     * unit to use.
     */
    public static final Date add(Date date, int unit, int unitAmount){
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            
            cal.add(unit, unitAmount);
            
            return new Date( cal.getTime().getTime() );
    }
    
    /**
     * Return an ISO date string
     *
     * @param date
     * @param expanded use formating char's
     * @return ISO date String
     */
    public static final String dateToISO(Date date, boolean expanded) {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

            return formatter.format(date);
    }

    /**
     * non-expanded
     *
     * @param date
     * @return ISO Date String
     */
    public static final String dateToISO(Date date) {
            return dateToISO(date, false);
    }

    /**
     * Converts java Date to Julian day count
     * A Julian day is defined as the number of days since Jan 1, 1.
     *
     * @param date
     * @return julian day
     */
    public static final long dateToJulianDay(Date date) {
            return millisToJulianDay(date.getTime());
    }

    /**
     * Returns the days between two dates. Positive values indicate that
     * the second date is after the first, and negative values indicate, well,
     * the opposite. Relying on specific times is problematic.
     *
     * @param early the "first date"
     * @param late the "second date"
     * @return the days between the two dates
         * @deprecated
     */
    public static final int daysBetween(Date early, Date late) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(early);
            c2.setTime(late);

            return daysBetween(c1, c2);
    }

    /**
     * Returns the days between two dates. Positive values indicate that
     * the second date is after the first, and negative values indicate, well,
     * the opposite.
     *
     * @param early
     * @param late
     * @return the days between two dates.
         * @deprecated
     */
    public static final int daysBetween(Calendar early, Calendar late) {
            return (int) (toJulian(late) - toJulian(early));
    }

    /**
    * Returns the days between two dates. Positive values indicate that
    * the second date is after the first, and negative values indicate, well,
    * the opposite.
    *
    * @param isoEarly the "first date" in ISO DateTime Format
    * @param isoLate the "second date" in ISO Date Time format
    * @return the days between the two dates
    */
    public static final long daysBetween(
            String isoEarly,
            String isoLate,
            boolean expanded)
            throws IllegalAccessError {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTimeZone(getTimeZoneFromDateTime(isoEarly, expanded));
            c1.setTime(isoToDate(isoEarly, expanded));
            c2.setTimeZone(getTimeZoneFromDateTime(isoLate, expanded));
            c2.setTime(isoToDate(isoLate, expanded));

            return millisToJulianDay(c2.getTime().getTime())
                    - millisToJulianDay(c1.getTime().getTime());
    }

    /**
     * Return an ISO date string as a java.util.Date
     *
     *
     * @param dateString
     * @param expanded use formating charaters
     * @return java.util.Date from the ISO Date in GMT
     * @throws java.text.IllegalAccessError
     */
    public static final Date isoToDate(String dateString, boolean expanded)
            throws IllegalAccessError {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
            }


        try {
            return new Date(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
    }

    /**
     * non-expanded
     *
     * @param dateString
     * @return ISO java.util.Date
     * @throws IllegalAccessError
     */
    public static final Date isoToDate(String dateString)
            throws IllegalAccessError {
            return isoToDate(dateString, false);
    }

    /**
     * Return an ISO date string as a java.sql.Date
     *
     * @param dateString
     * @param expanded    expanded use formating charaters
     * @return java.util.Date from the ISO Date in GMT
     * @throws IllegalAccessError
     */
    public static final java.sql.Date isoToSQLDate(
            String dateString,
            boolean expanded)
            throws IllegalAccessError {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return new java.sql.Date(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
    }

    /**
     * non-expanded
     *
     * @param dateString
     * @return java.sql.Date
     * @throws IllegalAccessError
     */
    public static final java.sql.Date isoToSQLDate(String dateString)
            throws IllegalAccessError {
            return isoToSQLDate(dateString, false);
    }

    /**
     *
     * @param converts a string in the format hh:mm a to a Time object
     * @param dateString
     * @return Date String
     * @throws java.text.IllegalAccessError
     */
    public static final Time stringToTime(String dateString)
            throws IllegalAccessError {
            SimpleDateFormat formatter;

            formatter = new SimpleDateFormat(TEXT_TIME_FORMAT, dateFormatSymbles);


        try {
            return new Time(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
    }

    /**
     * Converts a date to a 12 hour based string
     * @param date
     * @return date as string
     */
    public static final String timeToString(Time date){
            String result = null;
            
            if( date != null  ){
                    DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
                    
                    result = df.format(date);
            }
            
            return result;          
    }
    
    /**
     *
     * @param expanded expanded use formating charaters
     * @param dateString
     * @return ISO Date String
     * @throws java.text.IllegalAccessError
     */
    public static final Time isoToTime(String dateString, boolean expanded)
            throws IllegalAccessError {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_TIME_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_TIME_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return new Time(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
    }

    /**
     * non-expanded
     *
     * @param dateString
     * @return Time
     * @throws java.text.IllegalAccessError
     */
    public static final Time isoToTime(String dateString)
            throws IllegalAccessError {
            return isoToTime(dateString, false);
    }

    /**
     *
     * @param expanded expanded use formating charaters
     * @param dateString
     * @return ISO Time String
     * @throws java.text.IllegalAccessError
     */
    public static final Timestamp isoToTimestamp(
            String dateString,
            boolean expanded)
            throws IllegalAccessError {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_TIME_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_TIME_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return new Timestamp(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
    }

    /**
     * non-expanded
     *
     * @param dateString
     * @return Timestamp
     * @throws java.text.IllegalAccessError
     */
    public static final Timestamp isoToTimestamp(String dateString)
            throws IllegalAccessError {
            return isoToTimestamp(dateString, false);
    }

    /**
     * Convert a julian day count to a java sql Date @ midnight
     *
     * @param julian the given Julian day number.
     * @return java.sql.Date
     */
    public static final java.sql.Date julianDayCountToDate(long julian) {
            return new java.sql.Date(julianDayToMillis(julian));
    }

    /**
     * Convert a julian day count to a java util Date @ midnight
     *
     * @param julian the given Julian day number.
     * @return java.util.Date
     */
    public static final Date julianDayToDate(long julian) {
            return new Date(julianDayToMillis(julian));
    }

    /**
     * Converts Julian day to time as milliseconds.
     *
     * @param julian the given Julian day number.
     * @return time as milliseconds.
     */
    public static final long julianDayToMillis(long julian) {
            return (julian - EPOCH_JULIAN_DAY + JAN_1_1_JULIAN_DAY) * ONE_DAY;
    }

    /**
    * Converts time as milliseconds to Julian day count
     * A Julian day is defined as the number of days since Jan 1, 1.
     *
    * @param millis the given milliseconds.
    * @return the Julian day number.
    */
    public static final long millisToJulianDay(long millis) {
            return EPOCH_JULIAN_DAY - JAN_1_1_JULIAN_DAY + (millis / ONE_DAY);
    }

    /**
     * Time Field Rolling function.
     * Rolls (up/down) a single unit of time on the given time field.
     *
     * @param isoString
     * @param field the time field.
     * @param up Indicates if rolling up or rolling down the field value.
     * @param expanded use formating char's
     * @exception IllegalAccessError if an unknown field value is given.
     */
    public static final String roll(
            String isoString,
            int field,
            boolean up,
            boolean expanded)
            throws IllegalAccessError {
            Calendar cal =
                    GregorianCalendar.getInstance(
                            getTimeZoneFromDateTime(isoString, expanded));
            cal.setTime(isoToDate(isoString, expanded));
            cal.roll(field, up);

            return dateToISO( new Date(cal.getTime().getTime()), expanded);
    }

    /**
     * Time Field Rolling function.
     * Rolls (up/down) a single unit of time on the given time field.
     *
     * @param isoString
     * @param field the time field.
     * @param up Indicates if rolling up or rolling down the field value.
     * @exception IllegalAccessError if an unknown field value is given.
     */
    public static final String roll(String isoString, int field, boolean up)
            throws IllegalAccessError {
            return roll(isoString, field, up, false);
    }

    /**
     * Time Field Rolling function.
     * Rolls (up/down) a single unit of time on the given time field.
     *
     * @param date to rolll
     * @param field the time field.
     * @param up Indicates if rolling up or rolling down the field value.
     */
    public static final Date roll(Date dateToRoll, int field, boolean up){
            Calendar cal = 
                    GregorianCalendar.getInstance();
            
            cal.setTime(dateToRoll);
            cal.roll(field, up);
            
            Date result = new Date( cal.getTime().getTime() );
            
            return result;
    }
    
    /**
     *
     * @param expanded expanded use formating charaters
     * @param date
     * @return ISO Time String
     */
    public static final String timeToISO(Time date, boolean expanded) {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_TIME_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_TIME_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

            return formatter.format(date);
    }

    /**
     * non-expanded
     *
     * @param date
     * @return ISO Time String
     */
    public static final String timeToISO(Time date) {
            return timeToISO(date, false);
    }

    /**
     *
     * @param expanded expanded use formating charaters
     * @param date
     * @return ISO Date Time String
     */
    public static final String timestampToISO(
            Timestamp date,
            boolean expanded) {
            SimpleDateFormat formatter;

            if (expanded) {
                    formatter =
                            new SimpleDateFormat(
                                    ISO_EXPANDED_DATE_TIME_FORMAT,
                                    dateFormatSymbles);
            } else {
                    formatter =
                            new SimpleDateFormat(ISO_DATE_TIME_FORMAT, dateFormatSymbles);
            }

            //formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

            return formatter.format(date);
    }

    /**
     * non-expanded
     *
     * @param date
     * @return ISO Date/Time String
     */
    public static final String timestampToISO(Timestamp date) {
            return timestampToISO(date, false);
    }

    /**
     * Returns the Date from a julian. The Julian date will be converted to noon GMT,
         * such that it matches the nearest half-integer (i.e., a julian date of 1.4 gets
     * changed to 1.5, and 0.9 gets changed to 0.5.)
     *
     * @param JD the Julian date
     * @return the Gregorian date
     * @deprecated
     */
    public static final Date toDate(float JD) {
            /* To convert a Julian Day Number to a Gregorian date, assume that it is for 0 hours, Greenwich time (so
             * that it ends in 0.5). Do the following calculations, again dropping the fractional part of all
             * multiplicatons and divisions. Note: This method will not give dates accurately on the
             * Gregorian Proleptic Calendar, i.e., the calendar you get by extending the Gregorian
             * calendar backwards to years earlier than 1582. using the Gregorian leap year
             * rules. In particular, the method fails if Y<400. */
            float Z = (normalizedJulian(JD)) + 0.5f;
            float W = (int) ((Z - 1867216.25f) / 36524.25f);
            float X = (int) (W / 4f);
            float A = (Z + 1 + W) - X;
            float B = A + 1524;
            float C = (int) ((B - 122.1) / 365.25);
            float D = (int) (365.25f * C);
            float E = (int) ((B - D) / 30.6001);
            float F = (int) (30.6001f * E);
            int day = (int) (B - D - F);
            int month = (int) (E - 1);

            if (month > 12) {
                    month = month - 12;
            }

            int year = (int) (C - 4715);
            //(if Month is January or February) or C-4716 (otherwise)

            if (month > 2) {
                    year--;
            }

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1); // damn 0 offsets
            c.set(Calendar.DATE, day);

            return new Date(c.getTime().getTime());
    }

    /**
     * Return a Julian date based on the input parameter. This is
     * based from calculations found at
     * <a href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day Calculations
     * (Gregorian Calendar)</a>, provided by Bill Jeffrys.
     * @param c a calendar instance
     * @return the julian day number
     */
    public static final float toJulian(Calendar c) {
            int Y = c.get(Calendar.YEAR);
            int M = c.get(Calendar.MONTH);
            int D = c.get(Calendar.DATE);
            int A = Y / 100;
            int B = A / 4;
            int C = 2 - A + B;
            float E = (int) (365.25f * (Y + 4716));
            float F = (int) (30.6001f * (M + 1));
            float JD = (C + D + E + F) - 1524.5f;

            return JD;
    }

    /**
     * Return a Julian date based on the input parameter. This is
     * based from calculations found at
     * <a href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day Calculations
     * (Gregorian Calendar)</a>, provided by Bill Jeffrys.
     * @param date
     * @return the julian day number
     */
    public static final float toJulian(Date date) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);

            return toJulian(c);
    }

    protected static final float normalizedJulian(float JD) {
            float f = Math.round(JD + 0.5f) - 0.5f;

            return f;
    }

    /**
    * Divide two long integers, returning the floor of the quotient.
    * <p>
    * Unlike the built-in division, this is mathematically well-behaved.
    * E.g., <code>-1/4</code> => 0
    * but <code>floorDivide(-1,4)</code> => -1.
    * @param numerator the numerator
    * @param denominator a divisor which must be > 0
    * @return the floor of the quotient.
    */
    private static final long floorDivide(long numerator, long denominator) {
            // We do this computation in order to handle
            // a numerator of Long.MIN_VALUE correctly
            return (numerator >= 0)
                    ? (numerator / denominator)
                    : (((numerator + 1) / denominator) - 1);
    }
    /**
     * Method stringToDate.
     * FSL - TODO
     * @param string
     * @return java.sql.Date
     */
    public static Date stringToDate(
            String stringDate,
            String inputDateformat,
            String outPutDateFormat)
            throws IllegalAccessError {
            SimpleDateFormat sdfInput = new SimpleDateFormat(inputDateformat);
            //SimpleDateFormat sdfOutput = new SimpleDateFormat(outPutDateFormat);
            new SimpleDateFormat(outPutDateFormat);
            String textDate = stringDate;

            java.util.Date date;
        try {
            date = sdfInput.parse(textDate);
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }
        return new Date( date.getTime() );
    }

    /**
     * Method stringToDate.
     * @param string
     * @return java.sql.Date
     */
    public static Date stringToDate(String stringDate,String format) throws IllegalAccessError {
            SimpleDateFormat sdfInput = new SimpleDateFormat(format);
            String textDate = stringDate;

            java.util.Date date;
        try {
            date = sdfInput.parse(textDate);
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage(), e);
            throw new IllegalAccessError();
        }
        return new Date( date.getTime() );
    }

    /**
     * Method getYearValue.
     * @param date
     * @return int
     */
    public static int getYearValue(Date date) {
            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy");
            String year = sdfInput.format(date);

            return new Integer(year).intValue();
    }

    /**
     * Method getDayValue.
     * 
     * @author hhill
     * @param date
     * @return int
     */
    public static int getDayValue(Date date) {
            SimpleDateFormat sdfInput = new SimpleDateFormat("dd");
            String day = sdfInput.format(date);
            return new Integer(day).intValue();
    }

    /**
     * @author hhill
     * @param date
     * @return Month Value as a int
     */
    public static int getMonthValue(Date date) {
            SimpleDateFormat sdfInput = new SimpleDateFormat("MM");
            String day = sdfInput.format(date);

            return new Integer(day).intValue();
    }

    /**
     * @param now
     * @param day
     * @param month
     * @return
     */
    public static int compare(Date now, int _day, int _month) {

            int day = getDayValue(now);
            int month = getMonthValue(now);

            if (day > _day)
                    if (month > _month)
                            return 1;

            if (day > _day)
                    if (month < _month)
                            return 0;

            return -1;

    }

    /**
     * Method isGreaterThan.
     * @param early
     * @param _month
     * if the now is greater than the day and the month
     * @return boolean
     */
    public static boolean isMonthGreaterThan(
            Date early,
            Integer _month) {
            return isMonthGreaterThan(early,_month.intValue());
    }

    /**
     * Method isGreaterThan
     * <b>True if this date is greater than the day and the month</b>
     * @param now
     * @param day
     * @param month
     * @author hhill
     * @return
     */
    public static boolean isMonthGreaterThan(Date early, int _month) {
    
            int month = getMonthValue(early);

            if (month > _month) {
                    return true;
            }
            
            return false;
    }
    
    
    public static boolean isMonthLessThanOrEqual(Date early,Integer _month) {
            return isMonthLessThanOrEqual(early,_month.intValue());
    }
    
    /**
     * Method isMonthLessThanOrEqual.
     * @param early
     * @param i
     * @return boolean
     */
    public static boolean isMonthLessThanOrEqual(Date early, int _month) {
            
            int month = getMonthValue(early);
            log.debug("Month of date is  " + month);
            if (month < _month) {
                    return true;
            }
            
            if (month == _month) {
                    return true;
            }

            return false;
    }



    public static boolean isMonthLessThan(Date early,Integer _month) {
            return isMonthLessThan(early,_month.intValue());
    }
    /**
     * @author hhill
     * Method isLessThan 
     * <b>True if this date is less than the day and the month</b>
     * @param now
     * @param day
     * @param month
     * @return
     */
    public static boolean isMonthLessThan(Date early, int _month) {
            
            int month = getMonthValue(early);
            log.debug("Month of date is  " + month);
            if (month < _month) {
                    return true;
            }


            return false;
    }

    /**
     * Method yearsBetween.
     * @param date
     * @param date1
     * @return int
     */
    public static int yearsBetween(Date date, Date date1) {
            int diffInDays = daysBetween(date, date1);
            int years  =diffInDays / 365;
            log.debug("Years between " + date + " and " + date1 + " is " + years);
            return years;
    }

    /**
     * Method yearMonthDayToDate.
     * @param year
     * @param month
     * @param day
     * @param delimiter
     * @return Date
     * @throws IllegalAccessError
     */
    public static Date yearMonthDayToDate(
            String year,
            String month,
            String day,
            String delimiter)
            throws IllegalAccessError {

            String dateFormatted =
                    year.concat(delimiter).concat(month).concat(delimiter).concat(day);
            return stringToDate(dateFormatted,"dd-mm-yyyy");
    }
    
    /**
     * Method yearMonthDayToDate.
     * @param year
     * @param month
     * @param day
     * @return Date
     * @throws IllegalAccessError
     */
    public static Date yearMonthDayToDate(
            String year,
            String month,
            String day)
            throws IllegalAccessError {
            
            String delimiter = "-";
            
            String dateFormatted =
                    year.concat(delimiter).concat(month).concat(delimiter).concat(day);
            return stringToDate(dateFormatted,"dd-mm-yyyy");
    }

    /**
     * Method isNotCurrentYear.
     * @param date
     * @return boolean
     */
    public static boolean isNotCurrentYear(Date date) {
            
            if(getYearValue(new Date(System.currentTimeMillis()) ) != getYearValue(date) )
                    return true;
            else
                    return false;
    }

    /**
     * Method isYearGreaterThanOrEqual.
     * @param date
     * @param today
     * @return boolean
     */
    public static boolean isYearGreaterThanOrEqual(Date date, Date today) {
            
            if(getYearValue(date) >= getYearValue(today) )
                    return true;
            else
                    return false;
    }

    /**
     * @param licenceExpiryDate
     * @return
     */
    public static Date getStartOfFinancialYear(Date aDate) throws IllegalAccessError {
            String year = String.valueOf(getYearValue(aDate) ); 
            return yearMonthDayToDate(year,String.valueOf(FINANCIAL_MONTH_START),String.valueOf(FINANCIAL_DAY_START));
    }
    
    /**
     * @param licenceExpiryDate
     * @return
     */
    public static Date getEndOfFinancialYear(Date aDate) throws IllegalAccessError {
            String year = String.valueOf(getYearValue(aDate) ); 
            return yearMonthDayToDate(year,String.valueOf(FINANCIAL_MONTH_END),String.valueOf(FINANCIAL_DAY_END));
    }
    
    public static Calendar getCalendar(String str_date, String format){
            DateFormat formatter ; 
            Date date ;
            Calendar cal=Calendar.getInstance();
             try{
                formatter = new SimpleDateFormat(format);
                date = (Date)formatter.parse(str_date);                 
                cal.setTime(date);

             }catch(Exception e){
                 
             }
             
             return cal;  
    }
    
    public static String getCurrentHourString(){
        Date current = getTodaysDateWithTime();
        String dateString = "" + getHour_12HrFormat(current) + ":"
                            + (getMinute(current)<10?"0" +getMinute(current):"" + getMinute(current)) + ":"
                            + (getSecond(current)<10?"0"+getSecond(current):""+getSecond(current)) + ":"
                            + getMilliSecond(current) + " "
                            + (getAM_PM(current)==0?"AM": "PM") ;
                            
        return dateString;
    }
    
    /**
     * This method will check the comobination of day and month. if it is wrong it will return false otherwise true.
     * @return
     */
    public static boolean isMonthAndDayCombinationCorrect(String passedDay, String month, String passedInYear, 
                                                          String dateFormat, String seperator) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat);
            int year = (Calendar.getInstance()).get(Calendar.YEAR);
            if (passedInYear != null) {
                year = Integer.parseInt(passedInYear);
            }
            String day = FINANCIAL_DAY_START + "";
            if (passedDay != null) {
                day = passedDay;
            }
            String inputDate = day + seperator + month + seperator + year;
            df.setLenient(false);
            df.parse(inputDate);
            return true;
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage(), ex);
            return false;
        }
    }
    
    /**
     * Default implementation creates a Calendar object and returns
     * a java.sql.Timestamp object after conversion to insert into database
     * <br>.
     * 
     * @return sqlTimeStamp java.sql.Timestamp
     */
    public static Timestamp getSqlTimestamp() {
        Calendar calendar = Calendar.getInstance();  
        Timestamp sqlTimestamp = null;
        if (calendar != null) {
            sqlTimestamp = new Timestamp(calendar.getTimeInMillis());
        }
        return sqlTimestamp;
    }
    
    /**
     * Default implementation creates a Date object and returns
     * a java.sql.Timestamp object after conversion to insert into database
     * <br>.
     * 
     * @return sqlTimeStamp java.sql.Timestamp
     */
    public static Timestamp getSqlTimestamp(String date) {
        Timestamp timeSt=null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date lDate1 = dateFormat.parse(date);
            return timeSt = new Timestamp(lDate1.getTime());
        }catch(Exception e){
            log.error(e.getLocalizedMessage(), e);
        }
        return timeSt;
        
    }
    
    public static boolean isDateValid(String date) 
    {
            try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                df.setLenient(false);
                df.parse(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
    }

    
    
}
