package com.technobrain.trips.compliance.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "TestTimer.findAll", query = "select o from TestTimer o")
@Table(name = "TEST_TIMER")
public class TestTimer implements Serializable {
    @Id
    @Column(nullable = false)
    private String id;
    private String status;
    @Column(name="UPDATED DATE")
    private Timestamp updated_date;

    public TestTimer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }
}
