package com.supconit.controller;

import com.supconit.domain.TestDo;
import com.supconit.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 15:15:42
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/insert")
    public void insert() {
        TestDo testDo = new TestDo();
        testDo.setName("张无忌");
        Integer num = testService.insert(testDo);
    }


}
