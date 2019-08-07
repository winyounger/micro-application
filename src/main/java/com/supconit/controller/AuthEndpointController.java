package com.supconit.controller;

import com.supconit.core.response.ResponseData;
import com.supconit.dao.dto.UserDto;
import com.supconit.dao.domain.UserDo;
import com.supconit.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:01:43
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthEndpointController {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private WechatService wechatService;

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }

    @GetMapping("/testAuth")
    public String testAuth() {
        return "testAuth_success";
    }

    @PostMapping("/auth")
    public ResponseData createAuthenticationToken(@RequestBody UserDo userDo) throws Exception {
        return wechatService.wechatLogin(userDo.getCode());
    }

    @PostMapping("/updateConsumerInfo")
    public ResponseData updateConsumerInfo(@RequestBody UserDto userDto) {
        return wechatService.updateConsumerInfo(userDto);
    }

}
