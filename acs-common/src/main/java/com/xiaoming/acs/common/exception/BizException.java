package com.xiaoming.acs.common.exception;

import com.xiaoming.acs.common.enums.ErrorCodeEnum;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 10:50
 * @description 业务异常
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -2494414139085701008L;

    private static final int UNKNOWN = -1;

    private int errorCode;

    private String errorMessage;

    public BizException() {
        super();
        this.errorCode = UNKNOWN;
        this.errorMessage = "";
    }

    public BizException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorCodeEnum.getMsg();
    }

    public BizException(String message) {
        super(message);
        this.errorCode = UNKNOWN;
        this.errorMessage = message;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = UNKNOWN;
        this.errorMessage = message;
    }

    public BizException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BizException(int errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BizException(int errorCode, Throwable cause) {
        super(cause.getMessage(), cause);
        this.errorCode = errorCode;
        this.errorMessage = cause.getMessage();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
