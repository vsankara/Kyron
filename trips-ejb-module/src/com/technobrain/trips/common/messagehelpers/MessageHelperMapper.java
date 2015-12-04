package com.technobrain.trips.common.messagehelpers;

import com.technobrain.trips.core.model.BaseModelObject;

public class MessageHelperMapper <T extends MessageHelper, Z extends BaseModelObject> {
    private Class<T> messageHelperClass;
    private Class<Z> pojoClass;

    public MessageHelperMapper(Class<T> messageHelperClass, Class<Z> pojoClass) {
        this.messageHelperClass = messageHelperClass;
        this.pojoClass = pojoClass;
    }

    public void setMessageHelperClass(Class<T> messageHelperClass) {
        this.messageHelperClass = messageHelperClass;
    }

    public Class<T> getMessageHelperClass() {
        return messageHelperClass;
    }

    public void setPojoClass(Class<Z> pojoClass) {
        this.pojoClass = pojoClass;
    }

    public Class<Z> getPojoClass() {
        return pojoClass;
    }
}
