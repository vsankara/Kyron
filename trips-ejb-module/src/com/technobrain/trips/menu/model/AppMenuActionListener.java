package com.technobrain.trips.menu.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
        @NamedQuery(name = "AppMenuActionListener.findAll", 
                    query = "select o from AppMenuActionListener o")
    }
)
@Table(name = "APP_MENU_ACTIONLISTENERS")
public class AppMenuActionListener extends BaseNormalModelObject {

    @Id
    @Column(name="ID" ,nullable = false)
    private Long id;
    
    @Column(name="FROM_VALUE")
    private String fromValue;
    
    @Column(name="TO_VALUE")
    private String toValue;

    public AppMenuActionListener() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setToValue(String toValue) {
        this.toValue = toValue;
    }

    public String getToValue() {
        return toValue;
    }
}
