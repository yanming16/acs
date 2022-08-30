package com.xiaoming.acs.core.converter;

import java.util.Date;
import java.util.Objects;

import com.xiaoming.acs.common.vo.UserVo;
import com.xiaoming.acs.db.entity.User;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 14:04
 * @description
 */
public class UserConverter {

    public static UserVo convertFromUser2Vo(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        return UserVo.builder()
                .userId(user.getUserId())
                .prodId(user.getProdId())
                .loginId(user.getLoginId())
                .loginType(user.getLoginType())
                .loginName(user.getLoginName())
                .gender(user.getGender())
                .cellphone(user.getCellphone())
                .email(user.getEmail())
                .idCard(user.getIdCard())
                .realName(user.getRealName())
                .desc(user.getDesc())
                .userStatus(user.getUserStatus())
                .updateTime(user.getUpdateTime().getTime())
                .createTime(user.getCreateTime().getTime())
                .build();
    }

    public static User convertFromVo2User(UserVo userVo) {
        if (Objects.isNull(userVo)) {
            return null;
        }
        return User.builder()
                .userId(userVo.getUserId())
                .prodId(userVo.getProdId())
                .loginId(userVo.getLoginId())
                .loginType(userVo.getLoginType())
                .loginName(userVo.getLoginName())
                .gender(userVo.getGender())
                .cellphone(userVo.getCellphone())
                .email(userVo.getEmail())
                .idCard(userVo.getIdCard())
                .realName(userVo.getRealName())
                .desc(userVo.getDesc())
                .userStatus(userVo.getUserStatus())
                .updateTime(new Date())
                .createTime(new Date())
                .build();
    }
}
