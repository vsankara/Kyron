package com.technobrain.trips.account.messagehelper;

import com.technobrain.trips.account.model.Account;
import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.account.model.RevenueAccount;
import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.messagehelpers.ComplexAssociationHelper;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SubmissionOutputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.entityandregimeaccounting.message.AccountType;
import com.technobrain.trips.entityandregimeaccounting.message.PeriodType;
import com.technobrain.trips.entityandregimeaccounting.message.RevenueAccountType;

import java.math.BigDecimal;

import java.util.ArrayList;


public class AccountMessageHelper extends MessageHelper {

    /**
     * 
     * @param accountTaxpayer
     * @return
     */
    public InputType getData(BaseModelObject pojo) {
        if(pojo instanceof AccountPeriod) return null;
//        else if(account instanceof RevenueAccount ||
//                accountTaxpayer instanceof AccountTaxpayerEntityType)
            else if(pojo instanceof RevenueAccount)
                return new AccountTypeMessageHelper().getData((Account)pojo);
        else return null;
    }

    /**
     * 
     * @param accountTaxpayer
     * @param inputType
     * @return
     */
    public BaseModelObject setData(BaseModelObject pojo, InputType inputType) {
        if(inputType instanceof AccountType || inputType instanceof RevenueAccountType) 
            return new AccountTypeMessageHelper().setData(pojo, inputType);
        else if(inputType instanceof PeriodType) 
            return setAccountPeriodData(pojo,inputType);
        else return null;
    }

    /**
     * 
     * @param pojo
     * @return
     */
    public OutputType getOutputTypeData(BaseModelObject pojo) {
        OutputType output = new SubmissionOutputType();
        output.setId(((Account) pojo).getId());
        output.setHasErrors(false);
        output.setReturnStatus(Constants.PASS);
        output.setHasWarnings(false);
        return output;
    }
    
    // TODO: Hari caluclate period  end due dates.
    public  AccountPeriod setAccountPeriodData(BaseModelObject pojo, InputType type){
        if (type == null)
            return null;
        AccountPeriod accountPeriod = pojo == null ? new AccountPeriod() : (AccountPeriod)pojo;
        PeriodType periodType = (PeriodType)type;
        setCommonFieldsFromInputTypeToPojo(accountPeriod,periodType);
        accountPeriod.setPeriodNo(periodType.getPeriodNo());
        accountPeriod.setPeriodYear(periodType.getPeriodYear());
        accountPeriod.setPeriodDueDate(DateHelper.getSqlTimestamp(periodType.getReturnDue()));
        accountPeriod.setPeriodStartDate(DateHelper.getSqlTimestamp(periodType.getPeriodStart()));
        accountPeriod.setPeriodEndDate(DateHelper.getSqlTimestamp(periodType.getPeriodEnd()));
        //explicit assignment as period balance is not a part of type        
        accountPeriod.setBalance(new BigDecimal("0.0"));
        accountPeriod.setPeriodDueDate(DateHelper.getSqlTimestamp(periodType.getPaymentDue()));
        accountPeriod.setAccAccountId(periodType.getRegimeAccountId()); 
        accountPeriod.setReturnDocument(periodType.getRevenueReturnType());
        return accountPeriod;
    }

    
}
