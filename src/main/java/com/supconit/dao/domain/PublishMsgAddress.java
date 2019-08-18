package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 20:22:03
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class PublishMsgAddress {

    //0表示出发地址，1表示到达地址
    private Integer type;
    private String name;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String nation;
    private String province;
    private String city;
    private String district;
    private String street;
    private String streetNumber;
    private Long msgId;
    private Long id;

}
