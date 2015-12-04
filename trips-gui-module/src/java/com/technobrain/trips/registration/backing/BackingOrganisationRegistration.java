/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobrain.trips.registration.backing;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.delegate.ReferenceCodeDelegate;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author vsankara
 */
@Named(value = "backingOrganisationRegistration")
@SessionScoped
public class BackingOrganisationRegistration implements Serializable {

    private List<SelectItem> legalStatusList;
    private OrganisationTaxpayerInputType organisationInputType;
    private final ReferenceCodeDelegate refDelegate;
    private String tradingAs;

    /**
     * Creates a new instance of BackingOrganisationRegistration
     */
    public BackingOrganisationRegistration() {
        refDelegate = new ReferenceCodeDelegate();
        organisationInputType = MessageHelper.init(organisationInputType, OrganisationTaxpayerInputType.class);
    }

    public OrganisationTaxpayerInputType getOrganisationInputType() {
        return organisationInputType;
    }

    public void setOrganisationInputType(OrganisationTaxpayerInputType organisationInputType) {
        this.organisationInputType = organisationInputType;
    }

    public String getTradingAs() {
        return tradingAs;
    }

    public void setTradingAs(String tradingAs) {
        this.tradingAs = tradingAs;
    }

    public void setLegalStatusList(List<SelectItem> legalStatusList) {
        this.legalStatusList = legalStatusList;
    }

    public List<SelectItem> getLegalStatusList() {
        if (legalStatusList == null) {
            legalStatusList = new ArrayList<>();
            legalStatusList = refDelegate.findAllLegalStatusByTaxpayerType(null,
                    Constants.Entity.ORGANISATION_TYPE, Constants.Modes.ADD);
        }
        return legalStatusList;
    }

}
