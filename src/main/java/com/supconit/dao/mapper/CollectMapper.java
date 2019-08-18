package com.supconit.dao.mapper;

import com.supconit.dao.domain.CollectDo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 陈旋凯
 * @Date: 2019-08-15- 10:19:35
 * @Description:
 * @Version: 1.0.0
 */
public interface CollectMapper {


    void saveRecord(CollectDo collectDo);

    /**
     * description
     * @param
     * @return
     * */
    CollectDo getByCourseIdAndOpenid(@Param("courseId") Long courseId, @Param("openid") String openid);
}
