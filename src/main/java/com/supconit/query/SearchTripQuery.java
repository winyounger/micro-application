package com.supconit.query;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 23:46:20
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class SearchTripQuery {

    private String start;
    private String end;
    private String date;
    //showType 0: 乘客行程， 1：司机行程
    private Integer showType;

}
