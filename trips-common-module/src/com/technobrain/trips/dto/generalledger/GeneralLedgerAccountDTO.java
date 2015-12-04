package com.technobrain.trips.dto.generalledger;

import com.technobrain.trips.dto.DataTransferObject;

import java.util.Calendar;
import java.util.List;

public class GeneralLedgerAccountDTO extends GeneraLedgerAbstractDTO {
    private String accountType;
    private String subCategoryCode;
    private String department;
    private String description;
    private String[] documentType;
    private String[] taxChargeType;
    private String accountCode;
    private String accessLevel;
    private Long id;
    
    public GeneralLedgerAccountDTO() {
    }

    public GeneralLedgerAccountDTO(String accountType, String code, String department, String description, String[] documentType, String[] taxChargeType, Long id) {
        this.accountType = accountType;
        this.subCategoryCode = code;
        this.description = description;
        this.documentType = documentType;
        this.taxChargeType = taxChargeType;
        this.id = id;
        this.department = department;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDocumentType(String[] documentType) {
        this.documentType = documentType;
    }

    public String[] getDocumentType() {
        return documentType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setTaxChargeType(String[] taxChargeType) {
        this.taxChargeType = taxChargeType;
    }

    public String[] getTaxChargeType() {
        return taxChargeType;
    }
}
