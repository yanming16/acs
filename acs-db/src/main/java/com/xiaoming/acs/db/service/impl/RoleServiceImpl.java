package com.xiaoming.acs.db.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoming.acs.db.entity.Role;
import com.xiaoming.acs.db.mapper.RoleMapper;
import com.xiaoming.acs.db.service.RoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 19:22
 * @description
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>  implements RoleService {

    @Override
    public Role queryByProdIdAndEnName(long prodId, String enName) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getRoleId, prodId);
        queryWrapper.eq(Role::getEnName, enName);
        return getOne(queryWrapper);
    }
}
