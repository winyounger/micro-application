package com.supconit.service.impl;

import com.supconit.core.config.AppContext;
import com.supconit.core.enums.ResponseCodeEnum;
import com.supconit.core.response.ResponseData;
import com.supconit.dao.domain.CollectDo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.dto.PublishMsgDto;
import com.supconit.dao.mapper.CollectMapper;
import com.supconit.dao.mapper.DriverMapper;
import com.supconit.dao.mapper.PassengerMapper;
import com.supconit.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-15- 10:15:54
 * @Description:
 * @Version: 1.0.0
 */
@Service("collectService")
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectMapper collectMapper;
    @Resource
    private PassengerMapper passengerMapper;
    @Resource
    private DriverMapper driverMapper;

    @Override
    public ResponseData collectCourse(Long courseId, Integer courseType) {
        String openid = AppContext.getCurrentUserWechatOpenId();
        //判断用户不能收藏自己的行程
        //courseType 0: 乘客行程， 1：司机行程
        PublishMsgDto publishMsg = null;
        if (courseType.equals(0)) {
            publishMsg = passengerMapper.getById(courseId);
        }else {
            publishMsg = driverMapper.getById(courseId);
        }
        if (publishMsg == null) {
            return new ResponseData("收藏失败，该行程已结束", ResponseCodeEnum.FAILD.getCode());
        }
        if (publishMsg.getOpenid().equals(openid)) {
            return new ResponseData("不能收藏自己的行程", ResponseCodeEnum.FAILD.getCode());
        }
        //判断收藏过的不能重复收藏
        CollectDo collectDo = collectMapper.getByCourseIdAndOpenid(courseId, openid);
        if (collectDo != null) {
            return new ResponseData("您收藏过啦，请勿重复收藏", ResponseCodeEnum.FAILD.getCode());
        }
        collectDo = new CollectDo();
        collectDo.setCourseId(courseId).setCourseType(courseType).setOpenid(openid);
        collectMapper.saveRecord(collectDo);
        return new ResponseData("收藏成功", ResponseCodeEnum.SUCCESS.getCode());
    }

    @Override
    public ResponseData getIsCollectedCourse(Long courseId, Integer courseType) {
        String openid = AppContext.getCurrentUserWechatOpenId();
        //判断用户不能收藏自己的行程
        //courseType 0: 乘客行程， 1：司机行程
        CollectDo collectDo = collectMapper.getByCourseIdAndOpenid(courseId, openid);
        if (collectDo != null) {
            //已收藏，返回true
            return new ResponseData(true);
        }
        //未收藏，返回false
        return new ResponseData(false);
    }
}
