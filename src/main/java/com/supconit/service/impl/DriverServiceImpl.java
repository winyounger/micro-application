package com.supconit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supconit.dao.domain.DriverDo;
import com.supconit.dao.domain.UserDo;
import com.supconit.dao.mapper.DriverMapper;
import com.supconit.dao.mapper.UserMapper;
import com.supconit.query.CommonQuery;
import com.supconit.service.DriverService;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, DriverDo> implements DriverService {
    @Override
    public int creatDriver(CommonQuery commonQuery) {
        DriverDo driverDo = new DriverDo();
        driverDo.setUserId(commonQuery.getUserId());
        driverDo.setCarColor(commonQuery.getCarColor());
        driverDo.setCarName(commonQuery.getCarName());
        driverDo.setCarNumber(commonQuery.getCarNumber());
        return baseMapper.insert(driverDo);
    }
}
