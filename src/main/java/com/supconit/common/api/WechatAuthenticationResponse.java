package com.supconit.common.api;

import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 11:06:54
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class WechatAuthenticationResponse {

    private String code;
    private String msg;


    public WechatAuthenticationResponse(String code) {
        this.code = code;
    }
}
