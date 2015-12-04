package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefDayOfWeek;
import com.technobrain.trips.reference.model.RefEntAttType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EntFormApp.findAll", query = "select o from EntFormApp o")
@Table(name = "ENT_FORM_APP")
public class EntFormApp extends BaseNormalModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_FORM_APP_SEQ")
    @SequenceGenerator(name = "ENT_FORM_APP_SEQ", sequenceName = "ENT_FORM_APP_SEQ", allocationSize = 1)        
    @Column(nullable = false)
    private Long id;
    
    private String code;
    
    private String description;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="ENTFORMAPP_REFENTATT",
        joinColumns={@JoinColumn(name = "FORMAPP_ID",
                referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ENT_ATT_TYPE",
                referencedColumnName = "CODE")}
    )
    private List<RefEntAttType> requiredAttachments = new ArrayList<RefEntAttType>();
    
    public EntFormApp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public RefEntAttType addRequiredAttachments(RefEntAttType entAttType) {
        getRequiredAttachments().add(entAttType);
        return entAttType;
    }

    public void setRequiredAttachments(List<RefEntAttType> requiredAttachments) {
        this.requiredAttachments = requiredAttachments;
    }

    public List<RefEntAttType> getRequiredAttachments() {
        return requiredAttachments;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
