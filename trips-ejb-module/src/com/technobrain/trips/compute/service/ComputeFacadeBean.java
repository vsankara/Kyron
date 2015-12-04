package com.technobrain.trips.compute.service;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.constants.JndiConstants;
import com.technobrain.trips.common.exceptions.TripsScriptException;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.moduluscheckdigits.CheckDigit;
import com.technobrain.trips.moduluscheckdigits.ModulusCheckDigitFactory;
import com.technobrain.trips.core.message.EntityAccountType;
import com.technobrain.trips.core.message.RelationshipType;
import com.technobrain.trips.registration.message.OrganisationTaxpayerInputType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;

import javax.ejb.Stateless;


import javax.sql.DataSource;

import oracle.rules.rl.exceptions.RLException;
import oracle.rules.sdk.exception.RepositoryException;
import oracle.rules.sdk.exception.RuleSetException;


@Stateless(name="ComputeFacade",mappedName = "ComputeFacade")
public class ComputeFacadeBean extends FacadeBean  implements ComputeFacadeLocal, ComputeFacadeRemote {
    @Resource(name = JndiConstants.DATA_SOURCE_JNDI)
    DataSource ds;

    public ComputeFacadeBean() {
    }

        public EntityAccountType generateEntityTIN(EntityAccountType entityAccountType,RelationshipType[] relationships,
                                OrganisationTaxpayerInputType variantType) throws RLException,
                                                         RuleSetException, 
                                                         RepositoryException, TripsScriptException {
        
        try {
            // TODO - Read the script name from Groovy
            String pattern = "GENERATEID_SEQ";
            String accountNumber = null;
            String tinPrefix = generatePrefixForTIN(variantType);
            Long tin = null;            
            //Get the tin by using sequence from the specified pattern (nothing but from particular sequence table).
            tin = generateNumberForTIN(pattern);
            //Append tin with "0"s up to 9 characters.
            String tinWithPadding = StringHelper.leftPadding(tin.toString(),
                Constants.TinFormate.MAX_PADDING, Constants.TinFormate.PADDING_CHAR);
            //Applying modulus 11 to tinWithPadding.    
            String tinWithCheckDigit = applyCheckDigit(tinWithPadding);
            //Append tinPrefix with tinWithCheckDigit. tinPrefix will vary based on entity type and legal status.
            accountNumber = String.valueOf(tinPrefix + tinWithCheckDigit);
            entityAccountType.setAccountNumber(accountNumber);
            return entityAccountType;
        } catch (NumberFormatException numFormatExp) {
            throw numFormatExp;
        }
    }
    
    private String applyCheckDigit(String id){
        CheckDigit checkDigit = 
            ModulusCheckDigitFactory.getModulusCheckDigitInstance(Constants.MODULUS_11);
        try {
           return id + checkDigit.calculate(id);
        } catch (Exception exp) {
           
        }
        
        return null;
    }
    
        private Long generateNumberForTIN(String sequenceName){
        long id = 0;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = 
                stmt.executeQuery("select " + sequenceName + ".nextval generatedId from dual");
            rs.next();
            id = rs.getLong("generatedId");
            rs.close();
            stmt.close();
        } catch (Exception exp) {
            
        } finally {
            try {
                if(null != con && !con.isClosed()) con.close();
            } catch (Exception eaten) {
                
            }
        }
        
        return id;
    }
    
        private String generatePrefixForTIN(OrganisationTaxpayerInputType variantType) {
        String tinPrefix = Constants.TinFormate.FOR_ALL_OTHERS;
       if (variantType!= null && 
           variantType.getOrganisationDetails() != null) {
            if (!StringHelper.isNullOrEmptyString(variantType.getOrganisationDetails().getLegalStatus())) {
                //for Miscellaneous Entity Types of MDA or MMDA:G
                if (Constants.LegalStatus.MDA.equals(variantType.getOrganisationDetails().getLegalStatus()) || 
                    Constants.LegalStatus.MMDA.equals(variantType.getOrganisationDetails().getLegalStatus())) {
                    tinPrefix = Constants.TinFormate.GOVERNMENT_MDA_MMDA;
                } //for Foreign Missions and their employees:Q
                else if (Constants.LegalStatus.FOREIGN_MISSION.equals(variantType.getOrganisationDetails().getLegalStatus())) {
                    tinPrefix = Constants.TinFormate.FOREIGN_MISSION;
                } //For legal status "LLC", "PARTS", "EXTORG", "SUBS", "CLG", "ULC", "PLLC" prefix should be "C"
//                else if (entityFacadeLocal.isLegalStatusFromRGD(variantType.getOrganisationDetails().getLegalStatus())) {
//                    tinPrefix = Constants.TinFormate.FROM_RGD;
//                }
            } 
        }
        
        return tinPrefix;
    }

    @Override
        public long getSequenceValue(String sequenceName){
        long id = 0;
        Connection con = null;
        try {
            con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = 
                stmt.executeQuery("select " + sequenceName + ".nextval generatedId from dual");
            rs.next();
            id = rs.getLong("generatedId");
        } catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } finally {
            try {
                con.close();
            } catch (Exception eaten) {
                log.error(eaten.getLocalizedMessage(), eaten);
            }
        }
        return id;
    }
   
}
