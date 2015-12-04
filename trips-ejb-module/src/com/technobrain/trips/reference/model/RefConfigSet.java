package com.technobrain.trips.reference.model;

//import com.crownagents.trips.core.configuration.model.ConfigSetMode;
import com.technobrain.trips.core.model.BaseRefModelObject;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQueries
({
    @NamedQuery(name = "RefConfigSet.findAll", query = "select o from RefConfigSet o"),
    @NamedQuery(name = "RefConfigSet.findConfigSetByName", query = "select o from RefConfigSet o where o.code = ?1")
})

@Table(name="REF_CONFIG_SET")
public class RefConfigSet extends BaseRefModelObject {
    @Id
    @Column(nullable = false)
    private String code;
    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name = "EXPIRY_DATE")
    private Timestamp expiryDate;
    @Column(name="CONFIG_SET_TYPE")
    private String configSetType;
    @Column(name="DEPENDENT_ON")
    private String dependentOn;
//    @OneToMany(cascade={CascadeType.ALL}, mappedBy = "configSetCode")
//    private List<ConfigSetMode> configSetModeList;

    public  RefConfigSet () {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setConfigSetType(String configSetType) {
        this.configSetType = configSetType;
    }

    public String getConfigSetType() {
        return configSetType;
    }

//    public void setConfigSetModeList(List<ConfigSetMode> configSetModeList) {
//        this.configSetModeList = configSetModeList;
//    }
//
//    public List<ConfigSetMode> getConfigSetModeList() {
//        if(configSetModeList == null)
//            configSetModeList = new ArrayList<ConfigSetMode>();
//        return configSetModeList;
//    }
//    
//    public ConfigSetMode addConfigSetMode(ConfigSetMode configSetMode) {
//        getConfigSetModeList().add(configSetMode);
//        configSetMode.setConfigSetCode(this);
//        return configSetMode;
//    }
//
//    public ConfigSetMode removeConfigSetMode(ConfigSetMode configSetMode) {
//        getConfigSetModeList().remove(configSetMode);
//        return configSetMode;
//    }

    public void setDependentOn(String dependentOn) {
        this.dependentOn = dependentOn;
    }

    public String getDependentOn() {
        return dependentOn;
    }
    
//    // this method will find the actual mode recursively
//    public String getActualMode(String mode){
//        if(getConfigSetModeList() != null){
//            for (ConfigSetMode csMode : getConfigSetModeList() ){
//                if(csMode != null && csMode.getFormModeCode().equals(mode)){
//                    //check if this mode is not extended mode
//                    if(csMode.getModeTypeCode().equalsIgnoreCase("BASIC")){
//                        return csMode.getFormModeCode();
//                    }else{
//                        return getActualMode(csMode.getDependentOn());
//                    }
//                }
//            }
//        }   
//        return null;
//    }

//    // this method will find the actual mode recursively
//    public ConfigSetMode getConfigSetModeForMode(String mode){
//        if(getConfigSetModeList() != null){
//            for (ConfigSetMode csMode : getConfigSetModeList() ){
//                if(csMode != null && csMode.getFormModeCode().equals(mode)){
//                        return csMode;
//                    }
//                }
//            }
//        return null;
//    }
//    
//    // this method will return the actual ConfigSetMode recursively
//    public ConfigSetMode getActualConfigSetMode(String mode){
//        if(getConfigSetModeList() != null){
//            for (ConfigSetMode csMode : getConfigSetModeList() ){
//                if(csMode != null && csMode.getFormModeCode().equals(mode)){
//                    //check if this mode is not extended mode
//                    if(csMode.getModeTypeCode().equalsIgnoreCase("BASIC")){
//                        return csMode;
//                    }else{
//                        return getActualConfigSetMode(csMode.getDependentOn());
//                    }
//                }
//            }
//        }   
//        return null;
//    }  
}

