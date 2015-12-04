package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( 
    {
        @NamedQuery(name = "RefDocTypeReturnTypeRel.findAll", query = "select o from RefDocTypeReturnTypeRel o"),
        @NamedQuery(name = "RefDocTypeReturnTypeRel.findByReturnType", 
            query = "select o from RefDocTypeReturnTypeRel o where o.returnType=?1"),
        @NamedQuery(name = "RefDocTypeReturnTypeRel.findByDocType", 
            query = "select o from RefDocTypeReturnTypeRel o where o.docType=?1")
    } 
)
@Table(name = "REF_DOC_TYPE_RET_TYPE_REL")
public class RefDocTypeReturnTypeRel extends BaseRefModelObject   {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name = "RETURN_TYPE")
    private String returnType;
    @Column(name = "DOC_TYPE")
    private String docType;
    
    public RefDocTypeReturnTypeRel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    
    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }
}
