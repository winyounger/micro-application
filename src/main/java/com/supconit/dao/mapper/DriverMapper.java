package com.supconit.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supconit.dao.domain.DriverDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverMapper {

    int saveDriver(DriverDo driverDo);
}
