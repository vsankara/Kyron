package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "FlexMenuActionListner.findAll", 
    query = "select o from FlexMenuActionListner o")
@Table(name = "FLEX_MENU_ACTION_LISTNER")
public class FlexMenuActionListner extends BaseNormalModelObject {
    @Column(name="ACTION_FROM")
    private String actionFrom;
    @Column(name="ACTION_TO")
    private String actionTo;

    @Id
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
    private FlexMenuItem flexMenuItem;

    public FlexMenuActionListner() {
    }

    public String getActionFrom() {
        return actionFrom;
    }

    public void setActionFrom(String actionFrom) {
        this.actionFrom = actionFrom;
    }

    public String getActionTo() {
        return actionTo;
    }

    public void setActionTo(String actionTo) {
        this.actionTo = actionTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlexMenuItem getFlexMenuItem() {
        return flexMenuItem;
    }

    public void setFlexMenuItem(FlexMenuItem flexMenuItem) {
        this.flexMenuItem = flexMenuItem;
    }
}
