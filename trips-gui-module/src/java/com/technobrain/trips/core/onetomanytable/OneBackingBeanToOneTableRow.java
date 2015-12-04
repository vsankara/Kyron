package com.technobrain.trips.core.onetomanytable;


import com.technobrain.trips.core.RowWrapper;
import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;

import java.lang.reflect.InvocationTargetException;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * �?��Crown Agents 2006
 * <p>
 * Represents the table row for this backing bean which is linked to the
 * parent backing bean via a faces outcome , a session variable TABLE_HANDLER_KEY
 * and the returnFromDialog method on this class.
 *
 * @since $Date: 26/05/2009 18:05:22$
 * @version $Revision: 26$
 * @author $Author: Howard Hill$
 *
 * $Log[1]:
 *  26   TRIPS2    1.25        26/05/2009 18:05:22    Howard Hill     updated
 *       with addition of office security
 * $
 */ 
public abstract class OneBackingBeanToOneTableRow extends BackingBase{
    
    /**
     * Define the session key used for the single select table handler
     */
    public static final String TABLE_HANDLER_KEY = WebConstants.SessionVariable.TABLE_HANDLER_KEY;
    
    /**
     * Define the mode used when table data is to be mananger
     */
    public static final String TABLE_MODE_KEY = WebConstants.SessionVariable.TABLE_MODE_KEY;
    
    /**
     * No mode defined
     */
    public static final int TABLE_NO_MODE = -1;
    
    /**
     * Indicates that the table is in Add Mode
     */
    public static final int TABLE_ADD_MODE = 1;
    
    
    /**
     * Indicates that the table is in Create Mode
     */
    public static final int TABLE_CREATE_MODE = 5;
    
    /**
     * Indicates that the table is in Edit Mode
     */
    public static final int TABLE_EDIT_MODE = 2;   
    
    /**
     * Indicates that the table is in View Mode
     */
    public static final int TABLE_VIEW_MODE = 3; 
    
    /**
     * Indicates that the table is in Delete Mode
     */
    public static final int TABLE_DELETE_MODE = 4; 
    
    /**
     * Indicates that the changes made should be discarded
     */
    public static final String DISCARD_CHANGES = "discardChanges";
    
    public static final String TO_VIEW_ID = "toViewId";
    
    /**
     * @see  OneBackingBeanToOneTableRow#onPageLoad(int mode, Object selectedRowData)
     */
    

    public void setDiscardChanges(boolean discardChanges) {
        this.discardChanges = discardChanges;
    }

    public OneBackingBeanToOneTableRow() {   
        onPageLoad(getMode(),getRowData());      
    }
    
    /**
     * Used to generate the input type that will be used in the backing bean extending OneBackingBeanToOneTableRow. 
     * Generally will be called from the onPageLoad method that is overriden in the backing bean.
     * @param inputTypeClass
     * @param MODE
     * @param rowData
     * @return
     */
    protected <T> T generateCurrentInputType(Class<T> inputTypeClass, int MODE, Object rowData) {
        T currentInputType = MessageHelper.init(inputTypeClass);
        if (MODE == TABLE_EDIT_MODE || MODE == TABLE_VIEW_MODE && null != rowData) {
            //If editing an existing record
            //Finds row selected
            T original = null;
            if(rowData instanceof RowWrapper) {
                original = (T)((RowWrapper)rowData).getType();
            }
            else {
                original = (T)rowData;
            }
            try {
            	PropertyUtils.copyProperties(currentInputType, original);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
        }    
        return currentInputType;
    }
    
    

    //~--- methods ------------------------------------------------------------
    
    /**
     * Firsted call when the page is loaded.This allows for this rowData 
     * to be presented to the user on the screen.
     * <p>
     * Note it is expected that subclass use this MODE to determine what
     * actions need to be performed. E.g. 
     * <code>
     *  if(MODE == TABLE_EDIT_MODE){
     *      //update the bean on the page with this rowData.
     *  }
     * </code>
     * <br>
     * TODO: Another method could be made to perform the edit operation
     * 
     * @param MODE - EDIT, ADD etc
     * @param rowData - the selected row in the table
     */
    protected abstract void onPageLoad(int MODE,Object rowData);
 
    /**
     * Subclasses will need to return the bean used in the data binding
     * to the fields on the page.
     * @return the bean used on the page to represent the data
     */
    protected abstract Object getBeanRepresentedAsRow();

    /**
     * @return the mode of the current process i.e ADD_MODE, EDIT_MODE , etc
     */
    public final int getMode() {
        Object mode = getTableModeKey();

        if (mode != null) {
            return ((Integer) mode).intValue();
        } else {
            return 0;
        }
    }
 

    
    /**
     * Gets the 
     * @return
     */
     public String getCurrentPageMode() {
         int mode = getMode();
         if(mode == 0) {
             return super.getPageMode();
         }
         switch(mode){
             case TABLE_ADD_MODE: return "Global.GuiMode."+"ADD";
             case TABLE_VIEW_MODE: return "Global.GuiMode."+"VIEW";
             case TABLE_EDIT_MODE: return "Global.GuiMode."+"EDIT";
             case TABLE_DELETE_MODE: return "Global.GuiMode."+"DELETE";
             case TABLE_CREATE_MODE: return "Global.GuiMode."+"CREATE";
         }
        throw new IllegalAccessError("No mode found");
     }

    
    public String getPageMode() {
        int mode = getMode();
        if(mode == 0) {
            return super.getPageMode();
        }
        switch(mode){
            case TABLE_ADD_MODE: return Constants.Modes.ADD;
            case TABLE_VIEW_MODE: return Constants.Modes.VIEW;
            case TABLE_EDIT_MODE: return Constants.Modes.EDIT;
            case TABLE_CREATE_MODE: return Constants.Modes.CREATE;
            case TABLE_DELETE_MODE: return "DELETE";
        }    
        
        return super.getPageMode();
    }



    protected String getPageConfig() {
        return super.getPageConfig();
    }
    
    /**
     * @return the row selected in the table.
     */
    protected final Object getRowData() {
        GenericSingleSelectionTableHandler handler = getTableHander();        
       
        if(handler == null){
            if(log.isDebugEnabled())log.debug("the table handler is null see echo: " + handler);
            return null;
        }
        
        if((getMode() == TABLE_EDIT_MODE || getMode() == TABLE_VIEW_MODE)
            && handler.getRowToUpdate() == null){ 
            if(log.isDebugEnabled())log.debug("return " + handler);
            returnFromDialog(null,null);
        }
        return handler.getRowToUpdate();
    }

    /**
     * This needs to be included on the child page for the  
     * button e.g. the Ok button that will return to the parent page with the 
     * new or update row data.
     * <br>
     * <b>action="#{backingTransitOfficeDetails.returnFromDialog}"</b>
     * @return
     */
    public String returnFromDialog() {

        // Gets the values written, added or edited

        // Returns to page came from with values input
        // Values now sitting in object 'bean'
        if(isValidProcess(getMode())){
            //checks if changes made are to be discarded
            if(isChangesToBeDiscarded()){
                Object orginal = null; //for add mode
                if(getMode() == TABLE_EDIT_MODE){
                  orginal  = getRowData(); // copy the original
                }                
                 
                returnFromDialog(orginal, null);//returns the original data
            }else{
                returnFromDialog(getBeanRepresentedAsRow(), null); //return the new or updated data
            }
            
            Object toViewId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("toViewId");
            if(log.isDebugEnabled())log.debug("View Id " + toViewId);
            return toViewId == null ? null : String.valueOf(toViewId);
           
        }else{
           
           if( ! FacesUtil.getFacesContext().getMessages().hasNext() ){
                FacesUtil.addFacesErrorMessage("ProcessInValidPleaseTryAgain");
           }
           
            
           if(isChangesToBeDiscarded()){
                Object orginal = null; //for add mode
                if(getMode() == TABLE_EDIT_MODE){
                  orginal  = getRowData(); // copy the original
                }                
                  
                returnFromDialog(orginal, null);//returns the original data
           }
             
            return null;
        }
        
    }
    
    public boolean isAddMode(){
        return TABLE_ADD_MODE == getMode() ? true : false;
    }
    
    public boolean isViewMode(){
        return TABLE_VIEW_MODE == getMode() ? true : false;
    }
    
    public boolean isEditMode(){
        return TABLE_EDIT_MODE == getMode() ? true : false;
    }
    
    public boolean isCreateMode(){
        return TABLE_CREATE_MODE == getMode() ? true : false;
    }
    
    public boolean isDeleteMode(){
        return TABLE_DELETE_MODE == getMode() ? true : false;
    }
    public String returnFromWindow() {

        // Gets the values written, added or edited
        //FacesContext ctx = FacesContext.getCurrentInstance();
        
        GenericSingleSelectionTableHandler handler = getTableHander();
        int mode = getMode();

        switch (mode) {
        case TABLE_ADD_MODE:
            if(isChangesToBeDiscarded()){
                break;
            }
            else{
                createNewRow(handler, getBeanRepresentedAsRow());
                break;
            }
        case TABLE_CREATE_MODE:
            if(isChangesToBeDiscarded()){
                break;
            }
            else{
                createNewRow(handler, getBeanRepresentedAsRow());
                break;
            }

        case TABLE_EDIT_MODE:
            if (null != handler.getRowToUpdate() && getBeanRepresentedAsRow() != null)
                if(isChangesToBeDiscarded()){
                    break;
                }
                else{
                    editSelectedRow(handler.getRowToUpdate(), getBeanRepresentedAsRow());
                    break;
                }
            break;
        }
        /**
         * 
         * OneBackingBeanToOneTableRow class's          * 
         * public void setViewID(ActionEvent evt) function set's TO_VIEW_ID
         * */
        //String toViewId = (String)FacesUtil.getFacesContext().getExternalContext().getRequestParameterMap().get(TO_VIEW_ID);
        String toViewId = (String)FacesUtil.getProcessScope().get(TO_VIEW_ID);
        if(toViewId == null || toViewId.equals("")) {
            goPreviousByLookingAtTheFlowOfPages();
            return null;
        }
        return navigateBack(toViewId);
    }    
  
    /**
     * Uses this selected row in this table and the trasient data bean in the
     * child page.
     * <p>
     * This selectedRow represented in the table is expected 
     * implement com.crownagents.trips.declaration.beans.Updateble in order
     * to call the update method on the interface.
     *       
     * @param selectedRow
     * @param transientDataBean
     */
    protected void editSelectedRow(Object selectedRow, 
                                   Object transientDataBean) {
        copyProperties(selectedRow,transientDataBean);
    }
    
    /**
     * Allow subclass to override the implementation of copy row
     * to table used by editSelectedRow
     * @param dest
     * @param source
     */
    protected void copyProperties(Object dest, Object source){
        OneBackingBeanToManyTableUtil.defaultCopyFunction(dest,source);
    }
    

    /**
     * Uses this handler to create a new row with this
     * transientDataBean
     * @param handler
     * @param transientDataBean
     */
    protected void createNewRow(GenericSingleSelectionTableHandler handler, 
                                Object transientDataBean) {
        
        if(null != transientDataBean)
            handler.createRow(transientDataBean);
    }
    
    /**
     * Called when the user hits the Ok button.
     * @param currentMode
     * @return true if the process is valid. 
     */
    protected abstract boolean isValidProcess(int currentMode);
   
    
    /**
     * Checks the request param map data of DISCARD_CHANGE  
     * @return true if DISCARD_CHANGES = true
     */
    public boolean isChangesToBeDiscarded() {
    	return discardChanges;
    }
    
    public void discardChanges(ActionEvent event){ 
    	String val = (String)event.getComponent().getAttributes().get("discardChanges");
        discardChanges = Boolean.valueOf(val);
    }
    

    protected GenericSingleSelectionTableHandler getTableHander() {
        FacesContext ctx = FacesContext.getCurrentInstance();
       return (GenericSingleSelectionTableHandler)ctx.getExternalContext().getSessionMap().get(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY);

    }


    protected Object getTableModeKey() {
        return FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get(TABLE_MODE_KEY);
    }
    
    public void setViewID(ActionEvent evt)
    {
    	String toViewID = (String) evt.getComponent().getAttributes().get(TO_VIEW_ID);    	
		FacesUtil.getProcessScope().put(TO_VIEW_ID, toViewID);
    }
    
    /**
     * The method is used to verify the Uniqueness of the search key value selected 
     * to add a record or update the slected record. 
     * If duplicate found false is returned else true is returned.
     * If the popup is opened in ADD MODE, duplicte check is done with all the records.
     * If the popup is opened in EDIT_MODE, duplicate check is done with all the other records looping 
     * through the table list.
     * 
     * @param attribute
     * @return
     */
     public boolean verifyDataUniqueness(String attribute) {
    
        try {
            if (isValidProcess(getMode())) {
                // Duplicate check when opened in ADD MODE
                if (getMode() == TABLE_ADD_MODE) {
                    boolean bFlag = true;
                    // user selected/Entered key search value. 

                    Object searchValue = 
                        ReflectionHelper.getFieldValue(getBeanRepresentedAsRow(), 
                                                       attribute);
                    String strSearchValue = null;
                    if (searchValue != null && !searchValue.equals("")) {
                        strSearchValue = searchValue.toString();
                    } else {
                        return true;
                    }
                    // Gets the entire table data as list.
                    List dataList = getTableHander().getDataAsList();
                    if (dataList != null) {
                        // Loops through each row data of the table.
                        for (Object tableData: dataList) {
                            // Key value in the existing data in the table for each row.
                            Object existingData = 
                                ReflectionHelper.getFieldValue(tableData, 
                                                               attribute);
                            //Changes made to below code, to validate the unique code validation for business sector    
                            if (existingData != null && 
                                String.valueOf(existingData).equals(strSearchValue)) {
                                bFlag =  false;
                                break;
                            } else {
                                bFlag = true;
                            }
                            if(!bFlag){
                                bFlag =  false;
                            }
                        }
                    } else {
                        bFlag = true;
                    }
                   return bFlag;
                }
                // Duplicate check when opened in EDIT MODE
                else if (getMode() == TABLE_EDIT_MODE) {
                    boolean isValid = true;
                    // User selected key data for update.
                    Object searchValue = 
                        ReflectionHelper.getFieldValue(getTableHander().getRowToUpdate(), 
                                                       attribute);
                    String strSearchValue = null;
                    if (searchValue != null) {
                        strSearchValue = searchValue.toString();
                    } else {
                        return true;
                    }
                    // user selected/Entered new key search value.                                   
                    String strNewValue = 
                        ReflectionHelper.getFieldValue(getBeanRepresentedAsRow(), 
                                                       attribute).toString();

                    // Gets the entire table data as list.
                    List dataList = getTableHander().getDataAsList();
                    String strExistingData = null;
                    if (dataList != null) {
                        // Loops through each row data of the table.
                        for (Object tableData: dataList) {
                            // Key value in the existing data in the table for each row.
                             Object objExistingData = 
                                 ReflectionHelper.getFieldValue(tableData, 
                                                                attribute);
                            if(objExistingData!= null){ 
                                strExistingData = 
                                ReflectionHelper.getFieldValue(tableData, 
                                                               attribute).toString();
                             }                                  
                               if (strSearchValue.equals(strNewValue)) {
                                isValid = true;
                                break;
                            } else if (strExistingData != null && strNewValue.equals(strExistingData)) {
                                isValid = false;
                            }
                            if (!isValid) {
                                isValid = false;
                            }
                        }
                    } else {
                        isValid = true;
                    }
                    return isValid;
                }
            }
        } catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }
}


