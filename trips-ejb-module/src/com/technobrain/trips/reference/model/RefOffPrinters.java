package com.technobrain.trips.reference.model;

import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQuery(name = "RefOffPrinters.findAll", 
    query = "select o from RefOffPrinters o")
@Table(name = "REF_OFF_PRINTERS")
public class RefOffPrinters extends BaseNormalModelObject {
    
    @Column(name="ORDER_SEQ")
    private Long orderSeq;
    
    @ManyToOne
    @JoinColumn(name = "REF_OFFICE", referencedColumnName = "CODE")
    private RefOffice refOffice;
    @ManyToOne
    @JoinColumn(name = "REF_PRINTER", referencedColumnName = "CODE")
    private RefPrinter refPrinter;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
    
                    generator = "REF_OFF_PRINTERS_SEQ")
    @SequenceGenerator(name = "REF_OFF_PRINTERS_SEQ", 
                       sequenceName = "REF_OFF_PRINTERS_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    
    @Column(name="DEFAULT_PRINTER")
    private String defaultPrinter;
    
    @Column(name="SECURE_PRINTER")
    private String securePrinter;
    
    @Transient
    private boolean defPrinter;
    
    @Transient 
    private boolean secPrinter;
    
    public RefOffPrinters() {
    }
    
    public Long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Long orderSeq) {
        this.orderSeq = orderSeq;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRefOffice(RefOffice refOffice) {
        this.refOffice = refOffice;
    }

    public RefOffice getRefOffice() {
        return refOffice;
    }

    public void setRefPrinter(RefPrinter refPrinter) {
        this.refPrinter = refPrinter;
    }

    public RefPrinter getRefPrinter() {
        return refPrinter;
    }

    public void setDefaultPrinter(String defaultPrinter) {
        this.defaultPrinter = defaultPrinter;
    }

    public String getDefaultPrinter() {
        return defaultPrinter;
    }

    public void setSecurePrinter(String securePrinter) {
        this.securePrinter = securePrinter;
    }

    public String getSecurePrinter() {
        return securePrinter;
    }

    public void setDefPrinter(boolean defPrinter) {
        this.defPrinter = defPrinter;
    }

    public boolean isDefPrinter() {
        return defPrinter;
    }

    public void setSecPrinter(boolean secPrinter) {
        this.secPrinter = secPrinter;
    }

    public boolean isSecPrinter() {
        return secPrinter;
    }
}
