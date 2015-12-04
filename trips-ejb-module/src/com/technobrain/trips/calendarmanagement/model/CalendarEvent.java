package com.technobrain.trips.calendarmanagement.model;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.technobrain.trips.core.model.BaseNormalModelObject;

/**
 * TechnoBrain 2015
 * 
 * The persistent class for the Calendar events which is the root for business holiday.
 * 
 * @author Syed Asghar
 */
@Entity
@NamedQuery(name = "CalendarEvent.findAll", 
            query = "select o from CalendarEvent o")
@Table(name = "CAL_CALENDAR_EVENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("CALENDAR_EVENT")
public class CalendarEvent extends BaseNormalModelObject {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CAL_CALENDAR_EVENT_SEQ")
    @SequenceGenerator(name = "CAL_CALENDAR_EVENT_SEQ", 
                       sequenceName = "CAL_CALENDAR_EVENT_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "RECURSIVE")
    private Boolean recursive;
    
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;

    /**
     * @return the startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        final SimpleDateFormat dateFormat = 
            new SimpleDateFormat("dd/MM/yyyy hh:ss");
        final String formattedStartDate = 
            dateFormat.format(new Date(this.getStartDate().getTime()));
        final String formattedEndDate = 
            dateFormat.format(new Date(this.getEndDate().getTime()));

        return "CalendarEvent[StartDate: " + formattedStartDate + 
            ", EndDate: " + formattedEndDate + ", Recursive: " + recursive + 
            "]";
    }

    /**
     * @return the recursive
     */
    public Boolean getRecursive() {
        return recursive;
    }

    /**
     * @param recursive the recursive to set
     */
    public void setRecursive(Boolean recursive) {
        this.recursive = recursive;
    }
    
    public Timestamp getExpiryDate(){
        return this.expiryDate;
    }
    
    public void setExpiryDate(Timestamp expiryDate){
        this.expiryDate = expiryDate;
    }
}
