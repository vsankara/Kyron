package com.technobrain.trips.reports.util;

import com.technobrain.trips.reports.dto.ReportData;

import org.w3c.dom.Document;

public interface DataBuilder {
    enum TYPES {BI};
    public ReportData doTransform(Document document);
}
