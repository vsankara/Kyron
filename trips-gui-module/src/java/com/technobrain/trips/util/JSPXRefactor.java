package com.technobrain.trips.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.technobrain.trips.util.LocationReporter.LocationPointer;
import com.technobrain.trips.common.constants.Constants;

public class JSPXRefactor {
	
	
	public static final String TEMP_FILE = "C:/tempXX.jspx";
	public static final String LOG_FILE_FILES = "C:/files.txt";
	public static final String LOG_FILE_DETAILS = "C:/details.txt";
	
	private static BufferedWriter logFileNames = null;
	private static BufferedWriter logDetails = null;
	
	private static int totalChangeIdCount;
	private static int totalChangeFileCount;
	private static int totalFileCount; 
	

	public static void main(String[] args) throws Exception {
		//String fileName = "C:/work/Projects/trips-gui/public_html/account/AccountAdjustment.jspx";
		String fileName = "C:/work/Projects/trips-gui/public_html";

	    logFileNames = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(JSPXRefactor.LOG_FILE_FILES), Constants.DEFAULT_ENCODING));
	    logDetails = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(JSPXRefactor.LOG_FILE_FILES), Constants.DEFAULT_ENCODING)); 
	    
	    
	    
	    
	    processFolder(new File(fileName));
	    
	    logFileNames.write("totalFileCount:" +totalFileCount + "totalChangeFileCount:" + totalChangeFileCount + " totalChangeIdCount:" + totalChangeIdCount + "\n");
	    
	    logFileNames.close();
	    logDetails.close();
	    
	    
	}
	
	private static void processFolder(File file) throws Exception{
		try {
			if(file.isDirectory()){
				for(File f : file.listFiles()){
					processFolder(f);
				}
			} else {
				if(!file.getAbsolutePath().endsWith(".jspx")){
					return;
				}
				
				XMLReader saxParser = new SAXParser();
				LocationReporter lr = new LocationReporter();
				lr.init(file, logDetails);
				lr.setJustMock(true);
				saxParser.setContentHandler(lr);
				InputStream inputStream= new FileInputStream(file);
				Reader reader = new InputStreamReader(inputStream,"UTF-8");
				saxParser.parse(new InputSource(reader));
				inputStream.close();
				
				if(lr.isChanged()){
					if(!lr.isJustMock()){
						for(LocationPointer p : lr.getLocations()){
							updateWithNewId(file, p.getId(), p.getLine(), p.getColumn());
							File tmpFile = new File(JSPXRefactor.TEMP_FILE);
							file.delete();
							tmpFile.renameTo(file);
							tmpFile.delete();
						}
					}
					
					logFileNames.write(file.getAbsolutePath() + " total changes:" + lr.getChangeCount()  + "\n" );
					totalChangeIdCount += lr.getChangeCount();
					totalChangeFileCount ++;
				}
				totalFileCount ++;

			} 
		} catch (Exception e) {
			System.err.println("ERROR file:" + file.getAbsolutePath() + " :" + e.getMessage());
			e.printStackTrace();
		}
		
		

	}
	
	
	private static void updateWithNewId(File file, String id, int line, int column) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Constants.DEFAULT_ENCODING));
			File tempFile = new File(JSPXRefactor.TEMP_FILE);
			OutputStreamWriter fstream = new OutputStreamWriter(new FileOutputStream(tempFile), Constants.DEFAULT_ENCODING);
		    BufferedWriter out = new BufferedWriter(fstream);
		 
		    
			String sCurrentLine;
			int cLine = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				cLine ++;
				if(cLine == line){
					if( sCurrentLine.charAt((column-3)) == '/'){
						sCurrentLine = sCurrentLine.substring(0
								, column -3)  
										+ " id=\"" + id +"\" "
										+  sCurrentLine.substring(column - 3 );	
					} else {
						sCurrentLine = sCurrentLine.substring(0
								, column -2)  
										+ " id=\"" + id +"\" "
										+  sCurrentLine.substring(column - 2 );
					}
					
					
				}
				out.write(sCurrentLine);
				out.write((char)13);
				out.write((char)10);
				//System.out.println(sCurrentLine);
			}
			
			
			out.close();
			br.close();
			
			//file.delete();
			//fileNew.delete();
			//tempFile.renameTo(file);
		} catch (Exception e) {
			System.err.println("file:" + file.getName() + " id :" + id);
			e.printStackTrace();
		}
		
		
		
	}

}

