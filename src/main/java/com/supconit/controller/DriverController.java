package com.supconit.controller;

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

    /**
     * 司机发布信息接口
     * */
    @PostMapping("/publishMsg")
    public void publishMsg(@RequestBody PublishMsg publishMsg) {
        System.out.println(publishMsg);
    }

}

