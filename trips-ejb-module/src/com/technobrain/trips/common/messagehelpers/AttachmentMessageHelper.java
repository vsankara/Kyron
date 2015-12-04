package com.technobrain.trips.common.messagehelpers;

import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.model.CommAttachment;
import com.technobrain.trips.core.message.AttachmentType;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;

import java.sql.Timestamp;

import java.util.Calendar;


public class AttachmentMessageHelper extends MessageHelper {
    public AttachmentMessageHelper() {
    }
    

    /**
     * This method takes the CommAttachment and AttachmentType object
     * as input parameters, sets the data of AttachmentType to
     * CommAttachment and returns the populated CommAttachment object
     *
     */
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        CommAttachment commAttachment = (CommAttachment)pojo;
        AttachmentType attachType = (AttachmentType)type;
        if (commAttachment == null)
            commAttachment =
                    MessageHelper.init(commAttachment, CommAttachment.class);

        //setting the properties of the bean
        commAttachment.setAttachmentDate(DateHelper.getSqlTimestamp(attachType.getAttachmentDate()));
        commAttachment.setAttachmentPath(attachType.getAttachmentPath());
        commAttachment.setAttachmentType(attachType.getAttachmentType());
        commAttachment.setNotes(attachType.getNotes());
        commAttachment.setReference(attachType.getReference());
        commAttachment.setFileStoreId(attachType.getFileStoreId());
        commAttachment.setId(attachType.getId());
        return commAttachment;
    }
    
    // NOTHING TO DO
    public InputType getData(BaseModelObject pojo) {
        AttachmentType type = new AttachmentType();
        CommAttachment commAttachment = (CommAttachment)pojo;
        Timestamp sqlTimestamp = commAttachment.getAttachmentDate();
        if (sqlTimestamp != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(sqlTimestamp.getTime());
            type.setAttachmentDate(calendar);
        }
        type.setAttachmentPath(commAttachment.getAttachmentPath());
        type.setAttachmentType(commAttachment.getAttachmentType());
        type.setFileStoreId(commAttachment.getFileStoreId());
        type.setId(commAttachment.getId());
        type.setNotes(commAttachment.getNotes());
        type.setReference(commAttachment.getReference());
        return type;
    }
}
