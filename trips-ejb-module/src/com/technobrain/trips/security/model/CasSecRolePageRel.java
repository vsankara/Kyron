package com.technobrain.trips.security.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "CasSecRolePageRel.findAll", 
                             query = "select o from CasSecRolePageRel o")
        , @NamedQuery(name = "CasSecRolePageRel.findByPageURL", 
            query = "select o from CasSecRolePageRel o where o.pageURL=?1")        
        } )
@Table(name = "CAS_SEC_ROLE_PAGE_REL")
public class CasSecRolePageRel extends BaseNormalModelObject   {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "CAS_SEC_ROLE_PAGE_REL_SEQ")
    @SequenceGenerator(name = "CAS_SEC_ROLE_PAGE_REL_SEQ", sequenceName = "CAS_SEC_ROLE_PAGE_REL_SEQ", 
                       allocationSize = 1) 
    @Column(name="ID",nullable = false)
    private Long id;
    @Column(name="PAGE_URL",nullable = false)
    private String pageURL;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="SECURITY_ROLE")
    private String securityRole;
    
    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "secRolePageRel")
    private List<CasSecRolePageConfig> secRolePageConfigList;
    
    public CasSecRolePageRel() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setSecRolePageConfigList(List<CasSecRolePageConfig> secRolePageConfigList) {
        this.secRolePageConfigList = secRolePageConfigList;
    }

    public List<CasSecRolePageConfig> getSecRolePageConfigList() {
        return secRolePageConfigList;
    }
    
    public CasSecRolePageConfig addCasSecRolePageConfig(CasSecRolePageConfig casSecRolePageConfig) {
        casSecRolePageConfig.setSecRolePageRel(this);
        getSecRolePageConfigList().add(casSecRolePageConfig);
        return casSecRolePageConfig;
    }

    public CasSecRolePageConfig removeCasSecRolePageConfig(CasSecRolePageConfig casSecRolePageConfig) {
        getSecRolePageConfigList().remove(casSecRolePageConfig);
        return casSecRolePageConfig;
    }

    public void setSecurityRole(String securityRole) {
        this.securityRole = securityRole;
    }

    public String getSecurityRole() {
        return securityRole;
    }
}
