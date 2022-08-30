package com.xiaoming.acs.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 14:00
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    /**
     * 该用户的idn
     */
    private Long userId;

    /**
     * 可访问产品线id
     */
    private Long prodId;

    /**
     * 该用户登录类型
     */
    private Integer loginType;

    /**
     * 该用户在登录系统里面的id
     */
    private Long loginId;

    /**
     * 该用户在登录系统里面的登录名
     */
    private String loginName;

    /**
     * 该用户的名称
     */
    private String realName;

    /**
     * 该用户的电子邮箱，同种登录系统不能重复
     */
    private String email;

    /**
     * 用户性别，0女，1男
     */
    private Integer gender;

    /**
     * 该用户的手机
     */
    private String cellphone;

    /**
     * 该用户的身份证号
     */
    private String idCard;

    /**
     * 是否生效
     */
    private Integer userStatus;

    /**
     * 该用户的额外描述
     */
    private String desc;

    /**
     * 时间戳
     */
    private Long updateTime;

    /**
     * 创建时间
     */
    private Long createTime;

}
