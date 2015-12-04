package com.technobrain.trips.usermanagement.model;

import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
{
                @NamedQuery(name = "WfisUserPrinter.findAll", 
                          query = "select o from WfisUserPrinter o"), 
                @NamedQuery(name = "WfisUserPrinter.findPrinterByUserName", 
                           query = "select o from WfisUserPrinter o where o.userName=?1")
}                           
)
@Table(name = "WFIS_USER_PRINTER")
public class WfisUserPrinter implements Serializable {
    @Id
    @Column(name = "USER_NAME", nullable=false)
    private String userName;
    @Column(name = "PRINTER")
    private String printer;
    @Column(name="OFFICE")
    private String office;

    public WfisUserPrinter() {
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }
}
