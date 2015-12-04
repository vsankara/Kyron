package com.technobrain.trips.application.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AppRevenueType.findAll", 
    query = "select o from AppRevenueType o")
@Table(name = "APP_REVENUE_TYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="APP_TYPE")
@DiscriminatorValue("APP_REVTYPE")
public class AppRevenueType extends AppApplication {
    @Column(name="REVENUE_TYPE")
    private String revenueType;

    public AppRevenueType() {
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }
}
