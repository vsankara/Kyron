package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "FlexibleParentChildCompRelation.findAll", 
    query = "select o from FlexibleParentChildCompRelation o")
@Table(name = "FLEXIBLE_PARENT_CHILD_REL")
public class FlexibleParentChildCompRelation extends BaseNormalModelObject   {
    @Column(name="PARENT_TYPE")
    private String parentType;
    @Column(name="CHILD_TYPE")
    private String childType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "FLEXIBLE_PARENT_CHILD_REL_SEQ")
    @SequenceGenerator(name = "FLEXIBLE_PARENT_CHILD_REL_SEQ", sequenceName = "FLEXIBLE_PARENT_CHILD_REL_SEQ", 
                       allocationSize = 1)    
    @Column(nullable = false)
    private Long id;
    
    
    public FlexibleParentChildCompRelation(){
    
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentType() {
        return parentType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }

    public String getChildType() {
        return childType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
