package com.technobrain.trips.entity.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_VEHICLE
 *
 * @since	$Date: 2/2/2009 5:29:53 AM$
 * @version 	$Revision: 24$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  24   TRIPS2    1.23        2/2/2009 5:29:53 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
@Entity
@NamedQuery(name = "EntVehicle.findAll", query = "select o from EntVehicle o")
@NamedQueries(
    @NamedQuery(
    name="findEntVehicleById",
    query="select ec from EntVehicle ec where ec.id = ?1",
    hints={@QueryHint(name=QueryHints.REFRESH, value=HintValues.TRUE)}
    )
)

@Table(name = "ENT_VEHICLE") 
@DiscriminatorColumn(name="TRANSPORT_TYPE")
@DiscriminatorValue("VEHICLE")
public class EntVehicle extends EntTransport {
    @Column(name="CHASSIS_NUMBER")
    private String chassisNumber;
    @Column(name="DATE_OF_MANUFACTURE")
    private Timestamp dateOfManufacture;
    @Column(name="ENGINE_CAPACITY")
    private Long engineCapacity;
    @Column(name="ENGINE_CAPACITY_UNITS")
    private String engineCapacityUnits;
    @Column(name="ENGINE_NUMBER")
    private String engineNumber;
    @Column(name="FUEL_TYPE")
    private String fuelType;
    @Column(name="MAKE")
    private String make;
    @Column(name="MODEL")
    private String model;
    @Column(name="VEHICLE_TYPE")
    private String vehicleType;
    @Column(name="CONDITION")
    private String condition;
    @Column(name="MILEAGE")
    private Long mileage;
    @Column(name="DEFERRED_START_DATE")
    private Timestamp deferredStartDate;
    @Column(name="DEFERRED_END_DATE")
    private Timestamp deferredEndDate;    
    @Column(name="WAIVED")
    private String waived;
    @Column(name="VEHICLE_DESCRIPTION")
    private String vehicleDescription;
    /*
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;
    */
    
    @ManyToOne 
    @JoinColumn(name="ENT_ENTITY_ID", referencedColumnName="ID")
    private EntEntity entEntity;
       
    
    public EntVehicle() {
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Timestamp getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Timestamp dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Long getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Long engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineCapacityUnits() {
        return engineCapacityUnits;
    }

    public void setEngineCapacityUnits(String engineCapacityUnits) {
        this.engineCapacityUnits = engineCapacityUnits;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setDeferredStartDate(Timestamp deferredStartDate) {
        this.deferredStartDate = deferredStartDate;
    }

    public Timestamp getDeferredStartDate() {
        return deferredStartDate;
    }

    public void setDeferredEndDate(Timestamp deferredEndDate) {
        this.deferredEndDate = deferredEndDate;
    }

    public Timestamp getDeferredEndDate() {
        return deferredEndDate;
    }

    public void setWaived(String waived) {
        this.waived = waived;
    }

    public String getWaived() {
        return waived;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }
}
