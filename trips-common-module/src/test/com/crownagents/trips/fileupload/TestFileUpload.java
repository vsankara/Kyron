package test.com.crownagents.trips.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;

public class TestFileUpload {
    static final Logger log = Logger.getLogger(TestFileUpload.class);
    public TestFileUpload() {
    }

    public static void main(String[] args) {
        TestFileUpload testFileUpload = new TestFileUpload();
        File f = new File("C:/logo.jpeg");
     
        try {
            FileInputStream i;
            i = new FileInputStream(f);
           
            byte[] newBytes = testFileUpload.getBytesArray(i);
            log.debug("newBytes " + newBytes.length);
            File newFile = new File("C:/newlogo.jpeg");
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(newBytes);
            fos.flush();
            fos.close();
        } catch (Exception e) {
           log.error(e.getLocalizedMessage(), e);
        }
    }
    
    public byte[] getBytesArray(InputStream inStream) throws IOException {
        BufferedOutputStream bufOut=null;
        ByteArrayOutputStream bAOut = null;
        //byte[] totalBytes = null;
        log.debug("before available " + inStream.available());
        int availableLength = inStream.available();
        //totalBytes = new byte[availableLength];
        int c;
        BufferedInputStream bufIn=new BufferedInputStream(inStream,availableLength);
        bAOut = new ByteArrayOutputStream();
        bufOut=new BufferedOutputStream(bAOut,availableLength);
        while ((c = bufIn.read()) != -1) {
            bufOut.write((char) c);
        }
        bufOut.flush();
        bufOut.close();
        return bAOut.toByteArray();

    }
}
