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

/**
 * TechnoBrain 2011
 *
 * 
 * AppMenuParent Entity
 * 
 * Implements standard functionality like finding a database entry according to its ID, 
 * fetching all of the entries on the table, or fetching some of the entries filtered by
 * some constraints..
 *
 * @since	$Date: 7/28/2011 10:00:00 AM$
 * @version 	$Revision: 1$
 * @author 	$Author: Melik Kose$
 * 

 */

@Entity
@NamedQueries(
    {
    @NamedQuery(name = "AppMenuParent.findAll", 
        query = "select parent " +
                "from AppMenuParent as parent " +
                "   left outer join parent.appMenuCommands as command " +
                "   left outer join command.appMenuActionListeners as action " +
                "order by command.orderNo, parent.orderNo"),
    @NamedQuery(name = "AppMenuParent.findAllMenuItems", 
        query = "select parent " +
                "from AppMenuParent parent " +
                "   left join parent.appMenuCommands command " +
                "   left join command.appMenuCommandList subcommands " +
                "   left join command.appMenuActionListeners action " +
                "where (parent.rendered in (?1) and command.rendered in (?2) and subcommands.rendered in(?3)) " +
                "   or (parent.rendered in (?4) and command.rendered in (?5) and Size(command.appMenuCommandList) = 0) " +
                "   or (parent.rendered in (?6) and Size(parent.appMenuCommands) = 0) " +
                "order by command.orderNo, parent.orderNo")
    }
)
@Table(name = "APP_MENU_PARENTS")
public class AppMenuParent extends BaseNormalModelObject implements Comparable<AppMenuParent>{

    @Id
    @Column(name="ID" ,nullable = false)
    private Long id;
    
    private String name;
    
    private String rendered;
    
    private String text;
        
    @Column(name = "ORDER_NO")
    private int orderNo;
    
    @OneToMany (cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(name="APP_MENU_PARENT_COMMAND", joinColumns = { @JoinColumn(name = "PARENT_ID")},
        inverseJoinColumns = {@JoinColumn(name="COMMAND_ID")})
    private List<AppMenuCommand> appMenuCommands;
    
    public AppMenuParent()  {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getRendered() {
        return rendered;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setAppMenuCommands(List<AppMenuCommand> appMenuCommands) {
        this.appMenuCommands = appMenuCommands;
    }

    public List<AppMenuCommand> getAppMenuCommands() {
        return appMenuCommands;
    }
    
    public int compareTo(AppMenuParent that) {
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

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
