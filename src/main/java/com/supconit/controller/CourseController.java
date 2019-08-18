package com.supconit.controller;

import com.supconit.core.api.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月25日 21:35:02
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/course")
public class CourseController {


    /**
     * 根据地址查找相关行程汇总数据
     * */
    @PostMapping("/getByDistrict")
    public ResponseData getCourseByDistrict(String start, String end, String date, Integer showType) {
        System.out.println("jin lai le meiyou a ");
        System.out.println(start+","+ end +","+ date+","+ showType);
        Map map = new HashMap<String, String>();
        map.put("data","啦啦啦，成功返回啦！");
        return new ResponseData(map);
    }

    /**
     * 查询是否已收藏
     * */
    @PostMapping("/getIsCollectedCourse")
    public ResponseData getIsCollectedCourse(String courseId) {
        System.out.println("jin lai le meiyou a ");
        System.out.println(courseId);
        Map map = new HashMap<String, String>();
        map.put("data","啦啦啦，成功返回啦！");
        return new ResponseData(map);
    }


    /**
     * 收藏
     * */
    @PostMapping("/collectCourse")
    public ResponseData collectCourse(String courseId, String courseType) {
        System.out.println("jin lai le meiyou a ");
        System.out.println(courseId + "," + courseType);
        Map map = new HashMap<String, String>();
        map.put("data","啦啦啦，成功返回啦！");
        return new ResponseData(map);
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