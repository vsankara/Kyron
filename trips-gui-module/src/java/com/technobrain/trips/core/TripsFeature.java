package com.technobrain.trips.core;

//package com.crownagents.trips.core;
//
//import com.crownagents.trips.core.delegate.ReferenceCodeDelegate;
//import com.technobrain.trips.common.constants.Constants.SystemParameterCode;
//import com.technobrain.trips.dto.CodeAndDescription;
//import com.technobrain.trips.gui.model.GuiPage;
//import com.technobrain.trips.security.model.CasDBMenu;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TripsFeature  {
//    static final String A = "key1.properties";
//    static final String B = "key2.properties";
//    static final String C = "key3.properties";
//    
//    static final boolean isDevMode;
//    static TripsFeature tripsFeature = null;
//    
//    static{
//        ReferenceCodeDelegate  refCodeDelegate = new ReferenceCodeDelegate();
//        String result = refCodeDelegate.getSystemParameter(SystemParameterCode.DEV_BUILD);
//        
//        if(result == null || !result.equals("true")){
//            isDevMode = false;
//        }else{
//            isDevMode = true;
//        }
//    }
//    
//    public static TripsFeature getInstance() {
//        if(tripsFeature == null){
//            tripsFeature  =  new TripsFeature();
//        }
//        return tripsFeature;
//    }
//
//    public List<CasDBMenu> enableMenuFeature(List<CasDBMenu> features) {
//        
//        if(isDevMode){
//            return features;
//        }
//        
//        List ks = new FeatureLicence().readAgreement(A);
//        List vf = new ArrayList<CasDBMenu>();
//        for(CasDBMenu obj:features){
//            if(ks.contains( doEncryt(Encryptor.SHA1, obj.getId()) )){
//                vf.add(obj);
//            }else{
//                boolean x = false;
//            }
//        }
//        return vf;
//    }
//    
//    public List<GuiPage> enableGuiConfiguFeature(List<GuiPage> features) {
//        
//        if(isDevMode){
//            return features;
//        }
//        
//        
//        List ks = new FeatureLicence().readAgreement(B);
//        List vf = new ArrayList<CasDBMenu>();
//        for(GuiPage obj:features){
//            if(ks.contains( doEncryt(Encryptor.SHA1, obj.getCode()) )){
//                vf.add(obj);
//            }
//        }
//        return vf;
//    }
//
//    public List<CodeAndDescription> enableTableMgtFeature(List<CodeAndDescription> features) {
//        
//        if(isDevMode){
//            return features;
//        }
//        
//        List ks = new FeatureLicence().readAgreement(C);
//        List vf = new ArrayList<CasDBMenu>();
//        for(CodeAndDescription obj:features){
//            if(ks.contains( doEncryt(Encryptor.SHA1, obj.getCode()) )){
//                vf.add(obj);
//            }
//        }
//        return vf;
//        
//    }
//
//    private Object doEncryt(String encrytType, Object value) {
//        return value;
//    }
//}
