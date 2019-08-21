package com.supconit.controller;

import com.supconit.core.response.ResponseData;
import com.supconit.query.SearchTripQuery;
import com.supconit.service.CollectService;
import com.supconit.service.DriverService;
import com.supconit.service.OrderService;
import com.supconit.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月25日 21:35:02
 * @Description: 用户行程相关controller
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private OrderService orderService;

    /**
     * 根据地址查找相关行程汇总数据
     * */
    @PostMapping("/getByDistrict")
    public ResponseData getTripByDistrict(@RequestBody SearchTripQuery searchObj) {
        Integer showType = searchObj.getShowType();
        if (showType.equals(0)) {
            //查询乘客行程
            return passengerService.getTripByDistrict(searchObj);
        } else {
            //查询司机行程
            return driverService.getTripByDistrict(searchObj);
        }
    }

    /**
     * 首页的行程汇总统计,暂时写的假数据
     * */
    @GetMapping("/getAllCourseTotal")
    public ResponseData getAllCourseTotal() {
        Map map = new HashMap<String, Object>();
        map = orderService.getAllCourseTotal();
        return new ResponseData(map);
    }

    /**
     * 查询是否已收藏
     * */
    @PostMapping("/getIsCollectedCourse")
    public ResponseData getIsCollectedCourse(Long courseId, Integer courseType) {
        return collectService.getIsCollectedCourse(courseId, courseType);
    }



    /**
     * 收藏
     * */
    @PostMapping("/collectCourse")
    public ResponseData collectCourse(Long courseId, Integer courseType) {
        return collectService.collectCourse(courseId, courseType);
    }

    /**
     * 获取我的行程
     * */
    @PostMapping("/getUserCourse")
    public ResponseData getUserCourse(Integer type) {
        System.out.println("jin lai le meiyou a ");
        System.out.println(type);
        Map map = new HashMap<String, String>();
        map.put("data","啦啦啦，成功返回啦！");
        return new ResponseData(map);
    }

    /**
     * 我的收藏页面
     * */
    @PostMapping("/getUserCollection")
    public ResponseData getUserCollection(Integer type) {
        System.out.println("jin lai le meiyou a ");
        System.out.println(type);
        Map map = new HashMap<String, String>();
        map.put("data","啦啦啦，成功返回啦！");
        return new ResponseData(map);
    }




}
