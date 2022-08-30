package com.xiaoming.acs.common.vo;

import java.util.UUID;

import com.xiaoming.acs.common.enums.BaseStatusCodeEnum;
import com.xiaoming.acs.common.enums.ErrorCodeEnum;

import lombok.Data;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:46
 * @description
 */
@Data
public class Result<T> {

    private int errno;

    private String msg;

    private String logId;

    private T data;

    public static <T> Result<T> error() {
        return error(500, "fail");
    }

    public static <T> Result<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum) {
        return error(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
    }

    public static <T> Result<T> error(Integer status, String msg) {
        Result<T> r = new Result<>();
        r.setErrno(status);
        r.setMsg(msg);
        r.setLogId(UUID.randomUUID().toString().replace("-", ""));
        return r;
    }

    public static <T> Result<T> error(Integer status, String msg, T data) {
        Result<T> r = new Result<>();
        r.setErrno(status);
        r.setMsg(msg);
        r.setData(data);
        r.setLogId(UUID.randomUUID().toString().replace("-", ""));
        return r;
    }

    public static <T> Result<T> ok() {
        Result<T> r = new Result<>();
        r.setErrno(0);
        r.setMsg("success");
        r.setLogId(UUID.randomUUID().toString().replace("-", ""));
        return r;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.setErrno(0);
        r.setMsg("success");
        r.setLogId(UUID.randomUUID().toString().replace("-", ""));
        r.setData(data);
        return r;
    }
}
