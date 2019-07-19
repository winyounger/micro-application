package com.supconit.service;

import com.supconit.common.api.WechatAuthenticationResponse;
import com.supconit.domain.dto.UserDto;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 11:00:52
 * @Description:
 * @Version: 1.0.0
 */
public interface WechatService {


    WechatAuthenticationResponse wechatLogin(String code) throws Exception;

    void updateConsumerInfo(UserDto userDto);
}
