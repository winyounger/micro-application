package com.supconit.controller;

import com.supconit.core.response.AjaxMessage;
import com.supconit.core.response.ResponseData;
import com.supconit.dao.domain.UserDo;
import com.supconit.query.CommonQuery;
import com.supconit.service.DriverService;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.supconit.dao.domain.PublishMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月23日 11:07:52
 * @Description: 车主controller
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;

    /**
     * 司机发布信息接口
     * */
    @PostMapping("/publishMsg")
    public ResponseData publishMsg(@RequestBody PublishMsg publishMsg) {
        System.out.println(publishMsg);
        return driverService.publishOrder(publishMsg);
    }
    @PostMapping("/creatDriver")
    public AjaxMessage creatDriver(@RequestBody CommonQuery commonQuery) {
        Long userId = commonQuery.getUserId();
        UserDo userDo = userService.getUserById(userId);
        if(userDo == null){
            return AjaxMessage.error();
        }
        driverService.creatDriver(commonQuery);
        return AjaxMessage.success();
    }

}

