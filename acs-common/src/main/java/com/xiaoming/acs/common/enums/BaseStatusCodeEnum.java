package com.xiaoming.acs.common.enums;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 14:19
 * @description
 */
public enum BaseStatusCodeEnum {

    NO(0),
    IS(1);

    private int code;

    BaseStatusCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
