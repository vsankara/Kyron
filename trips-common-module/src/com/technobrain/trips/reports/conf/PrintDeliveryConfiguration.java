package com.technobrain.trips.reports.conf;


public class PrintDeliveryConfiguration extends DeliveryConfiguration {

    public static String DEFAULT_SERVER = "HPLJ4250DTN_PFMIT";
    
    private java.lang.String printNumberOfCopy;

    private java.lang.String printRange;

    private java.lang.String printSide;

    private java.lang.String printTray;

    private java.lang.String printerName;

    public void setPrintNumberOfCopy(String printNumberOfCopy) {
        this.printNumberOfCopy = printNumberOfCopy;
    }

    public String getPrintNumberOfCopy() {
        return printNumberOfCopy;
    }

    public void setPrintRange(String printRange) {
        this.printRange = printRange;
    }

    public String getPrintRange() {
        return printRange;
    }

    public void setPrintSide(String printSide) {
        this.printSide = printSide;
    }

    public String getPrintSide() {
        return printSide;
    }

    public void setPrintTray(String printTray) {
        this.printTray = printTray;
    }

    public String getPrintTray() {
        return printTray;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterName() {
        return printerName;
    }
}
