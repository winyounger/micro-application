package com.supconit.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supconit.dao.domain.DriverDo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.domain.PublishMsgAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverMapper {

    int saveDriver(DriverDo driverDo);

    void saveRecord(PublishMsg publishMsg);

    void saveAddressRecord(PublishMsgAddress publishMsgAddress);
}
