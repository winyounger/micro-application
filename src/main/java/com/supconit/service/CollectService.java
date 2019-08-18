package com.supconit.service;

import com.supconit.core.response.ResponseData;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-15- 10:15:26
 * @Description:
 * @Version: 1.0.0
 */
public interface CollectService {

    /**
     * description 收藏行程
     * @param courseId
     * @param courseType
     * @return responseData
     * */
    ResponseData collectCourse(Long courseId, Integer courseType);

    /**
     * description
     * @param courseId 行程id
     * @param courseType 行程类型
     * @return
     * */
    ResponseData getIsCollectedCourse(Long courseId, Integer courseType);
}
