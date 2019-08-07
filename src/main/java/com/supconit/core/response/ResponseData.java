package com.supconit.core.response;

import com.alibaba.druid.util.StringUtils;
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
        if (result instanceof String) {
            String resultStr = (String)result;
            if (StringUtils.equals(resultStr, ResponseCodeEnum.SUCCESS.getCode())) {
                this.msg = ResponseCodeEnum.SUCCESS.getDesc();
                this.code = ResponseCodeEnum.SUCCESS.getCode();
            } else if (StringUtils.equals(resultStr, ResponseCodeEnum.FAILD.getCode())){
                this.msg = ResponseCodeEnum.FAILD.getDesc();
                this.code = ResponseCodeEnum.FAILD.getCode();
            }else {
                this.msg = ResponseCodeEnum.SUCCESS.getDesc();
                this.result = resultStr;
                this.code = ResponseCodeEnum.SUCCESS.getCode();
            }
        }else {
            this.msg = ResponseCodeEnum.SUCCESS.getDesc();
            this.result = result;
            this.code = ResponseCodeEnum.SUCCESS.getCode();
        }
    }

    public ResponseData(String code) {

    }

    public ResponseData() {
        this.msg = msg;
        this.result = result;
        this.code = code;
    }
}
