package com.supconit.service;

import com.supconit.dao.domain.PublishMsg;

import java.util.List;
import java.util.Map;

public interface OrderService {
    int publishOrder(PublishMsg publishMsg);

    Map getAllCourseTotal();
}
