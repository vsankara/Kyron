package com.technobrain.trips.core.onetomanytable;

import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;


/**
 * Created for the sake of merging the functionalities that are used for OneBackingBeanToOneTableRow and 
 * OneBackingBeanToManyTables classes. By extending this class, the backing bean can be used as OneBackingBeanToOneTableRow
 * or OneBackingBeanToManyTables at the same time. (i.e. BackingConsignment.java)
 */
public abstract class OneBackingBeanToTableRowAndTables extends OneBackingBeanToOneTableRow {
    protected OneBackingBeanToManyTables backingBeanToManyTable = new OneBackingBeanToManyTables(this);
    
    public OneBackingBeanToTableRowAndTables() {
        super();
    }

    public void setBackingBeanToManyTable(OneBackingBeanToManyTables backingBeanToManyTable) {
        this.backingBeanToManyTable = backingBeanToManyTable;
    }

    public OneBackingBeanToManyTables getBackingBeanToManyTable() {
        return backingBeanToManyTable;
    }
    
    public void processReturnFromTableEvent(SelectEvent evt) {
        backingBeanToManyTable.processReturnFromTableEvent(evt);
    }
    
    public void launchAddDialog(ActionEvent event) {
        backingBeanToManyTable.launchAddDialog(event);
    }
    
    public String processAdd() {
        return backingBeanToManyTable.processAdd();
    }

    public String processEdit() {
        return backingBeanToManyTable.processEdit();
    }
    
    public String processView(){
        return backingBeanToManyTable.processView();
        
    }
    
    /**
     * Method which allows to delete records without confirmation message for one or many tables
     * @return
     */
    public String processDelete(){
        return backingBeanToManyTable.processDelete();
    }
    
    public String processDeleteConfirmation(){
        return backingBeanToManyTable.processDeleteConfirmation();
    }
}
