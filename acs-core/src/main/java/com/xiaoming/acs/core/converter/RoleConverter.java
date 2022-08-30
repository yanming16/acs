package com.xiaoming.acs.core.converter;

import java.util.Date;
import java.util.Objects;

import com.xiaoming.acs.common.vo.RoleVo;
import com.xiaoming.acs.db.entity.Role;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/30 18:55
 * @description
 */
public class RoleConverter {

    public static RoleVo convertFromRole2Vo(Role role) {
        if (Objects.isNull(role)) {
            return null;
        }

        return RoleVo.builder()
                .roleId(role.getRoleId())
                .prodId(role.getProdId())
                .cnName(role.getCnName())
                .enName(role.getEnName())
                .desc(role.getDesc())
                .createTime(role.getCreateTime().getTime())
                .updateTime(role.getUpdateTime().getTime())
                .build();
    }

    public static Role convertFromVo2Role(RoleVo roleVo) {
        if (Objects.isNull(roleVo)) {
            return null;
        }

        return Role.builder()
                .roleId(roleVo.getRoleId())
                .prodId(roleVo.getProdId())
                .cnName(roleVo.getCnName())
                .enName(roleVo.getEnName())
                .desc(roleVo.getDesc())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }
}
