package com.technobrain.trips.common.helpers.search;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.common.helpers.xml.ConfigurationHelper;
import com.technobrain.trips.common.helpers.xml.XMLAccessException;
import com.technobrain.trips.dto.CodeAndDescription;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.apache.log4j.Logger;

public class SearchConfigResourceGenerator {
    static final Logger log = Logger.getLogger(SearchConfigResourceGenerator.class);

    private static final String searchFilename = "search.config.xml";
    private static HashMap searchParams = new HashMap();
    private StringBuffer sbToPrint = new StringBuffer();

    private static final String FILENAME = 
        "Q:\\TRIPS2\\Dev\\Java\\Projects\\trips-common\\SearchConfig_UIResources.properties";

    
    public static SearchInfo getSearchInfo(String searchId) {
        return (SearchInfo)searchParams.get(searchId);
    }
        
    private void loadSearchConfig(String passed_id) {
        try {
            ConfigurationHelper configurationHelper;
            configurationHelper = new ConfigurationHelper();
            InputStream searchFilenameStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream(searchFilename); 
            configurationHelper.createDom(searchFilenameStream);
            
            int eachEntry = 1;
            while (eachEntry > 0) {
                configurationHelper.setPath("/searchList/search[" + 
                                            String.valueOf(eachEntry) + "]");
                if (configurationHelper.pathExists()) {
                    String id = configurationHelper.getElement("id");

                    if((id != null && passed_id != null && !passed_id.equals(id)) && (passed_id != null && !passed_id.equals(""))){
                        eachEntry++;
                        continue;                    
                    }
                    showPrint("\n\n#---SearchConfig."+id);                    
                    showPrint("SearchConfig."+id+".SectionHeading="+configurationHelper.getElement("sectionHeading"));
                    showPrint("SearchConfig."+id+".WindowHeading="+configurationHelper.getElement("windowHeading"));
                    
                    if(configurationHelper.getElement("advancedSectionHeading") != null)
                        showPrint("SearchConfig."+id+".AdvancedSectionHeading="+configurationHelper.getElement("advancedSectionHeading"));

                    String advancedSearchAvailable = 
                        configurationHelper.getElement("advancedSearchAvailable");
                    String multiAdvancedSearchAvailable = 
                        configurationHelper.getElement("multiAdvancedSearchAvailable");
                        
                    multiAdvancedSearchAvailable = multiAdvancedSearchAvailable==null?"N":multiAdvancedSearchAvailable;

                    if(multiAdvancedSearchAvailable.equalsIgnoreCase("Y") || multiAdvancedSearchAvailable.equalsIgnoreCase("YES")
                             || multiAdvancedSearchAvailable.equalsIgnoreCase("Basic") || multiAdvancedSearchAvailable.equalsIgnoreCase("SPOTLIGHT") ){
                        ArrayList multiSearchAttributeList = new ArrayList();
                        getMultiAdvancedCriteriaFieldList(eachEntry, configurationHelper, multiSearchAttributeList, id);   
                        getMultiResultFields(eachEntry, configurationHelper, id);   
                        getResultFieldList(eachEntry, configurationHelper, id);                           
                        if(multiSearchAttributeList != null && multiSearchAttributeList.size() > 0){
//                                multiSearchAttributeList;
                        }

                        TreeMap seMap = new TreeMap();
                        seMap = getCriteriaFieldList(eachEntry, configurationHelper,id);
                    }else{
                        getCriteriaFieldList(eachEntry, configurationHelper,id);
                        getAdvancedCriteriaFieldList(eachEntry, configurationHelper, id);                    
                        getResultFieldList(eachEntry, configurationHelper, id);                                                                        
                    }
                    getActions(eachEntry, configurationHelper);
                    eachEntry++;
                } else {
                    eachEntry = -1;
                }
            }
            writeToFile();
        } catch (XMLAccessException exp) {
            log.error(exp.getLocalizedMessage(), exp);
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (NoSuchFieldException nsfe) {
            log.error(nsfe.getLocalizedMessage(), nsfe);
        } catch (ClassNotFoundException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
    
    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private TreeMap getCriteriaFieldList(int eachEntry, 
                                                ConfigurationHelper configurationHelper, String searchFieldId) throws XMLAccessException, 
                                                                                                ClassNotFoundException, 
                                                                                                NoSuchFieldException, 
                                                                                                IllegalAccessException {

        String path = "/searchList/search[" + String.valueOf(eachEntry) + 
                                                "]/criteriaFields" ;
        TreeMap criteriaFields = getCriteriaFieldListByPath(path, eachEntry, configurationHelper, "", searchFieldId);
        return criteriaFields;        
     }

    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private TreeMap getAdvancedCriteriaFieldList(int eachEntry, 
                                                ConfigurationHelper configurationHelper, String searchFieldId) throws XMLAccessException, 
                                                                                                ClassNotFoundException, 
                                                                                                NoSuchFieldException, 
                                                                                                IllegalAccessException {

        String path = "/searchList/search[" + String.valueOf(eachEntry) + 
                                                "]/advancedCriteriaFields" ;
        TreeMap criteriaFields = getCriteriaFieldListByPath(path, eachEntry, configurationHelper, "", searchFieldId);
        return criteriaFields;
    }


    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private TreeMap getMultiAdvancedCriteriaFieldList(int eachEntry, 
                                                ConfigurationHelper configurationHelper, ArrayList multiSearchAttributeList,
                                                String searchFieldId) throws XMLAccessException, 
                                                                                                ClassNotFoundException, 
                                                                                                NoSuchFieldException, 
                                                                                                IllegalAccessException {
        int eachFieldEntry = 1;
        TreeMap multiCriteriaFields = new TreeMap();
        
        while (eachFieldEntry > 0) {
            configurationHelper.setPath("/searchList/search[" + 
                                        String.valueOf(eachEntry) + 
                                        "]/advancedCriteriaFields[" + 
                                        String.valueOf(eachFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String forField = configurationHelper.getAttribute("forField");
                multiSearchAttributeList.add(new CodeAndDescription(forField, forField));
                showPrint("SearchConfig."+searchFieldId+".CriteriaFields.forField."+forField+"="+forField);
                
                String path = "/searchList/search[" + String.valueOf(eachEntry) + 
                                                        "]/advancedCriteriaFields[@forField='" + forField +"']" ;

                TreeMap criteriaFields = getCriteriaFieldListByPath(path, eachEntry, configurationHelper, forField, searchFieldId);
                multiCriteriaFields.put(forField, criteriaFields);

                eachFieldEntry++;
            } else {
                eachFieldEntry = -1;
            }
        }
        return multiCriteriaFields;
    }

        /**
         * 
         * @param eachEntry
         * @param configurationHelper
         * @return
         * @throws XMLAccessException
         * @throws ClassNotFoundException
         * @throws NoSuchFieldException
         * @throws IllegalAccessException
         */
        private TreeMap getMultiResultFields(int eachEntry, 
                                                    ConfigurationHelper configurationHelper, String searchFieldId) throws XMLAccessException, 
                                                                                                    ClassNotFoundException, 
                                                                                                    NoSuchFieldException, 
                                                                                                    IllegalAccessException {
            int eachResultFieldEntry = 1;
            TreeMap multiCriteriaFields = new TreeMap();
            ArrayList attributeList = new ArrayList();
            while (eachResultFieldEntry > 0) {
                configurationHelper.setPath("/searchList/search[" + 
                                            String.valueOf(eachEntry) + 
                                            "]/advancedResultFields[" + 
                                            String.valueOf(eachResultFieldEntry) + 
                                            "]");
                if (configurationHelper.pathExists()) {
                    String forField = configurationHelper.getAttribute("forField");
                    attributeList.add(forField);
            
                    String path = "/searchList/search[" + String.valueOf(eachEntry) + 
                                                            "]/advancedResultFields[@forField='" + forField +"']" ;

                    TreeMap resultFields = getResultFieldListByPath(path, eachEntry, configurationHelper, searchFieldId);
                    multiCriteriaFields.put(forField, resultFields);

                    eachResultFieldEntry++;
                } else {
                    eachResultFieldEntry = -1;
                }
            }
            return multiCriteriaFields;
        }


    
    /**
     * 
     * @param eachEntry
     * @param eachFieldEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static ArrayList getOptions(int eachEntry, int eachFieldEntry, 
                                        ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachOptionFieldEntry = 1;
        ArrayList options = new ArrayList();
        while (eachOptionFieldEntry > 0) {
            configurationHelper.setPath("/searchList/search[" + 
                                        String.valueOf(eachEntry) + 
                                        "]/criteriaFields/field[" + 
                                        String.valueOf(eachFieldEntry) + 
                                        "]/options/option[" + 
                                        eachOptionFieldEntry + "]");
            if (configurationHelper.pathExists()) {
                String value = configurationHelper.getElement("value");
                String text = configurationHelper.getElement("text");
                CodeAndDescription codeAndDescription = 
                    new CodeAndDescription(value, text);
                options.add(codeAndDescription);
                eachOptionFieldEntry++;
            } else {
                eachOptionFieldEntry = -1;
            }
        }
        return options;
    }
    
    /**
     * 
     * @param eachEntry
     * @param eachFieldEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static List<SearchTrigger> getSearchTriggers(int eachEntry, int eachFieldEntry, 
                                        ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachSearchTriggerEntry = 1;
        List<SearchTrigger> searchTriggers = new ArrayList<SearchTrigger>();
        while (eachSearchTriggerEntry > 0) {
            configurationHelper.setPath("/searchList/search[" + 
                                        String.valueOf(eachEntry) + 
                                        "]/criteriaFields/field[" + 
                                        String.valueOf(eachFieldEntry) + 
                                        "]/triggers/trigger[" + 
                                        eachSearchTriggerEntry + "]");
            if (configurationHelper.pathExists()) {
                String triggeringFieldName = configurationHelper.getElement("triggeringFieldName");
                String resultFieldName = configurationHelper.getElement("resultFieldName");
                SearchTrigger trigger = 
                    new SearchTrigger(triggeringFieldName, resultFieldName);
                searchTriggers.add(trigger);
                eachSearchTriggerEntry++;
            } else {
                eachSearchTriggerEntry = -1;
            }
        }
        return searchTriggers;
    }    
    
    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private TreeMap getResultFieldList(int eachEntry, 
                                              ConfigurationHelper configurationHelper, String searchFieldId) throws XMLAccessException {
        
        String path = "/searchList/search[" + String.valueOf(eachEntry) + 
                                                "]/resultFields" ;
        TreeMap resultFields = getResultFieldListByPath(path, eachEntry, configurationHelper, searchFieldId);
        return resultFields;        

    }
    
   
    
    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private static TreeMap getActions(int eachEntry, 
                                      ConfigurationHelper configurationHelper) throws XMLAccessException {
        int eachActionFieldEntry = 1;
        TreeMap actions = new TreeMap();
        while (eachActionFieldEntry > 0) {
            configurationHelper.setPath("/searchList/search[" + 
                                        String.valueOf(eachEntry) + 
                                        "]/actions/action[" + 
                                        String.valueOf(eachActionFieldEntry) + 
                                        "]");
            if (configurationHelper.pathExists()) {
                String actionId = configurationHelper.getElement("actionId");
                String actionLabel = 
                    configurationHelper.getElement("actionLabel");
                String actionCallBack = 
                    configurationHelper.getElement("actionCallBack");
                String allowableModes = 
                    configurationHelper.getElement("allowableModes");
                SearchActionInfo searchActionInfo = 
                    new SearchActionInfo(actionId, actionLabel, actionCallBack, 
                                         allowableModes);
                String useDialog = 
                    configurationHelper.getElement("useDialog");
                if(null != useDialog){
                    searchActionInfo.setUseDialog(Boolean.valueOf(useDialog));
                    searchActionInfo.setWindowHeight(Integer.parseInt(configurationHelper.getElement("windowHeight")));
                    searchActionInfo.setWindowWidth(Integer.parseInt(configurationHelper.getElement("windowWidth")));
                }
                actions.put(actionId, searchActionInfo);
                eachActionFieldEntry++;
            } else {
                eachActionFieldEntry = -1;
            }
        }
        return actions;
    }   




    public static void main(String[] arg) {
        String passed_id = "";
        if (arg.length > 0){
            passed_id = arg[0];
        }
        (new SearchConfigResourceGenerator()).loadSearchConfig(passed_id);

    }

    
    /**
     * Return a formated or different value based on this withValue.
     * <br>e.g.
     * This withValue code be a resource bundle key or a class constant
     * that is to be translated.
     * @param withValue
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static String getRealWithValue(String withValue) throws ClassNotFoundException, 
                                                                    NoSuchFieldException, 
                                                                    IllegalAccessException {
        if(withValue.equalsIgnoreCase("ANY")){
            return withValue;
        }
        
//        String[] classes = withValue.split(":", 3);
//        Class inTerface = Class.forName(classes[0]);
//        Field field = inTerface.getField(classes[1]);
        
        return withValue;
    }


    private TreeMap getCriteriaFieldListByPath(String path, int eachEntry, 
                                                ConfigurationHelper configurationHelper, String forField, String searchFieldId) throws XMLAccessException, 
                                                                                                ClassNotFoundException, 
                                                                                                NoSuchFieldException, 
                                                                                                IllegalAccessException {
        int eachCriteriaFieldEntry = 1;
        TreeMap criteriaFields = new TreeMap();
        int displayOrder = 0;
        while (eachCriteriaFieldEntry > 0) {
            configurationHelper.setPath(path+"/field["+String.valueOf(eachCriteriaFieldEntry)+"]");
            if (configurationHelper.pathExists()) {
                String fieldName = StringHelper.convertStringToID(forField) + configurationHelper.getElement("fieldName");
                showPrint("SearchConfig."+searchFieldId+".CriteriaFields."+ fieldName+"="+configurationHelper.getElement("fieldLabel"));                

                String fieldType = configurationHelper.getElement("fieldType");
                String fieldLabel = "SearchConfig."+searchFieldId+".CriteriaFields."+ fieldName;//configurationHelper.getElement("fieldLabel");
                String columnName = 
                    configurationHelper.getElement("columnName");
                String required = configurationHelper.getElement("required");
                String fieldLink = configurationHelper.getElement("fieldLink");
                String displayOrderStr = configurationHelper.getElement("displayOrder");
                String disabled = configurationHelper.getElement("disabled");
                String isVisible = configurationHelper.getElement("isVisible");
                String fieldValuesStaticallyGiven = configurationHelper.getElement("fieldValuesStaticallyGiven");
                String fieldLinkValue = 
                    configurationHelper.getElement("fieldLinkValue");
                String opertaor = configurationHelper.getElement("operator");
                String listId = StringHelper.returnBlankIfNull(configurationHelper.getElement("listId"));                
                String multipleLines = configurationHelper.getElement("multipleLines");
                SearchCriteriaFieldInfo searchCriteriaFieldInfo = 
                    new SearchCriteriaFieldInfo(fieldName, fieldType, 
                                                fieldLabel, columnName, 
                                                opertaor);
                                                
                searchCriteriaFieldInfo.setListId(listId);
                String searchId = configurationHelper.getElement("searchId");
                searchCriteriaFieldInfo.setSearchId(searchId);
                
                if (null != required)
                    searchCriteriaFieldInfo.setRequired(Boolean.valueOf(required));

                if (null != fieldLink)
                    searchCriteriaFieldInfo.setFieldLink(fieldLink);
                
                if(disabled != null) {
                    searchCriteriaFieldInfo.setDisabled(Boolean.valueOf(disabled));
                }

                if(multipleLines != null) {
                    searchCriteriaFieldInfo.setMultipleLines(Boolean.valueOf(multipleLines));
                }
                
                if(isVisible != null) {
                    searchCriteriaFieldInfo.setVisible(Boolean.valueOf(isVisible));
                }   
                
                if(fieldValuesStaticallyGiven != null) {
                    searchCriteriaFieldInfo.setFieldValuesStaticallyGiven(Boolean.valueOf(fieldValuesStaticallyGiven));
                }
                
                if(displayOrderStr != null) {
                    searchCriteriaFieldInfo.setDisplayOrder(Integer.valueOf(displayOrderStr));
                }
                else {
                    searchCriteriaFieldInfo.setDisplayOrder(displayOrder);
                }
                displayOrder++;
                
                if (null != fieldLinkValue){
                   
                        /*
                         * Use reflection with the class to get interface constant value
                         */
                        fieldLinkValue = getRealWithValue(fieldLinkValue);                    
                        searchCriteriaFieldInfo.setFieldLinkValue(fieldLinkValue);
                }

//                ArrayList options = 
//                    getOptions(eachEntry, eachCriteriaFieldEntry, 
//                               configurationHelper);
//                searchCriteriaFieldInfo.setOptions(options);
                List<SearchTrigger> triggers = 
                    getSearchTriggers(eachEntry, eachCriteriaFieldEntry, 
                               configurationHelper);   
                searchCriteriaFieldInfo.setTriggerList(triggers);
                criteriaFields.put(fieldName, searchCriteriaFieldInfo);
                eachCriteriaFieldEntry++;
            } else {
                eachCriteriaFieldEntry = -1;
            }
        }
        return criteriaFields;
    }



    /**
     * 
     * @param eachEntry
     * @param configurationHelper
     * @return
     * @throws XMLAccessException
     */
    private TreeMap getResultFieldListByPath(String path, int eachEntry, 
                                              ConfigurationHelper configurationHelper, String searchFieldId) throws XMLAccessException {
        int eachResultFieldEntry = 1;
        TreeMap resultFields = new TreeMap();
        while (eachResultFieldEntry > 0) {
            configurationHelper.setPath(path+"/field[" + 
                                        String.valueOf(eachResultFieldEntry) + "]");
            if (configurationHelper.pathExists()) {
                String fieldName = configurationHelper.getElement("fieldName");
                showPrint("SearchConfig."+searchFieldId+".ResultField."+fieldName+"="+configurationHelper.getElement("columnHeading"));

                String getValueFromResources = configurationHelper.getElement("getValueFromResources");
                if (getValueFromResources != null && getValueFromResources.equals("Y")){
                    showPrint("SearchConfig.getValueFromResource."+searchFieldId+".");
                }
                    
                eachResultFieldEntry++;
            } else {
                eachResultFieldEntry = -1;
            }
        }
        return resultFields;
    }


    private void showPrint(String str){
        sbToPrint.append(str + "\n");
//        log.debug(str);
    }

    public void writeToFile() {
        
        //FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object

        try
        {
            File output = new File(FILENAME);
            if (output.exists()) {
                output.delete();
            }
                //out = new FileOutputStream(FILENAME);
                p =  new PrintStream(output, Constants.DEFAULT_ENCODING);
                p.print (sbToPrint.toString());
                p.close();
            log.debug("---- File generated ---- ");
        }
        catch (Exception e)
        {
                System.err.println ("Error writing to file");
        }
    }
}
