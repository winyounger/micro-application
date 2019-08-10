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

    private String name;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private AddressComponent addressComponent;

}
