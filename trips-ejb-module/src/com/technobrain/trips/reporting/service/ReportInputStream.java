package com.technobrain.trips.reporting.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;

public class ReportInputStream extends ObjectInputStream {

	public static final Logger log = Logger.getLogger(ReportInputStream.class);

	protected ReportInputStream() throws IOException, SecurityException {
		super();
	}
	
	public ReportInputStream(InputStream in) throws IOException {
		super(in);
	}
	

	protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
		ObjectStreamClass streamClassDescriptor = super.readClassDescriptor();
		Class localClass = Class.forName(streamClassDescriptor.getName());
		ObjectStreamClass localClassDescriptor = ObjectStreamClass.lookup(localClass);
		if (localClassDescriptor != null) {
			final long localSUID = localClassDescriptor.getSerialVersionUID();
			final long streamSUID = streamClassDescriptor.getSerialVersionUID();
			if (streamSUID != localSUID) {
				log.warn("overriding deserialization operation !!!  localSUID:" + localSUID + " streamSUID:" + streamSUID
						+ " for " + localClassDescriptor.getName());
				try {
					Field fields = streamClassDescriptor.getClass().getDeclaredField("fields");
					fields.setAccessible(true);
					Object old = fields.get(streamClassDescriptor);
					fields.set(localClassDescriptor, old);
					
					Field numObjFields = streamClassDescriptor.getClass().getDeclaredField("numObjFields");
					numObjFields.setAccessible(true);
					Object oldNumObjFields = numObjFields.get(streamClassDescriptor);
					numObjFields.set(localClassDescriptor, oldNumObjFields);
					
					streamClassDescriptor = localClassDescriptor;
				} catch (Exception e) {
					log.error("", e);
				} 
			}
		}
		return streamClassDescriptor;
	}
	
	


	 
	 

}
