package com.xiaoming.acs.core.converter;

import java.util.Date;
import java.util.Objects;

import com.xiaoming.acs.common.vo.FuncVo;
import com.xiaoming.acs.db.entity.Func;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/9/21 15:15
 * @description
 */
public class FuncConverter {

    public static FuncVo convertFromFunc2Vo(Func func) {
        if (Objects.isNull(func)) {
            return null;
        }

        return FuncVo.builder()
                .funcId(func.getFuncId())
                .enName(func.getEnName())
                .cnName(func.getCnName())
                .parentFuncId(func.getParentFuncId())
                .desc(func.getDesc())
                .parentPath(func.getParentPath())
                .resContent(func.getResContent())
                .createTime(func.getCreateTime().getTime())
                .updateTime(func.getUpdateTime().getTime())
                .build();
    }

    public static Func convertFromVo2Func(FuncVo funcVo) {
        if (Objects.isNull(funcVo)) {
            return null;
        }

        return Func.builder()
                .funcId(funcVo.getFuncId())
                .enName(funcVo.getEnName())
                .cnName(funcVo.getCnName())
                .parentFuncId(funcVo.getParentFuncId())
                .desc(funcVo.getDesc())
                .parentPath(funcVo.getParentPath())
                .resContent(funcVo.getResContent())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }

}
