package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-07- 17:34:28
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class AddressInfo {

    private String name;//道路名称
    private String address;//详细地址
    private BigDecimal latitude;//纬度
    private BigDecimal longitude;//经度
    private AddressComponent addressComponent;//详细信息

}
