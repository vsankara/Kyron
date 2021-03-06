package com.technobrain.trips.registration.service;

import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.registration.model.RegTaxpayerStatusView;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.reference.model.RefLegalStatusType;
import com.technobrain.trips.registration.message.AccountOutputType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

@Local
public interface RegTaxpayerFacadeLocal extends FacadeLocal {

    public RegTaxpayerStatusView findTaxpayerAccountByEntity(Long entityId);

    public List<RegTaxpayerStatusView> findAccountNumberByEntityAndRevenueType(Long entityId, String revenueType);

    public AccountOutputType registerAccountEntity(InputType inputType, String workflowType);

    public OutputType updateTaxpayerAccountId(Long taxpayerAccoutnId, Long registrationId);

    public void updateAccountIdInDocument(Long accountId, Long documentId);
    
    public ArrayList<SystemMessage> validateRGDMandatoryFields(OrganisationTaxpayerInputType orgRegMsg);
    
    public RefLegalStatusType isRGDRegisterRequired(String legalStatus);
}
