package com.technobrain.trips.menu.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries (
    {
        @NamedQuery(name = "AppMenuChildCommands.findAll", 
                    query = "select o from AppMenuChildCommands o")
    }
)
@Table(name = "APP_MENU_CHILD_COMMANDS")
public class AppMenuChildCommands extends BaseNormalModelObject implements Comparable<AppMenuChildCommands>{

    @Id
    @Column(nullable = false)
    private Long id;
    
    private String name;
    
    private String rendered;
    
    @Column(name = "ORDER_NO")
    private int orderNo;
    
    private String style;
    
    private String blocking;
    
    private String disabled;
    
    private String text;
    
    private String action;
    
    @OneToMany (cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(name="APP_MENU_CHILD_COMMAND_ACTION", joinColumns = { @JoinColumn(name = "COMMAND_ID" ,referencedColumnName="ID")},
        inverseJoinColumns = {@JoinColumn(name="ACTION_ID")})
    private List<AppMenuActionListener> appMenuActionListeners;
    public AppMenuChildCommands() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRendered() {
        return rendered;
    }
    
    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setAppMenuActionListeners(List<AppMenuActionListener> appMenuActionListeners) {
        this.appMenuActionListeners = appMenuActionListeners;
    }

    public List<AppMenuActionListener> getAppMenuActionListeners() {
        return appMenuActionListeners;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setBlocking(String blocking) {
        this.blocking = blocking;
    }

    public String getBlocking() {
        return blocking;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public int compareTo(AppMenuChildCommands that) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        
        if (this.getOrderNo()<that.getOrderNo())
            return BEFORE;
        else if (this.getOrderNo()==that.getOrderNo())
            return EQUAL;
        else
            return AFTER;
    }
}