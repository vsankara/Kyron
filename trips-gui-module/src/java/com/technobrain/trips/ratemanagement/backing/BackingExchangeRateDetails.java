package com.technobrain.trips.ratemanagement.backing;

import com.technobrain.trips.core.onetomanytable.OneBackingBeanToOneTableRow;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.util.FacesUtil;
import com.technobrain.trips.util.WebConstants;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.dto.ratemanagement.ExchangeRateDTO;

import java.math.BigDecimal;

import java.util.Calendar;


/**
 * Backing Bean class for ExchangeRateDetails.jspx pop up. 
 * 
 *@author
 *@version
 *@since   
 * 
 */

@SessionWorker(managedBeanName="backingExchangeRateDetails", 
     stayAlive = "/ratemanagement/ExchangeRateDetails.jspx")
public class BackingExchangeRateDetails extends OneBackingBeanToOneTableRow {

    private ExchangeRateDTO exchangeRateDTO;

    public BackingExchangeRateDetails() {
    
    }

    protected void onPageLoad(int MODE, Object rowData) {
        exchangeRateDTO = 
                    MessageHelper.init(exchangeRateDTO, ExchangeRateDTO.class);
        if (MODE == TABLE_ADD_MODE){
            // do nothing
        } else if (MODE == TABLE_EDIT_MODE || MODE == TABLE_VIEW_MODE) {
            ExchangeRateDTO row = (ExchangeRateDTO)rowData;
            copyProperties(exchangeRateDTO, row);
            String futureRate = (String)FacesUtil.getFromProcessScope(WebConstants.ProcessScopeVariable.FUTURE_RATE_EDIT);
            // Below if loop is to set the values for the fields in the pop up
            if(futureRate.equalsIgnoreCase(Constants.NO)){
                exchangeRateDTO.setEffectiveDate(null);
                exchangeRateDTO.setExchangeRate(null);
            }
        }
    }
    
    protected Object getBeanRepresentedAsRow() {
        return exchangeRateDTO;
    }

    protected boolean isValidProcess(int currentMode) {
        return true;
    }
    
    /**
     * The method is to validate the data from ExchangeRateDetails.jspx pop up.
     * Returns false if there is any validation error.
     * 
     * @param 
     * @return boolean
     */
    private boolean validateExchangeRateDetails() {
        boolean isValid = true;
        if(exchangeRateDTO!=null){
            if(exchangeRateDTO.getExchangeRate()!=null){
              if(exchangeRateDTO.getExchangeRate().compareTo(BigDecimal.ZERO)==0 || exchangeRateDTO.getExchangeRate().compareTo(BigDecimal.ZERO)<0){
                  FacesUtil.addFacesErrorMessage("ExchangeRateDetails.msg.RateShouldBeGreaterThanZero");    
                  isValid = false;
              }
            } else {
                FacesUtil.addFacesErrorMessage("ExchangeRateDetails.msg.RateMandatory");    
                isValid = false;
            }
            if(exchangeRateDTO.getEffectiveDate()==null){
                FacesUtil.addFacesErrorMessage("ExchangeRateDetails.msg.EffectiveFromMandatory");
                isValid = false;
            }
        } else {
            isValid = false;    
        }
        
        return isValid;
    }
    
    /**
     * The method is triggered on click of Ok button from ExchangeRateDetails.jspx pop up.
     * This method is used to set the current time onto the effective date to be used in BackingMaintainExchangeRate.java
     * 
     * @param 
     * @return String
     */
    public String returnFromDialog() {
    
        FacesUtil.removeFromSession("CancelFlow");
        if (isChangesToBeDiscarded()) {
            FacesUtil.storeOnSession("CancelFlow",Constants.YES);
            return super.returnFromDialog();
        }
        if (!validateExchangeRateDetails()) {
            return null;
        }
        // Set the current time information onto the effective date to be read in processReturnFromTableEvent in BackingMaintainExchangeRate
        Calendar cal = Calendar.getInstance();
        exchangeRateDTO.getEffectiveDateCalendar().setTimeInMillis(exchangeRateDTO.getEffectiveDate().getTime());
        exchangeRateDTO.getEffectiveDateCalendar().set(Calendar.HOUR,cal.get(Calendar.HOUR));
        exchangeRateDTO.getEffectiveDateCalendar().set(Calendar.MINUTE,cal.get(Calendar.MINUTE));
        exchangeRateDTO.getEffectiveDateCalendar().set(Calendar.SECOND,cal.get(Calendar.SECOND));
        exchangeRateDTO.getEffectiveDateCalendar().set(Calendar.AM_PM,cal.get(Calendar.AM_PM));
        
        // This is to identify the changed records from the maintenance screen.
        exchangeRateDTO.setValueChanged(true);
        
        return super.returnFromDialog();
            
    }

    public void setExchangeRateDTO(ExchangeRateDTO exchangeRateDTO) {
        this.exchangeRateDTO = exchangeRateDTO;
    }

    public ExchangeRateDTO getExchangeRateDTO() {
        return exchangeRateDTO;
    }
}