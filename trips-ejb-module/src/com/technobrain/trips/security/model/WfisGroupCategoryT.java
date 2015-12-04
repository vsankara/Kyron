package com.technobrain.trips.security.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQueries({
    @NamedQuery(name = "WfisGroupCategoryT.findAll", query = "select o from WfisGroupCategoryT o"),
    @NamedQuery(name = "WfisGroupCategoryT.findGroupsByCategory", query = "select o from WfisGroupCategoryT o where o.category=?1 order by o.groupName")
})
@Table(name = "WFIS_GROUP_CATEGORY_T")
public class WfisGroupCategoryT extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "WFIS_GROUP_CATEGORY_T_SEQ")
    @SequenceGenerator(name = "WFIS_GROUP_CATEGORY_T_SEQ", 
                       sequenceName = "WFIS_GROUP_CATEGORY_T_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="GROUP_NAME")
    private String groupName;
    
    private String category;
    
//    @JoinColumn(name = "CATEGORY", referencedColumnName = "CODE", insertable=false,updatable=false)
//    private RefGroupCategory groupCategory;
    
    @Column(nullable = false)
    private String realm;
    
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "REALM", referencedColumnName = "REALM",insertable=false, updatable=false),
    @JoinColumn(name = "GROUP_NAME", referencedColumnName = "NAME",insertable=false, updatable=false)
    })
    private WfisRoleT group;
    
    public WfisGroupCategoryT() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroup(WfisRoleT group) {
        this.group = group;
    }

    public WfisRoleT getGroup() {
        return group;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getRealm() {
        return realm;
    }

//    public void setGroupCategory(RefGroupCategory groupCategory) {
//        this.groupCategory = groupCategory;
//    }
//
//    public RefGroupCategory getGroupCategory() {
//        return groupCategory;
//    }
}
