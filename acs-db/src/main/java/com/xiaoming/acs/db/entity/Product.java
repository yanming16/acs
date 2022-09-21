package com.xiaoming.acs.db.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoming
 * @description 产品线
 * @date 2022-08-24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 该产品线id
     */
    @TableId(type = IdType.AUTO)
    private Long prodId;

    /**
     * access token
     */
    private String accessToken;

    /**
     * 该产品线的英文名称n
     */
    private String enName;

    /**
     * 该产品线的中文名称
     */
    private String cnName;

    /**
     * 该产品线的中文描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}