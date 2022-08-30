package com.xiaoming.acs.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoming.acs.db.entity.User;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:32
 * @description
 */
public interface UserService extends IService<User> {

    /**
     * 根据 产品线 登录id 和 登录方式 查询用户信息
     *
     * @param prodId    产品线id
     * @param loginId   登录id
     * @param loginType 登录方式
     *
     * @return 用户信息
     */
    User queryByProdIdAndLoginIdAndLoginType(long prodId, long loginId, int loginType);

    /**
     * 根据 产品线 登录id 和 登录方式 删除用户信息
     *
     * @param prodId    产品线id
     * @param loginId   登录id
     * @param loginType 登录方式
     */
    void deleteByProdIdAndLoginIdAndLoginType(long prodId, long loginId, int loginType);

    /**
     * 根据 产品线 登录id 和 登录方式 更新用户信息
     */
    void updateByProdIdAndLoginIdAndLoginType(User user);

}
