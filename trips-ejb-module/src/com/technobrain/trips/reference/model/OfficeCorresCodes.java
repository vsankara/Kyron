package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

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
@NamedQuery(name = "OfficeCorresCodes.findAll", query = "select o from OfficeCorresCodes o")
@Table(name = "OFFICE_CORRES_CODE")
public class OfficeCorresCodes extends BaseNormalModelObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFICE_CORRES_CODE_SEQ")
    @SequenceGenerator(name = "OFFICE_CORRES_CODE_SEQ", sequenceName = "OFFICE_CORRES_CODE_SEQ", allocationSize = 1)
    private Long id; 
    
    @ManyToOne
    @JoinColumn(name = "OFFICE_CODE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    
    @ManyToOne
    @JoinColumn(name = "CORRES_CODE", referencedColumnName = "CODE")
    private RefCorresCodes refCorres ;

    public OfficeCorresCodes() {
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefCorresCodes getRefCorres() {
        return refCorres;
    }

    public void setRefCorres(RefCorresCodes refCorres) {
        this.refCorres = refCorres;
    }
}
