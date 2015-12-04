package com.technobrain.trips.rules.util;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class JDBCExternalUtil {
    static final Logger log = Logger.getLogger(JDBCExternalUtil.class);
    String jndiName = null;
    String jdbcUrl = null;
    boolean jdbc;
    DataSource dataSource = null;
    
    public List getQuery(String query){
        return queryImpl(query);
    }
    
    /**
     * 
     * @param query
     * @return
     */
    private List queryImpl(String query)  {
        Connection con = null;
        List results = null;
        Statement stmt = null;
        ResultSet rs = null;
        Row row = null;
        try {
            con = isJDBC() ? geJDBCConnection() : geJNDIConnection();                             
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            results = new ArrayList();
            while (rs.next()) {
                row = new Row();
                row.addColumn(rs);
                results.add(row);     
            }  
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (SQLException e) {
           log.error(e.getLocalizedMessage(), e);
        }finally{
            try{
                if(null != stmt) stmt.close();
                if(null != rs) rs.close();
            }catch(SQLException e) {
                log.error(e.getLocalizedMessage(), e);                
            }
            if ( con != null )
                 {
                    try {
                       con.close();
                    }
                    catch( SQLException sqlException ){}
                 }
        }
        
        return null == results ? Collections.emptyList() : results; 
    }
    
    /*
     * -------------------------------------------------------
     */
    
    public JDBCExternalUtil(String _CONN, String _TYPE) {
        if(null == _TYPE){
            throw new IllegalAccessError("Missig type of connection");
        }else
            if(_TYPE.equalsIgnoreCase("JDBC")){
                jdbcUrl = _CONN;
                jdbc = true;
            }else
                if(_TYPE.equalsIgnoreCase("JNDI")){
                    jndiName = _CONN;
                }
    }

    private Connection geJDBCConnection() throws ClassNotFoundException, 
                                             SQLException {
        
        Class.forName("oracle.jdbc.OracleDriver") ;
        Connection con = DriverManager.getConnection
                   ( "jdbc:oracle:thin:" + jdbcUrl);
        return con;
    }

    private boolean isJDBC() {
        return jdbc;
    }

    private Connection geJNDIConnection() {
        InitialContext ctx;
        try {
            if(dataSource == null){
                ctx = new InitialContext();
                dataSource = (DataSource)ctx.lookup(jndiName);
                return dataSource.getConnection();
            }else{
                return dataSource.getConnection();
            }
        } catch (NamingException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
        
    } 


}
