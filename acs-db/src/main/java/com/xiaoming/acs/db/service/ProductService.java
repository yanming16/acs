package com.xiaoming.acs.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoming.acs.db.entity.Product;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:32
 * @description
 */
public interface ProductService extends IService<Product> {

    /**
     * 根据 accessToken 查询 product
     *
     * @param accessToken accessToken
     *
     * @return product
     */
    Product queryByAccessToken(String accessToken);
}
