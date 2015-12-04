package com.technobrain.trips.dto.generalledger;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.ArrayList;
import java.util.List;

public class GeneralLedgerChartOfAccountsDTO extends GeneraLedgerAbstractDTO implements DataTransferObject {
    private String code;
    private String currentAcc;
    private String description;
    private List<GeneralLedgerAccountCategoryDTO> generalLedgerAccountCategoryDTOs;
    
    public GeneralLedgerChartOfAccountsDTO(String code, String currentAcc, String description, List<GeneralLedgerAccountCategoryDTO> generalLedgerAccountCategories) {
        this.code = code;
        this.currentAcc = currentAcc;
        this.description = description;
        this.generalLedgerAccountCategoryDTOs = generalLedgerAccountCategories;
    }

    public GeneralLedgerChartOfAccountsDTO() {
        generalLedgerAccountCategoryDTOs = new ArrayList<GeneralLedgerAccountCategoryDTO>();
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCurrentAcc(String currentAcc) {
        this.currentAcc = currentAcc;
    }

    public String getCurrentAcc() {
        return currentAcc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public List<String> getGeneralLedgerAccountCategoryCodes() {
        List<String> accountCategoryCodes = new ArrayList<String>();
        for (GeneralLedgerAccountCategoryDTO generalLedgerAccountCategoryDTO : getGeneralLedgerAccountCategoryDTOs()) {
            accountCategoryCodes.add(generalLedgerAccountCategoryDTO.getAccountCategory());
        }
        return accountCategoryCodes;
    }

    public void setGeneralLedgerAccountCategoryDTOs(List<GeneralLedgerAccountCategoryDTO> generalLedgerAccountCategoryDTOs) {
        this.generalLedgerAccountCategoryDTOs = generalLedgerAccountCategoryDTOs;
    }

    public List<GeneralLedgerAccountCategoryDTO> getGeneralLedgerAccountCategoryDTOs() {
        return generalLedgerAccountCategoryDTOs;
    }
}
