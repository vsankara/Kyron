package com.technobrain.trips.dto.generalledger;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class GeneralLedgerAccountSubCategoryDTO extends GeneraLedgerAbstractDTO implements DataTransferObject {
    private Long accountCodeHigh;
    private Long accountCodeLow;
    private Long id;
    private String categoryCode;
    private String subCategoryCode;
    private List<GeneralLedgerAccountDTO> generalLedgerAccounts;
    
    public GeneralLedgerAccountSubCategoryDTO() {
        generalLedgerAccounts = new ArrayList<GeneralLedgerAccountDTO>();
    }

    public GeneralLedgerAccountSubCategoryDTO(Long accountCodeHigh, Long accountCodeLow, Long id, String subCategoryCode, List<GeneralLedgerAccountDTO> generalLedgerAccounts) {
        this.accountCodeHigh = accountCodeHigh;
        this.accountCodeLow = accountCodeLow;
        this.id = id;
        this.subCategoryCode = subCategoryCode;
        this.generalLedgerAccounts = generalLedgerAccounts;
    }

    public void setAccountCodeHigh(Long accountCodeHigh) {
        this.accountCodeHigh = accountCodeHigh;
    }

    public Long getAccountCodeHigh() {
        return accountCodeHigh;
    }

    public void setAccountCodeLow(Long accountCodeLow) {
        this.accountCodeLow = accountCodeLow;
    }

    public Long getAccountCodeLow() {
        return accountCodeLow;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setGeneralLedgerAccounts(List<GeneralLedgerAccountDTO> generalLedgerAccounts) {
        this.generalLedgerAccounts = generalLedgerAccounts;
    }

    public List<GeneralLedgerAccountDTO> getGeneralLedgerAccounts() {
        return generalLedgerAccounts;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }
}
