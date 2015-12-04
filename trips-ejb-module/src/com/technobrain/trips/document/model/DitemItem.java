package com.technobrain.trips.document.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "DitemItem.findAll", query = "select o from DitemItem o")
@Table(name = "DITEM_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@DiscriminatorValue("ITEM")
public class DitemItem extends BaseNormalModelObject   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ditem_item_seq")
    @SequenceGenerator(name = "ditem_item_seq", sequenceName = "ditem_item_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @Column(name="ITEM_REFERENCE")
    private String itemReference;
    private String dtype;
    @OneToMany(mappedBy = "ditemItem",cascade={CascadeType.ALL})
    private List<DdocItemLink> ddocItemLinkList;
    @OneToMany(mappedBy = "ditemItem1",cascade={CascadeType.ALL})
    private List<DdocItemLink> ddocItemLinkList1;
    @OneToMany(mappedBy = "ditemItem",cascade={CascadeType.ALL})
    private List<DtaxItem> dtaxItemList;
    @Column(name="DDOC_DOCUMENT",insertable=false,updatable=false)
    private Long ddocDocument; 

    public DitemItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemReference() {
        return itemReference;
    }

    public void setItemReference(String itemReference) {
        this.itemReference = itemReference;
    }


    public List<DdocItemLink> getDdocItemLinkList() {
        return ddocItemLinkList;
    }

    public void setDdocItemLinkList(List<DdocItemLink> ddocItemLinkList) {
        this.ddocItemLinkList = ddocItemLinkList;
    }

    public DdocItemLink addDdocItemLink(DdocItemLink ddocItemLink) {
        getDdocItemLinkList().add(ddocItemLink);
        ddocItemLink.setDitemItem(this);
        return ddocItemLink;
    }

    public DdocItemLink removeDdocItemLink(DdocItemLink ddocItemLink) {
        getDdocItemLinkList().remove(ddocItemLink);
        ddocItemLink.setDitemItem(null);
        return ddocItemLink;
    }

    public List<DdocItemLink> getDdocItemLinkList1() {
        return ddocItemLinkList1;
    }

    public void setDdocItemLinkList1(List<DdocItemLink> ddocItemLinkList1) {
        this.ddocItemLinkList1 = ddocItemLinkList1;
    }

    public DdocItemLink addDdocItemLink1(DdocItemLink ddocItemLink) {
        getDdocItemLinkList1().add(ddocItemLink);
        ddocItemLink.setDitemItem1(this);
        return ddocItemLink;
    }

    public DdocItemLink removeDdocItemLink1(DdocItemLink ddocItemLink) {
        getDdocItemLinkList1().remove(ddocItemLink);
        ddocItemLink.setDitemItem1(null);
        return ddocItemLink;
    }

    public List<DtaxItem> getDtaxItemList() {
        return dtaxItemList;
    }

    public void setDtaxItemList(List<DtaxItem> dtaxItemList) {
        this.dtaxItemList = dtaxItemList;
    }

    public DtaxItem addDtaxItem(DtaxItem dtaxItem) {
        getDtaxItemList().add(dtaxItem);
        dtaxItem.setDitemItem(this);
        return dtaxItem;
    }

    public DtaxItem removeDtaxItem(DtaxItem dtaxItem) {
        getDtaxItemList().remove(dtaxItem);
        dtaxItem.setDitemItem(null);
        return dtaxItem;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDtype() {
        return dtype;
    }

   
//   public ItemDetailType getData() {
//        ItemDetailType itemDetailType = new ItemDetailType();
//        return itemDetailType;        
//   }

    public void setDdocDocument(Long ddocDocument) {
        this.ddocDocument = ddocDocument;
    }

    public Long getDdocDocument() {
        return ddocDocument;
    }
}
