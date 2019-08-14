package com.supconit.service;

import com.supconit.core.response.ResponseData;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.query.CommonQuery;
import com.supconit.query.SearchTripQuery;

public interface DriverService {
    int creatDriver(CommonQuery commonQuery);

    ResponseData publishOrder(PublishMsg publishMsg);

    ResponseData getTripByDistrict(SearchTripQuery searchObj);
}
