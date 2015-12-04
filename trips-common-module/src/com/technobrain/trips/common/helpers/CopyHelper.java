package com.technobrain.trips.common.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.log4j.Logger;

public class CopyHelper {
    static final Logger log = Logger.getLogger(CopyHelper.class);


    /**
     * Returns a deep copy of the object, or null if the object cannot
     * be serialized.
     */
    public static <T extends Object> T deepCopy(T orig) {
        T obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            obj = (T)in.readObject();
        }
        catch(IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        catch(ClassNotFoundException cnfe) {
            log.error(cnfe.getLocalizedMessage(), cnfe);
        }
        return obj;
    }

}
