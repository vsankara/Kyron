package com.technobrain.trips.dto.registration;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;

/**
 * TechnoBrain 2015
 * This is a DTO for entity history details. 
 * 
 * @since $Date: 2/2/2009 5:23:03 AM$
 * @version $Revision: 3$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  3    TRIPS2    1.2         2/2/2009 5:23:03 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */
public class EntityHistory {
    
    private Calendar eventDate;
    private String event;
    private String officer;
    private String status;
    
    public EntityHistory(Timestamp eventDate,String event,String officer,String status) {
        this.eventDate = toDate(eventDate);
        this.event = event;
        this.officer = officer;
        this.status = status;
    }
    
    public EntityHistory() {
    }
    
    /**
     * Converts to a Calendar
     * @param timeStamp
     * @return
     */
    private Calendar toDate(Timestamp timeStamp) {
        if(timeStamp == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(timeStamp.getTime()));
        return c;
    }
    
    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }

    public Calendar getEventDate() {
        return eventDate;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getOfficer() {
        return officer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
