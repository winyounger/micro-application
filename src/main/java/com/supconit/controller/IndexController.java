package com.supconit.controller;

import com.supconit.core.api.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月22日 15:38:06
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    /**
     * 首页的形成汇总统计
     * */
    @GetMapping("/getAllCourseTotal")
    public ResponseData getAllCourseTotal() {
        Map map = new HashMap<String, String>();
        map.put("data","我调用成功了");
        return new ResponseData(map);
    }


}
