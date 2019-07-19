package com.supconit.service.impl;

import com.supconit.dao.TestDo;
import com.supconit.dao.mapper.TestMapper;
import com.supconit.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 15:14:48
 * @Description:
 * @Version: 1.0.0
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public Integer insert(TestDo testDo) {
        return testMapper.insert(testDo);
    }
}
