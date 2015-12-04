package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "RefLocationByCountry.findAll", 
    query = "select o from RefLocationByCountry o")
@Table(name = "REF_LOCATION_BY_COUNTRY")
public class RefLocationByCountry extends BaseRefModelObject {
    @Id 
    @Column(nullable = false)
    private Long id;
    private String code;
    private String coordinates;
    private String description;
    private String iata;
    @Column(name="IS_AIRPORT")
    private String isAirport;
    @Column(name="IS_BORDER_CROSSING")
    private String isBorderCrossing;
    @Column(name="IS_PORT")
    private String isPort;
    @Column(name="IS_POST_EXG_OFFICE")
    private String isPostExgOffice;
    @Column(name="IS_RAIL_TERMINAL")
    private String isRailTerminal;
    @Column(name="IS_RESERVED_FXD_TRANSPORT")
    private String isReservedFxdTransport;
    @Column(name="IS_RESERVED_MULTIMODAL")
    private String isReservedMultimodal;
    @Column(name="REF_COUNTRY")
    private String refCountry;
    @Column(name="ROAD_TERMINAL")
    private String roadTerminal;
    @Column(name="LOC_TYPE")
    private String locationType;
    @Column(name="SUBDIVISION")
    private String subdivision;
    
    public RefLocationByCountry() {
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIsAirport() {
        return isAirport;
    }

    public void setIsAirport(String isAirport) {
        this.isAirport = isAirport;
    }

    public String getIsBorderCrossing() {
        return isBorderCrossing;
    }

    public void setIsBorderCrossing(String isBorderCrossing) {
        this.isBorderCrossing = isBorderCrossing;
    }

    public String getIsPort() {
        return isPort;
    }

    public void setIsPort(String isPort) {
        this.isPort = isPort;
    }

    public String getIsPostExgOffice() {
        return isPostExgOffice;
    }

    public void setIsPostExgOffice(String isPostExgOffice) {
        this.isPostExgOffice = isPostExgOffice;
    }

    public String getIsRailTerminal() {
        return isRailTerminal;
    }

    public void setIsRailTerminal(String isRailTerminal) {
        this.isRailTerminal = isRailTerminal;
    }

    public String getIsReservedFxdTransport() {
        return isReservedFxdTransport;
    }

    public void setIsReservedFxdTransport(String isReservedFxdTransport) {
        this.isReservedFxdTransport = isReservedFxdTransport;
    }

    public String getIsReservedMultimodal() {
        return isReservedMultimodal;
    }

    public void setIsReservedMultimodal(String isReservedMultimodal) {
        this.isReservedMultimodal = isReservedMultimodal;
    }

    public String getRefCountry() {
        return refCountry;
    }

    public void setRefCountry(String refCountry) {
        this.refCountry = refCountry;
    }

    public String getRoadTerminal() {
        return roadTerminal;
    }

    public void setRoadTerminal(String roadTerminal) {
        this.roadTerminal = roadTerminal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getSubdivision() {
        return subdivision;
    }
}
