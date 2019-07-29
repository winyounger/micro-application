package com.supconit.controller;

import com.supconit.core.api.WechatAuthenticationResponse;
import com.supconit.core.response.AjaxMessage;
import com.supconit.dao.domain.UserDo;
import com.supconit.query.CommonQuery;
import com.supconit.service.DriverService;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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

    @PostMapping("/creatDriver")
    public AjaxMessage creatDriver(@RequestBody CommonQuery commonQuery) {
        Long userId = commonQuery.getUserId();
        UserDo userDo = userService.getUserById(userId);

        return ResponseEntity.ok(jwtResponse);
    }

}

