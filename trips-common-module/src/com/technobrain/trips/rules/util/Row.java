package com.technobrain.trips.rules.util;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class Row {
    int index = 1;
    List<Column> columns;
    public Row() {
    }    
   
    public List getColumns() {
        return columns;
    }
    
    public Column getColumn(String name) {
        for(Column col:columns){
            if(col.getName().equalsIgnoreCase(name)){
                return col;
            }
        }
        
        return null;
    }

    void addColumn(Column column) {
        if(null == columns){
            columns = new ArrayList();
        }
        
        columns.add(column);
        index++;
    }

    void addColumn(ResultSet rs) throws SQLException {
        Column column = new Column();
        column.setName(rs.getMetaData().getColumnName(index));
        column.setValue(rs.getObject(index));
        addColumn(column);
    }
}
