package com.xiaoming.acs.db.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoming.acs.db.entity.User;
import com.xiaoming.acs.db.mapper.UserMapper;
import com.xiaoming.acs.db.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:33
 * @description
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User queryByProdIdAndLoginIdAndLoginType(long prodId, long loginId, int loginType) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getProdId, prodId);
        queryWrapper.eq(User::getLoginId, loginId);
        queryWrapper.eq(User::getLoginType, loginType);
        return getOne(queryWrapper);
    }

    @Override
    public void deleteByProdIdAndLoginIdAndLoginType(long prodId, long loginId, int loginType) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getProdId, prodId);
        queryWrapper.eq(User::getLoginId, loginId);
        queryWrapper.eq(User::getLoginType, loginType);
        remove(queryWrapper);
    }

    @Override
    public void updateByProdIdAndLoginIdAndLoginType(User user) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getProdId, user.getProdId());
        updateWrapper.eq(User::getLoginType, user.getLoginType());
        updateWrapper.eq(User::getLoginId, user.getLoginId());
        update(user, updateWrapper);
    }
}
