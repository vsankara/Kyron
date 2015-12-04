package com.technobrain.trips.enforcement.config.messagehelper;

//package com.crownagents.trips.enforcement.config.messagehelper;
//
//import com.crownagents.trips.common.helpers.DateHelper;
//import com.crownagents.trips.common.messagehelpers.ComplexAssociationHelper;
//import com.crownagents.trips.common.messagehelpers.MessageHelper;
////import com.crownagents.trips.core.message.InputType;
//import com.technobrain.trips.core.message.InputType;
//import com.crownagents.trips.core.model.BaseModelObject;
//import com.crownagents.trips.enforcement.config.model.CfgPenaltyRule;
//import com.crownagents.trips.enforcement.config.model.CfgPenaltyRuleTaxType;
//import com.crownagents.trips.enforcement.message.PenaltyRuleConfigInputType;
//import com.crownagents.trips.enforcement.message.PenaltyRuleTaxTypeInputType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PenaltyConfigurationMessageHelper extends MessageHelper{
//    public PenaltyConfigurationMessageHelper() {
//    }
//
//    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
//        if(type == null) return null;
//        CfgPenaltyRule cfgPenaltyRule = pojo==null?new CfgPenaltyRule():(CfgPenaltyRule)pojo;
//        PenaltyRuleConfigInputType penaltyConfigInputType = (PenaltyRuleConfigInputType)type;
//        
//        cfgPenaltyRule.setDescription(penaltyConfigInputType.getDescription());
//        cfgPenaltyRule.setEffectiveDate(DateHelper.getSqlTimestamp(penaltyConfigInputType.getEffectiveDate()));
//        cfgPenaltyRule.setExpiryDate(DateHelper.getSqlTimestamp(penaltyConfigInputType.getExpiryDate()));
//        cfgPenaltyRule.setId(penaltyConfigInputType.getId());
//        cfgPenaltyRule.setLegalReference(penaltyConfigInputType.getLegalReference());
//        cfgPenaltyRule.setMaximumAmount(penaltyConfigInputType.getMaximumAmount());
//        cfgPenaltyRule.setMinimumAmount(penaltyConfigInputType.getMinimumAmount());
//        cfgPenaltyRule.setPenaltyCode(penaltyConfigInputType.getPenaltyCode());
//        cfgPenaltyRule.setPenaltyRuleType(penaltyConfigInputType.getPenaltyRuleType());
//        cfgPenaltyRule.setPenaltyUnitType(penaltyConfigInputType.getPenaltyUnitType());
//        cfgPenaltyRule.setStatus(penaltyConfigInputType.getStatus());
//        setCommonFieldsFromInputTypeToPojo(cfgPenaltyRule,penaltyConfigInputType);
//
//
////        penaltyConfigInputType.getPenaltyRuleTaxType().toArray(new PenaltyRuleTaxTypeInputType[penaltyConfigInputType.getPenaltyRuleTaxType().size()]);
//
//        setAssociationData(cfgPenaltyRule,
//                           penaltyConfigInputType.getPenaltyRuleTaxType().toArray(new PenaltyRuleTaxTypeInputType[penaltyConfigInputType.getPenaltyRuleTaxType().size()]),
//                           cfgPenaltyRule.getPenaltyRuleTaxTypeList(),
//                           getPenaltyRuleTaxTypeAssociationHelper());
//        
//        return cfgPenaltyRule;
//      
//    }
//
//
//    public ComplexAssociationHelper getPenaltyRuleTaxTypeAssociationHelper(){
//        return  new ComplexAssociationHelper(){
//            public void add(BaseModelObject parent, BaseModelObject child){
//                if(((CfgPenaltyRule)parent).getPenaltyRuleTaxTypeList() == null){
//                    ((CfgPenaltyRule)parent).setPenaltyRuleTaxTypeList(new ArrayList<CfgPenaltyRuleTaxType>());
//                }
//                ((CfgPenaltyRule)parent).addCfgPenaltyRuleTaxType((CfgPenaltyRuleTaxType)child);
//            }
//
//            public void remove(BaseModelObject parent,BaseModelObject child){
//                ((CfgPenaltyRule)parent).removeCfgPenaltyRuleTaxType((CfgPenaltyRuleTaxType)child);
//            }
//
//            public Class getChildPojoClass() {
//                return CfgPenaltyRuleTaxType.class;
//            }
//
//            public Class getMessageHelperClass(){
//                return PenaltyConfigurationMessageHelper.class;
//            }
//
//            public void setData( InputType messageChild, BaseModelObject newChildPojo, MessageHelper messageHelper) {
//                ((PenaltyConfigurationMessageHelper)messageHelper).
//                    setPenaltyRuleTaxTypeDataToPojo((PenaltyRuleTaxTypeInputType)messageChild, (CfgPenaltyRuleTaxType)newChildPojo);
//            }
//
//            public Boolean compare(InputType messageChild, BaseModelObject pojo){
//                    if(messageChild.getId() == null || ((CfgPenaltyRuleTaxType)pojo).getId() == null){
//                        return null;//return null because cannot compare, it is an insert operation
//                    }else{
//                        return messageChild.getId().equals(((CfgPenaltyRuleTaxType)pojo).getId());
//                    }
//                }
//            };
//    }
//
//    private CfgPenaltyRuleTaxType setPenaltyRuleTaxTypeDataToPojo(PenaltyRuleTaxTypeInputType penaltyRuleTaxType, 
//                                                       CfgPenaltyRuleTaxType cfgPenaltyRuleTaxType) {
//        cfgPenaltyRuleTaxType.setTaxType(penaltyRuleTaxType.getTaxType());
//        return cfgPenaltyRuleTaxType;
//    }
//                
//    public InputType getData(BaseModelObject pojo) {
//        if(pojo == null) return null;
//        CfgPenaltyRule cfgPenaltyRule = (CfgPenaltyRule)pojo;
//         
//        PenaltyRuleConfigInputType penaltyConfType = null;
//        penaltyConfType = MessageHelper.init(penaltyConfType, PenaltyRuleConfigInputType.class);
//        
//        setCommonFieldsDataToInputType(cfgPenaltyRule, penaltyConfType);
//        
//        penaltyConfType.setDescription(cfgPenaltyRule.getDescription());
//        penaltyConfType.setEffectiveDate(DateHelper.getCalendar(cfgPenaltyRule.getEffectiveDate()));
//        penaltyConfType.setExpiryDate(DateHelper.getCalendar(cfgPenaltyRule.getExpiryDate()));
//        penaltyConfType.setId(cfgPenaltyRule.getId());
//        penaltyConfType.setLegalReference(cfgPenaltyRule.getLegalReference());
//        penaltyConfType.setMaximumAmount(cfgPenaltyRule.getMaximumAmount());
//        penaltyConfType.setMinimumAmount(cfgPenaltyRule.getMinimumAmount());
//        penaltyConfType.setPenaltyCode(cfgPenaltyRule.getPenaltyCode());
//        penaltyConfType.setPenaltyRuleType(cfgPenaltyRule.getPenaltyRuleType());
//        penaltyConfType.setPenaltyUnitType(cfgPenaltyRule.getPenaltyUnitType());
//        penaltyConfType.setStatus(cfgPenaltyRule.getStatus());
//
//        
//        if(cfgPenaltyRule.getPenaltyRuleTaxTypeList() != null){
//            int noOfValidCountry = cfgPenaltyRule.getPenaltyRuleTaxTypeList().size();
//            List<PenaltyRuleTaxTypeInputType> penaltyRuleTaxType = new ArrayList<PenaltyRuleTaxTypeInputType>();
////            PenaltyRuleTaxTypeInputType[noOfValidCountry];
//            
//            
//            for(int i=0;i<noOfValidCountry;i++){
//                penaltyRuleTaxType.add(getPenaltyRuleTaxTypeData(cfgPenaltyRule.getPenaltyRuleTaxTypeList().get(i)));
//            }
//            penaltyConfType.setPenaltyRuleTaxType(penaltyRuleTaxType);
//        }
//        return penaltyConfType;
//
//    }    
//   
//    private PenaltyRuleTaxTypeInputType getPenaltyRuleTaxTypeData(CfgPenaltyRuleTaxType cfgPenaltyRuleTaxType) {
//        PenaltyRuleTaxTypeInputType penaltyRuleInputType = new PenaltyRuleTaxTypeInputType();
//        penaltyRuleInputType.setId(cfgPenaltyRuleTaxType.getId());
//        penaltyRuleInputType.setTaxType(cfgPenaltyRuleTaxType.getTaxType());
//        return penaltyRuleInputType;
//    }
// 
//
//}
