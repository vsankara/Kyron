package com.technobrain.trips.util;

//package com.crownagents.trips.util;
//
//import au.com.bytecode.opencsv.CSVReader;
//
//import com.crownagents.trips.common.constants.Constants;
//import com.crownagents.trips.common.exceptions.InvalidFileException;
//import com.crownagents.trips.dto.tax.accounting.BatchPaymentRecnLog;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import java.math.BigDecimal;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.myfaces.trinidad.model.UploadedFile;
//import org.apache.log4j.Logger;
//
///**
// *  Inner class for processing/parsing file input.
// */
//public class ReconcileBatchPaymentFileProcessor {
//    static final Logger log = Logger.getLogger(ReconcileBatchPaymentFileProcessor.class);
//
//    private UploadedFile uploadedFile;
//    private String filename;
//    private long filesize;
//    private String filetype;
//    private BatchPaymentRecnLog model;
//    private static final String VALID_FILE = "text/plain";
//
//    /**
//     * Parse csv file to string
//     */
//    public CSVReader returnParsingReader(InputStream is) throws IOException {
//        return new CSVReader(new InputStreamReader(is, Constants.DEFAULT_ENCODING));
//    }
//
//    /**
//     * Event when reconcile is invoked
//     * @param 
//     */
//    public List<BatchPaymentRecnLog> doReconcileFile() throws IOException, 
//                                                            InvalidFileException {
//        // Check if file is already uploaded
//        if (uploadedFile == null) {
//            throw new NullPointerException("Uploaded file must not be null.");
//        }
//        
//        log.debug(this.filetype + " is file type" );
//        
//        // Validate if file is acceptable
//        if (!this.filetype.equals(VALID_FILE)) {
//            throw new InvalidFileException("File uploaded is not valid.");
//        }
//
//        // Map contents to model ReconciliationModel and return it
//        return parseContentToModelManually(uploadedFile.getInputStream());
//    }
//
//    /**
//     * Parse content to model manually.
//     */
//    public List<BatchPaymentRecnLog> parseContentToModelManually(InputStream in) throws IOException {
//
//        List<String[]> items = returnParsingReader(in).readAll();
//        List<BatchPaymentRecnLog> trpEntries = 
//            new ArrayList<BatchPaymentRecnLog>();
//
//        for (String[] item: items) {
//            BatchPaymentRecnLog instance = new BatchPaymentRecnLog();
//            String firstItem = item[0];
//            if(firstItem != null && firstItem.equalsIgnoreCase("0")){
//            }else{
//                instance.setIndicator(item[0]); //1
//                instance.setHeadAABCode(item[1]); //2
//                //instance.setCollectionDate(item[2]); //3
////                instance.setRemittanceDate(item[3]); //4
//                instance.setBranchAABCode(item[4]); //5
//                instance.setRdoCode(item[5]); //6
//                instance.setBcsStartNumber(item[6]); //7
//                instance.setBcsEndNumber(item[7]); // 8
//                instance.setCashAmount(new BigDecimal(item[8])); // 9
//                instance.setNonCashAmount(new BigDecimal(item[9])); // 10
//                trpEntries.add(instance);
//            }
//             
//
//            
//        }
//        return trpEntries;
//    }
//
//
//    /**
//     * Event when Upload control is invoked
//     * @param uploadedFile
//     */
//    public void setUploadedFile(UploadedFile uploadedFile) {
//        this.uploadedFile = uploadedFile;
//        this.filename = uploadedFile.getFilename();
//        this.filesize = uploadedFile.getLength();
//        this.filetype = uploadedFile.getContentType();
//    }
//
//    /**
//     * Get uploaded file
//     */
//    public UploadedFile getUploadedFile() {
//        return uploadedFile;
//    }
//}
