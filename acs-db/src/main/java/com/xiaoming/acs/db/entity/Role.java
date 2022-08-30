package com.xiaoming.acs.db.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author xiaoming
 * @description 角色表
 * @date 2022-08-24
 */
@Data
@TableName(value = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 该角色的id
     */
    @TableId(type = IdType.AUTO)
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
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}