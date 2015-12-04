package com.technobrain.trips.core.messagehelper;

import com.technobrain.trips.common.messagehelpers.MessageHelper;
import com.technobrain.trips.core.message.InputType;
import com.technobrain.trips.core.model.BaseModelObject;
import com.technobrain.trips.core.system.SysTaskLink;
import com.technobrain.trips.core.message.InputType;

import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

/**
 * Technobrain 2015
 *
 * Override to transfer data to/from tasklockmessage
 *
 * @since	$Date: 2/2/2009 5:56:39 AM$
 * @version 	$Revision: 4$
 * @author 	$Author: Howard Hill$
 * 
 * $Log[1]:
 *  4    TRIPS2    1.3         2/2/2009 5:56:39 AM    Howard Hill     changed
 *       to Log1 instead of Log
 * $
 */
public class TaskLockMessageHelper extends MessageHelper {

    @Override
    public BaseModelObject setData(BaseModelObject pojo, InputType type) {
        // this should happen in some central location
        SqlTimestampConverter sqlCon = new SqlTimestampConverter(null);
        LongConverter lCon = new LongConverter(null);
        ConvertUtils.register(sqlCon, Timestamp.class);
        ConvertUtils.register(lCon, Long.class);

        SysTaskLink task = (SysTaskLink)pojo;
//        TaskLockInputType msg = (TaskLockInputType)type;
//        try {
//            BeanUtils.copyProperties(task, msg);
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
        return task;
    }

    public InputType getData(BaseModelObject pojo) {
        // this should happen in some central location
        SqlTimestampConverter sqlCon = new SqlTimestampConverter(null);
        LongConverter lCon = new LongConverter(null);
        ConvertUtils.register(sqlCon, Timestamp.class);
        ConvertUtils.register(lCon, Long.class);
        
        SysTaskLink task = (SysTaskLink)pojo;
//        TaskLockInputType msg = new TaskLockInputType();
//        try {
//            BeanUtils.copyProperties(msg, task);
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }

        return null;
    }

}
