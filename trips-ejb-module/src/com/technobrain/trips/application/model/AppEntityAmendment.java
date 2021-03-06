package com.technobrain.trips.application.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ENTITY")
@DiscriminatorColumn(name="ENT_REG_APP_TYPE")
@DiscriminatorValue("ENT_AMEND")
public class AppEntityAmendment extends AppEntity {
    public AppEntityAmendment() {
    }
}
