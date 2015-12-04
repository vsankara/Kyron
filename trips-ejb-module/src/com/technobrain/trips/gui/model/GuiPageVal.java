package com.technobrain.trips.gui.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

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
@NamedQuery(name = "GuiPageVal.findAll", 
    query = "select o from GuiPageVal o")
@Table(name = "GUI_PAGE_VAL")
public class GuiPageVal extends BaseNormalModelObject {

    @ManyToOne
    @JoinColumn(name = "GUI_PAGE", referencedColumnName = "CODE" )
    private GuiPage guiPage;
    @Id
    @GeneratedValue(generator = "GuiPageValSeq")
    @SequenceGenerator(name = "GuiPageValSeq", 
                       sequenceName = "GUI_PAGE_VAL_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String script;
   
    public GuiPageVal() {
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

    public void setGuiPage(GuiPage guiPage) {
        this.guiPage = guiPage;
    }

    public GuiPage getGuiPage() {
        return guiPage;
    }
}
