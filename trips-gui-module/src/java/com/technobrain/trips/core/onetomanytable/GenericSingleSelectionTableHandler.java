package com.technobrain.trips.core.onetomanytable;

import com.technobrain.trips.util.FacesUtil;

import java.io.Serializable;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import org.primefaces.component.datatable.DataTable;


/**
 * � Crown Agents 2006
 * <p>
 * Generic single selection table handler class.
 * 
 * @since $Date: 2/16/2010 8:24:35 PM$
 * @version $Revision: 33$
 * @author $Author: John Ferrolino$
 * 
 * $Log[1]:
 *  33   TRIPS2 etis.bir.gov.ph1.31.1.0    2/16/2010 8:24:35 PM   John
 *       Ferrolino  overloaded rowToUpdate method.
 * $
 */
public class GenericSingleSelectionTableHandler implements Serializable {
//    private List data = new ArrayList();
    private DataTable table;
    private List tableModel = new ArrayList();
    // if the data is stored, this variable becomes true. Used for understanding if the table handler is initialized with
    // data.
    private boolean loaded = false;
    private boolean allowDuplicate = false;
    private String handlerName;
    private String shortDesc;
    
    public GenericSingleSelectionTableHandler(Object[] a) {
        loaded = true;
        setDataAndRefreshTableModel(a);
        FacesContext ctx = FacesContext.getCurrentInstance();
        table = (DataTable)ctx.getApplication().createComponent(DataTable.COMPONENT_TYPE);
    }

    public GenericSingleSelectionTableHandler(List data) {
        loaded = true;
        tableModel = initTableModel(data);
        FacesContext ctx = FacesContext.getCurrentInstance();
        //creates a new table component
        table = (DataTable)ctx.getApplication().createComponent(DataTable.COMPONENT_TYPE);
    }
    
    public GenericSingleSelectionTableHandler(DataTable _table,List data) {
        loaded = true;
        tableModel = initTableModel(data);
        FacesContext ctx = FacesContext.getCurrentInstance();
        //creates a new table component
        table = _table;
    }
    
    public GenericSingleSelectionTableHandler() {
        tableModel = initTableModel(null);
        FacesContext ctx = FacesContext.getCurrentInstance();
        //creates a new table component
        table = (DataTable)ctx.getApplication().createComponent(DataTable.COMPONENT_TYPE);
    }
    
    /**
     * Clears the existing data for this table model and adds the new
     * one
     * @param newData
     */
    public void addNewData(Collection<? extends Iterable> newData) {
        getTableModel().clear();
        getTableModel().addAll(newData);
    }
    
    /**
     * Reinitialize the table model with the new data.
     * 
     * @param data rows of the table.
     */
    public void setDataAndRefreshTableModel(Object[] data) {
        if(null == data){
            tableModel = initTableModel(new ArrayList());
        }else{
         tableModel = initTableModel(new ArrayList(Arrays.asList(data)));
        }
    }
    
    /**
     * Reinitialize the table model with the new data.
     * 
     * @param data rows of the table.
     */
    public void setDataAndRefreshTableModel(List data) {
        if(null == data){
            tableModel = initTableModel(new ArrayList());
        }else{
         tableModel = initTableModel(data);
        }
    }


    /**
     * @return
     */
    public final List initTableModel(List rows) {
        if (rows == null){
            rows = new ArrayList();
            //data = rows; //load the table with blank rows       
        }
       
        return rows;
    }
    
    public final Integer getRowIndexToUpdate() {
        List<Integer> selectionList = FacesUtil.getSelectionIndex(getTable());
        if(selectionList != null && selectionList.size() > 0) {
            return selectionList.get(0);
        }
        else {
            return null;
        }
    }
    
    /**
     * Replaces the data in the specified index.
     * @param index
     * @param data
     */
    public final void replaceData(Integer index, Object data) {
        if(index == null || data == null)
            return;
        List dataList = getDataAsList();
        dataList.set(index, data);
        setDataAndRefreshTableModel(dataList);
    }


    public final Object getRowToUpdate() {
        try {
            return table.getSelection();
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public final Object getRowToUpdate(int index) {
        try {
            return tableModel.get(index);
        }
        catch(Exception e) {
            return null;
        }
    }
    
    /**
     * @since Feb 2008
     * @deprecated use getData()
     * @param arrayOfTypes
     * @return
     */
    public <T> T[] getData(T[] arrayOfTypes) {
        List list = tableModel;
        
        //create an array of this type parameter a
        if(list.isEmpty()){
            return null;
        }else{
            arrayOfTypes = (T[])Array.newInstance(list.iterator().next().getClass(),list.size()); 
        }
        
        return (T[])list.toArray(arrayOfTypes);
        
    }
    
    /**
     * 
     * @return a array of types that are contained in the table model
     */
    public <T> T[] getData() {
        List list = tableModel;
        T[] a = null;
        //create an array of this type parameter a
        if(null == list || list.isEmpty()){
            return null;
        }else{
            if(list.get(0) == null){
                return null;
            }else{
                a = (T[])Array.newInstance(list.get(0).getClass(),list.size()); 
            }
        }
        
        return (T[])list.toArray(a);
        
    }
    
    public List getDataAsList() {
        List list = tableModel;
        //create an array of this type parameter a
        if(null == list || list.isEmpty()){
            return null;
        }else{
            if(list.get(0) == null){
                return null;
            }
        }
        
        return list;
    }

    public final void createRow(Object bean) {
       if(bean instanceof List)  {
           for(Object bn:((ArrayList)bean)) {
               tableModel.add(bn);
           }
       }
       else {
        tableModel.add(bean);
       }
    }
    
    public final void createOrUpdateRow(Object bean,Comparator comparator) {
       int index = Collections.binarySearch(tableModel,bean,comparator);
       if(index < 0){
           tableModel.add(bean);
       }else{
           tableModel.set(index,bean);
       }
    }
    
    public final void createRow(Object bean,Comparator comparator) {
       if(Collections.binarySearch(tableModel,bean,comparator) == -1){
           tableModel.add(bean);
       }    
    }

    public final void deleteSelectedRows(ActionEvent evt) {
//        Set selection = table.getSelectedRowKeys();
//        Iterator iterator = selection.iterator();
//        while (iterator.hasNext()) {
//            String rowKey = (String)iterator.next();
//            table.setRowKey(rowKey);
//            Object row = table.getRowData();
//            tableModel.remove(row);
//        }
//        table.getSelectedRowKeys().clear();
    }

    public final void deleteSelectedIndividualRow() {
        Object row = table.getSelection();
        tableModel.remove(row);

//        table.getSelectedRowKeys().clear();
    }


//    public void rebuildModel(ActionEvent evt) {
//        Collection rows = getDefaultData();
//        tableModel = rows;
//    }

    /**
     * This method can be used to load data via the database or other.
     * <p>
     * Subclass may ovverride this method to implement the default data if required
     * @return a collection of data to be added to the model
     */
    protected Collection getDefaultData() {
        return null;
    }

    /*
     *********************************************************************************************
     *                              Getters and Setters                                          *
     *********************************************************************************************/
    public void settable(DataTable table) {
        this.table = table;
    }

    public DataTable getTable() {
        return table;
    }

    public void setTableModel(List tableModel) {
        this.tableModel = tableModel;
    }

    public List getTableModel() {
        return tableModel;
    }

    public boolean isARowSelected() {
        return null == getRowToUpdate() ? false : true;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setAllowDuplicate(boolean allowDuplicate) {
        this.allowDuplicate = allowDuplicate;
    }

    public boolean isAllowDuplicate() {
        return allowDuplicate;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}

