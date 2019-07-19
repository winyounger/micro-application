package com.supconit.controller;

import com.supconit.common.api.WechatAuthenticationResponse;
import com.supconit.domain.dto.UserDto;
import com.supconit.domain.po.UserPo;
import com.supconit.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:01:43
 * @Description:
 * @Version: 1.0.0
 */
@RestController
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
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestBody UserPo userPo) throws Exception {
        WechatAuthenticationResponse jwtResponse = wechatService.wechatLogin(userPo.getCode());
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/updateConsumerInfo")
    public void updateConsumerInfo(@RequestBody UserDto userDto) {
        wechatService.updateConsumerInfo(userDto);
    }

}
