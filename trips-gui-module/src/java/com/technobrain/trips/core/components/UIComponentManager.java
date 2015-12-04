package com.technobrain.trips.core.components;

import com.technobrain.trips.core.components.builder.ComponentBuilder;

import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;


public class UIComponentManager {
    private ComponentBuilder componentBuilder;
    
    public UIComponentManager() {
    }

    public void setComponentBuilder(ComponentBuilder componentBuilder) {
        this.componentBuilder = componentBuilder;
    }

    /*
     * TABLE BUILDER
     */
    
    public void constructCoreTable(){
        componentBuilder.buildComponent(FacesContext.getCurrentInstance());
    }
    
    public DataTable getCoreTable() {
        return (DataTable)componentBuilder.getComponent();
    }
    
    /*
     * END TABLE BUILDER
     */
    
}
