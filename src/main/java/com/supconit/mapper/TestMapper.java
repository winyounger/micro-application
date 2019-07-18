package com.supconit.mapper;

import com.supconit.domain.TestDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 15:15:53
 * @Description:
 * @Version: 1.0.0
 */
@Mapper
public interface TestMapper {

    Integer insert(TestDo testDo);

}
