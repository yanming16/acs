package com.xiaoming.acs.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoming.acs.db.entity.Role;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:32
 * @description
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据 产品线 和 英文名称删除角色信息
     *
     * @param prodId 产品线 id
     * @param enName 英文名称
     */
    void deleteByProdIdAndEnName(long prodId, String enName);

    /**
     * 根据产品线id和英文名称修改角色信息
     *
     * @param role 角色信息
     */
    void updateByProdIdAndEnName(Role role);

    /**
     * 根据 产品线 和 英文名称查询角色信息
     *
     * @param prodId 产品线 id
     * @param enName 英文名称
     *
     * @return 角色信息
     */
    Role queryByProdIdAndEnName(long prodId, String enName);

}
