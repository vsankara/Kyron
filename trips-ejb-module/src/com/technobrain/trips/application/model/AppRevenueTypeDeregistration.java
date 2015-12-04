package com.technobrain.trips.application.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_REVENUE_TYPE")
@DiscriminatorColumn(name="REV_REG_APP_TYPE")
@DiscriminatorValue("REV_DEREG")
public class AppRevenueTypeDeregistration extends AppRevenueType {
    public AppRevenueTypeDeregistration() {
    }
}
