package com.xiaoming.acs.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoming.acs.db.entity.Product;
import com.xiaoming.acs.db.mapper.ProductMapper;
import com.xiaoming.acs.db.service.ProductService;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 19:23
 * @description
 */
@Slf4j
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product queryByAccessToken(String accessToken) {
        if (StrUtil.isEmpty(accessToken)) {
            return null;
        }
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getAccessToken, accessToken);
        return productMapper.selectOne(queryWrapper);
    }
}
