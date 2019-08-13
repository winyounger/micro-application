package com.supconit.service;

import com.supconit.core.response.ResponseData;
import com.supconit.dao.domain.PublishMsg;
import com.supconit.query.CommonQuery;

public interface DriverService {
    int creatDriver(CommonQuery commonQuery);

    ResponseData publishOrder(PublishMsg publishMsg);
}
