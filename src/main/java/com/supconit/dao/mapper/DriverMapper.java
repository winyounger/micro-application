package com.supconit.dao.mapper;

import com.supconit.dao.domain.AddressInfo;
import com.supconit.dao.domain.DriverDo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.domain.PublishMsgAddress;
import com.supconit.dao.dto.PublishMsgDto;
import com.supconit.query.SearchTripQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverMapper {

    int saveDriver(DriverDo driverDo);

    void saveRecord(PublishMsg publishMsg);

    void saveAddressRecord(PublishMsgAddress publishMsgAddress);

    List<PublishMsgDto> getMainTripByDistrict(SearchTripQuery searchObj);

    List<AddressInfo> getAddressInfoByMsgId(@Param("msgId") Long msgId);

    PublishMsgDto getById(@Param("id") Long id);
}
