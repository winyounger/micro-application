package com.supconit.dao.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-07- 17:37:48
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class AddressComponent {

    private String city;//市
    private String district;//区
    private String nation;//国家
    private String province;//省
    private String street;//路
    private String street_number;//路号

}
