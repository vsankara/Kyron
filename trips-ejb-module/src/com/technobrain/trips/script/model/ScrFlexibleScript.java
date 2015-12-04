package com.technobrain.trips.script.model;

import com.technobrain.trips.flexforms.model.FlexibleFormType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

 /**
  * @ Crown Agents 2010
  *
  * Model class representing the table "SCR_FLEXIBLE_SCRIPT". It also represents one 
  * of the usage types for Script Manager
  * 
  * @since       $Date: $
  * @version     $Revision: $
  * @author      $Author: Uma shankar kathinokkula$
  * 
  */
@Entity
@NamedQuery(name = "ScrFlexibleScript.findAll", 
    query = "select o from ScrFlexibleScript o")
@Table(name = "SCR_FLEXIBLE_SCRIPT")
@DiscriminatorColumn(name="USAGE_TYPE")
@DiscriminatorValue("FlexibleForms")
public class ScrFlexibleScript extends ScrCommScript   {
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "FORM_TYPE_ID", referencedColumnName = "ID", updatable=false, insertable=false)
    private FlexibleFormType formType;    
    @Column(name="FORM_TYPE_ID", nullable = false)
    private Long formTypeId;

    public ScrFlexibleScript() {
    }

    public void setFormType(FlexibleFormType formType) {
        this.formType = formType;
    }

    public FlexibleFormType getFormType() {
        return formType;
    }

    public void setFormTypeId(Long formTypeId) {
        this.formTypeId = formTypeId;
    }

    public Long getFormTypeId() {
        return formTypeId;
    }
}

