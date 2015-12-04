package com.technobrain.trips.common.messagehelpers;

import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;

import java.util.Collection;

public interface IAssociationHelper {

    /**
     * Sets the Collection of object, associated with the POJO.
     *
     * @param pojo EJB POJO to associate a Collection with.
     * @param associatedCollection a Collection to associate with a POJO
     */
    public void setAssociatedCollection(BaseModelObject pojo,
            Collection<BaseModelObject> associatedPojoCollection);

    public void setDataForAssociatedPojo(InputType associatedType,
            BaseModelObject associatedPojo);

    public Class getAssociatedPojoClass();
}
