package com.supconit.service.impl;

import com.supconit.dao.domain.OrderDo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.mapper.OrderMapper;
import com.supconit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
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
}
