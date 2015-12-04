package com.technobrain.trips.script.model;

import com.technobrain.trips.gui.model.GuiPage;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @ Crown Agents 2010
 *
 * Model class representing the table "SCR_GUI_PAGE_VAL". It also represents one 
 * of the usage types for Script Manager 
 * 
 * @since       $Date: $
 * @version     $Revision: $
 * @author      $Author: Uma shankar kathinokkula$
 * 
 */
@Entity
@NamedQuery(name = "ScrGuiPageVal.findAll", 
            query = "select o from ScrGuiPageVal o")
@Table(name = "SCR_GUI_PAGE_VAL")
@DiscriminatorColumn(name = "USAGE_TYPE")
@DiscriminatorValue("PageValidation")
public class ScrGuiPageVal extends ScrCommScript {
    @ManyToOne
    @JoinColumn(name = "GUI_PAGE", referencedColumnName = "CODE", nullable = false)
    private GuiPage guiPage;

    public ScrGuiPageVal() {
    }

    public void setGuiPage(GuiPage guiPage) {
        this.guiPage = guiPage;
    }

    public GuiPage getGuiPage() {
        return guiPage;
    }
}
