package com.supconit.dao.mapper;

import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.domain.PublishMsgAddress;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 14:43:50
 * @Description:
 * @Version: 1.0.0
 */
public interface PassengerMapper {

    /**
     * description
     * @param publishMsg
     * @return
     * */
    void saveRecord(PublishMsg publishMsg);

    /**
     * description
     * @param
     * @return
     * */
    void saveAddressRecord(PublishMsgAddress publishMsgAddress);
}
