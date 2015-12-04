package com.technobrain.trips.dto.tax.returns;

import java.math.BigDecimal;

public class CalculatedTaxesChargesDTO {
    private String taxType;
    private String returnType;
    private BigDecimal netPayable;
    private String adjustmentType;
    private Long baseTableId;
    public CalculatedTaxesChargesDTO() {
    }
    public CalculatedTaxesChargesDTO(String taxType,String returnType,BigDecimal netPayable,String adjustmentType) {
        this.taxType=taxType;
        this.returnType=returnType;
        this.netPayable=netPayable;
        this.adjustmentType=adjustmentType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setNetPayable(BigDecimal netPayable) {
        this.netPayable = netPayable;
    }

    public BigDecimal getNetPayable() {
        return netPayable;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public String getAdjustmentType() {
        return adjustmentType;
    }

    public void setBaseTableId(Long baseTableId) {
        this.baseTableId = baseTableId;
    }

    public Long getBaseTableId() {
        return baseTableId;
    }
}
