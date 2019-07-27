package com.supconit.core.response;

import com.supconit.core.exception.ExceptionCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 *@desc: 统一封装 处理响应类
 *@author
 *@date  2019/7/22
 */
@Data
public class HandleResponse{

    private String id;
    private int code;
    private String msg;
    private Object data;

    private HandleResponse(ExceptionCode iShangJieExceptionCode, Object data){
        this.code = iShangJieExceptionCode.getErrorCode();
        if(StringUtils.isNotBlank(iShangJieExceptionCode.getCustomMsg())){
            this.msg = iShangJieExceptionCode.getCustomMsg();
        }else {
            this.msg = iShangJieExceptionCode.getDesc();
        }
        this.data = data;
    }

    private HandleResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 封装成功的响应
     * @return
     */
    public static HandleResponse successResponse(Object data){
        HandleResponse handleResponse = new HandleResponse(ExceptionCode.SUCCESS, data);
        return handleResponse;
    }

    /**
     * 封装成功的响应
     * @return
     */
    public static HandleResponse successResponse(Object data, String id){
        HandleResponse handleResponse = new HandleResponse(ExceptionCode.SUCCESS, data);
        if (StringUtils.isNotBlank(id)) {
            handleResponse.setId(id);
        }
        return handleResponse;
    }

    /**
     * 封装失败的响应
     * @return
     */
    public static HandleResponse failedResponse(ExceptionCode iShangJieExceptionCode,Object data){
        return new HandleResponse(iShangJieExceptionCode,data);
    }

    /**
     * 全局统一异常处理封装失败的响应
     *
     * @return
     */
    public static HandleResponse failedResponseForGlobal(int code, String msg, Object data) {
        return new HandleResponse(code, msg, data);
    }


}
