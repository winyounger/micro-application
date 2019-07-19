package com.supconit.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:22:20
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Component
public class WechatAuthConfig {

    @Value("${auth.wechat.sessionHost}")
    private String sessionHost;

    @Value("${auth.wechat.appId}")
    private String appId;

    @Value("${auth.wechat.secret}")
    private String secret;

    @Value("${auth.wechat.grantType}")
    private String grantType;

}
