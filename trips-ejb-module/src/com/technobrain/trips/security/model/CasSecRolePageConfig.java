package com.technobrain.trips.security.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery( name = "CasSecRolePageRel.findAll",query = "select o from CasSecRolePageRel o")
@Table(name = "CAS_SEC_ROLE_PAGE_CONFIG")
public class CasSecRolePageConfig extends BaseNormalModelObject   {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CAS_SEC_ROLE_PAGE_CONFIG_SEQ")
    @SequenceGenerator(name = "CAS_SEC_ROLE_PAGE_CONFIG_SEQ", sequenceName = "CAS_SEC_ROLE_PAGE_CONFIG_SEQ", 
                       allocationSize = 1) 
    @Column(name="ID",nullable = false)
    private Long id;
    
    @Column(name="PAGE_CONFIG")
    private String pageConfig;
    @Column(name="PAGE_MODE")
    private String pageMode;
    
    @ManyToOne
    @JoinColumn(name = "SEC_ROLE_PAGE_REL", referencedColumnName = "ID",nullable = false)
    private CasSecRolePageRel secRolePageRel;
    
    public CasSecRolePageConfig() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPageConfig(String pageConfig) {
        this.pageConfig = pageConfig;
    }

    public String getPageConfig() {
        return pageConfig;
    }

    public void setPageMode(String pageMode) {
        this.pageMode = pageMode;
    }

    public String getPageMode() {
        return pageMode;
    }

    public void setSecRolePageRel(CasSecRolePageRel secRolePageRel) {
        this.secRolePageRel = secRolePageRel;
    }

    public CasSecRolePageRel getSecRolePageRel() {
        return secRolePageRel;
    }
}
