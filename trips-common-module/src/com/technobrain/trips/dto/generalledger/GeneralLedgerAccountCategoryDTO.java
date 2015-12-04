package com.technobrain.trips.dto.generalledger;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.ArrayList;
import java.util.List;


public class GeneralLedgerAccountCategoryDTO extends GeneraLedgerAbstractDTO  implements DataTransferObject {
    private String accountCategory;
    private String chartOfAccountsCode;
    private Long id;
    private List<GeneralLedgerAccountSubCategoryDTO> generalLedgerAccountSubCategories;
    
    public GeneralLedgerAccountCategoryDTO() {
        generalLedgerAccountSubCategories = new ArrayList<GeneralLedgerAccountSubCategoryDTO>();
    }

    public GeneralLedgerAccountCategoryDTO(String accountCategory, String chartOfAccounts, Long id, List<GeneralLedgerAccountSubCategoryDTO> generalLedgerAccountSubCategories) {
        this.accountCategory = accountCategory;
        this.chartOfAccountsCode = chartOfAccounts;
        this.id = id;
        this.generalLedgerAccountSubCategories = generalLedgerAccountSubCategories;
    }


    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setChartOfAccountsCode(String chartOfAccountsCode) {
        this.chartOfAccountsCode = chartOfAccountsCode;
    }

    public String getChartOfAccountsCode() {
        return chartOfAccountsCode;
    }

    public void setId(Long id) {
        this.id = id;   
    }

    public Long getId() {
        return id;
    }

    public void setGeneralLedgerAccountSubCategories(List<GeneralLedgerAccountSubCategoryDTO> generalLedgerAccountSubCategoryList) {
        this.generalLedgerAccountSubCategories = generalLedgerAccountSubCategoryList;
    }

    public List<GeneralLedgerAccountSubCategoryDTO> getGeneralLedgerAccountSubCategories() {
        return generalLedgerAccountSubCategories;
    }
}
