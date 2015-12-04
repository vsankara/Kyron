package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "FlexibleFieldDbMap.findAll", 
    query = "select o from FlexibleFieldDbMap o")
@Table(name = "FLEXIBLE_FIELD_DB_MAP")
public class FlexibleFieldDbMap extends BaseNormalModelObject   {
    @Column(name="COLUMN_NAME")
    private String columnName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_FIELD_DB_MAP_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_FIELD_DB_MAP_SEQ", sequenceName = "FLEXIBLE_FIELD_DB_MAP_SEQ", 
                       allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    @Column(name="TABLE_NAME")
    private String tableName;
    @Column(name="IS_PRIMARY_KEY")
    private String isPrimaryKey;

    public FlexibleFieldDbMap() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setIsPrimaryKey(String isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getIsPrimaryKey() {
        return isPrimaryKey;
    }
}
