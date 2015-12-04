package com.technobrain.trips.account.messagehelper;

import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.account.model.RevenueAccount;
import com.technobrain.trips.account.model.SuspenseAccount;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.entityandregimeaccounting.message.AccountType;
import com.technobrain.trips.entityandregimeaccounting.message.RevenueAccountType;
//import com.crownagents.trips.reference.model.RefAccountType;

import java.math.BigDecimal;

/**
 * TechnoBrain 2015
 *
 * Perfroms conversion operations between RevenueAccount, SuspenseAccount,
 * AccountType and RevenueAccountType objects.
 *
 * @since	November 2010
 * @author	j_sweet
 * 
 */
public class AccountTypeMessageHelper extends MessageHelper {

    /**
     * Converts an Account/RevenueAccount object to a 
     * AccountType/RevenueAccountType object.
     * @param entityBean The source for the conversion.
     * @return The result of the conversion.
     */
    public InputType getData(BaseModelObject entityBean) {
        AccountType inputType = null;
        Account account = null;
        if (entityBean instanceof RevenueAccount) {
            inputType = new RevenueAccountType();
            ((RevenueAccountType)inputType).setRevenueType(((RevenueAccount)entityBean).getRevenueType());
            inputType.setTaxAccountType(Constants.AccountTypes.REVENUE);
            account = (RevenueAccount) entityBean;
        } else {
            inputType = new AccountType();
            inputType.setTaxAccountType(Constants.AccountTypes.SUSPENSE);
            account = (Account) entityBean;
        }

        inputType.setId(account.getId());
        inputType.setAccountNumber(account.getAccountNumber());
        inputType.setAccountBalance(account.getBalance());
//        inputType.setAccessLevel(account.getAccessLevel());
//        inputType.setCreatedBy(account.getCreatedBy());
//        inputType.setCreatedDate(DateHelper.getCalendar(account.getCreatedDate()));
//        inputType.setStatus(account.getStatus());
//        inputType.setUpdatedBy(account.getUpdatedBy());
//        inputType.setUpdatedDate(DateHelper.getCalendar(account.getUpdatedDate()));
        setCommonFieldsDataToInputType(account, inputType);
        return inputType;
    }

    /**
     * Converts an AccountType to an Account.
     * @param entityBean The target of the conversion (supplying null results in a new
     * object).
     * @param inputType The source of the conversion.
     * @return The converted DfinPaymentAllocation.
     */
    public BaseModelObject setData(BaseModelObject entityBean, 
                                   InputType inputType) {
        if (inputType instanceof AccountType) {
            return getAccount((Account)entityBean, (AccountType)inputType);
        } else {
            return null;
        }
    }
    
    /**
     * Converts an AccountType/RevenueAccountType object to a 
     * SuspenseAccount/RevenueAccount object.
     * @param from The target of the conversion (supplying null results in a new
     * object).
     * @param to The source of the conversion.
     * @return The result of the conversion.
     */
    public Account getAccount(Account to, AccountType from){
        if(to == null){
            if(from instanceof RevenueAccountType){
                to = new RevenueAccount();
            }else{
                to = new SuspenseAccount();
            }
        }
        
        if(to instanceof RevenueAccount){
            ((RevenueAccount)to).setRevenueType(((RevenueAccountType)from).getRevenueType());
        }
        
        if(from.getId() != null)
            to.setId(from.getId());
        to.setAccountNumber(from.getAccountNumber());
//        RefAccountType accType = new RefAccountType();
//        accType.setCode(from.getTaxAccountType());
        to.setEntId(from.getEntityID());
        if(from.getAccountBalance() == null)
            to.setBalance(new BigDecimal(0));
        else
            to.setBalance(from.getAccountBalance());

          setCommonFieldsFromInputTypeToPojo(to, from);
//        to.setAccessLevel(from.getAccessLevel());
//        to.setCreatedBy(from.getCreatedBy());
//        to.setCreatedDate(DateHelper.getSqlTimestamp(from.getCreatedDate()));
//        to.setStatus(from.getStatus());
//        to.setUpdatedBy(from.getUpdatedBy());
//        to.setUpdatedDate(DateHelper.getSqlTimestamp(from.getUpdatedDate()));

        return to;
    }
}
