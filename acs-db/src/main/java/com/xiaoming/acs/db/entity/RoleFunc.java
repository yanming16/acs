package com.xiaoming.acs.db.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author xiaoming
 * @description 角色授权
 * @date 2022-08-24
 */
@Data
@TableName(value = "role_func")
public class RoleFunc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 该授权的角色id
     */
    private Long roleId;

    /**
     * 该授权绑定的功能
     */
    private Long funcId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}