package com.technobrain.trips.enforcement.service;

import com.technobrain.trips.account.model.AccountPeriod;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.service.FacadeRemote;
import com.technobrain.trips.enforcement.config.model.CfgPenaltyRule;
import com.technobrain.trips.registration.model.RegTaxpayerStatusView;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface EnforcementFacadeRemote extends FacadeRemote {
    
//    public CfgPenaltyRule processPenaltyRule(PenaltyRuleConfigInputType penaltyRuleInputType);
//    
//    public OutputType processPenalty(PenaltyInputType penaltyInputType);
//    
//    public OutputType savePenalty(PenaltyInputType penaltyInputType);
//
//    public boolean isDuplicatePenaltyRule(PenaltyRuleConfigInputType penaltyRuleIn);
//    
//    public boolean canDeletePenaltyRule(String penaltyCode);
//    
//    public CfgPenaltyRule getActivePenaltyRuleByCode(String penaltyCode);
//    
//    public List<CfgPenaltyRule> findAllPenaltyCodeByTaxTypeAndStatus(String taxType,String status);
//    
//    public AccountPeriod getCurrentAccPeriodByAcctIdAndReturnType(Long acctId,String returnType);
//    
//    public RegTaxpayerStatusView findTaxPayerByTin(String tin);
}
