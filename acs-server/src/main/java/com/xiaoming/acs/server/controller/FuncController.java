package com.xiaoming.acs.server.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoming.acs.common.vo.FuncVo;
import com.xiaoming.acs.common.vo.Result;
import com.xiaoming.acs.core.converter.FuncConverter;
import com.xiaoming.acs.db.entity.Func;
import com.xiaoming.acs.db.service.FuncService;
import com.xiaoming.acs.server.threadlocal.CurrentAccessInfo;

import cn.hutool.core.lang.Assert;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/30 19:31
 * @description 功能权限接口
 */
@Api(tags = "功能权限接口")
@Slf4j
@RestController
@RequestMapping("/func")
public class FuncController {

    @Autowired
    private FuncService funcService;

    @PostMapping("/{enName}")
    public Result<Void> addFunc(@PathVariable("enName") String enName, @RequestBody FuncVo funcVo) {
        Func parentFunc = funcService.queryByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName);
        Assert.notNull(parentFunc, "func " + enName + " is not exist!");
        Func func = FuncConverter.convertFromVo2Func(funcVo);
        func.setParentFuncId(parentFunc.getFuncId());
        func.setProdId(CurrentAccessInfo.getProdId());
        funcService.save(func);
        return Result.ok();
    }

    @DeleteMapping("/{enName}")
    public Result<Void> deleteFunc(@PathVariable("enName") String enName) {
        Func func = funcService.queryByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName);
        Assert.notNull(func, "func " + enName + " is not exist!");
        List<Func> funcList = funcService.queryByProdIdAndParentId(CurrentAccessInfo.getProdId(), func.getFuncId());
        Assert.notEmpty(funcList, "func " + enName + " has child func!");
        funcService.deleteByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName);
        return Result.ok();
    }

    @PutMapping
    public Result<Void> updateFunc(@RequestBody FuncVo funcVo) {
        Assert.notEmpty(funcVo.getEnName());
        Func func = funcService.queryByProdIdAndEnName(CurrentAccessInfo.getProdId(), funcVo.getEnName());
        Assert.notNull(func, "func " + funcVo.getEnName() + " is not exist!");
        func.setCnName(funcVo.getCnName());
        func.setDesc(funcVo.getDesc());
        func.setResContent(funcVo.getResContent());
        func.setUpdateTime(new Date());
        funcService.updateByProdIdAndEnName(func);
        return Result.ok();
    }

    @GetMapping("/{enName}")
    public Result<FuncVo> findFunc(@PathVariable("enName") String enName) {
        Func func = funcService.queryByProdIdAndEnName(CurrentAccessInfo.getProdId(), enName);
        Assert.notNull(func, "func " + enName + " is not exist!");
        FuncVo funcVo = FuncConverter.convertFromFunc2Vo(func);
        return Result.ok(funcVo);
    }

}
