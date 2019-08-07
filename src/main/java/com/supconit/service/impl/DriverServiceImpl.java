package com.supconit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supconit.dao.domain.DriverDo;
import com.supconit.dao.domain.UserDo;
import com.supconit.dao.mapper.DriverMapper;
import com.supconit.dao.mapper.UserMapper;
import com.supconit.query.CommonQuery;
import com.supconit.service.DriverService;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private UserService userService;

    @Override
    public int creatDriver(CommonQuery commonQuery) {
        DriverDo driverDo = new DriverDo();
        driverDo.setUserId(commonQuery.getUserId());
        driverDo.setCarColor(commonQuery.getCarColor());
        driverDo.setCarName(commonQuery.getCarName());
        driverDo.setCarNumber(commonQuery.getCarNumber());
        driverMapper.saveDriver(driverDo);
        UserDo userDo = new UserDo();
        userDo.setId(commonQuery.getUserId());
        userDo.setIdentity(2);
        userService.updataUser(userDo);
        return 1;
    }
}
