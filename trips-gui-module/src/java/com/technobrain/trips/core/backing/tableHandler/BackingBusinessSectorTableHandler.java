package com.technobrain.trips.core.backing.tableHandler;


import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.core.message.BusinessSectorInputType;

import javax.faces.context.FacesContext;

public class BackingBusinessSectorTableHandler extends BackingTableHandler{
    public BackingBusinessSectorTableHandler() {
        super();
    }
    
    public BackingBusinessSectorTableHandler(Object[] data) {
        super(data);
    }
    
    public String deleteRecord() {
        if(tableHandler != null && tableHandler.getTableModel() != null && tableHandler.getTableModel().size() == 0){
            FacesUtil.addFacesErrorMessage("Global.msg.NoRecordsFound");
            return null;
        }else{
            if(!tableHandler.isARowSelected()){
                FacesUtil.addFacesErrorMessage("Global.msg.NoRowSelected");
                return null;
            }else{
                String tableHandlerKey = retrieveTableHandlerName();
                
                Object selectedRow = tableHandler.getTable().getSelection();
                if(selectedRow != null ){
                
                    // if this organization is a RGD organization and this business sector is its primary business sector prevent delete (TRGHA-13340)
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    Boolean value = Boolean.valueOf((String)ctx.getExternalContext().getRequestParameterMap().get("renderRGD"));
                    if(value == true && ((BusinessSectorInputType)selectedRow).isPrimaryIndicator() == true) {
                        FacesUtil.addFacesErrorMessage("Global.msg.NoChangeOnPrimaryBusinessSector");
                        return null;
                    }
                    
                    String s = super.processDelete();
                }else{
                    FacesUtil.addFacesErrorMessage("Global.msg.NoRowSelected");
                    return null;
                }
            }
        }
        
        return null;
    }
}
