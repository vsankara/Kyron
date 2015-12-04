package com.technobrain.trips.core.components;

import java.lang.reflect.InvocationTargetException;

import javax.faces.component.StateHolder;
import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 */
public abstract class AbstractStateholder implements StateHolder {

	/**
	 * Necessary for {@link StateHolder}.
	 */
	private boolean isTransient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.StateHolder#setTransient(boolean)
	 */
	public final void setTransient(final boolean isTransient) {
		this.isTransient = isTransient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.StateHolder#isTransient()
	 */
	public final boolean isTransient() {
		return isTransient;
	}

	/**
	 * Saves the entire state of the current validator as clones bean
	 * 
	 * @see StateHolder#saveState(FacesContext)
	 * @see GenericUtils#cloneBean(Object)
	 */
	public final Object saveState(final FacesContext context) {
	    try {
	                    return BeanUtils.cloneBean(this);
	            } catch (final IllegalAccessException e) {
	                 //   logger.error("error cloning bean", e);
	                    throw new RuntimeException(e.getMessage(), e);
	            } catch (final InstantiationException e) {
	                  ///  logger.error("error cloning bean", e);
	                    throw new RuntimeException(e.getMessage(), e);
	            } catch (final InvocationTargetException e) {
	                  //  logger.error("error cloning bean", e);
	                    throw new RuntimeException(e.getMessage(), e);
	            } catch (final NoSuchMethodException e) {
	                 //   logger.error("error cloning bean", e);
	                    throw new RuntimeException(e.getMessage(), e);
	            }
	}

	/**
	 * Restores the entire state through the use of project bean (project the previously cloned bean's 
	 * properties on the current validator)
	 * 
	 * @see javax.faces.component.StateHolder#restoreState(javax.faces.context.FacesContext, java.lang.Object)
	 * @see GenericUtils#projectBean(Object, Object)
	 */
	public final void restoreState(final FacesContext context, final Object clonedValidatorBean) {
		
	    try {
	                            BeanUtils.copyProperties(this,clonedValidatorBean);
	                    } catch (IllegalAccessException e) {
//	                            logger.error("fout bij overnemen bean properties", e);
	                            throw new RuntimeException(e.getMessage(), e);
	                    } catch (InvocationTargetException e) {
//	                            logger.error("fout bij overnemen bean properties", e);
	                            throw new RuntimeException(e.getMessage(), e);
	                    }
	}
}
