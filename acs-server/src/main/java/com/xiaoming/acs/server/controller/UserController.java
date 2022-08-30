package com.xiaoming.acs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoming.acs.common.vo.Result;
import com.xiaoming.acs.common.vo.UserVo;
import com.xiaoming.acs.core.converter.UserConverter;
import com.xiaoming.acs.db.entity.User;
import com.xiaoming.acs.db.service.UserService;
import com.xiaoming.acs.server.threadlocal.CurrentAccessInfo;

import cn.hutool.core.lang.Assert;
import io.swagger.annotations.Api;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/24 18:45
 * @description 用户信息接口
 */
@Api(tags = "用户信息接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public Result<Void> addUser(@RequestBody UserVo userVo) {
        Assert.notNull(userVo);
        Assert.notNull(userVo.getLoginId());
        Assert.notNull(userVo.getLoginType());
        User user = UserConverter.convertFromVo2User(userVo);
        user.setProdId(CurrentAccessInfo.getProdId());
        userService.save(user);
        return Result.ok();
    }

    @DeleteMapping("/{loginType}/{loginId}")
    public Result<Void> deleteUser(@PathVariable("loginType") Integer loginType,
                                   @PathVariable("loginId") Long loginId) {
        userService.deleteByProdIdAndLoginIdAndLoginType(CurrentAccessInfo.getProdId(), loginId, loginType);
        return Result.ok();
    }

    @PutMapping()
    public Result<Void> updateUser(@RequestBody UserVo userVo) {
        Assert.notNull(userVo);
        Assert.notNull(userVo.getLoginId());
        Assert.notNull(userVo.getLoginType());
        User user = UserConverter.convertFromVo2User(userVo);
        user.setProdId(CurrentAccessInfo.getProdId());
        user.setCreateTime(null);
        userService.updateByProdIdAndLoginIdAndLoginType(user);
        return Result.ok();
    }

    @GetMapping("/{loginType}/{loginId}")
    public Result<UserVo> findUser(@PathVariable("loginType") Integer loginType,
                                   @PathVariable("loginId") Long loginId) {
        Assert.notNull(loginType);
        Assert.notNull(loginId);
        User user = userService.queryByProdIdAndLoginIdAndLoginType(CurrentAccessInfo.getProdId(), loginId, loginType);
        return Result.ok(UserConverter.convertFromUser2Vo(user));
    }

}
