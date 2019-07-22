package com.supconit.core.api;

import com.supconit.core.enums.ResponseCodeEnum;
import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月22日 15:41:29
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class ResponseData {

    private String msg;
    private Object result;
    private String code;

    public ResponseData(String msg, Object result, String code) {
        this.msg = msg;
        this.result = result;
        this.code = code;
    }

    public ResponseData( Object result) {
        this.msg = ResponseCodeEnum.SUCCESS.getDesc();
        this.result = result;
        this.code = ResponseCodeEnum.SUCCESS.getCode();
    }

    public ResponseData() {
        this.msg = msg;
        this.result = result;
        this.code = code;
    }
}
