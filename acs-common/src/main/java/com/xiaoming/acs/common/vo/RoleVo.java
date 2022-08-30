package com.xiaoming.acs.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/30 18:53
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo {

    /**
     * 该角色的id
     */
    private Long roleId;

    /**
     * 该角色的英文名称
     */
    private String enName;

    /**
     * 该角色的中文名称
     */
    private String cnName;

    /**
     * 该角色所属的产品线id
     */
    private Long prodId;

    /**
     * 该角色的描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}
