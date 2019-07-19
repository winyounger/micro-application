package com.supconit.common.api;

import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 11:07:57
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class WechatAuthCodeResponse {

    private String errorCode;
    private String errorMsg;
    private Integer expireTime;
    private String openid;
    private String sessionKey;

}
