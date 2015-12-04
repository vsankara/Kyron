package com.technobrain.trips.application.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "AppEntity.findAll", query = "select o from AppEntity o")
        , 
        @NamedQuery(name = "AppEntity.findByEntityIdAndDType", query = "select o from AppEntity o where o.entity.id=?1 and o.dtype=?2")
        } )
@Table(name = "APP_ENTITY")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "APP_TYPE")
@DiscriminatorValue("APP_ENT")
public class AppEntity extends AppApplication {

    @Column(name = "NEW_OFFICE")
    private String newOffice;

    public AppEntity() {
    }

    public void setNewOffice(String newOffice) {
        this.newOffice = newOffice;
    }

    public String getNewOffice() {
        return newOffice;
    }
}
