package com.supconit.dao.mapper;

import com.supconit.dao.domain.AddressInfo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.domain.PublishMsgAddress;
import com.supconit.dao.dto.TotalDto;
import com.supconit.dao.dto.PublishMsgDto;
import com.supconit.query.SearchTripQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<PublishMsgDto> getMainTripByDistrict(SearchTripQuery searchObj);

    List<AddressInfo> getAddressInfoByMsgId(@Param("msgId") Long msgId);

    PublishMsgDto getById(@Param("id") Long id);

    List<TotalDto> getAddressCountInfo();
}
