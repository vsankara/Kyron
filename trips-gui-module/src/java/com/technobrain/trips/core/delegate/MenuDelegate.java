package com.technobrain.trips.core.delegate;

import com.technobrain.trips.menu.model.AppMenuActionListener;
import com.technobrain.trips.menu.model.AppMenuCommand;
import com.technobrain.trips.menu.model.AppMenuParent;
import java.util.List;

/**
 * ? Crown Agents 2011
 * <p>
 * Provides the coupling between the application menu assembler ejb and the view
 * layer.
 *
 * @since $Date: 7/28/2011 10:00:00 AM$
 * @version $Revision: 1$
 * @author $Author: Melik Kose$
 *
 */
public class MenuDelegate extends BusinessDelegate {

    public MenuDelegate() {
    }

    public List<AppMenuParent> findAllParents() {
        List<AppMenuParent> list = getAppMenuService().findAllParents();

        return list;
    }

    public List<AppMenuCommand> findAllCommands() {

        List<AppMenuCommand> list = getAppMenuService().findAllCommands();

        return list;
    }

    public List<AppMenuActionListener> findAllActions() {
        List<AppMenuActionListener> list = getAppMenuService().findAllActionListeners();

        return list;
    }

    public AppMenuParent findParentById(Long id) {
        AppMenuParent parent;
        parent = getAppMenuService().findAppMenuParentById(id);

        return parent;
    }

    public AppMenuCommand findCommandById(Long id) {
        AppMenuCommand command;
        command = getAppMenuService().findAppMenuCommandById(id);

        return command;
    }

    public AppMenuActionListener findActionById(Long id) {
        AppMenuActionListener action;
        action = getAppMenuService().findAppMenuActionListenerById(id);

        return action;
    }

    public List<AppMenuParent> findAllMenuItems(String values) {
        List<AppMenuParent> list = getAppMenuService().findAllMenuItems(values);

        return list;
    }
}
