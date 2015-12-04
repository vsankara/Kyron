package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseCompositeModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "SysDbTableDefaultCols.findAll", 
    query = "select o from SysDbTableDefaultCols o")
@Table(name = "SYS_DB_TABLE_DEFAULT_COLS")
public class SysDbTableDefaultCols  extends BaseCompositeModelObject {
    @Id
    @Column(nullable = false)
    private Long id;
    
    @Column(name="COLUMN_NAME")
    private String columnName;

    @Column(name="COLUMN_TYPE")
    private String columnType;

    @Column(name="NOT_NULL")
    private String notNull;

    @Column(name="PRIMARY_KEY")
    private String primaryKey;

    @Column(name="SCALE_OF_COL")
    private Double scaleOfCol;

    @Column(name="SIZE_OF_COL")
    private Double sizeOfCol;
    
    public SysDbTableDefaultCols() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Double getScaleOfCol() {
        return scaleOfCol;
    }

    public void setScaleOfCol(Double scaleOfCol) {
        this.scaleOfCol = scaleOfCol;
    }

    public Double getSizeOfCol() {
        return sizeOfCol;
    }

    public void setSizeOfCol(Double sizeOfCol) {
        this.sizeOfCol = sizeOfCol;
    }


    @Override
    public final boolean equals(Object object){
        if (object == this) return true;
        if ( (object == null) || !(object instanceof SysDbTableDefaultCols) ) return false;

        final SysDbTableDefaultCols col = (SysDbTableDefaultCols) object;
             
        if (columnName != null && col.getColumnName() != null){
            if(columnName.equals(col.getColumnName()))
                return true;
            else 
                return false;
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        if(columnName == null)
            return super.hashCode();
        else    
        return columnName.toString().hashCode();
    }


}
