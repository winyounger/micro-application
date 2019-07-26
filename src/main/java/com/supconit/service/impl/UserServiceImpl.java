package com.supconit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supconit.dao.domain.UserDo;
import com.supconit.dao.mapper.UserMapper;
import com.supconit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 13:38:29
 * @Description:
 * @Version: 1.0.0
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDo getUserById(Long userId) {
        return userMapper.selectById(userId);
    }
}
