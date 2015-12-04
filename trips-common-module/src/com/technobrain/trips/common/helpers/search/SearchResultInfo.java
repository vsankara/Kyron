package com.technobrain.trips.common.helpers.search;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author hhill
 */
public class SearchResultInfo implements Serializable {
    private Object primaryKey;
    private List<ColumnData> columns = null;
    private String accessLevel;
    
    public SearchResultInfo(){
    }
    
    /**
     * 
     * @param columnNbr
     * @param fieldName
     * @param columnValue
     */
    public void addColumn(int columnNbr,String fieldName, Object columnValue){
        if(columns == null){
            columns = new ArrayList<ColumnData>();
        }        
        columns.add(new ColumnData(columnNbr,fieldName,columnValue));
    }
    
    /**
     * 
     * @param columnNbr
     * @param fieldName
     * @param columnValue
     * @param primaryKey
     */
    public void addColumn(int columnNbr,String fieldName, Object columnValue,boolean primaryKey){
        if(columns == null){
            columns = new ArrayList<ColumnData>();
        }        
        columns.add(new ColumnData(columnNbr,fieldName,columnValue,primaryKey));
    }
    
    
    public void addColumnToGetValueFromResource(int columnNbr, String fieldName, Object columnValue, boolean primaryKey){
        if(columns == null){
            columns = new ArrayList<ColumnData>();
        }        
        ColumnData colData = new ColumnData(columnNbr,fieldName,columnValue,primaryKey);
        columns.add(colData);
    }
    
    public void addColumn(ColumnData colData){
        if(columns == null){
            columns = new ArrayList<ColumnData>();
        }        
        columns.add( colData );
    }
    
 
    public ColumnData[] getColumns(){
        if(columns == null)
            return null;
        Collections.sort(columns,new ColumnOrderComparator());
       return columns.toArray(new ColumnData[columns.size()]);
    }

    public Object getColumnValueFor(String field) {
        Object[] columns = getColumns();
        for(int i =0; i<columns.length; i++){
           ColumnData columnData = (ColumnData)columns[i];
            if(field.equalsIgnoreCase(columnData.getFieldName().trim())){
                return columnData.getValue();
            }
        }
        
        return null;
    }
    
    public void setColumnValueFor(String field, Object value) {
        Object[] columns = getColumns();
        for(int i =0; i<columns.length; i++){
           ColumnData columnData = (ColumnData)columns[i];
            if(field.equalsIgnoreCase(columnData.getFieldName().trim())){
                columnData.setValue(value);;
            }
        }        
    }
    
    public Object getColumnCodeFor(String field) {
        Object[] columns = getColumns();
        for(int i =0; i<columns.length; i++){
           ColumnData columnData = (ColumnData)columns[i];
            if(field.equals(columnData.getFieldName())){
                return columnData.getCode();
            }
        }
        throw new IllegalAccessError("field not found");
    }

    public ColumnData getSugguestedPrimaryKey() {
           Object[] columns = getColumns();
           if(columns == null)
            return null;
            for(int i =0; i<columns.length; i++){
               ColumnData columnData = (ColumnData)columns[i];
                if(columnData.isPrimaryKey()){
                    return columnData;
                }
            }
        return null;
    }

    public void setPrimaryKey(Object primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Object getPrimaryKey() {
        return primaryKey;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    private class ColumnOrderComparator implements Comparator {
        public int compare(Object o1, Object o2) {
           
            if(((ColumnData)o1).getSequenceNbr() < ((ColumnData)o2).getSequenceNbr()){
                return -1;
            }
                
            if(((ColumnData)o1).getSequenceNbr() > ((ColumnData)o2).getSequenceNbr()){
                return 1;
            }
            
            if(((ColumnData)o1).getSequenceNbr() == ((ColumnData)o2).getSequenceNbr()){
                return 0;
            }
            
            throw new IllegalAccessError("Eroor");
        }
    }
}
