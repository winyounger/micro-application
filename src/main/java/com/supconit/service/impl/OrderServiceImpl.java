package com.supconit.service.impl;

import com.supconit.dao.domain.OrderDo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.dto.TotalDto;
import com.supconit.dao.mapper.DriverMapper;
import com.supconit.dao.mapper.OrderMapper;
import com.supconit.dao.mapper.PassengerMapper;
import com.supconit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private PassengerMapper passengerMapper;
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public int publishOrder(PublishMsg publishMsg) {

        OrderDo orderDo = new OrderDo();
//        orderDo.setStartTime(publishMsg.getStartTime());
//        orderDo.setEndTime(publishMsg.getEndTime());
//        orderDo.setStartSite(publishMsg.getStartSite());
//        orderDo.setEndSite(publishMsg.getEndSite());
//        orderDo.setAmount(publishMsg.getAmount());
//        orderDo.setSeats(publishMsg.getSeats());
//        orderDo.setType(publishMsg.getType());
//        orderDo.setMobile(publishMsg.getMobile());
//        orderDo.setRemark(publishMsg.getRemark());

        return orderMapper.creatOrder(orderDo);
    }

    @Override
    public Map getAllCourseTotal() {
        Map map = new HashMap();
        List<TotalDto> publishAddress = passengerMapper.getAddressCountInfo();
        List<TotalDto> driverAddress = driverMapper.getAddressCountInfo();
        map.put("passenger",publishAddress);
        map.put("driver",driverAddress);
        return map;
    }
}
