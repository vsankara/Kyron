package com.technobrain.trips.dropdownhelper;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.dto.CodeAndDescription;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.naming.InitialContext;

import javax.persistence.PersistenceContext;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


@Stateless(name = "DropDownHelper", mappedName = "test-Project1-DropDownHelperBean")
@Local
public class DropDownHelperBean implements DropDownHelperLocal {
	public static final Logger log = Logger.getLogger(DropDownHelperBean.class);
	
    List<CodeAndDescription> genderList;
    private DataSource ds;

    public DropDownHelperBean() {
        genderList = new ArrayList();
        genderList.add(new CodeAndDescription(Constants.MALE, Constants.MALE));
        genderList.add(new CodeAndDescription(Constants.FEMALE, 
                                              Constants.FEMALE));
    }

    public List<CodeAndDescription> getDropDownList(String listName) {
        if (listName.equals(Constants.GENDER_LIST)) {
            return genderList;
        }
        if (listName.equals(Constants.COUNTRY_LIST)) {
            return getCountryList();
        }        
        return null;
    }

    private List getCountryList() {
        return getList("REF_COUNTRY","code,description","");    
    }

    private List getList(String tableName, String fieldNames, String whereClause) {
        ArrayList list=new ArrayList();
        Connection connection=null;
        try{
            String sql = "select  " + fieldNames + " from " + tableName;
            if (!whereClause.equals("")) {
                sql = sql + " where " + whereClause;
            }
            connection=getConnection();
            Statement stmt=connection.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()){
                CodeAndDescription codeAndDescription=new CodeAndDescription(resultSet.getString(1),resultSet.getString(2));
                list.add(codeAndDescription);
            }
            resultSet.close();
            stmt.close();
            return list;
        
        }catch(Exception exp){
        	log.error("", exp);
            return list;
        }finally{
            if(connection!=null){
                try{connection.close();}catch(Exception exp){log.error("", exp);}
            }
        }
    }
    public Connection getConnection() {
        try {
            InitialContext context = new InitialContext();
            DataSource em = 
                (DataSource)context.lookup(JndiConstants.DATA_SOURCE_JNDI);
            return em.getConnection();
        } catch (Exception exp) {
            return null;
        }
    }
}
