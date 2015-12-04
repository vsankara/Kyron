package com.technobrain.trips.menu.service;

import com.technobrain.trips.menu.model.AppMenuActionListener;
import com.technobrain.trips.menu.model.AppMenuCommand;
import com.technobrain.trips.menu.model.AppMenuParent;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AppMenuFacadeLocal {
    public AppMenuParent findAppMenuParentById(long id);

    public AppMenuCommand findAppMenuCommandById(long id);

    public AppMenuActionListener findAppMenuActionListenerById(long id);

    public List<AppMenuParent> findAllParents();

    public List<AppMenuCommand> findAllCommands();

    public List<AppMenuActionListener> findAllActionListeners();
    
    public List<AppMenuParent> findAllMenuItems(String values);

}
