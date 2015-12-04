package com.technobrain.trips.entity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntOfficer.findAll", query = "select o from EntOfficer o")
@Table(name = "ENT_OFFICER")
@DiscriminatorColumn(name="DTYPE")
@DiscriminatorValue("OFFICER")
public class EntOfficer extends EntEntity    {
    @Column(name="REF_OFFICE", nullable = false)
    private String refOffice;
    @Column(name="USER_NAME")
    private String userName;

    public EntOfficer() {
    }

    public String getRefOffice() {
        return refOffice;
    }

    public void setRefOffice(String refOffice) {
        this.refOffice = refOffice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
