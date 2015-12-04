package com.technobrain.trips.util;

import com.technobrain.trips.core.backing.BackingBase;
import com.technobrain.trips.core.sessionmanager.annotation.SessionWorker;
import com.technobrain.trips.core.sessionmanager.backing.BackingSessionManager;
import com.technobrain.trips.common.exceptions.TripsValidationException;
import com.technobrain.trips.common.helpers.ReflectionHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.message.OutputType;
import com.technobrain.trips.core.message.SystemMessage;
import com.technobrain.trips.core.model.BaseRefModelObject;
import com.technobrain.trips.dto.CodeAndDescription;

import java.lang.reflect.Field;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import javax.ejb.EJBException;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewHandler;
import javax.faces.component.ActionSource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

import javax.security.auth.Subject;

import oracle.bpel.services.workflow.WorkflowException;

import org.apache.log4j.Logger;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.spacer.Spacer;
import org.primefaces.context.RequestContext;
/**
 * General useful static utilies for workign with JSF.
 *
 * @since November 22,2006.
 * @author hhill
 */
public class FacesUtil {
    static final Logger log = Logger.getLogger(FacesUtil.class);

    private static final String NO_RESOURCE_FOUND = "Missing resource: ";
    
    /**
     * Indicates failure outcome
     */
    public static final String FAILURE_OUTCOME = "failure";
    
    /**
     * Indicates success outcome
     */
    public static final String SUCCESS_OUTCOME = "success";

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static Object resolveExpression(String expression) {
      FacesContext ctx = getFacesContext(); 
//      Application app = ctx.getApplication();
//      ValueBinding bind = app.createValueBinding(expression);
//      return bind.getValue(ctx);
        return ctx.getELContext().getELResolver().getValue(ctx.getELContext(), null, expression);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching Boolean.
     * @param expression EL expression
     * @return Managed object
     */
    public static Boolean resolveExpressionAsBoolean(String expression) {
      return (Boolean)resolveExpression(expression);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching String (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static String resolveExpressionAsString(String expression) {
      return (String)resolveExpression(expression);
    }

    /**
     * Convenience method for resolving a reference to a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @return Managed object
     */
    public static Object getManagedBeanValue(String beanName) {
      FacesContext ctx = getFacesContext();  
      Object managedBean =  ctx.getExternalContext().getSessionMap().get(beanName);
        log.debug("managedBean ["+managedBean+"]");
//      if(managedBean == null){
//          StringBuffer buff = new StringBuffer("#{");
//          buff.append(beanName);
//          buff.append("}");
//          return resolveExpression(buff.toString());
//      }else{
          return managedBean;
//      }
    }
    
 public static Object getCreateOrGetManagedBeanValue(String beanName) {
     FacesContext ctx = getFacesContext();  
     Map<String, Object> myMap = ctx.getExternalContext().getSessionMap();
     /*
     log.debug("================================================================");
     for(String key : myMap.keySet()) {
             log.debug(key);
             //log.debug(myMap.get(key)); 
     }
     log.debug("================================================================");
     log.debug("beanName ["+beanName+"]");
      */
     Object managedBean =  ctx.getExternalContext().getSessionMap().get(beanName);
     log.debug("backingSessionManager ["+managedBean+"]");
     if(managedBean == null){
             //                      StringBuffer buff = new StringBuffer("#{");
             //                      buff.append(beanName);
             //                      buff.append("}");
             //                      return resolveExpression(buff.toString());
             return resolveExpression(beanName);
     }else{
             return managedBean;
     }
 }

    /**
     * Method for setting a new object into a JSF managed bean
     * Note: will fail silently if the supplied object does
     * not match the type of the managed bean.
     * @param expression EL expression
     * @param newValue new value to set
     */
    public static void setExpressionValue(String expression, 
                                          Object newValue) {
      FacesContext ctx = getFacesContext();                                        
//      Application app = ctx.getApplication();
//      ValueBinding bind = app.createValueBinding(expression);

      //Check that the input newValue can be cast to the property type
      //expected by the managed bean. 
      //If the managed Bean expects a primitive we rely on Auto-Unboxing
      //I could do a more comprehensive check and conversion from the object 
      //to the equivilent primitive but life is too short
//      Class bindClass = bind.getType(ctx);
//      if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
//        bind.setValue(ctx, newValue);
//      }
        Class bindClass = ctx.getELContext().getELResolver().getType(ctx.getELContext(), null, expression);
        if(bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            ctx.getELContext().getELResolver().setValue(ctx.getELContext(), null, expression, newValue);
        }
    }
    
    /**
     * Returns the class type of the binding of the value expression of a component
     * @param valueHolder
     * @return
     */
    public static Class getTypeOfValueBinding(UIComponent valueHolder) {
        String expression = valueHolder.getValueBinding("value").getExpressionString();
        // we need to remove "#{" and "}".
        String exprWithoutRegSigns = expression.substring(2, expression.length() - 1);
        String subExpression = exprWithoutRegSigns.substring(0, exprWithoutRegSigns.lastIndexOf("."));
        Object mainBinding = FacesUtil.resolveExpression("#{"+subExpression+"}");
        Field f = ReflectionHelper.getField(mainBinding, exprWithoutRegSigns.substring(exprWithoutRegSigns.lastIndexOf(".")+1));
        if(f == null) {
            return null;
        }
        return f.getType();
    }

    /**
     * Convenience method for setting the value of a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @param newValue new value to set
     */
    public static void setManagedBeanValue(String beanName, 
                                           Object newValue) {
        //              StringBuffer buff = new StringBuffer("#{");
        //              buff.append(beanName);
        //              buff.append("}");
        //              setExpressionValue(buff.toString(), newValue);
        setExpressionValue(beanName, newValue);
    }


    /**
     * Convenience method for setting Session variables.
     * @param key object key
     * @param object value to store
     */
    public static  void storeOnSession(String key, Object object) {
    
      FacesContext ctx = getFacesContext();
      Map sessionState = ctx.getExternalContext().getSessionMap();
      sessionState.put(key, object);
    }

    /**
    * Convenience method for getting Process variables.
    * @param key object key
    * @return process scope object for key
    */
    public static Object getFromProcessScope(String key) {
        Map<String, Object> processScope = FacesUtil.getProcessScope();
        return processScope.get(key);        
    }
    
    /**
    * Convenience method for setting Process variables.
    * @param key object key
    * @param object value to store
    */
    public static void storeOnProcessScope(String key, Object object) {
        Map<String, Object> processScope = FacesUtil.getProcessScope();
        processScope.put(key,object);        
    }
    
    public static void removeFromProcessScope(String key) {
        Map<String, Object> processScope = FacesUtil.getProcessScope();
        processScope.remove(key);        
    }   
    
    public static void removeFromProcessScope(String[] processScopeVariables) {
        if (processScopeVariables != null) {
                Map<String, Object> processScope = FacesUtil.getProcessScope();
            for (String processScopeVariable : processScopeVariables) {
                Object v = processScope.remove(processScopeVariable);
                if (null != v){
                    v = null;//dereference
                }
            }
        }
    }   

    /**
     * Convenience method for getting Session variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromSession(String key) {
      FacesContext ctx = getFacesContext();
      Map sessionState = ctx.getExternalContext().getSessionMap();
      return sessionState.get(key);
    }
    
    public static Map getSessionScope() {
        return getFacesContext().getExternalContext().getSessionMap();
    }
    
    public static Map getRequestScope() {
        return getFacesContext().getExternalContext().getRequestMap();
    }
    
    public static Map getProcessScope() {
//        return RequestContext.getCurrentInstance().getPageFlowScope();
return null;
    }
    
    public static Map getApplicationScope() {
        return getFacesContext().getExternalContext().getApplicationMap();
    }
    
    public static void storeOnApplicationScope(String key, Object object) {
    
      FacesContext ctx = getFacesContext();
      Map applicationMap = ctx.getExternalContext().getApplicationMap();
      applicationMap.put(key, object);
    }
    
    public static Object getFromApplicationScope(String key) {
      FacesContext ctx = getFacesContext();
      Map applicationMap = ctx.getExternalContext().getApplicationMap();
      return applicationMap.get(key);
    }

    /**
     * Pulls a String resource from the property bundle that
     * is defined under the application &lt;summary-bundle&gt; element in
     * the faces config. Respects Locale
     * @param key string summary key
     * @return Resource value or placeholder error String
     */
    public static String getStringFromBundle(String key) {
      ResourceBundle bundle = getBundle();
      return getStringSafely(bundle, key, null);
    }


    /**
     * Convenience method to construct a <code>FacesMesssage</code>
     * from a defined error key and severity
     * This assumes that the error keys follow the convention of
     * using <b>_detail</b> for the detailed part of the
     * message, otherwise the main summary is returned for the
     * detail as well.
     * @param key for the error summary in the resource bundle
     * @param severity severity of summary
     * @return Faces Message object
     */
    public static FacesMessage getMessageFromBundle(String key, 
                                                    FacesMessage.Severity severity) {
      ResourceBundle bundle = getBundle();
      String summary = getStringSafely(bundle, key, null);
      String detail = getStringSafely(bundle, key + "_detail", summary);
      FacesMessage message = new FacesMessage(summary, detail);
      message.setSeverity(severity);
      return message;
    }
    
    public static String getResource(String key){
        ResourceBundle bundle = getBundle();
        String resource = null;
        try {
          resource = bundle.getString(key);
        } catch (MissingResourceException mrex) {
            return null;
        }
        return resource;
    }
    
    public static void addFacesErrorMessage(String msg, Exception ex) {
    
        if(null != msg){
            msg=  getResource(msg);
        }
        
            FacesContext ctx = getFacesContext();
            FacesMessage fm;
            if (ex instanceof WorkflowException)
                    if (ex.getCause() != null && ex.getCause() instanceof WorkflowException)
                            fm = 
    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ((WorkflowException)ex).getErrorCode() +
                                                                    ": " + ((WorkflowException)ex.getCause()).getDescription());
                    else
                            fm = 
    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ((WorkflowException)ex).getErrorCode() +
                                                                    ": " + ((WorkflowException)ex).getDescription());
            else
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ex.getMessage());
            ctx.addMessage(getRootViewComponentId(), fm);
    }

    public static void addInfoMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = getMessageFromBundle(msg,FacesMessage.SEVERITY_INFO);
        String id = getRootViewComponentId();
        ctx.addMessage(id,fm);
    }
    
    public static void addWarnMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = getMessageFromBundle(msg,FacesMessage.SEVERITY_WARN);
        String id = getRootViewComponentId();
        ctx.addMessage(id,fm);
    }
    
    public static void addFacesErrorMessage(OutputType outputType) {
        if(null == outputType.getErrors()){
            //do nothing   
        }else{
            ArrayList<SystemMessage> sysMessages = new ArrayList<SystemMessage>();
            sysMessages.addAll(outputType.getErrors());
            addFacesErrorMessage(sysMessages);
        }
    }
    
    public static void addFacesSeverityMessage(FacesMessage.Severity severity,OutputType outputType) {
        if(null == outputType.getErrors()){
            //do nothing   
        }else{
            ArrayList<SystemMessage> sysMessages = new ArrayList<SystemMessage>();
            sysMessages.addAll(outputType.getErrors());
            addFacesMessage(severity,sysMessages);
        }
    }
    
    public static void addFacesMessage(FacesMessage.Severity severity,List<SystemMessage> systemMessages) {
        for(int m=0; m < systemMessages.size(); m++){
          addFacesMessage(severity,systemMessages.get(m));
        }
    }
    
    public static void addFacesErrorMessage(List<SystemMessage> systemMessages) {
        for(int m=0; m < systemMessages.size(); m++){
          addFacesErrorMessage(systemMessages.get(m));
        }
    }
    
    public static void addFacesMessage(FacesMessage.Severity severity,SystemMessage message){
        
        FacesContext ctx = getFacesContext();
        String messageKeyValue = null;
        if(message == null){
            //do nothing
        }else{
            if(message.getMessage() != null){
                messageKeyValue = parseMessageKeyValue(message.getMessage());
                FacesMessage fm = createFacesMessage(severity,message.getCode(),messageKeyValue);
                ctx.addMessage(getRootViewComponentId(),fm);
            }
        }
    }

    public static void addFacesErrorMessage(SystemMessage message){
        
        FacesContext ctx = getFacesContext();
        String messageKeyValue = null;
        if(message == null){
            //do nothing
        }else{
            if(message.getMessage() != null){
                messageKeyValue = parseMessageKeyValue(message.getMessage());
                addFacesErrorMessageForValidation(message.getCode(),messageKeyValue);
            }
        }
    }
    public static void addFacesInfoMessageForType(String clientId,OutputType outputType) {
        if(null == outputType.getErrors()){
            //do nothing
        }else{
            for(int m=0; m < outputType.getErrors().size(); m++){
               SystemMessage message = outputType.getErrors().get(m);
                FacesContext ctx = getFacesContext();
                String messageKeyValue = null;
                if (null == message) {
                } else 
                    if(null != message.getMessage()){
                        String[] messageKey = formatAsStringArray(message.getMessage(),"?");
                        messageKeyValue = getStringFromBundle(messageKey[0]);
                        int pos = 0;
                        for(int i=1; i<messageKey.length; i++){
                           pos = i-1; // holds the real position of the token key
                           messageKeyValue = messageKeyValue.replace("{"+pos+"}",messageKey[i]);
                        }
                        addFacesInfoMessage(clientId,message.getCode(),messageKeyValue);
                    }else{
                        addFacesInfoMessage(null,WebConstants.Messages.INVALID_BPEL_REPLY);
                    }
            }
        }
    }
    
    /**
     * 
     * @param clientId
     * @param msg
     * @param detail
     * @param values
     */
    public static void addFacesInfoMessage(String clientId,String msg, String detail, Object[] values) {
        FacesContext ctx = getFacesContext();
            
        FacesMessage fm = null;
        String realMsg = getStringFromBundle(msg, values);
        if(realMsg != null && realMsg.equals(""))
            realMsg = null;
        String realDetail = getStringFromBundle(detail, values);
        if(realDetail != null && realDetail.equals(""))
            realDetail = null;

        fm = new FacesMessage(FacesMessage.SEVERITY_INFO,  
            realMsg, realDetail);
        if(fm != null)
            ctx.addMessage(clientId, fm);
         
    }
    
    /**
     * Add JSF error summary.
     * @param msg error summary string
     */
    public static void addFacesErrorMessage(String msg) {
      FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, getStringFromBundle(msg) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }
    
    /**
     * Add JSF error summary.
     * @param msg error summary string
     */
    public static void addFacesErrorMessage(String msg, Object[] params) {
      FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, getStringFromBundle(msg, params) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }
    
    public static void addFacesInfoMessage(String msg) {
      FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, getStringFromBundle(msg) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }
    public static void addFacesInfoMessageWithParams(String msg, Object[] params) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, getStringFromBundle(msg, params) ,null);
        ctx.addMessage(getRootViewComponentId(),fm);
      }
    
    public static void concatFacesErrorMessage(List<String> msgs) {
        concatFacesErrorMessage(msgs, null);
    }

    public static void concatFacesErrorMessage(List<String> msgs, Object[] params) {
      FacesContext ctx = getFacesContext();
      String errorMsg = "";
      for(String msg: msgs){
          errorMsg = errorMsg +" "+ getStringFromBundle(msg);
      }
      FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, replaceParamsInString(errorMsg, params) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }
    
    public static void addFacesErrorMessage(TripsValidationException ex) {
        if(ex.getMessage() != null) {
            FacesContext ctx = getFacesContext();
              FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                getStringFromBundle(ex.getMessage(), ex.getMessageParameters()) ,null);
            ctx.addMessage(getRootViewComponentId(),fm);            
        }
    }
    
    /**
     * Add JSF error summary.
     * @param msg error summary string
     */
    public static void addFacesErrorMessage(String msg, String detail, String clientId) {
      FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, detail);
      ctx.addMessage(clientId,fm);
    }

    public static void addFacesInfoMessage(String msg, String detail) {
            FacesContext ctx = getFacesContext();
            FacesMessage fm = null;
            
            fm = createFacesMessage(FacesMessage.SEVERITY_INFO, msg, detail);
            ctx.addMessage(getRootViewComponentId(), fm);
    }
    
    public static void addFacesMessage(FacesMessage.Severity severity, String msg, String detail,Object[] args) {
        addFacesMessage(severity, null,  msg,  detail,args);
    }
    
    public static void addFacesMessage(FacesMessage.Severity severity,String clientID, String msg, String detail,Object[] args) {
            FacesContext ctx = getFacesContext();
            FacesMessage fm = null;
            detail = parseMessageKeyValue(detail + toParseFormat(args));
            fm = new FacesMessage(severity, getStringFromBundle(msg), detail);;
            if(null == clientID){
                ctx.addMessage(getRootViewComponentId(), fm);
            }else{
                ctx.addMessage(clientID, fm);
            }
    }
    
    public static String toParseFormat(Object[] args){
        if(null == args) return null;
        
        StringBuilder strBuilder = new StringBuilder();
            for(Object obj : args){
                strBuilder.append("?");
                strBuilder.append(String.valueOf(obj));
            }
        return strBuilder.toString();    
    }
    
    /**
     * Creates the faces message. First it searches every parameter in the bundle, if it cannot find the parameter in the bundle,
     * it uses the actual parameter. There are four cases:
     * 
     * <p>
     * detail != null && msg != null 
     * <p>
     * new FacesMessage(severity, msg, detail);
     * 
     * <p>
     * detail != null && msg= null
     * <p>
     * new FacesMessage(severity, detail, null);
     * 
     * <p>
     * detail == null && msg != null
     * <p>
     * new FacesMessage(severity, msg, detail);
     * 
     * <p>
     * detail == null && msg == null
     * <p>
     * null
     * 
     * @param severity 
     * @param detail
     * @param msg
     * @return
     */
    public static FacesMessage createFacesMessage(
        javax.faces.application.FacesMessage.Severity severity, String msg, String detail) {
        
        String realMsg = null, realDetail = null;
        if(msg != null  && !msg.equals("")) {
            realMsg = getStringFromBundle(msg);
        }
        if(realMsg == null  || realMsg.startsWith(NO_RESOURCE_FOUND))
            realMsg = msg;

        if(detail != null && !detail.equals("")) {
            try{
                realDetail = getStringFromBundle(detail);
            }catch(Exception ex){
                //log.error(ex.getLocalizedMessage(), ex);
                //do nothing just return the key
            }
        }
        if(realDetail == null || realDetail.startsWith(NO_RESOURCE_FOUND))
            realDetail = detail;
        
        if(realDetail != null && realMsg == null) {
            return new FacesMessage(severity, realDetail, null);
        }
        else if(realMsg != null || realDetail != null){
            return new FacesMessage(severity, realMsg, realDetail);
        }
        return null;
    }
    
    public static void addFacesInfoMessage(String clientId,String msg, String detail) {
            FacesContext ctx = getFacesContext();
            FacesMessage fm = null;
            
            fm = createFacesMessage(FacesMessage.SEVERITY_INFO, msg, detail);
            if(fm != null)
                ctx.addMessage(clientId, fm);
    }
    
    /**
     * Add JSF error summary for a specific attribute.
     * @param attrName name of attribute
     * @param msg error summary string
     */
    public static void addFacesErrorMessage(String attrName, 
                                            String msg) {
      // TODO: Need a way to associate attribute specific messages
      //       with the UIComponent's Id! For now, just using the view id.
      //TODO: make this use the internal getMessageFromBundle?
       FacesContext ctx = getFacesContext();        
       FacesMessage fm =  new FacesMessage(FacesMessage.SEVERITY_ERROR,getStringFromBundle(attrName),getStringFromBundle(msg));
       ctx.addMessage(getRootViewComponentId(),fm);
    }
    
    public static void addFacesErrorMessageForValidation(String msg, 
                                                String detail) {
           FacesContext ctx = getFacesContext();        
           FacesMessage fm = createFacesMessage(FacesMessage.SEVERITY_ERROR,msg,detail);
           ctx.addMessage(getRootViewComponentId(),fm);
    }

    
    public static void addFacesErrorMessage(ArrayList<String> facesMessages) {
        FacesContext ctx = getFacesContext();  
        for(String fm: facesMessages){
            addFacesErrorMessage(fm);
        }
    }
    
    public static void addFacesErrorMessageList(ArrayList<FacesMessage> facesMessages) {
        FacesContext ctx = getFacesContext();  
        for(FacesMessage fm: facesMessages){
            ctx.addMessage(getRootViewComponentId(),fm);
        }
    }
    
    
    // Informational getters

    /**
     * Get view id of the view root.
     * @return view id of the view root
     */
    public static String getRootViewId() {
       return getFacesContext().getViewRoot().getViewId();
     }

    /**
     * Get component id of the view root.
     * @return component id of the view root
     */
    public static String getRootViewComponentId() {
       return getFacesContext().getViewRoot().getId();
     }

    /**
     * Get FacesContext.
     * @return FacesContext
     */
    public static FacesContext getFacesContext() {
       return FacesContext.getCurrentInstance();
     }
    

    /*
     * Internal method to pull out the correct local
     * message bundle
     */
    private static ResourceBundle getBundle() {
      FacesContext ctx = getFacesContext();
      ClassLoader ldr = Thread.currentThread().getContextClassLoader();
      Locale locale = ctx.getViewRoot().getLocale();
      return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), 
                                      locale,ldr);
    }

    /**
     * Get an HTTP Request attribute.
     * @param name attribute name
     * @return attribute value
     */
    public static Object getRequestAttribute(String name) {
      return getFacesContext().getExternalContext().getRequestMap().get(name);
    }

    /**
     * Set an HTTP Request attribute.
     * @param name attribute name
     * @param value attribute value
     */
    public static void setRequestAttribute(String name, Object value) {
      getFacesContext().getExternalContext().getRequestMap().put(name,value);
    }

    /*
     * Internal method to proxy for resource keys that don't exist
     */

    private static String getStringSafely(ResourceBundle bundle, String key, 
                                          String defaultValue) {
      String resource = null;
      try {
        resource = key != null ? bundle.getString(key.trim()) : "";
      } catch (MissingResourceException mrex) {
        if (defaultValue != null) {
          resource = defaultValue;
        } else {
          resource = NO_RESOURCE_FOUND + key;
        }
      }
      return resource;
    }
    
    /**
     * Uses the CodeAndDescription interface
     * @param aList
     * @return
     */
    public static List<SelectItem> convertToSelectItems(List<CodeAndDescription> aList) {
        List<SelectItem> selectItems = null;
        if(null == aList)
            return null;
        else{
             selectItems = new ArrayList<>(aList.size()+1);
            for (CodeAndDescription cad : aList) {
                // Filter out items that have been created but are both null
                if ((null != cad.getCode()) && (null != cad.getDescription()))
                    selectItems.add(new SelectItem(cad.getCode(), cad.getDescription()));
//                    log.debug("ADD!");
            }
            
            return selectItems;
        }
    }
    
    /**
     * Uses the CodeAndDescription interface
     * @param aList
     * @return
     */
    public static List<SelectItem> convertPojoAndDescriptionToSelectItems(List<BaseRefModelObject> aList, String descriptionFieldName) {
        List<SelectItem> selectItems = null;
        if(null == aList)
            return null;
        else{
             selectItems = new ArrayList<>(aList.size());
             if(descriptionFieldName == null) {
                 descriptionFieldName = "description";
             }
            for (BaseRefModelObject cad : aList) {
                // Filter out items that have been created but are both null
                String description = null;
                try {
                    description = (String)ReflectionHelper.invokeGetter(cad, descriptionFieldName);
                } catch (NoSuchMethodException e) {
                    log.error(e.getLocalizedMessage(), e);
                }
                if (null != cad && null != description)
                    selectItems.add(new SelectItem(cad, description));
            }
            
            return selectItems;
        }
    }
    
    /**
     * Uses the CodeAndDescription interface
     * @param aList
     * @return
     */
    public static List<SelectItem> convertToSelectItemsUseCodeOnly(List<CodeAndDescription> aList) {
        List<SelectItem> selectItems = null;
        if(null == aList)
            return null;
        else{
             selectItems = new ArrayList<>(aList.size());
            for (CodeAndDescription cad : aList) {
                // Filter out items that have been created but are both null
                if (null != cad.getCode())
                    selectItems.add(new SelectItem(cad.getCode(), cad.getCode().toString()));
            }
            
            return selectItems;
        }
    }
    
    public static List<SelectItem> convertToSelectItemsUseCodeDescTogether(List<CodeAndDescription> aList,boolean isCodeAfterDesc) {
        return convertToSelectItemsUseCodeDescTogether(aList,isCodeAfterDesc,null);
//        List<SelectItem> selectItems = null;
//        if(null == aList)
//            return null;
//        else{
//            selectItems = new ArrayList<SelectItem>(aList.size());
//            Iterator i = aList.iterator();
//            while(i.hasNext()){
//                CodeAndDescription cad = (CodeAndDescription)i.next();
//                // Filter out items that have been created but are both null
//                if ((null != cad.getCode()) && (null != cad.getDescription())){
//                    if(isCodeAfterDesc)
//                        selectItems.add(new SelectItem(cad.getCode(),cad.getDescription() + "   " + cad.getCode()));
//                    else
//                        selectItems.add(new SelectItem(cad.getCode(),cad.getCode() + "   " + cad.getDescription()));
//                }
//            }
//            
//            return selectItems;
//        }
    }
    
    public static List<SelectItem> convertToSelectItemsUseCodeDescTogether(List<CodeAndDescription> aList,boolean isCodeAfterDesc,String delimiter) {
        List<SelectItem> selectItems = null;
        if(null == aList)
            return null;
        else{
            selectItems = new ArrayList<>(aList.size());
            for (CodeAndDescription cad : aList) {
                // Filter out items that have been created but are both null
                if ((null != cad.getCode()) && (null != cad.getDescription())){
                    if(delimiter == null){
                        delimiter = "   ";
                    }
                    if(isCodeAfterDesc)
                        selectItems.add(new SelectItem(cad.getCode(),cad.getDescription() + delimiter + cad.getCode()));
                    else
                        selectItems.add(new SelectItem(cad.getCode(),cad.getCode() + delimiter + cad.getDescription()));
                }
            }
            
            return selectItems;
        }
    }
    
    public static List<SelectItem> convertToCodeAndShortDesc(List<CodeAndDescription> aList,boolean isCodeAfterDesc,String delimiter) {
        
        List<SelectItem> selectItems = null;
        if(null == aList)
            return null;
        else{
            selectItems = new ArrayList<>(aList.size());
            Iterator i = aList.iterator();
            String subDesc;
            while(i.hasNext()){
                CodeAndDescription cad = (CodeAndDescription)i.next();
                // Filter out items that have been created but are both null
                if ((null != cad.getCode()) && (null != cad.getDescription())){
                    if(delimiter == null){
                        delimiter = "   ";
                    }
                    subDesc = cad.getDescription();
                    if (subDesc.length()>30) {
                        subDesc = subDesc.substring(0,30) + "...";
                    }
                    if(isCodeAfterDesc)
                        selectItems.add(new SelectItem(cad.getCode(),subDesc + delimiter + cad.getCode()));
                    else
                        selectItems.add(new SelectItem(cad.getCode(),cad.getCode() + delimiter + subDesc));
                }
            }
            
            return selectItems;
        }
    }

    /**
     * Converts the collection to a select item list by using the objects as the value of a select item.
     * The label for the select item is provided by using the descriptionmethod
     * 
     * @param aCollection
     * @param descriptionMethod
     * @return
     */
    public static Collection<SelectItem> convertToSelectItemsObjectsAsValue(Collection aCollection, String descriptionMethod) {
                                                  
        return convertToSelectItems(aCollection,null,descriptionMethod,false);                                            
    }
    
    
    public static Collection<SelectItem> convertToSelectItems(Collection aCollection, 
                                                  String methodCode, 
                                                  String methodDescription) {
                                                  
        return convertToSelectItems(aCollection,methodCode,methodDescription,false);                                            
    }
    
    /**
     * Uses this methodA and methodB for the code and value respectively.
     * <p>
     * Invoke the getters on this methodCode and this methodDescripion
     * if the object type is not know.
     * @param aCollection
     * @param methodCode
     * @param methodDescription
     * @param addIndex
     * @return
     */
    public static Collection<SelectItem> convertToSelectItems(Collection aCollection, 
                                                  String methodCode, 
                                                  String methodDescription,boolean addIndex) {
        
        
        
        
        try {
            Collection<SelectItem> selectItems = null;
            if(null == aCollection)
                return Collections.emptyList();
            else{
                 selectItems = new ArrayList<>(aCollection.size());
                Iterator i = aCollection.iterator();
                int cnt = 0;
                while(i.hasNext()){
                    Object obj = i.next();
                    
                    Object methodDescriptionValue = ReflectionHelper.invokeGetter(obj,methodDescription);
                    
                    SelectItem item =null;
                    Object methodCodeValue = null;
                    if(methodCode != null) {
                        methodCodeValue = ReflectionHelper.invokeGetter(obj,methodCode);
                        if(addIndex)
                            item = new SelectItem(cnt,String.valueOf(methodCodeValue), String.valueOf(methodDescriptionValue));
                        else
                            item = new SelectItem(String.valueOf(methodCodeValue), String.valueOf(methodDescriptionValue));
                    }else {
                        //No value supplied for code method, then set object itself as the code value
                        item = new SelectItem(obj, String.valueOf(methodDescriptionValue));
                    }
                    
                    selectItems.add(item);
                    cnt++;
                }
                
                return selectItems;
            }
        }
        catch (NoSuchMethodException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        
        return Collections.emptyList();
    }

    public static Object removeFromSession(String sessionVariable) {
       return FacesUtil.getFacesContext().getExternalContext().getSessionMap().remove(sessionVariable);
    }
    
    public static void removeFromSessionAllBackingBean() {
            Map<String, Object> sessionMap = FacesUtil.getFacesContext().getExternalContext().getSessionMap();
            Set<String> keySet = sessionMap.keySet();
            if(keySet!=null) {
                keySet.stream().forEach((key) -> {
                    Object obj = sessionMap.get(key);
                    if (obj instanceof BackingBase) {
                        if (obj.getClass().isAnnotationPresent(SessionWorker.class)) {
                            sessionMap.remove(key);
                            System.out.println("["+key+"] : ["+obj.toString()+"] removed from scope");
                        }
                    }
                });
            }
    }
    

    public static void removeFromSession(String[] sessionScopeVariables) {
        if (sessionScopeVariables != null) {
            for (String sessionScopeVariable : sessionScopeVariables) {
                Object v = FacesUtil.removeFromSession(sessionScopeVariable);
                if (null != v){
                    v = null;//dereference
                }
            }
        }
    }

    public static void storeOnRequestScope(String key, 
                                           Object value) {
        FacesUtil.getFacesContext().getExternalContext().getRequestMap().put(key,value);    
    }

    public static Object getFromRequest(String key) {
       return FacesUtil.getFacesContext().getExternalContext().getRequestMap().get(key);
    }

    public static void addAllPartialTargets(UIComponent component, String[] componentIds) {
        RequestContext adfContext = RequestContext.getCurrentInstance();
        for (String componentId : componentIds) {
            UIComponent target = component.findComponent(componentId);
            if(null != target){
//                adfContext.addPartialTarget(target);
            }
        }
    }


    private static String[] formatAsStringArray(String literal, 
                                                String pattern) {
        return literal.split(Pattern.quote(pattern));
        //              // find the token ?
        //              StringTokenizer st = new StringTokenizer(literal,pattern);
        //              List<String> stringList = new ArrayList<String>();
        //              while (st.hasMoreTokens()){///start while loop
        //                      stringList.add(st.nextToken());
        //              }//end while loop
        //              Pattern sd = null;
        //
        //              //return array of token values
        //              return stringList.toArray(new String[st.countTokens()]);
    }


        public static String lookupManagedBeanName(Object bean) {
               ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

               // Get requestmap.
               Map<String, Object> requestMap = externalContext.getRequestMap();
           
               // Lookup the current bean instance in the request scope.
               for (String key : requestMap.keySet()) {
                   if (bean.equals(requestMap.get(key))) {
                       // The key is the managed bean name.
                       return key;
                   }
               }
           
               // Bean is not in the request scope. Get the sessionmap then.
               Map<String, Object> sessionMap = externalContext.getSessionMap();

               // Lookup the current bean instance in the session scope.
               for (String key : sessionMap.keySet()) {
                   if (bean.equals(sessionMap.get(key))) {
                       // The key is the managed bean name.
                       return key;
                   }
               }

               // Bean is also not in the session scope. Get the applicationmap then.
               Map<String, Object> applicationMap = externalContext.getApplicationMap();

               // Lookup the current bean instance in the application scope.
               for (String key : applicationMap.keySet()) {
                   if (bean.equals(applicationMap.get(key))) {
                       // The key is the managed bean name.
                       return key;
                   }
               }

               // Bean is also not in the application scope.
               // Is the bean's instance actually a managed bean instance then? =)
               return null;
           }
    
    /**
     * Refreshes table and clears the selection.
     * 
     * @param table
     */
    public static void refreshTable(DataTable table){     
//        if(table.getSelectionState() != null) {
//            table.getSelectionState().clear();
//            table.setFirst(0);
//        }
//        RequestContext.getCurrentInstance().addPartialTarget(table);
    }  
    
    /**
     * Navigates to the given url.
     * 
     * @param nextPageUrl the page url that will be navigated
     */
    public static void navigate(String nextPageUrl) {
    
        FacesContext ctx = FacesContext.getCurrentInstance();
        ViewHandler vh = ctx.getApplication().getViewHandler();  
//        NavigationHandler nh =  ctx.getApplication().getNavigationHandler();
//        nh.handleNavigation(ctx, null, nextPageUrl);
        UIViewRoot previousViewRoot = vh.createView(ctx,nextPageUrl);
        ctx.setViewRoot(previousViewRoot);
        FacesContext.getCurrentInstance().renderResponse();
    }

    /**
     * Navigates to the url that this navigation string belongs to
     * @param navigationString the navigation string that is defined faces-config.
     */
    public static void navigateViaNavigationString(String navigationString) {
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler nh = context.getApplication().getNavigationHandler();
        nh.handleNavigation(context, null, navigationString);
    }
    /**
     * 
     * @param msg
     * @param detail
     * @param values
     */
    public static void addFacesInfoMessage(String msg, String detail, Object[] values) {
        FacesContext ctx = getFacesContext();
        String messageKeyValue = getStringFromBundle(msg, values);
            
        FacesMessage fm = null;
        
        fm = new FacesMessage(FacesMessage.SEVERITY_INFO,  messageKeyValue, detail);
        if(fm != null)
            ctx.addMessage(getRootViewComponentId(), fm);
         
    }  
    
    public static String getStringFromBundle(String msg, Object[] values) {
        String messageKeyValue = getStringFromBundle(msg);
        return replaceParamsInString(messageKeyValue, values);
    }
    
    public static String replaceParamsInString(String messageKeyValue, Object[] values) {
        return StringHelper.replaceParamsInString(messageKeyValue,values);
    }
    
    
    public static void addSetActionListenerToActionSource(
        String setActionListenerFrom,
        String setActionListenerTo, ActionSource source) {
        
        
//        SetActionListener setActionListener = new SetActionListener();
////        ValueBinding fromVB = 
////            FacesContext.getCurrentInstance().getApplication().createValueBinding(setActionListenerFrom);
////        setActionListener.setValueBinding(SetActionListener.FROM_KEY, fromVB);
////        ValueBinding toVB = 
////            FacesContext.getCurrentInstance().getApplication().createValueBinding(setActionListenerTo);
////        setActionListener.setValueBinding(SetActionListener.TO_KEY, toVB);
//        
//        FacesContext ctx = getFacesContext(); 
//        Object fromVB = ctx.getELContext().getELResolver().getValue(ctx.getELContext(), null, setActionListenerFrom);
//        setActionListener.setFrom(fromVB);
//
//        setActionListener.setValueExpression(setActionListenerTo, getValueExpression(setActionListenerTo));
//        
//        source.addActionListener(setActionListener);     
    }
    
    public static void refreshCurrentPage() {
        String currentViewId = getRootViewId();
        ViewHandler vh = FacesContext.getCurrentInstance().getApplication().getViewHandler();
        UIViewRoot x = vh.createView(FacesContext.getCurrentInstance(), currentViewId);   
        x.setViewId(currentViewId);
        FacesContext.getCurrentInstance().setViewRoot(x);        
    }

    public static void addFacesErrorMessages(ArrayList<String> mgs) {
       if(null != mgs){
           for(String msg:mgs){
               addFacesErrorMessage(msg);
           }
       }
    }
    
    public static void cleanUpSystem() {
        /*
         * Kills all backing beans on session scope
         */
        Map sessionMap = FacesUtil.getFacesContext().getExternalContext().getSessionMap();
        BackingSessionManager sessionManager = (BackingSessionManager)sessionMap.get(WebConstants.ManagedBean.BACKING_SESSION_MANAGER);
    
        if(null != sessionManager){
                sessionManager.cleanUpSystem();
        }
    }
    
    public static UIViewRoot getViewRoot(String viewId) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ViewHandler vh = ctx.getApplication().getViewHandler();
        UIViewRoot previousViewRoot = vh.createView(ctx, viewId);
        return previousViewRoot;
    }
    public static UIComponent createComponent(String componentType) {
        return FacesContext.getCurrentInstance().getApplication().createComponent(componentType);
    }
    
    public static Column createColumn(String headerText, String valueBinding, String componentType) {
        Column column = new Column();
//        ValueBinding valueBindingRole = FacesUtil.getFacesContext().getApplication().createValueBinding(
//            headerText);
//        column.setValueBinding("headerText", valueBindingRole);
//        UIXValue output = (UIXValue)FacesUtil.createComponent(componentType);
//        ValueBinding value = FacesUtil.getFacesContext().getApplication().createValueBinding(
//            valueBinding);
//        output.setValueBinding("value", value);
//        column.getChildren().add(output);
//        return column;
        
        FacesContext ctx = getFacesContext();
        Class headerClass = ctx.getELContext().getELResolver().getType(ctx.getELContext(), null, headerText);
        ValueExpression headerExpr = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), headerText, headerClass);			 
        column.setValueExpression("headerText", headerExpr);

        Class valueClass = ctx.getELContext().getELResolver().getType(ctx.getELContext(), null, valueBinding);
        ValueExpression valueExpr = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), valueBinding, valueClass);
        column.setValueExpression("value", valueExpr);

        UIComponent output = (UIComponent)FacesUtil.createComponent(componentType);
        column.getChildren().add(output);
        return column;
        
    }
    
    
    public static void openPopup(String url, CommandButton button, int windowWidth, int windowHeight) {
            Map params = new HashMap();
            FacesUtil.openPopup(url, button, windowWidth, windowHeight, params);

    }

    public static void openPopup(String url, CommandButton button, int windowWidth, int windowHeight, Map parameters) {
            RequestContext actx = RequestContext.getCurrentInstance();
            FacesContext ctx = FacesContext.getCurrentInstance();
            ViewHandler vh = ctx.getApplication().getViewHandler();    
            String a = url;
            UIViewRoot myViewRoot = vh.createView(ctx,a);
            Map<String,Object> windowProperties = new HashMap();
            windowProperties.put("width", windowWidth);
            windowProperties.put("height", windowHeight);
//            actx. launchDialog(myViewRoot, parameters, button, true, windowProperties);
            
            actx.openDialog(url, windowProperties, null);
    }
    
    /**
     * Finds the selected rows and returns them in a list. (Used for tableselectmany.)
     * 
     * @param table
     * @return selected rows
     */
     public static List getSelectedListInTable(DataTable table) {
         //to:do:currently commented for testing for 11g migration
         // Set selectedSet = table.getSelectionState().getKeySet();
         //              Set selectedSet = new HashSet();
         //              List wholeList = null;
         //              if(table.getValue() instanceof List) {
         //                      wholeList = (List)table.getValue();
         //              }
         //              else if(table.getValue() instanceof SortableModel) {
         //                      SortableModel model = (SortableModel)table.getValue();
         //                      wholeList = (List)model.getWrappedData();
         //              }
         //              Iterator itr = selectedSet.iterator();
         //              List selectedList = new ArrayList();
         //              while(itr.hasNext()) {
         //                      Object indexObj = itr.next();
         //                      Integer index = null;
         //                      try {
         //                              index = new Integer(indexObj.toString());
         //                      }
         //                      catch(Exception e) {
         //                              continue;
         //                      }
         //                      selectedList.add(wholeList.get(index));
         //              }
         //              return selectedList;
//         Set selectedSet = table.getSelectedRowKeys();
//         List wholeList = null;
//         if(table.getValue() instanceof List) {
//                 wholeList = (List)table.getValue();
//         }
//         else if(table.getValue() instanceof SortableModel) {
//                 SortableModel model = (SortableModel)table.getValue();
//                 wholeList = (List)model.getWrappedData();
//         }
//
//         Iterator itr = selectedSet.iterator();
         List selectedList = new ArrayList();
//         while(itr.hasNext()) {
//                 Object indexObj = itr.next();
//                 Integer index = null;
//                 try {
//                         index = new Integer(indexObj.toString());
//                 }
//                 catch(Exception e) {
//                         continue;
//                 }
//                 selectedList.add(wholeList.get(index));
//         }
         return selectedList;

     }
     
     public static List<Integer> getSelectionIndex(DataTable table) {
         //to:do:currently commented for testing for 11g migration
         //Iterator itr = table.getSelectionState().getKeySet().iterator();
         //              Iterator itr = table.getChildren().iterator();
         //              List<Integer> selectedList = new ArrayList<Integer>();
         //              while(itr.hasNext()) {
         //                      Object indexObj = itr.next();
         //                      Integer index = null;
         //                      try {
         //                              index = new Integer(indexObj.toString());
         //                      }
         //                      catch(Exception e) {
         //                              continue;
         //                      }
         //                      selectedList.add(index);
         //              }
         //              return selectedList;


//         Iterator selection = table.getSelectedRowKeys().iterator();
//         Object oldKey = table.getRowKey();
         List<Integer> selectedList = new ArrayList<>();
         Integer index = null;

//         while(selection.hasNext())
//         {
//                 Object rowKey = selection.next();
//                 table.setRowKey(rowKey);
//
//                 try {
//                         index = new Integer(table.getRowIndex());
//                 }
//                 catch(Exception e) {
//                         continue;
//                 }
//                 selectedList.add(index);
//         }
//         // restore the old key:
//         table.setRowKey(oldKey);

         return selectedList;            
     }
     
    /**
     * Chooses the selection list within the table.(Used for tableselectmany.) Requires "id" attribute in the object representing the row.
     * 
     * @param wholeList
     * @param selectedList
     * @param table
     */
    public static void chooseSelectedListInTable(List wholeList, List selectedList, DataTable table) {
//        RowKeySetImpl rowKeySet = new RowKeySetImpl();
//        table.setSelectedRowKeys(null);
//        if(wholeList == null || selectedList == null)
//            return;
//        int listIndex = 0;
//        for (Object obj: wholeList) {
//            if (selectedList.contains(obj)) {
//                rowKeySet.add(String.valueOf(listIndex));
//            }
//            else {
//                // the objects can have different references but should be selected, so we should look at the primary keys
//                // in order to find the related object.
//                for(Object selectedObj: selectedList) {
//                    Object selectedId = null;
//                    Object id = null;
//                    try {
//                        selectedId = ReflectionHelper.getFieldValue(selectedObj, "id");
//                        id = ReflectionHelper.getFieldValue(obj, "id");
//                    } catch (NoSuchMethodException e) {
//                        continue;
//                    }
//                    if(id == null || selectedId == null)
//                        continue;
//                    if(selectedId.toString().equals(id.toString())) {
//                        rowKeySet.add(String.valueOf(listIndex));
//                        break;
//                    }
//                }
//            }
//            listIndex++;
//        }
////        table.getSelectedRowKeys(rowKeySet);
//        table.setRowKey(rowKeySet);
    }
        
    public static void setAlphanumericStringConverterAndScripts(UIComponent facesComp) { 
            facesComp.getAttributes().put("onblur", "this.value = checkAlphaNumeric(this.value);");
    }
    
    public static void setDecimalConverterAndScripts(UIInput facesComp, Integer decimalLength, 
        Boolean hasThousandSeparator) {
        
        if (decimalLength == null)
            decimalLength = 0;
        Converter converter = 
            getFacesContext().getApplication().createConverter("trips.converter.decimal");
        facesComp.getAttributes().put(com.technobrain.trips.core.components.converter.BigDecimalConverter.DECIMAL_LENGTH, 
                                       decimalLength);
        facesComp.getAttributes().put(com.technobrain.trips.core.components.converter.BigDecimalConverter.HAS_THOUSAND_SEPARATOR, hasThousandSeparator);
        facesComp.setConverter(converter);
        String localeStr = getFacesContext().getViewRoot().getLocale().toString();
        if(hasThousandSeparator == null || hasThousandSeparator) {
            facesComp.getAttributes().put("onblur", 
                                             "this.value = formatCurrencyWithScale(this.value, " + 
                                             decimalLength + ",'" + localeStr + "');");
            facesComp.getAttributes().put("onkeypress", "validateNumber();");
        } else {
            facesComp.getAttributes().put("onblur", 
                                             "this.value = formatCurrencyWithScaleWithoutThSep(this.value, " + 
                                             decimalLength + ",'" + localeStr +"');");
            facesComp.getAttributes().put("onkeypress", "validateNumber();");        
        }
    }
    
    public static void setDecimalConverterAndScriptsFF(UIInput facesComp, Integer decimalLength, 
        Boolean hasThousandSeparator, Boolean isNegativeAllowed) {
        
        if (decimalLength == null)
            decimalLength = 0;
        Converter converter = 
            getFacesContext().getApplication().createConverter("trips.converter.decimal");
        facesComp.getAttributes().put(com.technobrain.trips.core.components.converter.BigDecimalConverter.DECIMAL_LENGTH, 
                                       decimalLength);
        facesComp.getAttributes().put(com.technobrain.trips.core.components.converter.BigDecimalConverter.HAS_THOUSAND_SEPARATOR, hasThousandSeparator);
        facesComp.setConverter(converter);
        String localeStr = getFacesContext().getViewRoot().getLocale().toString();
        if(hasThousandSeparator == null || hasThousandSeparator) {
            facesComp.getAttributes().put("onblur", 
                                             "this.value = formatCurrencyWithScale(this.value, " + 
                                             decimalLength + ",'" + localeStr + "');");
        } else {
            facesComp.getAttributes().put("onblur", 
                                             "this.value = formatCurrencyWithScaleWithoutThSep(this.value, " + 
                                             decimalLength + ",'" + localeStr +"');");       
        }

        if(isNegativeAllowed == null || isNegativeAllowed){
            facesComp.getAttributes().put("onkeypress", "validateNumber();"); 
        }else{
            facesComp.getAttributes().put("onkeypress", "validatePositiveNumber();"); 
        }
    }


    public static void setTinFormat(UIInput facesComp){
        Converter converter = getFacesContext().getApplication().createConverter("trips.converter.tinformat");
        facesComp.setConverter(converter);
    }
    
    /**
     * Checks whether this component or any parent of this component is unrendered or not.
     * @param comp
     * @return
     */
    public static boolean isCompOrAnyParentNotRendered(UIComponent comp) {
        Boolean rendered = (Boolean)comp.getAttributes().get("rendered");
        if(rendered == null || rendered == true) {
            if(comp.getParent() != null) {
                return isCompOrAnyParentNotRendered(comp.getParent());
            }
        }
        else if(rendered == false) {
            return true;
        }
        return false;
    }
    
    public static SelectItem createSelectItem(Object value, String label) {
        if(value == null || label == null) {
            return null;
        }
        SelectItem selectItem = new SelectItem();
        selectItem.setValue(value);
        selectItem.setLabel(label);
        return selectItem;
    }
    
    /**
     * Explicitly set date format
     * @param facesComp
     */
    public static void setDateFormat(UIInput facesComp){
    
        Converter converter = getFacesContext().getApplication().createConverter("trips.converter.date");
        facesComp.setConverter(converter);
    }
    
    public static Locale getLocale() {
        return getFacesContext().getViewRoot().getLocale();
    }
    
    /**
     * Converts date value's format to conform user defined format.
     * @param value
     * @return
     */
    public static Date convertToDateFormat(Object value) {
        Locale l = getFacesContext().getViewRoot().getLocale();
        SimpleDateFormat df = new SimpleDateFormat(FacesUtil.getStringFromBundle("Global.dateformat"), l);      
        Date d = null;
        try {
            d = df.parse(value.toString());
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return d;
    }


    public static void printSessionScope(){

       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

       
       Map<String, Object> sessionMap = externalContext.getSessionMap();

        log.debug("printSessionScope STARTS");
        // Print the sessionmap
       for (String key : sessionMap.keySet()) {
            log.debug(key + ":" + sessionMap.get(key));
       }
       log.debug("printSessionScope ENDS");
    }


    public static void printApplicationScope(){

       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

       // Bean is also not in the session scope. Get the applicationmap then.
       Map<String, Object> applicationMap = externalContext.getApplicationMap();

        log.debug("printApplicationScope STARTS");
         // Print the printApplicationScope
        for (String key : applicationMap.keySet()) {
            log.debug(key + ":" + applicationMap.get(key));
        }
        log.debug("printApplicationScope ENDS");

    }
    
    public static void printRequestScope(){

       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

       // Get requestmap.
       Map<String, Object> requestMap = externalContext.getRequestMap();
    
        log.debug("printRequestScope STARTS");
         // Print the printRequestScope
        for (String key : requestMap.keySet()) {
            log.debug(key + ":" + requestMap.get(key));
        }
        log.debug("printRequestScope ENDS");
    }
    
    public static Spacer createSpacer(int width, int height){
        Spacer spacer = new Spacer();
        spacer.setWidth(String.valueOf(width));
        spacer.setHeight(String.valueOf(height));        
        return spacer;
    }
    
    /**
     * Finds the first parent component which is of the given type.
     * @param comp
     * @param wrapperCompType
     * @return
     */
    public static UIComponent findFirstWrapperComponent(UIComponent comp, String wrapperCompType) {
          UIComponent parentComp = comp.getParent();
          if(parentComp.getClass().getName().contains(wrapperCompType)) {
              return parentComp;
          }
          else {
              return findFirstWrapperComponent(comp.getParent(), wrapperCompType);
          }
    }
    
    
    /**
     * Parses the source exception to UI by checking error codes
     * 
     */
    public static void handleException(Exception e){

//            if(e instanceof EJBException){
//
//                    //Find the TopLinkException
//                    Throwable causeEx = e.getCause();
//
//                    EclipseLinkException toplinkException = null;
//                    if(causeEx instanceof EclipseLinkException){
//                            toplinkException = (EclipseLinkException)causeEx;
//                    }else if (causeEx.getCause() instanceof EclipseLinkException){
//                            toplinkException = (EclipseLinkException)causeEx.getCause();
//                    }
//
//                    /*
//                    TopLinkException toplinkException = null;
//                    if(causeEx instanceof TopLinkException){
//                            toplinkException = (TopLinkException)causeEx;
//                    }else if (causeEx.getCause() instanceof TopLinkException){
//                            toplinkException = (TopLinkException)causeEx.getCause();
//                    }
//                     */
//
//                    if (toplinkException !=null) {
//                            int toplinkErrorCode = toplinkException.getErrorCode();
//
//                            switch (toplinkErrorCode) {
//
//                            case 4002:
//                            {
//                                    Throwable innerExc = toplinkException.getCause();
//                                    SQLException sqlexc = null;
//                                    if (innerExc instanceof SQLException) {
//                                            sqlexc = (SQLException)innerExc;
//                                            //et the JDBC error code specific to ORACLE
//                                            int sqlErrorCode = sqlexc.getErrorCode();
//                                            switch (sqlErrorCode) {
//
//                                            case 1:
//                                            {
//                                                    addFacesErrorMessage("Global.err.jdbc.DuplicateFound");
//                                                    return;
//                                            }
//                                            case 1438:
//                                            {
//                                                    addFacesErrorMessage("Global.err.jdbc.PrecisionLarger");
//                                                    return;
//                                            }
//                                            case 1722:
//                                            {
//                                                    addFacesErrorMessage("Global.err.jdbc.InvalidNumber");
//                                                    return;
//                                            }
//                                            case 12899:
//                                            {
//                                                    addFacesErrorMessage("Global.err.jdbc.ValueLargeForColumn");
//                                                    return;
//                                            }
//                                            case 17002:
//                                            {
//                                                    addFacesErrorMessage("Global.err.jdbc.IOError");
//                                                    return;
//                                            }                                    
//                                            default:
//                                            {
//                                                    addFacesErrorMessage("Global.err.GenericDBError");
//                                                    return;
//                                            }
//                                            }
//                                    }
//
//                            }
//                            default:
//                            {
//                                    addFacesErrorMessage("Global.err.GenericDBError");
//                                    return;
//                            }
//                            }
//                    } else {
//                            addFacesErrorMessage("TRIPS_CATCHALL");
//                            return;
//                    }
//            }
    }

    

    public static void main(String[] args) {
        log.debug(Locale.getDefault().toString());
    }


    public static String parseMessageKeyValue(String message) {
        String messageKeyValue = null;
        String[] messageKey = formatAsStringArray(message,"?");
        messageKeyValue = getStringFromBundle(messageKey[0]);
        if(messageKeyValue.startsWith(NO_RESOURCE_FOUND)){
            messageKeyValue = messageKey[0];
        }
        int pos = 0;
        for(int i=1; i<messageKey.length; i++){
           pos = i-1; // holds the real position of the token key
           messageKeyValue = messageKeyValue.replace("{"+pos+"}",messageKey[i]);
        }
        return messageKeyValue;
    }



    public static String getStringFromBundleForFF(String key) {
      ResourceBundle bundle = getBundle();
      return getStringSafely(bundle, key, key);
    }
    public static String getStringFromBundleForFF(String msg, Object[] values) {
        String messageKeyValue = getStringFromBundleForFF(msg);
        return replaceParamsInString(messageKeyValue, values);
    }
    public static void addFacesErrorMessageForFF(String msg, Object[] params) {
      FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, getStringFromBundleForFF(msg, params) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }
    public static void concatFacesErrorMessageForFF(List<String> msgs, Object[] params) {
      FacesContext ctx = getFacesContext();
      String errorMsg = "";
      for(String msg: msgs){
          errorMsg = errorMsg +" "+ getStringFromBundleForFF(msg);
      }
      FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, replaceParamsInString(errorMsg, params) ,null);
      ctx.addMessage(getRootViewComponentId(),fm);
    }

    public static void addFacesErrorMessageForFF(SystemMessage message){        
        String messageKeyValue = null;
        if(message != null && message.getMessage() != null){
            messageKeyValue = parseMessageKeyValueForFF(message.getMessage());
            addFacesErrorMessageForValidation(message.getCode(),messageKeyValue);
        }
    }
    
    public static String parseMessageKeyValueForFF(String message) {
        String messageKeyValue = null;
        String[] messageKey = formatAsStringArray(message,"?");
        messageKeyValue = getStringFromBundleForFF(messageKey[0]);
        if(messageKeyValue.startsWith(NO_RESOURCE_FOUND)){
            messageKeyValue = messageKey[0];
        }
        int pos = 0;
        for(int i=1; i<messageKey.length; i++){
           pos = i-1; // holds the real position of the token key
           messageKeyValue = messageKeyValue.replace("{"+pos+"}",messageKey[i]);
        }
        return messageKeyValue;
    } 
    
    public static boolean isUserInRole(String role){
    	Subject subject = (Subject)FacesUtil.getSessionScope().get("jaas.subject");
    	if(subject == null){
    		return false;
    	} else {
//            for(TripsSSOPrincipal principal:subject.getPrincipals(TripsSSOPrincipal.class)){
//            	if(principal.getName().equals(role)){
//            		return true;
//            	}
//            }
    	}
        return false;
    }
    
    public static ELContext getELContext()
    {
            return getFacesContext().getELContext();
    }

    public static MethodExpression getMethodExpression(String name, Class[] clazz)
    {
            FacesContext facesCtx = getFacesContext();
            Application app = facesCtx.getApplication();  
            ExpressionFactory elFactory = app.getExpressionFactory();  
            ELContext elContext = facesCtx.getELContext();
            return elFactory.createMethodExpression(elContext, name, Object.class, clazz);          
    }
    
    public  static ValueExpression getValueExpression(String name) {  
            FacesContext facesCtx = getFacesContext();
            Application app = facesCtx.getApplication();  
            ExpressionFactory elFactory = app.getExpressionFactory();  
            ELContext elContext = facesCtx.getELContext();  
            return  elFactory.createValueExpression(elContext, name, Object.class);  
    }
}
