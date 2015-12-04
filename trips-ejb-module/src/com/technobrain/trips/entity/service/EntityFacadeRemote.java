package com.technobrain.trips.entity.service;

import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.core.service.FacadeRemote;

import com.technobrain.trips.dto.HeaderSummaryDetail;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface EntityFacadeRemote extends FacadeRemote{
    
    public HeaderSummaryDetail findHeaderDetails(Long primaryKey);
    
    public HeaderSummaryDetail findHeaderDetails(String entityType,Long primaryKey);
    
    public OrganisationTaxpayerInputType findOrganisationTaxpayerInputType(Long entityId);
    
    public List<AppEntity> findAppEntityByEntityIdAndDType(Long entityId, String dType);

    
}
