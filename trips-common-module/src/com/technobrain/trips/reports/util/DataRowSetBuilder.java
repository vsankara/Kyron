package com.technobrain.trips.reports.util;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.reports.dto.ReportData;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class DataRowSetBuilder {
    Document document = null;

    public DataRowSetBuilder(byte[] reportBytes) throws ParserConfigurationException, 
                                                        SAXException, 
                                                        IOException {


        ByteArrayInputStream byteArrayInputStream = 
            new ByteArrayInputStream(reportBytes);
        DocumentBuilder db;
        DocumentBuilderFactory documentBuilderFactory = 
            DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        db = documentBuilderFactory.newDocumentBuilder();
        db.setEntityResolver(new EntityResolver() {
                    public InputSource resolveEntity(java.lang.String publicId, 
                                                     java.lang.String systemId) throws SAXException, 
                                                                                       java.io.IOException {
//                        if (publicId.equals("--myDTDpublicID--"))
                            // this deactivates the open office DTD
                            return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes(Constants.DEFAULT_ENCODING)));
//                        else
//                            return null;
                    }
                });
        this.document = db.parse(byteArrayInputStream);


    }

    public DataRowSetBuilder(Document _document) {
        this.document = _document;
    }

    public ReportData transform(DataBuilder dataBuilder) {
        return dataBuilder.doTransform(this.document);
    }
}
