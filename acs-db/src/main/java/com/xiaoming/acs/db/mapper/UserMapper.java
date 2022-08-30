package com.xiaoming.acs.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoming.acs.db.entity.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaoming
 * @description 用户表
 * @date 2022-08-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}