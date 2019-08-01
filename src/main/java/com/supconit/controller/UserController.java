package com.supconit.controller;


import com.supconit.core.response.HandleResponse;
import com.supconit.core.util.TokenUtils;
import com.supconit.dao.TestDo;
import com.supconit.dao.domain.UserDo;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TokenUtils tokenUtils;
    @GetMapping("/getUserInfo")
    public HandleResponse getUserInfo(@RequestParam String token) {
        Long userId = tokenUtils.getUserId(token);
        UserDo userDo = userService.getUserById(userId);
        //redisTemplate.opsForValue().set("ww","22222");
        //redisTemplate.expire("ww",1l, TimeUnit.MINUTES);
        return HandleResponse.successResponse(userDo);
    }
}
