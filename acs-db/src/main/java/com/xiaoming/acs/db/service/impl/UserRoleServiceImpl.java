package com.xiaoming.acs.db.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoming.acs.db.entity.UserRole;
import com.xiaoming.acs.db.mapper.UserRoleMapper;
import com.xiaoming.acs.db.service.UserRoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 19:22
 * @description
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>  implements UserRoleService {
}
