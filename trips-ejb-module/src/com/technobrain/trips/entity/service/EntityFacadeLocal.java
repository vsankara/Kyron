package com.technobrain.trips.entity.service;

import com.technobrain.trips.application.model.AppEntity;
import com.technobrain.trips.assembler.DataReference;
import com.technobrain.trips.core.service.FacadeLocal;
import com.technobrain.trips.dto.HeaderSummaryDetail;
import com.technobrain.trips.entity.model.EntEntity;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;


@Local
public interface EntityFacadeLocal extends FacadeLocal{
    
    public EntEntity getEntEntity(long entityId);
    
    public HeaderSummaryDetail findHeaderDetails(Long primaryKey);
    
    public Serializable saveOrUpdateOrganisationEntity(OrganisationTaxpayerInputType orgTaxpayerInputType);
    
     public String findRefDescription(String code, DataReference dataReference);
    
    public String getAddressAsCSV(Long id);
    
    public OrganisationTaxpayerInputType findOrganisationTaxpayerInputType(Long entityId);
    
    public List<AppEntity> findAppEntityByEntityIdAndDType(Long entityId, String dType);
 
}
