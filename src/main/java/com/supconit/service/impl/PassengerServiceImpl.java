package com.supconit.service.impl;

import com.supconit.dao.mapper.PassengerMapper;
import com.supconit.service.PassengerService;

import javax.annotation.Resource;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 14:42:22
 * @Description:
 * @Version: 1.0.0
 */
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

}
