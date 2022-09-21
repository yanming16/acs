package com.xiaoming.acs.db.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoming.acs.db.entity.Func;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:32
 * @description
 */
public interface FuncService extends IService<Func> {

    /**
     * 根据prodId和enName查询权限详情
     *
     * @param prodId prodId
     * @param enName func 英文名称
     *
     * @return 权限详情
     */
    Func queryByProdIdAndEnName(long prodId, String enName);

    /**
     * 根据prodId和parentId查询权限详情列表
     *
     * @param prodId   prodId
     * @param parentId 父id
     *
     * @return 权限详情列表
     */
    List<Func> queryByProdIdAndParentId(long prodId, long parentId);

    /**
     * 根据prodId和enName删除权限
     *
     * @param prodId prodId
     * @param enName func 英文名称
     */
    void deleteByProdIdAndEnName(long prodId, String enName);

    /**
     * 根据prodId和enName更新权限详情
     *
     * @param func 权限
     */
    void updateByProdIdAndEnName(Func func);
}
