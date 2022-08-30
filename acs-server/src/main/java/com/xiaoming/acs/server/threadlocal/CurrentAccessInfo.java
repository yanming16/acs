package com.xiaoming.acs.server.threadlocal;

import java.util.Objects;

import com.xiaoming.acs.db.entity.Product;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 11:03
 * @description 当前访问信息
 */
@Slf4j
public class CurrentAccessInfo {

    private static final ThreadLocal<Product> PRODUCT_THREAD_LOCAL = new ThreadLocal<>();

    public static void setProduct(Product product) {
        PRODUCT_THREAD_LOCAL.set(product);
    }

    public static Product getProduct() {
        return PRODUCT_THREAD_LOCAL.get();
    }

    public static long getProdId() {
        Product product = PRODUCT_THREAD_LOCAL.get();
        if (Objects.isNull(product) || Objects.isNull(product.getProdId())) {
            log.error("current access has no product info! product={}", product);
            throw new IllegalArgumentException("current access has no product info!");
        }
        return product.getProdId();
    }

    public static void clearProduct() {
        PRODUCT_THREAD_LOCAL.remove();
    }
}
