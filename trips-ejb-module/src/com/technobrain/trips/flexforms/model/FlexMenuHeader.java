package com.technobrain.trips.flexforms.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "FlexMenuHeader.findAll", 
    query = "select o from FlexMenuHeader o")
@Table(name = "FLEX_MENU_HEADER")
public class FlexMenuHeader  extends BaseNormalModelObject {
    @Column(name="HEADER_ID")
    private String headerId;
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="ON_CLICK")
    private String onClick;
    @Column(name="ON_MOUSE_OUT")
    private String onMouseOut;
    @Column(name="ON_MOUSE_OVER")
    private String onMouseOver;
    @Column(name="PANEL_FORM_ID")
    private String panelFormId;
    @Column(name="PANEL_MOUSE_OUT")
    private String panelMouseOut;
    @Column(name="PANEL_MOUSE_OVER")
    private String panelMouseOver;
    @Column(name="PANEL_STYLE_CLASS")
    private String panelStyleClass;
    private String rendered;
    @Column(name="STYLE_CLASS")
    private String styleClass;
    private String text;
    @OneToMany(mappedBy = "flexMenuHeader")
    private List<FlexMenuItem> flexMenuItemList;

    public FlexMenuHeader() {
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public String getOnMouseOut() {
        return onMouseOut;
    }

    public void setOnMouseOut(String onMouseOut) {
        this.onMouseOut = onMouseOut;
    }

    public String getOnMouseOver() {
        return onMouseOver;
    }

    public void setOnMouseOver(String onMouseOver) {
        this.onMouseOver = onMouseOver;
    }

    public String getPanelFormId() {
        return panelFormId;
    }

    public void setPanelFormId(String panelFormId) {
        this.panelFormId = panelFormId;
    }

    public String getPanelMouseOut() {
        return panelMouseOut;
    }

    public void setPanelMouseOut(String panelMouseOut) {
        this.panelMouseOut = panelMouseOut;
    }

    public String getPanelMouseOver() {
        return panelMouseOver;
    }

    public void setPanelMouseOver(String panelMouseOver) {
        this.panelMouseOver = panelMouseOver;
    }

    public String getPanelStyleClass() {
        return panelStyleClass;
    }

    public void setPanelStyleClass(String panelStyleClass) {
        this.panelStyleClass = panelStyleClass;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FlexMenuItem> getFlexMenuItemList() {
        return flexMenuItemList;
    }

    public void setFlexMenuItemList(List<FlexMenuItem> flexMenuItemList) {
        this.flexMenuItemList = flexMenuItemList;
    }

    public FlexMenuItem addFlexMenuItem(FlexMenuItem flexMenuItem) {
        getFlexMenuItemList().add(flexMenuItem);
        flexMenuItem.setFlexMenuHeader(this);
        return flexMenuItem;
    }

    public FlexMenuItem removeFlexMenuItem(FlexMenuItem flexMenuItem) {
        getFlexMenuItemList().remove(flexMenuItem);
        flexMenuItem.setFlexMenuHeader(null);
        return flexMenuItem;
    }
}
