package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class RefLegalStatusEffectiveFeePK implements Serializable {

    
    private String code;
    private Timestamp effectiveDate;
    

    public RefLegalStatusEffectiveFeePK() {
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
