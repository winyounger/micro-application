package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月24日 21:24:19
 * @Description: 乘客发布信息的参数实体
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class PublishMsg {

    private String date;
    private String time;
    private String end;
    private String start;
    private AddressInfo endAddressInfo;
    private AddressInfo startAddressInfo;
    private Integer personNum;
    private String phone;
    private BigDecimal price;
    private String note;

}
