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

    private String city;
    private String district;
    private String nation;
    private String province;
    private String street;
    private String street_number;

}
