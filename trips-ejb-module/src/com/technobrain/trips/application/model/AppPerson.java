package com.technobrain.trips.application.model;

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
@NamedQuery(name = "AppPerson.findAll", query = "select o from AppPerson o")
@Table(name = "APP_PERSON")
public class AppPerson extends BaseNormalModelObject {
    @Column(name="APPLICATION_ROLE")
    private String applicationRole;
    @Column(name="PERSONS_DATE")
    private Timestamp date;
    private String grade;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_PERSON_SEQ")
    @SequenceGenerator(name = "APP_PERSON_SEQ", sequenceName = "APP_PERSON_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    private String name;
    private String position;
    @ManyToOne
    @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID")
    private AppApplication appApplication;

    public AppPerson() {
    }


    public String getApplicationRole() {
        return applicationRole;
    }

    public void setApplicationRole(String applicationRole) {
        this.applicationRole = applicationRole;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public AppApplication getAppApplication() {
        return appApplication;
    }

    public void setAppApplication(AppApplication appApplication) {
        this.appApplication = appApplication;
    }
}
