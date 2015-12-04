package test.com.crownagents.trips.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import java.io.IOException;
import org.apache.log4j.Logger;

public class GroovyTest {
    static final Logger log = Logger.getLogger(GroovyTest.class);
    public GroovyTest() {
    }
    
    public static void testScript(GroovyCodeSource script){
        new GroovyTest().runGroovyScript(script);
    }
    private Object runGroovyScript(GroovyCodeSource script) {
        ClassLoader parent = GroovyTest.class.getClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);
        
          Class groovyClass = loader.parseClass(script);
          
          GroovyObject groovyObject = null;

         try {
             groovyObject = (GroovyObject)
            groovyClass.newInstance();
         } catch (IllegalAccessException e) {
             log.error(e.getLocalizedMessage(), e);
         } catch (InstantiationException e) {
              log.error(e.getLocalizedMessage(), e);
         }
         
          //groovyObject.setProperty("context", this);
          Object[] argz = {};
          
         Object value = groovyObject.invokeMethod("main", argz);
         return value;
    }
    
    public static void main(String args[]){
        GroovyCodeSource gcs = null;
        try {
            gcs = new GroovyCodeSource(new GroovyFile().readFile());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        testScript(gcs);
    }
}
