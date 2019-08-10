package com.supconit.controller;

import com.supconit.core.config.AppContext;
import com.supconit.dao.domain.PublishMsg;
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
    private PassengerService passengerService;

    /**
     * 乘客发布信息接口
     * */
    @PostMapping("/publishMsg")
    public void publishMsg(@RequestBody PublishMsg publishMsg) {
        String openid = AppContext.getCurrentUserWechatOpenId();

        System.out.println(publishMsg);
    }

}
