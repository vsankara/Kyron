package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.TreeMap;
/**
 * Crown Agents 2007
 * <br>
 * Provides the java interfaces to the xml tag
 * <code>dynamicQueryInjection</code>.
 * @since $Date: 12/1/2009 10:23:12 PM$
 * @version $Revision: 6$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]:
 *  6    TRIPS2 etis.bir.gov.ph1.4.2.0     12/1/2009 10:23:12 PM  Howard Hill  
 *         Merge from SearchQueryInjection.java, Revision 1.5 
 * $
 */
public class SearchQueryInjection implements Serializable {
    private String forField;
    private Object withValue;
    private String joinQuery;
    private String where;
    private TreeMap tables;
    private String tablesAsString;
    
    /**
     * Holds the conditions to add to the query injection
     */
    private String condition;
            
    public SearchQueryInjection(String forField, Object withValue) {
        this.forField = forField;
        this.withValue = withValue;
    }
    
    public SearchQueryInjection(String forField, String withValue, 
                                String where) {
        this(forField,withValue);
        this.where = where;
    }
    

    public String getForField() {
        return forField;
    }

    public Object getWithValue() {
        return withValue;
    }

    public String getWhere() {
        return where;
    }

    public TreeMap getTables() {
        return tables;
    }

    public void setTables(TreeMap tables) {
        this.tables = tables;
    }
    
    public ArrayList getTableAsList(){
       return new  ArrayList(tables.values());       
    }

    public void setJoinQuery(String joinQuery) {
        this.joinQuery = joinQuery;
    }

    public String getJoinQuery() {
        return joinQuery;
    }

    public void setTablesAsString(String tablesAsString) {
        this.tablesAsString = tablesAsString;
    }

    public String getTablesAsString() {
        return tablesAsString;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
