package com.supconit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.supconit.dao.domain.UserDo;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 13:38:17
 * @Description:
 * @Version: 1.0.0
 */
public interface UserService{
    UserDo getUserById(Long userId);

    int updataUser(UserDo userDo);
}
