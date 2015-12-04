package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "GuiPageModeVal.findAll", 
    query = "select o from GuiPageModeVal o")
@Table(name = "GUI_PAGE_MODE_VAL")
public class GuiPageModeVal extends BaseNormalModelObject {
   
    @ManyToOne
    @JoinColumn(name = "GUI_PAGE_MODE", referencedColumnName = "ID" )
    private GuiPageMode guiPageMode;
    @Id
    @GeneratedValue(generator = "GuiPageModeValSeq")
    @SequenceGenerator(name = "GuiPageModeValSeq", 
                       sequenceName = "GUI_PAGE_MODE_VAL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String script;
   
    public GuiPageModeVal() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setGuiPageMode(GuiPageMode guiPageMode) {
        this.guiPageMode = guiPageMode;
    }

    public GuiPageMode getGuiPageMode() {
        return guiPageMode;
    }
}
