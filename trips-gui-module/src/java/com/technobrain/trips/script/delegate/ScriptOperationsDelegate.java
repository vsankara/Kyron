package com.technobrain.trips.script.delegate;

//package com.crownagents.trips.script.delegate;
//
//import com.crownagents.trips.common.exceptions.TripsScriptCompilationException;
//import com.crownagents.trips.common.exceptions.TripsScriptRuntimeException;
//import com.crownagents.trips.core.delegate.BusinessDelegate;
//import com.crownagents.trips.core.flexforms.script.JSFScriptFunctions;
//import com.crownagents.trips.core.message.FlexibleFormsInputType;
//import com.crownagents.trips.core.service.FacadeLocal;
//import com.crownagents.trips.flexforms.helper.FlexFormsConstants;
//import com.crownagents.trips.flexforms.model.FlexibleAttribute;
//import com.crownagents.trips.flexforms.model.FlexibleForm;
//import com.crownagents.trips.script.helper.ScriptFunctions;
//import com.crownagents.trips.script.message.ScriptInputType;
//import com.crownagents.trips.script.model.ScrCommScript;
//import com.crownagents.trips.script.model.ScrFlexibleScript;
//import com.crownagents.trips.script.model.ScrGuiPageVal;
//import com.crownagents.trips.util.ExceptionParser;
//
//import groovy.lang.Script;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class ScriptOperationsDelegate extends BusinessDelegate {
//    public ScriptOperationsDelegate() {
//    }
//
//    public Object callScript(ScrCommScript script, Map parametersMap, 
//                             ScriptFunctions functions, 
//                             FlexibleFormsInputType baseType) throws TripsScriptCompilationException, 
//                                                                     TripsScriptRuntimeException {
//        if (parametersMap == null) {
//            parametersMap = new HashMap();
//        }
//        if (functions != null) {
//            parametersMap.put("functions", functions);
//        }
//        if (parametersMap.get("functions") == null) {
//            parametersMap.put("functions", 
//                              new JSFScriptFunctions(getFacadeBeans()));
//        }
//        if (baseType != null) {
//            parametersMap.put("dataObject", baseType);
//        }
//        try {
//            return callScript(script, parametersMap);
//        } catch (Exception ex) {
//            log.error(ex.getLocalizedMessage(), ex);
//            throw new TripsScriptRuntimeException(ex.getMessage(), ex);
//        }
//    }
//
//    public Object callScript(ScrFlexibleScript flexScript, 
//                             Map generalParametersMap) throws TripsScriptCompilationException, 
//                                                              TripsScriptRuntimeException {
//        return getScriptOperationsService().callScript(flexScript, 
//                                                       generalParametersMap);
//    }
//
//    public boolean isScriptValid(FlexibleAttribute attr) {
//        return getScriptOperationsService().isScriptValid(attr);
//    }
//
//    public ScrFlexibleScript getFormScript(FlexibleForm form, String scriptType, 
//                                        String forMode) {
//        return getScriptOperationsService().getFormScript(form, scriptType, forMode);
//    }
//
////    public void emptyCache() {
////        getScriptOperationsService().emptyCache();
////    }
////
////    public void removeFromAllCaches(Long ruleId) {
////        getScriptOperationsService().removeFromAllCaches(ruleId);
////    }
////
////    public void removeFromAllCaches(ScrFlexibleScript rule) {
////        getScriptOperationsService().removeFromAllCaches(rule);
////        ;
////    }
////
////    public Script putScriptIntoCache(ScrFlexibleScript rule) throws TripsScriptCompilationException {
////        return getScriptOperationsService().putScriptIntoCache(rule);
////    }
//
//    public Script compileGroovyToJava(String scriptCode, 
//                                      String className) throws TripsScriptCompilationException {
//        return getScriptOperationsService().compileGroovyToJava(scriptCode, 
//                                                                className);
//    }
//
//    public void validateSyntax(String scriptCode) throws TripsScriptCompilationException {
//        getScriptOperationsService().validateSyntax(scriptCode);
//    }
//
////    public Class createClassFromClassData(ScrFlexibleScript rule) {
////        //return getScriptOperationsService().createClassFromClassData(rule);
////    }
//
//    public boolean isScriptInCache(ScrFlexibleScript rule) {
//        return getScriptOperationsService().isScriptInCache(rule);
//    }
//
//    public ScrFlexibleScript getFormValidationScript(FlexibleForm form, 
//                                                  String forMode) {
//        return getFormScript(form, 
//                             FlexFormsConstants.FlexFormAttributeNames.FORM_VALIDATION, 
//                             forMode);
//    }
//
//    public ScrFlexibleScript getFormSaveScript(FlexibleForm form, 
//                                            String forMode) {
//        return getFormScript(form, 
//                             FlexFormsConstants.FlexFormAttributeNames.FORM_SAVE, 
//                             forMode);
//    }
//
//    public ScrFlexibleScript getFormInitScript(FlexibleForm form, 
//                                            String forMode) {
//        return getFormScript(form, 
//                             FlexFormsConstants.FlexFormAttributeNames.FORM_INIT, 
//                             forMode);
//    }
//
////    public boolean saveScriptAndPutToCache(FlexibleScript script) throws TripsScriptCompilationException {
////        return saveScriptAndPutToCache(script);
////    }
//
//    public List<ScrCommScript> findAllScripts() {
//        return getScriptOperationsService().findAllScripts();
//    }
//
//    public ScrFlexibleScript saveScript(ScrFlexibleScript script) {
//        return (ScrFlexibleScript)getScriptOperationsService().saveOrUpdateScript(script);
//    }
//
//    public Map<String, FacadeLocal> getFacadeBeans() {
//        return getScriptOperationsService().getFacadeBeans();
//
//        //        Map<String, FacadeLocal> beans = new HashMap<String, FacadeLocal>();
//        //        beans.put("entityFacade", getEntityService());
//        //        beans.put("scriptFacade", getScriptOperationsService());
//        //        beans.put("flexFormFacade", getFlexibleFormsService());
//        //        beans.put("refCodeFacade", getRefCodeAssemblerService());
//        //        beans.put("returnService", getReturnService());
//        //        return beans;
//    }
//
//    public void parseErrorMessageToGUI(Object message, String label, 
//                                       Exception e) {
//        ExceptionParser.parseScriptErrorMessageToGUI(message, label, e);
//    }
//
//    /**
//     * Get class names for the facade beans that are to be exposed in the Script Manager
//     * 
//     * @return a Map of keys to fully qualified class names 
//     */
//    public Map<String, String> getFacadeBeanNames() {
//        return getScriptOperationsService().getFacadeBeanNames();
//    }
//
//    public Object callScript(ScrCommScript script, 
//                             Map generalParametersMap) throws TripsScriptCompilationException, 
//                                                              TripsScriptRuntimeException {
//        return getScriptOperationsService().callScript(script, 
//                                                       generalParametersMap);
//    }
//    
//    /**
//     * Delegate method for compiling and performing CRUD operations on a ScriptManager.
//     *  
//     *  @param scriptInputType
//     *  @return ScrCommScript
//     */
//    public ScrCommScript compileAndSaveScriptData(ScriptInputType scriptInputType) throws TripsScriptCompilationException{
//        return getScriptOperationsService().compileAndSaveScriptData(scriptInputType);
//    }
//
//    /**
//     *  This method delegate a method call to FacadeBean
//     *  
//     *  @param scriptInputType
//     *  @return boolean
//     */
//    public boolean duplicateScriptNameCheck(ScriptInputType scriptInputType) {
//        return getScriptOperationsService().duplicateScriptNameCheck(scriptInputType);
//    }
//
//    /**
//     *  This method delegate a method call to FacadeBean
//     *  
//     *  @param id
//     *  @return ScriptInputType
//     */
//    public ScriptInputType findScriptInputType(Long id) {
//        return getScriptOperationsService().findScriptInputType(id);
//    }
//
//    /**
//     *  This method delegate a method call to FacadeBean
//     *  Takes a return value from facade bean, if script data exist returns script data , otherwise returns null.
//     *  
//     *  @param searchId
//     *  @return String
//     */
//    public ScrCommScript loadDataByScriptId(Long searchId) {
//        return getScriptOperationsService().loadDataByScriptId(searchId);
//    }
//    
//
//    
//    /**
//     * This method will return all active records based on code.
//     * @param code guipage code
//     * @return List of active ScrGuiPageVal objects.
//     */
//    public List<ScrGuiPageVal> getActiveScriptsByGuiPageCode(String code) {
//        return getScriptOperationsService().findActiveScriptsByGuiPageCode(code);
//    }
//    
//    /**
//     * Deletes the script identified by the ID.
//     */
//    public void deleteScript(Long id) {
//        getScriptOperationsService().deleteScript(id);
//    }
//}
