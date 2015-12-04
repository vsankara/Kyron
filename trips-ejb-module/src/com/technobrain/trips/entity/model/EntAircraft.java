package com.technobrain.trips.entity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@Entity
@Table(name = "ENT_AIRCRAFT")
@NamedQuery(name = "EntAircraft.findAll",
    query = "select o from EntAircraft o")
@NamedQueries(
    @NamedQuery(
    name="findEntAircraftById",
    query="select ec from EntAircraft ec where ec.id = ?1",
    hints={@QueryHint(name=QueryHints.REFRESH, value=HintValues.TRUE)}
    )
)

@SequenceGenerator(name = "ENT_AIRCRAFT_SEQ", sequenceName = "ENT_AIRCRAFT_SEQ", initialValue = 1, allocationSize = 1)
@DiscriminatorColumn(name="TRANSPORT_TYPE")
@DiscriminatorValue("AIRCRAFT")
public class EntAircraft extends EntTransport    {
    @Column(name="AIRCRAFT_MAKE")
    private String make;
    @Column(name="AIRCRAFT_MODEL")
    private String model;
    @Column(name="AIRCRAFT_NAME")
    private String name;
    @Column(name="AIRCRAFT_TYPE")
    private String type;
    @Column(name="AIRLINE")
    private String airline;
    @Column(name="AIRLINE_STATUS")
    private String airlineStatus;
    @Column(name="AIRCRAFT_STATUS")
    private String aircraftStatus;

    public EntAircraft() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirlineStatus(String airlineStatus) {
        this.airlineStatus = airlineStatus;
    }

    public String getAirlineStatus() {
        return airlineStatus;
    }

    public void setAircraftStatus(String aircraftStatus) {
        this.aircraftStatus = aircraftStatus;
    }

    public String getAircraftStatus() {
        return aircraftStatus;
    }
}
