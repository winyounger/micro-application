package com.supconit.core.enums;


/**
 * @Author: chenxuankai
 * @Date: 2019年07月22日 15:45:18
 * @Description:
 * @Version: 1.0.0
 */
public enum ResponseCodeEnum {

    SUCCESS("SUCCESS","获取成功"),
    FAILD("FAILD","获取失败");

    private String code;
    private String desc;

    ResponseCodeEnum() {
    }

    ResponseCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
