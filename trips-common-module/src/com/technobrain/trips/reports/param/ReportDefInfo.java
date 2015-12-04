package com.technobrain.trips.reports.param;

public class ReportDefInfo {
    private java.lang.String defaultOutputFormat;

    private java.lang.String defaultTemplateId;

    private java.lang.String[] parameterNames;

    private ParameterNameValue[] reportParameterNameValues;

    private java.lang.String[] templateIds;
    
    private TemplateFormatsLabelValuesImpl[] templateFormatsLabelValuesImpl;

    public void setDefaultOutputFormat(String defaultOutputFormat) {
        this.defaultOutputFormat = defaultOutputFormat;
    }

    public String getDefaultOutputFormat() {
        return defaultOutputFormat;
    }

    public void setDefaultTemplateId(String defaultTemplateId) {
        this.defaultTemplateId = defaultTemplateId;
    }

    public String getDefaultTemplateId() {
        return defaultTemplateId;
    }

    public void setParameterNames(String[] parameterNames) {
        this.parameterNames = parameterNames;
    }

    public String[] getParameterNames() {
        return parameterNames;
    }

    public void setTemplateIds(String[] templateIds) {
        this.templateIds = templateIds;
    }

    public String[] getTemplateIds() {
        return templateIds;
    }

    public void setReportParameterNameValues(ParameterNameValue[] reportParameterNameValues) {
        this.reportParameterNameValues = reportParameterNameValues;
    }

    public ParameterNameValue[] getReportParameterNameValues() {
        return reportParameterNameValues;
    }

    public void setTemplateFormatsLabelValuesImpl(TemplateFormatsLabelValuesImpl[] templateFormatsLabelValuesImpl) {
        this.templateFormatsLabelValuesImpl = templateFormatsLabelValuesImpl;
    }

    public TemplateFormatsLabelValuesImpl[] getTemplateFormatsLabelValuesImpl() {
        return templateFormatsLabelValuesImpl;
    }
}
