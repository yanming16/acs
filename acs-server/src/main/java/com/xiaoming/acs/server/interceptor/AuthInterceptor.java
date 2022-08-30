package com.xiaoming.acs.server.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoming.acs.common.exception.AuthException;
import com.xiaoming.acs.db.entity.Product;
import com.xiaoming.acs.db.service.ProductService;
import com.xiaoming.acs.server.threadlocal.CurrentAccessInfo;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 10:33
 * @description 认证拦截器，简单的 accessToken 认证方式
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private ProductService productService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String accessToken = request.getHeader("accessToken");
        if (StrUtil.isEmpty(accessToken)) {
            log.error("request auth error! has no accessToken!");
            throw new AuthException();
        }

        Product product = productService.queryByAccessToken(accessToken);
        if (Objects.isNull(product)) {
            log.error("request auth error! accessToken={}", accessToken);
            throw new AuthException();
        }

        CurrentAccessInfo.setProduct(product);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        CurrentAccessInfo.clearProduct();
    }
}
