
package com.supconit.core.exception;

/**
 * @author
 * @desc: 错误枚举类
 * @date 2019/7/20
 */
public enum ExceptionCode {

    /**
     * 系统错误
     */
    SUCCESS("SUCCESS", 1000, "success", "成功", ""),
    FAILED("FAILED", 1001, "failed", "失败", ""),
    REQUEST_PARAM_NOT_EXIST("REQUEST_PARAM_NOT_EXIST", 1002, "request param is invalid", "请求参数缺失",""),
    PARAM_ERROR("PARAM_ERROR", 1111, "param error", "参数错误", ""),
    SYSTEM_ERROR("SYSTEM_ERROR", 9999, "system error", "系统异常", ""),

    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误编号
     */
    private int errorCode;

    /**
     * 英文错误描述
     */
    private String enDesc;

    /**
     * 中文错误描述
     */
    private String desc;

    /**
     * 自定义的错误信息
     */
    private String customMsg;

    ExceptionCode(String code, int errorCode, String enDesc, String desc, String customMsg) {
        this.code = code;
        this.errorCode = errorCode;
        this.enDesc = enDesc;
        this.desc = desc;
        this.customMsg = customMsg;
    }

    public static ExceptionCode getObjectByCode(String code) {
        if (code == null || "".equalsIgnoreCase(code)) {
            return null;
        }
        ExceptionCode[] errorCodes = values();

        for (ExceptionCode errorCode : errorCodes) {
            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }
}
