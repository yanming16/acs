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
import com.xiaoming.acs.common.vo.RoleVo;
import com.xiaoming.acs.core.converter.RoleConverter;
import com.xiaoming.acs.db.entity.Role;
import com.xiaoming.acs.db.service.RoleService;
import com.xiaoming.acs.server.threadlocal.CurrentAccessInfo;

import cn.hutool.core.lang.Assert;
import io.swagger.annotations.Api;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/30 10:22
 * @description 角色信息接口
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Result<Void> addRole(@RequestBody RoleVo roleVo) {
        Assert.notEmpty(roleVo.getEnName());
        Role role = RoleConverter.convertFromVo2Role(roleVo);
        role.setProdId(CurrentAccessInfo.getProdId());
        roleService.save(role);
        return Result.ok();
    }

    @DeleteMapping("/{enName}")
    public Result<Void> deleteRole(@PathVariable("enName") String enName) {
        roleService.deleteByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName);
        return Result.ok();
    }

    @PutMapping
    public Result<Void> updateRole(@RequestBody RoleVo roleVo) {
        Assert.notEmpty(roleVo.getEnName());
        Role role = RoleConverter.convertFromVo2Role(roleVo);
        role.setProdId(CurrentAccessInfo.getProdId());
        role.setCreateTime(null);
        roleService.updateByProdIdAndEnName(role);
        return Result.ok();
    }

    @GetMapping("/{enName}")
    public Result<RoleVo> findRole(@PathVariable("enName") String enName) {
        return Result.ok(RoleConverter
                .convertFromRole2Vo(roleService.queryByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName)));
    }
}
