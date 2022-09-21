package com.xiaoming.acs.db.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoming.acs.db.entity.Func;
import com.xiaoming.acs.db.mapper.FuncMapper;
import com.xiaoming.acs.db.service.FuncService;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 19:24
 * @description
 */
@Slf4j
@Service
public class FuncServiceImpl extends ServiceImpl<FuncMapper, Func> implements FuncService {

    @Override
    public Func queryByProdIdAndEnName(long prodId, String enName) {
        Assert.notBlank(enName);
        LambdaQueryWrapper<Func> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Func::getProdId, prodId);
        queryWrapper.eq(Func::getEnName, enName);
        return getOne(queryWrapper);
    }

    @Override
    public List<Func> queryByProdIdAndParentId(long prodId, long parentId) {
        LambdaQueryWrapper<Func> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Func::getProdId, prodId);
        queryWrapper.eq(Func::getParentFuncId, parentId);
        return list(queryWrapper);
    }

    @Override
    public void deleteByProdIdAndEnName(long prodId, String enName) {
        Assert.notBlank(enName);
        LambdaQueryWrapper<Func> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Func::getProdId, prodId);
        queryWrapper.eq(Func::getEnName, enName);
        remove(queryWrapper);
    }

    @Override
    public void updateByProdIdAndEnName(Func func) {
        Assert.notNull(func);
        Assert.notNull(func.getProdId());
        Assert.notBlank(func.getEnName());
        LambdaUpdateWrapper<Func> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Func::getProdId, func.getProdId());
        updateWrapper.eq(Func::getEnName, func.getEnName());
        update(func, updateWrapper);
    }
}
