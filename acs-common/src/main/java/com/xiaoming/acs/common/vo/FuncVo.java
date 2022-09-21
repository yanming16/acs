package com.xiaoming.acs.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/9/21 15:09
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncVo {

    /**
     * 该功能的id
     */
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
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}
