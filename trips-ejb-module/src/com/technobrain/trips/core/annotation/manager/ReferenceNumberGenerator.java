package com.technobrain.trips.core.annotation.manager;

import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.common.helpers.AnnotationHelper;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.core.annotation.ReferenceNumber;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Calendar;


import java.util.Vector;

import javax.sql.DataSource;

//import oracle.toplink.essentials.descriptors.DescriptorEvent;
//import oracle.toplink.essentials.internal.sessions.AbstractSession;
//import oracle.toplink.essentials.sessions.DatabaseRecord;
//import oracle.toplink.essentials.sessions.Session;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.sessions.DatabaseRecord;

public class ReferenceNumberGenerator {
//    @Resource(name = JndiConstants.DATA_SOURCE_JNDI)
//    private static DataSource ds;
    public static final Logger log = Logger.getLogger(ReferenceNumberGenerator.class);
    /**
     * The constants that are used for the formatting. 
     */
    public static final String FORMAT_DATE_PART = "DATE";
    public static final String FORMAT_SQL_PART = "SQL";
    public static final String FORMAT_ATTRIBUTE_PART = "ATTRIBUTE(";
    
    private ReferenceNumberGenerator() {
    }
    
    /**
     * Generates the unique reference number that is used in the entity. This reference number is shown to the user in ui
     * to indicate that specific entity. This method has a generic way to generate the number. It uses ReferenceNumber
     * annotation to collect the information about creating the number. That annotation is defined in the pojo above the 
     * specific reference number attribute of the pojo.
     * 
     * @param entity
     * @param ds
     * @return
     */
    public static String generateNumber(DescriptorEvent event, boolean updateEvent) {
        if(event == null)
            return null;
        // find the referencenumber attribute in the pojo.
        Field annotationField = AnnotationHelper.getFieldByAnnotation(event.getObject().getClass(), ReferenceNumber.class);
        if(annotationField == null)
            return null;
        // find the annotation that is defined for that referencenumber attribute.
        ReferenceNumber refNumber = annotationField.getAnnotation(ReferenceNumber.class);
        if(refNumber == null)
            return null;
        // if there is already a reference number generated before, there is no need to generate again.
        try {
            Object generatedIdBefore = ReflectionHelper.invokeGetter(event.getObject(), annotationField.getName());
            if(generatedIdBefore != null)
                return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
        // obtain the select query that will be used to generate the reference number.
        String sql = refNumber.sql();
        if(sql == null)
            return null;
        // if there is a format, obtain that format.
        String format = refNumber.format();
        // holds the generated reference number that will be found by executing the query.
        String generatedId = null;
        
        //Connection con = null;
        try {
            //con = ds.getConnection();
            //Statement stmt = con.createStatement();
             if(sql.contains(FORMAT_ATTRIBUTE_PART)) {
            
                 String columnName = StringUtils.substringBetween(sql, FORMAT_ATTRIBUTE_PART, ")");
                 Object columnValue = null;
                 try {
                     columnValue = ReflectionHelper.invokeGetter(event.getObject(), columnName);
                 } catch (NoSuchMethodException e) {
                     log.error(e.getLocalizedMessage(), e);
                 }
                 if(columnValue != null) {
                     String replacableStr = FORMAT_ATTRIBUTE_PART + columnName + ")";
                     sql = sql.replace(replacableStr, columnValue.toString());
                 }
             }
          
            Vector vec = event.getSession().executeSQL(sql);
            // find the number.
            generatedId = String.valueOf(((DatabaseRecord)vec.get(0)).get("GENERATEDID"));
        } catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } 
//        finally {
//            try {
//                con.close();
//            } catch (Exception eaten) {
//            }
//        }
        if(generatedId == null)
            return null;
        // if there is a format, we will convert our generated number to the related format.
        // if there is no format, just return that generated number.
        if(format != null) {
            // e.g. ATTRIBUTE(caseType)/SQL/DATE
            // look at the caseType attribute value and replace that ATTRIBUTE(caseType) with the value.
            // replace SQL string with the generated number.
            // replace DATE string with the year.
            if(format.contains(FORMAT_SQL_PART)) {
                format = format.replace(FORMAT_SQL_PART, generatedId);
            }
            if(format.contains(FORMAT_DATE_PART)) {
                format = format.replace(FORMAT_DATE_PART, String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            }
            if(format.contains(FORMAT_ATTRIBUTE_PART)) {
                String columnName = StringUtils.substringBetween(format, FORMAT_ATTRIBUTE_PART, ")");
                Object columnValue = null;
                try {
                    columnValue = ReflectionHelper.invokeGetter(event.getObject(), columnName);
                } catch (NoSuchMethodException e) {
                    log.error(e.getLocalizedMessage(), e);
                }
                if(columnValue != null) {
                    String replacableStr = FORMAT_ATTRIBUTE_PART + columnName + ")";
                    format = format.replace(replacableStr, columnValue.toString());
                }
            }
            // make generated number the converted format.
            generatedId = format;
        }
        try {
            // put that generated reference number to the attribute of the pojo by calling the setter.
            ReflectionHelper.invokeSetter(event.getObject(), annotationField.getName(), generatedId);
            if(updateEvent)
                event.updateAttributeWithObject(annotationField.getName(), generatedId);
        } catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        return generatedId;
    }
    
    public static void main(String[] args) {
        String format = "ATTRIBUTE(caseType)/SQL";
        String generatedId = "1223/2008";
        if(format != null) {
            if(format.contains(FORMAT_SQL_PART)) {
                format = format.replace(FORMAT_SQL_PART, generatedId);
            }
            if(format.contains(FORMAT_DATE_PART)) {
                format = format.replace(FORMAT_DATE_PART, String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            }
            if(format.contains(FORMAT_ATTRIBUTE_PART)) {
                String columnName = StringUtils.substringBetween(format, FORMAT_ATTRIBUTE_PART, ")");
                Object columnValue = null;
//                try {
                    columnValue = "caseType";//ReflectionHelper.invokeGetter(entity, columnName);
//                } catch (NoSuchMethodException e) {
//                    log.error(e.getLocalizedMessage(), e);
//                }
                if(columnValue != null) {
                    String replacableStr = FORMAT_ATTRIBUTE_PART + columnName + ")";
                    format = format.replace(replacableStr, columnValue.toString());
                }
            }
            generatedId = format;
        }
        log.debug(generatedId);
    }
}
