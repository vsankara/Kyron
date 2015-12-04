package com.technobrain.trips.common.logging;

import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.common.exceptions.TripsValidationException;
import com.technobrain.trips.common.helpers.DateHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.Map;

import javax.ejb.EJBContext;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Logger;

public class TripsDatabaseAppender extends AppenderSkeleton{
    public static final Logger log = Logger.getLogger(TripsDatabaseAppender.class);
    public static final String BPEL_INSTANCE_ID = "BPEL_INSTANCE_ID";
    public static final String MESSAGE_DETAIL = "MESSAGE_DETAIL";
    public static final String MODULE_NAME = "MODULE_NAME";
    public TripsDatabaseAppender() {
    }

    /**
     * Appends the activity log to database.
     * @param loggingEvent
     */
    protected void append(LoggingEvent loggingEvent) {
        Connection connection = null;
        try {
            EJBContext sessionContext = null;
            Context context = new InitialContext();
            // if we are calling this method within an ejb context:
            try {
            sessionContext = (EJBContext) context.lookup("java:comp/EJBContext");
            }
            catch(Exception ex) {
                // nothing to do.
            }
            // the below if statement is for the calls that are done outside ejb context (outside an ejb method).
            if(sessionContext == null) {
//                try {
//                    AuditFacadeLocal systemFacade = 
//                        (AuditFacadeLocal)new ServiceLocator().getLocalEJB(ServiceLocator.Services.AUDIT_FACADE);
//                    if(systemFacade != null) {
//                        sessionContext = systemFacade.getSessionContext();
//                    }
//                }
//                catch(Exception e) {
//                    return;
//                }
            }
            String userName = sessionContext.getCallerPrincipal().getName();
            
            DataSource datasource = null;
            datasource = (DataSource)context.lookup(JndiConstants.DATA_SOURCE_JNDI);
            connection = datasource.getConnection();
            if(loggingEvent.getLevel() == Level.INFO || loggingEvent.getLevel() == Level.ERROR)
                logMessage(connection, loggingEvent, userName);
            
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        } 
        finally{
            if(connection != null) {
                try {
                connection.close();
                }
                catch(SQLException e) {
                    log.error(e.getLocalizedMessage(), e);
                }
            }
        }
    }
    
    /**
     * Opens a jdbc connection, logs the event appropriately with the user name given.
     * 
     * @param connection
     * @param loggingEvent
     * @param userName
     * @throws Exception
     */
    private void logMessage(Connection connection, LoggingEvent loggingEvent, String userName) throws Exception{
        // we don't need to log the events that are coming from the mapping class.
        if(loggingEvent.getLocationInformation().getFileName().equals("Mapping.java")) {
            return;
        }
        PreparedStatement statement = null;
        Throwable ex = null;
        if(loggingEvent.getThrowableInformation() != null) {
            ex = loggingEvent.getThrowableInformation().getThrowable();
        }
        else if(loggingEvent.getMessage() instanceof Throwable) {
            ex = (Throwable)loggingEvent.getMessage();
        }
        else if(loggingEvent.getLevel() == Level.ERROR &&  loggingEvent.getMessage() instanceof String) {
            String message = (String)loggingEvent.getMessage();
            ex = new Exception(message);
        }
        
        String bpelInstanceId = null;
        if(loggingEvent.getMessage() instanceof Map) {
            bpelInstanceId = (String)((Map)loggingEvent.getMessage()).get(BPEL_INSTANCE_ID);
        }
        
        statement = connection.prepareStatement(
        " INSERT\n" + 
        "   INTO LOG_ACTIVITY_LOG" + 
        "  (\n" + 
        "    ID              ,\n" + //1
        "    MESSAGE_CODE    ,\n" + //2
        "    TYPE            ,\n" + //3
        "    BPEL_INSTANCE_ID,\n" + //4
        "    MODULE_NAME     ,\n" + //5
        "    IS_READ         ,\n" + 
        "    MESSAGE_DETAIL  ,\n" + //6
        "    EXCEPTION_DETAIL,\n" + //7
        "    OCCURENCE_CLASS ,\n" + //8
        "    CREATED_BY      ,\n" + //9
        "    CREATED_DATE    ,\n" + //10
        "    UPDATED_BY      ,\n" + //11
        "    UPDATED_DATE    ,\n" + //12
        "    STATUS          ,\n" + 
        "    VERSION\n" + 
        "  )\n" + 
        "  VALUES\n" + 
        "  (\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    'F',\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    ?,\n" + 
        "    'A',\n" + 
        "    NULL\n" + 
        "  )");

        // the message code will be null if level is info.
        statement.setString(2, findMessageCode(ex));
        // we store if message is error or info.
        statement.setString(3, loggingEvent.getLevel().toString());
        statement.setString(4, bpelInstanceId);
        String exceptionMessage = "";
        // if there is a string MESSAGE ( log.error(MESSAGE, EXCEPTION) ) and if the exception is not null which
        // means this is an error message, then we should log the string MESSAGE. If there is no MESSAGE, then only
        // EXCEPTION will be logged.
        if(loggingEvent.getMessage() != null && ex != null) {
            // if it is a system error that is coming from deep api classes, then the loggingEvent.message 
            // will be the explanation of an exception. We should store that loggingEvent.message
            // and append it while persisting the exception detail to db.
            if(isProgrammaticException(loggingEvent)) {
                statement.setString(5, findModuleName(loggingEvent));
                exceptionMessage = ex.toString();
            }
            else {
                exceptionMessage = findMessageDetail(loggingEvent);
                statement.setString(5, "");
            }
        }
        else {
            statement.setString(5, "");
        }
        // if there is an exception reported, persist it as a message detail. Otherwise it is an INFO message, persist
        // the message details.
        if(ex != null) {
            if(exceptionMessage != null && exceptionMessage.length() > 2000) {
                statement.setString(6, exceptionMessage.substring(0, 1999));
            }
            else {
                statement.setString(6, exceptionMessage);
            }
            StringBuffer exceptionDetail = new StringBuffer();
            fillExceptionStackTrace(ex, exceptionDetail);
            statement.setString(7,exceptionDetail.toString());
            // TODO: Kemal: The exception message is not written to the log file. Temporarily, I
            // printed the trace. The below line will be deleted after correcting this issue.
            log.error(ex.getLocalizedMessage(), ex);
        }
        else if(loggingEvent.getMessage() != null) {
            statement.setString(6, findMessageDetail(loggingEvent));
            statement.setString(7, "");
        }
        statement.setString(8, loggingEvent.getLocationInformation().getFileName());
        // principal name and dates should be persisted.
        statement.setString(9, userName);
        statement.setTimestamp(10, DateHelper.getSqlTimestamp(Calendar.getInstance()));
        statement.setString(11, userName);
        statement.setTimestamp(12, DateHelper.getSqlTimestamp(Calendar.getInstance()));
        
        if(statement != null) {
            // for the sequence number we will execute another query.
            PreparedStatement seqStatement = connection.prepareStatement(
                "select LOG_ACTIVITY_LOG_SEQ.nextval from dual");
            ResultSet rs = null;
            if(seqStatement.execute()) {
                rs = seqStatement.getResultSet();
            }
            if(rs.next())
                statement.setLong(1, rs.getLong(1));
            statement.execute();
        }
    }
    
    private String findMessageDetail(LoggingEvent loggingEvent) {
        if(loggingEvent.getMessage() == null)  
            return null;
        if(loggingEvent.getMessage() instanceof String) {
            return loggingEvent.getMessage().toString();
        }
        else if(loggingEvent.getMessage() instanceof Map) {
            return ((Map)loggingEvent.getMessage()).get(MESSAGE_DETAIL).toString();
        }
        return null;
    }
    
    private String findModuleName(LoggingEvent loggingEvent) {
        if(loggingEvent.getMessage() == null)  
            return null;
        if(loggingEvent.getMessage() instanceof String) {
            return loggingEvent.getMessage().toString();
        }
        else if(loggingEvent.getMessage() instanceof Map) {
            return ((Map)loggingEvent.getMessage()).get(MODULE_NAME).toString();
        }
        return null;
    }
    
    /**
     * Recursively fills the exception stack trace that is coming from the exception.
     * @param ex
     * @param exceptionDetail
     */
    private void fillExceptionStackTrace(Throwable ex, StringBuffer exceptionDetail) {
        exceptionDetail.delete(0, exceptionDetail.length());
        exceptionDetail.append("\n"+ex.toString().toUpperCase() + "\n");
        StackTraceElement[] stacks = ex.getStackTrace();
        for(StackTraceElement stack:stacks) {
            exceptionDetail.append(" \n " + stack.toString());
        }
        if(ex.getCause() != null) {
            fillExceptionStackTrace(ex.getCause(), exceptionDetail);
        }
    }
    
    /**
     * If the exception is coming from our classes, it means it is an exception that is thrown by ourselves.
     * @param loggingEvent
     * @return
     */
    private boolean isProgrammaticException(LoggingEvent loggingEvent) {
        return loggingEvent.getLocationInformation().getClassName().startsWith("com.technobrain");
    }
    
    /**
     * This method finds the related message code that represents the exception in a meaninful manner. It will be a code
     * and the detail message will be fetched from the properties file.
     * @param ex
     * @return
     */
    private String findMessageCode(Throwable ex) {
        if(ex == null)
            return null;
        if(ex instanceof TripsValidationException) {
            return "error.validation.generic";
        }
        else {
            return "error.system.generic";
        }
    }

//    private void logInfoMessage(Connection connection, LoggingEvent loggingEvent, String userName) throws Exception{
//        PreparedStatement statement = null;
//        Throwable ex = null;
//        if(loggingEvent.getThrowableInformation() != null) {
//            ex = loggingEvent.getThrowableInformation().getThrowable();
//        }
//        else if(loggingEvent.getMessage() instanceof Throwable) {
//            ex = (Throwable)loggingEvent.getMessage();
//        }
//        else if(loggingEvent.getMessage() instanceof String) {
//            String message = (String)loggingEvent.getMessage();
//            ex = new Exception(message);
//        }
//        if(ex != null && ex instanceof TripsValidationException) {
//            statement = connection.prepareStatement(
//            " INSERT\n" + 
//            "   INTO LOG_ACTIVITY_LOG" + 
//            "  (\n" + 
//            "    ID              ,\n" + 
//            "    MESSAGE_CODE    ,\n" + 
//            "    TYPE            ,\n" + 
//            "    BPEL_INSTANCE_ID,\n" + 
//            "    MODULE_NAME     ,\n" + 
//            "    IS_READ         ,\n" + 
//            "    MESSAGE_DETAIL  ,\n" + 
//            "    OCCURENCE_CLASS ,\n" + 
//            "    CREATED_BY      ,\n" + 
//            "    CREATED_DATE    ,\n" + 
//            "    UPDATED_BY      ,\n" + 
//            "    UPDATED_DATE    ,\n" + 
//            "    STATUS          ,\n" + 
//            "    VERSION\n" + 
//            "  )\n" + 
//            "  VALUES\n" + 
//            "  (\n" + 
//            "    ?,\n" + 
//            "    'error.validation.generic',\n" + 
//            "    NULL,\n" + 
//            "    NULL,\n" + 
//            "    ?,\n" + 
//            "    'F',\n" + 
//            "    ?,\n" + 
//            "    ?,\n" + 
//            "    ?,\n" + 
//            "    ?,\n" + 
//            "    ?,\n" + 
//            "    ?,\n" + 
//            "    'A',\n" + 
//            "    NULL\n" + 
//            "  )");
//            if(loggingEvent.getMessage() != null && !(loggingEvent.getMessage() instanceof Throwable))
//                statement.setString(2, loggingEvent.getMessage().toString());
//            else
//                statement.setString(2, "");
//            statement.setString(3, ex.toString());
//            statement.setString(4, loggingEvent.getLocationInformation().getFileName());
//            statement.setString(5, userName);
//            statement.setTimestamp(6, DateHelper.getSqlTimestamp(Calendar.getInstance()));
//            statement.setString(7, userName);
//            statement.setTimestamp(8, DateHelper.getSqlTimestamp(Calendar.getInstance()));
//        }
//        if(statement != null) {
//            PreparedStatement seqStatement = connection.prepareStatement(
//                "select LOG_ACTIVITY_LOG_SEQ.nextval from dual");
//            ResultSet rs = null;
//            if(seqStatement.execute()) {
//                rs = seqStatement.getResultSet();
//            }
//            if(rs.next())
//                statement.setLong(1, rs.getLong(1));
//            statement.execute();
//        }
//    }
    
    public boolean requiresLayout() {
        return false;
    }

    public void close() {
    }
}
