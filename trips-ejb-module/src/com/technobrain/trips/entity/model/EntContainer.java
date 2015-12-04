package com.technobrain.trips.entity.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;


import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@Entity
@NamedQuery(name = "EntContainer.findAll", query = "select o from EntContainer o")
@Table(name = "ENT_CONTAINER")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("CONTAINER")
@NamedQueries(
    @NamedQuery(
    name="findEntContainerById",
    query="select ec from EntContainer ec where ec.id = ?1",
    hints={@QueryHint(name=QueryHints.REFRESH, value=HintValues.TRUE)}
    )
)
public class EntContainer extends EntEntity {

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    private EntTransport entTransport;

    @Column(name="CONTAINER_NUMBER")
    private String containerNumber;
    @Column(name="CONTAINER_OWNER")
    private String containerOwner;
    @Column(name="CONTAINER_STATUS")
    private String containerStatus;
    @Column(name="CONTAINER_TYPE")
    private String containerType;

    @Column(name="MARKS_AND_NUMBERS")
    private String marksAndNumbers;
    @Column(name="MEASUREMENTS")
    private String measurements;
    @Column(name="REGISTRATION_ORG")
    private String registrationOrg;
    @Column(name="REGISTRATION_DATE")
    private Timestamp registrationDate;
    
    @Column(name="SHIPPING_LINE")
    private Long shippingLine;

    public EntContainer() {
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMarksAndNumbers(String marksAndNumbers) {
        this.marksAndNumbers = marksAndNumbers;
    }

    public String getMarksAndNumbers() {
        return marksAndNumbers;
    }

    public void setContainerStatus(String containerStatus) {
        this.containerStatus = containerStatus;
    }

    public String getContainerStatus() {
        return containerStatus;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setShippingLine(Long shippingLine) {
        this.shippingLine = shippingLine;
    }

    public Long getShippingLine() {
        return shippingLine;
    }

    public void setRegistrationOrg(String registrationOrg) {
        this.registrationOrg = registrationOrg;
    }

    public String getRegistrationOrg() {
        return registrationOrg;
    }

    public void setEntTransport(EntTransport entTransport) {
        this.entTransport = entTransport;
    }

    public EntTransport getEntTransport() {
        return entTransport;
    }

    public void setContainerOwner(String containerOwner) {
        this.containerOwner = containerOwner;
    }

    public String getContainerOwner() {
        return containerOwner;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }
}
