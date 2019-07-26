package com.supconit.controller;

import com.supconit.core.api.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * 首页的行程汇总统计
     * */
    @GetMapping("/getAllCourseTotal")
    public ResponseData getAllCourseTotal() {
        Map map = new HashMap<String, String>();
        map.put("data","我调用成功了");
        return new ResponseData(map);
    }

    /**
     * description 根据定位信息获取行程
     * @param
     * @return
     * */
    @GetMapping("/getCourseByDistrict")
    public ResponseData getCourseByDistrict() {
        Map map = new HashMap<String, List>();
//        latitude: arr[i].latitude,
//                longitude: arr[i].longitude
        Map map1 = new HashMap<String, Double>();
        map1.put("latitude",13.4566432423D);
        map1.put("longitude",21.4566442423D);
        List<Map> list = new ArrayList<>();
        list.add(map1);
        map.put("data",list);
        return new ResponseData(map);
    }


}
