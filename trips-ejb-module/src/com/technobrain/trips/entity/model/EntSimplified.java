package com.technobrain.trips.entity.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries  ( 
    {
@NamedQuery(name = "EntSimplified.findAll", 
    query = "select o from EntSimplified o"),
@NamedQuery(name = "EntSimplified.findEntSimplifiedByRelationId", 
    query = "select o from EntSimplified o where o.id = ?1")
    }
)
@Table(name = "ENT_SIMPLIFIED")
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("SIMPLIFIED")
public class EntSimplified extends EntEntity {
    @Column(name = "DATE_OF_BIRTH")
    private Timestamp dateOfBirth;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    private String name;
    @Column(name = "NIA_PIN")
    private Long niaPin;
    private String surname;

    public EntSimplified() {
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNiaPin() {
        return niaPin;
    }

    public void setNiaPin(Long niaPin) {
        this.niaPin = niaPin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
