package com.technobrain.trips.document.model;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;import com.technobrain.trips.core.model.BaseNormalModelObject;
import com.technobrain.trips.core.model.BaseModelObject;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "DdocItemLink.findAll", 
    query = "select o from DdocItemLink o")
@Table(name = "DDOC_ITEM_LINK")
public class DdocItemLink extends BaseNormalModelObject   {
     
     
     
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ddoc_item_link_seq")
    @SequenceGenerator(name = "ddoc_item_link_seq", sequenceName = "ddoc_item_link_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
     
     
     
     
     
     
    @ManyToOne
    @JoinColumn(name = "SOURCE_ITEM", referencedColumnName = "ID")
    private DitemItem ditemItem;
    @ManyToOne
    @JoinColumn(name = "TARGET_ITEM", referencedColumnName = "ID")
    private DitemItem ditemItem1;

    public DdocItemLink() {
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DitemItem getDitemItem() {
        return ditemItem;
    }

    public void setDitemItem(DitemItem ditemItem) {
        this.ditemItem = ditemItem;
    }

    public DitemItem getDitemItem1() {
        return ditemItem1;
    }

    public void setDitemItem1(DitemItem ditemItem1) {
        this.ditemItem1 = ditemItem1;
    }
}
