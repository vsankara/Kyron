package com.technobrain.trips.reports.bi;

import com.technobrain.trips.reports.dto.ColumnData;
import com.technobrain.trips.reports.dto.ReportData;
import com.technobrain.trips.reports.dto.RowData;
import com.technobrain.trips.reports.util.DataBuilder;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlPublisherDataBuilderImpl implements DataBuilder {
    ReportData reportData = null;

    public ReportData doTransform(Document document) {
        reportData = new ReportData();
        reportData.setRows(new ArrayList<RowData>());
        if(null == document || document.getChildNodes() == null){
            //do nothing
        }else
            for (int i = 0; i < document.getChildNodes().getLength(); i++) {
                Node node = document.getChildNodes().item(i);
                transformRows(node.getChildNodes());
            }
        return reportData;
    }

    public void transformRows(NodeList _nodeList) {
        for (int n = 0; n < _nodeList.getLength(); n++) {
            Node node = _nodeList.item(n);
           
            if (node.getNodeType() == Node.ELEMENT_NODE) {
              RowData rowData =  transformRow(node);
              if(null != rowData)
                reportData.addRow(rowData);
            }
        }
    }

    public  RowData transformRow(Node _node) {
        RowData rowData = _node.getChildNodes().getLength() == 0 ? null : new RowData();
        ColumnData columnData = null;
        for (int n = 0; n < _node.getChildNodes().getLength(); n++) {
            Node node = _node.getChildNodes().item(n);
            columnData = new ColumnData();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                columnData.setFieldName(node.getNodeName());
                if(node.getChildNodes().getLength() > 0){
                    columnData.setFieldValue(node.getChildNodes().item(0).getNodeValue());
                }
                rowData.addColumn(columnData);
            }
            
        }    
        
        return rowData;
    }
}
