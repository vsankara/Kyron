package com.technobrain.trips.entity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * TechnoBrain 2015
 *
 * Entity for table ENT_VESSEL
 *
 * @since	$Date: 2/2/2009 5:28:56 AM$
 * @version 	$Revision: 22$
 * @author 	$Author: Howard Hill$
 *
 * $Log[1]:
 *  22   TRIPS2    1.21        2/2/2009 5:28:56 AM    Howard Hill     change
 *       log10 to log1
 * $
 */
 

@Entity
@NamedQuery(name = "EntVessel.findAll", query = "select o from EntVessel o")
@NamedQueries(
    @NamedQuery(
    name="findEntVesselById",
    query="select ec from EntVessel ec where ec.id = ?1",
    hints={@QueryHint(name=QueryHints.REFRESH, value=HintValues.TRUE)}
    )
)

@Table(name = "ENT_VESSEL")
@DiscriminatorColumn(name="TRANSPORT_TYPE")
@DiscriminatorValue("VESSEL")
public class EntVessel extends EntTransport    {
    @Column(name="VESSEL_TYPE")
    private String vesselType;
    @Column(name="VESSEL_MAKE")
    private String vesselMake;
    @Column(name="VESSEL_MODEL")
    private String vesselModel;
    @Column(name="SHIPPING_LINE")
    private String shippingLine;
    @Column(name="VESSEL_NAME")
    private String vesselName;
    @Column(name="FLAG")
    private String flag;
    @Column(name="NORMALLY_BERTHED_AT")
    private String birthedAt;
    @Column(name="PORT_OF_REGISTRATION")
    private String registrationPort;
    @Column(name="HULL_NUMBER")
    private String hullNumber;
    @Column(name="NET_TONNAGE")
    private Long netTonnage;
    @Column(name="LENGTH")
    private Long length;

    public EntVessel() {
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setBirthedAt(String birthedAt) {
        this.birthedAt = birthedAt;
    }

    public String getBirthedAt() {
        return birthedAt;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setRegistrationPort(String registrationPort) {
        this.registrationPort = registrationPort;
    }

    public String getRegistrationPort() {
        return registrationPort;
    }

    public void setHullNumber(String hullNumber) {
        this.hullNumber = hullNumber;
    }

    public String getHullNumber() {
        return hullNumber;
    }

    public void setNetTonnage(Long netTonnage) {
        this.netTonnage = netTonnage;
    }

    public Long getNetTonnage() {
        return netTonnage;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getLength() {
        return length;
    }

    public void setVesselMake(String vesselMake) {
        this.vesselMake = vesselMake;
    }

    public String getVesselMake() {
        return vesselMake;
    }

    public void setVesselModel(String vesselModel) {
        this.vesselModel = vesselModel;
    }

    public String getVesselModel() {
        return vesselModel;
    }

    public void setShippingLine(String shippingLine) {
        this.shippingLine = shippingLine;
    }

    public String getShippingLine() {
        return shippingLine;
    }
}
