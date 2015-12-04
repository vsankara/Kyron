package test.com.crownagents.trips.groovy;

//import com.crownagents.trips.castor.CastorSerializerDeSerializer;
import java.io.File;

import org.apache.log4j.Logger;

public class GroovyFile {
    static final Logger log = Logger.getLogger(GroovyFile.class);
    public GroovyFile() {
    }
    
    public File readFile(){
     
    String file = "Q:\\TRIPS2\\Dev\\Java\\Projects\\trips-common\\src\\test\\com\\crownagents\\trips\\groovy\\Rule001.txt";
    log.debug("File " + file);
     File f = new File(file);
       
        return f;
    }
}
