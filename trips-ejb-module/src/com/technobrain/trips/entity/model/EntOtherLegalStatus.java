package com.technobrain.trips.entity.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.reference.model.RefOffice;

import java.io.Serializable;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@NamedQuery(name = "EntOtherLegalStatus.findAll", query = "select o from EntOtherLegalStatus o")
@Table(name = "ENT_OTHER_LEGAL_STATUS")
@SequenceGenerator(name = "ENT_OTHER_LEGAL_STATUS_SEQ", sequenceName = "ENT_OTHER_LEGAL_STATUS_SEQ", initialValue = 1, allocationSize = 1)
public class EntOtherLegalStatus extends BaseNormalModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENT_OTHER_LEGAL_STATUS_SEQ")
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ENT_ENTITY", referencedColumnName = "ID")
    private EntEntity entEntity;
    
    @OneToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "REF_LEGAL_STATUS", referencedColumnName = "CODE")
    private RefLegalStatusType refLegalStatus;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="EFFECTIVE_DATE")
    private Calendar effectiveDate;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="EXPIRY_DATE")
    private Calendar expiryDate;

    public EntOtherLegalStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntEntity getEntEntity() {
        return entEntity;
    }

    public void setEntEntity(EntEntity entEntity) {
        this.entEntity = entEntity;
    }

    public RefLegalStatusType getRefLegalStatus() {
        return refLegalStatus;
    }

    public void setRefLegalStatusCode(RefLegalStatusType refLegalStatus) {
        this.refLegalStatus = refLegalStatus;
    }

    public Calendar getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }
}
