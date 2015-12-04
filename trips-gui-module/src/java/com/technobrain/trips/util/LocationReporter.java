package com.technobrain.trips.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class LocationReporter implements ContentHandler {

	Locator locator = null;
	int indexCunter = 0;
	List<String> existigIDs;
	Properties rb;
	private File file;
	private boolean changed;
	private int changeCount; 
	BufferedWriter logDetails;
	private boolean justMock = true;
	private List<LocationPointer> locations;
	
	public void init(File file, BufferedWriter logDetails) throws IOException {
		existigIDs = new ArrayList<String>();
		rb = new Properties();
		this.file = file;
		this.logDetails = logDetails;
		locations = new ArrayList<LocationReporter.LocationPointer>();
		rb.load(new FileInputStream("Q:/Projects/trips-gui/src/com/crownagents/trips/bundle/UIResources.properties"));
	}
	
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
	}
//
//	private String reportPosition() {
//
//		if (locator != null) {
//
//			String publicID = locator.getPublicId();
//			String systemID = locator.getSystemId();
//			int line = locator.getLineNumber();
//			int column = locator.getColumnNumber();
//
//			String name;
//			if (publicID != null)
//				name = publicID;
//			else
//				name = systemID;
//
//			return " in " + name + " at line " + line + ", column " + column;
//		}
//		return "";
//
//	}

	public void startDocument() throws SAXException {
		//System.out.println("Document started" + reportPosition());
	}

	public void endDocument() throws SAXException {
		//System.out.println("Document ended" + reportPosition());
	}

	public void characters(char[] text, int start, int length)throws SAXException {
		//System.out.println("Got some characters" + reportPosition());
	}

	public void ignorableWhitespace(char[] text, int start, int length)throws SAXException {
		//System.out.println("Got some ignorable white space" + reportPosition());
	}

	public void processingInstruction(String target, String data) throws SAXException {
		//System.out.println("Got a processing instruction" + reportPosition());
	}

	// Changed methods for SAX2
	public void startElement(String namespaceURI, String localName, String rawName, Attributes atts) throws SAXException {
		//System.out.println("Element " + rawName + " started" + reportPosition());
		
		if(atts.getValue("id") != null){
			if(existigIDs.contains(atts.getValue("id"))){
				System.out.println("duplicate ID problem for file : " + file.getName() + " line:" + locator.getLineNumber() + " element:" + rawName + " Id:" +atts.getValue("id"));
			} else {
				existigIDs.add(atts.getValue("id"));	
			}
			return;
		}
		
		String newId = null;

		if(rawName.equals("af:commandButton")){
			newId = "btn" + generateId(atts.getValue("text"));
		} else if(rawName.equals("af:selectInputDate")){
			newId = "date" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectOneChoice")){
			newId = "selectOne" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:inputTex")){
			newId = "text" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:inputFile")){
			newId = "file" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectBooleanCheckbox")){
			newId = "booleanCheckBox" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectOneRadio")){
			newId = "radio" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectManyCheckbox")){
			newId = "date" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectManyListbox")){
			newId = "date" + generateId(atts.getValue("label"));
		} else if(rawName.equals("af:selectOneRadio")){
			newId = "date" + generateId(atts.getValue("label"));
		}

		if(newId != null){
			locations.add(new LocationPointer( locator.getLineNumber(),  locator.getColumnNumber(), newId));
			setChanged(true);
			changeCount++;
			try {
				logDetails.write("file : " + file.getName() + " line:" + locator.getLineNumber() + " element:" + rawName + " newId:" +newId + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void endElement(String namespaceURI, String localName, String rawName) throws SAXException {
		//System.out.println("Element " + rawName + " ended" + reportPosition());
	}

	// new methods for SAX2
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		//System.out.println("Started mapping prefix " + prefix + " to URI " + uri + reportPosition());
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		//System.out.println("Stopped mapping prefix " + prefix + reportPosition());
	}

	public void skippedEntity(String name) throws SAXException {
		//System.out.println("Skipped entity " + name + reportPosition());
	}
	
	private String generateId(String text){
		String newId = null;
		
		String label = null;
		if(text != null && text.contains("#{resources[")){ // e.g. #{resources['Global.commandButton.Save']}
			label = rb.getProperty(text.substring("#{resources['".length(), text.indexOf("']}")));
		} else if(text != null){
			label = text;
		} else {
			label = "";
		}
		if(label == null){
			label = "";
		}
		
		boolean isFirst = true;
		if(label.replaceAll("[^a-zA-Z0-9]+","").length() > 20){
			newId = "";
			String append = null;
			for(String word : label.split(" ")){
				if(isFirst){
					append =  word;
					isFirst = false;
				} else if(word.length() > 3){
					append = word.substring(0, 3);
				} else {
					append = word;
				}
				newId += Character.toUpperCase(append.charAt(0)) +  append.substring(1) ;
			}
		} else {
			newId = label;
		}
		String result =  null;
		if(newId.length() > 1){
			newId = newId.replaceAll("[^a-zA-Z0-9]+","");
			result = Character.toUpperCase(newId.charAt(0)) +  newId.substring(1);
		} else {
			result = newId;
		}
		if(existigIDs.contains(result)){
			result += ++indexCunter;
		}
		
		
		existigIDs.add(result);
		return  result;
	}

	class LocationPointer{
		
		private int line;
		private int column;
		private String id;

		public LocationPointer(int line, int column, String id) {
			super();
			this.line = line;
			this.column = column;
			this.id = id;
		}
		public int getLine() {
			return line;
		}
		public void setLine(int line) {
			this.line = line;
		}
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		
		
		
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public int getChangeCount() {
		return changeCount;
	}

	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}

	public boolean isJustMock() {
		return justMock;
	}

	public void setJustMock(boolean justMock) {
		this.justMock = justMock;
	}

	public List<LocationPointer> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationPointer> locations) {
		this.locations = locations;
	}
	
	
	
}
