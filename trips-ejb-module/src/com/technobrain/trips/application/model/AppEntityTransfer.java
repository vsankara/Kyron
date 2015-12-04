package com.technobrain.trips.application.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ENTITY")
@DiscriminatorColumn(name="ENT_REG_APP_TYPE")
@DiscriminatorValue("ENT_TRNSFR")
public class AppEntityTransfer extends AppEntity {
    @Column(name="NEW_OFFICE")
    private String newOffice;
    public AppEntityTransfer() {
    }
    
    public String getNewOffice() {
        return newOffice;
    }

    public void setNewOffice(String newOffice) {
        this.newOffice = newOffice;
    }
}
