package com.xiaoming.acs.common.exception;

import com.xiaoming.acs.common.enums.ErrorCodeEnum;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 10:48
 * @description 认证异常
 */
public class AuthException extends BizException {

    private static final long serialVersionUID = -2494414132355701008L;

    public AuthException() {
        super(ErrorCodeEnum.ACCESS_AUTH_ERROR);
    }

}
