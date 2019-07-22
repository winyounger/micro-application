package com.supconit.core.api;

import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 11:07:57
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class WechatAuthCodeResponse {

    private String errorcode;
    private String errmsg;
    private Integer expireTime;
    private String openid;
    private String session_key;

}
