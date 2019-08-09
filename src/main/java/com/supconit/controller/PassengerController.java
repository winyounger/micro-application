package com.supconit.controller;

import com.supconit.dao.domain.PublishMsg;
import com.supconit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月23日 11:08:27
 * @Description: 乘客controller
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("passenger")
public class PassengerController {

    @Autowired
    private OrderService orderService;

    /**
     * 乘客发布信息接口
     * */
    @PostMapping("/publishMsg")
    public void publishMsg(@RequestBody PublishMsg publishMsg) {
        orderService.publishOrder(publishMsg);
        System.out.println(publishMsg);
    }

}
