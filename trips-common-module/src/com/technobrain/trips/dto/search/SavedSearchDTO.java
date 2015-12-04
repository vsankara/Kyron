package com.technobrain.trips.dto.search;

import com.technobrain.trips.dto.DataTransferObject;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will carry the values of the search parameters that are given by the user from the search in saved search page to the
 * facade bean search method.
 */
public class SavedSearchDTO implements DataTransferObject{
    private String referenceNo;
    private String searchedBy;
    private Timestamp searchDateFrom;
    private Timestamp searchDateTo;
    private String searchName;
    private String searchType;
    /**
     * There can be additional search parameters for some specific search id's. This will hold the data for these specific
     * search parameters.
     */
    private Map additionalSearchFields = new HashMap();
    
    public SavedSearchDTO() {
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

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setSearchedBy(String searchedBy) {
        this.searchedBy = searchedBy;
    }

    public String getSearchedBy() {
        return searchedBy;
    }

    public void setSearchDateFrom(Timestamp searchDateFrom) {
        this.searchDateFrom = searchDateFrom;
    }

    public Timestamp getSearchDateFrom() {
        return searchDateFrom;
    }

    public void setSearchDateTo(Timestamp searchDateTo) {
        this.searchDateTo = searchDateTo;
    }

    public Timestamp getSearchDateTo() {
        return searchDateTo;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setAdditionalSearchFields(Map additionalSearchFields) {
        this.additionalSearchFields = additionalSearchFields;
    }

    public Map getAdditionalSearchFields() {
        return additionalSearchFields;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchType() {
        return searchType;
    }
}
