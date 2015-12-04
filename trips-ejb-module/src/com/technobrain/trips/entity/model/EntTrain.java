package com.technobrain.trips.entity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;


import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@Entity
@NamedQuery(name = "EntTrain.findAll", query = "select o from EntTrain o")
@NamedQueries(
    @NamedQuery(
    name="findEntTrainById",
    query="select ec from EntTrain ec where ec.id = ?1",
    hints={@QueryHint(name=QueryHints.REFRESH, value=HintValues.TRUE)}
    )
)

@Table(name = "ENT_TRAIN")
@DiscriminatorColumn(name="TRANSPORT_TYPE")
@DiscriminatorValue("TRAIN")
public class EntTrain extends EntTransport {

    @Column(name="NO_OF_CARRIAGES")
    private Long noOfCarriages;
    @Column(name="RAIL_COMPANY")
    private String railCompany;
    @Column(name="TRAIN_MAKE")
    private String trainMake;
    @Column(name="TRAIN_MODEL")
    private String trainModel;
    @Column(name="TRAIN_NAME")
    private String trainName;
    @Column(name="TRAIN_TYPE")
    private String trainType;

    public EntTrain() {
    }

    public Long getNoOfCarriages() {
        return noOfCarriages;
    }

    public void setNoOfCarriages(Long noOfCarriages) {
        this.noOfCarriages = noOfCarriages;
    }

    public String getRailCompany() {
        return railCompany;
    }

    public void setRailCompany(String railCompany) {
        this.railCompany = railCompany;
    }

    public String getTrainMake() {
        return trainMake;
    }

    public void setTrainMake(String trainMake) {
        this.trainMake = trainMake;
    }

    public String getTrainModel() {
        return trainModel;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
}
