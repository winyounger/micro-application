package com.supconit.controller;


import com.supconit.dao.TestDo;
import com.supconit.dao.domain.UserDo;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangqiujun
 * @Date: 2019年07月22日
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getUserInfo")
    public void getUserInfo(@RequestParam String token) {
        UserDo userDo = userService.getUserById();

    }
}
