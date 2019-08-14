package com.supconit.service.impl;

import com.supconit.core.config.AppContext;
import com.supconit.core.response.ResponseData;
import com.supconit.core.util.DateUtil;
import com.supconit.dao.domain.AddressComponent;
import com.supconit.dao.domain.AddressInfo;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.dao.domain.PublishMsgAddress;
import com.supconit.dao.dto.PublishMsgDto;
import com.supconit.dao.mapper.PassengerMapper;
import com.supconit.query.SearchTripQuery;
import com.supconit.service.PassengerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 14:42:22
 * @Description:
 * @Version: 1.0.0
 */
@Service("passengerService")
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData publishOrder(PublishMsg publishMsg) {
        String openid = AppContext.getCurrentUserWechatOpenId();
        Date date = DateUtil.joinDate(publishMsg.getDate(), publishMsg.getTime());
        publishMsg.setDate(date).setOpenid(openid);
        //保存到信息表
        passengerMapper.saveRecord(publishMsg);
        //保存发布信息的详细地址
        //1.出发地信息地址
        //type类型 0表示出发地址，1表示到达地址
        saveRecordDetail(0, publishMsg.getId(), publishMsg.getStartAddressInfo());
        //2.到达信息地址
        saveRecordDetail(1, publishMsg.getId(), publishMsg.getEndAddressInfo());
        return new ResponseData();
    }

    @Override
    public ResponseData getTripByDistrict(SearchTripQuery searchObj) {
        List<PublishMsgDto> list = passengerMapper.getMainTripByDistrict(searchObj);
        list.stream().forEach( publishMsg -> {
            List<AddressInfo> addressInfoList = passengerMapper.getAddressInfoByMsgId(publishMsg.getId());
            addressInfoList.stream().forEach(addressInfo -> {
                if(addressInfo.getType().equals(0)) {
                    //出发地址
                    publishMsg.setStartAddressInfo(addressInfo);
                }else {
                    //到达地址
                    publishMsg.setEndAddressInfo(addressInfo);
                }
            });
        });
        return new ResponseData(list);
    }

    public void saveRecordDetail(Integer type, Long msgId, AddressInfo addressInfo) {
        PublishMsgAddress publishMsgAddress = new PublishMsgAddress();
        AddressComponent addressComponent = addressInfo.getAddressComponent();
        publishMsgAddress.setType(type).setName(addressInfo.getName()).setAddress(addressInfo.getAddress())
                .setLongitude(addressInfo.getLongitude()).setLatitude(addressInfo.getLatitude())
                .setNation(addressComponent.getNation()).setProvince(addressComponent.getProvince())
                .setCity(addressComponent.getCity()).setDistrict(addressComponent.getDistrict())
                .setStreet(addressComponent.getStreet()).setStreetNumber(addressComponent.getStreet_number())
                .setMsgId(msgId);
        passengerMapper.saveAddressRecord(publishMsgAddress);
    }
}
