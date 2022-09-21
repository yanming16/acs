package com.xiaoming.acs.common.page;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageParam<T> implements Serializable {

    /**
     * 页码，从1开始
     */
    private int pageNo = 1;

    /**
     * 每页记录数,当pageSize=0时，表示查询全部数据
     */
    private int pageSize = 10;

    /**
     * 排序语句，属性不为空时可以直接翻译成排序语句
     * 例如orderBy=name asc, birthday desc 可以翻译成SQL order by name asc, birthday desc
     */
    private String sortBy;

    /**
     * 查询参数
     */
    private T queryParam;

}
