package com.supconit.core.exception;


/**
 *@desc: 异常处理
 *@author
 *@date  2019/7/20
 */
public class ResponseException extends RuntimeException {

    private ExceptionCode errorCode;


    public ResponseException() {
        super();
        errorCode = ExceptionCode.SYSTEM_ERROR;
    }

    public ResponseException( ExceptionCode exceptionCode) {
        super(exceptionCode.getEnDesc());
        errorCode = exceptionCode;
        exceptionCode.setCustomMsg("");
    }

    public ResponseException(ExceptionCode exceptionCode, Throwable e) {
        super(e);
        errorCode = exceptionCode;
        exceptionCode.setCustomMsg("");
    }

    public ResponseException(ExceptionCode exceptionCode, String customMsg) {
        super(customMsg);
        errorCode = exceptionCode;
        exceptionCode.setCustomMsg(customMsg);
    }

    public ExceptionCode getErrorCode() {
        return errorCode;
    }
}
