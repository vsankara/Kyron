package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "REF_DOC_REV_CODE_PARAM")
public class RefDocRevLedCodeParams extends BaseRefModelObject {

    @Id
    @Column(nullable = false)
    private String code;   
    
    @Column(name = "NON_NULLABLE_EXTRA_PARAMETER" , insertable = false, updatable = false)
    private String comaSeparatedExtraParams;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setComaSeparatedExtraParams(String comaSeparatedExtraParams) {
        this.comaSeparatedExtraParams = comaSeparatedExtraParams;
    }

    public String getComaSeparatedExtraParams() {
        return comaSeparatedExtraParams;
    }
}
