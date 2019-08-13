package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月24日 21:24:19
 * @Description: 乘客发布信息的参数实体
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class PublishMsg implements Serializable {

    private Long id;
    private Date date;
    private String time;
    private String end;
    private String start;
    private AddressInfo endAddressInfo;
    private AddressInfo startAddressInfo;
    private Integer personNum;
    private String phone;
    private BigDecimal price;
    private String note;
    private String openid;

    /**
     * 司机相关
     * */
    private Integer surplusSeat;//余座
    private String carInfo;//车辆品牌型号颜色
    private String carNum;//车牌号

//    private Date startTime;
//    private Date endTime;
//    private String startSite;
//    private String endSite;
//    private String mobile;
//    private Integer seats;
//    private String remark;
//    private Integer type;
//    private Long userId;
//    private BigDecimal amount;
}
