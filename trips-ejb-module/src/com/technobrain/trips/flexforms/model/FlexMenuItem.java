package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "FlexMenuItem.findAll", 
    query = "select o from FlexMenuItem o")
@Table(name = "FLEX_MENU_ITEM")
public class FlexMenuItem  extends BaseNormalModelObject {
    private String action;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="MENU_ID")
    private String menuId;
    private String rendered;
    private String text;

    @OneToMany(mappedBy = "flexMenuItem")
    private List<FlexMenuActionListner> flexMenuActionListnerList;

    @ManyToOne
    @JoinColumn(name = "MENU_HEADER_ID", referencedColumnName = "ID")
    private FlexMenuHeader flexMenuHeader;

    public FlexMenuItem() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FlexMenuActionListner> getFlexMenuActionListnerList() {
        return flexMenuActionListnerList;
    }

    public void setFlexMenuActionListnerList(List<FlexMenuActionListner> flexMenuActionListnerList) {
        this.flexMenuActionListnerList = flexMenuActionListnerList;
    }

    public FlexMenuActionListner addFlexMenuActionListner(FlexMenuActionListner flexMenuActionListner) {
        getFlexMenuActionListnerList().add(flexMenuActionListner);
        flexMenuActionListner.setFlexMenuItem(this);
        return flexMenuActionListner;
    }

    public FlexMenuActionListner removeFlexMenuActionListner(FlexMenuActionListner flexMenuActionListner) {
        getFlexMenuActionListnerList().remove(flexMenuActionListner);
        flexMenuActionListner.setFlexMenuItem(null);
        return flexMenuActionListner;
    }

    public FlexMenuHeader getFlexMenuHeader() {
        return flexMenuHeader;
    }

    public void setFlexMenuHeader(FlexMenuHeader flexMenuHeader) {
        this.flexMenuHeader = flexMenuHeader;
    }
}
