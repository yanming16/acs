package com.xiaoming.acs.db.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author xiaoming
 * @description 功能
 * @date 2022-08-24
 */
@Data
@TableName(value = "func")
public class Func implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 该功能的id
     */
    @TableId(type = IdType.AUTO)
    private Long funcId;

    /**
     * 该功能的英文名称
     */
    private String enName;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 父功能的id
     */
    private Long parentFuncId;

    /**
     * 该功能所属的产品线n
     */
    private Long prodId;

    /**
     * 该功能的资源内容
     */
    private String resContent;

    /**
     * 该功能的描述
     */
    private String desc;

    /**
     * 该节点的父路径
     */
    private String parentPath;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}