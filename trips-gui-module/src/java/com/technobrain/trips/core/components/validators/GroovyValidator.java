package com.technobrain.trips.core.components.validators;

import com.technobrain.trips.core.components.AbstractStateholder;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

public class GroovyValidator extends AbstractStateholder implements Validator {

    static final Logger log = Logger.getLogger(GroovyValidator.class);

    String groovyScript = null;
    Object messageType = null;

    /**
     *
     */
    public GroovyValidator() {
        super();
    }

    /* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {

        if (null != groovyScript) {
            String msg = computeDefaultValue(groovyScript, context, component, value);
            if (null != msg) {
                String[] rule = msg.split(":");
                FacesMessage errMsg = null;
                if (rule.length > 1) {
                    errMsg = new FacesMessage(rule[0], rule[1]);
                } else {
                    errMsg = new FacesMessage(msg);
                }

                throw new ValidatorException(errMsg);
            }
        }
    }

    /**
     * Run the groovy script
     *
     * @param script
     * @return
     */
    private String computeDefaultValue(String script, FacesContext context, UIComponent component, Object value) {
        ClassLoader parent = GroovyValidator.class.getClassLoader();
        GroovyClassLoader loader = new GroovyClassLoader(parent);

        Class groovyClass = loader.parseClass(script);

        GroovyObject groovyObject = null;

        try {
            groovyObject = (GroovyObject) groovyClass.newInstance();
        } catch (IllegalAccessException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (InstantiationException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        groovyObject.setProperty("context", context);
        groovyObject.setProperty("component", component);
        groovyObject.setProperty("value", value);
        groovyObject.setProperty("messageType", messageType);

        Object[] argz = {};

        Object returnValue = groovyObject.invokeMethod("run", argz);
        return null == returnValue ? null : String.valueOf(returnValue);
    }

    public void setGroovyScript(String groovyScript) {
        this.groovyScript = groovyScript;
    }

    public String getGroovyScript() {
        return groovyScript;
    }

    public void setMessageType(Object messageType) {
        this.messageType = messageType;
    }

    public Object getMessageType() {
        return messageType;
    }

}
