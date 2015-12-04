
package com.technobrain.trips.wrapper;

import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;


public class OrganisationTaxpayerInputTypeWrapper implements java.io.Serializable {
    private OrganisationTaxpayerInputType organisationTaxpayerInputType;
    public OrganisationTaxpayerInputTypeWrapper(){}
    public OrganisationTaxpayerInputTypeWrapper(OrganisationTaxpayerInputType organisationTaxpayerInputType){
        this.organisationTaxpayerInputType=organisationTaxpayerInputType;
    }    
    public void setOrganisationTaxpayerInputType(OrganisationTaxpayerInputType organisationTaxpayerInputType) {
        this.organisationTaxpayerInputType = organisationTaxpayerInputType;
    }

    public OrganisationTaxpayerInputType getOrganisationTaxpayerInputType() {
        return organisationTaxpayerInputType;
    }
}
