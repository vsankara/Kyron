package com.technobrain.trips.dto;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Calendar;

/**
 * Crown Agents 2007
 * <br>
 * Generic Code and Description representation of
 * a logical code and description of an entity.
 * 
 * @since $Date: 2/2/2009 5:23:02 AM$
 * @version $Revision: 9$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  9    TRIPS2    1.8         2/2/2009 5:23:02 AM    Howard Hill     lower the
 *       log to 1 instead of 10
 * $
 */
public class CodeAndDescription implements DataTransferObject {
    
    /**
     * Logical id that represents this code and decription
     */
    private Object auxillaryId;
    private Object code;
    private String description;
    private String status;
    private Calendar createdDate;
    
    public CodeAndDescription(Object code,String description){
        this.code = code;
        this.description = description;
    }
    
    public CodeAndDescription(String code,String description){
        this.code = code;
        this.description = description;
    }
    
    public CodeAndDescription(Long code,String description){
        this.code = code;
        this.description = description;
    }
    
    public CodeAndDescription(Long code,Long description){
        this.code = String.valueOf(code);
        this.description = String.valueOf(description);
    }
    
    public CodeAndDescription(String description){
        this.description = description;
    }
    
    public CodeAndDescription(String code,String description, String cod, String des){
        this.code = code;
        this.description = code+" - "+description;
    }
    
    public CodeAndDescription(String code,String description,String status){
        this.code = code;
        this.description = description;
        this.status = status;
    }
    
    public CodeAndDescription(String code,String description,Timestamp createdDate){
        this.code = code;
        this.description = description;
        this.createdDate =  toDate(createdDate);
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
    
    public void setCode(Object code){
        this.code = code;
    }
    
    public void setDescription(String desc){
        this.description = desc;
    }
    
    public Object getCode(){
        return code;
    }
    
    public String getDescription(){
        return description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setAuxillaryId(Object auxillaryId) {
        this.auxillaryId = auxillaryId;
    }

    public Object getAuxillaryId() {
        return auxillaryId;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }
}
