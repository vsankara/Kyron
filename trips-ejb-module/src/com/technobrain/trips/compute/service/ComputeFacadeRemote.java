package com.technobrain.trips.compute.service;

import com.technobrain.trips.common.exceptions.TripsScriptException;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.RelationshipType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;

import javax.ejb.Remote;

import oracle.rules.rl.exceptions.RLException;
import oracle.rules.sdk.exception.RepositoryException;
import oracle.rules.sdk.exception.RuleSetException;


@Remote
public interface ComputeFacadeRemote {
                                                                                              
    public EntityAccountType generateEntityTIN(EntityAccountType entityAccountType,RelationshipType[] relationships,
                                                    OrganisationTaxpayerInputType variantType) throws RLException, 
                                                                             RuleSetException, 
                                                                             RepositoryException, TripsScriptException;
    public long getSequenceValue(String sequenceName);                                                                             
}
