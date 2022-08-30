package com.xiaoming.acs.common.enums;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 10:54
 * @description 错误码
 */
public enum ErrorCodeEnum {

    OK(0, "success"),

    // 用户端校验异常
    REQUEST_FAIL(400, "request error"),
    ACCESS_PARAMS_ERROR(40000, "用户访问参数错误"),
    ACCESS_PARAMS_INCOMPLETE(40001, "必填参数为空"),
    ACCESS_PARAMS_JSON_INVALID(40002, "参数非法-JSON数据转换异常"),
    ACCESS_PARAMS_RANGE_EXCEED(40003, "参数值超出允许范围"),
    ACCESS_PARAMS_BATCH_EXCEED(40004, "参数数量超出允许范围"),
    ACCESS_CONTENT_TYPE_ERROR(40005, "Content-Type不支持"),
    ACCESS_FILE_ERROR(40006, "用户上传文件异常"),
    ACCESS_FILE_TYPE_INVALID(40007, "上传文件类型无效"),
    ACCESS_FILE_SIZE_EXCEED(40008, "上传文件大小超出允许范围"),

    ACCESS_AUTH_ERROR(401, "用户访问权限异常"),
    ACCESS_SIGN_INVALID(40100, "用户访问签名无效"),

    ACCESS_REQUEST_METHOD_ERROR(405, "HTTP请求方法不支持"),

    SYSTEM_ERROR(500, "server error"),
    // 内部服务异常
    INTERNAL_SQL_ERROR(50000, "对不起，服务器出错了，请稍候再试"),
    INTERNAL_IO_ERROR(50001, "对不起，服务器出错了，请稍候再试"),

    // 三方依赖服务异常
    EXTERNAL_SERVICE_ERROR(502, "对不起，服务器出错了，请稍候再试"),
    EXTERNAL_RPC_ERROR(50200, "天路接口异常"),
    EXTERNAL_RAL_ERROR(50201, "对不起，服务器出错了，请稍候再试"),
    EXTERNAL_BP_ERROR(50202, "对不起，服务器出错了，请稍候再试"),
    EXTERNAL_CONNECT_ERROR(50203, "对不起，服务器出错了，请稍后再试"),
    EXTERNAL_ES_ERROR(50204, "对不起，服务器出错了，请稍候再试"),

    EXTERNAL_TIMEOUT_ERROR(503, "对不起，服务器出错了，请稍后再试"),
    EXTERNAL_SOCKET_TIMEOUT_ERROR(50300, "对不起，服务器出错了，请稍后再试");

    private Integer code;
    private String msg;

    ErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorCodeEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
