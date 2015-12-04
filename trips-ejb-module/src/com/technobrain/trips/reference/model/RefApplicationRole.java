package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQueries({
    @NamedQuery(name = "RefApplicationRole.findAll", query = "select o from RefApplicationRole o"),
    @NamedQuery(
    name="RefApplicationRole.findAllApplicationRoleByRoleType",
    query="select new com.technobrain.trips.dto.CodeAndDescription(o.code,o.description) from RefApplicationRole o where o.roleType = ?1"
    )
})
@Table(name = "REF_APPLICATION_ROLE")
public class RefApplicationRole extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;

    private String description;
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="ROLE_TYPE")
    private String roleType;

    public RefApplicationRole() {
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

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
