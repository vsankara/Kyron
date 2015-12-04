package com.technobrain.trips.ratemanagement.backing;

import com.technobrain.trips.core.onetomanytable.GenericSingleSelectionTableHandler;
import com.technobrain.trips.core.onetomanytable.OneBackingBeanToManyTables;
import com.technobrain.trips.core.onetomanytable.OneBackingBeanToOneTableRow;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.ratemanagement.delegate.RateManagementDelegate;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.CopyHelper;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;


/**
 * Backing Bean class for ExchangeRateMaintainenance.jspx.
 *
 *@author
 *@version
 *@since
 *
 */

@SessionWorker(
     managedBeanName="backingMaintainExchangeRate", 
     stayAlive = "/ratemanagement/ExchangeRateMaintenance.jspx,/ratemanagement/ExchangeRateDetails.jspx"
 )
public class BackingMaintainExchangeRate extends OneBackingBeanToManyTables{
    
    private RateManagementDelegate rateManagementDelegate;
    private ExchangeRateDTO exchangeRateDTO = null;
    private GenericSingleSelectionTableHandler exchangeRateTable;
    private boolean displaySelectedExchangeRateTable;
    private String selectedExchangeRateDescription;
    private List<ExchangeRateDTO> selectedExchangeRateHistory;
    private List<ExchangeRateDTO> expiredExchangeRates;

    
    public BackingMaintainExchangeRate() {
        rateManagementDelegate = 
                rateManagementDelegate == null ? new RateManagementDelegate() : rateManagementDelegate;
        List<ExchangeRateDTO> exchangeRates = rateManagementDelegate.findAllUnexpiredExchangeRates();
        exchangeRateTable = new GenericSingleSelectionTableHandler(exchangeRates);
        expiredExchangeRates = new ArrayList<ExchangeRateDTO>();
    }

    public void setExchangeRateTable(GenericSingleSelectionTableHandler exchangeRateTable) {
        this.exchangeRateTable = exchangeRateTable;
    }

    public GenericSingleSelectionTableHandler getExchangeRateTable() {
        return exchangeRateTable;
    }
    
    protected boolean setUpValidateOnSubmission() {
        return true;
    }
    
    
    /**
     * The method is triggred on selection of a record in the Exchange Rate table.
     * This is used to render the exchange rate history table of the selected currency.
     * 
     * @param selectionEvent
     * @return void
     */
//    public void rateSelectionListener(SelectionEvent selectionEvent) {
//        DataTable table = (DataTable)selectionEvent.getComponent();
//        ExchangeRateDTO selectedExchangeRateDTO = (ExchangeRateDTO)table.getSelection();
//        displaySelectedExchangeRateTable= true;
//        selectedExchangeRateDescription = selectedExchangeRateDTO.getCurrencyDescription()+" ("+selectedExchangeRateDTO.getCurrencyCode()+")";
//        selectedExchangeRateHistory = rateManagementDelegate.findAllExchangeRatesByCurrency(selectedExchangeRateDTO.getCurrencyCode());
//
//        FacesUtil.getFacesContext().renderResponse();
//    }
    
    /**
     * The method is triggred on while returning back from ExchangeRateDetails.jspx pop up.
     * This is used to set the expiry date of the current exchange rate of the selected Currency.
     * 
     * @param evt
     * @return void
     */
    public void processReturnFromTableEvent(SelectEvent evt) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExchangeRateDTO exchangeRateDTOFromPopUp = (ExchangeRateDTO)evt.getObject();
        ExchangeRateDTO selectedExchangeRateDTO = null;
        boolean isFutureRate = false;
        boolean isCancelFlow = FacesUtil.getFromSession("CancelFlow")==null?false:true;
        Calendar cal = Calendar.getInstance();
        
        if(isCancelFlow){
            return;
        } else {
            evt.getComponent();
            GenericSingleSelectionTableHandler handler = 
                (GenericSingleSelectionTableHandler)ctx.getExternalContext().getSessionMap().get(OneBackingBeanToOneTableRow.TABLE_HANDLER_KEY);
            if(handler.getRowToUpdate()!=null){
                selectedExchangeRateDTO = (ExchangeRateDTO)handler.getRowToUpdate();
            }
                
            // For New Record Processing
            if(selectedExchangeRateDTO!=null && selectedExchangeRateDTO.getExchangeRate()==null){
                if(DateHelper.compareDates(exchangeRateDTOFromPopUp.getEffectiveDateCalendar(),Calendar.getInstance())==0){
                    // do nothing, leave the effective start time as the current time
                } else if(DateHelper.compareDates(exchangeRateDTOFromPopUp.getEffectiveDateCalendar(),Calendar.getInstance())>0){
                    // set the time of future effecive date as 00:00:00
                    exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.HOUR,0);
                    exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.MINUTE,0);
                    exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.SECOND,0);
                    exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.AM_PM,Calendar.AM);
                }
            } else if(selectedExchangeRateDTO!=null && selectedExchangeRateDTO.getExchangeRate()!=null){
                 // For Current Rate Record Processing
                 if(DateHelper.compareDates(exchangeRateDTOFromPopUp.getEffectiveDateCalendar(),Calendar.getInstance())==0){
                     // This should be a considered as an expiry date to be added to the index 0
                     isFutureRate=false;
                 } else if(DateHelper.compareDates(exchangeRateDTOFromPopUp.getEffectiveDateCalendar(),Calendar.getInstance())>0){
                     // For Future Rate Record Processing, set the time of future effecive date as 00:00:00
                     exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.HOUR,0);
                     exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.MINUTE,0);
                     exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.SECOND,0);
                     exchangeRateDTOFromPopUp.getEffectiveDateCalendar().set(Calendar.AM_PM,Calendar.AM);
                     isFutureRate=false;
                 } else {
                     // Do nothing
                 }
                  // This should be a considered as an expiry date to be added to the index 1
                   if (DateHelper.compareDates(selectedExchangeRateDTO.getEffectiveDateCalendar(),Calendar.getInstance()) > 0 || selectedExchangeRateDTO.isValueChanged()) {
                     isFutureRate=true;
                   }
                 // Set the expiry date onto the latest active record on the Database as 1 second earlier than the effective time
                   cal.setTime(exchangeRateDTOFromPopUp.getEffectiveDateCalendar().getTime());
                   cal.add(Calendar.SECOND,-1);
                   setExchangeRateExpiry(selectedExchangeRateDTO,cal,isFutureRate);
             }
             else {
                 // do nothing
             }
             if(!isFutureRate){
                 // To create a new record in the table
                 exchangeRateDTOFromPopUp.setExchangeRateId(null);
             }
            super.processReturnFromTableEvent(evt);
        }
    }
    
    /**
     * This is used to find out if the selected Currency is already added to expiry dates list.
     * 
     * @param currencyCode
     * @return boolean
     */
    private boolean expiryDateAlreadyAddedForCurrency(String currencyCode){
        if(expiredExchangeRates!=null && expiredExchangeRates.size()>0){
            for(ExchangeRateDTO expiredExchangeRateDTO : expiredExchangeRates){
                if(currencyCode.equalsIgnoreCase(expiredExchangeRateDTO.getCurrencyCode())){
                    return true;
                }
            }    
        }
        return false;
    }
    
    /**
     * This is used to set the expiry date of the current exchange rate of the selected Currency.
     * Build a new exchange rate dto object and add it to the expired exchange rates list.
     * @param selectedExchangeRateDTO, expiryDate, isFutureRate
     * @return void
     */
    private void setExchangeRateExpiry(ExchangeRateDTO selectedExchangeRateDTO, Calendar expiryDate, boolean isFutureRate){
        if(selectedExchangeRateHistory!=null && selectedExchangeRateHistory.size()>0){
            // If loop to handle future rate edit and set the expiry date on the latest record with expiry date
            if (selectedExchangeRateHistory.size() > 1 && isFutureRate && 
                !expiryDateAlreadyAddedForCurrency(selectedExchangeRateDTO.getCurrencyCode())) {
            	ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
                ExchangeRateDTO historyToUpdate = 
                    CopyHelper.deepCopy(selectedExchangeRateHistory.get(1));
                exchangeRateDTO = historyToUpdate;
                exchangeRateDTO.setExpiryDateCalendar(expiryDate);
                exchangeRateDTO.setValueChanged(true);
                expiredExchangeRates.add(exchangeRateDTO);
            }
            // Else If loop to handle current rate edit and set the expiry date on the latest record with no expiry date
            else if (selectedExchangeRateHistory.size()>0 && !isFutureRate && 
                !expiryDateAlreadyAddedForCurrency(selectedExchangeRateDTO.getCurrencyCode())){
            	ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
                ExchangeRateDTO historyToUpdate = CopyHelper.deepCopy(selectedExchangeRateHistory.get(0));
                exchangeRateDTO = historyToUpdate;
                exchangeRateDTO.setExpiryDateCalendar(expiryDate);
                exchangeRateDTO.setValueChanged(true);
                expiredExchangeRates.add(exchangeRateDTO);
            }else{
             //do nothing   
            }
            
            if(expiredExchangeRates!=null && expiredExchangeRates.size()>0){
                for(ExchangeRateDTO expiredExchangeRateDTO : expiredExchangeRates){
                    if(selectedExchangeRateDTO.getCurrencyCode().equalsIgnoreCase(expiredExchangeRateDTO.getCurrencyCode())){
                        expiredExchangeRateDTO.setExpiryDateCalendar(expiryDate);
                        break;
                    }
                }
            }
        }
  }

    /**
     * This method is used to set where the selected record should be edited 
     * or a new record should be added. If a rate with effective date in future is selected, 
     * then it should be an edit mode for other cases it should be in add mode.
     * 
     * @param actionEvent
     * @return void
     */

    public void rateListener(ActionEvent actionEvent) {
        ExchangeRateDTO selectedExchangeRateDTO = null;
        if (exchangeRateTable != null && 
            exchangeRateTable.getRowToUpdate() != null) {
            selectedExchangeRateDTO = 
                    (ExchangeRateDTO)exchangeRateTable.getRowToUpdate();
            if (selectedExchangeRateDTO.getEffectiveDate()!=null && 
                DateHelper.compareDates(selectedExchangeRateDTO.getEffectiveDateCalendar(), 
                                        Calendar.getInstance()) > 0) {
                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.FUTURE_RATE_EDIT, Constants.YES);
            } else if (selectedExchangeRateDTO.isValueChanged()){
                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.FUTURE_RATE_EDIT, Constants.YES);
            } else {
                FacesUtil.storeOnProcessScope(WebConstants.ProcessScopeVariable.FUTURE_RATE_EDIT, Constants.NO);
            }
            
            launchEditDialog(actionEvent);
        }
    }

    /**
     * This method is invoked on click of save button from ExchangeRateMaintenance.jspx file. 
     * 
     * @param
     * @return void
     */
    public String processMaintainExchangeRate() {
        if(!validateMaintainExchangeRate()){
            return null;
        }else{
            try {
                List<ExchangeRateDTO> exchangeRatesToProcess = (List<ExchangeRateDTO>)exchangeRateTable.getDataAsList();
                if(expiredExchangeRates.size()>0){
                    for(ExchangeRateDTO exchangeRateDTO : expiredExchangeRates){
                        exchangeRatesToProcess.add(exchangeRateDTO);
                    }    
                }
                rateManagementDelegate.processExchangeRateMaintenance(exchangeRatesToProcess);
                FacesUtil.addFacesInfoMessage(WebConstants.Messages.CONFIRMATION, 
                                              "MaintainExchangeRate.ExchangeRate", 
                                              "Global.message.RecordSaved");
                return WebConstants.Navigation.HOME;
            }catch(Exception ex){
                FacesUtil.addFacesErrorMessage(WebConstants.Messages.GENERIC_ERROR, 
                                              "MaintainExchangeRate.ExchangeRate", 
                                              "MaintainExchangeRate.msg.SaveFailed");
                ex.printStackTrace();
               log.error(ex.getLocalizedMessage(), ex);
               return WebConstants.Navigation.SELF;
            }        
        }        
    }
    
    /**
     * This method is invoked on click of save button from ExchangeRateMaintenance.jspx file.
     * This is used to perform validations on this page.
     * 
     * @param
     * @return boolean
     */
    private boolean validateMaintainExchangeRate() {
        boolean isValid = true;
        if(exchangeRateTable.getDataAsList()==null ||
        (exchangeRateTable!=null && exchangeRateTable.getDataAsList()!=null && exchangeRateTable.getDataAsList().size()==0)){
            FacesUtil.addFacesErrorMessage("Global.message.NoDataToBeSaved");    
            isValid = false;
        }
        return isValid;
    }


    public void setDisplaySelectedExchangeRateTable(boolean displaySelectedExchangeRateTable) {
        this.displaySelectedExchangeRateTable = displaySelectedExchangeRateTable;
    }

    public boolean isDisplaySelectedExchangeRateTable() {
        return displaySelectedExchangeRateTable;
    }

    public void setExchangeRateDTO(ExchangeRateDTO exchangeRateDTO) {
        this.exchangeRateDTO = exchangeRateDTO;
    }

    public ExchangeRateDTO getExchangeRateDTO() {
        return exchangeRateDTO;
    }

    public void setSelectedExchangeRateDescription(String selectedExchangeRateDescription) {
        this.selectedExchangeRateDescription = selectedExchangeRateDescription;
    }

    public String getSelectedExchangeRateDescription() {
        return selectedExchangeRateDescription;
    }

    public void setSelectedExchangeRateHistory(List<ExchangeRateDTO> selectedExchangeRateHistory) {
        this.selectedExchangeRateHistory = selectedExchangeRateHistory;
    }

    public List<ExchangeRateDTO> getSelectedExchangeRateHistory() {
        return selectedExchangeRateHistory;
    }

    public void setExpiredExchangeRates(List<ExchangeRateDTO> expiredExchangeRates) {
        this.expiredExchangeRates = expiredExchangeRates;
    }

    public List<ExchangeRateDTO> getExpiredExchangeRates() {
       return expiredExchangeRates;
    }
}
