package com.technobrain.trips.reports.param;

public class TemplateFormatsLabelValuesImpl {
    TemplateFormatsLabelValueImpl[] templateFormatsLabelValue = null;
    
    private java.lang.String templateID;

    private java.lang.String templateType;

    private java.lang.String templateURL;
    
    public TemplateFormatsLabelValuesImpl() {
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateURL(String templateURL) {
        this.templateURL = templateURL;
    }

    public String getTemplateURL() {
        return templateURL;
    }

    public void setTemplateFormatsLabelValue(TemplateFormatsLabelValueImpl[] templateFormatsLabelValue) {
        this.templateFormatsLabelValue = templateFormatsLabelValue;
    }

    public TemplateFormatsLabelValueImpl[] getTemplateFormatsLabelValue() {
        return templateFormatsLabelValue;
    }
}
