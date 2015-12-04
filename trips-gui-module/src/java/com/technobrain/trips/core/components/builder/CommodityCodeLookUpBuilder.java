package com.technobrain.trips.core.components.builder;

import com.technobrain.trips.util.FacesUtil;

import java.lang.reflect.Field;

import javax.faces.component.ActionSource;
import javax.faces.component.UIComponent;


//import oracle.adfinternal.view.faces.taglib.listener.SetActionListener;

public class CommodityCodeLookUpBuilder extends LookUpBuilder {
    public CommodityCodeLookUpBuilder() {
    }
    
    protected UIComponent buildComponentSpecifically(Field field, UIComponent component) {
        component = super.buildComponentSpecifically(field, component);
        
//                SetActionListener searchKey = new SetActionListener();
        //to:do:currently commented for testing for 11g migration
       /* searchKey.setValueBinding(SetActionListener.FROM_KEY,FacesUtil.getFacesContext().getApplication().
                                            createValueBinding("#{webconstants.findCommoditySearchKey}"));
        searchKey.setValueBinding(SetActionListener.TO_KEY,FacesUtil.getFacesContext().getApplication().
                                            createValueBinding("#{processScope.processScopeSearchKey}"));
        ((ActionSource)component).addActionListener(searchKey);*/
        
        return component;
    }
}
