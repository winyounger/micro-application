package com.supconit.service;

import com.supconit.core.response.ResponseData;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.query.SearchTripQuery;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-10- 14:41:48
 * @Description:
 * @Version: 1.0.0
 */
public interface PassengerService {

    ResponseData publishOrder(PublishMsg publishMsg);

    ResponseData getTripByDistrict(SearchTripQuery searchObj);
}
